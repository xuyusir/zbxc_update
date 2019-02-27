package com.jy.controller.content.articleManage;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.DateUtils;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.articleManage.Articleinfo;
import com.jy.service.content.articleManage.ArticleInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Controller
@RequestMapping("content/article")
@Api(tags = "content.ArticleInfoController", description = "内容-文章管理")
public class ArticleInfoController extends BaseController {
	
	
	
	@Resource
	ArticleInfoService articleInfoService;
	
	@ApiOperation(value = "文章列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getArticleinfoByPageColumnID( 
			@ApiParam(value = "文章标题", required = false) String articletitle,
			@ApiParam(value = " 官网搜索(学员案例时使用)", required = false) String search,
			@ApiParam(value = "栏目ID", required = true) Integer pagecolumnid,
			@ApiParam(value = "加载第几页")@RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam( required = false, defaultValue = "10") Integer pageSize
			) {
		
		return articleInfoService.getArticleinfoByPageColumnID(pagecolumnid, articletitle,search, page, pageSize);
		
	}
	
	
	@ApiOperation(value = "回收站文章列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/recycle/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getRecycleInfoByPageColumnID( 
			@ApiParam(value = "文章标题", required = false) String articletitle,
			@ApiParam(value = "栏目ID", required = true) Integer pagecolumnid,
			@ApiParam(value = "加载第几页")@RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam( required = false, defaultValue = "10") Integer pageSize
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return articleInfoService.getRecycleInfoByPageColumnID(accountInfo, AuthorityCode.CONTENT_ARTICLE_RECYCLE_LIST_AUTHORITY, pagecolumnid, articletitle, page, pageSize);
		
	}
	
	@ApiOperation(value = "未审核文章列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/not/audit/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getNotAudit( 
			@ApiParam(value = "文章标题", required = false) String articletitle,
			@ApiParam(value = "栏目ID", required = true) Integer pagecolumnid,
			@ApiParam(value = "加载第几页")@RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam( required = false, defaultValue = "10") Integer pageSize
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return articleInfoService.getNotAudit(accountInfo, AuthorityCode.CONTENT_ARTICLE_AUDIT_LIST_AUTHORITY, pagecolumnid, articletitle, page, pageSize);
		
	}
	
	@ApiOperation(value = "加载表单", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/form/load", method = RequestMethod.GET)
	@ResponseBody
	public Result getFormLoad() throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return articleInfoService.getFormLoad(accountInfo, AuthorityCode.CONTENT_ARTICLE_LOAD_FORM_AUTHORITY);
		
	}
	
//	@ApiOperation(value = "加载banner图", httpMethod = "GET", produces = "application/json")
//	@RequestMapping(value = "/banner/{pagecolumnid}", method = RequestMethod.GET)
//	@ResponseBody
//	public Result getBanner( @ApiParam(value = "栏目id", required = true) @PathVariable Integer pagecolumnid) {
//		Pagecolumn banner = articleInfoService.getBannerByPageColumnID(pagecolumnid);
//		Map<String, Object> map = new HashMap<>();
//		
//		return Result.succee(map);
//	}
	
	
//	@ApiOperation(value = "替换/删除banner图", httpMethod = "PUT", produces = "application/json")
//	@RequestMapping(value = "/banner", method = RequestMethod.PUT)
//	@ResponseBody
//	public Result updateBanner(Pagecolumn pagecolumn) throws MyException {
//		AccountInfo accountInfo = this.getAccountInfo();
//		return articleInfoService.updateBanner(accountInfo, CONTROLLER_CODE, pagecolumn);
//		
//	}
	
