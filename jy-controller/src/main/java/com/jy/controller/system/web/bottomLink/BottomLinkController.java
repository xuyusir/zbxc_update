package com.jy.controller.system.web.bottomLink;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.system.web.bottomLink.Bottomlink;
import com.jy.entiy.system.web.bottomLink.Bottomlinktype;
import com.jy.service.system.web.bottomLink.BottomLinkService;
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
import java.util.Date;

/**
 * @ClassName: BottomLinkController
 * @Description:底部链接管理
 * @author: chenye
 * @date: 2018-09-28 16:49
 */

@Controller
@RequestMapping("system/web/bottomLink")
@Api(tags = "BottomLinkController", description = "系统-网站设置-底部链接管理")
public class BottomLinkController extends BaseController {

	@Resource
	private BottomLinkService bottomLinkService;


	/**
	 * 加载页面按钮权限
	 * @return
	 */
	@ApiOperation(value = "加载页面操作权限", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/authority",method = RequestMethod.GET)
	@ResponseBody
	public Result getAuthority(
			@ApiParam(value = "菜单ID", required = true) @RequestParam(required = true) Integer menu_id
			){
		AccountInfo accountInfo = this.getAccountInfo();
		return bottomLinkService.getAuthority(accountInfo, menu_id);
	}

	@ApiOperation(value = "获取底部链接类目下拉列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/type/list", method = RequestMethod.GET)
	@ResponseBody
	public Result getAllType() throws MyException {

		return bottomLinkService.getAllType();
	}

	@ApiOperation(value = "获取底部链接列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Result getAllBottomLink() throws MyException {

		return bottomLinkService.getAllBottomLink();
	}

	@ApiOperation(value = "后台管理获取底部链接列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getBottomLinkList(
			@ApiParam(value = "类目id") @RequestParam(required = false, defaultValue = "1") Integer typeid,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return bottomLinkService.getBottomLinkList(accountInfo, AuthorityCode.SYSTEM_BOTTOM_LINK_SELECT_AUTHORITY, page, pageSize, typeid);
	}

	@ApiOperation(value = "底部链接详情", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Result getBottomLinkInfo(@ApiParam(value = "底部链接id", required = true) Integer id) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return bottomLinkService.getBottomLinkInfo(id);
	}

	@ApiOperation(value = "添加底部链接类目", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/type", method = RequestMethod.POST)
	@ResponseBody
	public Result insertBottomlinktype(@ApiParam(value = "类目名称", required = true) String typename) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Bottomlinktype bottomlinktype = new Bottomlinktype();
		bottomlinktype.setTypename(typename);
		bottomlinktype.setCreateby(accountInfo.getAccount().getName());
		bottomlinktype.setCreatetime(new Date());
		bottomlinktype.setCreatepersonid(accountInfo.getAccount().getAccountid());

		return bottomLinkService.insertBottomLinkType(accountInfo, AuthorityCode.SYSTEM_BOTTOM_LINK_INSERT_AUTHORITY, bottomlinktype);
	}

	@ApiOperation(value = "编辑底部链接类目", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/type", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateBottomlinktype(@ApiParam(value = "类目id", required = true) Integer id,
									   @ApiParam(value = "类目名称", required = true) String typename) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Bottomlinktype bottomlinktype = new Bottomlinktype();
		bottomlinktype.setId(id);
		bottomlinktype.setTypename(typename);
		bottomlinktype.setUpdateby(accountInfo.getAccount().getName());
		bottomlinktype.setUpdatetime(new Date());
		bottomlinktype.setUpdatepersonid(accountInfo.getAccount().getAccountid());

		return bottomLinkService.updateBottomLinkType(accountInfo, AuthorityCode.SYSTEM_BOTTOM_LINK_INSERT_AUTHORITY, bottomlinktype);
	}


	@ApiOperation(value = "删除底部链接类目", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/type", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteBottomLinkType(
			@ApiParam(value = "要删除的类目id列表,用,隔开", required = true) @RequestParam(required = true) String ids) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Result result =bottomLinkService.deleteBottomLinkType(accountInfo, AuthorityCode.SYSTEM_BOTTOM_LINK_DELETE_AUTHORITY, Integer.parseInt(id));
			if(result.getStatus() != 200) {
				return result;
			}
		}
		return Result.succee();

	}

	@ApiOperation(value = "添加底部链接", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertBottomlink(@ApiParam(value = "类目id", required = true) Integer typeid,
			@ApiParam(value = "排序", required = true) Integer displayorder,
			@ApiParam(value = "标题", required = true) String title,
			@ApiParam(value = "链接地址", required = true) String url) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Bottomlink bottomlink = new Bottomlink();
		bottomlink.setCreateby(accountInfo.getAccount().getName());
		bottomlink.setCreatetime(new Date());
		bottomlink.setCreatepersonid(accountInfo.getAccount().getAccountid());
		bottomlink.setDisplayorder(displayorder);
		bottomlink.setTitle(title);
		bottomlink.setUrl(url);
		bottomlink.setTypeid(typeid);
		return bottomLinkService.insertBottomLink(accountInfo, AuthorityCode.SYSTEM_BOTTOM_LINK_INSERT_AUTHORITY, bottomlink);
	}

	@ApiOperation(value = "修改底部链接", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateBottomlink(
			@ApiParam(value = "底部链接id", required = true) Integer id,
			@ApiParam(value = "类目id", required = false) Integer typeid,
			@ApiParam(value = "排序", required = false) Integer displayorder,
			@ApiParam(value = "标题", required = false) String title,
			@ApiParam(value = "链接地址", required = false) String url
	) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Bottomlink bottomlink = new Bottomlink();
		bottomlink.setDisplayorder(displayorder);
		bottomlink.setTitle(title);
		bottomlink.setUrl(url);
		bottomlink.setId(id);
		bottomlink.setTypeid(typeid);
		return bottomLinkService.updateBottomLink(accountInfo, AuthorityCode.SYSTEM_BOTTOM_LINK_UPDATE_AUTHORITY, bottomlink);
	}

	@ApiOperation(value = "删除底部链接", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteBottomLink(
			@ApiParam(value = "要删除的底部链接id列表,用,隔开", required = true) @RequestParam(required = true) String ids) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
		Result result =	bottomLinkService.deleteBottomLink(accountInfo, AuthorityCode.SYSTEM_BOTTOM_LINK_DELETE_AUTHORITY,  Integer.parseInt(id));
		if(result.getStatus() != 200) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}
		}
		return Result.succee();

	}

}
