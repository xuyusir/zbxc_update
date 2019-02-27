package com.jy.service.function.person.memberFunction;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.DateUtils;
import com.jy.common.utils.ExcelUtils;
import com.jy.common.utils.LiuUtils;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.content.product.course.CourseMapper;
import com.jy.dao.content.product.course.PersoncourseMapper;
import com.jy.dao.function.person.AppointserviceconfigMapper;
import com.jy.dao.function.person.PersonservicesMapper;
import com.jy.dao.function.person.memberFunction.MemberServiceManageViewMapper;
import com.jy.dao.function.person.memberFunction.PersonserviceapplicationMapper;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.product.course.Course;
import com.jy.entiy.content.product.course.Personcourse;
import com.jy.entiy.function.person.Appointserviceconfig;
import com.jy.entiy.function.person.Personservices;
import com.jy.entiy.function.person.memberFunction.MemberServiceManageView;
import com.jy.entiy.function.person.memberFunction.Personserviceapplication;
import com.jy.service.base.BaseService;
import com.sun.mail.imap.protocol.Status;

/**
 * 服务申请处理实现类
 * 
 * @author chenye
 *
 */
@Service
public class ServiceApplicationServiceImpl extends BaseService implements ServiceApplicationService {

	@Resource
	private MemberServiceManageViewMapper memberServiceManageViewMapper;

	@Resource
	private PersonserviceapplicationMapper personserviceapplicationMapper;

	@Resource
	private AccountMapper accountMapper;
	
	@Resource
	private PersonservicesMapper personservicesMapper;
	
	@Resource
	private PersoncourseMapper personcourseMapper;
	
	@Resource
	private CourseMapper courseMapper;
	
	@Resource
	private AppointserviceconfigMapper appointserviceconfigMapper;
	//处理状态  待处理
	private static final Integer PROCESS_STATUS1 = 1;
	//同意
	private static final Integer PROCESS_STATUS2 = 2;
	//拒绝
	private static final Integer PROCESS_STATUS3 = 3;
	//服务使用状态 已使用
	private static final Integer USE_STATUS1 = 1;
	//未使用
	private static final Integer USE_STATUS2 = 2;
	
	//预约服务类型 单面模拟
	private static final Integer TYPE2 = 2;
	//ICD报考
	private static final Integer TYPE6 = 6;
	
