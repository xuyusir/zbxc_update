package com.jy.service.account.authority;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.account.authority.Role;

/**
 * @ClassName: RoleService
 * @Description:角色管理服务接口
 * @author: cheng fei
 * @date: 2018-08-03 01:15
 */
public interface RoleService {


	/**
	 *
	 * 功能描述: 检测用户组名称是否可用
	 *
	 * @param: role_id 要排除的用户组ID
	 * @param: role_name 用户组名称
	 * @return:
	 * @auther: cheng fei
	 * @date: 2018/10/28 15:39
	 */
    Result checkRoleName(Integer role_id, String role_name);

    /**
	 * 查询用户组列表
	 * @param accountInfo 当前登陆用户
	 * @param search 关键词
	 * @param page 页码
	 * @param page_size 每页条数 
	 * @return
	 * @throws MyException
	 */
	Result getRoleList(AccountInfo accountInfo, String search, Integer page, Integer page_size) throws MyException;

	/**
	 * 添加一个用户组
	 * 
	 * @param accountInfo
	 * @param role
	 * @return
	 * @throws MyException
	 */
	Result insertRole(AccountInfo accountInfo, String AUTHORITY_CODE, Role role) throws MyException;

	/**
	 * 修改一个用户组
	 * 
	 * @param accountInfo
	 * @param role
	 * @param AUTHORITY_CODE
	 * @param role
	 * @return
	 * @throws MyException
	 */
	Result updateRole(AccountInfo accountInfo, String AUTHORITY_CODE, Role role) throws MyException;

	/**
	 * 删除一个用户组
	 * 
	 * @param accountInfo
	 * @param role_ids
	 * @return
	 * @throws MyException
	 */
	Result deleteRole(AccountInfo accountInfo, String AUTHORITY_CODE, String role_ids) throws MyException;

	/**
	 * 加载页面操作权限
	 * @param accountInfo 当前登录用户
	 * @param menu_id 菜单ID
	 * @return
	 */
	Result getAuthority(AccountInfo accountInfo, Integer menu_id);

	/**
	 * 根据权限组id查询权限组信息
	 * @param accountInfo
	 * @param role_id
	 * @return
	 */
	Result getRoleById(AccountInfo accountInfo, Integer role_id);

	/**
	 * 获取用户组的下拉列表
	 * @param accountInfo
	 * @return
	 */
	Result getRoleSelect(AccountInfo accountInfo);

	
	/**
	 * 获取用户组的权限
	 * @param accountInfo 当前登录人员
	 * @param role_id 用户组ID
	 * @return
	 */
	Result getRoleAuthority(AccountInfo accountInfo, Integer role_id);

	/**
	 * 修改用户组权限
	 * @param accountInfo 当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param role_id 用户组ID
	 * @param menu_ids 菜单ID列表,用","隔开
	 * @param authority_ids 权限ID列表,用","隔开
	 * @return
	 * @throws MyException 
	 */
	Result updateRoleAuthority(AccountInfo accountInfo, String AUTHORITY_CODE, Integer role_id, String menu_ids, String authority_ids) throws MyException;

	/**
	 * 修改用户组状态
	 * @param accountInfo 当前登陆人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param role_ids 用户组ID
	 * @param status 状态
	 * @return
	 */
    Result updateRoleStatus(AccountInfo accountInfo, String AUTHORITY_CODE,String role_ids, Integer status) throws MyException;
}
