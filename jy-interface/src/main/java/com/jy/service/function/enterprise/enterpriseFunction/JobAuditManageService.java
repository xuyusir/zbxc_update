package com.jy.service.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * 岗位审核处理接口
 *
 * @author chenye
 *
 */
public interface JobAuditManageService {
	/**
	 * 处理申请
	 *
	 * @return
	 */
	public Result updateJobApplication(AccountInfo accountInfo, String AUTHORITY_CODE, Integer ejdapplicationid,
			Integer applicationstatusid) throws MyException;


	/**
	 * 获取申请列表
	 *
	 * @return
	 */
	public Result getJobApplicationList(AccountInfo accountInfo, String AUTHORITY_CODE,String applicationstatusname,
			String search,String applicationtime,Integer page, Integer pageSize) throws MyException;

}
