package com.jy.service.function.enterprise.recruitment.rz;


import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.recruitment.Enterpriserecruitingprocess;

/**
 *
 * @ClassName:  PersonDeliveryApplication
 * @Description:简历投递申请接口
 * @author: cheng fei
 * @date:   2018-09-07 11:07
 */

public interface PersonDeliveryApplicationService {

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/7 23:54
	 * 描述 : 获取企业招聘职位简历列表
	 * @param accountInfo 当前登陆人员
	 * @param jobID 职位ID
	 * @param search 关键词:模糊查询姓名,手机号,学校
	 * @param personDeliveryStatusID 简历处理流程状态
	 * @param page 页码
	 * @param pageSize 每页条数
	 * @return
	 */
	Result getPersonDeliveryApplicationList(AccountInfo accountInfo, Integer jobID, String search, Integer personDeliveryStatusID, Integer page, Integer pageSize);

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/7 22:41
	 * 描述 : 投递简历接口
	 * @param accountInfo 当前登陆账号
	 * @param jobID 职位ID
	 * @param accountID 投递人账号ID
	 * @return
	 * @throws MyException
	 */
    Result insertPersonDeliveryApplication(AccountInfo accountInfo, Integer jobID, Long accountID) throws MyException;

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/8 15:55
	 * 描述 : 检测简历是否投递接口
	 * @param jobID
	 * @param accountID
	 * @return
	 */
	Result checkPersonDeliveryApplication(Integer jobID, Long accountID);

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/8 16:28
	 * 描述 : 修改企业招聘流程状态
	 * @param accountInfo 当前登陆人员
	 * @param ids 企业招聘职位表ID列表,用","隔开
	 * @param status 简历投递流程状态:1.主动投递-待处理,2.主动投递-不合适,3.面试-进行中,4.面试-不合适,5.录用-待入职,6.录用-已入职,7.录用-未入职
	 * @return
	 * @throws MyException
	 */
	Result updateDeliverStatus(AccountInfo accountInfo, String ids, Integer status) throws MyException;


	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/11 17:45
	 * 描述 : 查询企业招聘总数
	 * @param accountInfo 当前登陆人员
	 * @param personDeliveryStatusID 招聘流程状态
	 * @return
	 */
    Result getPersonDeliveryApplicationCount(AccountInfo accountInfo, Integer personDeliveryStatusID);

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/15 15:35
	 * 描述 : 修改确认入职时间接口
	 * @param accountInfo 当前登陆人员
	 * @param enterpriserecruitingprocess 要修改的企业招聘信息
	 * @return
	 */
	Result updateConfirmEntryTime(AccountInfo accountInfo, Enterpriserecruitingprocess enterpriserecruitingprocess) throws MyException;

	/**
	 * 作者: cheng fei
	 * 创建日期: 2019/1/4 16:17
	 * 描述 : 修改面试时间
	 * @param accountInfo 当前登陆人员
	 * @param id 企业招聘表ID
	 * @param interviewTime 面试时间
	 * @return
	 */
	Result updateInterviewTime(AccountInfo accountInfo,Long id, String interviewTime) throws MyException;
}
