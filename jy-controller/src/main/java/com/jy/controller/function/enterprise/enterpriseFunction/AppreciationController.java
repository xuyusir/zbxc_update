package com.jy.controller.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.enterpriseFunction.Enterpriseappraise;
import com.jy.service.function.enterprise.enterpriseFunction.AppreciationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 增值模块
 * @author liuhong
 * @date: 2018年9月18日 下午7:13:31 
 * @Package: com.jy.controller.enterprise
 */
@Controller
@RequestMapping("function/enterprise/appreciation")
@Api(tags = "function.enterprise.enterpriseFunction.AppreciationController", description = "功能-企业端-增值服务模块")
public class AppreciationController extends BaseController {


	@Resource
	AppreciationService appreciationService;
	
	

	@ApiOperation(value = "增值服务页信息查询", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getEnterpriseInfo(
		@ApiParam(value = "职位ID", required = false) @RequestParam(required = false) Integer jobID,
		@ApiParam(value = "是否已评价（Y/N）", required = true) @RequestParam(required = false, defaultValue = "Y") String isEvaluate,
		@ApiParam(value = "关键词:姓名/手机/岗位", required = false) String search,
		@ApiParam(value = "页码", required = false) Integer pageNumber,
		@ApiParam(value = "每页条数", required = false) Integer pageCount
			) {
		
		AccountInfo accountInfo = this.getAccountInfo();
		return appreciationService.getList(accountInfo, jobID, isEvaluate, search, pageNumber, pageCount);
	}
	
	@ApiOperation(value = "企业端增值服务页评价信息写入", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result getEnterpriseInfo(
			@ApiParam(value = "职位ID", required =true ) @RequestParam(required = true) Integer jobID,
			@ApiParam(value = "被评价人ID", required =true ) @RequestParam(required = true) Long accountID,
			@ApiParam(value = "评价详情", required =true ) String appraiseDetail
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
        Enterpriseappraise enterpriseappraise = new Enterpriseappraise();
        enterpriseappraise.setEjobvacancyid(jobID);
        enterpriseappraise.setAccountid(accountID);
        enterpriseappraise.setAppraisedetail(appraiseDetail);
        return appreciationService.insertEnterpriseAppraise(accountInfo, enterpriseappraise);
	}

	@ApiOperation(value = "查询增值服务总数接口", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public Result getCount(
	) {
		AccountInfo accountInfo = this.getAccountInfo();
		return appreciationService.getCount(accountInfo);
	}

	@ApiOperation(value = "查询所有评价接口", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/all/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getAppreciationAllList(
			@ApiParam(value = "关键词:姓名", required = false) @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam(value = "入职时间", required = false) @RequestParam(required = false, defaultValue = "") String searchDate,
			@ApiParam(value = "页码", required = false) @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每页条数", required = false) @RequestParam(required = false, defaultValue = "10") Integer pageSize
	) {
		AccountInfo accountInfo = this.getAccountInfo();
		return appreciationService.getAppreciationAllList(accountInfo, search, searchDate, page, pageSize);
	}
	
}
