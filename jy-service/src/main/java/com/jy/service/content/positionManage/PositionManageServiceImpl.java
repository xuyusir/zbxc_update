package com.jy.service.content.positionManage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.content.articleManage.ArticleinfoMapper;
import com.jy.dao.content.columnManage.PagecolumnMapper;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.dao.content.file.file.UsefileMapper;
import com.jy.dao.content.positionManage.ColumnpostionMapper;
import com.jy.dao.function.enterprise.info.EnterpriseinfoMapper;
import com.jy.dao.function.enterprise.recruitment.EnterprisejobvacancyMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.articleManage.Articleinfo;
import com.jy.entiy.content.columnManage.Pagecolumn;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.entiy.content.positionManage.Columnpostion;
import com.jy.entiy.content.positionManage.ColumnpostionExample;
import com.jy.entiy.function.enterprise.info.Enterpriseinfo;
import com.jy.entiy.function.enterprise.recruitment.EnterprisejobvacancyExample;
import com.jy.service.base.BaseService;

/**
 * @ClassName: PositionManageServiceImpl
 * @Description:推荐位管理实现类
 * @author: chenye
 * @date: 2018-09-20 9:55
 */
@Service
public class PositionManageServiceImpl extends BaseService implements PositionManageService {

	// 数据库操作日志类型
	private static final String DB_LOG_TYPE = "DB_LOG_POSITION_MANAGE";
	private static final String TABLE_NAME = "ColumnPostion";

	@Resource
	PagecolumnMapper pagecolumnMapper;
	@Resource
	private ColumnpostionMapper columnpostionMapper;
	@Resource
	private FileinfoMapper fileinfoMapper;
	@Resource
	private UsefileMapper usefileMapper;
	@Resource
	private EnterpriseinfoMapper enterpriseinfoMapper;
	@Resource
	private ArticleinfoMapper articleinfoMapper;
	@Resource
	private EnterprisejobvacancyMapper enterprisejobvacancyMapper;

	public Result getPositionList() throws MyException {
		ColumnpostionExample columnpostionExample = new ColumnpostionExample();
		columnpostionExample.setOrderByClause("PageColumnID,DisplayOrder");
		List<Columnpostion> list = columnpostionMapper.selectByExample(columnpostionExample);

		return Result.succee(list);
	}

	@Override
	public Result getPositionList(AccountInfo accountInfo, String AUTHORITY_CODE, Integer page, Integer pageSize)
			throws MyException {
		// 检测权限
		// Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		// if (checkAuthority.getStatus() != 200) {
		// return checkAuthority;
		// }
		PageHelper.startPage(page, pageSize);
		ColumnpostionExample columnpostionExample = new ColumnpostionExample();
		columnpostionExample.setOrderByClause("PageColumnID,DisplayOrder");
		List<Columnpostion> list = columnpostionMapper.selectByExample(columnpostionExample);
		PageInfo<Columnpostion> info = new PageInfo<>(list);
		List<Columnpostion> rows = info.getList();
		
		if(rows != null && rows.size() != 0) {
			for (Columnpostion columnpostion : rows) {
				Integer pagecolumnid = columnpostion.getPagecolumnid();
				if(pagecolumnid != null && pagecolumnid != 0) {
					Pagecolumn selectByPrimaryKey = pagecolumnMapper.selectByPrimaryKey(pagecolumnid);
					if(selectByPrimaryKey != null) {
						columnpostion.setPagecolumnname(selectByPrimaryKey.getPagecolumnname());
					}
				}
			}
		}
		
		long count = info.getTotal();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

	@Override
	public Result getPositionInfo(AccountInfo accountInfo, String AUTHORITY_CODE, Integer columnpostionid)
			throws MyException {
		// // 检测权限
		// Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		// if (checkAuthority.getStatus() != 200) {
		// return checkAuthority;
		// }
		if (columnpostionid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Columnpostion columnpostion = columnpostionMapper.selectByPrimaryKey(columnpostionid);
		if (columnpostion.getFileid() != null) {
			Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(columnpostion.getFileid());
			if(fileinfo != null) {
				if (fileinfo.getFilefullpath() != null) {
				columnpostion.setPicturePath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));
			}
			}
			

		}
		aliyunOSSClientUtil.closeOSSClient();
		return Result.succee(columnpostion);
	}

