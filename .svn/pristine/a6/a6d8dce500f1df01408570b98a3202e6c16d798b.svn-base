package com.jy.controller.function.enterprise.enterpriseFunction;

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
import com.jy.service.function.enterprise.enterpriseFunction.EnterpriseServiceApplicationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: EnterpriseServiceApplicationController
 * @author: chenye
 * @date: 2018-09-6 10:35
 */
@Controller
@RequestMapping("function/EnterpriseService")
@Api(tags = "EnterpriseServiceApplicationController", description = "企业功能-服务申请处理")
public class EnterpriseServiceApplicationController extends BaseController {

	@Resource
	private EnterpriseServiceApplicationService enterpriseServiceApplicationService;

	private static final String STAUS1 = "待处理";

	private static final String STAUS2 = "已处理";

	private static final String STAUS3 = "已拒绝";

	@ApiOperation(value = "获取企业服务申请列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getEnterpriseServiceList(@ApiParam(value = "申请状态", required = false) String applicationstatusname,
			@ApiParam(value = "申请时间", required = false) String applcationdate,
			@ApiParam(value = "企业名称/联系人/服务单号", required = false) String search,
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
		return enterpriseServiceApplicationService.getEnterpriseServiceList(accountInfo,
				AuthorityCode.ENTERPRISE_FUNCTION_SERVIVES_APPLICATION_LIST, applicationstatusname, search,
				applcationdate, page, pageSize);
	}

	@ApiOperation(value = "处理企业服务申请", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result processingEnterpriseService(
			@ApiParam(value = "要处理企业服务申请id列表,用,隔开", required = true) @RequestParam(required = true) String ids,
			@ApiParam(value = "申请状态id,同意发布2,拒绝发布3", required = true) Integer applicationstatusid) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}

		Result result =	enterpriseServiceApplicationService.processingEnterpriseService(accountInfo,
					AuthorityCode.ENTERPRISE_FUNCTION_SERVIVES_APPLICATION_DISPOSE, Integer.parseInt(id),
					applicationstatusid);
		if(result.getStatus() != 200) {
			return result;
		}
		}
		return Result.succee();
	}

}
