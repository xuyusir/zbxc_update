package com.jy.service.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

public interface TalentPoolService {
	
	/**
	 * 申请开启人才库服务
	 * @param accountInfo
	 * @return
	 */
	public Result insertApplicationServer(AccountInfo accountInfo) throws MyException;
	
	/**
	 * 查看人才库开启情况
	 * @param account
	 * @return
	 */
	public Result server(AccountInfo account) throws MyException;
	
	/**
	 * 申请下载简历
	 * @param accountInfo
	 * @return
	 */
	public Result updateServerDown(AccountInfo accountInfo) throws MyException;

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/15 0:39
	 * 描述 : 查看人才库所有简历
	 * @param accountInfo 当前登陆人员
	 * @param cityCode 期望工作城市编码
	 * @param search 关键词:模糊查询姓名/手机号/学校
	 * @param order 排序方式:1.绩点排序,2.更新时间排序
	 * @param pageNumber 页码
	 * @param pageCount 每页加载记录数
	 * @return
	 */
	public Result server(AccountInfo accountInfo, String cityCode, String search, Integer order, Integer pageNumber, Integer pageCount);
	
	/**
	 * 将简历添加到以下载
	 * @param accountInfo
	 * @param AccountID
	 * @return
	 */
	public Result updateServer(AccountInfo accountInfo,Long AccountID) throws MyException;
	
	/**
	 * 查询所有已下载已下载简历
	 * @param accountInfo
	 * @return
	 */
	public Result down(AccountInfo accountInfo, String cityCode, String search, Integer order, Integer pageNumber, Integer pageCount);

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/15 1:22
	 * 描述 : 查询人才库简历总数
	 * @param accountInfo 当前登陆人员
	 * @return
	 */
	Result resumeCount(AccountInfo accountInfo);

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/15 16:22
	 * 描述 : 检测当前企业账号是否拥有下载简历权限
	 * @param accountInfo 当前登陆账号
	 * @return
	 */
	Result checkResumeDown(AccountInfo accountInfo) throws MyException;
}
