package com.jy.service.function.person.memberFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.person.memberFunction.Complaintapplication;

/**
 * @ClassName:  ComplaintApplicationService   
 * @Description:会员功能-投诉建议处理Service 
 * @author: chenye
 * @date:   2018-09-04 17:54
 */
public interface ComplaintApplicationService {
	
	/**
	 * 处理投诉建议(根据投诉建议申请表主键id改变申请状态)
	 * 
	 * @return
	 */
	public Result processingComplaint(AccountInfo accountInfo, String AUTHORITY_CODE, Long complaintapplicationid,
			Integer applicationStatusID) throws MyException;

	
	/**
	 * 获取投诉建议列表(全部)
	 * 
	 * @return
	 */
	public Result getComplaintApplicationList(AccountInfo accountInfo, String AUTHORITY_CODE,String applicationstatusname,
			String targetSearch,String personSearch,String complainttime,Integer page, Integer pageSize) throws MyException;


	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/20 0:13
	 * 描述 : 添加投诉建议
	 * @param accountInfo 当前的登陆人员
	 * @param complaintapplication 投书建议内容
	 * @param code 验证码
	 * @param ip 登陆ip
	 * @return
	 */
	Result insertComplaintApplication(AccountInfo accountInfo, Complaintapplication complaintapplication, String code, String ip) throws MyException;
}
