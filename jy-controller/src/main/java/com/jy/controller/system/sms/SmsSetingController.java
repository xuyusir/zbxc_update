package com.jy.controller.system.sms;

import com.aliyuncs.exceptions.ClientException;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.system.sms.Setsms;
import com.jy.service.system.sms.SmsService;
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
 * @ClassName: smsSetingController
 * @Description:短信设置Controller
 * @author: chenye
 * @date: 2018-08-14 18:18
 */

@Controller
@RequestMapping("system/sms")
@Api(tags = "system.sms.SmsSetingController", description = "系统-短信-短信设置模块")
public class SmsSetingController extends BaseController {

	@Resource
	SmsService smsService;

	/**
	 * 查询短信配置原设置
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询短信配置原设置", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Result getSetingSMS() {
		Setsms setingSMS = smsService.getSetingSMS();
		return Result.succee(setingSMS);

	}

	/**
	 * 短信设置
	 * 
	 * @return
	 * @throws MyException
	 */
	@ApiOperation(value = "设置短信", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/seting", method = RequestMethod.POST)
	@ResponseBody
	public Result setingSMS(Setsms sms) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();// 获取操作人员账号信息
		Setsms old_sms = smsService.getSetingSMS();
		if (old_sms != null) {
			Setsms setsms = new Setsms();
			setsms.setSetinfoid(sms.getSetinfoid());
			setsms.setLoginsend(sms.getLoginsend());
			setsms.setRegistedsend(sms.getRegistedsend());
			setsms.setState(sms.getState());
			return smsService.updatesetingSMS(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_SMS_AUTHORITY, setsms);
		} else {
			Setsms setsms = new Setsms();
			
			setsms.setLoginsend(sms.getLoginsend());
			setsms.setRegistedsend(sms.getRegistedsend());
			setsms.setState(sms.getState());
			return smsService.insertSetingSMS(accountInfo, AuthorityCode.SYSTEM_WEB_SETING_SMS_AUTHORITY, setsms);
		}

	}

	@ApiOperation(value = "发送短信", httpMethod = "PATCH", produces = "application/json")
	@RequestMapping(value = "/send", method = RequestMethod.PATCH)
	@ResponseBody
	public Result sendSMS(
			@ApiParam(value = "验证场景:1 短信测试,2 身份验证验证码,3 登录确认验证码,4 登录异常验证码,5 用户注册验证码,6 活动确认验证码,7 修改密码验证码,8 信息变更验证码", required = true) Integer scene,
			@ApiParam(value = "接收手机号", required = true) String phone,
			@ApiParam(value = "场景提示内容例登录场景时传入'中博星辰'", required = true) @RequestParam(required = false,defaultValue = "中博星辰") String product,
			@ApiParam(value = "获取活动确认验证码时的活动名称其他场景不传", required = true) String item,
			@ApiParam(value = "短信测试时使用参数其他场景不传", required = true) String customer) throws ClientException {
		return smsService.sendSms(scene, phone, product, item, customer);

	}

	// @ApiOperation(value = "发送短信验证码", httpMethod = "PATCH", produces =
	// "application/json")
	// @RequestMapping(value = "/send/sms/code", method = RequestMethod.PATCH)
	// @ResponseBody
	// public Result sendSMSCode(
	// @ApiParam(value = "手机号码", required = true) @RequestParam String phone
	// ) {
	// return smsService.sendSMSCode(phone);
	//
	// }

}
