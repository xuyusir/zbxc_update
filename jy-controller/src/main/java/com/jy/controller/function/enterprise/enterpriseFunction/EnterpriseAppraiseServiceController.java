package com.jy.controller.function.enterprise.enterpriseFunction;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.service.function.enterprise.enterpriseFunction.EnterpriseAppraiseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



/**
 * 推荐评价管理
 * @author chenye
 *
 */
@Controller
@RequestMapping("function/appraise")
@Api(tags = "EnterpriseAppraiseServiceController",description = "企业功能-推荐评价管理")
public class EnterpriseAppraiseServiceController extends BaseController {
	
	@Resource
	EnterpriseAppraiseService  enterpriseAppraiseService;


	@ApiOperation(value = "获取推荐评价列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getAppraisalList(
			@ApiParam(value = "入职时间", required = false) String inductiondate,
			@ApiParam(value = "姓名/入职岗位",required = false) String search,
			@ApiParam(value = "加载第几页")@RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam( required = false, defaultValue = "10")Integer pageSize) throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		return enterpriseAppraiseService.getAppraisalList(accountInfo, AuthorityCode.ENTERPRISE_FUNCTION_ENTERPRISE_APPRAISE_LIST, search, inductiondate, page, pageSize);

	}

}
