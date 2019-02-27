package com.jy.controller.content.positionManage;

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
import com.jy.entiy.content.positionManage.Columnpostion;
import com.jy.service.content.positionManage.PositionManageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: PositionManageController
 * @Description:推荐位管理
 * @author: chenye
 * @date: 2018-09-20 14:35
 */

@Controller
@RequestMapping("content/position")
@Api(tags = "content.PositionManageController", description = "内容-推荐位管理")
public class PositionManageController extends BaseController {

	@Resource
	private PositionManageService positionManageService;

	@ApiOperation(value = "获取推荐位列表不分页", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/all/list", method = RequestMethod.GET)
	@ResponseBody
	public Result getPositionList() throws MyException {
		return positionManageService.getPositionList();
	}

	@ApiOperation(value = "获取推荐位列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Result getPositionList(
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return positionManageService.getPositionList(accountInfo, AuthorityCode.CONTENT_POSITION_SELECT_LIST_AUTHORITY,
				page, pageSize);
	}

	@ApiOperation(value = "推荐位详情", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Result getPositionInfo(@ApiParam(value = "推荐位id", required = true) Integer columnpostionid)
			throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return positionManageService.getPositionInfo(accountInfo, AuthorityCode.CONTENT_POSITION_SELECT_LIST_AUTHORITY,
				columnpostionid);
	}

	@ApiOperation(value = " 获取指定栏目下的推荐位", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/{pagecolumnid}", method = RequestMethod.GET)
	@ResponseBody
	public Result getAllPositionByColumn(@ApiParam(value = "栏目id", required = true) @PathVariable Integer pagecolumnid)
			throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		return positionManageService.getAllPositionByColumn(accountInfo,
				AuthorityCode.CONTENT_COLUMN_SELECT_LIST_AUTHORITY, pagecolumnid);
	}

	/**
	 * @param pagecolumnid
	 * @param relationtype
	 * @param postionname
	 * @param displayorder
	 * @param relationid
	 * @param fileid
	 * @param describe
	 * @return
	 * @throws MyException
	 */
	@ApiOperation(value = "添加推荐位", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result insertPosition(@ApiParam(value = "栏目id", required = true) Integer pagecolumnid,
			@ApiParam(value = "关联类型", required = true) Integer relationtype,
			@ApiParam(value = "推荐位名称", required = true) String postionname,
			@ApiParam(value = "推荐位排序", required = true) Integer displayorder,
			@ApiParam(value = "关联id", required = false) Integer relationid,
			@ApiParam(value = "图片文件id", required = false) Long fileid,
			@ApiParam(value = "描述", required = false) String description) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Columnpostion columnpostion = new Columnpostion();
		columnpostion.setCreateby(accountInfo.getAccount().getName());
		columnpostion.setCreatepersonid(accountInfo.getAccount().getAccountid());
		columnpostion.setCreatetime(new Date());// 新建时间就是推荐时间
		columnpostion.setPagecolumnid(pagecolumnid);
		columnpostion.setRelationtype(relationtype);
		columnpostion.setPostionname(postionname);
		columnpostion.setDisplayorder(displayorder);
		columnpostion.setDescription(description);
		columnpostion.setRelationid(relationid);
		columnpostion.setFileid(fileid);

		return positionManageService.insertPosition(accountInfo, AuthorityCode.CONTENT_POSITION_INSERT_AUTHORITY,
				columnpostion);
	}

	@ApiOperation(value = "修改推荐位", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateColumn(@ApiParam(value = "推荐位主键id", required = true) Integer columnpostionid,
			@ApiParam(value = "栏目id", required = true) Integer pagecolumnid,
			@ApiParam(value = "关联类型", required = true) Integer relationtype,
			@ApiParam(value = "推荐位名称", required = true) String postionname,
			@ApiParam(value = "栏目排序", required = true) Integer displayorder,
			@ApiParam(value = "关联id", required = false) Integer relationid,
			@ApiParam(value = "图片文件id", required = true) Long fileid,
			@ApiParam(value = "描述", required = false) String description) throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		Columnpostion columnpostion = new Columnpostion();
		columnpostion.setColumnpostionid(columnpostionid);
		columnpostion.setUpdateby(accountInfo.getAccount().getName());
		columnpostion.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		columnpostion.setUpdatetime(new Date());// 修改时间就是推荐时间
		columnpostion.setPagecolumnid(pagecolumnid);
		columnpostion.setRelationtype(relationtype);
		columnpostion.setPostionname(postionname);
		columnpostion.setDisplayorder(displayorder);
		columnpostion.setDescription(description);
		columnpostion.setRelationid(relationid);
		columnpostion.setFileid(fileid);

		return positionManageService.updatePosition(accountInfo, AuthorityCode.CONTENT_POSITION_UPDATE_AUTHORITY,
				columnpostion);
	}

	@ApiOperation(value = "删除推荐位", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteColumn(
			@ApiParam(value = "要删除的推荐位id列表,用,隔开", required = true) @RequestParam(required = true) String ids)
			throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Result result = positionManageService.deletePosition(accountInfo,
					AuthorityCode.CONTENT_POSITION_DELETE_AUTHORITY, Integer.parseInt(id));
			if (result.getStatus() != 200) {
				return result;
			}
		}
		return Result.succee();

	}

}
