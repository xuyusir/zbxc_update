package com.jy.controller.account.account;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.JsonUtils;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.function.person.info.Personinfo;
import com.jy.entiy.system.inMail.Message;
import com.jy.entiy.system.inMail.Messagetext;
import com.jy.service.account.account.AccountService;
import com.jy.service.system.email.SetingMailService;
import com.jy.service.system.inMail.InMailService;
import com.jy.service.system.login.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: PersonAccountController
 * @Description:个人账号模块
 * @author: cheng fei
 * @date: 2018-10-07 11:32
 */

@Controller
@RequestMapping("/account/person")
@Api(tags = "account.account.PersonAccountController", description = "账号-账号-个人账号模块")
public class PersonAccountController extends BaseController {

	@Resource
	private AccountService accountService;

	@Resource
	private InMailService inMailService;

	@Resource
	private SetingMailService setingMailService;

	@Resource
	private LoginService loginService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加个人账号接口", httpMethod = "POST", produces = "application/json")
	public Result insertPersonAccount(
			@ApiParam(value = "姓名", required = true) @RequestParam(required = true) String name,
			@ApiParam(value = "手机号", required = true) @RequestParam(required = true) String phone,
			@ApiParam(value = "邮箱", required = true) @RequestParam(required = true) String email,
			@ApiParam(value = "密码", required = true) @RequestParam(required = true) String password,
			@ApiParam(value = "确认密码", required = true) @RequestParam(required = true) String confirm_password)
			throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		Account account = new Account();
		account.setName(name);
		account.setPhone(phone);
		account.setEmail(email);
		account.setPassword(password);
		return accountService.insertPersonAccount(accountInfo, AuthorityCode.ACCOUNT_PERSON_ACCOUNT_INSERT_AUTHORITY, account, confirm_password);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "注册个人账号接口", httpMethod = "POST", produces = "application/json")
	public Result registerPersonAccount(
			@ApiParam(value = "手机号码", required = true) @RequestParam(required = true) String phone,
			@ApiParam(value = "code", required = true) @RequestParam(required = true) String code,
			@ApiParam(value = "密码", required = true) @RequestParam(required = true) String password,
			@ApiParam(value = "确认密码", required = true) @RequestParam(required = true) String confirm_password)
			throws Exception {

		// 注册账号
		Result result = accountService.registerPersonAccount(phone, code, password, confirm_password);
		if (result.getStatus() != 200) {
			return result;
		}
		String ip = this.getIP();
		String requestHome = this.getRequestHome();
		// 登陆
		Result loginSuccess = loginService.loginSuccess((Account) result.getData(), ip, false,requestHome);
		return loginSuccess;
	}

	@RequestMapping(value = "/person/data", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "完善个人资料接口", httpMethod = "POST", produces = "application/json")
	public Result insertPersonInfo(
			@ApiParam(value = "姓名", required = false) @RequestParam(required = false) String name,
			@ApiParam(value = "性别", required = false) @RequestParam(required = false) String sex,
			@ApiParam(value = "出生年", required = false) @RequestParam(required = false) String birth_year,
			@ApiParam(value = "出生月", required = false) @RequestParam(required = false) String birth_month,
			@ApiParam(value = "院校", required = false) @RequestParam(required = false) String university,
			@ApiParam(value = "学历证书", required = false) @RequestParam(required = false) Integer education_id,
			@ApiParam(value = "年级", required = false) @RequestParam(required = false) String grade,
			@ApiParam(value = "专业", required = false) @RequestParam(required = false) String specialty,
			@ApiParam(value = "省Code", required = false) @RequestParam(required = false) String province_code,
			@ApiParam(value = "市Code", required = false) @RequestParam(required = false) String city_code,
			@ApiParam(value = "县Code", required = false) @RequestParam(required = false) String county_code
		) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Personinfo personinfo = new Personinfo();
		personinfo.setName(name);
		personinfo.setSex(sex);
		personinfo.setBirthyear(birth_year);
		personinfo.setBirthmonth(birth_month);
		personinfo.setUniversity(university);
		personinfo.setEducationid(education_id);
		personinfo.setGrade(grade);
		personinfo.setSpecialty(specialty);
		personinfo.setProvincecode(province_code);
		personinfo.setCitycode(city_code);
		personinfo.setCountycode(county_code);

		return accountService.insertPersonData(accountInfo, personinfo);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "修改个人账号信息",  httpMethod = "POST", produces = "application/json")
	public Result updatePersonInfo(
			@ApiParam(value = "姓名", required = true) @RequestParam(required = true) String name,
			@ApiParam(value = "性别", required = true) @RequestParam(required = true) String sex
	) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.updatePersonInfo(accountInfo, name, sex);
	}


	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "加载个人账号信息(仅管理员账号可用)",  httpMethod = "GET", produces = "application/json")
	public Result getEnterpriseAccount(
			@ApiParam(value = "账号ID", required = true) @RequestParam(required = true) Long account_id
			) {
        AccountInfo accountInfo = this.getAccountInfo();
        return accountService.getAccount(accountInfo, account_id) ;
	}

	/*@RequestMapping(value = "/person/data", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "加载个人资料接口", httpMethod = "GET", produces = "application/json")
	public Result getPersonInfo() {
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.getPersonInfo(accountInfo);
	}*/

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改个人账号接口", httpMethod = "PUT", produces = "application/json")
	public Result updatePersonAccount(
			@ApiParam(value = "账号ID", required = true) @RequestParam(required = true) Long account_id,
			@ApiParam(value = "姓名", required = true) @RequestParam(required = true) String name,
			@ApiParam(value = "手机号", required = true) @RequestParam(required = true) String phone,
			@ApiParam(value = "邮箱", required = true) @RequestParam(required = true) String email,
			@ApiParam(value = "密码", required = true) @RequestParam(required = true) String password,
			@ApiParam(value = "确认密码", required = true) @RequestParam(required = true) String confirm_password)
			throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		Account account = new Account();
		account.setAccountid(account_id);
		account.setName(name);
		account.setPhone(phone);
		account.setEmail(email);
		account.setPassword(password);

		return accountService.updatePersonAccount(accountInfo, AuthorityCode.ACCOUNT_PERSON_ACCOUNT_UPDATE_AUTHORITY, account, confirm_password);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "批量删除企业账号接口", httpMethod = "DELETE", produces = "application/json")
	public Result deletePersonAccountAll(
			@ApiParam(value = "要删除的账号ID列表,用\",\"号隔开", required = true) @RequestParam(required = true) String account_ids)
			throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.deletePersonAccountAll(accountInfo, AuthorityCode.ACCOUNT_PERSON_ACCOUNT_DELETE_AUTHORITY,account_ids);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "查询个人账号列表接口", httpMethod = "POST", produces = "application/json")
	public Result getPersonAccountList(
			@ApiParam(value = "是否删除true/false", required = false) @RequestParam(required = false, defaultValue = "false") boolean isDelete,
			@ApiParam(value = "个人账号类型:0全部,1会员,2非会员", required = false) @RequestParam(required = false, defaultValue = "0") Integer account_type,
			@ApiParam(value = "关键字,模糊查询姓名,联系电话,邮箱", required = false) @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam(value = "页码", required = false) @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每页显示条数", required = false) @RequestParam(required = false, defaultValue = "10") Integer page_size
	)throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.getPersonAccountList(accountInfo, isDelete, account_type, search, page, page_size);
	}

	@RequestMapping(value = "/send/inMail", method = RequestMethod.PATCH)
	@ResponseBody
	@ApiOperation(value = "发送站内信接口", httpMethod = "PATCH", produces = "application/json")
	public Result sendInMail(@ApiParam(value = "标题", required = true) String title,
			@ApiParam(value = "内容", required = true) String content,
			@ApiParam(value = "接收人ID数组", required = true) Long[] recids) throws MyException {
		Messagetext messageText = new Messagetext();
		messageText.setTitle(title);
		messageText.setContent(content);
		AccountInfo accountInfo = this.getAccountInfo();
		inMailService.writeMail(accountInfo, AuthorityCode.ACCOUNT_PERSON_ACCOUNT_SEND_INMAIL_AUTHORITY, messageText);
		Message message = new Message();
		Long accountid = accountInfo.getAccount().getAccountid();
		String name = accountInfo.getAccount().getName();
		message.setCreateby(name);
		message.setCreatepersonid(accountid);
		message.setSendid(accountid);
		message.setMessageid(messageText.getId());
		for (int i = 0; i < recids.length; i++) {
			message.setRecid(recids[i]);
			inMailService.sendMail(accountInfo, AuthorityCode.ACCOUNT_PERSON_ACCOUNT_SEND_INMAIL_AUTHORITY, message);
		}
		return Result.succee();
	}

	@RequestMapping(value = "/send/email", method = RequestMethod.PATCH)
	@ResponseBody
	@ApiOperation(value = "发送邮件接口", httpMethod = "PATCH", produces = "application/json")
	public Result SendEmail(@ApiParam(value = "邮件标题", required = false) String title,
			@ApiParam(value = "邮件正文", required = false) String content,
			@ApiParam(value = "邮件附件", required = false) String[] Files,
			@ApiParam(value = "目标邮箱", required = false) String[] RmailIPs) throws Exception {
		AccountInfo accountInfo = this.getAccountInfo();
		return setingMailService.sendMail(accountInfo, AuthorityCode.ACCOUNT_PERSON_ACCOUNT_SEND_EMAIL_AUTHORITY, true,
				title, content, Files, RmailIPs);
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	@ApiOperation(value = "导出列表接口", httpMethod = "GET", produces = "application/json")
	public Result exportPersonAccountList(
			@ApiParam(value = "个人账号类型:0全部,1会员,2非会员", required = false) @RequestParam(required = false, defaultValue = "0") Integer accountType,
			@ApiParam(value = "关键字,模糊查询姓名,联系电话,邮箱", required = false) @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam(hidden = true)HttpServletResponse response
	) throws MyException, IOException {
		AccountInfo accountInfo = this.getAccountInfo();
		search = new String(search.getBytes("ISO-8859-1"), "utf-8");
		Result result = accountService.exportPersonAccountList(accountInfo, AuthorityCode.ACCOUNT_PERSON_ACCOUNT_EXPORT_AUTHORITY, accountType, search);
		if (result.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			response.getWriter().println(JsonUtils.objectToJson(result));
		} else {
			HSSFWorkbook workbook = (HSSFWorkbook) result.getData();
			// 设置请求头
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String("中博星辰个人账号列表.xls".getBytes("utf-8"), "ISO8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
		}
		return null;
	}

	@ApiOperation(value = "回收个人账号接口", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/recycle", method = RequestMethod.PUT)
	@ResponseBody
	public Result recycleEnterpriseAccount(
			@ApiParam(value = "要回收的账号ID列表,用\",\"号隔开", required = true) @RequestParam(required = true) String ids
	) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.recycleAccount(accountInfo, AuthorityCode.ACCOUNT_PERSON_ACCOUNT_RECYCLE_AUTHORITY, ids, 2);
	}
}
