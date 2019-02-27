package com.jy.controller.function.person.memberFunction;

import java.io.IOException;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.JsonUtils;
import com.jy.common.utils.LiuUtils;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.service.function.person.memberFunction.ServiceApplicationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ServiceApplicationController
 * @author: chenye
 * @date: 2018-08-31 14:33
 */
@Controller
@RequestMapping("/ServiceApplication")
@Api(tags = "ServiceApplicationController", description = "功能-会员功能-服务申请处理")
public class ServiceApplicationController extends BaseController {

	
	private static final String STAUS1 = "待处理";
	
	private static final String STAUS2 = "已处理";
	
	private static final String STAUS3 = "已拒绝";

	@Resource
	ServiceApplicationService serviceApplicationService;

	@ApiOperation(value = "获取服务申请列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getServiceApplicationList(@ApiParam(value = "申请状态", required = false) String applicationstatusname,
			@ApiParam(value = "预约日期", required = false) String appointdate,
			@ApiParam(value = "申请日期", required = false) String applicationtime,
			@ApiParam(value = "姓名/手机号/服务单号", required = false) String search,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {

		// 参数检查
		if (applicationstatusname != null) {
			if (!applicationstatusname.equals(STAUS1) && !applicationstatusname.equals(STAUS2)
					&& !applicationstatusname.equals(STAUS3)) {
				applicationstatusname = null;
			}
		}
		AccountInfo accountInfo = this.getAccountInfo();
		return serviceApplicationService.getServiceApplicationList(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPLICATION_LIST, applicationstatusname,
				search, applicationtime, appointdate, page, pageSize);
	}

	@ApiOperation(value = "处理服务申请", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result processing(
			@ApiParam(value = "要处理的申请id列表,用,隔开", required = true) @RequestParam(required = true) String ids,
			@ApiParam(value = "申请状态id", required = false) Integer applicationStatusID) throws MyException, NumberFormatException, ParseException {
		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Result result = serviceApplicationService.processing(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPLICATION_DISPOSE, Long.parseLong(id),
					applicationStatusID);
			if(result.getStatus() != 200) {
				return result;
			}
		}
		return Result.succee();
	}
	
	
	@ApiOperation(value = "导出列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/exportList", method = RequestMethod.GET)
	@ResponseBody
	public Result exportList(
			HttpServletResponse response,
			@ApiParam(value = "申请状态", required = false) String applicationstatusname,
			@ApiParam(value = "预约日期", required = false) String appointdate,
			@ApiParam(value = "申请日期", required = false) String applicationtime,
			@ApiParam(value = "姓名/教师", required = false) String search,
			@ApiParam(value = "加载第几页")Integer page,
			@ApiParam(value = "每一页加载记录条数")Integer pageSize
			)
			throws MyException, IOException, ParseException {
		
		
		if(search != null) {
			//get请求转码
			search = new String(search.getBytes("ISO-8859-1"), "utf-8");
			
		}
		// 参数检查
		if (applicationstatusname != null) {
			//get请求转码
			applicationstatusname = new String(applicationstatusname.getBytes("ISO-8859-1"), "utf-8");
			
			if (!applicationstatusname.equals(STAUS1) && !applicationstatusname.equals(STAUS2)
					&& !applicationstatusname.equals(STAUS3)) {
				applicationstatusname = null;
			}
		}
		AccountInfo accountInfo = this.getAccountInfo();
//		String url = "D://xml//123.xls";
		String url = LiuUtils.getDownNameByUUId(accountInfo.getAccount().getAccountid());
		Result exportList = serviceApplicationService.exportList(accountInfo, AuthorityCode.MEMBER_FUNCTION_SERVIVES_APPLICATION_EXPORT, applicationstatusname, search, applicationtime, appointdate, page, pageSize, url);
		if(exportList.getStatus()!=200){
			response.getWriter().println(JsonUtils.objectToJson(exportList));
		}else {
			HSSFWorkbook workbook = (HSSFWorkbook) exportList.getData();
			// 设置请求头
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String("服务申请表.xls".getBytes("utf-8"), "ISO8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
		}
		return null;
	}

}
