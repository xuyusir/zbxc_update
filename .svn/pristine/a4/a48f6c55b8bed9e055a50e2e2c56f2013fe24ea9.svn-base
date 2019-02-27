package com.jy.service.system.select;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.select.Select;

/**
 * 
 * @ClassName:  SelectService   
 * @Description:配置表统一处理接口 
 * @author: cheng fei
 * @date:   2018-09-18 17:17
 */


public interface SelectService {

	/**
	 * 添加配置
	 * @param accountInfo 当前登录的人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param select 配置
	 * @return 
	 * @throws MyException 
	 */
	Result insert(AccountInfo accountInfo, String AUTHORITY_CODE, Select select) throws MyException;

	/**
	 * 查询下拉列表
	 * @param table_id 配置表在配置表中的ID
	 * @return
	 */
	Result getSelectByID(Integer table_id);
	
	/**
	 * 查询下拉列表
	 * @param table_name 配置表名称
	 * @return
	 */
	Result getSelectByName(String table_name);

	/**
	 * 加载配置列表
	 * @param accountInfo
	 * @param table_id
	 * @return
	 */
	Result getSelectList(AccountInfo accountInfo, Integer table_id);

	/**
	 * @throws MyException 
	 * 
	 * @Description 修改配置
	 * @author Administrator
	 * @date 2018年9月19日
	 * @param accountInfo 当前登陆人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param select 修改的配置
	 * @return  
	 * @throws
	 */
	Result updateSelect(AccountInfo accountInfo, String AUTHORITY_CODE, Select select) throws MyException;
	
	/**
	 * 
	 * @param accountInfo 当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param table_id 配置表的配置表ID
	 * @param id 要删除的主键
	 * @return
	 * @throws MyException
	 */
	Result deleteSelect(AccountInfo accountInfo, String AUTHORITY_CODE, Integer table_id, Integer id) throws MyException;
	
	/**
	 * 查询配置
	 * @param accountInfo 当前登录人员
	 * @param table_id 配置表的配置表ID
	 * @param id 配置表ID
	 * @return
	 * @throws MyException
	 */
	Result getSelect(AccountInfo accountInfo, Integer table_id, Integer id) throws MyException;

	/**
	 * @param id 
	 * 
	 * @Description 验证固定编码
	 * @author Administrator
	 * @date 2018年9月19日
	 * @param code 固定编码
	 * @param table_id 配置表的配置表ID
	 * @param table_id 要排除的主键
	 * @return  
	 * @throws
	 */
	Result checkCode(String code, Integer table_id, Integer id);

}
