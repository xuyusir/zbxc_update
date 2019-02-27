package com.jy.service.content.file.question_bank;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.file.question_bank.Companyinfo;

/**
 * @ClassName:  CompanyInfoService   
 * @Description:面经题库公司接口
 * @author: cheng fei
 * @date:   2018-09-20 14:38
 */
public interface CompanyInfoService {

	/**
	 * 添加面经题库公司
	 * @param accountInfo 当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param companyinfo 添加的公司
	 * @return
	 * @throws MyException 
	 */
	Result insertCompanyInfo(AccountInfo accountInfo, String AUTHORITY_CODE, Companyinfo companyinfo) throws MyException;

	/**
	 * 查询面经题库公司
	 * @param accountInfo 当前登录人员
	 * @param company_id 面经题库公司ID
	 * @return
	 * @throws MyException 
	 */
	Result getCompanyInfo(AccountInfo accountInfo, Integer company_id) throws MyException ;

	/**
	 * 修改面经题库公司
	 * @param accountInfo 当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param companyinfo 面经题库公司
	 * @return
	 * @throws MyException 
	 */
	Result updateCompanyInfo(AccountInfo accountInfo, String AUTHORITY_CODE, Companyinfo companyinfo) throws MyException;

	/**
	 * 
	 * @param accountInfo 当前登录人员
	 * @param AUTHORITY_CODE 权限编码
	 * @param company_ids 面经题库公司ID列表,用,隔开
	 * @return
	 * @throws MyException 
	 */
	Result deleteCompanyInfo(AccountInfo accountInfo, String AUTHORITY_CODE, String company_ids) throws MyException;

	/**
	 * @param business_id 面经题库行业
	 * @param search 关键词
	 * @param page 页码
	 * @param page_size 每页加载条数
	 * @return
	 * @throws MyException 
	 */
	Result getCompanyInfoList(Integer business_id, String search, Integer page, Integer page_size) throws MyException;

}
