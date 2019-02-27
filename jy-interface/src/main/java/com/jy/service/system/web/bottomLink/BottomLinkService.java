package com.jy.service.system.web.bottomLink;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.web.bottomLink.Bottomlink;
import com.jy.entiy.system.web.bottomLink.Bottomlinktype;

/**
 * 底部链接管理
 * @author chenye
 *
 */
public interface BottomLinkService {



	/**
	 * 加载页面操作权限(按钮是否显示)
	 * @param accountInfo 当前登录用户
	 * @param menu_id 菜单ID
	 * @return
	 */
	Result getAuthority(AccountInfo accountInfo, Integer menu_id);

	/**
	 * 获取底部链接类目下拉框
	 * @return
	 * @throws MyException
	 */
	public Result getAllType() throws MyException;

	/**
	 * 加载所有底部链接
	 * @return
	 * @throws MyException
	 */
	public Result getAllBottomLink() throws MyException;

	/**
	 * 新增类目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param bottomlinkType
	 * @return
	 * @throws MyException
	 */
	public Result insertBottomLinkType(AccountInfo accountInfo, String AUTHORITY_CODE, Bottomlinktype bottomlinkType) throws MyException;


	/**
	 * 编辑类目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param bottomlinkType
	 * @return
	 * @throws MyException
	 */
	public Result updateBottomLinkType(AccountInfo accountInfo, String AUTHORITY_CODE, Bottomlinktype bottomlinkType) throws MyException;

	/**
	 * 删除类目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param id
	 * @return
	 * @throws MyException
	 */
	public Result deleteBottomLinkType(AccountInfo accountInfo, String AUTHORITY_CODE, Integer id) throws MyException;


	/**
	 * 获取全部底部链接(条件分页)
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param page
	 * @param pageSize
	 * @param typeid 类目id
	 * @return
	 * @throws MyException
	 */
	public Result getBottomLinkList(AccountInfo accountInfo, String AUTHORITY_CODE,Integer page, Integer pageSize,Integer typeid) throws MyException;



	/**
	 * 获取底部链接详情
	 * @param id
	 * @return
	 * @throws MyException
	 */
	public Result getBottomLinkInfo(Integer id) throws MyException;



	/**
	 * 新增底部链接
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param bottomlink
	 * @return
	 * @throws MyException
	 */
	public Result insertBottomLink(AccountInfo accountInfo, String AUTHORITY_CODE, Bottomlink bottomlink) throws MyException;

	/**
	 * 修改底部链接
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param bottomlink
	 * @return
	 * @throws MyException
	 */
	public Result updateBottomLink(AccountInfo accountInfo, String AUTHORITY_CODE, Bottomlink bottomlink) throws MyException;


	/**
	 * 删除底部链接
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param id
	 * @return
	 * @throws MyException
	 */
	public Result deleteBottomLink(AccountInfo accountInfo, String AUTHORITY_CODE, Integer id) throws MyException;



}
