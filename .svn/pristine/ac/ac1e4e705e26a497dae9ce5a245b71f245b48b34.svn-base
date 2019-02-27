package com.jy.service.function.person.memberFunction;

import java.text.ParseException;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.person.Appointserviceconfig;

/**
 * 服务预约配置Service接口
 * @author chenye
 *
 */
public interface ServiceAppointmentConfigurationService {
	

	/**
	 * 获取全部预约列表
	 * @param accountInfo 登录用户信息
	 * @param AUTHORITY_CODE 权限码
	 * @param search 搜索条件
	 * @param appointdate 预约日期
	 * @param page 页码
	 * @param pageSize 每页展示条数
	 * @return
	 * @throws MyException
	 * @throws ParseException 
	 */
	public Result getAppointmentList(AccountInfo accountInfo, String AUTHORITY_CODE,
			String search,String appointdate,Integer page, Integer pageSize) throws MyException, ParseException;
	
	/**
	 * 获取已完成的预约列表
	 * @param accountInfo 登录用户信息
	 * @param AUTHORITY_CODE 权限码
	 * @param search 搜索条件
	 * @param appointdate 预约日期
	 * @param page 页码
	 * @param pageSize 每页展示条数
	 * @return
	 * @throws MyException
	 * @throws ParseException 
	 */
	public Result getAppointmentendList(AccountInfo accountInfo, String AUTHORITY_CODE,
			String search,String appointdate,Integer page, Integer pageSize) throws MyException, ParseException;
	
	/**
	 * 获取正在进行的预约列表
	 * @param accountInfo 登录用户信息
	 * @param AUTHORITY_CODE 权限码
	 * @param search 搜索条件
	 * @param appointdate 预约日期
	 * @param page 页码
	 * @param pageSize 每页展示条数
	 * @return
	 * @throws MyException
	 */
	public Result getAppointmentingList(AccountInfo accountInfo, String AUTHORITY_CODE,
			String search,String appointdate,Integer page, Integer pageSize) throws MyException;
	
	
	/**
	 * 加载预约时间下拉框
	 * @return
	 */
	public Result loadAppointmentTime();
	
	/**
	 * 加载服务名称下拉框
	 * @return
	 */
	public Result loadServiceName();
	
	/**
	 * 编辑回显
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param appointserviceid
	 * @return
	 * @throws MyException 
	 */
	public Result updateView(AccountInfo accountInfo, String AUTHORITY_CODE,Long appointserviceid) throws MyException;

	/**
	 * 新建预约
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param appointserviceconfig
	 * @return
	 * @throws MyException 
	 * @throws ParseException 
	 */
	public Result insertAppointment(AccountInfo accountInfo, String AUTHORITY_CODE,Appointserviceconfig appointserviceconfig) throws MyException, ParseException;
	
	/**
	 * 修改预约
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param appointserviceconfig
	 * @return
	 * @throws MyException 
	 * @throws ParseException 
	 */
	public Result updateAppointment(AccountInfo accountInfo, String AUTHORITY_CODE,Appointserviceconfig appointserviceconfig) throws MyException, ParseException;
	
	/**
	 * 删除预约
	 * @param accountInfo
	 * @param AUTHORITY_CODE
	 * @param appointserviceid
	 * @return
	 * @throws MyException
	 */
	public Result deleteAppointment(AccountInfo accountInfo, String AUTHORITY_CODE,Long appointserviceid) throws MyException;

	
}
