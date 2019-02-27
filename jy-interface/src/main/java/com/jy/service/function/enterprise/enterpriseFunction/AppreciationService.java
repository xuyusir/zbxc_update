package com.jy.service.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.enterpriseFunction.Enterpriseappraise;

public interface AppreciationService {

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/16 2:33
	 * 描述 : 查询企业已入职人员列表
	 * @param accountInfo 当前登陆账号
	 * @param jobID 职位ID
	 * @param isEvaluate 是否已评价
	 * @param search 关键词:姓名/手机/岗位
	 * @param pageNumber 页码
	 * @param pageCount 每页条数
	 * @return
	 */
	public Result getList(AccountInfo accountInfo, Integer jobID, String isEvaluate, String search, Integer pageNumber, Integer pageCount);


	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/16 13:04
	 * 描述 : 企业评价
	 * @param accountInfo 当前登陆人员
	 * @param enterpriseappraise 要添加信息
	 * @return
	 */
	public Result insertEnterpriseAppraise(AccountInfo accountInfo, Enterpriseappraise enterpriseappraise) throws MyException;

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/17 22:22
	 * 描述 : 查询增值服务总数
	 * @param accountInfo
	 * @return
	 */
	Result getCount(AccountInfo accountInfo);

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/20 16:16
	 * 描述 : 查询所有评价接口
	 * @param accountInfo 当前登陆人员
	 * @param search 关键词:姓名
	 * @param searchDate 入职时间
	 * @param page 页码
	 * @param pageSize 每页条数
	 * @return
	 */
    Result getAppreciationAllList(AccountInfo accountInfo, String search, String searchDate, Integer page, Integer pageSize);
}
