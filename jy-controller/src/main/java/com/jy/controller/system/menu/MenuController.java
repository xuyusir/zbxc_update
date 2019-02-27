package com.jy.controller.system.menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.EasyUITreeNode;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.system.menu.Menu;
import com.jy.service.system.menu.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * @ClassName:  MenuController   
 * @Description:菜单Controller  
 * @author: cheng fei
 * @date:   2018-07-31 16:17
 */
@Controller
@RequestMapping("/system/menu")
@Api(tags = "system.menu.MenuController", description = "系统-菜单-菜单模块")
public class MenuController extends BaseController{
	
	@Resource
	private MenuService menuService ;

	@ApiOperation(value = "加载一个菜单", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public Result getMenu(
			@ApiParam(value = "菜单id", required = true)Integer menu_id
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
        return menuService.getMenu(accountInfo, menu_id);
	}
	

	@ApiOperation(value = "添加菜单", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertMenu(
			@ApiParam(value = "父菜单id") @RequestParam(required = false, defaultValue = "0") Integer parent_id, 
			@ApiParam(value = "菜单名") @RequestParam(required = true) String name, 
			@ApiParam(value = "菜单地址") @RequestParam(required = false, defaultValue = "#") String url, 
			@ApiParam(value = "菜单排序码") @RequestParam(required= true) Integer display_order
			) throws MyException {
		Menu menu = new Menu();
		menu.setParentid(parent_id);
		menu.setName(name);
		menu.setUrl(url);
		menu.setDisplayorder(display_order);
		AccountInfo accountInfo = this.getAccountInfo();
		return menuService.insertMenu(accountInfo, AuthorityCode.SYSTEM_MENU_INSERT_AUTHORITY, menu);
	}

	@ApiOperation(value = "修改菜单", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateMenu(
			@ApiParam(value = "菜单id", required = true) Integer menu_id, 
			@ApiParam(value = "父菜单id", required = false) Integer parent_id, 
			@ApiParam(value = "菜单名", required = false) String name, 
			@ApiParam(value = "菜单地址", required = false) String url, 
			@ApiParam(value = "菜单排序码", required = false) Integer display_order,
			@ApiParam(value = "菜单图标", required = false) String icon
			//Integer id, Integer parentId,Integer serviceId, String name,String url, Integer menuOrder,String icon
			) throws MyException {
		Menu menu = new Menu();
		menu.setMenuid(menu_id);
		menu.setParentid(parent_id);
		menu.setName(name);
		menu.setUrl(url);
		menu.setDisplayorder(display_order);
		menu.setIcon(icon);
		AccountInfo accountInfo = this.getAccountInfo();
		return menuService.updateMenu(accountInfo, AuthorityCode.SYSTEM_MENU_UPDATE_AUTHORITY, menu);
	}
	

	@ApiOperation(value = "删除菜单", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/{menu_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteMenu(
			@PathVariable @ApiParam(value = "菜单id" ,required = true) Integer menu_id
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return menuService.deleteMenu(accountInfo, AuthorityCode.SYSTEM_MENU_DELETE_AUTHORITY, menu_id);
	}
	

	@ApiOperation(value = "加载登录用户菜单列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/user/menu", method = RequestMethod.GET)
	@ResponseBody
	public Result getMenuByUser() {
		AccountInfo accountInfo = this.getAccountInfo();
		return menuService.getMenuByUser(accountInfo);
	}
	

	@ApiOperation(value = "加载菜单列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
	public Result getMenuList(
			@ApiParam(value = "父节点id") @RequestParam(required = false, defaultValue = "0") Integer parent_id
			) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return menuService.getMenuList(accountInfo, parent_id);
	}
	
	@ApiOperation(value = "加载菜单EasyUITree", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value="/easyui/tree", method=RequestMethod.GET)
	@ResponseBody
	public List<EasyUITreeNode> getEasyUITree(
			@ApiParam("菜单父节点") @RequestParam(required =false,defaultValue = "0") Integer id  
			) throws MyException{
		AccountInfo accountInfo = this.getAccountInfo();
		return menuService.getEasyUITree(id);
	}

	@ApiOperation(value = "加载菜单vueTree", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value="/vue/tree", method=RequestMethod.GET)
	@ResponseBody
	public Result getVueTree(
			@ApiParam("菜单父节点") @RequestParam(required =false,defaultValue = "0") Integer parentID
	) throws MyException{
        AccountInfo accountInfo = this.getAccountInfo();
        return menuService.getVueTree(accountInfo, parentID);
	}
	
	
}
