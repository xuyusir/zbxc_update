package com.jy.controller.function.person.memberFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.function.person.memberFunction.Complaintapplication;
import com.jy.service.function.person.memberFunction.ComplaintApplicationService;
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
 * @ClassName: ComplaintApplicationController
 * @Description:投诉建议处理Controller
 * @author: chenye
 * @date: 2018-09-04 19:06
 */
@Controller
@RequestMapping("/ComplaintApplication")
@Api(tags = "function.person.memberFunction.ComplaintApplicationController", description = "功能-会员功能-投诉建议处理")
public class ComplaintApplicationController extends BaseController {

	@Resource
	private ComplaintApplicationService complaintApplicationService;

	private static final String STAUS1 = "待处理";

	private static final String STAUS2 = "已处理";

	@ApiOperation(value = "获取投诉建议列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getComplaintApplicationList(@ApiParam(value = "投诉状态", required = false) String applicationstatusname,
			@ApiParam(value = "投诉时间", required = false) String complainttime,
			@ApiParam(value = "投诉对象", required = false) String targetSearch,
			@ApiParam(value = "投诉人名字/手机号/服务单号", required = false) String personSearch,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {

		// 参数检查
		if (applicationstatusname != null) {
			if (!applicationstatusname.equals(STAUS1) && !applicationstatusname.equals(STAUS2)) {
				applicationstatusname = null;
			}
		}
		AccountInfo accountInfo = this.getAccountInfo();
		return complaintApplicationService.getComplaintApplicationList(accountInfo,
				AuthorityCode.MEMBER_FUNCTION_COMPLAIN_LIST, applicationstatusname, targetSearch, personSearch,
				complainttime, page, pageSize);
	}

	@ApiOperation(value = "处理投诉建议", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result processingComplaint(
			@ApiParam(value = "要处理的投诉id列表,用,隔开", required = true) @RequestParam(required = true) String ids,
			@ApiParam(value = "投诉状态id", required = false) Integer applicationStatusID) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}

			Result result =  complaintApplicationService.processingComplaint(accountInfo, AuthorityCode.MEMBER_FUNCTION_COMPLAIN_DISPOSE,
					Long.parseLong(id), applicationStatusID);
			if(result.getStatus() != 200) {
				return result;
			}
		}
		return Result.succee();
	}

	@ApiOperation(value = "投诉建议接口", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertComplaintApplication(
        @ApiParam(value = "投诉对象", required = true) @RequestParam(required = true) String complaintTarget,
        @ApiParam(value = "头数建议内容", required = true) @RequestParam(required = true) String complaintContent,
        @ApiParam(value = "验证码", required = true) @RequestParam(required = true) String code
	) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        String ip = this.getIP();
        Complaintapplication complaintapplication = new Complaintapplication();
        complaintapplication.setComplainttarget(complaintTarget);
        complaintapplication.setComplaintcontent(complaintContent);

        return complaintApplicationService.insertComplaintApplication(accountInfo, complaintapplication, code, ip);
	}
}
