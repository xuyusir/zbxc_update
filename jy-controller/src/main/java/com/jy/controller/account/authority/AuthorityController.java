package com.jy.controller.account.authority;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.account.authority.Authority;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.service.account.authority.AuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName:  AuthorityController   
 * @Description:权限接口
 * @author: cheng fei
 * @date:   2018-09-15 10:03
 */

@Controller
@RequestMapping("/account/authority")
@Api(tags = "account.authority.AuthorityController", description = "账号-权限-权限模块")
public class AuthorityController extends BaseController{
	
	@Resource
	private AuthorityService authorityService;
	
	@ApiOperation(value = "添加权限", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertAuthority(
			@ApiParam(value = "菜单ID", required = true) @RequestParam(required = true) Integer menu_id,
			@ApiParam(value = "权限名", required = true) @RequestParam(required = true) String name,
			@ApiParam(value = "固定编码", required = true) @RequestParam(required = true) String code,
			@ApiParam(value = "排序码", required = true) @RequestParam(required = true) Integer display_order,
			@ApiParam(value = "备注", required = false) @RequestParam(required = false) String remark
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Authority authority = new Authority();
		authority.setMenuid(menu_id);
		authority.setName(name);
		authority.setCode(code);
		authority.setDisplayorder(display_order);
		authority.setRemark(remark);
		
		return authorityService.insertAuthority(accountInfo, AuthorityCode.SYSTEM_AUTHORITY_INSERT_AUTHORITY, authority);
	}
	
	@ApiOperation(value = "修改权限", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateAuthority(
			@ApiParam(value = "权限ID", required = true) @RequestParam(required = true) Integer id,
			@ApiParam(value = "菜单ID", required = false) @RequestParam(required = false) Integer menu_id,
			@ApiParam(value = "权限名", required = false) @RequestParam(required = false) String name,
			@ApiParam(value = "固定编码", required = false) @RequestParam(required = false) String code,
			@ApiParam(value = "排序码", required = false) @RequestParam(required = false) Integer display_order,
			@ApiParam(value = "备注", required = false) @RequestParam(required = false) String remark
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Authority authority = new Authority();
		authority.setId(id);
		authority.setMenuid(menu_id);
		authority.setName(name);
		authority.setCode(code);
		authority.setDisplayorder(display_order);
		authority.setRemark(remark);
		return authorityService.updateAuthority(accountInfo, AuthorityCode.SYSTEM_AUTHORITY_UPDATE_AUTHORITY, authority);
	}
	
	@ApiOperation(value = "查询权限", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Result getAuthority(
			@ApiParam(value = "权限ID", required = true) @RequestParam(required = true) Integer id
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return authorityService.getAuthority(accountInfo, id);
	}
	
	@ApiOperation(value = "删除权限", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteAuthority(
			@ApiParam(value = "权限ID", required = true) @RequestParam(required = true) Integer id
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return authorityService.deleteAuthority(accountInfo, AuthorityCode.SYSTEM_AUTHORITY_DELETE_AUTHORITY, id);
	}
	
	
	
	@ApiOperation(value = "获取权限列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getAuthorityList(
			@ApiParam(value = "菜单ID", required = true) @RequestParam Integer menu_id
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return authorityService.getAuthorityList(accountInfo, AuthorityCode.SYSTEM_AUTHORITY_SELECT_LIST_AUTHORITY, menu_id);
	}
	
	
	@ApiOperation(value = "检测权限固定编码", httpMethod = "PATCH", produces = "application/json")
	@RequestMapping(value = "/check/code", method = RequestMethod.PATCH)
	@ResponseBody
	public Result checkAuthorityCode(
			@ApiParam(value = "需要排除的权限ID", required = false) @RequestParam(required = false,defaultValue = "") Integer id,
			@ApiParam(value = "固定编码", required = true) @RequestParam(required = true,defaultValue = "") String code
			) {
		return authorityService.checkAuthorityCode(id, code);
	}


	@ApiOperation(value = "获取页面按钮权限接口", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/page/authority", method = RequestMethod.GET)
	@ResponseBody
	public Result getPageAuthorityCode(
			@ApiParam(value = "菜单ID", required = true) @RequestParam(required = true) Integer menu_id
			) {
        AccountInfo accountInfo = this.getAccountInfo();
        return authorityService.getPageAuthorityCode(accountInfo, menu_id);
	}


}
