package com.jy.service.test;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;

public interface TestService {

	
	/**
	 * 测试同一方法操作两张表,中间出现异常测试
	 * @return
	 * @throws MyException 
	 */
	Result insertTest1() throws MyException;

	/**
	 * 测试service层一个公共法调用另一个公共方法操作两张表,中间出现异常测试
	 * @return
	 */
	Result insertTest2();

	/**
	 * 测试service层一个公共法调用另一个父类方法操作两张表,中间出现异常测试
	 * @return
	 */
	Result insertTest3();

	Result insertTest4();

	Result insertTest5();

	Result insertTest6();

	Result insertTest7() throws MyException;

}
