package com.jy.controller.system.db_log;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.AuthorityCode;
import com.jy.service.system.db_log.DbLogService;
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
 * @ClassName:  DbLogController   
 * @Description:数据库操作服务Controller
 * @author: cheng fei
 * @date:   2018-08-06 23:57
 */
@Controller
@RequestMapping("/system/db/log")
@Api(tags = "system.db_log.DbLogController",description = "系统-数据库操作日志-数据库操作日志模块")
public class DbLogController extends BaseController{

	@Resource
	private DbLogService dbLogService;

	/**
	 * 加载数据库操作日志
	 * @param search
	 * @param startTime
	 * @param endTime
	 * @param type
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "加载数据操作日志", httpMethod = "POST",produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result getDbLog(
			@ApiParam(value = "查询关键字") @RequestParam(required = false) String search,
			@ApiParam(value = "添加日志的开始时间")  @RequestParam(required = false) String startTime,
			@ApiParam(value = "添加日志的结束时间")  @RequestParam(required = false) String endTime, 
			@ApiParam(value = "日志类型")  @RequestParam(required = false) Integer type,
			@ApiParam(value = "加载第几页")  @RequestParam(required = false, defaultValue = "1") Integer page,
			@ApiParam(value = "每一页加载记录条数")  @RequestParam(required = false, defaultValue = "10") Integer pageSize
			
			) {
		AccountInfo accountInfo = this.getAccountInfo();
		return dbLogService.getDbLog(accountInfo, search,startTime,endTime,type,page,pageSize);
	}

	@ApiOperation(value = "删除数据库日志接口", httpMethod = "DELETE",produces = "application/json")
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	public Result deleteDBLog(
			@ApiParam(value = "要删除多久时间前的日志:1.一周前,2.一月前,3.三个月前") @RequestParam(required = true) Integer beforeTime
	) throws MyException {
        AccountInfo accountInfo = this.getAccountInfo();
        return dbLogService.deleteDBLog(accountInfo, AuthorityCode.SYSTEM_DB_LOG_DELETE_AUTHORITY,beforeTime);
	}

}




