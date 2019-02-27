package com.jy.service.function.marketingFunction.votingManagement;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.dao.function.marketingFunction.votingManagement.VoteconfigMapper;
import com.jy.dao.function.marketingFunction.votingManagement.VotedetailsMapper;
import com.jy.dao.function.marketingFunction.votingManagement.VoteitemMapper;
import com.jy.dao.function.marketingFunction.votingManagement.VoteoptionMapper;
import com.jy.dao.system.select.VotestatusMapper;
import com.jy.dao.system.select.VotetypeMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.entiy.function.marketingFunction.votingManagement.*;
import com.jy.entiy.function.marketingFunction.votingManagement.VoteitemExample.Criteria;
import com.jy.service.base.BaseService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: VotingManageServiceImpl
 * @Description:投票管理实现类
 * @author: chenye
 * @date: 2018-09-10 17:55
 */
@Service
public class VotingManageServiceImpl extends BaseService implements VotingManageService {

	// 数据库操作日志类型
	private static final String DB_LOG_TYPE = "DB_LOG_MARKETING_FUNCTION";

	private static final String TABLE_NAME = "VoteConfig";

	private static final int STAUTS = 2;// 状态为禁止
	// 投票参与人群所有用户
	private static final int TYPE1 = 1;
	//仅限会员
	private static final int TYPE2 = 2;

	//投票地址
	private static final String webVoteUrl = "/vote";

	//pc端服务器地址
	@Value("${WEB_SERVER_URL}")
	private String WEB_SERVER_URL;
	//移动端服务器地址
	@Value("${MOBILE_SERVER_URL}")
	private String MOBILE_SERVER_URL;

	@Resource
	private VoteconfigMapper voteconfigMapper;

	@Resource
	private VoteitemMapper voteitemMapper;

	@Resource
	private VoteoptionMapper voteoptionMapper;

	@Resource
	private VotestatusMapper votestatusMapper;

	@Resource
	private VotetypeMapper votetypeMapper;

	@Resource
	private VotedetailsMapper votedetailsMapper;

	@Resource
	private FileinfoMapper fileinfoMapper;

	@Override
	public Result getItemList(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteid, Integer voteitemid,
			String search, Integer page, Integer pageSize) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		if (voteid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		search = this.checkSearch(search);
		List<Voteitem> rows = voteitemMapper.selectVoteitemList(voteid, voteitemid, search, (page - 1) * pageSize,
				pageSize);
		int count = voteitemMapper.selectCountVoteitemList(voteid, voteitemid, search);
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

	@Override
	public Result getOptionList(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteitemid,
			Integer voteoptionid, String search, Integer page, Integer pageSize) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteitemid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		search = this.checkSearch(search);
		List<Voteoption> rows = voteoptionMapper.selectVoteoptionList(voteitemid, voteoptionid, search,
				(page - 1) * pageSize, pageSize);
		int count = voteoptionMapper.selectCountVoteoptionList(voteitemid, voteoptionid, search);
		for (Voteoption voteoption : rows) {
			//统计选项票数
			Integer sum = 0;
			VotedetailsExample votedetailsExample = new VotedetailsExample();
			com.jy.entiy.function.marketingFunction.votingManagement.VotedetailsExample.Criteria createCriteria = votedetailsExample
					.createCriteria();
			createCriteria.andVoteoptionidEqualTo(voteoption.getVoteoptionid());
			List<Votedetails> VotedetailsList = votedetailsMapper.selectByExample(votedetailsExample);
			sum += VotedetailsList.size();
			voteoption.setStatistics(sum);
		}


		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

	@Override
	public Result addItem(AccountInfo accountInfo, String AUTHORITY_CODE, Voteitem voteitem) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteitem.getVoteid() == null || voteitem.getVotetypeid() == null
				|| StringUtils.isBlank(voteitem.getVoteitemname()) || voteitem.getDisplayorder() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		VoteitemExample voteitemExample = new  VoteitemExample();
		Criteria createCriteria = voteitemExample.createCriteria();
		createCriteria.andVoteidEqualTo(voteitem.getVoteid());
		List<Voteitem> oldVoteitemList = voteitemMapper.selectByExample(voteitemExample);
		for (Voteitem oldVoteitem : oldVoteitemList) {
			if (voteitem.getDisplayorder() == oldVoteitem.getDisplayorder()) {
				return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);// 序号已存在
			}
		}


