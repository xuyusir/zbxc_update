package com.jy.controller.content.file.question_bank;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.file.question_bank.Companyinfo;
import com.jy.service.content.file.question_bank.CompanyInfoService;
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
 * @ClassName:  CompanyInfoController   
 * @Description:面经题库公司接口
 * @author: cheng fei
 * @date:   2018-09-20 14:32
 */

@Controller 
@RequestMapping("/content/file/question/bank/company")
@Api(tags = "content.file.question_bank.CompanyInfoController", description = "内容-文件-面经题库-公司模块")
public class CompanyInfoController extends BaseController{

	@Resource
	private CompanyInfoService companyInfoService;
	
	@ApiOperation(value = "添加面经题库公司", httpMethod = "POST", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertCompanyInfo(
			@ApiParam(value = "面经题库行业ID", required = true) @RequestParam(required = true) Integer business_id,
			@ApiParam(value = "面经题库公司名称", required = true) @RequestParam(required = true) String company_name,
			@ApiParam(value = "面经题库公司logo", required = false) @RequestParam(required = false) Long company_logo,
			String search, Integer page, Integer page_size
			) throws MyException{
		AccountInfo accountInfo = this.getAccountInfo();
		Companyinfo companyinfo = new Companyinfo();
		companyinfo.setBusinessid(business_id);
		companyinfo.setCompanyname(company_name);
		companyinfo.setCompanylogo(company_logo);
		return companyInfoService.insertCompanyInfo(accountInfo, AuthorityCode.CONTENT_COMPANY_INSERT_AUTHORITY, companyinfo);
	}
	
	@ApiOperation(value = "查询面经题库公司", httpMethod = "GET", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Result getCompanyInfo(
			@ApiParam(value = "面经题库公司ID", required = true) @RequestParam(required = true) Integer company_id
			) throws MyException{
		AccountInfo accountInfo = this.getAccountInfo();
		return companyInfoService.getCompanyInfo(accountInfo, company_id);
	}
	
	@ApiOperation(value = "修改面经题库公司", httpMethod = "PUT", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateCompanyInfo(
			@ApiParam(value = "面经题库公司ID", required = true) @RequestParam(required = true) Integer company_id,
			@ApiParam(value = "面经题库公司名称", required = false) @RequestParam(required = false) String company_name,
			@ApiParam(value = "面经题库公司logo", required = false) @RequestParam(required = false) Long company_logo
			) throws MyException{
		AccountInfo accountInfo = this.getAccountInfo();
		Companyinfo companyinfo = new Companyinfo();
		companyinfo.setCompanyid(company_id);
		companyinfo.setCompanyname(company_name);
		companyinfo.setCompanylogo(company_logo);
		return companyInfoService.updateCompanyInfo(accountInfo, AuthorityCode.CONTENT_COMPANY_UPDATE_AUTHORITY, companyinfo);
	}
	
	@ApiOperation(value = "删除面经题库公司", httpMethod = "DELETE", produces = "application/json" )
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result updateCompanyInfo(
			@ApiParam(value = "面经题库公司ID列表,用\",\"隔开", required = true) @RequestParam(required = true) String company_ids
			) throws MyException{
		AccountInfo accountInfo = this.getAccountInfo();
		return companyInfoService.deleteCompanyInfo(accountInfo, AuthorityCode.CONTENT_COMPANY_DELETE_AUTHORITY, company_ids);
	}
	
	@ApiOperation(value = "查询面经题库公司列表", httpMethod = "POST", produces = "application/json" )
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getCompanyInfoList(
			@ApiParam(value = "面经题库行业ID", required = false) @RequestParam(required = false, defaultValue = "1") Integer business_id,
			@ApiParam(value = "关键词", required = false,defaultValue = "") @RequestParam(required = false, defaultValue = "") String search, 
			@ApiParam(value = "页码", required = false,defaultValue = "1") @RequestParam(required = false, defaultValue = "1") Integer page, 
			@ApiParam(value = "每页条数", required = false,defaultValue = "9") @RequestParam(required = false, defaultValue = "9") Integer pageSize
			) throws MyException{
		AccountInfo accountInfo = this.getAccountInfo();
		return companyInfoService.getCompanyInfoList(business_id, search, page, pageSize);
	}
	
	
}