	@ApiOperation(value = "新增", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertArticleInfo(
			@ApiParam(value = "栏目id", required = true)  Integer pagecolumnid,
			@ApiParam(value = "文章标题", required = true)  String articletitle,
			@ApiParam(value = "文章副标题", required = false)  String articlesubtitle,			
			@ApiParam(value = "关键词", required = false)  String keyword,
			@ApiParam(value = "文章简介", required = false)  String articleabstract,
			@ApiParam(value = "SEO简介", required = false) String seoabstract,
			@ApiParam(value = "缩略图文件id", required = false)  Long thumbnailfileid,
			@ApiParam(value = "正文", required = true)  String articlemainbody,
			@ApiParam(value = "附件文件id", required = false)  Long attachmentfileid,
			@ApiParam(value = "关联视频文件id", required = false)  Long livevediolistid,
			@ApiParam(value = "截止日期", required = true)  String deadlinetime,			
			@ApiParam(value = "发布时间", required = true)  String deploymenttime,
			@ApiParam(value = "发布人", required = true)   String deployperson,
			@ApiParam(value = "文章来源", required = true)  String originalsource,
			@ApiParam(value = "审核Y不审核N", required = true) String isauditpassed
			
			) throws MyException, IOException, ParseException {
		AccountInfo accountInfo = this.getAccountInfo();
		Articleinfo articleinfo = new Articleinfo();
		articleinfo.setPagecolumnid(pagecolumnid);
		articleinfo.setArticletitle(articletitle);
		articleinfo.setArticlesubtitle(articlesubtitle);
		articleinfo.setKeyword(keyword);
		articleinfo.setArticleabstract(articleabstract);
		articleinfo.setSeoabstract(seoabstract);
		articleinfo.setThumbnailfileid(thumbnailfileid);
		articleinfo.setArticlemainbody(articlemainbody);
		articleinfo.setAttachmentfileid(attachmentfileid);
		articleinfo.setLivevediolistid(livevediolistid);	
		articleinfo.setDeployperson(deployperson);
		articleinfo.setOriginalsource(originalsource);
		articleinfo.setIsauditpassed(isauditpassed);
		articleinfo.setCreateby(accountInfo.getAccount().getName());
		articleinfo.setCreatetime(new Date());
		articleinfo.setCreatepersonid(accountInfo.getAccount().getAccountid());

		//截止时间
		Date dateParse1 = null;
		//发布时间
		Date dateParse2 = null;
		
		if(pagecolumnid == 4) {
			//直播课程 时间不能为空
			if(deploymenttime == null || deadlinetime == null || deploymenttime.equals("") || deadlinetime.equals("")) {
				 return Result.build(20001,400,"直播时间不能为空!");
			}
			//不能跨天直播
			if(StringUtils.isNotBlank(deadlinetime)){
				   dateParse1 = DateUtils.dateParse(deadlinetime,DateUtils.MINUTE_PATTERN);
				   dateParse2 = DateUtils.dateParse(deploymenttime,DateUtils.MINUTE_PATTERN);
				   String dateFormat = DateUtils.dateFormat(dateParse1, DateUtils.DATE_PATTERN);
				   String dateFormat2 = DateUtils.dateFormat(dateParse2, DateUtils.DATE_PATTERN);
				  if(!dateFormat.equals(dateFormat2)) {
					  return Result.build(20001,400,"直播结束时间不能为次日!");
				  }
				  articleinfo.setDeadlinetime(dateParse1);
		        }
		}
		
		//关键字字数控制
		if(keyword != null) {
			if(keyword.length() > 10) {
				return Result.build(0000,0000,"关键字字数不能超过10个字");
			}
			
		}
		
		//发布时间为空默认为当前时间
		if(deploymenttime == null || deploymenttime.equals("")) {
			articleinfo.setDeploymenttime(new Date());
		}
		
		  if(StringUtils.isNotBlank(deadlinetime)){
			   dateParse1 = DateUtils.dateParse(deadlinetime,DateUtils.MINUTE_PATTERN);
			  if(dateParse1.getTime() < new Date().getTime()) {
				  return Result.build(20001,400,"截止时间不能为过去的时间!");
			  }
			  articleinfo.setDeadlinetime(dateParse1);
	        }
		  if(StringUtils.isNotBlank(deploymenttime)){
			   dateParse2 = DateUtils.dateParse(deploymenttime,DateUtils.MINUTE_PATTERN);
			  articleinfo.setDeploymenttime(dateParse2);
	        }
		//截止时间早于发布时间
		  if(dateParse1 != null && dateParse2 != null && dateParse1.getTime()<dateParse2.getTime()) {
			  return Result.build(2000,200,"截止时间不能早于发布时间!");
		  }
		

		
		return articleInfoService.insertArticle(accountInfo, AuthorityCode.CONTENT_ARTICLE_INSERT_AUTHORITY, articleinfo);

	}
	
	
	@ApiOperation(value = "文章详细信息", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Result getUpdateSelect(
			@ApiParam(value = "文章id", required = true)Integer articleid,
			@ApiParam(value = "请求来源(官网1/后台2)", required = true)Integer reqSource
			) throws MyException, ParseException {
		AccountInfo accountInfo = this.getAccountInfo();
		return articleInfoService.getUpdateSelect(accountInfo, AuthorityCode.CONTENT_ARTICLE_UPDATE_AUTHORITY, articleid,reqSource);
		
	}
	
	@ApiOperation(value = "修改", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateArticleInfo(
			@ApiParam(value = "文章id", required = true)  Integer articleid,
			@ApiParam(value = "栏目id", required = true)  Integer pagecolumnid,
			@ApiParam(value = "文章标题", required = true)  String articletitle,
			@ApiParam(value = "文章副标题", required = false)  String articlesubtitle,			
			@ApiParam(value = "关键词", required = false)  String keyword,
			@ApiParam(value = "文章简介", required = false)  String articleabstract,
			@ApiParam(value = "SEO简介", required = false) String seoabstract,
			@ApiParam(value = "缩略图文件id", required = false)  Long thumbnailfileid,
			@ApiParam(value = "正文", required = true)  String articlemainbody,
			@ApiParam(value = "附件文件id", required = false)  Long attachmentfileid,
			@ApiParam(value = "关联视频文件id", required = false)  Long livevediolistid,
			@ApiParam(value = "截止日期", required = true)  String deadlinetime,			
			@ApiParam(value = "发布时间", required = true)  String deploymenttime,
			@ApiParam(value = "发布人", required = true)   String deployperson,
			@ApiParam(value = "文章来源", required = true)  String originalsource,
			@ApiParam(value = "审核Y不审核N", required = true) String isauditpassed) throws MyException, IOException, ParseException {

		AccountInfo accountInfo = this.getAccountInfo();
		Articleinfo articleinfo = new Articleinfo();
		articleinfo.setArticleid(articleid);
		articleinfo.setPagecolumnid(pagecolumnid);
		articleinfo.setArticletitle(articletitle);
		articleinfo.setArticlesubtitle(articlesubtitle);
		articleinfo.setKeyword(keyword);
		articleinfo.setArticleabstract(articleabstract);
		articleinfo.setSeoabstract(seoabstract);
		articleinfo.setThumbnailfileid(thumbnailfileid);
		articleinfo.setArticlemainbody(articlemainbody);
		articleinfo.setAttachmentfileid(attachmentfileid);
		articleinfo.setLivevediolistid(livevediolistid);
		articleinfo.setDeployperson(deployperson);
		articleinfo.setOriginalsource(originalsource);
		articleinfo.setIsauditpassed(isauditpassed);
		articleinfo.setUpdateby(accountInfo.getAccount().getName());
		articleinfo.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		articleinfo.setUpdatetime(new Date());
		articleinfo.setIsdelete("N");
		//截止时间
		Date dateParse1 = null;
		//发布时间
		Date dateParse2 = null;
		
		if(pagecolumnid == 4) {
			//直播课程 时间不能为空
			if(deploymenttime == null || deadlinetime == null || deploymenttime.equals("") || deadlinetime.equals("")) {
				 return Result.build(20001,400,"直播时间不能为空!");
			}
			//不能跨天直播
			if(StringUtils.isNotBlank(deadlinetime)){
				   dateParse1 = DateUtils.dateParse(deadlinetime,DateUtils.MINUTE_PATTERN);
				   dateParse2 = DateUtils.dateParse(deploymenttime,DateUtils.MINUTE_PATTERN);
				   String dateFormat = DateUtils.dateFormat(dateParse1, DateUtils.DATE_PATTERN);
				   String dateFormat2 = DateUtils.dateFormat(dateParse2, DateUtils.DATE_PATTERN);
				  if(!dateFormat.equals(dateFormat2)) {
					  return Result.build(20001,400,"直播结束时间只能为当日!");
				  }
				  articleinfo.setDeadlinetime(dateParse1);
		        }
		}
		
		//关键字字数控制
				if(keyword != null) {
					if(keyword.length() > 10) {
						return Result.build(0000,0000,"关键字字数不能超过10个字");
					}
					
				}
		
		//发布时间为空默认为当前时间
				if(deploymenttime == null || deploymenttime.equals("")) {
					articleinfo.setDeploymenttime(new Date());
				}
		
		  if(StringUtils.isNotBlank(deadlinetime)){
			   dateParse1 = DateUtils.dateParse(deadlinetime,DateUtils.MINUTE_PATTERN);
			  if(dateParse1.getTime() < new Date().getTime()) {
				  return Result.build(20001,400,"截止时间不能为过去的时间!");
			  }
			  articleinfo.setDeadlinetime(dateParse1);
	        }
		  if(StringUtils.isNotBlank(deploymenttime)){
			   dateParse2 = DateUtils.dateParse(deploymenttime,DateUtils.MINUTE_PATTERN);
			  articleinfo.setDeploymenttime(dateParse2);
	        }
		//截止时间早于发布时间
		  if(dateParse1 != null && dateParse2 != null && dateParse1.getTime()<dateParse2.getTime()) {
			  return Result.build(2000,200,"截止时间不能早于发布时间!");
		  }
		
		
		return articleInfoService.updateArticle(accountInfo, AuthorityCode.CONTENT_ARTICLE_UPDATE_AUTHORITY, articleinfo);

	}
	
	@ApiOperation(value = "回收", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/recycle", method = RequestMethod.PUT)
	@ResponseBody
	public Result recycleArticle(
			@ApiParam(value = "要回收的文章id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			) throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		Articleinfo articleinfo = new Articleinfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			articleinfo.setArticleid(Integer.parseInt(id));
		Result result =	articleInfoService.recycleArticle(accountInfo, AuthorityCode.CONTENT_ARTICLE_RECYCLE_AUTHORITY, articleinfo);
		if(result.getStatus() != 200) {
			return result;
		}
		}
		return Result.succee();

	}
	
	@ApiOperation(value = "还原", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/restore", method = RequestMethod.PUT)
	@ResponseBody
	public Result restoreArticle(
			@ApiParam(value = "要还原的文章id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			) throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		Articleinfo articleinfo = new Articleinfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			articleinfo.setArticleid(Integer.parseInt(id));
		Result result =	articleInfoService.restoreArticle(accountInfo, AuthorityCode.CONTENT_ARTICLE_RESTORE_AUTHORITY, articleinfo);
		if(result.getStatus() != 200) {
			return result;
		}
		}
		return Result.succee();

	}
	
	@ApiOperation(value = "彻底删除", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteArticle(
			@ApiParam(value = "要删除的文章id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			) throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
		Result result =	articleInfoService.deleteArticle(accountInfo, AuthorityCode.CONTENT_ARTICLE_DELETE_AUTHORITY, Integer.parseInt(id));
		if(result.getStatus() != 200) {
			return result;
		}
		}
		return Result.succee();

	}
	
	
	@ApiOperation(value = "审核", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/audit", method = RequestMethod.PUT)
	@ResponseBody
	public Result auditArticle(
			@ApiParam(value = "要审核的文章id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			) throws MyException {
		

		AccountInfo accountInfo = this.getAccountInfo();
		Articleinfo articleinfo = new Articleinfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			articleinfo.setArticleid(Integer.parseInt(id));
		Result result =	articleInfoService.auditArticle(accountInfo, AuthorityCode.CONTENT_ARTICLE_AUDIT_AUTHORITY, articleinfo);
		if(result.getStatus() != 200) {
			return result;
		}
		}
		return Result.succee();

		
	}
	
	@ApiOperation(value = "直播课程接口", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/live", method = RequestMethod.POST)
	@ResponseBody
	public Result getArticleLiveByTime() {
		//栏目为直播课程
		return articleInfoService.getArticleLiveByTime(4);
		
	}
	
//	@ApiOperation(value = "正在发布的文章", httpMethod = "POST", produces = "application/json")
//	@RequestMapping(value = "/nowList", method = RequestMethod.POST)
//	@ResponseBody
//	public Result nowList( 
//			@ApiParam(value = "文章标题", required = false) String articletitle,
//			@ApiParam(value = "栏目ID", required = true) Integer pagecolumnid,
//			@ApiParam(value = "加载第几页")@RequestParam(required = false, defaultValue = "1") Integer page,
//			@ApiParam(value = "每一页加载记录条数") @RequestParam( required = false, defaultValue = "10") Integer pageSize
//			) {
//		
//		return articleInfoService.getArticleList(pagecolumnid, articletitle, page, pageSize);
//		
//	}
}
