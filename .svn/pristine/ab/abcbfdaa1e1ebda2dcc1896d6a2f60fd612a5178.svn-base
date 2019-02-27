package com.jy.controller.system.select;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.system.select.Select;
import com.jy.service.system.select.SelectService;
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
 * @ClassName:  SelectController   
 * @Description:配置表统一处理接口
 * @author: cheng fei
 * @date:   2018-09-18 17:07
 */

@Controller
@RequestMapping("system/select")
@Api(tags="system.select.SelectController",description ="系统-下拉列表-下拉列表模块")
public class SelectController extends BaseController{

	@Resource
	private SelectService selectService;
	
	@ApiOperation(value = "添加配置", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "",method = RequestMethod.POST)
	@ResponseBody
	public Result insert(
			@ApiParam(value = "配置表在配置表的配置表中的 ID", required = true) @RequestParam(required =true) Integer table_id,
			@ApiParam(value = "名称", required = true)  @RequestParam(required =true) String name,
			@ApiParam(value = "固定编码", required = true)  @RequestParam(required =true) String code,
			@ApiParam(value = "排序码", required = true)  @RequestParam(required =true) Integer display_order,
			@ApiParam(value = "备注", required = true)  @RequestParam(required =true) String remark
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Select select = new Select();
		select.setTableID(table_id);
		select.setName(name);
		select.setCode(code);
		select.setDisplayOrder(display_order);
		select.setRemark(remark);
		return selectService.insert(accountInfo, AuthorityCode.SYSTEM_SELECT_INSERT_AUTHORITY, select);
	}
	
	@ApiOperation(value = "删除配置", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteSelect(
		   @ApiParam(value = "配置表在配置表的配置表中的 ID", required = true) @RequestParam(required = true) Integer table_id,
		   @ApiParam(value = "要删除的记录主键", required = true) @RequestParam(required =true) Integer id
			) throws MyException {
		//获取当前登录用户信息
		AccountInfo accountInfo = this.getAccountInfo();
		return selectService.deleteSelect(accountInfo,AuthorityCode.SYSTEM_SELECT_DELETE_AUTHORITY,table_id, id);
	}
	
	@ApiOperation(value = "修改配置", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateSelect(
			@ApiParam(value = "配置表在配置表的配置表中的 ID", required = true) Integer table_id,
			@ApiParam(value = "主键", required = true) @RequestParam(required =true) Integer id,
			@ApiParam(value = "名称", required = true)  @RequestParam(required =true) String name,
			@ApiParam(value = "固定编码", required = true)  @RequestParam(required =true) String code,
			@ApiParam(value = "排序码", required = true)  @RequestParam(required =true) Integer display_order,
			@ApiParam(value = "备注", required = true)  @RequestParam(required =true) String remark
			) throws MyException {
		//获取当前登录用户信息
		AccountInfo accountInfo = this.getAccountInfo();
		Select select = new Select();
		select.setTableID(table_id);
		select.setId(id);
		select.setName(name);
		select.setRemark(remark);
		select.setDisplayOrder(display_order);
		select.setCode(code);
		
		return selectService.updateSelect(accountInfo,AuthorityCode.SYSTEM_SELECT_UPDATE_AUTHORITY,select);
	}
	
	@ApiOperation(value = "修改配置的状态", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/status", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateSelectStatus(
			@ApiParam(value = "配置表在配置表的配置表中的 ID", required = true) Integer table_id,
			@ApiParam(value = "主键", required = true) @RequestParam(required =true) Integer id,
			@ApiParam(value = "排序码", required = true)  @RequestParam(required =true) Integer status
			) throws MyException {
		//获取当前登录用户信息
		AccountInfo accountInfo = this.getAccountInfo();
		Select select = new Select();
		select.setTableID(table_id);
		select.setId(id);
		select.setStatus(status);
		
		return selectService.updateSelect(accountInfo,AuthorityCode.SYSTEM_SELECT_UPDATE_STATUS_AUTHORITY,select);
	}
	
	@ApiOperation(value = "查询配置", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Result getSelect (
		   @ApiParam(value = "配置表在配置表的配置表中的 ID", required = true) Integer table_id,
		   @ApiParam(value = "配置表的 ID", required = true) Integer id
			) throws MyException {
		//获取当前登录用户信息
		AccountInfo accountInfo = this.getAccountInfo();
		
		return selectService.getSelect(accountInfo, table_id, id);
	}
	
	@ApiOperation(value = "加载下拉列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/select/id",method = RequestMethod.GET)
	@ResponseBody
	public Result getSelectByID(
			@ApiParam(value = "配置表在配置表的配置表中的 ID", required = true) @RequestParam Integer table_id
			) throws MyException {
		return selectService.getSelectByID(table_id);
	}
	
	@ApiOperation(value = "加载下拉列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/select/name",method = RequestMethod.GET)
	@ResponseBody
	public Result getSelectByName(
			@ApiParam(value = "配置表名称", required = true) @RequestParam(required = true) String table_name
			) throws MyException {
		return selectService.getSelectByName(table_name);
	}
	
	@ApiOperation(value = "加载配置列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	@ResponseBody
	public Result getSelectList(
			@ApiParam(value = "配置表在配置表的配置表中的 ID", required = true) @RequestParam Integer table_id
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return selectService.getSelectList(accountInfo, table_id);
	}
	
	@ApiOperation(value ="验证固定编码", httpMethod = "PATCH", produces = "application/json")
	@RequestMapping(value = "/check/code",method = RequestMethod.PATCH)
	@ResponseBody
	public Result checkCode(
			@ApiParam(value = "配置表在配置表的配置表中的 ID", required = true) @RequestParam(required = true) Integer table_id,
			@ApiParam(value = "固定编码", required = true) @RequestParam(required = true) String code,
			@ApiParam(value = "要排除的主键", required = false) @RequestParam(required = false, defaultValue = "") Integer id
			) {
		return selectService.checkCode(code,table_id, id);
	}
}
