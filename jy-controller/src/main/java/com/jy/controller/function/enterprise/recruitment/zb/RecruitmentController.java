package com.jy.controller.function.enterprise.recruitment.zb;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.DateUtils;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.function.enterprise.recruitment.Enterprisejobvacancy;
import com.jy.entiy.system.select.Jobtype;
import com.jy.service.function.enterprise.recruitment.zb.RecruitmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;


/**
 * @ClassName: RecruitmentController
 * @Description:内容-招聘管理Controller
 * @author: chenye
 * @date: 2018-08-21 15:37
 */
@Controller
@RequestMapping("/joinUs")
@Api(tags = "RecruitmentController", description = "招聘管理")
public class RecruitmentController extends BaseController {
	
	

	@Resource
	RecruitmentService recruitmentService;

	@ApiOperation(value = "通过类目 和模糊标题查询职位表获得职位列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getPositionInfoByJobTypeID(
			@ApiParam(value = "职位标题", required = false) String jobtitle,
			@ApiParam(value = "类目ID", required = false) Integer jobtypeid,
			@ApiParam(value = "加载第几页")@RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam( required = false, defaultValue = "10") Integer pageSize) {
		return recruitmentService.getPositionInfoByJobTypeID(2,jobtypeid, jobtitle, page, pageSize);

	}
	
