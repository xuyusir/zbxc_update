package com.jy.service.function.enterprise.recruitment.zb;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.recruitment.Enterprisejobvacancy;
import com.jy.entiy.system.select.Jobtype;

/**
 * 招聘管理Service
 * @author chenye
 *
 */
public interface RecruitmentService {


	/**
	 * 通过栏目 和模糊标题查询职位表获得职位列表
	 * @return
	 */
	public Result getPositionInfoByJobTypeID(Integer reqType ,Integer jobtypeid,  String jobtitle,Integer page, Integer pageSize);
	
	/**
	 * 通过栏目 和模糊标题查询职位表获得职位列表(回收站)
	 * @return
	 */
	public Result getRecycleInfoByJobTypeID(Integer jobtypeid,  String jobtitle,Integer page, Integer pageSize);
	
	
	
	
	/**新增职位信息
	 * @param accountInfo
	 * @param enterprisejobvacancy
	 * @return
	 * @throws MyException 
	 */
	public Result insertRecruitment(AccountInfo accountInfo,String AUTHORITY_CODE,Enterprisejobvacancy enterprisejobvacancy) throws MyException;
	
	
	/**
	 * 修改这条职位信息
	 * @param accountInfo
	 * @param enterprisejobvacancy
	 * @param ejobvacancyid
	 * @return
	 * @throws MyException 
	 */
	public Result updateRecruitment(AccountInfo accountInfo,String AUTHORITY_CODE,Enterprisejobvacancy enterprisejobvacancy) throws MyException;
	
	/**
	 * 删除这条职位信息(放到回收站)
	 * @param accountInfo
	 * @param ejobvacancyid
	 * @return
	 * @throws MyException 
	 */
	public Result recycleRecruitment(AccountInfo accountInfo,String AUTHORITY_CODE,Enterprisejobvacancy enterprisejobvacancy) throws MyException;
	
	/**
	 * 彻底删除职位信息
	 * @param accountInfo
	 * @param ejobvacancyid
	 * @return
	 * @throws MyException 
	 */
	public Result deleteRecruitment(AccountInfo accountInfo,String AUTHORITY_CODE,String ids) throws MyException;
	
	/**
	 * 审核这条职位信息
	 * @param accountInfo
	 * @param enterprisejobvacancy
	 * @param ejobvacancyid
	 * @return
	 * @throws MyException 
	 */
	public Result auditRecruitment(AccountInfo accountInfo,String AUTHORITY_CODE,Enterprisejobvacancy enterprisejobvacancy) throws MyException;
	
	
	/**
	 * 表格加载(查询表格下拉框等信息)
	 * @return
	 */
	public Result getFormLoad(AccountInfo accountInfo)throws MyException;
	
	
	/**
	 * 新增类目
	 * @return
	 */
	public Result addLM(AccountInfo accountInfo,String AUTHORITY_CODE,Jobtype jobtype)throws MyException;
	/**
	 * 编辑类目
	 * @return
	 */
	public Result updateLM(AccountInfo accountInfo,String AUTHORITY_CODE,Jobtype jobtype)throws MyException;
	/**
	 * 删除类目
	 * @return
	 */
	public Result deleteLM(AccountInfo accountInfo,String AUTHORITY_CODE,Integer jobtypeid)throws MyException;
	
	/**
	 * 回显类目
	 * @return
	 */
	public Result infoLM(AccountInfo accountInfo,String AUTHORITY_CODE,Integer jobtypeid)throws MyException;
	
	/**
	 * 修改前方法(查询原信息)
	 * @return
	 */
	public Result getUpdateSelect(AccountInfo accountInfo,String AUTHORITY_CODE,Integer ejobvacancyid)throws MyException;
	
	
}
