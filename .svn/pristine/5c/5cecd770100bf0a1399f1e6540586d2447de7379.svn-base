package com.jy.service.content.navbarManage;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.navbarManage.Page;

/**
 * 导航管理Service
 * 
 * @author chenye
 *
 */
public interface NavbarManageService {
	
	/**
	 * 根据导航页种类加载导航页
	 * 
	 * @return
	 */
	public Result loadNavbar(String remark);
	
	
	/**
	 * 获取导航页列表不分页
	 * 
	 * @return
	 */
	public Result getNavbarList();
	

	/**
	 * 根据导航页种类加载导航页所属下拉框
	 * 
	 * @return
	 */
	public Result loadNavbarByType(String remark);

	/**
	 * 获取导航页列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Result getNavbarList(Integer page, Integer pageSize);
	
	
	/**
	 * 获取导航页详情
	 * @param pageid
	 * @return
	 */
	public Result getNavbarInfo(Integer pageid);
	
	/**
	 * 检查序号是否存在
	 * @param displayorder
	 * @param parentid
	 * @param remark
	 * @param pageid
	 * @return
	 */
	public Result checkDisplayorder(Integer parentid,String remark,Integer pageid,Integer displayorder);

	/**
	 * 新增导航页
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param page
	 * @return
	 * @throws MyException
	 */
	public Result insertNavbar(AccountInfo accountInfo, String AUTHORITY_CODE, Page page) throws MyException;

	/**
	 * 修改导航页
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param page
	 * @return
	 * @throws MyException
	 */
	public Result updateNavbar(AccountInfo accountInfo, String AUTHORITY_CODE, Page page) throws MyException;

	/**
	 * 删除导航页
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param pageid
	 * @return
	 * @throws MyException 
	 */
	public Result deleteNavbar(AccountInfo accountInfo, String AUTHORITY_CODE, Integer pageid) throws MyException;
	
	/**
	 * 删除Banner
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param bannerid
	 * @return
	 * @throws MyException 
	 */
	public Result deleteBanner(AccountInfo accountInfo, String AUTHORITY_CODE, Integer bannerid) throws MyException;
	
	
	/**
	 * 获取子导航
	 * @param pageid
	 * @return
	 */
	public Result getCpage(Integer pageid);

}
