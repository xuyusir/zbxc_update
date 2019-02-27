package com.jy.controller.content.navbarManage;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.navbarManage.Page;
import com.jy.service.content.navbarManage.NavbarManageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: NavbarManageController
 * @author: chenye
 * @date: 2018-09-18 11:23
 */
@Controller
@RequestMapping("content/navbar")
@Api(tags = "content.NavbarManageController", description = "内容-导航页管理")
public class NavbarManageController extends BaseController {

	// 服务代码
	private static final String CONTROLLER_CODE = "CONTROLLER_NAVBAR_MANAGE";

	@Resource
	private NavbarManageService navbarManageService;
	
	
	
	@ApiOperation(value = "根据导航页种类加载导航页", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	@ResponseBody
	public Result loadNavbar(@ApiParam(value = "导航页类型(W官网P个人E企业)", required = true)String remark)
			throws MyException {

		return navbarManageService.loadNavbar(remark);
	}
	
	@ApiOperation(value = "根据导航页种类加载导航页所属下拉框", httpMethod = "PATCH", produces = "application/json")
	@RequestMapping(value = "/load", method = RequestMethod.PATCH)
	@ResponseBody
	public Result loadNavbarByType(@ApiParam(value = "导航页类型(W官网P个人E企业)", required = true)String remark)
			throws MyException {

		return navbarManageService.loadNavbarByType(remark);
	}
	
	@ApiOperation(value = "获取导航页列表不分页", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/all/list", method = RequestMethod.GET)
	@ResponseBody
	public Result getNavbarList()
			throws MyException {

		return navbarManageService.getNavbarList();
	}

	@ApiOperation(value = "获取导航页列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getNavbarList(
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {

		return navbarManageService.getNavbarList(page, pageSize);
	}
	
	@ApiOperation(value = "导航页详情", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Result getNavbarInfo(@ApiParam(value = "主键id", required = true) Integer pageid) throws MyException {

		return navbarManageService.getNavbarInfo(pageid);
	}
	
	@ApiOperation(value = "检查序号", httpMethod = "PATCH", produces = "application/json")
	@RequestMapping(value = "/displayorder", method = RequestMethod.PATCH)
	@ResponseBody
	public Result checkDisplayorder(@ApiParam(value = "主键id(修改时传)", required = false) Integer pageid,
			@ApiParam(value = "排序码", required = true) Integer displayorder,
			@ApiParam(value = "种类", required = true) String remark,
			@ApiParam(value = "父级id", required = true) Integer parentid
			) throws MyException {

		return navbarManageService.checkDisplayorder(parentid,remark, pageid,displayorder);
	}
	

//	@ApiOperation(value = "添加导航页", httpMethod = "POST", produces = "application/json")
//	@RequestMapping(value = "", method = RequestMethod.POST)
//	@ResponseBody
//	public Result insertNavbar(@RequestBody Page page) throws MyException {
//		AccountInfo accountInfo = this.getAccountInfo();
//		return navbarManageService.insertNavbar(accountInfo, AuthorityCode.CONTENT_NAVBAR_INSERT_AUTHORITY, page);
//	}

	@ApiOperation(value = "修改导航页", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateNavbar(@RequestBody Page page) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return navbarManageService.updateNavbar(accountInfo, AuthorityCode.CONTENT_NAVBAR_UPDATE_AUTHORITY, page);
	}

//	@ApiOperation(value = "删除导航页", httpMethod = "DELETE", produces = "application/json")
//	@RequestMapping(value = "", method = RequestMethod.DELETE)
//	@ResponseBody
//	public Result deleteNavbar(@ApiParam(value = "主键id", required = true) Integer pageid) throws MyException {
//
//		AccountInfo accountInfo = this.getAccountInfo();
//		return navbarManageService.deleteNavbar(accountInfo, AuthorityCode.CONTENT_NAVBAR_DELETE_AUTHORITY, pageid);
//	}
	
	@ApiOperation(value = "删除导航页Banner", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/banner", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteBanner(@ApiParam(value = "主键id", required = true) Integer bannerid) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return navbarManageService.deleteBanner(accountInfo, CONTROLLER_CODE, bannerid);
	}
	
	@ApiOperation(value = "根据导航页id加载子导航", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/loadc", method = RequestMethod.GET)
	@ResponseBody
	public Result loadNavbar(@ApiParam(value = "导航页id", required = true)Integer pageid)
			throws MyException {

		return navbarManageService.getCpage(pageid);
	}
}
