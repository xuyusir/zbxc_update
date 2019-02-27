package com.jy.controller.account.account;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.service.account.account.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 * @ClassName:  PublicAccountController
 * @Description :账号公用模块
 * @author: cheng fei
 * @date:   2018-10-07 11:21
 */
@Controller
@RequestMapping("/account/public")
@Api(tags = "account.account.PublicAccountController", description = "账号-账号-账号共用模块")
public class PublicAccountController extends BaseController{

	@Resource
	private AccountService accountService;

	/**
	 * web端服务器地址
	 */
	@Value("${WEB_SERVER_URL}")
	private  String webServerUrl;



	@ApiOperation(value = "检测用户名是否可用", httpMethod = "PATCH", produces = "application/json")
	@RequestMapping(value = "/check/userName", method = RequestMethod.PATCH)
	@ResponseBody
	public Result checkUserName(
			@ApiParam(value = "排除id", required = false) Long id,
			@ApiParam(value = "要检测的用户名", required = true) String username
			) {
		return accountService.checkUserName(id, username);
	}

	@ApiOperation(value = "检测电话是否可用", httpMethod = "PATCH", produces = "application/json")
	@RequestMapping(value = "/check/phone", method = RequestMethod.PATCH)
	@ResponseBody
	public Result checkPhone(
			@ApiParam(value = "排除id", required = false) Long id,
			@ApiParam(value = "要检测的电话号码", required = true) String phone
			) {
		return accountService.checkPhone(id, phone);
	}

	@ApiOperation(value = "检测邮箱是否可用", httpMethod = "PATCH", produces = "application/json")
	@RequestMapping(value = "/check/email", method = RequestMethod.PATCH)
	@ResponseBody
	public Result checkEmail(
			@ApiParam(value = "排除id", required = false) @RequestParam(required = false) Long id,
			@ApiParam(value = "要检测的邮箱", required = true) String email
			) {
		return accountService.checkEmail(id, email);
	}


	@ApiOperation(value = "修改账号密码", httpMethod = "PUT", produces = "application/json" )
	@RequestMapping(value = "/password", method = RequestMethod.PUT)
	@ResponseBody
	public Result updatePassWord(
			@ApiParam(value = "旧密码", required = true) @RequestParam String old_password,
			@ApiParam(value = "新密码", required = true) @RequestParam String password,
			@ApiParam(value = "确认密码", required = true) @RequestParam String confirm_password
			) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.updatePassWord(accountInfo, old_password, password, confirm_password);
	}

	@ApiOperation(value = "确认邮箱验证", httpMethod = "GET", produces = "application/json", hidden = false)
	@RequestMapping(value = "/jsp", method = RequestMethod.GET)
	public String JSP(
			@ApiParam(value = "邮箱验证Token", required = true, hidden = true) @RequestParam(required = true) String emailToken,
            @ApiParam(value = "回调地址", required = true) @RequestParam(required = true) String redirectUrl
			) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        Result result = accountService.updateEmail(accountInfo, emailToken);
        accountInfo = (AccountInfo) result.getData();
        return "redirect:" + webServerUrl + "/" + redirectUrl + "?token=" + accountInfo.getToken() + "&email=" + accountInfo.getAccount().getEmail();
	}

	@ApiOperation(value = "找回密码(手机)", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/reset/password", method = RequestMethod.POST)
	@ResponseBody
	public Result resetPasswordByPhone(
			@ApiParam(value = "手机号", required = true) String phone,
			@ApiParam(value = "验证码", required = true) String code,
			@ApiParam(value = "新密码", required = true) String password,
			@ApiParam(value = "确认新密码", required = true) String confirm_password
			) throws Exception {
		return accountService.resetPasswordByPhone(phone, code, password, confirm_password);
	}

	@ApiOperation(value = "找回密码(邮箱)", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/reset/password", method = RequestMethod.PUT)
	@ResponseBody
	public Result resetPasswordByEmail(
			@ApiParam(value = "邮箱", required = true) String email,
			@ApiParam(value = "验证码", required = true) String code,
			@ApiParam(value = "新密码", required = true) String password,
			@ApiParam(value = "确认新密码", required = true) String confirm_password
			) throws Exception {
		return accountService.resetPasswordByEmail(email, code, password, confirm_password);
	}

	@ApiOperation(value = "修改账号手机号接口", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/update/phone", method = RequestMethod.PUT)
	@ResponseBody
	public Result updatePhone(
		@ApiParam(value = "新手机号", required = true) @RequestParam(required = true) String phone,
		@ApiParam(value = "验证码", required = true) @RequestParam(required = true) String code
	) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return accountService.updatePhone(accountInfo, phone, code);
	}

	@ApiOperation(value = "修改账号头像接口", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/update/head/photo", method = RequestMethod.PUT)
	@ResponseBody
	public Result updageHeadPhoto(
			@ApiParam(value = "头像文件ID", required = true) @RequestParam(required = true) Long headPhotoFileID
	) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return accountService.updateHeadPhoto(accountInfo, headPhotoFileID);
    }

}
