package com.jy.service.function.person.memberFunction;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * 会员服务申请处理接口
 * 
 * @author chenye
 *
 */
public interface ServiceApplicationService {

	/**
	 * 处理申请(根据服务申请表主键id改变申请状态)
	 * 
	 * @return
	 * @throws ParseException 
	 */
	public Result processing(AccountInfo accountInfo, String AUTHORITY_CODE, Long serviceApplicationID,
			Integer applicationStatusID) throws MyException, ParseException;

	
	/**
	 * 获取服务申请列表
	 * 
	 * @return
	 */
	public Result getServiceApplicationList(AccountInfo accountInfo, String AUTHORITY_CODE,String applicationstatusname,
			String search,String applicationtime, String appointdate,Integer page, Integer pageSize) throws MyException;

	
	/**
	 * 导出列表
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param signincheckid
	 * @param url
	 * @return
	 * @throws MyException
	 * @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 */
	public Result exportList(AccountInfo accountInfo, String AUTHORITY_CODE, String applicationstatusname, String search, String applicationtime, String appointdate, Integer page,
			Integer pageSize, String url) throws MyException, ParseException, UnsupportedEncodingException;
}
