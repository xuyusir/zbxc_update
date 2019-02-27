package com.jy.service.function.person.memberFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * @ClassName:  MemberInfoManagementService   
 * @Description:会员信息管理接口 
 * @author: chenye
 * @date:   2018-09-04 10:34
 */
public interface MemberInfoManagementService {
	
	/**
	 * 获取会员信息列表
	 * @param AUTHORITY_CODE
	 * @param accountInfo
	 * @param account
	 * @return
	 * @throws MyException 
	 */
	public Result getMemberInfoList(String AUTHORITY_CODE,AccountInfo accountInfo,String search,Integer page, Integer pageSize) throws MyException;
	
	
	/**
	 * 加载报告类型下拉列表
	 * @return
	 */
	public Result loadPersonreporttype();
	
	
	/**
	 * 上传报告
	 * @return
	 * @throws MyException 
	 */
	public Result uploadReport(String AUTHORITY_CODE,AccountInfo accountInfo,Long accountID, Integer reportTypeID,Long reportFileID) throws MyException;
	
	
	/**
	 * 根据会员id和报告类型id获取报告文件
	 * @param AUTHORITY_CODE
	 * @param accountInfo
	 * @param accountid
	 * @param personreporttypeid
	 * @return
	 * @throws MyException 
	 */
	public Result getMemberPersonreport(String AUTHORITY_CODE,AccountInfo accountInfo,Long accountid,Integer personreporttypeid) throws MyException;
}
