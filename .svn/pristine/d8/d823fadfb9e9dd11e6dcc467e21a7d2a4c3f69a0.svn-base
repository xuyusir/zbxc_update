package com.jy.service.system.db_log;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.system.db_log.DblogMapper;
import com.jy.dao.system.dictionaries.DictionariesMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.system.db_log.Dblog;
import com.jy.service.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: DbLogServiceImpl
 * @Description:数据库操作服务实现类
 * @author: cheng fei
 * @date: 2018-08-07 00:04
 */
@Service
public class DbLogServiceImpl extends BaseService implements DbLogService {

	/**
	 * 数据库操作日志类型
	 */
	private static final String DB_LOG_TYPE = "DB_LOG_DB_LOG";

	/**
	 * 时间参数允许传递的参数
	 */
	private static final Integer [] BEFORE_TIME_PARAMS = {1, 2, 3};

	@Resource
	private DblogMapper dblogMapper;
	
	@Resource DictionariesMapper dictionariesMapper;

	@Override
	public Result getDbLog(AccountInfo accountInfo, String search, String startTime, String endTime, Integer type, Integer page, Integer pageSize) {

		// 检测账号类型
		if (!checkManageAccount(accountInfo.getAccount())){
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}
		
		// 处理参数
		search = this.checkSearch(search);
		startTime = this.checkSearchTime(startTime);
		endTime = this.checkSearchTime(endTime);
		type = type == 0 ? null : type;
		
		List<Dblog> rows = dblogMapper.selectDbLogByParem(type, startTime, endTime, search, (page - 1) * pageSize, pageSize);
		
		for (Dblog dbLog : rows) {
			dbLog.setTypeName(dictionariesMapper.getNameByDictionariesID(dbLog.getDictionariesid()));
		}
		int count = dblogMapper.selectDbLogCountByParem(type, startTime, endTime, search);
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

	@Override
	public Result deleteDBLog(AccountInfo accountInfo, String AUTHORITY_CODE, Integer beforeTime) throws MyException {
		//检测权限
		Result result = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (result.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		Date date = new Date();
		String time = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (beforeTime.intValue() == BEFORE_TIME_PARAMS[0]) {
			//过去七天
			c.add(Calendar.DATE, -7);
			Date d = c.getTime();
			time = format.format(d);
		} else if (beforeTime.intValue() == BEFORE_TIME_PARAMS[1]) {
			//过去一月
			c.add(Calendar.MONTH, -1);
			Date m = c.getTime();
			time = format.format(m);
		} else {
			//过去三个月
			c.add(Calendar.MONTH, -3);
			Date m3 = c.getTime();
			time = format.format(m3);
		}
		int i = dblogMapper.deleteDbLog(time);

		return Result.succee();
	}

}
