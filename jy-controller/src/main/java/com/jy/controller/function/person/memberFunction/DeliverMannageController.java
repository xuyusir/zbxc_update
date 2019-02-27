package com.jy.controller.function.person.memberFunction;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.service.function.person.memberFunction.DeliverMannageService;
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
 * @ClassName:  DeliverMannageController   
 * @Description:投递审核处理Controller
 * @author: chenye
 * @date:   2018-09-03 14:56
 */
@Controller
@RequestMapping("/DeliverMannage")
@Api(tags = "DeliverMannageController", description = "功能-会员功能-投递审核处理")
public class DeliverMannageController extends BaseController {
	
	@Resource
	private DeliverMannageService deliverMannageService;
	
	
	@ApiOperation(value = "获取投递申请列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getDeliveryApplicationList(
			@ApiParam(value = "申请状态:0全部,1.待处理,2.已处理,3.已拒绝", required = false) @RequestParam(required = false, defaultValue = "0") Integer applicationStatus,
			@ApiParam(value = "是否是会员:0全部,1.是, 2.不是", required = false) @RequestParam(required = false, defaultValue = "0") Integer isMember,
			@ApiParam(value = "申请时间:模糊查询当天记录", required = false) @RequestParam(required = false, defaultValue = "") String applicationTime,
			@ApiParam(value = "关键词: 申请职位人姓名/手机号", required = false) @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam(value = "页码", required = false) @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每页加载记录数", required = false) @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {


		return deliverMannageService.getDeliveryApplicationList(applicationStatus,isMember, applicationTime, search, page, pageSize);
	}

	@ApiOperation(value = "处理投递申请", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result processingDelivery(
			@ApiParam(value = "要处理的申请列表,id用,隔开", required = true) @RequestParam(required = true) String ids,
			@ApiParam(value = "申请状态id", required = true) @RequestParam(required = true) Integer applicationStatusID
	) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return deliverMannageService.processingDelivery(accountInfo, AuthorityCode.MEMBER_FUNCTION_DELIVER_DISPOSE, ids, applicationStatusID);
	}
	
	


}
