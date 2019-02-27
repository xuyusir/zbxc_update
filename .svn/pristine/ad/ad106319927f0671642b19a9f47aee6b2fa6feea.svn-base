package com.jy.service.content.articleManage;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.DateUtils;
import com.jy.dao.content.articleManage.ArticleinfoMapper;
import com.jy.dao.content.columnManage.PagecolumnMapper;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.articleManage.Articleinfo;
import com.jy.entiy.content.articleManage.ArticleinfoExample;
import com.jy.entiy.content.articleManage.ArticleinfoExample.Criteria;
import com.jy.entiy.content.columnManage.Pagecolumn;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenye 文章管理接口实现
 *
 */
@Service
public class ArticleInfoServiceImpl extends BaseService implements ArticleInfoService {

	// 菜单数据库操作日志类型
	private static final String DB_LOG_TYPE = "DB_LOG_ARTICLE";

	// 放入回收站
	private static final String IS_DELETE = "Y";

	// 审核文章
	private static final String ISAUDITPASSED = "Y";

	private static final String TABLE_NAME = "ArticleInfo";

	@Resource
	private ArticleinfoMapper articleinfoMapper;

	@Resource
	private PagecolumnMapper pagecolumnMapper;

	@Resource
	private FileinfoMapper fileinfoMapper;

