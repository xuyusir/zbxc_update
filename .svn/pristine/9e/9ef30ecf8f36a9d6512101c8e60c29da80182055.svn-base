package com.jy.controller.function.person.memberFunction;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.articleManage.Articleinfo;
import com.jy.service.function.person.memberFunction.MemberInfoManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName:  MemberInfoManagementController   
 * @Description:会员信息管理Controller
 * @author: chenye
 * @date:   2018-09-04 15:07
 */
@Controller
@RequestMapping("/MemberInfoManage")
@Api(tags = "MemberInfoManagementController", description = "功能-会员功能-会员信息管理")
public class MemberInfoManagementController extends BaseController {
	

	
	@Resource
	private MemberInfoManagementService memberInfoManagementService;

	@ApiOperation(value = "获取会员信息列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getMemberInfoList", method = RequestMethod.POST)
	@ResponseBody
	public Result getMemberInfoList(
			@ApiParam(value = "姓名/手机号/邮箱", required = false) String search,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		return memberInfoManagementService.getMemberInfoList(AuthorityCode.MEMBER_FUNCTION_MEMBER_INFO_LIST, accountInfo, search, page, pageSize);

	}
	
	
	@ApiOperation(value = "加载报告类型下拉列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/loadPersonreporttype", method = RequestMethod.GET)
	@ResponseBody
	public Result loadPersonreporttype() {
		
		return	memberInfoManagementService.loadPersonreporttype();
				
	}
	
	@ApiOperation(value = "获取报告文件", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getMemberPersonreport", method = RequestMethod.POST)
	@ResponseBody
	public Result getMemberPersonreport(
			@ApiParam(value = "报告类型id", required = true)Integer personreporttypeid,
			@ApiParam(value = "会员id(用户id)",required = true) Long accountid
			) throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		return memberInfoManagementService.getMemberPersonreport(AuthorityCode.MEMBER_FUNCTION_UPLOAD_REPORT, accountInfo, accountid, personreporttypeid);
		
	}
	
	@ApiOperation(value = "上传报告", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	@ResponseBody
	public Result uploadReport(
			@ApiParam(value = "报告类型id", required = true)Integer personreporttypeid,
			@ApiParam(value = "会员id(用户id)",required = true) Long accountid,
			@ApiParam(value = "要上传的报告文件id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			) throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Result result  = memberInfoManagementService.uploadReport(AuthorityCode.MEMBER_FUNCTION_UPLOAD_REPORT, accountInfo, accountid, personreporttypeid, Long.parseLong(id));
				if(result.getStatus() != 200) {
					return result;
				}
		}
		return Result.succee();
		
	}
}