		voteitem.setCreateby(accountInfo.getAccount().getName());
		voteitem.setCreatetime(new Date());
		voteitem.setCreatepersonid(accountInfo.getAccount().getAccountid());

		int i = voteitemMapper.insertSelective(voteitem);// 获得投票主键id

		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "添加了一个题目 : [ ";
		log += StringUtils.isBlank(voteitem.getVoteitemname()) ? "" : "题目名字=" + voteitem.getVoteitemname() + ",";
		log += voteitem.getVoteid() == null ? "" : "投票id=" + voteitem.getVoteid() + ",";
		log += StringUtils.isBlank(voteitem.getCreateby()) ? "" : "创建者=" + voteitem.getCreateby() + ",";
		log += voteitem.getCreatepersonid() == null ? "" : "创建者id=" + voteitem.getCreatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	@Override
	public Result updateItem(AccountInfo accountInfo, String AUTHORITY_CODE, Voteitem voteitem) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteitem.getVoteid() == null || voteitem.getVoteitemid() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		VoteitemExample voteitemExample = new  VoteitemExample();
		Criteria createCriteria = voteitemExample.createCriteria();
		createCriteria.andVoteidEqualTo(voteitem.getVoteid());
		createCriteria.andVoteitemidNotEqualTo(voteitem.getVoteitemid());
		List<Voteitem> oldVoteitemList = voteitemMapper.selectByExample(voteitemExample);
		for (Voteitem oldVoteitem : oldVoteitemList) {
			if (voteitem.getDisplayorder() == oldVoteitem.getDisplayorder()) {
				return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);// 序号已存在
			}
		}


		voteitem.setUpdateby(accountInfo.getAccount().getName());
		voteitem.setUpdatetime(new Date());
		voteitem.setUpdatepersonid(accountInfo.getAccount().getAccountid());

		int i = voteitemMapper.updateByPrimaryKeySelective(voteitem);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "修改了一个题目 : [ ";
		log += StringUtils.isBlank(voteitem.getVoteitemname()) ? "" : "题目名字=" + voteitem.getVoteitemname() + ",";
		log += voteitem.getVoteid() == null ? "" : "投票id=" + voteitem.getVoteid() + ",";
		log += StringUtils.isBlank(voteitem.getUpdateby()) ? "" : "修改者=" + voteitem.getUpdateby() + ",";
		log += voteitem.getUpdatepersonid() == null ? "" : "修改者id=" + voteitem.getUpdatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	@Override
	public Result deleteItem(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteitemid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteitemid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Voteitem selectByPrimaryKey = voteitemMapper.selectByPrimaryKey(voteitemid);
		if (selectByPrimaryKey == null) {

			return Result.build(ResultEnum.DATA_NOT_EXIST);
		}

		VoteoptionExample voteoptionExample = new VoteoptionExample();
		com.jy.entiy.function.marketingFunction.votingManagement.VoteoptionExample.Criteria createCriteria = voteoptionExample
				.createCriteria();
		createCriteria.andVoteitemidEqualTo(voteitemid);
		voteoptionMapper.deleteByExample(voteoptionExample);// 删除题目下的选项
		int i = voteitemMapper.deleteByPrimaryKey(voteitemid);
		if (i < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "删除了一个题目 :  题目id为";
		log += voteitemid;
		log += "删除者";
		log += accountInfo.getAccount().getName();

		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();
	}

	@Override
	public Result getItemInfo(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteitemid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteitemid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Voteitem voteitem = voteitemMapper.selectByPrimaryKey(voteitemid);
		return Result.succee(voteitem);
	}

	@Override
	public Result addOption(AccountInfo accountInfo, String AUTHORITY_CODE, Voteoption voteoption) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteoption.getVoteitemid() == null || StringUtils.isBlank(voteoption.getVoteoptiontitle())
				|| voteoption.getDisplayorder() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		VoteoptionExample voteoptionExample = new VoteoptionExample();
		com.jy.entiy.function.marketingFunction.votingManagement.VoteoptionExample.Criteria createCriteria = voteoptionExample.createCriteria();
		createCriteria.andVoteitemidEqualTo(voteoption.getVoteitemid());
		List<Voteoption> old_VoteoptionList = voteoptionMapper.selectByExample(voteoptionExample);
		for (Voteoption old_Voteoption : old_VoteoptionList) {
			if (voteoption.getDisplayorder() == old_Voteoption.getDisplayorder()) {
				return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);// 序号已存在
			}
		}


		voteoption.setCreateby(accountInfo.getAccount().getName());
		voteoption.setCreatetime(new Date());
		voteoption.setCreatepersonid(accountInfo.getAccount().getAccountid());

		int i = voteoptionMapper.insertSelective(voteoption);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "添加了一个选项: [ ";
		log += StringUtils.isBlank(voteoption.getVoteoptiontitle()) ? ""
				: "选项名字=" + voteoption.getVoteoptiontitle() + ",";
		log += voteoption.getVoteitemid() == null ? "" : "题目id=" + voteoption.getVoteitemid() + ",";
		log += StringUtils.isBlank(voteoption.getCreateby()) ? "" : "创建者=" + voteoption.getCreateby() + ",";
		log += voteoption.getCreatepersonid() == null ? "" : "创建者id=" + voteoption.getCreatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	@Override
	public Result updateOption(AccountInfo accountInfo, String AUTHORITY_CODE, Voteoption voteoption)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		if (voteoption.getVoteitemid() == null || voteoption.getVoteoptionid() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		VoteoptionExample voteoptionExample = new VoteoptionExample();
		com.jy.entiy.function.marketingFunction.votingManagement.VoteoptionExample.Criteria createCriteria = voteoptionExample.createCriteria();
		createCriteria.andVoteoptionidNotEqualTo(voteoption.getVoteoptionid());
		createCriteria.andVoteitemidEqualTo(voteoption.getVoteitemid());
		List<Voteoption> old_VoteoptionList = voteoptionMapper.selectByExample(voteoptionExample);
		for (Voteoption old_Voteoption : old_VoteoptionList) {
			if (voteoption.getDisplayorder() == old_Voteoption.getDisplayorder()) {
				return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);// 序号已存在
			}
		}


		voteoption.setUpdateby(accountInfo.getAccount().getName());
		voteoption.setUpdatetime(new Date());
		voteoption.setUpdatepersonid(accountInfo.getAccount().getAccountid());

		int i = voteoptionMapper.updateByPrimaryKeySelective(voteoption);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "修改了一个选项 : [ ";
		log += StringUtils.isBlank(voteoption.getVoteoptiontitle()) ? ""
				: "选项名字=" + voteoption.getVoteoptiontitle() + ",";
		log += voteoption.getVoteitemid() == null ? "" : "题目id=" + voteoption.getVoteitemid() + ",";
		log += StringUtils.isBlank(voteoption.getUpdateby()) ? "" : "修改者=" + voteoption.getUpdateby() + ",";
		log += voteoption.getUpdatepersonid() == null ? "" : "修改者id=" + voteoption.getUpdatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();
	}

	@Override
	public Result deleteOption(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteoptionid)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteoptionid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Voteoption selectByPrimaryKey = voteoptionMapper.selectByPrimaryKey(voteoptionid);

		if (selectByPrimaryKey == null) {

			return Result.build(ResultEnum.DATA_NOT_EXIST);
		}
		int i = voteoptionMapper.deleteByPrimaryKey(voteoptionid);
		if (i < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "删除了一个选项 :  选项id为";
		log += voteoptionid;
		log += "删除者=";
		log += accountInfo.getAccount().getName();

		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();
	}

	@Override
	public Result getOption(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteoptionid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteoptionid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Voteoption voteoption = voteoptionMapper.selectByPrimaryKey(voteoptionid);
		return Result.succee(voteoption);
	}

	@Override
	public Result getVoteConfigList(AccountInfo accountInfo, String AUTHORITY_CODE, Integer votestatusid, String search,
			Integer page, Integer pageSize) throws MyException {
		Integer voteparticipanttypeid = null;
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (accountInfo.getAccount().getIsmember() != null && !accountInfo.getAccount().getIsmember()
				&& accountInfo.getAccount().getRoleid() != null && accountInfo.getAccount().getRoleid() != 1) {// 非会员,非管理员
			voteparticipanttypeid = 1;// 加载所有注册用户参与的投票
		} else {
			voteparticipanttypeid = null;// 加载所有投票
		}
		// 处理参数
		search = this.checkSearch(search);
		if(votestatusid != null) {
			if(votestatusid == 0) {
				votestatusid = null;
			}

		}
		List<Voteconfig> rows = voteconfigMapper.selectVoteconfigList(votestatusid, voteparticipanttypeid, search,
				(page - 1) * pageSize, pageSize);
		int count = voteconfigMapper.selectCountVoteconfigList(votestatusid, voteparticipanttypeid, search);
		if(rows != null && rows.size() != 0) {
			for (Voteconfig voteconfig : rows) {
				if(voteconfig.getTwodimensionpath() != null) {
					String url = aliyunOSSClientUtil.getUrl(voteconfig.getTwodimensionpath());
					voteconfig.setTwodimensionpath(url);
				}
			}
		}

		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		//关闭阿里oss
		aliyunOSSClientUtil.closeOSSClient();
		return Result.succee(map);
	}

	@Override
	public Result addVoteConfig(AccountInfo accountInfo, String AUTHORITY_CODE, Voteconfig voteconfig, String voteUrl,String qRpath)
			throws MyException, IOException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		if (voteconfig.getVotetitle() == null || voteconfig.getVoteparticipanttypeid() == null) {// 投票标题和参与人群不能为空
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		voteconfig.setCreateby(accountInfo.getAccount().getName());
		voteconfig.setCreatetime(new Date());
		voteconfig.setCreatepersonid(accountInfo.getAccount().getAccountid());
		int i = voteconfigMapper.insertSelective(voteconfig);
		//pc端地址
		if(voteconfig.getVoteid() != null) {
			voteconfig.setVotepageurl(WEB_SERVER_URL+webVoteUrl+"?voteitemid=" + voteconfig.getVoteid());
		}

		if (voteUrl != null) {// url拼接插入返回的投票活动id生成二维码
			Qr_code qr_code = new Qr_code();
			//移动端地址
			qr_code.getQrCodeImg(MOBILE_SERVER_URL+webVoteUrl + "?voteitemid=" + voteconfig.getVoteid(), qRpath);

			File f = new File(qRpath);
			FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(f.toPath()), false, f.getName(),
					(int) f.length(), f.getParentFile());
			try (InputStream input = new FileInputStream(f); OutputStream os = fileItem.getOutputStream();) {
				IOUtils.copy(input, os);
				MultipartFile mulFile = new CommonsMultipartFile(fileItem);
				// 取扩展名
				String fileName = mulFile.getOriginalFilename();
				String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
				String rqCodeFolder = createRQCodeFolder();
				// 执行上传
				String fileFullPath = aliyunOSSClientUtil.uploadFile(rqCodeFolder, fileName, mulFile.getSize(), mulFile.getInputStream(), accountInfo.getAccount().getAccountid());
				if (StringUtils.isBlank(fileFullPath)) {
					return Result.build(ResultEnum.UPLOAD_FILE_ERROR);
				}


				Fileinfo fileinfo = new Fileinfo();
				fileinfo.setType(4);// 二维码图片
				fileinfo.setFilename(fileName);
				fileinfo.setFiletype(extName);
				fileinfo.setFilefullpath(fileFullPath);
				fileinfo.setFilepath(rqCodeFolder);
				fileinfo.setFilesize(mulFile.getSize() + "");
				fileinfo.setCreateby(accountInfo.getAccount().getName());
				fileinfo.setCreatepersonid(accountInfo.getAccount().getAccountid());
				fileinfo.setCreatetime(new Date());

				// 添加到数据库
				int fileNum = fileinfoMapper.insertSelective(fileinfo);

				// 插入失败删除文件
				if (fileNum < 1) {
					aliyunOSSClientUtil.deleteFile(fileFullPath);
					return Result.build(ResultEnum.UPLOAD_FILE_ERROR);
				}

				if (fileinfo.getFileid() != null) {// 将图片id插入文件引用表
					this.addUseFile(fileinfo.getFileid(), TABLE_NAME, (long) voteconfig.getVoteid());
				}

				voteconfig.setTwodimensionpath(fileFullPath);// 二维码地址
				voteconfigMapper.updateByPrimaryKeySelective(voteconfig);
				// 数据库操作日志
				try {
					this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(),
							"上传文件:[ " + fileName + " ]", DB_LOG_TYPE);
				} catch (Exception e) {
					aliyunOSSClientUtil.deleteFile(fileFullPath);
					throw new MyException(ResultEnum.UPLOAD_FILE_ERROR);
				}
				aliyunOSSClientUtil.closeOSSClient();
			}

		}

		voteconfigMapper.updateByPrimaryKeySelective(voteconfig);

		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "添加了一个投票 : [ ";
		log += StringUtils.isBlank(voteconfig.getVotetitle()) ? "" : "投票标题=" + voteconfig.getVotetitle() + ",";
		log += voteconfig.getVoteid() == null ? "" : "投票id=" + voteconfig.getVoteid() + ",";
		log += StringUtils.isBlank(voteconfig.getCreateby()) ? "" : "创建者=" + voteconfig.getCreateby() + ",";
		log += voteconfig.getCreatepersonid() == null ? "" : "创建者id=" + voteconfig.getCreatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	@Override
	public Result updateVoteConfig(AccountInfo accountInfo, String AUTHORITY_CODE, Voteconfig voteconfig)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		voteconfig.setUpdateby(accountInfo.getAccount().getName());
		voteconfig.setUpdatetime(new Date());
		voteconfig.setUpdatepersonid(accountInfo.getAccount().getAccountid());

		int i = voteconfigMapper.updateByPrimaryKeySelective(voteconfig);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "修改了一个投票 : [ ";
		log += StringUtils.isBlank(voteconfig.getVotetitle()) ? "" : "投票标题=" + voteconfig.getVotetitle() + ",";
		log += voteconfig.getVoteid() == null ? "" : "投票id=" + voteconfig.getVoteid() + ",";
		log += StringUtils.isBlank(voteconfig.getUpdateby()) ? "" : "修改者=" + voteconfig.getUpdateby() + ",";
		log += voteconfig.getUpdatepersonid() == null ? "" : "修改者id=" + voteconfig.getUpdatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();
	}

	@Override
	public Result deleteVoteConfig(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		Voteconfig selectByPrimaryKey = voteconfigMapper.selectByPrimaryKey(voteid);
		if (selectByPrimaryKey == null) {
			return Result.build(ResultEnum.DATA_NOT_EXIST);
		}

		VoteitemExample voteitemExample = new VoteitemExample();
		Criteria createCriteria = voteitemExample.createCriteria();
		createCriteria.andVoteidEqualTo(voteid);
		List<Voteitem> voteitemList = voteitemMapper.selectByExample(voteitemExample);// 该投票下的所有题目
		if (voteitemList.size() != 0) {
			for (Voteitem voteitem : voteitemList) {
				VoteoptionExample voteoptionExample = new VoteoptionExample();
				com.jy.entiy.function.marketingFunction.votingManagement.VoteoptionExample.Criteria createCriteria2 = voteoptionExample
						.createCriteria();
				createCriteria2.andVoteitemidEqualTo(voteitem.getVoteitemid());
				voteoptionMapper.deleteByExample(voteoptionExample);// 删除题目下的选项
			}
		}

		voteitemMapper.deleteByExample(voteitemExample);// 删除该投票下的题目
		//删除二维码图片
		aliyunOSSClientUtil.deleteFile(selectByPrimaryKey.getTwodimensionpath());
		int i = voteconfigMapper.deleteByPrimaryKey(voteid);
		if (i < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "删除了一个投票 :  投票id为";
		log += voteid;
		log += "删除者=";
		log += accountInfo.getAccount().getName();

		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();
	}

	@Override
	public Result getVoteConfigInfo(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Voteconfig voteconfig = voteconfigMapper.selectByPrimaryKey(voteid);
		return Result.succee(voteconfig);

	}

	/**
	 * 投票操作
	 *
	 * @throws MyException
	 *
	 *
	 */
	@Override
	public Result voting(AccountInfo accountInfo,Integer voteid,Integer voteitemid,String[] voteoptionids) throws MyException {

		Votedetails votedetails = new Votedetails();
		Long accountid = accountInfo.getAccount().getAccountid();
		votedetails.setAccountid(accountid);
		//判断该用户是否已投过票
		VotedetailsExample votedetailsExample = new VotedetailsExample();
		com.jy.entiy.function.marketingFunction.votingManagement.VotedetailsExample.Criteria createCriteria = votedetailsExample
				.createCriteria();
		createCriteria.andVoteidEqualTo(voteid);
		createCriteria.andVoteitemidEqualTo(voteitemid);
		createCriteria.andAccountidEqualTo(accountid);
		int countByExample = votedetailsMapper.countByExample(votedetailsExample);
		if(countByExample != 0) {
			return Result.build(20001,400,"您已经投过票了!");
		}

		for (int i = 0; i < voteoptionids.length; i++) {
			String string = voteoptionids[i];
			votedetails.setVoteid(voteid);
			votedetails.setVoteitemid(voteitemid);
			votedetails.setVoteoptionid(Integer.parseInt(string));
			int j = votedetailsMapper.insertSelective(votedetails);
			if (j < 1) {
				throw new MyException(ResultEnum.INSERT_SQL_ERROR);
			}

			// 插入数据库操作日志
			String log = "进行了一次投票操作 : [ ";
			log += "投票人id=" + votedetails.getAccountid() + ",";
			log += "投票题目id=" + votedetails.getVoteitemid();
			log += "投票id=" + votedetails.getVoteid();

			this.dbLog(accountid, accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		}


		return Result.succee();
	}

	/**
	 * 导出投票
	 *
	 * @throws MyException
	 *
	 *
	 */
	@Override
	public Result exportVote(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (voteid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		//本题的有效投票人次
		int pNum = 0;
		Integer sum = 0;// 选项票数
		Voteconfig voteconfig = voteconfigMapper.selectByPrimaryKey(voteid);
		VoteitemExample voteitemExample = new VoteitemExample();
		Criteria createCriteria2 = voteitemExample.createCriteria();
		createCriteria2.andVoteidEqualTo(voteconfig.getVoteid());
		List<Voteitem> voteitems = voteitemMapper.selectByExample(voteitemExample);
		voteconfig.setVoteitems(voteitems);

		if(voteitems == null || voteitems.size() == 0) {
			return Result.build(20001,400,"该投票下没有题目!");
		}

		for (Voteitem voteitem : voteitems) {// 根据题目id查询下面的选项

			if(voteitem.getVoteitemid() != null) {
				pNum = voteitemMapper.pNum(voteid, voteitem.getVoteitemid());
				voteitem.setpNum(pNum);
			}

			VoteoptionExample voteoptionExample = new VoteoptionExample();
			com.jy.entiy.function.marketingFunction.votingManagement.VoteoptionExample.Criteria createCriteria3 = voteoptionExample
					.createCriteria();
			createCriteria3.andVoteitemidEqualTo(voteitem.getVoteitemid());
			List<Voteoption> voteoptions = voteoptionMapper.selectByExample(voteoptionExample);
			voteitem.setVoteoptions(voteoptions);
			for (Voteoption voteoption : voteoptions) {// 查询每项选项的票数(投一票插入一次)
				VotedetailsExample votedetailsExample = new VotedetailsExample();
				com.jy.entiy.function.marketingFunction.votingManagement.VotedetailsExample.Criteria createCriteria = votedetailsExample
						.createCriteria();
				createCriteria.andVoteoptionidEqualTo(voteoption.getVoteoptionid());
				List<Votedetails> VotedetailsList = votedetailsMapper.selectByExample(votedetailsExample);
				sum += VotedetailsList.size();
			}

			for (Voteoption voteoption : voteoptions) {
				VotedetailsExample votedetailsExample = new VotedetailsExample();
				com.jy.entiy.function.marketingFunction.votingManagement.VotedetailsExample.Criteria createCriteria = votedetailsExample
						.createCriteria();
				createCriteria.andVoteoptionidEqualTo(voteoption.getVoteoptionid());
				createCriteria.andVoteidEqualTo(voteid);
				createCriteria.andVoteitemidEqualTo(voteitem.getVoteitemid());
				List<Votedetails> VotedetailsList = votedetailsMapper.selectByExample(votedetailsExample);
				voteoption.setStatistics(VotedetailsList.size());// 统计票数
				if(VotedetailsList.size() != 0 && sum != 0) {
					// 计算比例
					double proportion = (double) VotedetailsList.size() / sum;
					//保留两位小数
					proportion = new BigDecimal(proportion).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					voteoption.setProportion(proportion*100);
				}else {
					voteoption.setProportion(0d);// 计算比例
				}



			}
		}

		return Result.succee(voteconfig);

	}

	/**
	 * 投票前加载 (根据投票id加载题目和选项)
	 *
	 * @throws MyException
	 *
	 *
	 */
	@Override
	public Result loadVote(AccountInfo accountInfo, String AUTHORITY_CODE, Integer voteid) throws MyException {


		if (voteid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}



		Voteconfig voteconfig = voteconfigMapper.selectByPrimaryKey(voteid);
		if(voteconfig == null) {
			return Result.build(20001,400,"该投票不存在!");
		}
		if(voteconfig.getVotestatusid() == STAUTS) {
			return Result.build(20001,400,"该活动已结束!");
		}
		//查看用户类型是否会员
		Boolean ismember = accountInfo.getAccount().getIsmember();
		Integer voteparticipanttypeid = voteconfig.getVoteparticipanttypeid();

		if(ismember == null && voteparticipanttypeid == TYPE2) {
			return Result.build(20001,400,"该投票只有会员可以参与!");
		}
		if(voteparticipanttypeid != null && voteparticipanttypeid == TYPE2 && !ismember) {
			return Result.build(20001,400,"该投票只有会员可以参与!");
		}

		VoteitemExample voteitemExample = new VoteitemExample();
		Criteria createCriteria2 = voteitemExample.createCriteria();
		createCriteria2.andVoteidEqualTo(voteconfig.getVoteid());
		List<Voteitem> voteitems = voteitemMapper.selectByExample(voteitemExample);
		voteconfig.setVoteitems(voteitems);

		if(voteitems == null || voteitems.size() == 0) {
			return Result.build(20001,400,"该投票下没有题目!");
		}

		for (Voteitem voteitem : voteitems) {// 根据题目id查询下面的选项
			VoteoptionExample voteoptionExample = new VoteoptionExample();
			com.jy.entiy.function.marketingFunction.votingManagement.VoteoptionExample.Criteria createCriteria3 = voteoptionExample
					.createCriteria();
			createCriteria3.andVoteitemidEqualTo(voteitem.getVoteitemid());
			List<Voteoption> voteoptions = voteoptionMapper.selectByExample(voteoptionExample);
			voteitem.setVoteoptions(voteoptions);
			Integer sum = 0;// 选项票数
			for (Voteoption voteoption : voteoptions) {// 查询每项选项的票数(投一票插入一次)
				VotedetailsExample votedetailsExample = new VotedetailsExample();
				com.jy.entiy.function.marketingFunction.votingManagement.VotedetailsExample.Criteria createCriteria = votedetailsExample
						.createCriteria();
				createCriteria.andVoteoptionidEqualTo(voteoption.getVoteoptionid());
				createCriteria.andVoteidEqualTo(voteid);
				createCriteria.andVoteitemidEqualTo(voteitem.getVoteitemid());
				List<Votedetails> VotedetailsList = votedetailsMapper.selectByExample(votedetailsExample);
				sum += VotedetailsList.size();
			}

			for (Voteoption voteoption : voteoptions) {
				VotedetailsExample votedetailsExample = new VotedetailsExample();
				com.jy.entiy.function.marketingFunction.votingManagement.VotedetailsExample.Criteria createCriteria = votedetailsExample
						.createCriteria();
				createCriteria.andVoteoptionidEqualTo(voteoption.getVoteoptionid());
				createCriteria.andVoteidEqualTo(voteid);
				createCriteria.andVoteitemidEqualTo(voteitem.getVoteitemid());
				List<Votedetails> VotedetailsList = votedetailsMapper.selectByExample(votedetailsExample);
				voteoption.setStatistics(VotedetailsList.size());// 统计票数
				if(VotedetailsList.size() != 0 && sum != 0) {
					// 计算比例
					double proportion = (double) VotedetailsList.size() / sum;
					//保留两位小数
					proportion = new BigDecimal(proportion).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
					voteoption.setProportion(proportion*100);
				}else {
					voteoption.setProportion(0d);// 计算比例
				}

			}

		}

		return Result.succee(voteconfig);

	}

	@Override
	public int itemType(Integer voteId, Integer voteItemId) {
		if(voteId == null || voteItemId == null) {
			return 0;
		}
		VoteitemExample voteitemExample = new VoteitemExample();
		Criteria createCriteria = voteitemExample.createCriteria();
		createCriteria.andVoteidEqualTo(voteId);
		createCriteria.andVoteitemidEqualTo(voteItemId);
		List<Voteitem> voteitems = voteitemMapper.selectByExample(voteitemExample);
		if(voteitems!= null && voteitems.size() != 0) {
			Integer votetypeid = voteitems.get(0).getVotetypeid();
			return votetypeid;
		}
		return 0;
	}

}
