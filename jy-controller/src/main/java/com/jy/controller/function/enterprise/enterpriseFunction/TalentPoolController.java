package com.jy.controller.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.service.function.enterprise.enterpriseFunction.TalentPoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 人才库模块
 * @author liuhong
 * @date: 2018年9月18日 下午7:13:43 
 * @Package: com.jy.controller.enterprise
 */
@Controller
@RequestMapping("function/enterprise/talentPool")
@Api(tags = "function.enterprise.enterpriseFunction.TalentPoolController", description = "功能-企业端-人才库模块")
public class TalentPoolController extends BaseController {
	

	@Resource
	private TalentPoolService talentPoolService;
	
	
	@ApiOperation(value = "申请开启人才库服务", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "server", method = RequestMethod.POST)
	@ResponseBody
	public Result applicationServer(
			@ApiParam(value = "申请服务类型", required = false) Integer ApplicationServiceType,
			HttpServletRequest request
			) throws MyException {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return talentPoolService.insertApplicationServer(accountInfo);
	}
	
	@ApiOperation(value = "查看人才库开启情况,返回Y表示已开启，返回N表示未开启,P表示申请中", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "server", method = RequestMethod.GET)
	@ResponseBody
	public Result server(
			HttpServletRequest request
			) throws MyException {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return talentPoolService.server(accountInfo);	
	}
	
	@ApiOperation(value = "查看人才库所有简历", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "resume/list", method = RequestMethod.POST)
	@ResponseBody
	public Result resume(
			@ApiParam(value = "期望工作城市编码", required = false)  @RequestParam(required = false, defaultValue = "") String cityCode,
			@ApiParam(value = "关键词:模糊查询姓名/手机号/学校", required = false) @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam(value = "排序方式:1.绩点排序,2.更新时间排序", required = false) @RequestParam(required = false, defaultValue = "1") Integer order,
			@ApiParam(value = "页码", required = false) @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
			@ApiParam(value = "每页加载记录数", required = false) @RequestParam(required = false,defaultValue = "10") Integer pageCount
			) {
        AccountInfo accountInfo = this.getAccountInfo();
        return talentPoolService.server(accountInfo, cityCode, search, order, pageNumber, pageCount);
	}

    @ApiOperation(value = "加载人才库简历总数", httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "count", method = RequestMethod.GET)
    @ResponseBody
    public Result resume() {
        AccountInfo accountInfo = this.getAccountInfo();
        return talentPoolService.resumeCount(accountInfo);
    }
	
	@ApiOperation(value = "将简历添加到已下载", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "resume", method = RequestMethod.POST)
	@ResponseBody
	public Result resume(
			@ApiParam(value = "被下载者ID", required = false) Long AccountID,
			HttpServletRequest request
			) throws MyException {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return talentPoolService.updateServer(accountInfo,AccountID);
	}

	@ApiOperation(value = "检测当前账号是否拥有下载简历权限接口", httpMethod = "PATCH", produces = "application/json")
	@RequestMapping(value = "check/resume/down", method = RequestMethod.PATCH)
	@ResponseBody
	public Result checkResumeDown() throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return  talentPoolService.checkResumeDown(accountInfo);
	}

	@ApiOperation(value = "申请下载简历", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "resume/down", method = RequestMethod.POST)
	@ResponseBody
	public Result resumeDown(
			HttpServletRequest request
			) throws MyException {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		
		return talentPoolService.updateServerDown(accountInfo);
	}
	
	@ApiOperation(value = "查询所有已下载已下载简历", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "down", method = RequestMethod.POST)
	@ResponseBody
	public Result down(
            @ApiParam(value = "期望工作城市编码", required = false)  @RequestParam(required = false, defaultValue = "") String cityCode,
            @ApiParam(value = "关键词:模糊查询姓名/手机号/学校", required = false) @RequestParam(required = false, defaultValue = "") String search,
            @ApiParam(value = "排序方式:1.绩点排序,2.更新时间排序", required = false) @RequestParam(required = false, defaultValue = "1") Integer order,
            @ApiParam(value = "页码", required = false) @RequestParam(required = false, defaultValue = "1") Integer pageNumber,
            @ApiParam(value = "每页加载记录数", required = false) @RequestParam(required = false,defaultValue = "10") Integer pageCount
			) {
        AccountInfo accountInfo = this.getAccountInfo();

		return talentPoolService.down(accountInfo,cityCode, search, order, pageNumber,pageCount);
	}
}
