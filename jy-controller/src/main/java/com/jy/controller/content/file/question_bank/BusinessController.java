package com.jy.controller.content.file.question_bank;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.file.question_bank.Business;
import com.jy.service.content.file.question_bank.BusinessService;
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
 * @ClassName:  BusinessController
 * @Description:面经题库行业模块
 * @author: cheng fei
 * @date:   2018-09-19 16:44
 * 注释掉的代码是为将面经题库行业修改为一级目录,不做成树形
 */

@Controller
@RequestMapping("/content/file/question/bank/business")
@Api(tags = "content.file.question_bank.BusinessController", description = "内容-文件-面经题库-行业模块")
public class BusinessController extends BaseController{

	@Resource
	private BusinessService businessService;

	@ApiOperation(value = "添加面经题库行业", httpMethod = "POST", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertBusiness(
			//@ApiParam(value = "行业父节点ID", required = true) @RequestParam( required = true) Integer parent_id,
			@ApiParam(value = "行业名称", required = true) @RequestParam( required = true) String business_name
			) throws MyException{
		AccountInfo accountInfo = this.getAccountInfo();
		Business business = new Business();
		//business.setParentid(parent_id);
		//添加时不需要传入父节点ID,默认添加到所有行业下,所有行业不允许删除,ID为1
		business.setParentid(1);
		business.setBusinessname(business_name);
		return businessService.insertBusiness(accountInfo, AuthorityCode.CONTENT_BUSINESS_INSERT_AUTHORITY,business);
	}

	@ApiOperation(value = "修改面经题库行业", httpMethod = "PUT", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateBusiness(
			@ApiParam(value = "行业ID", required = true) @RequestParam( required = true) Integer business_id,
			@ApiParam(value = "行业名称", required = true) @RequestParam( required = true) String business_name
			)throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Business business = new Business();
		business.setBusinessid(business_id);
		business.setBusinessname(business_name);
		return businessService.updateBusiness(accountInfo, AuthorityCode.CONTENT_BUSINESS_UPDATE_AUTHORITY ,business);
	}

	@ApiOperation(value = "删除面经题库行业", httpMethod = "DELETE", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteBusiness(
			@ApiParam(value = "行业ID", required = true) @RequestParam( required = true) Integer business_id
			) throws MyException{
		AccountInfo accountInfo = this.getAccountInfo();
		return businessService.deleteBusiness(accountInfo, AuthorityCode.CONTENT_BUSINESS_DELETE_AUTHORITY ,business_id);
	}

	@ApiOperation(value = "获取面经题库行业列表", httpMethod = "POST", produces = "application/json" )
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getBusinessList(
			@ApiParam(value = "行业父节点ID", required = false, defaultValue = "0") @RequestParam( required = false, defaultValue= "0") Integer business_parent_id,
			@ApiParam(value = "关键词:模糊查询行业", required = false) @RequestParam(required = false,defaultValue = "") String serach,
			@ApiParam(value = "页码", required = false, defaultValue = "1") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每页条数", required = false, defaultValue = "10") @RequestParam(required = false, defaultValue = "10") Integer pageSize

	)throws MyException{
		return businessService.getBusinessList(business_parent_id, serach, page, pageSize);
	}

	@ApiOperation(value = "获取面经题库行业列表树", httpMethod = "GET", produces = "application/json" )
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	@ResponseBody
	public Result getBusinessList(
			@ApiParam(value = "行业父节点ID", required = false, defaultValue = "0") @RequestParam( required = false, defaultValue= "0") Integer business_parent_id
	)throws MyException{
		return businessService.getBusinessList(business_parent_id);
	}
}
