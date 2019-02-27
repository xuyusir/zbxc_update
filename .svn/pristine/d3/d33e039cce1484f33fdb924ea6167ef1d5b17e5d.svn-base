package com.jy.service.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * 企业服务申请处理接口
 * 
 * @author chenye
 *
 */
public interface EnterpriseServiceApplicationService {

	

	/**
	 * 处理申请
	 * @param accountInfo 登录用户信息
	 * @param AUTHORITY_CODE 权限码
	 * @param talentpoolapplicationid 人才库申请表自增长主键
	 * @param applicationstatusid 人才库申请状态id
	 * @return
	 * @throws MyException
	 */
	public Result processingEnterpriseService(AccountInfo accountInfo, String AUTHORITY_CODE, Integer talentpoolapplicationid,
			Integer applicationstatusid) throws MyException;

	

	/**
	 * 获取申请列表
	 * @param accountInfo 登录用户信息
	 * @param AUTHORITY_CODE 权限码
	 * @param applicationstatusname 申请状态
	 * @param search 搜索条件
	 * @param applcationdate 申请时间
	 * @param page 页码
	 * @param pageSize 每页展示条数
	 * @return
	 * @throws MyException
	 */
	public Result getEnterpriseServiceList(AccountInfo accountInfo, String AUTHORITY_CODE,String applicationstatusname,
			String search,String applcationdate,Integer page, Integer pageSize) throws MyException;
}