	public Result getAllPositionByColumn(AccountInfo accountInfo, String AUTHORITY_CODE, Integer pagecolumnid)
			throws MyException {

		if (pagecolumnid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		ColumnpostionExample columnpostionExample = new ColumnpostionExample();
		columnpostionExample.setOrderByClause("DisplayOrder");
		com.jy.entiy.content.positionManage.ColumnpostionExample.Criteria createCriteria = columnpostionExample.createCriteria();
		createCriteria.andPagecolumnidEqualTo(pagecolumnid);
		List<Columnpostion> list = columnpostionMapper.selectByExample(columnpostionExample);
		for (Columnpostion columnpostion : list) {
			Integer relationtype = columnpostion.getRelationtype();
			Integer relationid = columnpostion.getRelationid();
			if (relationtype == 1 && relationid != null) {// 关联的是文章
				Articleinfo relationContent = articleinfoMapper.selectByPrimaryKey(relationid);
				if(relationContent!= null && relationContent.getAttachmentfileid() != null) {
					Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(relationContent.getAttachmentfileid());
					if(fileinfo != null) {
						if (fileinfo.getFilefullpath() != null) {
							relationContent.setAttachmentpath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));
					}
					}
				}
				if(relationContent!= null && relationContent.getAttachmentfileid() != null) {
					Fileinfo fileinfo2 = fileinfoMapper.selectByPrimaryKey(relationContent.getThumbnailfileid());
					if(fileinfo2 != null) {
						if (fileinfo2.getFilefullpath() != null) {
							relationContent.setThumbnailpath(aliyunOSSClientUtil.getUrl(fileinfo2.getFilefullpath()));
					}
					}
				}
				columnpostion.setRelationContent(relationContent);
			}
			if (relationtype == 2 && relationid != null) {// 关联的是企业
				Enterpriseinfo relationContent = enterpriseinfoMapper.selectByPrimaryKey(relationid);
				if(relationContent!= null && relationContent.getLogofileid() != null) {
					Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(relationContent.getLogofileid());
					if(fileinfo != null) {
						if (fileinfo.getFilefullpath() != null) {
							relationContent.setLogoPath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));
					}
					}
				}

