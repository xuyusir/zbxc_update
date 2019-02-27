package com.jy.service.account.authority;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.account.authority.Authority;

/**
 * @ClassName:  AuthorityService   
 * @Description:权限接口 
 * @author: cheng fei
 * @date:   2018-09-15 10:01
 */
public interface AuthorityService {

	/**
	 * 查询权限列表
	 * @param accountInfo 当前登录用户
	 * @param menu_Id 菜单ID
	 * @return
	 * @throws MyException 
	 */
	Result getAuthorityList(AccountInfo accountInfo, String AUTHORITY_CODE, Integer menu_Id) throws MyException;

	
	/**
	 * 添加权限
	 * @param accountInfo 当前登录用户
	 * @param AUTHORITY_CODE 菜单权限编码
	 * @param authority 需要添加的权限
	 * @return
	 * @throws MyException 
	 */
	Result insertAuthority(AccountInfo accountInfo, String AUTHORITY_CODE, Authority authority) throws MyException;


	/**
	 * 修改权限
	 * @param accountInfo 当前登录用户
	 * @param authority 修改的权限
	 * @return
	 * @throws MyException 
	 */
	Result updateAuthority(AccountInfo accountInfo, String AUTHORITY_CODE, Authority authority) throws MyException;


	/**
	 * 查询权限
	 * @param accountInfo 当前登录的用户
	 * @param id 权限ID
	 * @return
	 * @throws MyException 
	 */
	Result getAuthority(AccountInfo accountInfo, Integer id) throws MyException;

	/**
	 * 检测权限固定编码
	 * @param id 需要排除的权限
	 * @param code 固定编码
	 * @return
	 */
	Result checkAuthorityCode(Integer id, String code);


	/**
	 * 删除权限
	 * @param accountInfo
	 * @param id
	 * @return
	 * @throws MyException 
	 */
	Result deleteAuthority(AccountInfo accountInfo, String AUTHORITY_CODE, Integer id) throws MyException;

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/23 23:35
	 * 描述 : 获取页面按钮权限
	 * @param accountInfo
	 * @param menu_id
	 * @return
	 */
	Result getPageAuthorityCode(AccountInfo accountInfo, Integer menu_id);
}
