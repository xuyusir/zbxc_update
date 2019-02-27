package com.jy.controller.system.dictionaries;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.system.dictionaries.Dictionaries;
import com.jy.service.system.dictionaries.DictionariesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @ClassName:  DictionariesController   
 * @Description:数据字典Controller 
 * @author: cheng fei
 * @date:   2018-08-05 11:54
 */
@Controller
@RequestMapping("system/dictionaries")
@Api(tags = "system.dictionaries.DictionariesController", description = "系统-数据字典-字典模块模块")
public class DictionariesController extends BaseController{

	@Resource
	private DictionariesService dictionariesService;


	@ApiOperation(value = "加载一个数据字典", httpMethod ="GET", produces = "application/json")
	@RequestMapping(value ="", method = RequestMethod.GET)
	@ResponseBody
	public Result getDictionariesById(
			@ApiParam(value = "数据字典id") @RequestParam(required = true) Integer id
			
			) {
		AccountInfo accountInfo = this.getAccountInfo();
		return dictionariesService.getDictionariesById(accountInfo, id);
	}
	

	@ApiOperation(value = "添加数据字典", httpMethod ="POST", produces = "application/json")
	@RequestMapping(value = "" ,method = RequestMethod.POST)
	@ResponseBody
	public Result insertDictionaries(
			@ApiParam(value = "父节点id") @RequestParam(required = true) Integer parentId,
			@ApiParam(value = "数据字典名字") @RequestParam(required = true) String name,
			@ApiParam(value = "数据字典编码") @RequestParam(required = true) String code,
			@ApiParam(value = "数据字典排序码") @RequestParam(required = true) Integer display_order
			
			) throws MyException {
		Dictionaries dictionaries = new Dictionaries();
		dictionaries.setParentid(parentId);
		dictionaries.setName(name);
		dictionaries.setCode(code);
		dictionaries.setDisplayorder(display_order);;
		AccountInfo accountInfo = this.getAccountInfo();
		return dictionariesService.InsertDictionaries(accountInfo, AuthorityCode.SYSTEM_DICTIONARIES_INSERT_AUTHORITY, dictionaries);
	}
	

	@ApiOperation(value = "修改数据字典", httpMethod ="PUT", produces = "application/json")
	@RequestMapping(value = "" ,method = RequestMethod.PUT)
	@ResponseBody
	public Result updateDictionaries(
			@ApiParam(value = "数据字典ID") @RequestParam(required = false) Integer dictionaries_id,
			@ApiParam(value = "数据字典名字") @RequestParam(required = false) String name,
			@ApiParam(value = "数据字典编码") @RequestParam(required = false) String code,
			@ApiParam(value = "数据字典排序码") @RequestParam(required = false) Integer display_order,
			@ApiParam(value = "状态") @RequestParam(required = false) Integer status
			
			) throws MyException {
		Dictionaries dictionaries = new Dictionaries();
		dictionaries.setDictionariesid(dictionaries_id);
		dictionaries.setName(name);
		dictionaries.setCode(code);
		dictionaries.setDisplayorder(display_order);
		dictionaries.setStatus(status);
		AccountInfo accountInfo = this.getAccountInfo();
		return dictionariesService.updateDictionaries(accountInfo, AuthorityCode.SYSTEM_DICTIONARIES_UPDATE_AUTHORITY, dictionaries);
	}

	@ApiOperation(value = "启用/禁用数据字典接口", httpMethod ="PUT", produces = "application/json")
	@RequestMapping(value = "/status" ,method = RequestMethod.PUT)
	@ResponseBody
	public Result updateDictionaries(
			@ApiParam(value = "数据字典ID") @RequestParam(required = false) Integer dictionaries_id,
			@ApiParam(value = "状态") @RequestParam(required = false) Integer status

	) throws MyException {
		Dictionaries dictionaries = new Dictionaries();
		dictionaries.setDictionariesid(dictionaries_id);
		dictionaries.setStatus(status);
		AccountInfo accountInfo = this.getAccountInfo();
		return dictionariesService.updateDictionaries(accountInfo, AuthorityCode.SYSTEM_DICTIONARIES_UPDATE_STATUS_AUTHORITY, dictionaries);
	}


	@ApiOperation(value = "删除数据字典", httpMethod ="DELETE" , produces = "application/json")
	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteDictionaries(
			@PathVariable @ApiParam(value = "id", required = true) Integer id
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return dictionariesService.deleteDictionaries(accountInfo, AuthorityCode.SYSTEM_DICTIONARIES_DELETE_AUTHORITY, id);
	}
	
	
	/**
	 * 获取下拉列表
	 * @param code
	 * @return
	 */
	@ApiOperation(value = "加载数据字典下拉列表", httpMethod ="GET", produces = "application/json")
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public Result getSelectDictionaries(
			@ApiParam(value = "数据字典编码") @RequestParam(required = true) String code
			) {
		return dictionariesService.getSelectDictionariesByCode(code);
	}
	

	@ApiOperation(value = "加载数据字典所有父节点" , httpMethod ="GET", produces = "application/json")
	@RequestMapping(value = "/parentName", method = RequestMethod.GET)
	@ResponseBody
	public Result getParentDictionaries(
			@ApiParam(value = "父节点id") @RequestParam(required = true) Integer parent_id
			
			) {
		AccountInfo accountInfo = this.getAccountInfo();
		return dictionariesService.getParentDictionaries(accountInfo, parent_id);
	}
	

	/**
	 * 获取数据字典列表
	 * @param parent_id
	 * @return
	 */
	@ApiOperation(value = "加载数据字典列表" , httpMethod ="POST", produces = "application/json")
	@RequestMapping(value = "/list",method = RequestMethod.POST)
	@ResponseBody
	public Result getSelectDictionaries(
			@ApiParam(value = "父节点") @RequestParam(required = false, defaultValue = "0") Integer parent_id, 
			@ApiParam(value = "查询关键字") @RequestParam(required = false,defaultValue = "") String search ,
			@ApiParam(value = "加载页码") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize
			) {
		AccountInfo accountInfo = this.getAccountInfo();
		return dictionariesService.getDictionaries(accountInfo, parent_id,search, page ,pageSize);
	}
	
	/**
	 * 检测数据字典code是否可用
	 * @param code
	 * @return
	 */
	@ApiOperation(value = "检测数据字典编码是否可用" , httpMethod ="PATCH", produces = "application/json")
	@RequestMapping(value = "/check/code", method = RequestMethod.PATCH)
	@ResponseBody
	public Result checkCode(
			@ApiParam(value = "数据字典编码", required = true) String code, 
			@ApiParam(value = "排除检测的数据字典id",required = false) Integer id
			) {

		return dictionariesService.checkCode(code,id);
	}
	
	
}
