package com.jy.service.function.person.memberFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * @ClassName:  DeliverMannageService   
 * @Description:会员功能-投递审核处理Service 
 * @author: chenye
 * @date:   2018-09-03 10:45
 */
public interface DeliverMannageService {

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/12 20:05
	 * 描述 :
	 *
	 * @param accountInfo         当前登陆用户
	 * @param AUTHORITY_CODE      权限编码
	 * @param ids                 要处理的投递申请ID
	 * @param applicationStatusID 处理的状态值
	 * @return
	 * @throws MyException
	 */
	public Result processingDelivery(AccountInfo accountInfo, String AUTHORITY_CODE, String ids, Integer applicationStatusID) throws MyException;


	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/12 19:26
	 * 描述 : 获取投递申请列表
	 *
	 * @param applicationStatus 申请状态:0全部,1.待处理,2.已处理,3.已拒绝
	 * @param isMember          是否是会员:0全部,1.是, 2.不是
	 * @param applicationTime   申请时间:模糊查询当天记录
	 * @param search            键词: 申请职位人姓名/岗位
	 * @param page              页码
	 * @param pageSize          每页加载记录数
	 * @return
	 * @throws MyException
	 */
	public Result getDeliveryApplicationList(Integer applicationStatus, Integer isMember, String applicationTime, String search, Integer page, Integer pageSize) throws MyException;
}
