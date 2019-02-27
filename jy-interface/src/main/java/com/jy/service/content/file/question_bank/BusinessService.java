package com.jy.service.content.file.question_bank;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.file.question_bank.Business;

/**
 * 
 * @ClassName:  BusinessService   
 * @Description:面经题库行业模块接口
 * @author: cheng fei
 * @date:   2018-09-19 16:59
 */
public interface BusinessService {

	/**
	 * 添加面经题库行业
	 * @param accountInfo  当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param business 添加的行业
	 * @return
	 * @throws MyException 
	 */
	Result insertBusiness(AccountInfo accountInfo, String AUTHORITY_CODE, Business business) throws MyException;

	/**
	 * 修改面经题库行业
	 * @param accountInfo 当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param business 修改的行业
	 * @return
	 */
	Result updateBusiness(AccountInfo accountInfo, String AUTHORITY_CODE, Business business)throws MyException;

	/**
	 * 删除面经题库行业
	 * @param accountInfo 当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param business_id 要删除的行业ID
	 * @return
	 */
	Result deleteBusiness(AccountInfo accountInfo, String AUTHORITY_CODE, Integer business_id)throws MyException;

	/**
	 * 加载面经题库行业easyUI树
	 * @param business_parent_id 行业父节点ID
	 * @param page 页码
	 * @param pageSize 每页条数
	 * @return
	 */
	Result getBusinessList(Integer business_parent_id,String serach, Integer page, Integer pageSize) throws MyException;

	/**
	 * 作者: cheng fei
	 * 创建日期: 2018/12/4 14:09
	 * 描述 : 获取行业列表树
	 * @param business_parent_id
	 * @return
	 */
	Result getBusinessList(Integer business_parent_id);
}
