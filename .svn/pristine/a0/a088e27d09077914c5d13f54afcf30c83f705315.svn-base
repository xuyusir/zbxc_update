package com.jy.service.content.positionManage;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.positionManage.Columnpostion;

/**
 * 推荐位管理
 * @author chenye
 *
 */
public interface PositionManageService {
	
	/**
	 * 获取推荐位列表不分页
	 * @throws MyException 
	 */
	public Result getPositionList() throws MyException;

	/**
	 * 获取推荐位列表
	 * @param page
	 * @param pageSize
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result getPositionList(AccountInfo accountInfo, String AUTHORITY_CODE,Integer page, Integer pageSize) throws MyException;
	
	
	/**
	 * 获取推荐位详情
	 * @param columnpostionid
	 * @return
	 * @throws MyException 
	 */
	public Result getPositionInfo(AccountInfo accountInfo, String AUTHORITY_CODE,Integer columnpostionid) throws MyException;
	
	/**
	 * 获取指定栏目下的推荐位内容
	 * @param pagecolumnid
	 * @return
	 * @throws MyException 
	 */
	public Result getAllPositionByColumn(AccountInfo accountInfo, String AUTHORITY_CODE,Integer pagecolumnid) throws MyException;

	/**
	 * 新增栏目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param columnpostion
	 * @return
	 * @throws MyException
	 */
	public Result insertPosition(AccountInfo accountInfo, String AUTHORITY_CODE,Columnpostion columnpostion) throws MyException;

	/**
	 * 修改推荐位
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param columnpostion
	 * @return
	 * @throws MyException
	 */
	public Result updatePosition(AccountInfo accountInfo, String AUTHORITY_CODE, Columnpostion columnpostion) throws MyException;

	/**
	 * 删除栏目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param columnpostionid
	 * @return
	 * @throws MyException 
	 */
	public Result deletePosition(AccountInfo accountInfo, String AUTHORITY_CODE, Integer columnpostionid) throws MyException;
	



	
}
