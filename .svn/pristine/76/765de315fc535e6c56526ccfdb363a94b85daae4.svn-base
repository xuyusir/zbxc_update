package com.jy.controller.function.enterprise.enterpriseFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.service.function.enterprise.enterpriseFunction.JobAuditManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @ClassName: JobAuditManageController
 * @author: chenye
 * @date: 2018-09-5 11:29
 */
@Controller
@RequestMapping("function/JobAuditManage")
@Api(tags = "JobAuditManageController", description = "企业功能-岗位审核处理")
public class JobAuditManageController extends BaseController {

	@Resource
	private JobAuditManageService jobAuditManageService;

	private static final String STAUS1 = "待处理";

	private static final String STAUS2 = "已处理";

	private static final String STAUS3 = "已拒绝";

	@ApiOperation(value = "获取岗位发布申请列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getJobApplicationList(@ApiParam(value = "申请状态", required = false) String applicationstatusname,
			@ApiParam(value = "申请时间", required = false) String applicationtime,
			@ApiParam(value = "企业名称/岗位名称/服务单号", required = false) String search,
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
		return jobAuditManageService.getJobApplicationList(accountInfo,
				AuthorityCode.ENTERPRISE_FUNCTION_JOB_AUDIT_LIST, applicationstatusname, search, applicationtime, page,
				pageSize);
	}

	@ApiOperation(value = "处理岗位发布申请", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result processingJobApplication(
			@ApiParam(value = "要处理岗位发布申请id列表,用,隔开", required = true) @RequestParam(required = true) String ids,
			@ApiParam(value = "申请状态id,同意发布2,拒绝发布3", required = true) Integer applicationstatusid) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}

			jobAuditManageService.updateJobApplication(accountInfo, AuthorityCode.ENTERPRISE_FUNCTION_JOB_AUDIT_DISPOSE, Integer.parseInt(id), applicationstatusid);
		}
		return Result.succee();
	}
}
