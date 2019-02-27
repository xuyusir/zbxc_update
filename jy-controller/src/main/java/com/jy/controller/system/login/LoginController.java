package com.jy.controller.system.login;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.service.system.login.LoginService;
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
 * @ClassName:  LoginContrller
 * @Description:登录Controller
 * @author: cheng fei
 * @date:   2018-07-30 17:47
 */
@Controller
@RequestMapping("/system")
@Api(tags = "system.login.LoginController", description = "系统-登录-登录登出模块")
public class LoginController extends BaseController{

	@Resource
	private LoginService loginService;


	/**
	 * 登录
	 * @param data
	 * @param code
	 * @return
	 * @throws MyException
	 */
	@ApiOperation(value ="官网后台管理员登录" ,httpMethod = "POST", produces="application/json")
	@RequestMapping(value = "/manage/login",method = RequestMethod.POST)
	@ResponseBody
	public Result doManageLoging(
			@ApiParam(value = "账户密码加密后的数据", required = true) String data,
			@ApiParam(value = "验证码", required = true) String code
			) throws MyException {
		String ip = this.getIP();
        String requestHome = this.getRequestHome();
		return loginService.doManageLogin(data,ip,code,requestHome);
	}

	@ApiOperation(value = "官网账号登录", httpMethod = "POST", produces="application/json")
	@RequestMapping(value = "/uccn/login", method = RequestMethod.POST)
	@ResponseBody
	public Result douccnLoging(
			@ApiParam(value = "账户密码加密后的数据", required = true)@RequestParam(required = true) String data,
			@ApiParam(value = "验证码,手机端可以不用传递验证码", required = false) @RequestParam(required = false) String code,
			@ApiParam(value = "是否是签到登陆:true/false", required = false) @RequestParam(required = false, defaultValue = "false") boolean isSign
			) throws MyException {
		String ip = this.getIP();
        String requestHome = this.getRequestHome();
        return loginService.douccnLoging(data, ip, code, requestHome, isSign);
	}

	@ApiOperation(value = "官网手机验证码登录", httpMethod = "POST", produces="application/json")
	@RequestMapping(value = "/uccn/phone/login", method = RequestMethod.POST)
	@ResponseBody
	public Result doUccnPhoneLoging(
			@ApiParam(value = "手机号", required = true) String phone,
			@ApiParam(value = "验证码", required = true) String code
			) throws MyException {
		String ip = this.getIP();
        String requestHome = this.getRequestHome();
		return loginService.doUccnPhoneLoging(phone, ip, code, requestHome);
	}

	/**
	 * 登出
	 * @return
	 */
	@ApiOperation(value ="登出", httpMethod = "DELETE", produces="application/json")
	@RequestMapping(value ="/logout", method = RequestMethod.DELETE)
	@ResponseBody
	public Result logout() {
		AccountInfo accountInfo = this.getAccountInfo();
		return loginService.logout(accountInfo);
	}

	@ApiOperation(value = "检测登陆状态接口", httpMethod = "GET", produces = "application/json")
	@RequestMapping("/check/login")
	@ResponseBody
	public Result checkLogin(){
        AccountInfo accountInfo = this.getAccountInfo();
        return  Result.succee(accountInfo);
	}

	@ApiOperation(value = "获取账号信息", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/login/account/info", method = RequestMethod.POST)
	@ResponseBody
	public Result getAccountInfo(

			@ApiParam(value = "Token", required = true) @RequestParam(required = true) String token
	){
        String requestHome = this.getRequestHome();
		return loginService.getAccountInfo(token, requestHome);
	}


}

