package com.jy.service.system.db_log;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;

/**
 * @ClassName:  DbLogService   
 * @Description:数据库操作Service 
 * @author: cheng fei
 * @date:   2018-08-07 00:02
 */
public interface DbLogService {

	/**
	 * 获取数据库操作日志信息
	 * @param accountInfo
	 * @param search
	 * @param startTime
	 * @param endTime
	 * @param type
	 * @param page
	 * @param pageSize
	 * @return
	 */
	Result getDbLog(AccountInfo accountInfo, String search, String startTime, String endTime, Integer type, Integer page, Integer pageSize);

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/11/24 0:15
	 * 描述 : 删除数据库操作日志
	 * @param accountInfo 当前登陆人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param beforeTime 删除多久以前的记录
	 * @return
	 */
	Result deleteDBLog(AccountInfo accountInfo, String AUTHORITY_CODE, Integer beforeTime) throws MyException;
}
