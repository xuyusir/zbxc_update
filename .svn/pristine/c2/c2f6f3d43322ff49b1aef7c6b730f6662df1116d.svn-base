package com.jy.controller.function.marketingFunction.registrationManagement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
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
import com.jy.common.utils.DateUtils;
import com.jy.common.utils.JsonUtils;
import com.jy.common.utils.LiuUtils;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.function.marketingFunction.registrationManagement.Signincheck;
import com.jy.entiy.function.marketingFunction.votingManagement.Voteconfig;
import com.jy.service.function.marketingFunction.registrationManagement.RegistrationManageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * @ClassName: RegistrationManageController
 * @author: chenye
 * @date: 2018-09-12 16:17
 */
@Controller
@RequestMapping("function/registration")
@Api(tags = "RegistrationManageController", description = "功能-营销功能-签到管理")
public class RegistrationManageController extends BaseController {
	
			
			@Resource
			private RegistrationManageService registrationManageService;
			
			@ApiOperation(value = "获取活动列表", httpMethod = "POST", produces = "application/json")
			@RequestMapping(value = "/getActivityList", method = RequestMethod.POST)
			@ResponseBody
			public Result getActivityList(@ApiParam(value = "状态id", required = false) Integer votestatusid,
					@ApiParam(value = "查询条件", required = false) String search,
					@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
					@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
					throws MyException {

				AccountInfo accountInfo = this.getAccountInfo();
				return registrationManageService.getActivityList(accountInfo, AuthorityCode.MARKETING_FUNCTION_ACTIVITY_LIST, votestatusid, search, page, pageSize);
			}
			
			@ApiOperation(value = "添加活动", httpMethod = "POST", produces = "application/json")
			@RequestMapping(value = "/addActivity", method = RequestMethod.POST)
			@ResponseBody
			public Result addActivity(
					HttpServletRequest request,
					@ApiParam(value = "活动地点",required = true) String activitylocation,
					@ApiParam(value = "活动名字",required = true) String activename,
					@ApiParam(value = "活动时间", required = true)String activetime,
					@ApiParam(value = "状态id",required = true )Integer votestatusid,
					@ApiParam(value = "参与人群id",required = true )Integer voteparticipanttypeid,
					@ApiParam(value = "签到链接地址",required = true )String voteUrl
					
					)
					throws MyException, IOException, ParseException {
				Signincheck signincheck = new Signincheck();
				if(activetime != null && !activetime.equals("")) {
					Date Dactivetime = DateUtils.dateParse(activetime, "yyyy-MM-dd HH:mm:ss");
					if(Dactivetime.getTime() < new Date().getTime()) {
						return Result.build(20001,400,"不能创建活动时间为过去的活动!");
					}
					signincheck.setActivetime(Dactivetime);
				}
				
				
				
				signincheck.setActivename(activename);
				
				signincheck.setActivitylocation(activitylocation);
				signincheck.setVotestatusid(votestatusid);
				signincheck.setVoteparticipanttypeid(voteparticipanttypeid);
				
				// 二维码图片存放地址
				String qRpath = request.getSession().getServletContext().getRealPath("/WEB-INF/qrPicture/QR_code.png");
				AccountInfo accountInfo = this.getAccountInfo();
				return registrationManageService.addActivity(accountInfo, AuthorityCode.MARKETING_FUNCTION_ACTIVITY_INSERT, signincheck, qRpath);
			}
			
			@ApiOperation(value = "编辑活动", httpMethod = "PUT", produces = "application/json")
			@RequestMapping(value = "/updateActivity", method = RequestMethod.PUT)
			@ResponseBody
			public Result updateActivity(
					@ApiParam(value = "活动主键id",required = true) Integer signincheckid,
					@ApiParam(value = "活动地点",required = true) String activitylocation,
					@ApiParam(value = "活动名字",required = true) String activename,
					@ApiParam(value = "活动时间", required = true)String activetime,
					@ApiParam(value = "状态id",required = true )Integer votestatusid,
					@ApiParam(value = "参与人群id",required = true )Integer voteparticipanttypeid
					)
					throws MyException, ParseException {
				Signincheck signincheck = new Signincheck();
				signincheck.setSignincheckid(signincheckid);
				signincheck.setActivename(activename);
				if(activetime != null && !activetime.equals("")) {
					Date Dactivetime = DateUtils.dateParse(activetime, "yyyy-MM-dd HH:mm:ss");
					if(Dactivetime.getTime() < new Date().getTime()) {
						return Result.build(20001,400,"活动时间不能为过去的时间!");
					}
					signincheck.setActivetime(Dactivetime);
				}
				signincheck.setActivitylocation(activitylocation);
				signincheck.setVotestatusid(votestatusid);
				signincheck.setVoteparticipanttypeid(voteparticipanttypeid);
				
				
				
				
				AccountInfo accountInfo = this.getAccountInfo();
				return registrationManageService.updateActivity(accountInfo, AuthorityCode.MARKETING_FUNCTION_ACTIVITY_UPDATE, signincheck);
			}
			
			@ApiOperation(value = "删除活动", httpMethod = "DELETE", produces = "application/json")
			@RequestMapping(value = "/deleteActivity", method = RequestMethod.DELETE)
			@ResponseBody
			public Result deleteActivity(
					@ApiParam(value = "活动id列表,用,隔开", required = true) @RequestParam(required = true) String ids
					)
					throws MyException {
				
				
				String[] split = ids.split(",");
				AccountInfo accountInfo = this.getAccountInfo();
				for (String id : split) {
					if (!StringUtils.isNumeric(id)) {
						return Result.build(ResultEnum.PARAMETER_ERROR);
					}
						Result result = registrationManageService.deleteActivity(accountInfo, AuthorityCode.MARKETING_FUNCTION_ACTIVITY_DELETE, Integer.parseInt(id));
						if(result.getStatus() != 200) {
							return result;
						}
				}
				
				return Result.succee();				
			}
			
			@ApiOperation(value = "查询活动详细信息", httpMethod = "POST", produces = "application/json")
			@RequestMapping(value = "/getActivityInfo", method = RequestMethod.POST)
			@ResponseBody
			public Result getActivityInfo(
					@ApiParam(value = "活动主键id",required = true) Integer signincheckid
					)
					throws MyException {
				
				
				
				AccountInfo accountInfo = this.getAccountInfo();
				return registrationManageService.getActivityInfo(accountInfo, AuthorityCode.MARKETING_FUNCTION_ACTIVITY_UPDATE, signincheckid);
			}
			
			@ApiOperation(value = "导出列表预览", httpMethod = "POST", produces = "application/json")
			@RequestMapping(value = "/exportListView", method = RequestMethod.POST)
			@ResponseBody
			public Result exportListView(
					@ApiParam(value = "活动主键id",required = true) Integer signincheckid
//					@ApiParam(value = "导出地址",required = true)String url
					)
					throws MyException {
				
				
				
				AccountInfo accountInfo = this.getAccountInfo();
				return registrationManageService.exportListView(accountInfo, AuthorityCode.MARKETING_FUNCTION_ACTIVITY_EXPORT, signincheckid);
			}
			
			@ApiOperation(value = "导出列表", httpMethod = "GET", produces = "application/json")
			@RequestMapping(value = "/exportList", method = RequestMethod.GET)
			@ResponseBody
			public Result exportList(
					HttpServletResponse response,
					@ApiParam(value = "活动主键id",required = true) Integer signincheckid
					)
					throws MyException, IOException, ParseException {
				
				
				
				AccountInfo accountInfo = this.getAccountInfo();
//				String url = "D://xml//123.xls";
				String url = LiuUtils.getDownNameByUUId(accountInfo.getAccount().getAccountid());
				Result exportList = registrationManageService.exportList(accountInfo, AuthorityCode.MARKETING_FUNCTION_ACTIVITY_EXPORT, signincheckid,url);
				if(exportList.getStatus()!=200){
					response.getWriter().println(JsonUtils.objectToJson(exportList));
				}else {
					HSSFWorkbook workbook = (HSSFWorkbook) exportList.getData();
					// 设置请求头
					response.setContentType("application/vnd.ms-excel");
					response.setHeader("Content-disposition",
							"attachment; filename=" + new String("活动签到表.xls".getBytes("utf-8"), "ISO8859-1"));
					ServletOutputStream outputStream = response.getOutputStream();
					workbook.write(outputStream);
				}
				return null;
			}
			
			@ApiOperation(value = "启用/禁用", httpMethod = "POST", produces = "application/json")
			@RequestMapping(value = "/is", method = RequestMethod.POST)
			@ResponseBody
			public Result isNotHave(
					@ApiParam(value = "活动id列表,用,隔开", required = true) @RequestParam(required = true) String ids,
					@ApiParam(value = "状态id ,1启用2禁用",required = true) Integer votestatusid
					)
					throws MyException {
				
				AccountInfo accountInfo = this.getAccountInfo();
				if(votestatusid != null) {
					if(votestatusid != 1 && votestatusid != 2) {
						return Result.build(ResultEnum.PARAMETER_ERROR);
					}
				}
				
				String[] split = ids.split(",");
				for (String id : split) {
					if (!StringUtils.isNumeric(id)) {
						return Result.build(ResultEnum.PARAMETER_ERROR);
					}
					Signincheck signincheck = new Signincheck();
					signincheck.setSignincheckid(Integer.parseInt(id));
					signincheck.setVotestatusid(votestatusid);
				Result result =	registrationManageService.updateActivity(accountInfo, AuthorityCode.MARKETING_FUNCTION_ACTIVITY_UPDATE, signincheck);
				if(result.getStatus() != 200) {
					return result;
				}
				}
				
				return Result.succee();

			}
			
			
			
			@ApiOperation(value = "签到", httpMethod = "GET", produces = "application/json")
			@RequestMapping(value = "/signin", method = RequestMethod.GET)
			@ResponseBody
			public Result signin(
					@ApiParam(value = "活动主键id",required = true) Integer signincheckid
					)
					throws MyException, ParseException {	
				AccountInfo accountInfo = this.getAccountInfo();
				return registrationManageService.signin(accountInfo, signincheckid);
			}

}
