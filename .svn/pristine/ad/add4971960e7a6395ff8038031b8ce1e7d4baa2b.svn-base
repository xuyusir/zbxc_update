package com.jy.service.function.person.memberFunction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.DateUtils;
import com.jy.dao.function.person.AppointserviceconfigMapper;
import com.jy.dao.function.person.memberFunction.ServiceAppointmentConfigurationViewMapper;
import com.jy.dao.system.select.AppointservicetimeMapper;
import com.jy.dao.system.select.PersonservicetypeMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.person.Appointserviceconfig;
import com.jy.entiy.function.person.memberFunction.ServiceAppointmentConfigurationView;
import com.jy.entiy.system.select.Appointservicetime;
import com.jy.entiy.system.select.Personservicetype;
import com.jy.service.base.BaseService;

/**
 * @ClassName: ServiceAppointmentConfigurationServiceImpl
 * @Description:服务预约配置实现类
 * @author: chenye
 * @date: 2018-09-0 15:35
 */
@Service
public class ServiceAppointmentConfigurationServiceImpl extends BaseService
		implements ServiceAppointmentConfigurationService {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");

	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	// 服务预约数据库操作日志类型
	private static final String DB_LOG_TYPE = "DB_LOG_MEMBER_FUNCTION";

	@Resource
	private AppointservicetimeMapper appointservicetimeMapper;
	@Resource
	private AppointserviceconfigMapper appointserviceconfigMapper;
	@Resource
	private ServiceAppointmentConfigurationViewMapper serviceAppointmentConfigurationViewMapper;
	@Resource
	private PersonservicetypeMapper personservicetypeMapper;

	@Override
	public Result getAppointmentList(AccountInfo accountInfo, String AUTHORITY_CODE, String search, String appointdate,
			Integer page, Integer pageSize) throws MyException, ParseException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		// 处理参数
		search = this.checkSearch(search);
		appointdate = this.checkSearchTime(appointdate);
		List<ServiceAppointmentConfigurationView> rows = serviceAppointmentConfigurationViewMapper
				.selectServiceAppointmentConfigurationList(appointdate, search, (page - 1) * pageSize, pageSize);
		for (ServiceAppointmentConfigurationView serviceAppointmentConfigurationView : rows) {
			Date yuyueDate = serviceAppointmentConfigurationView.getAppointdate();// 预约日期
			String yuyueTime = serviceAppointmentConfigurationView.getTimephase();// 预约时间
			Date nowTime = new Date();// 当前时间
			if(yuyueDate != null) {
				String yuyueDateStr = formatter.format(yuyueDate);
				String yuyueStr = yuyueDateStr + " " + yuyueTime;
				serviceAppointmentConfigurationView.setAppointdateView(yuyueDateStr);
			
					Date yuyue = format.parse(yuyueStr);
					if (yuyue.before(nowTime)) {
						serviceAppointmentConfigurationView.setStatus("已完成");
					} else {
						serviceAppointmentConfigurationView.setStatus("正在进行");
					}
			
				// data = format.parse(str); //字符串转data
				// String dateString = formatter.format(nowTime);//data转字符串
			}else {
				serviceAppointmentConfigurationView.setStatus("无效预约");
			}
			
		}
		int count = serviceAppointmentConfigurationViewMapper
				.selectCountServiceAppointmentConfigurationList(appointdate, search);
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

	@Override
	public Result insertAppointment(AccountInfo accountInfo, String AUTHORITY_CODE,
			Appointserviceconfig appointserviceconfig) throws MyException, ParseException {

		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if(appointserviceconfig.getAppointdate() == null || appointserviceconfig.getAppointservicetimeid() == null) {
			return Result.build(20001,400,"预约时间不能为空!");
		}
		//预约日期
	    String  appointdate =	appointserviceconfig.getAppointdate();
	    //预约时间点	    
	    Appointservicetime appointservicetime = appointservicetimeMapper.selectByPrimaryKey(appointserviceconfig.getAppointservicetimeid());
	    
		Date Dappointdate = DateUtils.dateParse(appointdate+" "+appointservicetime.getTimephase(), DateUtils.MINUTE_PATTERN);
		if(Dappointdate.getTime() <= new Date().getTime()) {
			return Result.build(20001,400,"预约日期不能为已过去的日期!");
		}
		appointserviceconfig.setCreateby(accountInfo.getAccount().getName());
		appointserviceconfig.setCreatepersonid(accountInfo.getAccount().getAccountid());
		appointserviceconfig.setCreatetime(new Date());
		int i = appointserviceconfigMapper.insertSelective(appointserviceconfig);
		if (i < 1) {
			throw new MyException(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "新增了一项预约 : [ ";
		log += StringUtils.isBlank(appointserviceconfig.getCreateby()) ? ""
				: "创建人=" + appointserviceconfig.getCreateby() + ",";
		log += appointserviceconfig.getCreatepersonid() == null ? ""
				: "创建人id=" + appointserviceconfig.getCreatepersonid() + ",";
		log += appointserviceconfig.getAppointserviceid() == null ? ""
				: "预约号=" + appointserviceconfig.getAppointserviceid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result updateAppointment(AccountInfo accountInfo, String AUTHORITY_CODE,
			Appointserviceconfig appointserviceconfig) throws MyException, ParseException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (appointserviceconfig.getAppointserviceid() == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		
		if(appointserviceconfig.getAppointdate() == null || appointserviceconfig.getAppointservicetimeid() == null) {
			return Result.build(20001,400,"预约时间不能为空!");
		}
		//预约日期
	    String  appointdate =	appointserviceconfig.getAppointdate();
	    //预约时间点	    
	    Appointservicetime appointservicetime = appointservicetimeMapper.selectByPrimaryKey(appointserviceconfig.getAppointservicetimeid());
	    
		Date Dappointdate = DateUtils.dateParse(appointdate+" "+appointservicetime.getTimephase(), DateUtils.MINUTE_PATTERN);
		if(Dappointdate.getTime() <= new Date().getTime()) {
			return Result.build(20001,400,"预约日期不能为已过去的日期!");
		}
		
		appointserviceconfig.setUpdateby(accountInfo.getAccount().getName());
		appointserviceconfig.setUpdatepersonid(accountInfo.getAccount().getAccountid());
		appointserviceconfig.setUpdatetime(new Date());
		//剩余名额的计算
		//原预约信息
		Appointserviceconfig old_Appointserviceconfig = appointserviceconfigMapper.selectByPrimaryKey(appointserviceconfig.getAppointserviceid());
		if(old_Appointserviceconfig != null) {
			//原预约名额
			Integer old_appointtotalnum = old_Appointserviceconfig.getAppointtotalnum();
			//原剩余名额
			Integer old_appointleftnum = old_Appointserviceconfig.getAppointleftnum();
			//修改后的预约名额
			Integer appointtotalnum = appointserviceconfig.getAppointtotalnum();
			if(old_appointleftnum != null && appointtotalnum != null && old_appointtotalnum != null) {
				Integer appointleftnum = (appointtotalnum - old_appointtotalnum) + old_appointleftnum;
				if(appointleftnum < 0) {
					appointleftnum = 0;
				}
				appointserviceconfig.setAppointleftnum(appointleftnum);
				
			}else {
				return Result.build(20001,400,"预约名额不能为空!");
			}
		}
		
		int i = appointserviceconfigMapper.updateByPrimaryKeySelective(appointserviceconfig);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "修改了一项预约 : [ ";
		log += StringUtils.isBlank(appointserviceconfig.getUpdateby()) ? ""
				: "修改人=" + appointserviceconfig.getUpdateby() + ",";
		log += appointserviceconfig.getUpdatepersonid() == null ? ""
				: "修改人id=" + appointserviceconfig.getUpdatepersonid() + ",";
		log += appointserviceconfig.getAppointserviceid() == null ? ""
				: "预约号=" + appointserviceconfig.getAppointserviceid() + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

	@Override
	public Result loadAppointmentTime() {
		List<Appointservicetime> AppointservicetimeList = appointservicetimeMapper.selectByExample(null);
		return Result.succee(AppointservicetimeList);
	}

	@Override
	public Result loadServiceName() {
		List<Personservicetype> personservicetypeList = new ArrayList<Personservicetype>();
		List<Personservicetype> list = personservicetypeMapper.selectByExample(null);
		for (Personservicetype personservicetype : list) {
			if (personservicetype.getServicetypename().equals("单面模拟")
					|| personservicetype.getServicetypename().equals("ICD报考")) {
				personservicetypeList.add(personservicetype);
			}
		}
		return Result.succee(personservicetypeList);
	}

	@Override
	public Result getAppointmentendList(AccountInfo accountInfo, String AUTHORITY_CODE, String search,
			String appointdate, Integer page, Integer pageSize) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		Date nowTime = new Date();// 当前时间
		String nowDate = formatter.format(nowTime);
		String nowTimePhase = formatter2.format(nowTime);

		// 处理参数
		search = this.checkSearch(search);
		appointdate = this.checkSearchTime(appointdate);
		List<ServiceAppointmentConfigurationView> rows = serviceAppointmentConfigurationViewMapper
				.selectServiceAppointmentendList(nowTimePhase, nowDate, appointdate, search, (page - 1) * pageSize,
						pageSize);
		int count = serviceAppointmentConfigurationViewMapper.selectCountServiceAppointmentendList(nowTimePhase,
				nowDate, appointdate, search);
		for (ServiceAppointmentConfigurationView serviceAppointmentConfigurationView : rows) {
				Date yuyueDate = serviceAppointmentConfigurationView.getAppointdate();// 预约日期		
				if(yuyueDate != null) {
				String yuyueDateStr = formatter.format(yuyueDate);
				serviceAppointmentConfigurationView.setAppointdateView(yuyueDateStr);
				serviceAppointmentConfigurationView.setStatus("已完成");
				}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

	@Override
	public Result getAppointmentingList(AccountInfo accountInfo, String AUTHORITY_CODE, String search,
			String appointdate, Integer page, Integer pageSize) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		Date nowTime = new Date();// 当前时间
		String nowDate = formatter.format(nowTime);
		String nowTimePhase = formatter2.format(nowTime);

		// 处理参数
		search = this.checkSearch(search);
		appointdate = this.checkSearchTime(appointdate);
		List<ServiceAppointmentConfigurationView> rows = serviceAppointmentConfigurationViewMapper
				.selectServiceAppointmentingList(nowTimePhase, nowDate, appointdate, search, (page - 1) * pageSize,
						pageSize);
		int count = serviceAppointmentConfigurationViewMapper.selectCountServiceAppointmentingList(nowTimePhase,
				nowDate, appointdate, search);
		for (ServiceAppointmentConfigurationView serviceAppointmentConfigurationView : rows) {
			Date yuyueDate = serviceAppointmentConfigurationView.getAppointdate();// 预约日期		
			if(yuyueDate != null) {
			String yuyueDateStr = formatter.format(yuyueDate);
			serviceAppointmentConfigurationView.setAppointdateView(yuyueDateStr);
			serviceAppointmentConfigurationView.setStatus("正在进行");
			}
	}
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", count);
		return Result.succee(map);
	}

	@Override
	public Result updateView(AccountInfo accountInfo, String AUTHORITY_CODE, Long appointserviceid) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		if (appointserviceid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		Appointserviceconfig appointserviceconfig = appointserviceconfigMapper.selectByPrimaryKey(appointserviceid);
		if (appointserviceconfig != null) {
			String appointdate = appointserviceconfig.getAppointdate();
			if (appointdate != null) {
				appointserviceconfig.getAppointdate();
				String string = appointdate.substring(0,appointdate.indexOf(" "));
				appointserviceconfig.setAppointdate(string);
			}
			
			if (appointserviceconfig.getAppointservicetimeid() != null) {
				Appointservicetime appointservicetime = appointservicetimeMapper.selectByPrimaryKey(appointserviceconfig.getAppointservicetimeid());
				appointserviceconfig.setAppointservicetime(appointservicetime.getTimephase());
			}
		}
		
		return Result.succee(appointserviceconfig);
	}

	@Override
	public Result deleteAppointment(AccountInfo accountInfo, String AUTHORITY_CODE, Long appointserviceid)
			throws MyException {

		if (appointserviceid == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}
		int i = appointserviceconfigMapper.deleteByPrimaryKey(appointserviceid);
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log = "删除了一项预约 : [ ";
		log += StringUtils.isBlank(accountInfo.getAccount().getName()) ? ""
				: "修改人=" + accountInfo.getAccount().getName() + ",";
		log += accountInfo.getAccount().getAccountid() == null ? ""
				: "修改人id=" + accountInfo.getAccount().getAccountid() + ",";
		log += appointserviceid == null ? "" : "预约号=" + appointserviceid + ",";
		log = log.substring(0, log.length() - 1) + " ]";
		this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

		return Result.succee();
	}

}