				EnterprisejobvacancyExample enterprisejobvacancyExample = new EnterprisejobvacancyExample();
				com.jy.entiy.function.enterprise.recruitment.EnterprisejobvacancyExample.Criteria criteria = enterprisejobvacancyExample.createCriteria();
				criteria.andEnterpriseidEqualTo(relationid);
				criteria.andIsopenEqualTo("Y");
				criteria.andIsdeleteEqualTo("N");
				criteria.andIszhongboxingchenEqualTo("N");
				criteria.andIsauditpassedEqualTo("Y");
				int countByExample = enterprisejobvacancyMapper.countByExample(enterprisejobvacancyExample);
				relationContent.setNum(countByExample);
				columnpostion.setRelationContent(relationContent);

			}
		}
		aliyunOSSClientUtil.closeOSSClient();
		return Result.succee(list);

	}

	@Override
	public Result insertPosition(AccountInfo accountInfo, String AUTHORITY_CODE, Columnpostion columnpostion)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查
		if (StringUtils.isBlank(columnpostion.getPostionname()) || columnpostion.getDisplayorder() == null
				|| columnpostion.getPagecolumnid() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		Pagecolumn pagecolumn = pagecolumnMapper.selectByPrimaryKey(columnpostion.getPagecolumnid());
		if (pagecolumn == null) {// 该栏目不存在
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		// 同一栏目下推荐位序号检查是否已存在
		ColumnpostionExample columnpostionExample = new ColumnpostionExample();
		com.jy.entiy.content.positionManage.ColumnpostionExample.Criteria createCriteria = columnpostionExample.createCriteria();
		createCriteria.andPagecolumnidEqualTo(columnpostion.getPagecolumnid());
		createCriteria.andDisplayorderEqualTo(columnpostion.getDisplayorder());
		int count = columnpostionMapper.countByExample(columnpostionExample);
		if (count != 0) {
			return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);
		}

		int i = columnpostionMapper.insertSelective(columnpostion);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}
		if (columnpostion.getFileid() != null) {
			this.addUseFile(columnpostion.getFileid(), TABLE_NAME, (long) columnpostion.getColumnpostionid());
		}

		// 插入数据库操作日志
		String log = "添加了一个推荐位 : [ ";
		log += StringUtils.isBlank(columnpostion.getPostionname()) ? ""
				: "推荐位名称=" + columnpostion.getPostionname() + ",";
		log += columnpostion.getColumnpostionid() == null ? "" : "推荐位id=" + columnpostion.getColumnpostionid() + ",";
		log += StringUtils.isBlank(columnpostion.getCreateby()) ? "" : "创建者=" + columnpostion.getCreateby() + ",";
		log += columnpostion.getCreatepersonid() == null ? "" : "创建者id=" + columnpostion.getCreatepersonid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	@Override
	public Result updatePosition(AccountInfo accountInfo, String AUTHORITY_CODE, Columnpostion columnpostion)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查
		if (columnpostion.getColumnpostionid() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		
		Columnpostion selectByPrimaryKey = columnpostionMapper.selectByPrimaryKey(columnpostion.getColumnpostionid());
		if(selectByPrimaryKey == null) {//没有该推荐位
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		
		try {
			if (columnpostion.getDisplayorder() != null) {
				// 序号检查是否已存在
				ColumnpostionExample columnpostionExample = new ColumnpostionExample();
				com.jy.entiy.content.positionManage.ColumnpostionExample.Criteria createCriteria = columnpostionExample
						.createCriteria();
				createCriteria.andDisplayorderEqualTo(columnpostion.getDisplayorder());
				createCriteria.andPagecolumnidEqualTo(columnpostion.getPagecolumnid());
				createCriteria.andColumnpostionidNotEqualTo(columnpostion.getColumnpostionid());
				int count = columnpostionMapper.countByExample(columnpostionExample);
				if (count != 0) {
					return Result.build(ResultEnum.SERIAL_NUMBER_EXIST);
				}
			}

			Columnpostion old_columnpostion = selectByPrimaryKey;

			int i = columnpostionMapper.updateByPrimaryKeySelective(columnpostion);
			if (i < 1) {
				throw new MyException(ResultEnum.INSERT_SQL_ERROR);
			}
			if (columnpostion.getFileid() != null) {
				this.addUseFile(columnpostion.getFileid(), TABLE_NAME, (long) columnpostion.getColumnpostionid());
				if (old_columnpostion.getFileid() != null) {
					this.deleteFile(accountInfo, DB_LOG_TYPE, old_columnpostion.getFileid(), TABLE_NAME,
							(long) old_columnpostion.getColumnpostionid());
				}
			}

			// 插入数据库操作日志
			String log = "修改了一个推荐位 : [ ";
			log += StringUtils.isBlank(columnpostion.getPostionname()) ? ""
					: "推荐位名称=" + columnpostion.getPostionname() + ",";
			log += columnpostion.getColumnpostionid() == null ? ""
					: "推荐位id=" + columnpostion.getColumnpostionid() + ",";
			log += StringUtils.isBlank(columnpostion.getUpdateby()) ? "" : "修改者=" + columnpostion.getUpdateby() + ",";
			log += columnpostion.getUpdatepersonid() == null ? "" : "修改者id=" + columnpostion.getUpdatepersonid() + ",";
			log = log.substring(0, log.length() - 1) + " ]";
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (Exception e) {

			logger.info("异常信息：" + e);

			throw new RuntimeException();

		}
		return Result.succee();
	}

	@Override
	public Result deletePosition(AccountInfo accountInfo, String AUTHORITY_CODE, Integer columnpostionid)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查
		if (columnpostionid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

			Columnpostion columnpostion = columnpostionMapper.selectByPrimaryKey(columnpostionid);
			
			if (columnpostion == null) {//该推荐位不存在
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			
			int i = columnpostionMapper.deleteByPrimaryKey(columnpostionid);
			if (i < 1) {
				throw new MyException(ResultEnum.DELETE_SQL_ERROR);
			}

			
			if (columnpostion.getFileid() != null) {
				this.deleteFile(accountInfo, DB_LOG_TYPE, columnpostion.getFileid(), TABLE_NAME,
						(long) columnpostion.getColumnpostionid());
			}
			// 插入数据库操作日志
			String log = "删除了一个推荐位 :  推荐位id为";
			log += columnpostionid;
			log += "删除者";
			log += accountInfo.getAccount().getName();

			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

}