	/**
	 *
	 * 文章列表
	 */
	@Override
	public Result getArticleinfoByPageColumnID(Integer pagecolumnid, String articletitle,String search, Integer page,
			Integer pageSize) {

		List<Articleinfo> rows = articleinfoMapper.getArticleinfoByPageColumnID(pagecolumnid, articletitle,search,
				(page - 1) * pageSize, pageSize);
		for (Articleinfo articleinfo : rows) {
			if (articleinfo.getPagecolumnid() != null) {
				Pagecolumn pagecolumn = pagecolumnMapper.selectByPrimaryKey(articleinfo.getPagecolumnid());
				if (pagecolumn != null) {
					articleinfo.setPagecolumnName(pagecolumn.getPagecolumnname());
				}

				Long thumbnailfileid = articleinfo.getThumbnailfileid();// 缩略图文件id

				if (thumbnailfileid != null) {
					Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(thumbnailfileid);
					if (fileinfo != null && fileinfo.getFilefullpath() != null) {
						articleinfo.setThumbnailpath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));// 文章是学员案例时缩略图存学员照片
					}
				}
			}

		}

		Integer count = articleinfoMapper.getArticleinfoCountByPageColumnID(pagecolumnid, articletitle,search);
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		aliyunOSSClientUtil.closeOSSClient();
		return Result.succee(map);

	}

	/**
	 *
	 * 回收站文章列表
	 *
	 * @throws MyException
	 */
	@Override
	public Result getRecycleInfoByPageColumnID(AccountInfo accountInfo, String AUTHORITY_CODE, Integer pagecolumnid,
			String articletitle, Integer page, Integer pageSize) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		List<Articleinfo> rows = articleinfoMapper.getRecycleInfoByPageColumnID(pagecolumnid, articletitle,
				(page - 1) * pageSize, pageSize);
		Integer count = articleinfoMapper.getRecycleInfoCountByPageColumnID(pagecolumnid, articletitle);
		for (Articleinfo articleinfo : rows) {
			if (articleinfo.getPagecolumnid() != null) {
				Pagecolumn pagecolumn = pagecolumnMapper.selectByPrimaryKey(articleinfo.getPagecolumnid());
				if (pagecolumn != null) {
					articleinfo.setPagecolumnName(pagecolumn.getPagecolumnname());
				}

				Long thumbnailfileid = articleinfo.getThumbnailfileid();// 缩略图文件id

				if (thumbnailfileid != null) {
					Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(thumbnailfileid);
					if (fileinfo != null && fileinfo.getFilefullpath() != null) {
						articleinfo.setThumbnailpath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));// 文章是学员案例时缩略图存学员照片
					}
				}
			}

		}
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		aliyunOSSClientUtil.closeOSSClient();
		return Result.succee(map);

	}

	@Override
	public Pagecolumn getBannerByPageColumnID(Integer pagecolumnid) {
		// 根据栏目id加载banner图

		return pagecolumnMapper.selectByPrimaryKey(pagecolumnid);
	}

	@Override
	public Result insertArticle(AccountInfo accountInfo, String AUTHORITY_CODE, Articleinfo articleinfo)
			throws MyException, IOException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数非空检查
		if (StringUtils.isBlank(articleinfo.getArticletitle()) && articleinfo.getPagecolumnid() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		if (articleinfo.getPagecolumnid() == 14) {
			ArticleinfoExample articleinfoExample = new ArticleinfoExample();
			Criteria createCriteria = articleinfoExample.createCriteria();
			createCriteria.andPagecolumnidEqualTo(14);// 栏目为中博星辰企业介绍
			int countByExample = articleinfoMapper.countByExample(articleinfoExample);
			if (countByExample > 0) {
				return Result.build(2004, 400, "首页已有企业简介!");
			}
		}
		articleinfo.setIsdelete("N");
		int i1 = articleinfoMapper.insertSelective(articleinfo);
		if (i1 < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		if (articleinfo.getThumbnailfileid() != null && articleinfo.getArticleid() != null) {
			this.addUseFile(articleinfo.getThumbnailfileid(), TABLE_NAME, (long) articleinfo.getArticleid());
		}

		if (articleinfo.getAttachmentfileid() != null && articleinfo.getArticleid() != null) {
			this.addUseFile(articleinfo.getAttachmentfileid(), TABLE_NAME, (long) articleinfo.getArticleid());
		}

		// 插入数据库操作日志
		String log = "新增了文章 : [ ";
		log += StringUtils.isBlank(articleinfo.getArticletitle()) ? "" : "文章标题=" + articleinfo.getArticletitle() + ",";
		log += StringUtils.isBlank(articleinfo.getCreateby()) ? "" : "创建人=" + articleinfo.getCreateby() + ",";
		log += articleinfo.getPagecolumnid() == null ? 0 : "栏目id=" + articleinfo.getPagecolumnid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	@Override
	public Result updateArticle(AccountInfo accountInfo, String AUTHORITY_CODE, Articleinfo articleinfo)
			throws MyException, IOException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (articleinfo.getArticleid() == null ) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		if(articleinfo.getIsauditpassed() != null && !articleinfo.getIsauditpassed().equals("Y") &&  !articleinfo.getIsauditpassed().equals("N") ) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		Articleinfo old_articleinfo = articleinfoMapper.selectByPrimaryKey(articleinfo.getArticleid());
		articleinfo.setCreateby(old_articleinfo.getCreateby());
		articleinfo.setCreatetime(old_articleinfo.getCreatetime());
		articleinfo.setCreatepersonid(old_articleinfo.getCreatepersonid());

		int i = articleinfoMapper.updateByPrimaryKey(articleinfo);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		if (articleinfo.getThumbnailfileid() != null) {
			this.addUseFile(articleinfo.getThumbnailfileid(), TABLE_NAME, (long) articleinfo.getArticleid());
			if (old_articleinfo.getThumbnailfileid() != null) {
				this.deleteFile(accountInfo, DB_LOG_TYPE, old_articleinfo.getThumbnailfileid(), TABLE_NAME,
						(long) old_articleinfo.getArticleid());
			}
		}

		if (articleinfo.getAttachmentfileid() != null) {
			this.addUseFile(articleinfo.getAttachmentfileid(), TABLE_NAME, (long) articleinfo.getArticleid());
			if (old_articleinfo.getAttachmentfileid() != null) {
				this.deleteFile(accountInfo, DB_LOG_TYPE, old_articleinfo.getAttachmentfileid(), TABLE_NAME,
						(long) old_articleinfo.getArticleid());
			}
		}

		// 插入数据库操作日志
		String log = "修改了文章 : [ ";
		log += StringUtils.isBlank(articleinfo.getArticletitle()) ? "" : "文章标题=" + articleinfo.getArticletitle() + ",";
		log += StringUtils.isBlank(articleinfo.getUpdateby()) ? "" : "修改人=" + articleinfo.getUpdateby() + ",";
		log += articleinfo.getPagecolumnid() == null ? 0 : "栏目id=" + articleinfo.getPagecolumnid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	/**
	 *
	 * 放到回收站
	 */
	@Override
	public Result recycleArticle(AccountInfo accountInfo, String AUTHORITY_CODE, Articleinfo articleinfo)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		Long accountid = accountInfo.getAccount().getAccountid();
		String name = accountInfo.getAccount().getName();
		articleinfo.setUpdateby(name);
		articleinfo.setUpdatepersonid(accountid);
		articleinfo.setUpdatetime(new Date());
		articleinfo.setIsdelete(IS_DELETE);// 放入回收站
		int i = articleinfoMapper.updateByPrimaryKeySelective(articleinfo);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "转移文章到回收站 : [ ";
		log += StringUtils.isBlank(articleinfo.getArticletitle()) ? "" : "文章标题=" + articleinfo.getArticletitle() + ",";
		log += StringUtils.isBlank(articleinfo.getUpdateby()) ? "" : "修改人=" + articleinfo.getUpdateby() + ",";
		log += StringUtils.isBlank(articleinfo.getIsdelete()) ? "" : "回收站=" + articleinfo.getIsdelete() + ",";
		log += articleinfo.getPagecolumnid() == null ? 0 : "栏目id=" + articleinfo.getPagecolumnid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	/**
	 *
	 * 彻底删除
	 */
	@Override
	public Result deleteArticle(AccountInfo accountInfo, String AUTHORITY_CODE, Integer articleid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		if (articleid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		Articleinfo old_articleinfo = articleinfoMapper.selectByPrimaryKey(articleid);

		if (old_articleinfo == null) {
			return Result.build(ResultEnum.DATA_NOT_EXIST);
		}

		int i = articleinfoMapper.deleteByPrimaryKey(articleid);
		if (i < 1) {
			throw new MyException(ResultEnum.DELETE_SQL_ERROR);
		}

		if (old_articleinfo.getThumbnailfileid() != null) {
			this.deleteFile(accountInfo, DB_LOG_TYPE, old_articleinfo.getThumbnailfileid(), TABLE_NAME,
					(long) old_articleinfo.getArticleid());
		}

		if (old_articleinfo.getAttachmentfileid() != null) {
			this.deleteFile(accountInfo, DB_LOG_TYPE, old_articleinfo.getAttachmentfileid(), TABLE_NAME,
					(long) old_articleinfo.getArticleid());
		}

		// 插入数据库操作日志
		String log = "删除了文章";
		log += "文章id= " + articleid;
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	/**
	 *
	 * 审核文章
	 */
	@Override
	public Result auditArticle(AccountInfo accountInfo, String AUTHORITY_CODE, Articleinfo articleinfo)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		Long accountid = accountInfo.getAccount().getAccountid();
		String name = accountInfo.getAccount().getName();
		articleinfo.setUpdateby(name);
		articleinfo.setUpdatepersonid(accountid);
		articleinfo.setUpdatetime(new Date());
		articleinfo.setIsauditpassed(ISAUDITPASSED);
		int i = articleinfoMapper.updateByPrimaryKeySelective(articleinfo);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "修改了文章 : [ ";
		log += StringUtils.isBlank(articleinfo.getArticletitle()) ? "" : "文章标题=" + articleinfo.getArticletitle() + ",";
		log += StringUtils.isBlank(articleinfo.getUpdateby()) ? "" : "修改人=" + articleinfo.getUpdateby() + ",";
		log += articleinfo.getPagecolumnid() == null ? 0 : "栏目id=" + articleinfo.getPagecolumnid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	@Override
	public Result getNotAudit(AccountInfo accountInfo, String AUTHORITY_CODE, Integer pagecolumnid, String articletitle,
			Integer page, Integer pageSize) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// if (pagecolumnid != null) {

		List<Articleinfo> rows = articleinfoMapper.getNotAudit(pagecolumnid, articletitle, (page - 1) * pageSize,
				pageSize);
		Integer count = articleinfoMapper.getNotAuditCount(pagecolumnid, articletitle);
		for (Articleinfo articleinfo : rows) {
			if (articleinfo.getPagecolumnid() != null) {
				Pagecolumn pagecolumn = pagecolumnMapper.selectByPrimaryKey(articleinfo.getPagecolumnid());
				if (pagecolumn != null) {
					articleinfo.setPagecolumnName(pagecolumn.getPagecolumnname());
				}

				Long thumbnailfileid = articleinfo.getThumbnailfileid();// 缩略图文件id

				if (thumbnailfileid != null) {
					Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(thumbnailfileid);
					if (fileinfo != null && fileinfo.getFilefullpath() != null) {
						articleinfo.setThumbnailpath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));// 文章是学员案例时缩略图存学员照片
					}
				}
			}

		}
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		aliyunOSSClientUtil.closeOSSClient();
		return Result.succee(map);
		//// }
		// return Result.build(ResultEnum.SELECT_ERROR);
	}

	@Override
	public Result getFormLoad(AccountInfo accountInfo, String AUTHORITY_CODE) throws MyException {

		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		List<Pagecolumn> selectByExample = pagecolumnMapper.selectByExample(null);

		return Result.succee(selectByExample);
	}

	@Override
	public Result getUpdateSelect(AccountInfo accountInfo, String AUTHORITY_CODE, Integer articleid,Integer reqSource)
			throws MyException, ParseException {
		// 检测权限
		// Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		/*
		 * if (checkAuthority.getStatus() != 200) { return checkAuthority; }
		 */
		Map<String, Object> map = new HashMap<>();

		if (articleid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

			Articleinfo articleinfo = articleinfoMapper.selectByPrimaryKey(articleid);
			if (articleinfo != null) {
				Date deploymenttime = articleinfo.getDeploymenttime();
				// 缩略图文件id
				Long thumbnailfileid = articleinfo.getThumbnailfileid();
				// 附件文件id
				Long attachmentfileid = articleinfo.getAttachmentfileid();
				// 关联视频id
				Long livevediolistid = articleinfo.getLivevediolistid();
				//官网查看详细信息点击量+1
				if(reqSource != null && reqSource == 1) {
					String hits = articleinfo.getAuditcomment();
					if(hits == null || hits.equals("")) {
						hits = "0";
					}
					Long longHits=Long.parseLong(hits) + 1l;
					hits = String.valueOf(longHits);
					articleinfo.setAuditcomment(hits);
					articleinfo.setThumbnailpath(null);
					articleinfo.setLivevedioPath(null);
					articleinfo.setThumbnailpath(null);
					articleinfoMapper.updateByPrimaryKeySelective(articleinfo);
				}
				if (deploymenttime != null) {
					String y = DateUtils.dateFormat(deploymenttime, "yyyy");
					String m = DateUtils.dateFormat(deploymenttime, "MM");
					String d = DateUtils.dateFormat(deploymenttime, "dd");

					map.put("y", y);
					map.put("md", m + "-" + d);
				}
				if (thumbnailfileid != null) {
					Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(thumbnailfileid);
					if (fileinfo != null && StringUtils.isNotBlank(fileinfo.getFilefullpath())) {
						articleinfo.setThumbnailpath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));// 文章是学员案例时缩略图存学员照片
						articleinfo.setThumbnailfileName(fileinfo.getFilename());
					}
				}
				if (attachmentfileid != null) {
					Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(attachmentfileid);
					if (fileinfo != null && StringUtils.isNotBlank(fileinfo.getFilefullpath())) {
						articleinfo.setAttachmentpath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));// 文章是学员案例时附件存公司logo
						articleinfo.setAttachmentfileName(fileinfo.getFilename());
					}
				}
				if (livevediolistid != null ) {
					Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(livevediolistid);
					if (fileinfo != null && StringUtils.isNotBlank(fileinfo.getFilefullpath())) {
						articleinfo.setLivevedioName(fileinfo.getFilename());
						articleinfo.setLivevedioPath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));
					}
				}
				aliyunOSSClientUtil.closeOSSClient();
			

				map.put("articleinfo", articleinfo);
				return Result.succee(map);
			}else {

				map.put("articleinfo", articleinfo);
				return Result.succee(map);
			}


	}

	@Override
	public Pagecolumn insertBannerByPageColumnID(Pagecolumn pagecolumn) {
		return null;
	}

	@Override
	public Result updateBanner(AccountInfo accountInfo, String AUTHORITY_CODE, Pagecolumn pagecolumn)
			throws MyException { // 检测修改权限
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		pagecolumn.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		pagecolumn.setUpdateby(accountInfo.getAccount().getName());
		int i = pagecolumnMapper.updateByPrimaryKeySelective(pagecolumn);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		return Result.succee();
	}

	@Override
	public Result getArticleLiveByTime(Integer pagecolumnid) {
		ArticleinfoExample articleinfoExample = new ArticleinfoExample();
		articleinfoExample.setOrderByClause("DeploymentTime");
		Criteria createCriteria = articleinfoExample.createCriteria();
		createCriteria.andIsdeleteEqualTo("N");
		createCriteria.andIsauditpassedEqualTo("Y");
		createCriteria.andPagecolumnidEqualTo(pagecolumnid);

		// List<Articleinfo> notBeginList = new ArrayList<>();//即将直播
		// List<Articleinfo> ingList = new ArrayList<>();//正在直播
		// List<Articleinfo> endList = new ArrayList<>();//直播结束
		// List<Articleinfo> playbackList = new ArrayList<>();//观看回放
		List<Articleinfo> list = articleinfoMapper.selectByExample(articleinfoExample);
		for (Articleinfo articleinfo : list) {
			Date deadlinetime = articleinfo.getDeadlinetime();
			Date deploymenttime = articleinfo.getDeploymenttime();
			if(deadlinetime == null || deploymenttime == null) {
				System.err.println("课程:"+articleinfo.getArticletitle()+"直播时间异常");
				//跳过本次循环
				continue;
			}
			Date date = new Date();
			if (deadlinetime.getTime() <= date.getTime() && articleinfo.getLivevediolistid() == null) {// 直播已结束
				articleinfo.setLiveStuatus(3);
				// endList.add(articleinfo);
			}else if (deploymenttime.getTime() > date.getTime()) {// 即将直播
				articleinfo.setLiveStuatus(1);
				// notBeginList.add(articleinfo);
			}else if (deadlinetime.getTime() > date.getTime() && date.getTime() >= deploymenttime.getTime()) {
				articleinfo.setLiveStuatus(2);//正在直播
				// ingList.add(articleinfo);
			}else if (articleinfo.getLivevediolistid() != null && articleinfo.getLivevediolistid() != 0 && deadlinetime.getTime() <= date.getTime()) {
				articleinfo.setLiveStuatus(4);//观看回放
				Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(articleinfo.getLivevediolistid());
				if (fileinfo != null && fileinfo.getFilefullpath() != null) {
					articleinfo.setLivevedioPath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));// 视频回放地址
				}
				// playbackList.add(articleinfo);
			}

			Long thumbnailfileid = articleinfo.getThumbnailfileid();// 缩略图文件id

			if (thumbnailfileid != null) {
				Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(thumbnailfileid);
				if (fileinfo != null && fileinfo.getFilefullpath() != null) {
					articleinfo.setThumbnailpath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));// 文章是学员案例时缩略图存学员照片
				}
			}

		}

		// Map<String, Object> map = new HashMap<>();
		// map.put("notBeginList", notBeginList);
		// map.put("ingList", ingList);
		// map.put("endList", endList);
		// map.put("playbackList", playbackList);
		aliyunOSSClientUtil.closeOSSClient();
		return Result.succee(list);
	}

	/**
	 * 还原文章
	 */
	@Override
	public Result restoreArticle(AccountInfo accountInfo, String CONTROLLER_CODE, Articleinfo articleinfo)
			throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, CONTROLLER_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		// 还原前检查该文章是否过了截止日期,若过期需要修改截止时间才可还原(因为文章过期自动回收)
		Articleinfo selectByPrimaryKey = articleinfoMapper.selectByPrimaryKey(articleinfo.getArticleid());
		if(selectByPrimaryKey == null) {
			return Result.build(ResultEnum.DATA_NOT_EXIST);
		}
		// 当前时间
		long time = new Date().getTime();
		Date deploymenttime = selectByPrimaryKey.getDeploymenttime();// 发布时间
		Date deadlinetime = selectByPrimaryKey.getDeadlinetime();// 截止时间
		if (deploymenttime != null && deadlinetime != null) {
			// 文章处于发布期间
			if (time >= deadlinetime.getTime()) {
				return Result.build(2004,400,"文章:"+selectByPrimaryKey.getArticletitle()+"已过期,还原前请先修改发布日期!");
			}
		}

		Long accountid = accountInfo.getAccount().getAccountid();
		String name = accountInfo.getAccount().getName();
		articleinfo.setUpdateby(name);
		articleinfo.setUpdatepersonid(accountid);
		articleinfo.setUpdatetime(new Date());
		articleinfo.setIsdelete("N");// 还原
		int i = articleinfoMapper.updateByPrimaryKeySelective(articleinfo);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log = "还原文章 : [ ";
		log += StringUtils.isBlank(articleinfo.getArticletitle()) ? "" : "文章标题=" + articleinfo.getArticletitle() + ",";
		log += StringUtils.isBlank(articleinfo.getUpdateby()) ? "" : "修改人=" + articleinfo.getUpdateby() + ",";
		log += StringUtils.isBlank(articleinfo.getIsdelete()) ? "" : "回收站=" + articleinfo.getIsdelete() + ",";
		log += articleinfo.getPagecolumnid() == null ? 0 : "栏目id=" + articleinfo.getPagecolumnid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		return Result.succee();

	}

	// /**
	// * 正在发布的文章
	// * 当前时间在发布时间和截止时间之间
	// *
	// */
	// @Override
	// public Result getArticleList(Integer pagecolumnid, String articletitle,
	// Integer page, Integer pageSize) {
	// //返回数据集
	// List<Articleinfo> list = new ArrayList<>();
	// List<Articleinfo> rows =
	// articleinfoMapper.getArticleinfoByPageColumnID(pagecolumnid, articletitle,
	// (page - 1) * pageSize, pageSize);
	//
	// //当前时间
	// long time = new Date().getTime();
	// for (Articleinfo articleinfo : rows) {
	// Date deploymenttime = articleinfo.getDeploymenttime();//发布时间
	// Date deadlinetime = articleinfo.getDeadlinetime();//截止时间
	// if(deploymenttime != null && deadlinetime != null) {
	// //文章处于发布期间
	// if(deploymenttime.getTime() <= time && time < deadlinetime.getTime()) {
	// list.add(articleinfo);
	// }
	// }
	// }
	//
	// for (Articleinfo articleinfo : list) {
	// if (articleinfo.getPagecolumnid() != null) {
	// Pagecolumn pagecolumn =
	// pagecolumnMapper.selectByPrimaryKey(articleinfo.getPagecolumnid());
	// if (pagecolumn != null) {
	// articleinfo.setPagecolumnName(pagecolumn.getPagecolumnname());
	// }
	//
	// Long thumbnailfileid = articleinfo.getThumbnailfileid();// 缩略图文件id
	//
	// if (thumbnailfileid != null) {
	// Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(thumbnailfileid);
	// if (fileinfo != null && fileinfo.getFilefullpath() != null) {
//	articleinfo.setThumbnailpath(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));// 文章是学员案例时缩略图存学员照片
//}
	// }
	// }
	// }
	//
	// }
	//
	// Integer count =
	// articleinfoMapper.getArticleinfoCountByPageColumnID(pagecolumnid,
	// articletitle);
	// Map<String, Object> map = new HashMap<>();
	// map.put("rows", list);
	// map.put("count", count);
	// return Result.succee(map);
	// }

}
