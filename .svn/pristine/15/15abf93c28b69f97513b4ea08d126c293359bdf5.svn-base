package com.jy.controller.function.marketingFunction.votingManagement;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.function.marketingFunction.votingManagement.Voteconfig;
import com.jy.entiy.function.marketingFunction.votingManagement.Votedetails;
import com.jy.entiy.function.marketingFunction.votingManagement.Voteitem;
import com.jy.entiy.function.marketingFunction.votingManagement.Voteoption;
import com.jy.service.function.marketingFunction.votingManagement.VotingManageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: VotingManageController
 * @author: chenye
 * @date: 2018-09-11 17:20
 */
@Controller
@RequestMapping("function/voting")
@Api(tags = "VotingManageController", description = "功能-营销功能-投票管理")
public class VotingManageController extends BaseController {

	@Resource
	private VotingManageService votingManageService;

	@ApiOperation(value = "获取投票列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getVoteConfigList", method = RequestMethod.POST)
	@ResponseBody
	public Result getVoteConfigList(@ApiParam(value = "状态id(1启用2禁用)", required = false) Integer votestatusid,
			@ApiParam(value = "查询条件", required = false) String search,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.getVoteConfigList(accountInfo, AuthorityCode.MARKETING_FUNCTION_VOTE_LIST,
				votestatusid, search, page, pageSize);
	}

	@ApiOperation(value = "获取指定投票下的题目列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getItemList", method = RequestMethod.POST)
	@ResponseBody
	public Result getItemList(@ApiParam(value = "投票id", required = false) Integer voteid,
			@ApiParam(value = "题目id", required = false) Integer voteitemid,
			@ApiParam(value = "查询条件", required = false) String search,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.getItemList(accountInfo, AuthorityCode.MARKETING_FUNCTION_ITEM_LIST, voteid,
				voteitemid, search, page, pageSize);
	}

	@ApiOperation(value = "获取指定题目下的选项列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getOptionList", method = RequestMethod.POST)
	@ResponseBody
	public Result getOptionList(@ApiParam(value = "选项id", required = false) Integer voteoptionid,
			@ApiParam(value = "题目id", required = false) Integer voteitemid,
			@ApiParam(value = "查询条件", required = false) String search,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.getOptionList(accountInfo, AuthorityCode.MARKETING_FUNCTION_OPTION_LIST, voteitemid,
				voteoptionid, search, page, pageSize);
	}

