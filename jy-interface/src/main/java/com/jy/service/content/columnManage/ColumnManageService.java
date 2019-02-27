package com.jy.service.content.columnManage;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.columnManage.Pagecolumn;

/**
 * 栏目管理Service
 * @author chenye
 *
 */
public interface ColumnManageService {
	
	
	/**
	 * 获取栏目列表不分页
	 * @return
	 * @throws MyException 
	 */
	public Result getColumnList() throws MyException;
	
	/**
	 * 获取栏目列表
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws MyException 
	 */
	public Result getColumnList(AccountInfo accountInfo, String AUTHORITY_CODE,Integer page, Integer pageSize) throws MyException;
	
	
	/**
	 * 获取栏目详情
	 * @param pagecolumnid
	 * @return
	 * @throws MyException 
	 */
	public Result getColumnInfo(AccountInfo accountInfo, String AUTHORITY_CODE,Integer pagecolumnid) throws MyException;
	
	
	
	/**
	 * 获取指定导航页下的栏目
	 * 
	 * @param pageid
	 * @return
	 */
	public Result getAllColumnByPageid(AccountInfo accountInfo,Integer pageid)throws MyException;
	

	/**
	 * 新增栏目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param Pagecolumn
	 * @return
	 * @throws MyException
	 */
	public Result insertColumn(AccountInfo accountInfo, String AUTHORITY_CODE, Pagecolumn pageColumn) throws MyException;

	/**
	 * 修改栏目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param Pagecolumn
	 * @return
	 * @throws MyException
	 */
	public Result updateColumn(AccountInfo accountInfo, String AUTHORITY_CODE, Pagecolumn pageColumn) throws MyException;

	/**
	 * 删除栏目
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param pagecolumnid
	 * @return
	 * @throws MyException 
	 */
	public Result deleteColumn(AccountInfo accountInfo, String AUTHORITY_CODE, Integer pagecolumnid) throws MyException;
	



}
