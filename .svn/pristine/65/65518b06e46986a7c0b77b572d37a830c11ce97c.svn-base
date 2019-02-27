package com.jy.controller.content.columnManage;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.content.columnManage.Pagecolumn;
import com.jy.service.content.columnManage.ColumnManageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: ColumnManageController
 * @Description:栏目管理
 * @author: chenye
 * @date: 2018-09-19 16:47
 */

@Controller
@RequestMapping("content/column")
@Api(tags = "content.ColumnManageController", description = "内容-栏目管理")
public class ColumnManageController extends BaseController {

	@Resource
	private ColumnManageService columnManageService;

	@ApiOperation(value = "获取栏目列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/all/list", method = RequestMethod.GET)
	@ResponseBody
	public Result getColumnList() throws MyException {

		return columnManageService.getColumnList();
	}

	@ApiOperation(value = "获取栏目列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getColumnList(
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return columnManageService.getColumnList(accountInfo, AuthorityCode.CONTENT_COLUMN_SELECT_LIST_AUTHORITY, page,
				pageSize);
	}

	@ApiOperation(value = "栏目详情", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Result getColumnInfo(@ApiParam(value = "栏目id", required = true) Integer pagecolumnid) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return columnManageService.getColumnInfo(accountInfo, AuthorityCode.CONTENT_COLUMN_SELECT_LIST_AUTHORITY,
				pagecolumnid);
	}

	@ApiOperation(value = " 获取指定导航页下的栏目", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/{pageid}", method = RequestMethod.GET)
	@ResponseBody
	public Result getAllColumnByPageid(@ApiParam(value = "导航页id", required = true) @PathVariable Integer pageid)
			throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return columnManageService.getAllColumnByPageid(accountInfo, pageid);
	}

	@ApiOperation(value = "添加栏目", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertColumn(@ApiParam(value = "所属导航页id", required = true) Integer pageid,
			@ApiParam(value = "栏目名称", required = true) String pagecolumnname,
			@ApiParam(value = "栏目排序", required = true) Integer displayorder,
			@ApiParam(value = "标题", required = false) String title,
			@ApiParam(value = "图片文件id", required = true) Long fileid,
			@ApiParam(value = "描述", required = false) String description) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Pagecolumn pagecolumn = new Pagecolumn();
		pagecolumn.setCreateby(accountInfo.getAccount().getName());
		pagecolumn.setCreatepersonid(accountInfo.getAccount().getAccountid());
		pagecolumn.setCreatetime(new Date());
		pagecolumn.setPageid(pageid);
		pagecolumn.setPagecolumnname(pagecolumnname);
		pagecolumn.setDisplayorder(displayorder);
		pagecolumn.setDescription(description);
		pagecolumn.setTitle(title);
		pagecolumn.setFileid(fileid);

		return columnManageService.insertColumn(accountInfo, AuthorityCode.CONTENT_COLUMN_INSERT_AUTHORITY, pagecolumn);
	}

	@ApiOperation(value = "修改栏目", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateColumn(@ApiParam(value = "栏目id", required = true) Integer pagecolumnid,
			@ApiParam(value = "所属导航页id", required = true) Integer pageid,
			@ApiParam(value = "栏目名称", required = true) String pagecolumnname,
			@ApiParam(value = "栏目排序", required = true) Integer displayorder,
			@ApiParam(value = "标题", required = true) String title,
			@ApiParam(value = "图片文件id", required = true) Long fileid,
			@ApiParam(value = "描述", required = true) String description) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Pagecolumn pagecolumn = new Pagecolumn();
		pagecolumn.setUpdateby(accountInfo.getAccount().getName());
		pagecolumn.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		pagecolumn.setUpdatetime(new Date());
		pagecolumn.setPagecolumnid(pagecolumnid);
		pagecolumn.setPageid(pageid);
		pagecolumn.setPagecolumnname(pagecolumnname);
		pagecolumn.setDisplayorder(displayorder);
		pagecolumn.setDescription(description);
		pagecolumn.setTitle(title);
		pagecolumn.setFileid(fileid);

		return columnManageService.updateColumn(accountInfo, AuthorityCode.CONTENT_COLUMN_UPDATE_AUTHORITY, pagecolumn);
	}

	@ApiOperation(value = "删除栏目", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteColumn(
			@ApiParam(value = "要删除的栏目id列表,用,隔开", required = true) @RequestParam(required = true) String ids)
			throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Result result = columnManageService.deleteColumn(accountInfo, AuthorityCode.CONTENT_COLUMN_DELETE_AUTHORITY,
					Integer.parseInt(id));
			if (result.getStatus() != 200) {
				return result;
			}
		}
		return Result.succee();

	}

}