	@Override
	public Result processing(AccountInfo accountInfo, String AUTHORITY_CODE, Long serviceapplicationid,
			Integer applicationStatusID) throws MyException, ParseException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		// 参数检查
		if (serviceapplicationid == null || applicationStatusID == null) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		Personserviceapplication personserviceapplication = personserviceapplicationMapper
				.selectByPrimaryKey(serviceapplicationid);
		if(personserviceapplication == null) {
			return Result.build(80002,500,"没有这项服务申请!");
		}
		//Long accountid = accountInfo.getAccount().getAccountid();
		personserviceapplication.setApplicationstatusid(applicationStatusID);
		personserviceapplication.setHandletime(new Date());
		int i = personserviceapplicationMapper.updateByPrimaryKeySelective(personserviceapplication);
		if(personserviceapplication.getCourseid() == null) {
			Long personserviceid = personserviceapplication.getPersonserviceid();
			Personservices selectByPrimaryKey = personservicesMapper.selectByPrimaryKey(personserviceid);
			//同意申请
			if(applicationStatusID == PROCESS_STATUS2) {
				selectByPrimaryKey.setPersonservicestatusid(USE_STATUS1);//已使用(1.已使用 2.未使用)
				personservicesMapper.updateByPrimaryKeySelective(selectByPrimaryKey);
			}			
			//已拒绝服务为ICD报考或单面模拟时剩余名额加回来
			if(applicationStatusID == PROCESS_STATUS3 && selectByPrimaryKey.getServicetypeid() == TYPE2 || selectByPrimaryKey.getServicetypeid() == TYPE6) {
				
				Appointserviceconfig appointserviceconfig = appointserviceconfigMapper.selectByPrimaryKey(personserviceapplication.getAppointserviceid());
				Integer appointleftnum =appointserviceconfig.getAppointleftnum() + 1;
				appointserviceconfig.setAppointleftnum(appointleftnum);
				appointserviceconfigMapper.updateByPrimaryKeySelective(appointserviceconfig);
			}
		}
		//申请服务为激活课程
		if(personserviceapplication.getCourseid() != null) {
			if(applicationStatusID == PROCESS_STATUS2) {
				//修改课程过期时间
				Personcourse personcourse = personcourseMapper.selectByPrimaryKey(personserviceapplication.getCourseid());
				if(personcourse != null && personcourse.getCourseid() != null) {
					//课程id
					Long courseid = personcourse.getCourseid();
					//课程有效期
					Integer validdays = courseMapper.selectByPrimaryKey(courseid).getValiddays();
					if(validdays != null) {
						//激活过后下次到期时间
						long dqTime = new Date().getTime() + validdays*24l*60l*60l*1000l;
						
						String strdate = DateUtils.dateTimeToDateString(new Date(dqTime));
						strdate = strdate + " 23:59:59";
						Date dateParse = DateUtils.dateParse(strdate,DateUtils.DATE_TIME_PATTERN);
						personcourse.setExpiredate(dateParse);
						//激活状态
						personcourse.setIsactive(1);
						int jh = personcourseMapper.updateByPrimaryKeySelective(personcourse);
						if(jh < 1) {
							return Result.build(80002,500,"激活课程异常!");
						}
					}
					
				}
			}
			if(applicationStatusID == PROCESS_STATUS3) {
				//修改课程过期时间
				Personcourse personcourse = personcourseMapper.selectByPrimaryKey(personserviceapplication.getCourseid());
				if(personcourse != null && personcourse.getCourseid() != null) {
//					//课程id
//					Long courseid = personcourse.getCourseid();
//					//课程有效期
//					Integer validdays = courseMapper.selectByPrimaryKey(courseid).getValiddays();
//					if(validdays != null) {
//						//激活过后下次到期时间
//						long dqTime = new Date().getTime() + validdays*24l*60l*60l*1000l;
//						
//						
//						personcourse.setExpiredate(new Date(dqTime));
						//激活状态
						personcourse.setIsactive(3);
						int jh = personcourseMapper.updateByPrimaryKeySelective(personcourse);
						if(jh < 1) {
							return Result.build(80002,500,"激活课程异常!");
						}
					
					
				}
			}
			
			
		}
		if (i < 1) {
			throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
		}
		return Result.succee();

	}

	@Override
	public Result getServiceApplicationList(AccountInfo accountInfo, String AUTHORITY_CODE,
			String applicationstatusname, String search, String applicationtime, String appointdate, Integer page,
			Integer pageSize) throws MyException {

		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}

		// 处理参数
		search = this.checkSearch(search);
		applicationtime = this.checkSearchTime(applicationtime);
		appointdate = this.checkSearchTime(appointdate);

		
		//分页
		PageHelper.startPage(page, pageSize);
		List<MemberServiceManageView> list = memberServiceManageViewMapper.selectMemberServiceList(
				applicationstatusname, appointdate, applicationtime, search);
		PageInfo<MemberServiceManageView> info = new PageInfo<>(list);
		List<MemberServiceManageView> rows = info.getList();
		long total = info.getTotal();
		//服务类型为课程时赋值
		if(rows != null && rows.size() != 0) {
			for (MemberServiceManageView memberServiceManageView : rows) {
				if(memberServiceManageView != null) {
					Personserviceapplication personserviceapplication = personserviceapplicationMapper
							.selectByPrimaryKey(memberServiceManageView.getServiceapplicationid());
					//申请服务为激活课程
					if(personserviceapplication != null && personserviceapplication.getCourseid() != null) {
						//查询该课程信息
						Personcourse personcourse = personcourseMapper.selectByPrimaryKey(personserviceapplication.getCourseid());
						if(personcourse != null && personcourse.getCourseid() != null) {
							//课程id
							Long courseid = personcourse.getCourseid();
							Course course = courseMapper.selectByPrimaryKey(courseid);
							if(course != null) {
								memberServiceManageView.setCoursetitle(course.getCoursetitle());
							}
						}
						
					}
					if(memberServiceManageView.getServicetypename() == null && memberServiceManageView.getCoursetitle() != null) {
						memberServiceManageView.setServicetypename(memberServiceManageView.getCoursetitle());
					}
				}
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("rows", rows);
		map.put("count", total);
		return Result.succee(map);
	}

	@Override
	public Result exportList(AccountInfo accountInfo, String AUTHORITY_CODE, String applicationstatusname,
			String search, String applicationtime, String appointdate, Integer page, Integer pageSize, String url)
			throws MyException, ParseException, UnsupportedEncodingException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
	
		
		search = this.checkSearch(search);
		applicationtime = this.checkSearchTime(applicationtime);
		appointdate = this.checkSearchTime(appointdate);
		//导出不分页
		List<MemberServiceManageView> rows = memberServiceManageViewMapper.selectMemberServiceList(
				applicationstatusname, appointdate, applicationtime, search);

		Map<String, List<List<String>>> map = new HashMap<>();
		List<List<String>> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		list2.add("服务单号");
		list2.add("申请时间");
		list2.add("姓名");
		list2.add("手机号");
		list2.add("申请服务");
		list2.add("预约时间");
		list2.add("预约老师");
		list2.add("申请状态");
		list2.add("处理时间");

		list.add(list2);
		for (MemberServiceManageView serviceManage : rows) {
			Long accountid = serviceManage.getAccountid();
			Account account = accountMapper.selectByPrimaryKey(accountid);

		
			
			List<String> list3 = new ArrayList<>();
			list3.add(serviceManage.getServiceno() == null ? "" : serviceManage.getServiceno()+ "");
			if(serviceManage.getApplicationtime() != null) {
				String Applicationtime = DateUtils.dateFormat(serviceManage.getApplicationtime(), DateUtils.DATE_TIME_PATTERN);
				list3.add(Applicationtime + "");
			}else {
				list3.add("");
			}
			
			list3.add(account.getName() == null ? "" : account.getName() + "");
			list3.add(account.getPhone() == null ? "" : account.getPhone() + "");
			list3.add(serviceManage.getServicetypename() == null ? "" : serviceManage.getServicetypename() + "");
			if(serviceManage.getAppointdate() != null) {
				String Appointdate = DateUtils.dateFormat(serviceManage.getAppointdate(), DateUtils.DATE_TIME_PATTERN);
				list3.add(Appointdate + "");
			}else {
				list3.add("");
			}
			list3.add(serviceManage.getAppointteacher() == null ? "" :serviceManage.getAppointteacher() + "");
			list3.add(serviceManage.getApplicationstatusname() == null ? "" :serviceManage.getApplicationstatusname() + "");
			if(serviceManage.getHandletime() != null) {
				String Handletime = DateUtils.dateFormat(serviceManage.getHandletime(), DateUtils.DATE_TIME_PATTERN);
				list3.add(Handletime + "");
			}else {
				list3.add("");
			}
			
			

			list.add(list3);
		}
		map.put("服务申请表.xls", list);
		HSSFWorkbook workbook = ExcelUtils.getExcelFileStream(map);
		return Result.succee(workbook);
	}

}
