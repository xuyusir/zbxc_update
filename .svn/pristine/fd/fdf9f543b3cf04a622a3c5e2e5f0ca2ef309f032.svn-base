package com.jy.service.teacher;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.teacher.Teacherresource;

/**
 * 导师资源接口
 * @author chenye
 *
 */
public interface TeacherService {
	
	public Result getTeacherresource(Integer page,Integer pageSize);
	
	public Result insertTeacherresource(AccountInfo accountInfo ,String CONTROLLER_CODE,Teacherresource teacherresource) throws MyException;
	
	public Result updateTeacherresource(AccountInfo accountInfo ,String CONTROLLER_CODE,Teacherresource teacherresource) throws MyException;
	
	public Result deleteTeacherresource(AccountInfo accountInfo ,String CONTROLLER_CODE,Integer teacherid);

}
