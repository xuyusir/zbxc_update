package com.jy.service.content.file.directory;

import com.aliyuncs.vod.model.v20170321.AddCategoryResponse;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.content.file.directory.DocumentdirectoryMapper;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.file.directory.Documentdirectory;
import com.jy.entiy.content.file.directory.DocumentdirectoryExample;
import com.jy.entiy.content.file.directory.DocumentdirectoryExample.Criteria;
import com.jy.entiy.content.file.directory.VueTreeNode;
import com.jy.entiy.content.file.file.FileinfoExample;
import com.jy.service.base.BaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName:  DocumentDirectoryServiceImpl
 * @Description:文件目录接口实现类
 * @author: cheng fei
 * @date:   2018-09-11 09:10
 */

@Service
public class DocumentDirectoryServiceImpl extends BaseService implements DocumentDirectoryService{

	/**
	 * 数据库操作日志编码
	 */
	private static final String DB_LOG_TYPE = "DB_LOG_DOCUMENT_DIRECTORY";

	/**
	 * 课程视频文件夹ID
	 */
	@Value("${COURSE_VIDEO_DIRECTORY_ID}")
	private long courseVideoDirectoryID;

	@Resource
	private DocumentdirectoryMapper documentdirectoryMapper;

	@Resource
	private FileinfoMapper fileinfoMapper;

	@Override
	public Result getFileDirectoryTree(AccountInfo accountInfo, Long directory_id) {

		//检测账号类型
		if (!checkManageAccount(accountInfo.getAccount())){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}

		if (directory_id == null) {
			directory_id = 0L;
		}
		DocumentdirectoryExample example = new DocumentdirectoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(directory_id);
		List<Documentdirectory> list = documentdirectoryMapper.selectByExample(example);
		List<VueTreeNode> data = new ArrayList<>();
		for (Documentdirectory directory : list) {
			VueTreeNode node = new VueTreeNode();
			node.setCode(directory.getDocumentdirectoryid());
			node.setName(directory.getDirectoryname());
			node.setExpand(directory.getIsparent() == 1);
			data.add(node);
		}
		return Result.succee(data);
	}

	@Override
	public Result insertDirectory(AccountInfo accountInfo, String AUTHORITY_CODE, Documentdirectory directory) throws Exception {

		//检测权限
		Result checkAuthority = checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		//判断是否在课程视频下添加子目录,所有目录结构自由课程视频允许添加子文件夹
		Boolean checkInCourseVideo = false;
		if (directory.getParentid() == courseVideoDirectoryID) {
			checkInCourseVideo = true;
		}else {
			checkInCourseVideo = checkInCourseVideo(directory.getParentid());
		}
		if (!checkInCourseVideo) {
			return Result.build(ResultEnum.INSERT_NOT_IN_COURSE_VIDEO_DIRECTORY);
		}

		//判断当前分类为几级分类,阿里云最多支持3层分类
		if(checkDirectoryTier(directory.getParentid())){
            return Result.build(ResultEnum.DIRECTORY_TIER_GREATER_THREE);
		}

		//在阿里云视频点播服务上添加视频分类
        AddCategoryResponse addCategoryResponse = aliyunOSSClientUtil.addCategory(directory.getParentid(), directory.getDirectoryname());
        Long cateId = addCategoryResponse.getCategory().getCateId();

        System.err.println(cateId);

        //补全参数
		directory.setDocumentdirectoryid(cateId);
		directory.setIsparent(0);
		directory.setCreateby(accountInfo.getAccount().getName());
		directory.setCreatepersonid(accountInfo.getAccount().getAccountid());
		directory.setCreatetime(new Date());
		int i = documentdirectoryMapper.insertSelective(directory);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		//判断当前添加节点的父节点是否是父节点,不是父节点修改为父节点
		Documentdirectory parent_directory = documentdirectoryMapper.selectByPrimaryKey(directory.getParentid());
		if (parent_directory.getIsparent() == 0) {
			Documentdirectory documentdirectory = new Documentdirectory();
			documentdirectory.setDocumentdirectoryid(parent_directory.getDocumentdirectoryid());
			documentdirectory.setIsparent(1);
			i = documentdirectoryMapper.updateByPrimaryKeySelective(documentdirectory);
			if (i < 1) {
				throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
			}
		}

		//数据库操作日志
		String log = "[ " + parent_directory.getDirectoryname() + " ]文件夹下添加了文件夹[ " + directory.getDirectoryname() + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee(directory.getDocumentdirectoryid());
	}

