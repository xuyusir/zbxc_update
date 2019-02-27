package com.jy.controller.account.account;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.utils.JsonUtils;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.service.account.account.AccountService;
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
 * @ClassName:  ManageAccountController
 * @Description:管理员账号模块
 * @author: cheng fei
 * @date:   2018-10-07 11:26
 */
@Controller
@RequestMapping("/account/manage")
@Api(tags = "account.account.ManageAccountController", description = "账号-账号-管理员账号模块")
public class ManageAccountController extends BaseController{

	@Resource
	private AccountService accountService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加管理员账号接口", httpMethod = "POST", produces = "application/json")
	public Result insertManageAccount(
			@ApiParam(value = "用户名", required = true) @RequestParam(required = true) String username,
			@ApiParam(value = "密码", required = true) @RequestParam(required =true) String password,
			@ApiParam(value = "确认密码", required = true) @RequestParam(required =true) String confirm_password,
			@ApiParam(value = "姓名", required = true) @RequestParam(required =true)String name,
			@ApiParam(value = "邮箱", required = true) @RequestParam(required =true)String email,
			@ApiParam(value = "电话", required = true) @RequestParam(required =true)String phone,
			@ApiParam(value = "用户组ID", required = true) @RequestParam(required = true) Integer role_id,
			@ApiParam(value = "审核", required = true) @RequestParam(required = true) Integer status
			) throws Exception{
		AccountInfo accountInfo = this.getAccountInfo();
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(password);
		account.setName(name);
		account.setEmail(email);
		account.setPhone(phone);
		account.setRoleid(role_id);
		account.setStatus(status);
		return accountService.insertManageAccount(accountInfo, AuthorityCode.ACCOUNT_MANAGE_ACCOUNT_INSERT_AUTHORITY, account, confirm_password);
	}


	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改管理员账号接口", httpMethod = "PUT", produces = "application/json")
	public Result updateManageAccount(
			@ApiParam(value = "账号ID", required = true) @RequestParam(required = true) Long account_id,
			@ApiParam(value = "用户名", required = true) @RequestParam(required = true) String username,
			@ApiParam(value = "密码", required = true) @RequestParam(required =true) String password,
			@ApiParam(value = "确认密码", required = true) @RequestParam(required =true) String confirm_password,
			@ApiParam(value = "姓名", required = true) @RequestParam(required =true)String name,
			@ApiParam(value = "邮箱", required = true) @RequestParam(required =true)String email,
			@ApiParam(value = "电话", required = true) @RequestParam(required =true)String phone,
			@ApiParam(value = "用户组ID", required = true) @RequestParam(required = true) Integer role_id,
			@ApiParam(value = "审核", required = true) @RequestParam(required = true) Integer status
			) throws Exception{
		AccountInfo accountInfo = this.getAccountInfo();
		Account account = new Account();
		account.setAccountid(account_id);
		account.setUsername(username);
		account.setPassword(password);
		account.setName(name);
		account.setEmail(email);
		account.setPhone(phone);
		account.setRoleid(role_id);
		account.setStatus(status);
		return accountService.updateManageAccount(accountInfo, AuthorityCode.ACCOUNT_MANAGE_ACCOUNT_UPDATE_AUTHORITY, account, confirm_password);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "加载管理员账号信息",  httpMethod = "GET", produces = "application/json")
	public Result getEnterpriseAccount(
			@ApiParam(value = "账号ID", required = true) @RequestParam(required = true) Long account_id
			) {
        AccountInfo accountInfo = this.getAccountInfo();
        return accountService.getAccount(accountInfo, account_id) ;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE )
	@ResponseBody
	@ApiOperation(value = "批量删除管理员账号接口", httpMethod = "DELETE", produces = "application/json")
	public Result deleteManageAccountAll(
			@ApiParam(value = "要删除的账号ID列表,用\",\"号隔开", required = true) @RequestParam(required = true) String account_ids
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.deleteManageAccountAll(accountInfo, AuthorityCode.ACCOUNT_MANAGE_ACCOUNT_DELETE_AUTHORITY, account_ids);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "查询管理员账号列表接口", httpMethod = "POST", produces = "application/json")
	public Result getManageAccountList(
			@ApiParam(value = "是否删除true/false", required = false) @RequestParam(required = false, defaultValue = "false") boolean isDelete,
			@ApiParam(value = "关键字,用户名,姓名,邮箱", required = false) @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam(value = "页码", required = false) @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每页显示条数", required = false) @RequestParam(required = false, defaultValue = "10") Integer page_size
			) throws Exception{
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.getManageAccountList(accountInfo, isDelete, search, page, page_size);
	}

	@RequestMapping(value = "/status", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "批量启用/禁用管理员账号接口", httpMethod = "PUT", produces = "application/json")
	public Result updateManageAccountStatus(
			@ApiParam(value = "账号ID列表,用\",\"隔开", required = true) @RequestParam(required = true ) String account_ids,
			@ApiParam(value = "状态:0禁用,1启用", required = true) @RequestParam( required = true) Integer status
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.updateAccountStatus(accountInfo, AuthorityCode.ACCOUNT_MANAGE_ACCOUNT_UPDATE_STATUS_AUTHORITY, account_ids, status);
	}

	@RequestMapping(value = "/export", method = RequestMethod.GET)
	@ApiOperation(value = "导出列表接口", httpMethod = "GET", produces = "application/json")
	public Result exportManageAccountList(
			@ApiParam(value = "关键字,用户名,姓名,邮箱", required = false) @RequestParam(required = false, defaultValue = "") String search,
			@ApiParam(hidden = true)HttpServletResponse response
			) throws MyException, IOException{
		AccountInfo accountInfo = this.getAccountInfo();
		search = new String(search.getBytes("ISO-8859-1"), "utf-8");
		Result result = accountService.exportManageAccountList(accountInfo, AuthorityCode.ACCOUNT_MANAGE_ACCOUNT_EXPORT_AUTHORITY, search);
		if (result.getStatus() != 200) {
			response.getWriter().println(JsonUtils.objectToJson(result));
		}else {
			HSSFWorkbook workbook = (HSSFWorkbook) result.getData();
			//设置请求头
			response.setContentType("application/vnd.ms-excel");
		    response.setHeader("Content-disposition", "attachment; filename=" + new String("中博星辰管理员账号列表.xls".getBytes("utf-8"), "ISO8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
		}
		return null;
	}

	@ApiOperation(value = "回收管理员账号接口", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/recycle", method = RequestMethod.PUT)
	@ResponseBody
	public Result recycleManageAccount(
			@ApiParam(value = "要回收的账号ID列表,用\",\"号隔开", required = true) @RequestParam(required = true) String ids
	) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return accountService.recycleAccount(accountInfo, AuthorityCode.ACCOUNT_MANAGE_ACCOUNT_RECYCLE_AUTHORITY, ids, 1);
	}


}
