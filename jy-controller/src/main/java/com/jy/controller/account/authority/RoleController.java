package com.jy.controller.account.authority;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.account.authority.Role;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.service.account.authority.RoleService;
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
 * @ClassName:  RoleController   
 * @Description:角色管理接口
 * @author: cheng fei
 * @date:   2018-08-03 01:09
 */
@Controller
@RequestMapping("/account/role")
@Api(tags = "account.authority.RoleController", description = "账号-权限-用户组模块")
public class RoleController extends BaseController{
	
	@Resource
	private RoleService roleService;
	
	
	@ApiOperation(value = "查询用户组接口", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Result getRole(
			@ApiParam(value = "用户组id", required = true) @RequestParam(required = true) Integer role_id
			) {
        AccountInfo accountInfo = this.getAccountInfo();
        return roleService.getRoleById(accountInfo, role_id);
	}
	
	/**
	 * 添加用户组
	 * @return
	 */
	@ApiOperation(value = "添加用户组接口", httpMethod = "POST",produces = "application/json")
	@RequestMapping(value = "",method = RequestMethod.POST)
	@ResponseBody
	public Result insertRole(
			 @ApiParam(value = "用户组名", required = true) @RequestParam(required = true) String name
			) throws MyException{
		Role role = new  Role();
		role.setName(name);
		AccountInfo accountInfo = this.getAccountInfo();
		return roleService.insertRole(accountInfo,  AuthorityCode.SYSTEM_ROLE_INSERT_AUTHORITY, role);
	}
	
	/**
	 * 修改用户组
	 * @return
	 */
	@ApiOperation(value = "修改用户组接口", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "",method = RequestMethod.PUT)
	@ResponseBody
	public Result updateRole(
			 @ApiParam(value = "用户组id", required = true) @RequestParam(required = true) Integer role_id,
			 @ApiParam(value = "用户组名", required = true) @RequestParam(required = true)String name
			) throws MyException{
		Role role = new Role();
		role.setRoleid(role_id);
		role.setName(name);
		AccountInfo accountInfo = this.getAccountInfo();
		return roleService.updateRole(accountInfo, AuthorityCode.SYSTEM_ROLE_UPDATE_AUTHORITY, role);
	}
	
	/**
	 * 删除用户组
	 * @return
	 */
	@ApiOperation(value = "删除用户组接口", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "",method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteRole(
			@ApiParam(value = "删除用户组ID列表,用\",\"号隔开", required = true) @RequestParam(required = true) String role_ids
			) throws MyException{
		AccountInfo accountInfo = this.getAccountInfo();
		return roleService.deleteRole(accountInfo,  AuthorityCode.SYSTEM_ROLE_AUTHORITY_DELETE_AUTHORITY, role_ids);
	}
	
	/**
	 * 加载用户组列表
	 * @return
	 * @throws MyException 
	 */
	@ApiOperation(value = "加载用户组组列表接口", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getRoleList(
			@ApiParam(value = "关键词,只对用户组名模糊查询", required = false) @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam(value = "页码", required = false) @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每页显示条数", required = false) @RequestParam(required = false, defaultValue = "10") Integer pageSize
			) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return roleService.getRoleList(accountInfo, search, page, pageSize);
	}
	
	@ApiOperation(value = "加载用户组下拉列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public Result getRoleSelect() {
        AccountInfo accountInfo = this.getAccountInfo();
        return roleService.getRoleSelect(accountInfo);
	}
	
	@ApiOperation(value = "加载用户组权限接口", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/authority", method = RequestMethod.GET)
	@ResponseBody
	public Result getRoleAuthority(
			@ApiParam(value = "用户组ID", required = true) @RequestParam Integer role_id
			) {
		AccountInfo accountInfo = this.getAccountInfo();
		return roleService.getRoleAuthority(accountInfo, role_id);
	}
	
	@ApiOperation(value = "修改用户组权限接口", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/authority", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateRoleAuthority(
			@ApiParam(value = "用户组ID", required = true) @RequestParam Integer role_id,
			@ApiParam(value = "菜单ID列表,用\",\"隔开", required = true) @RequestParam String menu_ids,
			@ApiParam(value = "权限ID列表,用\",\"隔开", required = true) @RequestParam String authority_ids
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return roleService.updateRoleAuthority(accountInfo, AuthorityCode.SYSTEM_ROLE_UPDATE_AUTHORITY_AUTHORITY, role_id,menu_ids, authority_ids);
	}


	@RequestMapping(value = "/check/role/name", method = RequestMethod.PATCH)
	@ResponseBody
	@ApiOperation(value = "检测用户组名称是否可用", httpMethod = "PATCH", produces = "application/json")
	public Result checkRoleName(
			@ApiParam(value = "要排除的用户组ID", required = false) @RequestParam(required = false) Integer role_id,
			@ApiParam(value = "用户组名称", required = true) @RequestParam(required = true) String role_name
	){
		return  roleService.checkRoleName(role_id, role_name);
	}

	@RequestMapping(value = "/status", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "启用/禁用用户组接口", httpMethod = "PUT", produces = "application/json")
	public Result updateRoleStatus(
			@ApiParam(value = "用户组ID列表,用\",\"号隔开", required = false) @RequestParam(required = false) String role_ids,
			@ApiParam(value = "状态:0禁用/1启用", required = true) @RequestParam(required = true) Integer status
	) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return  roleService.updateRoleStatus(accountInfo, AuthorityCode.SYSTEM_ROLE_UPDATE_STATUS_AUTHORITY,role_ids, status);
	}
	
	
}