	/**
	 * 作者: cheng fei
	 * 创建日期: 2019/1/20 14:03
	 * 描述 : 检测文件夹目录所在层级是否小于等于3
	 * @param parentID
	 * @return
	 */
	private boolean checkDirectoryTier(Long parentID) {

		int tier = 1;
		while (true){
		    if (parentID.longValue() == courseVideoDirectoryID){
		        return tier >= 3;
            }
            parentID = documentdirectoryMapper.getParentIDByDocumentDirectoryID(parentID);
            tier ++;
        }
	}


	@Override
	public Result updateDirectory(AccountInfo accountInfo, String AUTHORITY_CODE, Documentdirectory directory) throws MyException {

		//检测权限
		Result checkAuthority = checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		//补全参数
		directory.setUpdateby(accountInfo.getAccount().getName());
		directory.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		directory.setUpdatetime(new Date());

		//查询历史记录
		Documentdirectory old_directory = documentdirectoryMapper.selectByPrimaryKey(directory.getDocumentdirectoryid());

		int i = documentdirectoryMapper.updateByPrimaryKeySelective(directory);
		if (i < 1 ) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		//数据库操作日志
		String log = "[ " + old_directory.getDirectoryname() + " ]文件夹修改为[ " + directory.getDirectoryname() + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result deleteFileDirectory(AccountInfo accountInfo, String AUTHORITY_CODE, Long directory_id) throws Exception {

		//检测权限
		Result checkAuthority = checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		Documentdirectory directory = documentdirectoryMapper.selectByPrimaryKey(directory_id);
		//查询当前文件夹是否是父文件夹,是父文件夹不允许删除
		if (directory.getIsparent() == 1) {
			return Result.build(ResultEnum.IS_PARENT_DIRECTORY);
		}

		//查询当前文件夹中是否有文件,有问价不允许删除
		FileinfoExample example = new FileinfoExample();
		com.jy.entiy.content.file.file.FileinfoExample.Criteria criteria = example.createCriteria();
		criteria.andDocumentdirectoryidEqualTo(directory_id);
		int count = fileinfoMapper.countByExample(example);
		if (count > 0) {
			return Result.build(ResultEnum.DIRECTORY_EXIST_FILE);
		}

		//验证当前文件夹是否属于视频课程文件夹下属文件夹
		Boolean inCourseVideo = checkInCourseVideo(directory_id);
		if (!inCourseVideo) {
			return Result.build(ResultEnum.DELETE_NOT_IN_COURSE_VIDEO_DIRECTORY);
		}
		int i = documentdirectoryMapper.deleteByPrimaryKey(directory_id);
		if (i < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}

		//删除阿里云上分类
        aliyunOSSClientUtil.deleteCategory(directory_id);

        //删除文件夹父文件夹加重是否存在子文件,不存在,修改父文件夹为子文件夹
        DocumentdirectoryExample documentdirectoryExample = new DocumentdirectoryExample();
        Criteria documentdirectoryExampleCriteria = documentdirectoryExample.createCriteria();
        documentdirectoryExampleCriteria.andParentidEqualTo(directory.getParentid());
        count = documentdirectoryMapper.countByExample(documentdirectoryExample);
        if(count == 0){
            //修改父文件夹为子文件夹
            Documentdirectory documentdirectory = new Documentdirectory();
            documentdirectory.setDocumentdirectoryid(directory.getParentid());
            documentdirectory.setIsparent(0);
            i = documentdirectoryMapper.updateByPrimaryKeySelective(documentdirectory);
            if (i < 1){
                throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
            }
        }


        //数据库操作日志
		String log = "删除了文件夹[ " + directory.getDirectoryname() + " ]";
		dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	/**
	 * 片段当前文件夹是否属于视频课程下文件夹
	 * @param directory_id 文件夹ID
	 * @return
	 */
	private Boolean checkInCourseVideo(Long directory_id) {

	    if (directory_id == courseVideoDirectoryID){
	        return false;
        }
        List<Long> directoryIDs = getDirectoryIDs();
        return directoryIDs.contains(directory_id);
    }


    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/8 15:17
     * 描述 : 获取视频课程文件夹下所有子文件夹
     * @return
     */
    List<Long> getDirectoryIDs() {
        List<Long> directory_ids = new ArrayList<>();
        directory_ids = getDirectoryIDs(directory_ids, courseVideoDirectoryID );
        return directory_ids;
    }


    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/8 15:19
     * 描述 : 递归获取所有子文件夹列表
     * @param directory_ids
     * @param directory_id
     * @return
     */
    private List<Long> getDirectoryIDs(List<Long> directory_ids, Long directory_id) {
        List<Long> list2 = documentdirectoryMapper.getDocumentDirectoryIDByParentID(directory_id);
        directory_ids.addAll(list2);
        for (Long id : list2) {
            getDirectoryIDs(directory_ids, id);
        }
        return directory_ids;
    }


}
