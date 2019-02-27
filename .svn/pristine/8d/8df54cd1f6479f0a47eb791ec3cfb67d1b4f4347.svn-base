package com.jy.controller.function.person.memberFunction;

import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.DateUtils;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.articleManage.Articleinfo;
import com.jy.entiy.function.person.Appointserviceconfig;
import com.jy.service.function.person.memberFunction.ServiceAppointmentConfigurationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ServiceApplicationController
 * @author: chenye
 * @date: 2018-08-31 14:33
 */
@Controller
@RequestMapping("/ServiceAppointment")
@Api(tags = "ServiceAppointmentConfigurationController", description = "功能-会员功能-服务预约配置")
public class ServiceAppointmentConfigurationController extends BaseController {

	@Resource
	ServiceAppointmentConfigurationService serviceAppointmentConfigurationService;

	@ApiOperation(value = "获取全部预约列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getServiceApplicationList(@ApiParam(value = "预约日期", required = false) String appointdate,
			@ApiParam(value = "预约教师", required = false) String search,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException, ParseException {

		AccountInfo accountInfo = this.getAccountInfo();
		return serviceAppointmentConfigurationService.getAppointmentList(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPOINTMENT_LIST, search,
				appointdate, page, pageSize);
	}

	@ApiOperation(value = "获取已完成预约列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/applicationend/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getAppointmentendList(@ApiParam(value = "预约日期", required = false) String appointdate,
			@ApiParam(value = "预约教师", required = false) String search,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException, ParseException {

		AccountInfo accountInfo = this.getAccountInfo();
		return serviceAppointmentConfigurationService.getAppointmentendList(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPOINTMENT_LIST, search,
				appointdate, page, pageSize);
	}

	@ApiOperation(value = "获取正在进行预约列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/applicationing/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getAppointmentingList(@ApiParam(value = "预约日期", required = false) String appointdate,
			@ApiParam(value = "预约教师", required = false) String search,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return serviceAppointmentConfigurationService.getAppointmentingList(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPOINTMENT_LIST, search,
				appointdate, page, pageSize);
	}

	@ApiOperation(value = "新建预约", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertAppointment(

			@ApiParam(value = "服务名称", required = true) String appointservicename,
			@ApiParam(value = "预约日期", required = true) String appointdate,
			@ApiParam(value = "预约时间点ID", required = true) Integer appointservicetimeid,
			@ApiParam(value = "ICD报考预约名额", required = true) String appointtotalnum,
			@ApiParam(value = "预约老师/名额组合字符串'孔老师,10,孟老师,20' ", required = true) String appointteachers
			) throws MyException, ParseException {
		AccountInfo accountInfo = this.getAccountInfo();
		if (appointservicename == null || appointdate == null || appointservicetimeid == null
				) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Appointserviceconfig appointserviceconfig = new Appointserviceconfig();
		appointserviceconfig.setAppointservicename(appointservicename);
		appointserviceconfig.setAppointdate(appointdate);
		appointserviceconfig.setAppointservicetimeid(appointservicetimeid);
		

		//ICD报考新增预约
		if(appointtotalnum != null && !appointtotalnum.equals("")) {
//			String[] ICDsplit = appointtotalnum.split(",");
//			if(ICDsplit.length == 0) {
//				return Result.build(ResultEnum.PARAMETER_ERROR);
//			}
//			for (int i = 0; i < ICDsplit.length; i++) {
//				if (!StringUtils.isNumeric(ICDsplit[i])) {
//					return Result.build(20001,400,"预约名额不能为0 或负数!");
//					
//				}
//				if(Integer.parseInt(ICDsplit[i]) < 1) {//预约名额不能为0 或负数
//					return Result.build(20001,400,"预约名额不能为0 或负数!");
//				}
//				appointserviceconfig.setAppointtotalnum(Integer.parseInt(ICDsplit[i]));
//				appointserviceconfig.setAppointleftnum(Integer.parseInt(ICDsplit[i]));//剩余名额
//				
//			Result result	= serviceAppointmentConfigurationService.insertAppointment(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPOINTMENT_INSERT,
//						appointserviceconfig);	
//			
//			if(result.getStatus() != 200) {
//				return result;
//			}
//			}
			if(Integer.parseInt(appointtotalnum) < 1) {//预约名额不能为0 或负数
				return Result.build(20001,400,"预约名额不能为0 或负数!");
			}
			appointserviceconfig.setAppointtotalnum(Integer.parseInt(appointtotalnum));
			appointserviceconfig.setAppointleftnum(Integer.parseInt(appointtotalnum));//剩余名额
			
		Result result	= serviceAppointmentConfigurationService.insertAppointment(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPOINTMENT_INSERT,
					appointserviceconfig);
			return result;
		}
		
		//单面模拟新增预约
		if(appointteachers == null || appointteachers.equals("")) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		String[] split = appointteachers.split(",");
		if(split.length == 0) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		for (int i = 0; i <= split.length-2; i = i+2) {
			
				appointserviceconfig.setAppointteacher(split[i]);
				if (!StringUtils.isNumeric(split[i+1])) {
					return Result.build(20001,400,"预约名额不能为0 或负数!");
					
				}
				if(Integer.parseInt(split[i+1]) < 1) {//预约名额不能为0 或负数
					return Result.build(20001,400,"预约名额不能为0 或负数!");
				}
				appointserviceconfig.setAppointtotalnum(Integer.parseInt(split[i+1]));
				appointserviceconfig.setAppointleftnum(Integer.parseInt(split[i+1]));//剩余名额

			
			Result result = serviceAppointmentConfigurationService.insertAppointment(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPOINTMENT_INSERT,
					appointserviceconfig);	
			if(result.getStatus() != 200) {
				return result;
			}
		}

		return Result.succee();
		
	}

	@ApiOperation(value = "编辑回显", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Result updateView(@ApiParam(value = "预约编号", required = true) Long appointserviceid) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return serviceAppointmentConfigurationService.updateView(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPOINTMENT_UPDATE, appointserviceid);
	}
	
	
	@ApiOperation(value = "编辑预约", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateAppointment(
			@ApiParam(value = "预约ID", required = true)Long appointserviceid,
			@ApiParam(value = "服务名称", required = true) String appointservicename,
			@ApiParam(value = "预约日期", required = true) String appointdate,
			@ApiParam(value = "预约时间点ID", required = true) Integer appointservicetimeid,
			@ApiParam(value = "预约老师", required = true) String appointteacher,
			@ApiParam(value = "名额", required = true) Integer appointtotalnum) throws MyException, ParseException {
		
		if(appointtotalnum != null && appointtotalnum < 1) {//预约名额不能为0 或负数
			return Result.build(20001,400,"预约名额不能为0 或负数!");
		}
		AccountInfo accountInfo = this.getAccountInfo();
		Appointserviceconfig appointserviceconfig = new Appointserviceconfig();
		appointserviceconfig.setAppointserviceid(appointserviceid);
		appointserviceconfig.setAppointservicename(appointservicename);
		appointserviceconfig.setAppointdate(appointdate);
		appointserviceconfig.setAppointservicetimeid(appointservicetimeid);
		appointserviceconfig.setAppointtotalnum(appointtotalnum);
		appointserviceconfig.setAppointteacher(appointteacher);
		return serviceAppointmentConfigurationService.updateAppointment(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPOINTMENT_UPDATE,
				appointserviceconfig);
	}
	
	@ApiOperation(value = "删除预约", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteAppointment(
			@ApiParam(value = "要删除的预约id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Result	result = serviceAppointmentConfigurationService.deleteAppointment(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPOINTMENT_DELETE, Long.parseLong(id));
			if(result.getStatus() != 200) {
				return result;
			}
		}
		return Result.succee();
	}
	
}
