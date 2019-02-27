package com.jy.controller.function.marketingFunction.lotteryManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.JsonUtils;
import com.jy.common.utils.LiuUtils;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.entiy.function.marketingFunction.lotteryManagement.Drawlotteryconfig;
import com.jy.entiy.function.marketingFunction.lotteryManagement.Persondrawlottery;
import com.jy.entiy.function.marketingFunction.registrationManagement.Signincheck;
import com.jy.service.function.marketingFunction.lotteryManagement.LotteryManageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @ClassName: LotteryManageController
 * @author: chenye
 * @date: 2018-09-13 11:23
 */
@Controller
@RequestMapping("function/lottery")
@Api(tags = "LotteryManageController", description = "功能-营销功能-抽奖管理")

public class LotteryManageController extends BaseController {

	
	@Resource
	private LotteryManageService lotteryManageService;
	
	@ApiOperation(value = "获取抽奖列表", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getLotteryList", method = RequestMethod.POST)
	@ResponseBody
	public Result getLotteryList(@ApiParam(value = "状态id", required = false) Integer votestatusid,
			@ApiParam(value = "查询条件", required = false) String search,
			@ApiParam(value = "加载第几页") @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数") @RequestParam(required = false, defaultValue = "10") Integer pageSize)
			throws MyException {

		AccountInfo accountInfo = this.getAccountInfo();
		return lotteryManageService.getLotteryList(accountInfo, AuthorityCode.MARKETING_FUNCTION_LOTTERY_LIST, votestatusid, search, page, pageSize);
	}
	
	@ApiOperation(value = "添加抽奖(所有等级的奖项中奖概率和为1)", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/addLottery", method = RequestMethod.POST)
	@ResponseBody
	public Result addLottery(
			HttpServletRequest request,
			@RequestBody Drawlotteryconfig drawlotteryconfig
			)
			throws MyException, FileNotFoundException, IOException {
		
//		Drawlotteryconfig drawlotteryconfig = new Drawlotteryconfig();
//	
//		drawlotteryconfig.setDrawlotterytitle(drawlotterytitle);
//		drawlotteryconfig.setDrawlotterycontent(drawlotterycontent);
//		drawlotteryconfig.setDrawlotteryno(drawlotteryno);
//		drawlotteryconfig.setGetlotteryno(getlotteryno);
//		drawlotteryconfig.setVotestatusid(votestatusid);
//		drawlotteryconfig.setVoteparticipanttypeid(voteparticipanttypeid);
//		drawlotteryconfig.setDrawlotteryitems(drawlotteryitems);

		AccountInfo accountInfo = this.getAccountInfo();
		// 二维码图片存放地址
		String qRpath = request.getSession().getServletContext().getRealPath("/WEB-INF/qrPicture/QR_code.png");
		return lotteryManageService.addLottery(accountInfo, AuthorityCode.MARKETING_FUNCTION_LOTTERY_INSERT, drawlotteryconfig,qRpath);
	}
	
	@ApiOperation(value = "编辑抽奖", httpMethod = "PUT", produces = "application/json")
	@RequestMapping(value = "/updateLottery", method = RequestMethod.PUT)
	@ResponseBody
	public Result updateLottery(
			@RequestBody Drawlotteryconfig drawlotteryconfig
			)
			throws MyException {
//		Drawlotteryconfig drawlotteryconfig = new Drawlotteryconfig();
//		drawlotteryconfig.setDrawlotteryconfigid(drawlotteryconfigid);
//		drawlotteryconfig.setDrawlotterytitle(drawlotterytitle);
//		drawlotteryconfig.setDrawlotterycontent(drawlotterycontent);
//		drawlotteryconfig.setDrawlotteryno(drawlotteryno);
//		drawlotteryconfig.setGetlotteryno(getlotteryno);
//		drawlotteryconfig.setVotestatusid(votestatusid);
//		drawlotteryconfig.setVoteparticipanttypeid(voteparticipanttypeid);
//		drawlotteryconfig.setDrawlotteryitems(drawlotteryitems);
			
		AccountInfo accountInfo = this.getAccountInfo();
		return lotteryManageService.updateLottery(accountInfo, AuthorityCode.MARKETING_FUNCTION_LOTTERY_UPDATE, drawlotteryconfig);
	}
	
	@ApiOperation(value = "删除抽奖", httpMethod = "DELETE", produces = "application/json")
	@RequestMapping(value = "/deleteLottery", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteLottery(
			@ApiParam(value = "删除抽奖id列表,用,隔开", required = true) @RequestParam(required = true) String ids
			)
			throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		String[] split = ids.split(",");
		for (String id : split) {
		Result result =	lotteryManageService.deleteLottery(accountInfo, AuthorityCode.MARKETING_FUNCTION_LOTTERY_DELETE, Integer.parseInt(id));
		if(result.getStatus() != 200) {
			return result;
		}
		}
		return Result.succee();
		
	}
	
	@ApiOperation(value = "查询抽奖详细信息", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getLotteryInfo", method = RequestMethod.POST)
	@ResponseBody
	public Result getLotteryInfo(
			@ApiParam(value = "抽奖主键id",required = true) Integer drawlotteryconfigid
			)
			throws MyException {
		
		
		
		AccountInfo accountInfo = this.getAccountInfo();
		return lotteryManageService.getLotteryInfo(accountInfo, AuthorityCode.MARKETING_FUNCTION_LOTTERY_UPDATE, drawlotteryconfigid);
	}
	
	@ApiOperation(value = "抽奖", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/lotterying", method = RequestMethod.POST)
	@ResponseBody
	public Result lotterying(
			@ApiParam(value = "抽奖主键id",required = true) Integer drawlotteryconfigid
			)
			throws MyException {
		
		Persondrawlottery persondrawlottery = new Persondrawlottery();
		
		AccountInfo accountInfo = this.getAccountInfo();
		return lotteryManageService.lotterying(accountInfo, AuthorityCode.MARKETING_FUNCTION_LOTTERYING, drawlotteryconfigid, persondrawlottery);
	}
	
	@ApiOperation(value = "导出预览", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/exportListView", method = RequestMethod.POST)
	@ResponseBody
	public Result exportListView(
			@ApiParam(value = "抽奖主键id",required = true) Integer drawlotteryconfigid
			)
			throws MyException {
			
		AccountInfo accountInfo = this.getAccountInfo();
		return lotteryManageService.exportListView(accountInfo, AuthorityCode.MARKETING_FUNCTION_LOTTER_EXPORT, drawlotteryconfigid);
	
	}
	
	
	@ApiOperation(value = "导出列表", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/exportList", method = RequestMethod.GET)
	@ResponseBody
	public Result exportList(
			HttpServletResponse response,
			@ApiParam(value = "抽奖主键id",required = true) Integer drawlotteryconfigid
			)
			throws MyException, IOException, ParseException {
		
		
		
		AccountInfo accountInfo = this.getAccountInfo();
//		String url = "D://xml//123.xls";
		String url = LiuUtils.getDownNameByUUId(accountInfo.getAccount().getAccountid());
		Result result = lotteryManageService.exportList(accountInfo, AuthorityCode.MARKETING_FUNCTION_LOTTER_EXPORT, drawlotteryconfigid,url);
		if(result.getStatus()!=200){
			response.getWriter().println(JsonUtils.objectToJson(result));
		exportExcel(response,url,"中奖情况表.xls");
		}else {
			HSSFWorkbook workbook = (HSSFWorkbook) result.getData();
			// 设置请求头
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition",
					"attachment; filename=" + new String("中奖情况表.xls".getBytes("utf-8"), "ISO8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
		}
		return null;
	}
	
	@ApiOperation(value = "启用/禁用", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/is", method = RequestMethod.POST)
	@ResponseBody
	public Result isNotHave(
			@ApiParam(value = "抽奖id列表,用,隔开", required = true) @RequestParam(required = true) String ids,
			@ApiParam(value = "状态id ,1启用2禁用",required = true) Integer votestatusid
			)
			throws MyException {
		
		AccountInfo accountInfo = this.getAccountInfo();
		if(votestatusid != null) {
			if(votestatusid != 1 && votestatusid != 2) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
		}
		
		String[] split = ids.split(",");
		for (String id : split) {
			if (!StringUtils.isNumeric(id)) {
				return Result.build(ResultEnum.PARAMETER_ERROR);
			}
			Drawlotteryconfig drawlotteryconfig = new Drawlotteryconfig();
			drawlotteryconfig.setDrawlotteryconfigid(Integer.parseInt(id));
			drawlotteryconfig.setVotestatusid(votestatusid);
		Result result =	lotteryManageService.updateLottery(accountInfo, AuthorityCode.MARKETING_FUNCTION_LOTTERY_UPDATE, drawlotteryconfig);
		if(result.getStatus() != 200) {
			return result;
		}
		}
		
		return Result.succee();

	}
	
	@ApiOperation(value = "加载奖项下拉框", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	@ResponseBody
	public Result load()
			throws MyException {

		return lotteryManageService.load();
	}
	
	@ApiOperation(value = "中奖记录和可抽奖次数", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	@ResponseBody
	public Result lotteryingRecord(
			@ApiParam(value = "抽奖主键id",required = true) Integer drawlotteryconfigid
			)
			throws MyException {
		
		
		AccountInfo accountInfo = this.getAccountInfo();
		return lotteryManageService.lotteryingRecord(accountInfo, drawlotteryconfigid);
	}
	
	

}
