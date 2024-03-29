package com.jy.service.function.marketingFunction.registrationManagement;

import java.io.IOException;
import java.text.ParseException;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.marketingFunction.registrationManagement.Signincheck;

/**
 * 签到管理
 * @author chenye
 *
 */
public interface RegistrationManageService {
	

	/**
	 * 获取活动列表
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param votestatusid
	 * @param search
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws MyException 
	 */
	public Result getActivityList(AccountInfo accountInfo,String AUTHORITY_CODE,Integer votestatusid,  String search,Integer page, Integer pageSize) throws MyException;
	

	/**
	 * 添加活动
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param signincheck
	 * @return
	 * @throws MyException
	 * @throws IOException 
	 */
	public Result addActivity(AccountInfo accountInfo,String AUTHORITY_CODE,Signincheck signincheck,String voteUrl) throws MyException, IOException;
	

	/**
	 * 编辑活动
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param signincheck
	 * @return
	 * @throws MyException
	 */
	public Result updateActivity(AccountInfo accountInfo,String AUTHORITY_CODE,Signincheck signincheck) throws MyException;
	

	/**
	 * 删除活动
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param signincheckid
	 * @return
	 * @throws MyException
	 */
	public Result deleteActivity(AccountInfo accountInfo,String AUTHORITY_CODE,Integer signincheckid) throws MyException;
	

	/**
	 * 获取活动详细
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param signincheckid
	 * @return
	 * @throws MyException 
	 */
	public Result getActivityInfo(AccountInfo accountInfo,String AUTHORITY_CODE,Integer signincheckid) throws MyException;
	
	

	/**
	 * 导出列表预览(活动名称、活动时间、活动地点、姓名、电话、签到时间)
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param signincheckid
	 * @return
	 * @throws MyException 
	 */
	public Result exportListView(AccountInfo accountInfo,String AUTHORITY_CODE,Integer signincheckid) throws MyException;
	
	/**
	 * 导出列表(活动名称、活动时间、活动地点、姓名、电话、签到时间)
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param signincheckid
	 * @return
	 * @throws MyException 
	 * @throws ParseException 
	 */
	public Result exportList(AccountInfo accountInfo,String AUTHORITY_CODE,Integer signincheckid,String url) throws MyException, ParseException;
	
	
	/**
	 * 签到
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param signincheckid
	 * @return
	 * @throws MyException
	 * @throws ParseException 
	 */
	public Result signin(AccountInfo accountInfo,Integer signincheckid)throws MyException, ParseException;

}
