package com.jy.service.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * 招聘状态处理
 * @author chenye
 *
 */
public interface RecruitmentStatusProcessingService {

	/**
	 * 处理申请
	 * @param accountInfo 登录用户信息
	 * @param AUTHORITY_CODE 权限编码
	 * @param ids 处理招聘状态申请id列表，用","号隔开
	 * @param applicationStatus 服务申请状态
	 * @param interviewDate 面试时间
	 * @return
	 * @throws MyException
	 */
	public Result updateProcessingRecruitmentStatus(AccountInfo accountInfo, String AUTHORITY_CODE, String ids, Integer applicationStatus, String interviewDate) throws MyException;



	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/8 19:15
	 * 描述 : 加载职位申请列表
	 * @param applicationStatus 申请状态
	 * @param applicationStatus 简历处理流程状态
	 * @param applicationTime 申请时间:模糊查询当天记录
	 * @param search 关键词: 申请职位人姓名/电话
	 * @param page 页码
	 * @param pageSize 每页条数
	 * @return
	 * @throws MyException
	 */
	public Result getJobApplicationList(Integer applicationStatus,Integer personDeliveryStatus, String applicationTime, String search ,Integer page, Integer pageSize) throws MyException;

}