	@ApiOperation(value = "通过类目 和模糊标题查询职位表获得职位列表,官网", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list/gw", method = RequestMethod.POST)
	@ResponseBody
	public Result gw(
			@ApiParam(value = "职位标题", required = false) String jobtitle,
			@ApiParam(value = "类目ID", required = false) Integer jobtypeid,
			@ApiParam(value = "加载第几页")@RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam( required = false, defaultValue = "10") Integer pageSize) {
		return recruitmentService.getPositionInfoByJobTypeID(1,jobtypeid, jobtitle, page, pageSize);

	}

	@ApiOperation(value = "回收站职位列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/recycle/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getRecycleInfoByJobTypeID(@ApiParam(value = "职位标题", required = false) String jobtitle,
			@ApiParam(value = "类目ID", required = false) Integer jobtypeid,
			@ApiParam(value = "加载第几页")@RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam( required = false, defaultValue = "10") Integer pageSize) {
		return recruitmentService.getRecycleInfoByJobTypeID(jobtypeid, jobtitle, page, pageSize);

	}
	
	@ApiOperation(value = "加载表单", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/form/load", method = RequestMethod.GET)
	@ResponseBody
	public Result getFormLoad() throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return recruitmentService.getFormLoad(accountInfo);
	}
	
	
	@ApiOperation(value = "获取职位原信息", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/{ejobvacancyid}", method = RequestMethod.GET)
	@ResponseBody
	public Result getUpdateSelect(@PathVariable@ApiParam(value = "职位id", required = false) Integer ejobvacancyid) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		return recruitmentService.getUpdateSelect(accountInfo, AuthorityCode.CONTENT_JOINUS_INFO_LIST_AUTHORITY, ejobvacancyid);

	}
	

	@ApiOperation(value = "新增职位", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertRecruitment(
			@ApiParam(value = "类目id", required = true)  Integer jobtypeid,
			@ApiParam(value = "标题", required = true)  String jobtitle,
			@ApiParam(value = "工作年限要求", required = false)  String expirencerequirement,			
			@ApiParam(value = "工作地点", required = true)  String workaddress,
			@ApiParam(value = "职位性质id", required = true)  Integer jobpropertyid,
			@ApiParam(value = "所属部门", required = true)  String department,
			@ApiParam(value = "学历要求", required = false) Integer educationid,
			@ApiParam(value = "职位月薪", required = false)  String salary,
			@ApiParam(value = "Y 表示薪资要面谈， N 表示薪资不需要面谈", required = false)  String  issalaryonface,
			@ApiParam(value = "职位描述", required = true)  String jobchineserequirement,
			@ApiParam(value = "任职要求", required = false)  String jobchineseresponsibility,
			@ApiParam(value = "截止时间", required = true)  String recruitexpiredate,			
			@ApiParam(value = "发布时间", required = true)  String deploymenttime,
			@ApiParam(value = "审核Y不审核N", required = true) String isauditpassed
			) throws MyException, ParseException {
		Enterprisejobvacancy enterprisejobvacancy = new Enterprisejobvacancy();
		enterprisejobvacancy.setJobtypeid(jobtypeid);
		enterprisejobvacancy.setJobtitle(jobtitle);
		enterprisejobvacancy.setExpirencerequirement(expirencerequirement);
		enterprisejobvacancy.setWorkaddress(workaddress);
		enterprisejobvacancy.setJobpropertyid(jobpropertyid);
		enterprisejobvacancy.setDepartment(department);
		enterprisejobvacancy.setEducationid(educationid);
		enterprisejobvacancy.setSalary(salary);
		enterprisejobvacancy.setIssalaryonface(issalaryonface);
		enterprisejobvacancy.setJobchineserequirement(jobchineserequirement);
		enterprisejobvacancy.setJobchineseresponsibility(jobchineseresponsibility);
		enterprisejobvacancy.setIsauditpassed(isauditpassed);
		//是中博星辰职位
		enterprisejobvacancy.setIszhongboxingchen("Y");
		enterprisejobvacancy.setIsopen("Y");
		Date Drecruitexpiredate = null;
		Date Ddeploymenttime = null;
		if(StringUtils.isNotBlank(recruitexpiredate)){
			   Drecruitexpiredate = DateUtils.dateParse(recruitexpiredate,"yyyy-MM-dd");
			  enterprisejobvacancy.setRecruitexpiredate(Drecruitexpiredate);
	        }
		  if(StringUtils.isNotBlank(deploymenttime)){
			  Ddeploymenttime = DateUtils.dateParse(deploymenttime,"yyyy-MM-dd");
			  enterprisejobvacancy.setDeploymenttime(Ddeploymenttime);
	        }else {
	        	enterprisejobvacancy.setDeploymenttime(new Date());
	        }
		  //截止时间早于发布时间
		  if(Drecruitexpiredate != null && Drecruitexpiredate.getTime()<Ddeploymenttime.getTime()) {
			  return Result.build(2000,200,"截止时间不能早于发布时间!");
		  }
		  
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		return recruitmentService.insertRecruitment(accountInfo, AuthorityCode.CONTENT_JOINUS_INSERT_AUTHORITY, enterprisejobvacancy);

	}
	
	@ApiOperation(value = "删除职位到回收站", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/recycle", method = RequestMethod.PUT)
	@ResponseBody
	public Result recycleRecruitment( 
			@ApiParam(value = "要回收的岗位id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		Enterprisejobvacancy enterprisejobvacancy = new Enterprisejobvacancy();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			enterprisejobvacancy.setEjobvacancyid(Integer.parseInt(id));
		Result result =	recruitmentService.recycleRecruitment(accountInfo, AuthorityCode.CONTENT_JOINUS_RECYCLE_AUTHORITY, enterprisejobvacancy);
		if(result.getStatus() != 200) {
			return result;
		}
		}
		return Result.succee();

	}
	
	
	@ApiOperation(value = "还原", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/restore", method = RequestMethod.PUT)
	@ResponseBody
	public Result restoreRecruitment( 
			@ApiParam(value = "要还原的岗位id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		Enterprisejobvacancy enterprisejobvacancy = new Enterprisejobvacancy();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			enterprisejobvacancy.setEjobvacancyid(Integer.parseInt(id));
			enterprisejobvacancy.setIsdelete("N");
		Result result =	recruitmentService.updateRecruitment(accountInfo, AuthorityCode.CONTENT_JOINUS_RECYCLE_AUTHORITY, enterprisejobvacancy);
		if(result.getStatus() != 200) {
			return result;
		}
		}
		return Result.succee();

	}
	
	@ApiOperation(value = "彻底删除职位", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteRecruitment(
			@ApiParam(value = "要删除的岗位id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		return recruitmentService.deleteRecruitment(accountInfo, AuthorityCode.CONTENT_JOINUS_DELETE_AUTHORITY, ids);

	}
	

	@ApiOperation(value = "修改职位信息(移动时修改类目id)", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/shift", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateRecruitment(
			@ApiParam(value = "职位id", required = true)  Integer ejobvacancyid,
			@ApiParam(value = "类目id", required = true)  Integer jobtypeid,
			@ApiParam(value = "标题", required = true)  String jobtitle,
			@ApiParam(value = "工作年限要求", required = false)  String expirencerequirement,			
			@ApiParam(value = "工作地点", required = true)  String workaddress,
			@ApiParam(value = "职位性质id", required = true)  Integer jobpropertyid,
			@ApiParam(value = "所属部门", required = true)  String department,
			@ApiParam(value = "学历要求", required = false) Integer educationid,
			@ApiParam(value = "职位月薪", required = false)  String salary,
			@ApiParam(value = "职位描述", required = true)  String jobchineserequirement,
			@ApiParam(value = "任职要求", required = false)  String jobchineseresponsibility,
			@ApiParam(value = "截止时间", required = true)  String recruitexpiredate,			
			@ApiParam(value = "发布时间", required = true)  String deploymenttime,
			@ApiParam(value = "审核Y不审核N", required = true) String isauditpassed,
			@ApiParam(value = "批量移动职位ids", required = false)  String ids
			) throws MyException, ParseException {
		Enterprisejobvacancy enterprisejobvacancy = new Enterprisejobvacancy();
		enterprisejobvacancy.setEjobvacancyid(ejobvacancyid);
		enterprisejobvacancy.setJobtypeid(jobtypeid);
		enterprisejobvacancy.setJobtitle(jobtitle);
		enterprisejobvacancy.setExpirencerequirement(expirencerequirement);
		enterprisejobvacancy.setWorkaddress(workaddress);
		enterprisejobvacancy.setJobpropertyid(jobpropertyid);
		enterprisejobvacancy.setDepartment(department);
		enterprisejobvacancy.setEducationid(educationid);
		enterprisejobvacancy.setSalary(salary);
		enterprisejobvacancy.setJobchineserequirement(jobchineserequirement);
		enterprisejobvacancy.setJobchineseresponsibility(jobchineseresponsibility);
		enterprisejobvacancy.setIsauditpassed(isauditpassed);
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		if(StringUtils.isNotBlank(recruitexpiredate)){
			  Date dateParse = DateUtils.dateParse(recruitexpiredate, DateUtils.DATE_PATTERN);
			  enterprisejobvacancy.setRecruitexpiredate(dateParse);
	        }
		  if(StringUtils.isNotBlank(deploymenttime)){
			  Date dateParse = DateUtils.dateParse(deploymenttime, DateUtils.DATE_PATTERN);
			  enterprisejobvacancy.setDeploymenttime(dateParse);
	        }
		  //批量移动
		  if(ids != null && ids != "") {
				String[] split = ids.split(",");
				for (String id : split) {
					if (!StringUtils.isNumeric(id)) {
						return Result.build(ResultEnum.PARAMETER_ERROR);
					}
					 Enterprisejobvacancy enterprisejobvacancyYD = new Enterprisejobvacancy();
					 enterprisejobvacancyYD.setJobtypeid(jobtypeid);
					 enterprisejobvacancyYD.setEjobvacancyid(Integer.parseInt(id));
					Result result= recruitmentService.updateRecruitment(accountInfo, AuthorityCode.CONTENT_JOINUS_MOVE_AUTHORITY, enterprisejobvacancyYD);
					if(result.getStatus() != 200) {
						return result;
					}
				}
				return Result.succee();
			 
			  
		  }
		return recruitmentService.updateRecruitment(accountInfo, AuthorityCode.CONTENT_JOINUS_UPDATE_AUTHORITY, enterprisejobvacancy);

	}
	
	@ApiOperation(value = "审核职位信息", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/audit", method = RequestMethod.PUT)
	@ResponseBody
	public Result auditRecruitment( @ApiParam(value = "要审核的职位id列表,用,隔开", required = true) @RequestParam(required = true) String ids) throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		Enterprisejobvacancy enterprisejobvacancy = new Enterprisejobvacancy();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			enterprisejobvacancy.setEjobvacancyid(Integer.parseInt(id));
		Result result =	recruitmentService.auditRecruitment(accountInfo, AuthorityCode.CONTENT_JOINUS_AUDIT_AUTHORITY, enterprisejobvacancy);
		if(result.getStatus() != 200) {
			return result;
		}
		}
		return Result.succee();

	}
	
	
	@ApiOperation(value = "新增类目", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/lm", method = RequestMethod.POST)
	@ResponseBody
	public Result addLM(
			@ApiParam(value = "类目名", required = true)  String jobtypeName) throws MyException {		
		AccountInfo accountInfo = this.getAccountInfo();
		Jobtype jobtype = new Jobtype(); 
		jobtype.setJobtypename(jobtypeName);

		return	recruitmentService.addLM(accountInfo, AuthorityCode.CONTENT_JOINUS_UPDATE_AUTHORITY, jobtype);


	}
	
	@ApiOperation(value = "编辑类目", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/lm", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateLM(
			@ApiParam(value = "类目id", required = true)  Integer jobtypeID,
			@ApiParam(value = "类目名", required = true)  String jobtypeName) throws MyException {		
		AccountInfo accountInfo = this.getAccountInfo();
		Jobtype jobtype = new Jobtype(); 
		jobtype.setJobtypeid(jobtypeID);
		jobtype.setJobtypename(jobtypeName);

		return	recruitmentService.updateLM(accountInfo, AuthorityCode.CONTENT_JOINUS_UPDATE_AUTHORITY, jobtype);


	}
	
	@ApiOperation(value = "删除类目", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/lm", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteLM(
			@ApiParam(value = "类目id", required = true)  Integer jobtypeID) throws MyException {		
		AccountInfo accountInfo = this.getAccountInfo();

		return	recruitmentService.deleteLM(accountInfo, AuthorityCode.CONTENT_JOINUS_UPDATE_AUTHORITY, jobtypeID);


	}
	
	@ApiOperation(value = "类目回显", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/lm/info", method = RequestMethod.GET)
	@ResponseBody
	public Result infoLM(
			@ApiParam(value = "类目id", required = true)  Integer jobtypeID) throws MyException {		
		AccountInfo accountInfo = this.getAccountInfo();

		return	recruitmentService.infoLM(accountInfo, AuthorityCode.CONTENT_JOINUS_UPDATE_AUTHORITY, jobtypeID);


	}
	
	
	@ApiOperation(value = "移动", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/yd", method = RequestMethod.PUT)
	@ResponseBody
	public Result Recruitment(
			@ApiParam(value = "类目id", required = true)  Integer jobtypeid,
			@ApiParam(value = "批量移动职位ids", required = false)  String ids
			) throws MyException, ParseException {
		Enterprisejobvacancy enterprisejobvacancy = new Enterprisejobvacancy();
		enterprisejobvacancy.setJobtypeid(jobtypeid);
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		  //批量移动
		  if(ids != null && ids != "") {
				String[] split = ids.split(",");
				for (String id : split) {
					if (!StringUtils.isNumeric(id)) {
						return Result.build(ResultEnum.PARAMETER_ERROR);
					}
					 Enterprisejobvacancy enterprisejobvacancyYD = new Enterprisejobvacancy();
					 enterprisejobvacancyYD.setJobtypeid(jobtypeid);
					 enterprisejobvacancyYD.setEjobvacancyid(Integer.parseInt(id));
					Result result= recruitmentService.updateRecruitment(accountInfo, AuthorityCode.CONTENT_JOINUS_UPDATE_AUTHORITY, enterprisejobvacancyYD);
					if(result.getStatus() != 200) {
						return result;
					}
				}
				return Result.succee();
			 
			  
		  }
		return recruitmentService.updateRecruitment(accountInfo, AuthorityCode.CONTENT_JOINUS_UPDATE_AUTHORITY, enterprisejobvacancy);

	}
	
}