	@ApiOperation(value = "添加题目", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	@ResponseBody
	public Result addItem(@ApiParam(value = "投票id", required = true) Integer voteid,
			@ApiParam(value = "题目", required = true) String voteitemname,
			@ApiParam(value = "顺序", required = false) Integer displayorder,
			@ApiParam(value = "类型", required = true) Integer votetypeid

	) throws MyException {
		if (votetypeid != null) {
			if (votetypeid != 1 && votetypeid != 2) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
		}
		Voteitem voteitem = new Voteitem();
		voteitem.setVoteid(voteid);
		voteitem.setVoteitemname(voteitemname);
		voteitem.setDisplayorder(displayorder);
		voteitem.setVotetypeid(votetypeid);

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.addItem(accountInfo, AuthorityCode.MARKETING_FUNCTION_ITEM_INSERT, voteitem);
	}

	@ApiOperation(value = "编辑题目", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/updateItem", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateItem(@ApiParam(value = "题目id", required = true) Integer voteitemid,
			@ApiParam(value = "投票id", required = true) Integer voteid,
			@ApiParam(value = "题目", required = true) String voteitemname,
			@ApiParam(value = "顺序", required = false) Integer displayorder,
			@ApiParam(value = "类型", required = true) Integer votetypeid) throws MyException {
		if (votetypeid != null) {
			if (votetypeid != 1 && votetypeid != 2) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
		}
		Voteitem voteitem = new Voteitem();
		voteitem.setVoteitemid(voteitemid);
		voteitem.setVoteid(voteid);
		voteitem.setVoteitemname(voteitemname);
		voteitem.setDisplayorder(displayorder);
		voteitem.setVotetypeid(votetypeid);

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.updateItem(accountInfo, AuthorityCode.MARKETING_FUNCTION_ITEM_UPDATE, voteitem);
	}

	@ApiOperation(value = "删除题目", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/deleteItem", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteItem(
			@ApiParam(value = "删除题目id列表,用,隔开", required = true) @RequestParam(required = true) String ids)
			throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Result result = votingManageService.deleteItem(accountInfo, AuthorityCode.MARKETING_FUNCTION_ITEM_DELETE,
					Integer.parseInt(id));
			if (result.getStatus() != 200) {
				return result;
			}
		}
		return Result.succee();

	}

	@ApiOperation(value = "查询题目详细信息", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getItemInfo", method = RequestMethod.POST)
	@ResponseBody
	public Result getItemInfo(@ApiParam(value = "题目id", required = true) Integer voteitemid) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.getItemInfo(accountInfo, AuthorityCode.MARKETING_FUNCTION_ITEM_UPDATE, voteitemid);
	}

	@ApiOperation(value = "添加选项", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addOption", method = RequestMethod.POST)
	@ResponseBody
	public Result addOption(@ApiParam(value = "选项名字", required = true) String voteoptiontitle,
			@ApiParam(value = "题目id", required = true) Integer voteitemid,
			@ApiParam(value = "选项顺序", required = false) Integer displayorder

	) throws MyException {
		Voteoption voteoption = new Voteoption();
		voteoption.setVoteitemid(voteitemid);
		voteoption.setDisplayorder(displayorder);
		voteoption.setVoteoptiontitle(voteoptiontitle);

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.addOption(accountInfo, AuthorityCode.MARKETING_FUNCTION_OPTION_INSERT, voteoption);
	}

	@ApiOperation(value = "编辑选项", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/updateOption", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateOption(@ApiParam(value = "选项id", required = true) Integer voteoptionid,
			@ApiParam(value = "题目id", required = true) Integer voteitemid,
			@ApiParam(value = "选项名字", required = true) String voteoptiontitle,
			@ApiParam(value = "选项顺序", required = false) Integer displayorder) throws MyException {
		Voteoption voteoption = new Voteoption();
		voteoption.setVoteoptionid(voteoptionid);
		voteoption.setVoteitemid(voteitemid);
		voteoption.setDisplayorder(displayorder);
		voteoption.setVoteoptiontitle(voteoptiontitle);

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.updateOption(accountInfo, AuthorityCode.MARKETING_FUNCTION_OPTION_UPDATE,
				voteoption);
	}

	@ApiOperation(value = "删除选项", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/deleteOption", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteOption(
			@ApiParam(value = "删除选项id列表,用,隔开", required = true) @RequestParam(required = true) String ids)
			throws MyException {
		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Result result = votingManageService.deleteOption(accountInfo,
					AuthorityCode.MARKETING_FUNCTION_OPTION_DELETE, Integer.parseInt(id));
			if (result.getStatus() != 200) {
				return result;
			}
		}
		return Result.succee();

	}

	@ApiOperation(value = "查询选项详细信息", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getOptionInfo", method = RequestMethod.POST)
	@ResponseBody
	public Result getOptionInfo(@ApiParam(value = "选项id", required = true) Integer voteoptionid) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.getOption(accountInfo, AuthorityCode.MARKETING_FUNCTION_OPTION_UPDATE, voteoptionid);
	}

	@ApiOperation(value = "添加投票", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addVoteConfig", method = RequestMethod.POST)
	@ResponseBody
	public Result addVoteConfig(HttpServletRequest request, @ApiParam(value = "标题", required = true) String votetitle,
			@ApiParam(value = "状态id(1启用2禁用)", required = true) Integer votestatusid,
			@ApiParam(value = "参与人群id(1所有用户2会员)", required = false) Integer voteparticipanttypeid,
			@ApiParam(value = "投票活动地址(完整路径)", required = true) String voteUrl) throws MyException, IOException {
		if (votestatusid != null) {
			if (votestatusid != 1 && votestatusid != 2) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
		}
		if (voteparticipanttypeid != null) {
			if (voteparticipanttypeid != 1 && voteparticipanttypeid != 2) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
		}
		// 二维码图片存放地址
		String qRpath = request.getSession().getServletContext().getRealPath("/WEB-INF/qrPicture/QR_code.png");
		Voteconfig voteconfig = new Voteconfig();
		voteconfig.setVotestatusid(votestatusid);
		voteconfig.setVotetitle(votetitle);
		voteconfig.setVoteparticipanttypeid(voteparticipanttypeid);
		long time = new Date().getTime();
		String Voteno = String.valueOf(time);
		String substring = Voteno.substring(Voteno.length()-5);
		voteconfig.setVoteno(Integer.parseInt(substring));

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.addVoteConfig(accountInfo, AuthorityCode.MARKETING_FUNCTION_VOTE_INSERT, voteconfig,
				voteUrl, qRpath);
	}

	@ApiOperation(value = "编辑投票", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/updateVoteConfig", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateVoteConfig(@ApiParam(value = "投票id", required = true) Integer voteid,
			@ApiParam(value = "状态id", required = true) Integer votestatusid,
			@ApiParam(value = "标题", required = true) String votetitle,
			@ApiParam(value = "参与人群id", required = false) Integer voteparticipanttypeid) throws MyException {
		if (votestatusid != null) {
			if (votestatusid != 1 && votestatusid != 2) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
		}
		Voteconfig voteconfig = new Voteconfig();
		voteconfig.setVoteid(voteid);
		voteconfig.setVotestatusid(votestatusid);
		voteconfig.setVotetitle(votetitle);
		voteconfig.setVoteparticipanttypeid(voteparticipanttypeid);

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.updateVoteConfig(accountInfo, AuthorityCode.MARKETING_FUNCTION_VOTE_UPDATE,
				voteconfig);
	}

	@ApiOperation(value = "删除投票", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/deleteVoteConfig", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteVoteConfig(
			@ApiParam(value = "删除投票id列表,用,隔开", required = true) @RequestParam(required = true) String ids)
			throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Result result = votingManageService.deleteVoteConfig(accountInfo,
					AuthorityCode.MARKETING_FUNCTION_VOTE_DELETE, Integer.parseInt(id));
			if (result.getStatus() != 200) {
				return result;
			}
		}
		return Result.succee();

	}

	@ApiOperation(value = "查询投票详细信息", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getVoteConfigInfo", method = RequestMethod.POST)
	@ResponseBody
	public Result getVoteConfigInfo(@ApiParam(value = "投票id", required = true) Integer voteid) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.getVoteConfigInfo(accountInfo, AuthorityCode.MARKETING_FUNCTION_VOTE_UPDATE, voteid);
	}

	@ApiOperation(value = "投票前加载", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/loadVote", method = RequestMethod.POST)
	@ResponseBody
	public Result loadVote(@ApiParam(value = "投票id", required = true) Integer voteid) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.loadVote(accountInfo, AuthorityCode.MARKETING_FUNCTION_VOTE_INSERT, voteid);
	}

	@ApiOperation(value = "投票操作", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/voting", method = RequestMethod.POST)
	@ResponseBody
	public Result voting(@ApiParam(value = "投票id", required = true) Integer voteid,
			@ApiParam(value = "题目id", required = true) Integer voteitemid,
			@ApiParam(value = "选项id数组", required = true) String[] voteoptionids) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		if (voteoptionids == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		int itemType = votingManageService.itemType(voteid, voteitemid);
		if (itemType == 1) {// 单选
			if (voteoptionids.length > 1) {
				return Result.build(20001, 400, "该题为单选题!");
			}
		}
		if (itemType == 0) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		return votingManageService.voting(accountInfo, voteid, voteitemid, voteoptionids);

	}

	@ApiOperation(value = "导出投票", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/exportVote", method = RequestMethod.GET)
	@ResponseBody
	public Result exportVote(@ApiParam(value = "投票id", required = true) Integer voteid) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return votingManageService.exportVote(accountInfo, AuthorityCode.MARKETING_FUNCTION_VOTE_EXPORT, voteid);
	}

	@ApiOperation(value = "启用/禁用", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/is", method = RequestMethod.POST)
	@ResponseBody
	public Result isNotHave(@ApiParam(value = "投票id列表,用,隔开", required = true) @RequestParam(required = true) String ids,
			@ApiParam(value = "状态id ,1启用2禁用", required = true) Integer votestatusid) throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		if (votestatusid != null) {
			if (votestatusid != 1 && votestatusid != 2) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
		}

		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Voteconfig voteconfig = new Voteconfig();
			voteconfig.setVoteid(Integer.parseInt(id));
			voteconfig.setVotestatusid(votestatusid);
			Result result = votingManageService.updateVoteConfig(accountInfo,
					AuthorityCode.MARKETING_FUNCTION_VOTE_UPDATE, voteconfig);
			if (result.getStatus() != 200) {
				return result;
			}
		}

		return Result.succee();

	}
}
