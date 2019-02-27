package com.jy.service.function.person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.redis.JedisClient;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.LiuUtils;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.dao.content.file.file.UsefileMapper;
import com.jy.dao.content.product.course.PersoncourseMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.AccountenterpriseMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.TalentpoolMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.TalentpoolapplicationMapper;
import com.jy.dao.function.enterprise.info.EnterpriseinfoMapper;
import com.jy.dao.function.enterprise.recruitment.EnterprisejobvacancyMapper;
import com.jy.dao.function.enterprise.recruitment.EnterpriserecruitingprocessMapper;
import com.jy.dao.function.marketingFunction.registrationManagement.PersonsigninMapper;
import com.jy.dao.function.marketingFunction.registrationManagement.SignincheckMapper;
import com.jy.dao.function.person.AppointserviceconfigMapper;
import com.jy.dao.function.person.CustomresumeMapper;
import com.jy.dao.function.person.CustomresumeotherMapper;
import com.jy.dao.function.person.ExpectjoblocationMapper;
import com.jy.dao.function.person.LivelocationMapper;
import com.jy.dao.function.person.OfflinesigninMapper;
import com.jy.dao.function.person.PersondeliveryapplicationMapper;
import com.jy.dao.function.person.PersonexaminereportMapper;
import com.jy.dao.function.person.PersonservicesMapper;
import com.jy.dao.function.person.PracticalexpirenceMapper;
import com.jy.dao.function.person.QualificationcertificateMapper;
import com.jy.dao.function.person.WorkexpirenceMapper;
import com.jy.dao.function.person.info.PersoninfoMapper;
import com.jy.dao.function.person.memberFunction.PersonserviceapplicationMapper;
import com.jy.dao.function.person.resume.ResumeinfoMapper;
import com.jy.dao.system.dictionaries.DictionariesMapper;
import com.jy.dao.system.select.ApplicationstatusMapper;
import com.jy.dao.system.select.AppointservicetimeMapper;
import com.jy.dao.system.select.AreaMapper;
import com.jy.dao.system.select.EducationbackgroundMapper;
import com.jy.dao.system.select.PersondeliverystatusMapper;
import com.jy.dao.system.select.PersonreporttypeMapper;
import com.jy.dao.system.select.PersonservicestatusMapper;
import com.jy.dao.system.select.PersonservicetypeMapper;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.entiy.content.product.course.Personcourse;
import com.jy.entiy.content.product.course.PersoncourseExample;
import com.jy.entiy.function.enterprise.enterpriseFunction.TalentpoolExample;
import com.jy.entiy.function.enterprise.enterpriseFunction.Talentpoolapplication;
import com.jy.entiy.function.enterprise.recruitment.EnterpriserecruitingprocessExample;
import com.jy.entiy.function.marketingFunction.registrationManagement.Personsignin;
import com.jy.entiy.function.marketingFunction.registrationManagement.PersonsigninExample;
import com.jy.entiy.function.marketingFunction.registrationManagement.Signincheck;
import com.jy.entiy.function.person.Appointserviceconfig;
import com.jy.entiy.function.person.AppointserviceconfigExample;
import com.jy.entiy.function.person.Customresume;
import com.jy.entiy.function.person.CustomresumeExample;
import com.jy.entiy.function.person.Customresumeother;
import com.jy.entiy.function.person.CustomresumeotherExample;
import com.jy.entiy.function.person.Expectjoblocation;
import com.jy.entiy.function.person.ExpectjoblocationExample;
import com.jy.entiy.function.person.Livelocation;
import com.jy.entiy.function.person.LivelocationExample;
import com.jy.entiy.function.person.Offlinesignin;
import com.jy.entiy.function.person.Persondeliveryapplication;
import com.jy.entiy.function.person.PersondeliveryapplicationExample;
import com.jy.entiy.function.person.Personexaminereport;
import com.jy.entiy.function.person.PersonexaminereportExample;
import com.jy.entiy.function.person.Personservices;
import com.jy.entiy.function.person.PersonservicesExample;
import com.jy.entiy.function.person.Practicalexpirence;
import com.jy.entiy.function.person.PracticalexpirenceExample;
import com.jy.entiy.function.person.Qualificationcertificate;
import com.jy.entiy.function.person.QualificationcertificateExample;
import com.jy.entiy.function.person.Workexpirence;
import com.jy.entiy.function.person.WorkexpirenceExample;
import com.jy.entiy.function.person.memberFunction.Personserviceapplication;
import com.jy.entiy.function.person.memberFunction.PersonserviceapplicationExample;
import com.jy.entiy.function.person.memberFunction.PersonserviceapplicationExample.Criteria;
import com.jy.entiy.function.person.resume.Resumeinfo;
import com.jy.entiy.function.person.resume.ResumeinfoExample;
import com.jy.entiy.system.select.Applicationstatus;
import com.jy.entiy.system.select.ApplicationstatusExample;
import com.jy.entiy.system.select.Appointservicetime;
import com.jy.entiy.system.select.Area;
import com.jy.entiy.system.select.AreaExample;
import com.jy.entiy.system.select.Persondeliverystatus;
import com.jy.entiy.system.select.PersondeliverystatusExample;
import com.jy.entiy.system.select.Personreporttype;
import com.jy.entiy.system.select.Personservicetype;
import com.jy.entiy.system.select.PersonservicetypeExample;
import com.jy.service.base.BaseService;

/**
 * 简历模块业务逻辑层接口
 *
 * @author liuhong
 * @date: 2018年8月29日 下午3:19:20
 * @Package: com.jy.service.resume
 */
@Service
public class ResumeServiceImpl extends BaseService implements ResumeService {

	/**
	 * 人才库已开启状态
	 */
	private static final String TALENT_POOL_OPEN = "Y";

	/**
	 * 是否投递简历到企业
	 */
	private static final String DELIVER = "deliver";

	/**
	 * 企业是否开启人才库
	 */
	private static final String TALENT_POOL = "talentPool";

	@Resource
	ResumeinfoMapper resumeinfoMapper;

	@Resource
	DictionariesMapper dictionariesMapper;

	@Resource
	PracticalexpirenceMapper practicalexpirenceMapper;

	@Resource
	WorkexpirenceMapper workexpirenceMapper;

	@Resource
	QualificationcertificateMapper qualificationcertificateMapper;

	@Resource
	CustomresumeotherMapper customresumeotherMapper;

	@Resource
	PersonexaminereportMapper personexaminereportMapper;

	@Resource
	CustomresumeMapper customresumeMapper;

	@Resource
	PersondeliverystatusMapper persondeliverystatusMapper;

	@Resource
	ApplicationstatusMapper applicationstatusMapper;

	@Resource
	PersondeliveryapplicationMapper persondeliveryapplicationMapper;

	@Resource
	OfflinesigninMapper offlinesigninMapper;

	@Resource
	PersonserviceapplicationMapper personserviceapplicationMapper;

	@Resource
	PersonservicesMapper personservicesMapper;

	@Resource
	AppointserviceconfigMapper appointserviceconfigMapper;

	@Resource
	PersonsigninMapper personsigninMapper;

	@Resource
	PersonservicestatusMapper personservicestatusMapper;

	@Resource
	PersonservicetypeMapper personservicetypeMapper;

	@Resource
	PersoncourseMapper personcourseMapper;

	@Resource
	UsefileMapper usefileMapper;

	@Resource
	FileinfoMapper fileinfoMapper;

	@Resource
	PersoninfoMapper personinfoMapper;

	@Resource
	PersonreporttypeMapper personreporttypeMapper;

	@Resource
	ExpectjoblocationMapper expectjoblocationMapper;

	@Resource
	LivelocationMapper livelocationMapper;

	@Resource
	EducationbackgroundMapper educationbackgroundMapper;

	@Resource
	AccountMapper accountMapper;

	@Resource
	SignincheckMapper signincheckMapper;

	@Resource
	AreaMapper areaMapper;

	@Resource
	AppointservicetimeMapper appointservicetimeMapper;

	@Resource
	EnterprisejobvacancyMapper enterprisejobvacancyMapper;

	@Resource
	EnterpriseinfoMapper enterpriseinfoMapper;

	@Resource
	private AccountenterpriseMapper accountenterpriseMapper;

	@Resource
	private EnterpriserecruitingprocessMapper enterpriserecruitingprocessMapper;

	@Resource
	private TalentpoolapplicationMapper talentpoolapplicationMapper;

	@Resource
	private TalentpoolMapper talentpoolMapper;

	@Resource
	private JedisClient jedisClient;

	@Value("${REDIS_PASSWORD}")
	private String REDIS_PASSWORD;

	@Value("${PDF_CODE_EXPIRE}")
	private Integer PDF_CODE_EXPIRE;


	private static final String DB_LOG_TYPE = "DB_LOG_RESUME";

	/**
	 * 添加个人标准简历
	 *
	 * @throws MyException
	 */
	/*
	 * @Override public Result addResumeInfo(Resumeinfo resumeinfo, AccountInfo
	 * accountInfo, Map<String, String> param) { // 查询当前用户是否存在标准简历 ResumeinfoExample
	 * example = new ResumeinfoExample();
	 * com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria =
	 * example.createCriteria();
	 * criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
	 * List<Resumeinfo> list = resumeinfoMapper.selectByExample(example); if
	 * (list.size() > 0) { resumeinfo.setResumeid(list.get(0).getResumeid());
	 * updateResumeInfo(resumeinfo, accountInfo, param); }
	 * resumeinfo.setCreateby(accountInfo.getAccount().getName());
	 * resumeinfo.setCreatepersonid(accountInfo.getAccount().getAccountid());
	 * resumeinfo.setCreatetime(new Date());
	 * resumeinfo.setUpdateby(accountInfo.getAccount().getName());
	 * resumeinfo.setUpdatepersonid(accountInfo.getAccount().getAccountid());
	 * resumeinfo.setUpdatetime(new Date());
	 * resumeinfo.setResumecode(LiuUtils.getResumeIdByUUId());
	 * resumeinfo.setAccountid(accountInfo.getAccount().getAccountid()); int i =
	 * resumeinfoMapper.insertSelective(resumeinfo); if (i < 0) { return
	 * Result.build(ResultEnum.INSERT_SQL_ERROR); }
	 *
	 * if (!insertExpectJobLocation(param, resumeinfo.getResumeid())) { return
	 * Result.build(ResultEnum.INSERT_SQL_ERROR); }
	 *
	 * if (param.get("liveProvince") != null || param.get("liveCity") != null ||
	 * param.get("liveCounty") != null) { if
	 * (!insertLiveLocation(param,resumeinfo.getResumeid())) { return
	 * Result.build(ResultEnum.INSERT_SQL_ERROR); } }
	 *
	 * // 插入数据库操作日志 String log1 = "ID为[" + accountInfo.getAccount().getAccountid() +
	 * "]的用户添加了个人标准简历，简历ID[" + resumeinfo.getResumeid() + "]"; try {
	 * this.dbLog(accountInfo.getAccount().getAccountid(),
	 * accountInfo.getAccount().getName(), log1, DB_LOG_TYPE); } catch (MyException
	 * e) { e.printStackTrace(); }
	 *
	 * return Result.succee(); }
	 */
	@Override
	public Result updateResumeInfo(Resumeinfo resumeinfo, AccountInfo accountInfo, Map<String, String> param,
			Long FileinfoID) throws MyException {

		ResumeinfoExample example3 = new ResumeinfoExample();
		com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria3 = example3.createCriteria();
		criteria3.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Resumeinfo> resumeinfos = resumeinfoMapper.selectByExample(example3);
		resumeinfo.setResumeid(resumeinfos.get(0).getResumeid());
		resumeinfo.setUpdatetime(new Date());
		Account account = accountInfo.getAccount();

		// 修改头像
		if (FileinfoID != null) {
			resumeinfo.setPhoto(FileinfoID);

			Resumeinfo resumeinfo2 = resumeinfoMapper.selectByPrimaryKey(resumeinfo.getResumeid());
			if (resumeinfo2.getPhoto() != null) {
				deleteFile(accountInfo, DB_LOG_TYPE, resumeinfo2.getPhoto(), "ResumeInfo", resumeinfo2.getResumeid());
			}

			addUseFile(FileinfoID, "ResumeInfo", resumeinfo2.getResumeid());
		}

		// 修改名字
		if (resumeinfo.getResumename() != null) {

			account.setName(resumeinfo.getResumename());
			accountMapper.updateByPrimaryKeySelective(account);
		}

		int i = resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo);
		if (i < 1) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}

		if (param.get("Province") != null || param.get("City") != null || param.get("County") != null) {
			// 删除原期望工作地点信息
			ExpectjoblocationExample example = new ExpectjoblocationExample();
			com.jy.entiy.function.person.ExpectjoblocationExample.Criteria criteria = example.createCriteria();
			criteria.andResumeidEqualTo(resumeinfo.getResumeid());
			expectjoblocationMapper.deleteByExample(example);

			// 重新插入期望工作地点信息
			insertExpectJobLocation(param, resumeinfo.getResumeid());
		}

		if (param.get("liveProvince") != null || param.get("liveCity") != null || param.get("liveCounty") != null) {
			LivelocationExample example = new LivelocationExample();
			com.jy.entiy.function.person.LivelocationExample.Criteria criteria = example.createCriteria();
			criteria.andResumeidEqualTo(resumeinfo.getResumeid());
			livelocationMapper.deleteByExample(example);
			insertLiveLocation(param, resumeinfo.getResumeid());
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户修改了个人标准简历，简历ID["
				+ resumeinfo.getResumeid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result getResumeInfo(AccountInfo accountInfo, Map<String, Object> param, boolean isTalentPool) throws MyException {

		List<Resumeinfo> list1 = new ArrayList<>();
		if (param.get("AccountID") != null) {
			ResumeinfoExample example = new ResumeinfoExample();
			com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria = example.createCriteria();
			criteria.andAccountidEqualTo((Long) param.get("AccountID"));
			list1 = resumeinfoMapper.selectByExample(example);
			if (list1.size() != 1) {
				/* return Result.build(ResultEnum.NOT_INSERT_RIGHTS); */
				return Result.build(ResultEnum.NOT_SELECT_RIGHTS);

			}
			param.put("ResumeID", list1.get(0).getResumeid());
		}

		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_MANAGE) == accountInfo.getAccount()
				.getDictionariesid()) {// 后台管理员
			/*
			 * Result result = checkAuthority(accountInfo,
			 * AuthorityCode.RESUME_INFO_SELECT); if (result.getStatus() != 200) { return
			 * result; }
			 */
		} else if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE) == accountInfo.getAccount().getDictionariesid()) {
			// 企业用户
			Map<String, Boolean> map = checkEnterpriseSelectAuthority(accountInfo.getAccount().getAccountid(), (Long) param.get("AccountID"), isTalentPool);
			if (!map.get(DELIVER) && !map.get(TALENT_POOL)) {
				// 无投递,无人才库服务股,返回无数据库查询权限
				return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
			}

			// 查询简历
			ResumeinfoExample example2 = new ResumeinfoExample();
			com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andAccountidEqualTo((Long) param.get("AccountID"));
			list1 = resumeinfoMapper.selectByExample(example2);
			if (map.get(DELIVER)) {
				// 有投递
				if (list1 == null || list1.size() == 0) {
					return Result.build(ResultEnum.DB_ERROR);
				} else {
					return Result.succee(resumeData(list1.get(0)));
				}
			} else if (map.get(TALENT_POOL)) {
				// 有人才库权限
				if (list1 == null || list1.size() == 0) {
					return Result.build(ResultEnum.DB_ERROR);
				} else {
					// 判断是否已下载该简历
					Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());
					TalentpoolExample example3 = new TalentpoolExample();
					TalentpoolExample.Criteria criteria = example3.createCriteria();
					criteria.andEnterpriseidEqualTo(enterpriseID);
					criteria.andAccountidEqualTo((Long) param.get("AccountID"));
					int i = talentpoolMapper.countByExample(example3);
					if (i >= 1) {
						// 已下载不做联系方式屏蔽
						return Result.succee(resumeData(list1.get(0)));
					} else {
						// 屏蔽联系方式
						Resumeinfo resumeinfo = list1.get(0);
						resumeinfo.setEmail(null);
						resumeinfo.setPhone(null);
						return Result.succee(resumeData(resumeinfo));
					}
				}
			}
		} else if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON) == accountInfo.getAccount()
				.getDictionariesid()) {// 个人注册用户
			ResumeinfoExample example = new ResumeinfoExample();
			com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria = example.createCriteria();
			criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());

			list1 = resumeinfoMapper.selectByExample(example);
		}

		if (list1.size() > 0) {
			return Result.succee(resumeData(list1.get(0)));
		} else {
			return Result.build(ResultEnum.SELECT_SQL_ERROR);
		}
	}

	// 简历数据处理
	private Map<String, Object> resumeData(Resumeinfo resumeinfo) {
		Map<String, Object> map = new HashMap<>();
		map.put("resumeinfo", resumeinfo);
		if (resumeinfo.getExpectjobstartdate() != null) {
			map.put("startdate", LiuUtils.timeFormatChange(resumeinfo.getExpectjobstartdate()).substring(0, 10));
		}
		if (resumeinfo.getExpectjobenddate() != null) {
			map.put("enddate", LiuUtils.timeFormatChange(resumeinfo.getExpectjobenddate()).substring(0, 10));
		}

		Account account = accountMapper.selectByPrimaryKey(resumeinfo.getAccountid());
		account.setPassword(null);
		map.put("account", account);

		if (resumeinfo.getPhoto() != null) {
			Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(resumeinfo.getPhoto());
			if (fileinfo != null && StringUtils.isNotBlank(fileinfo.getFilefullpath())) {
				map.put("headphoto", aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));
				aliyunOSSClientUtil.closeOSSClient();
			}

		}

		// 居住地
		LivelocationExample example2 = new LivelocationExample();
		com.jy.entiy.function.person.LivelocationExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andResumeidEqualTo(resumeinfo.getResumeid());
		List<Livelocation> livelocations = livelocationMapper.selectByExample(example2);
		if (livelocations.size() > 0) {
			Map<String, Object> livelocation = new HashMap<>();
			if (livelocations.get(0).getProvince() != null) {
				AreaExample example3 = new AreaExample();
				com.jy.entiy.system.select.AreaExample.Criteria criteria3 = example3.createCriteria();
				criteria3.andCodeEqualTo(livelocations.get(0).getProvince());
				List<Area> areas = areaMapper.selectByExample(example3);
				if (areas.size() > 0) {
					livelocation.put("province", areas.get(0));
				}
			}
			if (livelocations.get(0).getCity() != null) {
				AreaExample example3 = new AreaExample();
				com.jy.entiy.system.select.AreaExample.Criteria criteria3 = example3.createCriteria();
				criteria3.andCodeEqualTo(livelocations.get(0).getCity());
				List<Area> areas = areaMapper.selectByExample(example3);
				if (areas.size() > 0) {
					livelocation.put("city", areas.get(0));
				}
			}
			if (livelocations.get(0).getCounty() != null) {
				AreaExample example3 = new AreaExample();
				com.jy.entiy.system.select.AreaExample.Criteria criteria3 = example3.createCriteria();
				criteria3.andCodeEqualTo(livelocations.get(0).getCounty());
				List<Area> areas = areaMapper.selectByExample(example3);
				if (areas.size() > 0) {
					livelocation.put("county", areas.get(0));
				}

			}
			map.put("livelocation", livelocation);
		}

		// 期望工作地点
		ExpectjoblocationExample example3 = new ExpectjoblocationExample();
		com.jy.entiy.function.person.ExpectjoblocationExample.Criteria criteria3 = example3.createCriteria();
		criteria3.andResumeidEqualTo(resumeinfo.getResumeid());
		List<Expectjoblocation> expectjoblocations = expectjoblocationMapper.selectByExample(example3);
		List<Map<String, Area>> expectjoblocationss = new ArrayList<>();
		for (Expectjoblocation expectjoblocation : expectjoblocations) {
			Map<String, Area> m = new HashMap<>();
			if (expectjoblocation.getProvince() != null) {
				AreaExample example4 = new AreaExample();
				com.jy.entiy.system.select.AreaExample.Criteria criteria4 = example4.createCriteria();
				criteria4.andCodeEqualTo(expectjoblocation.getProvince());
				List<Area> areas = areaMapper.selectByExample(example4);
				if (areas.size() > 0) {
					m.put("province", areas.get(0));
				}

			}
			if (expectjoblocation.getCity() != null) {
				AreaExample example4 = new AreaExample();
				com.jy.entiy.system.select.AreaExample.Criteria criteria4 = example4.createCriteria();
				criteria4.andCodeEqualTo(expectjoblocation.getCity());
				List<Area> areas = areaMapper.selectByExample(example4);
				if (areas.size() > 0) {
					m.put("city", areas.get(0));
				}
			}
			if (expectjoblocation.getCounty() != null) {
				AreaExample example4 = new AreaExample();
				com.jy.entiy.system.select.AreaExample.Criteria criteria4 = example4.createCriteria();
				criteria4.andCodeEqualTo(expectjoblocation.getCounty());
				List<Area> areas = areaMapper.selectByExample(example4);
				if (areas.size() > 0) {
					m.put("county", areas.get(0));
				}
			}
			expectjoblocationss.add(m);
		}

		map.put("expectjoblocation", expectjoblocationss);

		if (resumeinfo.getEducationid() != null) {
			map.put("education", educationbackgroundMapper.selectByPrimaryKey(resumeinfo.getEducationid()));
		}

		return map;

	}

	@Override
	public Result addPracticalExpirence(Practicalexpirence practicalexpirence, AccountInfo accountInfo) {
		// 查询简历表，获取当前登录用户的简历ID
		ResumeinfoExample example = new ResumeinfoExample();
		com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Resumeinfo> resumeinfo = resumeinfoMapper.selectByExample(example);
		if (resumeinfo.size() < 1) {
			Resumeinfo resumeinfo2 = new Resumeinfo();
			resumeinfo2.setAccountid(accountInfo.getAccount().getAccountid());
			resumeinfoMapper.insertSelective(resumeinfo2);
			resumeinfo.add(resumeinfo2);
		}
		Resumeinfo resumeinfo2 = resumeinfo.get(0);
		resumeinfo2.setUpdatetime(new Date());
		resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo2);
		practicalexpirence.setResumeid(resumeinfo.get(0).getResumeid());

		int i = practicalexpirenceMapper.insertSelective(practicalexpirence);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户新增了个人实践经历，实践经历ID["
				+ practicalexpirence.getPracticeid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result updatePracticalExpirence(AccountInfo accountInfo, Practicalexpirence practicalexpirence) {

		// 查询实践经历表，判断权限
		Practicalexpirence pirence = practicalexpirenceMapper.selectByPrimaryKey(practicalexpirence.getPracticeid());
		Resumeinfo info = resumeinfoMapper.selectByPrimaryKey(pirence.getResumeid());
		info.setUpdatetime(new Date());
		resumeinfoMapper.updateByPrimaryKeySelective(info);
		if (!info.getAccountid().equals(accountInfo.getAccount().getAccountid())) {
			return Result.build(ResultEnum.NOT_UPDATE_RIGHTS);
		}

		int i = practicalexpirenceMapper.updateByPrimaryKeySelective(practicalexpirence);
		if (i < 1) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户修改了个人实践经历，实践经历ID["
				+ practicalexpirence.getPracticeid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result getPracticalExpirence(AccountInfo accountInfo, Practicalexpirence practicalexpirence, boolean isTalentPool)
			throws MyException {

		// 若是没传简历ID，获取简历ID
		Long ResumeID = practicalexpirence.getResumeid();
		if (ResumeID == null) {
			Practicalexpirence practicalexpirence2 = practicalexpirenceMapper
					.selectByPrimaryKey(practicalexpirence.getPracticeid());
			if (practicalexpirence2 != null) {
				ResumeID = practicalexpirence2.getResumeid();
			}
		}

		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE) == accountInfo.getAccount()
				.getDictionariesid()) {

			// 企业用户
			// 企业用户只能查看以投本企业的人的简历
			// 传入的实践经历信息所在的简历是否已经投递到当前登陆者的企业
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("AccountId", accountInfo.getAccount().getAccountid());
			param.put("ResumeID", ResumeID);
			Resumeinfo resumeinfo = resumeinfoMapper.selectByPrimaryKey(ResumeID);
			Map<String, Boolean> map = checkEnterpriseSelectAuthority(accountInfo.getAccount().getAccountid(), resumeinfo.getAccountid(), isTalentPool);
			if (!map.get(DELIVER) && !map.get(TALENT_POOL)) {
				return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
			}
		} else if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON) == accountInfo.getAccount()
				.getDictionariesid()) {
			// 个人用户，只能查看当前登陆者自己的实践经历
			if (ResumeID == null) {
				ResumeinfoExample example = new ResumeinfoExample();
				com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria = example.createCriteria();
				criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
				List<Resumeinfo> resumeinfos = resumeinfoMapper.selectByExample(example);
				if(resumeinfos.size()<1) {
					return Result.succee();
				}
				ResumeID = resumeinfos.get(0).getResumeid();
			}

		}

		PracticalexpirenceExample example = new PracticalexpirenceExample();
		com.jy.entiy.function.person.PracticalexpirenceExample.Criteria criteria = example.createCriteria();
		criteria.andResumeidEqualTo(ResumeID);
		if (practicalexpirence.getPracticeid() != null) {
			criteria.andPracticeidEqualTo(practicalexpirence.getPracticeid());
		}
		List<Practicalexpirence> list = practicalexpirenceMapper.selectByExample(example);
		for (Practicalexpirence practicalexpirence2 : list) {
			if (practicalexpirence2.getPracticestartdate() != null) {
				practicalexpirence2.setSdate(
						LiuUtils.timeFormatChange(practicalexpirence2.getPracticestartdate()).substring(0, 10));
			}
			if (practicalexpirence2.getPracticeenddate() != null) {
				practicalexpirence2
						.setEdate(LiuUtils.timeFormatChange(practicalexpirence2.getPracticeenddate()).substring(0, 10));
			}
		}
		return Result.succee(list);
	}

	@Override
	public Result deletePracticalExpirence(AccountInfo accountInfo, Long PracticeID) {
		// 查询简历信息，判断被删除实践经历是否属于当前用户
		Practicalexpirence practicalexpirence = practicalexpirenceMapper.selectByPrimaryKey(PracticeID);
		Resumeinfo resumeinfo = resumeinfoMapper.selectByPrimaryKey(practicalexpirence.getResumeid());
		resumeinfo.setUpdatetime(new Date());
		resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo);
		if (!resumeinfo.getAccountid().equals(accountInfo.getAccount().getAccountid())) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}
		int i = practicalexpirenceMapper.deleteByPrimaryKey(PracticeID);
		if (i < 1) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户删除了个人实践经历，实践经历ID["
				+ practicalexpirence.getPracticeid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result addWorkExpirence(AccountInfo accountInfo, Workexpirence workexpirence) {
		// 查询简历表，获取当前登录用户的简历ID
		ResumeinfoExample example = new ResumeinfoExample();
		com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Resumeinfo> resumeinfo = resumeinfoMapper.selectByExample(example);

		if (resumeinfo.size() < 1) {
			Resumeinfo resumeinfo2 = new Resumeinfo();
			resumeinfo2.setAccountid(accountInfo.getAccount().getAccountid());
			resumeinfoMapper.insertSelective(resumeinfo2);
			resumeinfo.add(resumeinfo2);
		}

		Resumeinfo resumeinfo2 = resumeinfo.get(0);
		resumeinfo2.setUpdatetime(new Date());
		resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo2);

		workexpirence.setResumeid(resumeinfo.get(0).getResumeid());

		int i = workexpirenceMapper.insertSelective(workexpirence);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户增加了工作经验信息，工作经验ID为["
				+ workexpirence.getWorkexpirenceid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	// 登录者是否有权限查询当前简历
	private boolean jurisdiction(AccountInfo accountInfo, Long resumeID, boolean isTalentPool) throws MyException {
		boolean flag = false;

		// if (checkAuthority(accountInfo, AuthorityCode.RESUME_INFO_SELECT).getStatus()
		// == 200) {
		//// flag = true
		// return true;
		// }

		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_MANAGE) == accountInfo.getAccount()
				.getDictionariesid().intValue()) {
			// 后台系统管理员,直接返回true
			return true;
		}

		Map<String, Object> param = new HashMap<>();
		param.put("ResumeID", resumeID);
		param.put("AccountID", accountInfo.getAccount().getAccountid());
		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE) == accountInfo.getAccount()
				.getDictionariesid().intValue()) {
			// 企业用户
			// 企业用户只能查看以投本企业的人的简历

			/*
			 * List<Resumeinfo> resumeinfos = resumeinfoMapper.getSendAccounts(param);
			 *
			 * if (resumeinfos.size() > 0) { flag = true; }
			 */
			Resumeinfo resumeinfo = resumeinfoMapper.selectByPrimaryKey(resumeID);
			Map<String, Boolean> map = checkEnterpriseSelectAuthority(accountInfo.getAccount().getAccountid(), resumeinfo.getAccountid(), isTalentPool);
			return map.get(DELIVER) || map.get(TALENT_POOL);

		} else if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON) == accountInfo.getAccount()
				.getDictionariesid().intValue()) {
			Resumeinfo resumeinfo = resumeinfoMapper.selectByPrimaryKey(resumeID);
			if (accountInfo.getAccount().getAccountid().equals(resumeinfo.getAccountid())) {
				/* flag = true; */
				return true;
			}
		}

		return flag;
	}

	@Override
	public Result updateWorkExpirence(AccountInfo accountInfo, Workexpirence workexpirence) {

		Workexpirence workexpirence2 = workexpirenceMapper.selectByPrimaryKey(workexpirence.getWorkexpirenceid());
		Resumeinfo resumeinfo = resumeinfoMapper.selectByPrimaryKey(workexpirence2.getResumeid());
		resumeinfo.setUpdatetime(new Date());
		resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo);

		if (!resumeinfo.getAccountid().equals(accountInfo.getAccount().getAccountid())) {
			return Result.build(ResultEnum.NOT_UPDATE_RIGHTS);
		}

		workexpirence.setResumeid(workexpirence2.getResumeid());
		int i = workexpirenceMapper.updateByPrimaryKeySelective(workexpirence);
		if (i < 1) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户修改了工作经验信息，工作经验ID为["
				+ workexpirence.getWorkexpirenceid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result getWorkExpirence(AccountInfo accountInfo, Workexpirence workexpirence, boolean isTalentPool) throws MyException {

		// 获取被查询简历ID
		Long resumeID = null;
		if (workexpirence != null) {
			resumeID = workexpirence.getResumeid();
		}
		if (workexpirence != null && workexpirence.getResumeid() == null) {
			workexpirence = workexpirenceMapper.selectByPrimaryKey(workexpirence.getWorkexpirenceid());
			if (workexpirence != null) {
				resumeID = workexpirence.getResumeid();
			}
		}
		if (resumeID == null) {
			ResumeinfoExample example = new ResumeinfoExample();
			com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria = example.createCriteria();
			criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
			List<Resumeinfo> resumeinfos = resumeinfoMapper.selectByExample(example);
			if(resumeinfos.size()<1) {
				return Result.succee();
			}
			resumeID = resumeinfos.get(0).getResumeid();
		}

		if (!jurisdiction(accountInfo, resumeID, isTalentPool)) {
			return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
		}

		WorkexpirenceExample example = new WorkexpirenceExample();
		com.jy.entiy.function.person.WorkexpirenceExample.Criteria criteria = example.createCriteria();
		if (workexpirence != null && workexpirence.getWorkexpirenceid() != null) {
			criteria.andWorkexpirenceidEqualTo(workexpirence.getWorkexpirenceid());
		}
		criteria.andResumeidEqualTo(resumeID);
		List<Workexpirence> list = workexpirenceMapper.selectByExample(example);
		for (Workexpirence workexpirence2 : list) {
			if (workexpirence2.getWorkstartdate() != null) {
				workexpirence2.setsDate(LiuUtils.timeFormatChange(workexpirence2.getWorkstartdate()).substring(0, 10));
			}
			if (workexpirence2.getWorkenddate() != null) {
				workexpirence2.seteDate(LiuUtils.timeFormatChange(workexpirence2.getWorkenddate()).substring(0, 10));
			}
		}

		return Result.succee(list);
	}

	@Override
	public Result deleteWorkExpirence(AccountInfo accountInfo, Long workexpirenceid) {

		Workexpirence workexpirence = workexpirenceMapper.selectByPrimaryKey(workexpirenceid);
		Resumeinfo resumeinfo = resumeinfoMapper.selectByPrimaryKey(workexpirence.getResumeid());
		if (!resumeinfo.getAccountid().equals(accountInfo.getAccount().getAccountid())) {
			return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
		}

		resumeinfo.setUpdatetime(new Date());
		resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo);

		int i = workexpirenceMapper.deleteByPrimaryKey(workexpirenceid);
		if (i < 0) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户删除了工作经验信息,验ID为["
				+ workexpirence.getWorkexpirenceid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result addQualificationCertificate(AccountInfo accountInfo,
			Qualificationcertificate qualificationcertificate) {
		ResumeinfoExample example = new ResumeinfoExample();
		com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Resumeinfo> list = resumeinfoMapper.selectByExample(example);
		if (list.size() < 1) {
			Resumeinfo resumeinfo = new Resumeinfo();
			resumeinfo.setAccountid(accountInfo.getAccount().getAccountid());
			resumeinfoMapper.insertSelective(resumeinfo);
			list.add(resumeinfo);
		}

		Resumeinfo resumeinfo = list.get(0);
		resumeinfo.setUpdatetime(new Date());
		resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo);

		qualificationcertificate.setResumeid(list.get(0).getResumeid());

		qualificationcertificate.setCreateby(accountInfo.getAccount().getName());
		qualificationcertificate.setCreatepersonid(accountInfo.getAccount().getAccountid());
		qualificationcertificate.setCreatetime(new Date());

		int i = qualificationcertificateMapper.insertSelective(qualificationcertificate);

		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户增加了证书，证书ID为["
				+ qualificationcertificate.getQcid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result updateQualificationCertificate(AccountInfo accountInfo,
			Qualificationcertificate qualificationcertificate) {

		Qualificationcertificate qualificationcertificate2 = qualificationcertificateMapper
				.selectByPrimaryKey(qualificationcertificate.getQcid());
		Resumeinfo resumeinfo = resumeinfoMapper.selectByPrimaryKey(qualificationcertificate2.getResumeid());
		if (!resumeinfo.getAccountid().equals(accountInfo.getAccount().getAccountid())) {
			return Result.build(ResultEnum.NOT_UPDATE_RIGHTS);
		}

		resumeinfo.setUpdatetime(new Date());
		resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo);

		int i = qualificationcertificateMapper.updateByPrimaryKeySelective(qualificationcertificate);
		if (i < 1) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户修改了证书，证书ID为["
				+ qualificationcertificate.getQcid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result getQualificationcertificate(AccountInfo accountInfo,
			Qualificationcertificate qualificationcertificate, boolean isTalentPool) throws MyException {

		Long remuseID = null;

		if (qualificationcertificate != null) {
			remuseID = qualificationcertificate.getResumeid();
		}

		if (qualificationcertificate != null && qualificationcertificate.getResumeid() == null
				&& qualificationcertificate.getQcid() == null) {
			ResumeinfoExample example = new ResumeinfoExample();
			com.jy.entiy.function.person.resume.ResumeinfoExample.Criteria criteria = example.createCriteria();
			criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
			List<Resumeinfo> resumeinfos = resumeinfoMapper.selectByExample(example);
			if(resumeinfos.size()<1) {
				return Result.succee();
			}
			remuseID = resumeinfos.get(0).getResumeid();
		}
		if (remuseID == null) {
			qualificationcertificate = qualificationcertificateMapper
					.selectByPrimaryKey(qualificationcertificate.getQcid());
			if (qualificationcertificate != null) {
				remuseID = qualificationcertificate.getResumeid();
			}
		}
		if (!jurisdiction(accountInfo, remuseID, isTalentPool)) {// 判断权限
			return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
		}

		QualificationcertificateExample example = new QualificationcertificateExample();
		com.jy.entiy.function.person.QualificationcertificateExample.Criteria criteria = example.createCriteria();
		criteria.andResumeidEqualTo(remuseID);
		if (qualificationcertificate.getQcid() != null) {
			criteria.andQcidEqualTo(qualificationcertificate.getQcid());
		}
		example.setOrderByClause("CertificateTypeID");
		List<Qualificationcertificate> list = qualificationcertificateMapper.selectByExample(example);
		if (qualificationcertificate.getQcid() != null && list.size() > 0) {
			Qualificationcertificate qualificationcertificate2 = list.get(0);
			if (qualificationcertificate2.getQcdate() != null) {
				qualificationcertificate2
						.setQcdates(LiuUtils.timeFormatChange(qualificationcertificate2.getQcdate()).substring(0, 10));
			}
			return Result.succee(qualificationcertificate2);
		}
		Map<Integer, List<Qualificationcertificate>> map = new HashMap<>();
		List<Qualificationcertificate> list1 = new ArrayList<>();
		List<Qualificationcertificate> list2 = new ArrayList<>();
		List<Qualificationcertificate> list3 = new ArrayList<>();
		List<Qualificationcertificate> list4 = new ArrayList<>();
		for (Qualificationcertificate qualificationcertificate2 : list) {

			if (qualificationcertificate2.getQcdate() != null) {
				String string = LiuUtils.timeFormatChange(qualificationcertificate2.getQcdate());
				qualificationcertificate2.setQcdates(string.substring(0, 10));
			}

			if (qualificationcertificate2.getCertificatetypeid() == 1) {
				list1.add(qualificationcertificate2);
			}
			if (qualificationcertificate2.getCertificatetypeid() == 2) {
				list2.add(qualificationcertificate2);
			}
			if (qualificationcertificate2.getCertificatetypeid() == 3) {
				list3.add(qualificationcertificate2);
			}
			if (qualificationcertificate2.getCertificatetypeid() == 4) {
				list4.add(qualificationcertificate2);
			}
		}
		map.put(1, list1);
		map.put(2, list2);
		map.put(3, list3);
		map.put(4, list4);

		return Result.succee(map);
	}

	@Override
	public Result deleteQualificationcertificate(AccountInfo accountInfo, Integer QCID) {
		Qualificationcertificate qualificationcertificate = qualificationcertificateMapper.selectByPrimaryKey(QCID);
		Resumeinfo resumeinfo = resumeinfoMapper.selectByPrimaryKey(qualificationcertificate.getResumeid());
		if (!resumeinfo.getAccountid().equals(accountInfo.getAccount().getAccountid())) {
			return Result.build(ResultEnum.NOT_DELETE_RIGHTS);
		}

		resumeinfo.setUpdatetime(new Date());
		resumeinfoMapper.updateByPrimaryKeySelective(resumeinfo);

		int i = qualificationcertificateMapper.deleteByPrimaryKey(QCID);
		if (i < 1) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}
		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户删除了证书，证书ID为["
				+ qualificationcertificate.getQcid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result customresume(AccountInfo accountInfo, Customresume customresume) throws MyException {
		CustomresumeExample example = new CustomresumeExample();
		com.jy.entiy.function.person.CustomresumeExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Customresume> list = customresumeMapper.selectByExample(example);

		if (list.size() < 1) {// 无个性简历 新曾
			customresume.setAccountid(accountInfo.getAccount().getAccountid());
			int i = customresumeMapper.insertSelective(customresume);
			if (i < 1) {
				return Result.build(ResultEnum.INSERT_SQL_ERROR);
			}

			// 插入文件引用信息
			if (customresume.getDocfileid() != null) {
				try {
					super.addUseFile(customresume.getDocfileid(), "CustomResume", customresume.getCustomresumeid());
				} catch (MyException e) {
					e.printStackTrace();
				}
			}
			if (customresume.getVediofileid() != null) {
				try {
					super.addUseFile(customresume.getVediofileid(), "CustomResume", customresume.getCustomresumeid());
				} catch (MyException e) {
					e.printStackTrace();
				}

			}

			// 插入数据库操作日志
			String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户新增个性简历，个性简历ID为["
					+ customresume.getCustomresumeid() + "]";
			try {
				this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1,
						DB_LOG_TYPE);
			} catch (MyException e) {
				e.printStackTrace();
			}
			return Result.succee();
		} else {// 有个性简历，修改
			Customresume oldCustomresume = list.get(0);
			customresume.setCustomresumeid(oldCustomresume.getCustomresumeid());
			int i = customresumeMapper.updateByPrimaryKeySelective(customresume);
			if (i < 1) {
				return Result.build(ResultEnum.UPDATE_SQL_ERROR);
			}

			// 插入文件引用信息及删除原引用文件
			if (customresume.getDocfileid() != null && !customresume.getDocfileid().equals(oldCustomresume.getDocfileid())) {
				try {
					super.addUseFile(customresume.getDocfileid(), "CustomResume", oldCustomresume.getCustomresumeid());
				} catch (MyException e) {
					e.printStackTrace();
				}
				super.deleteFile(accountInfo, DB_LOG_TYPE, oldCustomresume.getDocfileid(), "CustomResume", oldCustomresume.getCustomresumeid());
			}
			if (customresume.getVediofileid() != null && !customresume.getVediofileid().equals(oldCustomresume.getVediofileid())) {
				try {
					super.addUseFile(customresume.getVediofileid(), "CustomResume", oldCustomresume.getCustomresumeid());
				} catch (MyException e) {
					e.printStackTrace();
				}
				super.deleteFile(accountInfo, DB_LOG_TYPE, oldCustomresume.getVediofileid(), "CustomResume",oldCustomresume.getCustomresumeid() );
			}

			// 插入数据库操作日志
			String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户修改个性简历，个性简历ID为["
					+ customresume.getCustomresumeid() + "]";
			try {
				this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1,
						DB_LOG_TYPE);
			} catch (MyException e) {
				e.printStackTrace();
			}

			return Result.succee();
		}
	}

	@Override
	public Result deleteCustomresume(AccountInfo accountInfo, Long FileID) {
		List<Customresume> customresumes = new ArrayList<>();

		CustomresumeExample example = new CustomresumeExample();
		com.jy.entiy.function.person.CustomresumeExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		customresumes = customresumeMapper.selectByExample(example);
		if (customresumes.size() < 1) {
			return Result.build(ResultEnum.NOT_DELETE_RIGHTS);
		}

		Customresume customresume = customresumes.get(0);

		// 确定删除的文件是哪个文件
		int temp = -1;
		if (customresume.getDocfileid() != null && customresume.getDocfileid().equals(FileID)) {
			temp = 1;
		}
		if (customresume.getVediofileid() != null && customresume.getVediofileid().equals(FileID)) {
			temp = 2;
		}

		String log = null;

		if (temp < 0) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		} else if (temp == 1) {
			log = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户删除了个性简历文档，个性简历ID为["
					+ customresume.getCustomresumeid() + "]";
			customresume.setDocfileid(null);
		} else if (temp == 2) {
			log = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户删除了个性简历视频，个性简历ID为["
					+ customresume.getCustomresumeid() + "]";
			customresume.setVediofileid(null);
			;
		}

		int i = customresumeMapper.updateByPrimaryKeySelective(customresume);

		if (i < 1) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}

		// 删除服务器上文件
		try {
			super.deleteFile(accountInfo, DB_LOG_TYPE, FileID, "CustomResume", customresume.getCustomresumeid());
		} catch (MyException e) {
			e.printStackTrace();
		}

		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result getCustomresume(Long AccountID, AccountInfo accountInfo, boolean isTalentPool) throws MyException {

		boolean flag = false;
		/*
		 * if (checkAuthority(accountInfo, AuthorityCode.RESUME_INFO_SELECT).getStatus()
		 * == 200) { flag = true; }
		 */
		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_MANAGE) == accountInfo.getAccount()
				.getDictionariesid()) {
			// 后台管理员,拥有权限
			flag = true;
		}

		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE) == accountInfo.getAccount()
				.getDictionariesid()) {
			// 企业用户
			// 企业用户只能查看以投本企业的人的简历
			/*
			 * Map<String, Object> param = new HashMap<>(); param.put("AccountID",
			 * accountInfo.getAccount().getAccountid()); List<Resumeinfo> resumeinfos =
			 * resumeinfoMapper.getSendAccounts(param); for (Resumeinfo resumeinfo :
			 * resumeinfos) {// 循环取得已投递该企业的用户的ID if
			 * (resumeinfo.getAccountid().equals(AccountID)) { flag = true; } }
			 */
			Map<String, Boolean> map = checkEnterpriseSelectAuthority(accountInfo.getAccount().getAccountid(), AccountID, isTalentPool);
			flag = map.get(DELIVER) || map.get(TALENT_POOL);
		} else if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON) == accountInfo.getAccount()
				.getDictionariesid()) {
			AccountID = accountInfo.getAccount().getAccountid();
			flag = true;
		}

		if (!flag) {
			return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
		}

		CustomresumeExample example = new CustomresumeExample();
		com.jy.entiy.function.person.CustomresumeExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(AccountID);
		List<Customresume> customresumes = customresumeMapper.selectByExample(example);
		if (customresumes.size() != 1) {
			return Result.succee();
		}
		Map<String, Object> map = new HashMap<>();

		if (customresumes.get(0).getDocfileid() != null) {
			Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(customresumes.get(0).getDocfileid());
			if (fileinfo != null) {
				fileinfo.setFilefullpath(null);
				fileinfo.setFilepath(null);
				map.put("doc", fileinfo);
			}

		}
		if (customresumes.get(0).getVediofileid() != null) {
			Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(customresumes.get(0).getVediofileid());
			if (fileinfo != null) {
				fileinfo.setFilepath(super.getBASE64Encoder(fileinfo.getFilefullpath()));
				map.put("vedio", fileinfo);
			}
		}

		// 查询其他文件类型
		CustomresumeotherExample example2 = new CustomresumeotherExample();
		com.jy.entiy.function.person.CustomresumeotherExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andCustomresumeidEqualTo(customresumes.get(0).getCustomresumeid());
		List<Customresumeother> customresumeothers = customresumeotherMapper.selectByExample(example2);

		List<Fileinfo> fileinfos = new ArrayList<>();
		for (Customresumeother customresumeother : customresumeothers) {
			Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(customresumeother.getFileid());
			if(fileinfo != null) {
				fileinfos.add(fileinfo);
			}
		}
		map.put("others", fileinfos);
		return Result.succee(map);
	}

	@Override
	public Result uploadHtmlCode(Long accountID, String htmlCode) {
		jedisClient.set(Constant.PDF_HTML_CODE_PRE + accountID, htmlCode, REDIS_PASSWORD);
		jedisClient.expire(Constant.PDF_HTML_CODE_PRE + accountID, PDF_CODE_EXPIRE, REDIS_PASSWORD);
		return Result.succee();
	}

	@Override
	public Result exportPDF(AccountInfo accountInfo, Long accountID) throws Exception {

		String token = accountInfo.getToken();
		// 等待标准简历也上传HTML代码
		while (true) {
			String code = jedisClient.get(Constant.PDF_HTML_CODE_PRE + accountID, REDIS_PASSWORD);
			// 等待上传HTML代码超时时间为10秒
			int overTime = 10000;
			int waitTime = 0;
			if (StringUtils.isBlank(code)) {
				if (waitTime >= overTime) {
					return Result.build(ResultEnum.EXPORT_PDF_ERROR);
				} else {
					Thread.sleep(50);
					waitTime += 50;
				}
			} else {
				jedisClient.del(Constant.PDF_HTML_CODE_PRE + accountID, REDIS_PASSWORD);
				File file = new File(Constant.PDF_HTML_CODE_BASE_PATH + accountID + ".html");
				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(code);
				bw.close();
				Account account = accountMapper.selectByPrimaryKey(accountID);
				Runtime.getRuntime().exec("wkhtmltopdf " + Constant.PDF_HTML_CODE_BASE_PATH + accountID + ".html" + " " + Constant.PDF_HTML_CODE_BASE_PATH + account.getName() + ".pdf");
				//睡眠500毫秒等待PDF文件生成
				Thread.sleep(500);
				return Result.succee(new File(Constant.PDF_HTML_CODE_BASE_PATH + account.getName() + ".pdf"));
			}
		}

	}

	@Override
	public Result personExamineReport(AccountInfo accountInfo, Long FileID, Integer PersonReportTypeID,
			String CONTROLLER_CODE, Long AccountID) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, CONTROLLER_CODE);
		if (checkAuthority.getStatus() != 200) {
			return checkAuthority;
		}
		PersonexaminereportExample example = new PersonexaminereportExample();
		com.jy.entiy.function.person.PersonexaminereportExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(AccountID);
		criteria.andPersonreporttypeidEqualTo(PersonReportTypeID);
		List<Personexaminereport> personexaminereports = personexaminereportMapper.selectByExample(example);
		if (personexaminereports.size() > 0) {
			deletePersonExamineReport(accountInfo, personexaminereports.get(0).getPexaminereportid());
		}

		Personexaminereport personexaminereport = new Personexaminereport();
		personexaminereport.setAccountid(accountInfo.getAccount().getAccountid());
		personexaminereport.setFileid(FileID);
		personexaminereport.setCreateby(accountInfo.getAccount().getName());
		personexaminereport.setCreatepersonid(accountInfo.getAccount().getAccountid());
		personexaminereport.setCreatetime(new Date());

		int i = personexaminereportMapper.insertSelective(personexaminereport);

		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 添加引用表信息
		try {
			super.addUseFile(FileID, "PersonExamineReport", personexaminereport.getPexaminereportid());
		} catch (MyException e1) {
			e1.printStackTrace();
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户上传了检测报告，检测报告ID为["
				+ personexaminereport.getPexaminereportid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result deletePersonExamineReport(AccountInfo accountInfo, Long PExamineReportID) {
		Personexaminereport personexaminereport = personexaminereportMapper.selectByPrimaryKey(PExamineReportID);

		if (!accountInfo.getAccount().getAccountid().equals(personexaminereport.getAccountid())) {
			return Result.build(ResultEnum.NOT_DELETE_RIGHTS);
		}

		int i = personexaminereportMapper.deleteByPrimaryKey(PExamineReportID);// 删除数据库信息
		if (i < 1) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}

		if (personexaminereport.getFileid() != null) {
			// 删除文件信息
			try {
				super.deleteFile(accountInfo, DB_LOG_TYPE, personexaminereport.getFileid(), "PersonExamineReport",
						PExamineReportID);
			} catch (MyException e) {
				e.printStackTrace();
			}
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户删除了检测报告，检测报告ID为["
				+ personexaminereport.getPexaminereportid() + "]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result getPersonExamineReport(AccountInfo accountInfo, Long AccountID, Long PExamineReportID)
			throws MyException {
		boolean flag = false;

		if (accountInfo.getAccount().getDictionariesid() == 13) {
			flag = true;
		}
		int i = -1;
		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE) == accountInfo.getAccount()
				.getDictionariesid()) {

			Map<String, Object> param = new HashMap<>();
			param.put("AccountID", accountInfo.getAccount().getAccountid());

			// 查询已录用ID
			List<Persondeliverystatus> persondeliverystatus = persondeliverystatusMapper.selectByExample(null);
			for (Persondeliverystatus persondeliverystatus2 : persondeliverystatus) {
				if (persondeliverystatus2.getCode().equals(Constant.APPLICATION_STATUS_HAS_HIRED)) {
					param.put("PDeliveryStatusID", persondeliverystatus2.getPdeliverystatusid());
				}
			}

			// 企业用户
			// 企业用户只能查看以投本企业的人的简历

			List<Resumeinfo> resumeinfos = resumeinfoMapper.getSendAccounts(param);

			for (Resumeinfo resumeinfo : resumeinfos) {// 循环取得已投递该企业的用户的ID
				if (resumeinfo.getAccountid().equals(AccountID)) {
					flag = true;
				}
			}

			// 企业用户只能看增值报告
			List<Personreporttype> personreporttypes = personreporttypeMapper.selectByExample(null);
			for (Personreporttype personreporttype : personreporttypes) {
				if (personreporttype.getCode().equals(Constant.PERSON_REPORT_TYPE_TAX_DECLARATION)) {
					i = personreporttype.getPersonreporttypeid();
				}
			}

		}
		int flag1 = -1;
		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON) == accountInfo.getAccount()
				.getDictionariesid()) {
			AccountID = accountInfo.getAccount().getAccountid();
			flag = true;
			flag1 = 1;
		}

		if (!flag) {
			return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
		}
		PersonexaminereportExample example = new PersonexaminereportExample();
		com.jy.entiy.function.person.PersonexaminereportExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(AccountID);
		if (i > 0) {
			criteria.andPersonreporttypeidEqualTo(i);
		}
		if (flag1>0) {
			criteria.andPersonreporttypeidNotEqualTo(21);
		}
		if (PExamineReportID != null) {
			criteria.andPexaminereportidEqualTo(PExamineReportID);
		}
		example.setOrderByClause("PersonReportTypeID");
		Map<String, List<Personexaminereport>> map = new HashMap<>();
		List<Personexaminereport> personexaminereports = personexaminereportMapper.selectByExample(example);

		int temp = -1;
		List<Personexaminereport> list = new ArrayList<>();
		for (int j = 0; j < personexaminereports.size(); j++) {
			Personexaminereport personexaminereport = personexaminereports.get(j);
			if (personexaminereport.getFileid() != null) {
				Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(personexaminereport.getFileid());
				if (fileinfo != null) {
					personexaminereport.setName(fileinfo.getFilename());
				}

			}
			if (temp == -1) {
				temp = personexaminereport.getPersonreporttypeid();
				j--;
				continue;
			}
			if (temp != personexaminereport.getPersonreporttypeid()) {
				j--;
				map.put(personreporttypeMapper.selectByPrimaryKey(temp).getPreporttypename(), list);
				list = new ArrayList<>();
				temp = personexaminereport.getPersonreporttypeid();
			} else {
				list.add(personexaminereport);
			}
		}
		if (temp > 0) {
			map.put(personreporttypeMapper.selectByPrimaryKey(temp).getPreporttypename(), list);
		}

		return Result.succee(map);
	}

	@Override
	public Result addDeliver(AccountInfo accountInfo, Integer EJobVacancyID, String Remark) {

		PersondeliverystatusExample example = new PersondeliverystatusExample();
		PersondeliverystatusExample.Criteria criteria = example.createCriteria();
		criteria.andDeleiverystatusnameEqualTo("投递成功");
		List<Persondeliverystatus> persondeliverystatus = persondeliverystatusMapper.selectByExample(example);

		ApplicationstatusExample example2 = new ApplicationstatusExample();
		ApplicationstatusExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andApplicationstatusnameEqualTo("同意申请");
		List<Applicationstatus> applicationstatus = applicationstatusMapper.selectByExample(example2);

		Persondeliveryapplication persondeliveryapplication = new Persondeliveryapplication();
		persondeliveryapplication.setAccountid(accountInfo.getAccount().getAccountid());
		persondeliveryapplication.setApplicationstatusid(applicationstatus.get(0).getApplicationstatusid());
		persondeliveryapplication.setEjobvacancyid(EJobVacancyID);
		persondeliveryapplication.setRemark(Remark);
		persondeliveryapplication.setDeliverydate(new Date());
		persondeliveryapplication.setPdeliverystatusid(persondeliverystatus.get(0).getPdeliverystatusid());

		int i = persondeliveryapplicationMapper.insertSelective(persondeliveryapplication);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户提交了简历投递申请，投递申请ID为["
				+ persondeliveryapplication.getPdapplciationid() + "]，被处理表为[PersonDeliveryApplication]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result updateDeliver(AccountInfo accountInfo, Map<String, Object> param) {

		Persondeliveryapplication persondeliveryapplication = persondeliveryapplicationMapper
				.selectByPrimaryKey((Long) param.get("PDApplciationID"));
		persondeliveryapplication.setPdapplciationid((Long) param.get("PDApplciationID"));
		String log1 = "";
		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_MANAGE) == accountInfo.getAccount()
				.getDictionariesid()) {// 后台管理员处理投递申请
			persondeliveryapplication.setApplicationstatusid((Integer) param.get("ApplicationStatusID"));

			log1 = "ID为[" + accountInfo.getAccount().getAccountid()
					+ "]的管理员处理了投递申请，处理表为[PersonDeliveryApplication]，投递申请ID为["
					+ persondeliveryapplication.getPdapplciationid() + "]";

		}
		if (dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE) == accountInfo.getAccount()
				.getDictionariesid()) {// 企业用户修改投递结果
			persondeliveryapplication.setPdeliverystatusid((Integer) param.get("PDeliveryStatusID"));

			// 若是改为录用状态，则把这个人所有的投递申请表推荐成功次数+1
			Persondeliverystatus persondeliverystatus = persondeliverystatusMapper
					.selectByPrimaryKey((Integer) param.get("PDeliveryStatusID"));
			if (persondeliverystatus.getDeleiverystatusname().equals("录用")) {
				PersondeliveryapplicationExample example = new PersondeliveryapplicationExample();
				com.jy.entiy.function.person.PersondeliveryapplicationExample.Criteria criteria = example
						.createCriteria();
				criteria.andAccountidEqualTo(persondeliveryapplication.getPdapplciationid());
				Persondeliveryapplication persondeliveryapplication2 = new Persondeliveryapplication();
				persondeliveryapplication2.setRecommendsuccessno(persondeliveryapplication.getRecommendsuccessno() + 1);
				persondeliveryapplicationMapper.updateByExampleSelective(persondeliveryapplication2, example);
			}

			log1 = "ID为[" + accountInfo.getAccount().getAccountid()
					+ "]的企业用户修改了投递申请表[PersonDeliveryApplication]，投递申请ID为["
					+ persondeliveryapplication.getPdapplciationid() + "]";
		}
		if (param.get("Remark") != null) {
			persondeliveryapplication.setRemark((String) param.get("Remark"));
		}

		int i = persondeliveryapplicationMapper.updateByPrimaryKeySelective(persondeliveryapplication);
		if (i < 1) {
			return Result.build(ResultEnum.UPDATE_SQL_ERROR);
		}

		// 插入数据库操作日志
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result getDeliver(AccountInfo accountInfo, Integer pageCount, Integer pageNumber,
			Integer PDeliveryStatusID) {

		// 检查账号类型
		Integer accountTypePerson = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_PERSON);
		if (accountTypePerson.intValue() != accountInfo.getAccount().getDictionariesid()) {
			return Result.build(ResultEnum.ACCOUNT_ERROR);
		}

		List<Integer> PDeliveryStatusIDs = new ArrayList<>();
		// 简历投递流程状态:0全部,1.主动投递-待处理,2.主动投递-不合适,3.面试-进行中,4.面试-不合适,5.录用-待入职,6.录用-已入职,7.录用-未入职
		switch (PDeliveryStatusID) {
		case 1:
			PDeliveryStatusIDs = null;
			break;
		case 2:
			PDeliveryStatusIDs.add(1);
			break;
		case 3:
			PDeliveryStatusIDs.add(3);
			break;
		case 4:
			PDeliveryStatusIDs.add(2);
			PDeliveryStatusIDs.add(4);
			break;
		case 5:
			PDeliveryStatusIDs.add(5);
			PDeliveryStatusIDs.add(6);
			PDeliveryStatusIDs.add(7);
			break;
		default:
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		// 分页
		PageHelper.startPage(pageNumber, pageCount);
		List<Map<String, Object>> list = persondeliveryapplicationMapper
				.getDeliverList(accountInfo.getAccount().getAccountid(), PDeliveryStatusIDs);

		PageInfo<Map<String, Object>> info = new PageInfo<>(list);

		HashMap<Object, Object> map = new HashMap<>();
		map.put("rows", info.getList());
		map.put("count", info.getTotal());
		return Result.succee(map);
	}

	@Override
	public Result getOfflineSignIn(AccountInfo accountInfo) {
		PersonsigninExample example = new PersonsigninExample();
		com.jy.entiy.function.marketingFunction.registrationManagement.PersonsigninExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Map<String, Object>> list = new ArrayList<>();
		example.setOrderByClause("SiginTime DESC");
		List<Personsignin> personsignins = personsigninMapper.selectByExample(example);
		for (Personsignin personsignin : personsignins) {
			Map<String, Object> map = new HashMap<>();
			Offlinesignin offlinesignin = new Offlinesignin();
			Signincheck signincheck = signincheckMapper.selectByPrimaryKey(personsignin.getSignincheckid());
			if(signincheck == null) {
				continue;
			}
			offlinesignin.setActivitylocation(signincheck.getActivitylocation());
			offlinesignin.setActivityname(signincheck.getActivename());
			offlinesignin.setActivitytime(signincheck.getActivetime());
			offlinesignin.setSignintime(LiuUtils.timeFormatChange(personsignin.getSigintime().substring(0,19)));
			map.put("offlinesignin", offlinesignin);
			map.put("signincheck", signincheck);
			list.add(map);
		}
		return Result.succee(list);
	}

	@Override
	public Result getPersonServices(AccountInfo accountInfo) {

		Map<String, Object> map = new HashMap<>();

		// 查询我的服务信息
		PersonservicesExample example = new PersonservicesExample();
		com.jy.entiy.function.person.PersonservicesExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Personservices> personservices = personservicesMapper.selectByExample(example);
		List<Map<String, Object>> l1 = new ArrayList<>();
		for (Personservices personservices2 : personservices) {
			Map<String, Object> m1 = new HashMap<>();
			m1.put("personservices", personservices2);
			m1.put("type", personservicetypeMapper.selectByPrimaryKey(personservices2.getServicetypeid()));
			l1.add(m1);
		}
		map.put("personservices", l1);

		List<Long> longs = new ArrayList<>();
		for (Personservices service : personservices) {
			longs.add(service.getPersonserviceid());
		}

		if (longs.size() < 1) {
			return Result.succee();
		}

		// 查询我的服务申请信息
		PersonserviceapplicationExample example2 = new PersonserviceapplicationExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andPersonserviceidIn(longs);
		example2.setOrderByClause("ApplicationTime DESC");
		List<Personserviceapplication> personserviceapplications = personserviceapplicationMapper
				.selectByExample(example2);

		List<Map<String, Object>> l2 = new ArrayList<>();
		for (Personserviceapplication personserviceapplication : personserviceapplications) {
			Map<String, Object> map2 = new HashMap<>();
			map2.put("personserviceapplications", personserviceapplication);
			Appointserviceconfig appointserviceconfig = new Appointserviceconfig();
			if (personserviceapplication.getAppointserviceid() != null) {
				appointserviceconfig = appointserviceconfigMapper
						.selectByPrimaryKey(personserviceapplication.getAppointserviceid());
				map2.put("appointserviceconfigs", appointserviceconfig);
			}
			if (appointserviceconfig!=null) {
				if (appointserviceconfig.getAppointservicetimeid() != null) {
					map2.put("appointservicetime",
							appointservicetimeMapper.selectByPrimaryKey(appointserviceconfig.getAppointservicetimeid()));
				}
			}

			if (personserviceapplication.getApplicationstatusid() != null) {
				map2.put("status",
						applicationstatusMapper.selectByPrimaryKey(personserviceapplication.getApplicationstatusid()));
			}
			l2.add(map2);
		}

		map.put("personserviceapplications", l2);

		return Result.succee(map);
	}

	@Override
	public Result applyUpdateResume(AccountInfo accountInfo) {
		// 查询用户拥有的所有服务
		PersonservicesExample example = new PersonservicesExample();
		com.jy.entiy.function.person.PersonservicesExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Personservices> personservices = personservicesMapper.selectByExample(example);

		boolean flag = false;

		Long serviceID = null;

		// 查询修改简历服务 ID，并确定用户拥有的服务中是否存在此项服务
		List<Personservicetype> personservicetypes = personservicetypeMapper.selectByExample(null);
		for (Personservicetype personservicetype : personservicetypes) {
			for (Personservices personservic : personservices) {
				if (personservicetype.getCode().equals(Constant.APPLY_UPDATE_RESUME)
						&& personservic.getServicetypeid() == personservicetype.getServicetypeid()) {// 筛选出个人服务中的简历修改服务
					serviceID = personservic.getPersonserviceid();
					flag = true;
//					List<Personservicestatus> personservicestatus = personservicestatusMapper.selectByExample(null);
//					Personservicestatus unUse = new Personservicestatus();
//					Personservicestatus use = new Personservicestatus();
//					for (Personservicestatus personservicestatus2 : personservicestatus) {// 循环找出使用和为使用两种服务状态的ID
//						if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_UNUSE)) {
//							unUse = personservicestatus2;
//						}
//
//						if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_USE)) {
//							use = personservicestatus2;
//						}
//					}

//					if (unUse.getPersonservicestatusid() == personservic.getPersonservicestatusid()) {// 若服务未使用，则改为使用状态
//						personservic.setPersonservicestatusid(use.getPersonservicestatusid());
//						int i = personservicesMapper.updateByPrimaryKeySelective(personservic);
//						if (i < 1) {
//							return Result.build(ResultEnum.UPDATE_SQL_ERROR);
//						}
//
//						// 插入数据库操作日志
//						String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户修改了修改简历服务的状态，服务ID为["
//								+ personservic.getPersonserviceid() + "],操作表为[PersonServices]";
//						try {
//							this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(),
//									log1, DB_LOG_TYPE);
//						} catch (MyException e) {
//							e.printStackTrace();
//						}
//
//					}

				}
			}
		}

		if (!flag) {// 用户没有这项服务，结束请求并返回
			return Result.build(ResultEnum.IS_NOT_REMEMBER);
		}

		// 获取待处理状态的ID
		Integer statusID = null;
		List<Applicationstatus> applicationstatus = applicationstatusMapper.selectByExample(null);
		for (Applicationstatus applicationstatus2 : applicationstatus) {
			if (applicationstatus2.getCode().equals(Constant.APPLICATION_STATUS_WAIT)) {
				statusID = applicationstatus2.getApplicationstatusid();
			}
		}

		// 查询是否有待处理的简历修改服务申请，有则暂时不能申请简历修改服务
		PersonserviceapplicationExample example2 = new PersonserviceapplicationExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andPersonserviceidEqualTo(serviceID);
		criteria2.andApplicationstatusidEqualTo(statusID);
		criteria2.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Personserviceapplication> list = personserviceapplicationMapper.selectByExample(example2);

		if (list.size() > 0) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		Personserviceapplication personserviceapplication = new Personserviceapplication();
		personserviceapplication.setAccountid(accountInfo.getAccount().getAccountid());
		personserviceapplication.setPersonserviceid(serviceID);
		personserviceapplication.setApplicationstatusid(statusID);
		personserviceapplication.setServiceapplicationname("简历修改");
		personserviceapplication.setApplicationtime(new Date());
		personserviceapplication.setServiceno(LiuUtils.getServeIdByUUId());

		int i = personserviceapplicationMapper.insertSelective(personserviceapplication);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户申请了简历修改服务，服务申请ID为["
				+ personserviceapplication.getServiceapplicationid() + "],操作表为[PersonServiceApplication]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result applyMockInterview(AccountInfo accountInfo, Long AppointServiceID) {

		// 查询剩余预约名额
		Appointserviceconfig appointserviceconfig = appointserviceconfigMapper.selectByPrimaryKey(AppointServiceID);
		if (appointserviceconfig.getAppointleftnum() < 1) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 查询单面模拟服务ID
		PersonservicetypeExample example = new PersonservicetypeExample();
		PersonservicetypeExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(Constant.APPLY_MOCK_INTERVIEW);
		List<Personservicetype> personservicetype = personservicetypeMapper.selectByExample(example);
		if (personservicetype.size() != 1) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 查询是否拥有单面模拟服务
		PersonservicesExample example2 = new PersonservicesExample();
		com.jy.entiy.function.person.PersonservicesExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria2.andServicetypeidEqualTo(2);
		List<Personservices> personservices = personservicesMapper.selectByExample(example2);

		if (personservices.size() < 1) {
			return Result.build(ResultEnum.IS_NOT_REMEMBER);
		}

		// 查询所有服务状态,并取出使用和未使用状态
//		List<Personservicestatus> personservicestatus = personservicestatusMapper.selectByExample(null);
//		Personservicestatus unUse = new Personservicestatus();
//		Personservicestatus use = new Personservicestatus();
//		for (Personservicestatus personservicestatus2 : personservicestatus) {// 循环找出使用和为使用两种服务状态的ID
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_UNUSE)) {
//				unUse = personservicestatus2;
//			}
//
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_USE)) {
//				use = personservicestatus2;
//			}
//		}

//		if (personservices.get(0).getPersonservicestatusid().equals(unUse.getPersonservicestatusid())) {// 如果服务未使用，则改为使用
//			personservices.get(0).setPersonservicestatusid(use.getPersonservicestatusid());
//			personservicesMapper.updateByPrimaryKeySelective(personservices.get(0));
//		}

		// 获取待处理状态的ID,确定是否有未处理单面模拟申请
		Integer statusID = null;
		List<Applicationstatus> applicationstatus = applicationstatusMapper.selectByExample(null);
		for (Applicationstatus applicationstatus2 : applicationstatus) {
			if (applicationstatus2.getCode().equals(Constant.APPLICATION_STATUS_WAIT)) {
				statusID = applicationstatus2.getApplicationstatusid();
			}
		}

		// 查询是否有待处理的简历修改服务申请，有则暂时不能申请简历修改服务
		PersonserviceapplicationExample example3 = new PersonserviceapplicationExample();
		Criteria criteria3 = example3.createCriteria();
		criteria3.andPersonserviceidEqualTo(personservices.get(0).getPersonserviceid());
		criteria3.andApplicationstatusidEqualTo(statusID);
		criteria3.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Personserviceapplication> list = personserviceapplicationMapper.selectByExample(example3);

		if (list.size() > 0) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 添加服务申请信息
		Personserviceapplication personserviceapplication = new Personserviceapplication();
		personserviceapplication.setAccountid(accountInfo.getAccount().getAccountid());
		personserviceapplication.setPersonserviceid(personservices.get(0).getPersonserviceid());
		personserviceapplication.setApplicationstatusid(statusID);
		personserviceapplication.setServiceapplicationname("单面模拟");
		personserviceapplication.setApplicationtime(new Date());
		personserviceapplication.setServiceno(LiuUtils.getServeIdByUUId());
		personserviceapplication.setAppointserviceid(AppointServiceID);

		// 修改预约服务，将可预约人数减一
		appointserviceconfig.setAppointleftnum(appointserviceconfig.getAppointleftnum() - 1);
		appointserviceconfigMapper.updateByPrimaryKeySelective(appointserviceconfig);

		int i = personserviceapplicationMapper.insertSelective(personserviceapplication);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户申请了单面模拟服务，服务申请ID为["
				+ personserviceapplication.getServiceapplicationid() + "],操作表为[PersonServiceApplication]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result applyBeiSen(AccountInfo accountInfo) {
		// 查询北森测试服务ID
		PersonservicetypeExample example = new PersonservicetypeExample();
		PersonservicetypeExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(Constant.APPLY_MOCK_BEISEN);
		List<Personservicetype> personservicetype = personservicetypeMapper.selectByExample(example);
		if (personservicetype.size() != 1) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 查询是否拥有北森测评服务
		PersonservicesExample example2 = new PersonservicesExample();
		com.jy.entiy.function.person.PersonservicesExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria2.andServicetypeidEqualTo(3);
		List<Personservices> personservices = personservicesMapper.selectByExample(example2);

		if (personservices.size() < 1) {
			return Result.build(ResultEnum.IS_NOT_REMEMBER);
		}

		// 查询所有服务状态,并取出使用和未使用状态
//		List<Personservicestatus> personservicestatus = personservicestatusMapper.selectByExample(null);
//		Personservicestatus unUse = new Personservicestatus();
//		Personservicestatus use = new Personservicestatus();
//		for (Personservicestatus personservicestatus2 : personservicestatus) {// 循环找出使用和为使用两种服务状态的ID
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_UNUSE)) {
//				unUse = personservicestatus2;
//			}
//
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_USE)) {
//				use = personservicestatus2;
//			}
//		}
//
//		if (personservices.get(0).getPersonservicestatusid().equals(unUse.getPersonservicestatusid())) {// 如果服务未使用，则改为使用
//			personservices.get(0).setPersonservicestatusid(use.getPersonservicestatusid());
//			personservicesMapper.updateByPrimaryKeySelective(personservices.get(0));
//		}

		// 获取待处理状态的ID,确定是否有未处理北森测试申请
		Integer statusID = null;
		List<Applicationstatus> applicationstatus = applicationstatusMapper.selectByExample(null);
		for (Applicationstatus applicationstatus2 : applicationstatus) {
			if (applicationstatus2.getCode().equals(Constant.APPLICATION_STATUS_WAIT)) {
				statusID = applicationstatus2.getApplicationstatusid();
			}
		}

		// 查询是否有待处理的该服务申请，有则暂时不能申请该服务
		PersonserviceapplicationExample example3 = new PersonserviceapplicationExample();
		Criteria criteria3 = example3.createCriteria();
		criteria3.andPersonserviceidEqualTo(personservices.get(0).getPersonserviceid());
		criteria3.andApplicationstatusidEqualTo(statusID);
		criteria3.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Personserviceapplication> list = personserviceapplicationMapper.selectByExample(example3);

		if (list.size() > 0) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 添加服务申请信息

		Personserviceapplication personserviceapplication = new Personserviceapplication();
		personserviceapplication.setAccountid(accountInfo.getAccount().getAccountid());
		personserviceapplication.setPersonserviceid(personservices.get(0).getPersonserviceid());
		personserviceapplication.setApplicationstatusid(statusID);
		personserviceapplication.setServiceapplicationname("北森测评");
		personserviceapplication.setApplicationtime(new Date());
		personserviceapplication.setServiceno(LiuUtils.getServeIdByUUId());

		int i = personserviceapplicationMapper.insertSelective(personserviceapplication);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户申请了北森测试服务，服务申请ID为["
				+ personserviceapplication.getServiceapplicationid() + "],操作表为[PersonServiceApplication]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result mockInterview(AccountInfo accountInfo) {

		// 查询群面模拟服务ID
		PersonservicetypeExample example = new PersonservicetypeExample();
		PersonservicetypeExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(Constant.MOCK_INTERVIEW);
		List<Personservicetype> personservicetype = personservicetypeMapper.selectByExample(example);
		if (personservicetype.size() != 1) {
			return Result.build(ResultEnum.SELECT_ERROR);

		}

		// 查询是否拥有群面模拟服务
		PersonservicesExample example2 = new PersonservicesExample();
		com.jy.entiy.function.person.PersonservicesExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria2.andServicetypeidEqualTo(4);
		List<Personservices> personservices = personservicesMapper.selectByExample(example2);

		if (personservices.size() < 1) {
			return Result.build(ResultEnum.IS_NOT_REMEMBER);
		}

		// 查询所有服务状态,并取出使用和未使用状态
//		List<Personservicestatus> personservicestatus = personservicestatusMapper.selectByExample(null);
//		Personservicestatus unUse = new Personservicestatus();
//		Personservicestatus use = new Personservicestatus();
//		for (Personservicestatus personservicestatus2 : personservicestatus) {// 循环找出使用和为使用两种服务状态的ID
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_UNUSE)) {
//				unUse = personservicestatus2;
//			}
//
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_USE)) {
//				use = personservicestatus2;
//			}
//		}
//
//		if (personservices.get(0).getPersonservicestatusid().equals(unUse.getPersonservicestatusid())) {// 如果服务未使用，则改为使用
//			personservices.get(0).setPersonservicestatusid(use.getPersonservicestatusid());
//			personservicesMapper.updateByPrimaryKeySelective(personservices.get(0));
//		}

		// 获取待处理状态的ID
		Integer statusID = null;
		List<Applicationstatus> applicationstatus = applicationstatusMapper.selectByExample(null);
		for (Applicationstatus applicationstatus2 : applicationstatus) {
			if (applicationstatus2.getCode().equals(Constant.APPLICATION_STATUS_WAIT)) {
				statusID = applicationstatus2.getApplicationstatusid();
			}
		}

		// 查询是否有待处理的该服务申请，有则暂时不能申请该服务
		PersonserviceapplicationExample example3 = new PersonserviceapplicationExample();
		Criteria criteria3 = example3.createCriteria();
		criteria3.andPersonserviceidEqualTo(personservices.get(0).getPersonserviceid());
		criteria3.andApplicationstatusidEqualTo(statusID);
		criteria3.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Personserviceapplication> list = personserviceapplicationMapper.selectByExample(example3);

		if (list.size() > 0) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 添加服务申请信息

		Personserviceapplication personserviceapplication = new Personserviceapplication();
		personserviceapplication.setAccountid(accountInfo.getAccount().getAccountid());
		personserviceapplication.setPersonserviceid(personservices.get(0).getPersonserviceid());
		personserviceapplication.setApplicationstatusid(statusID);
		personserviceapplication.setServiceapplicationname("群面模拟");
		personserviceapplication.setApplicationtime(new Date());
		personserviceapplication.setServiceno(LiuUtils.getServeIdByUUId());

		int i = personserviceapplicationMapper.insertSelective(personserviceapplication);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户申请了群面模拟服务，服务申请ID为["
				+ personserviceapplication.getServiceapplicationid() + "],操作表为[PersonServiceApplication]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();

	}

	@Override
	public Result offlineCourse(AccountInfo accountInfo) {
		// 查询线下课程服务ID
		PersonservicetypeExample example = new PersonservicetypeExample();
		PersonservicetypeExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(Constant.OFFLINE_COURSE);
		List<Personservicetype> personservicetype = personservicetypeMapper.selectByExample(example);
		if (personservicetype.size() != 1) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 查询是否拥有线下课程服务
		PersonservicesExample example2 = new PersonservicesExample();
		com.jy.entiy.function.person.PersonservicesExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria2.andServicetypeidEqualTo(5);
		List<Personservices> personservices = personservicesMapper.selectByExample(example2);

		if (personservices.size() < 1) {
			return Result.build(ResultEnum.IS_NOT_REMEMBER);
		}

		// 查询所有服务状态,并取出使用和未使用状态
//		List<Personservicestatus> personservicestatus = personservicestatusMapper.selectByExample(null);
//		Personservicestatus unUse = new Personservicestatus();
//		Personservicestatus use = new Personservicestatus();
//		for (Personservicestatus personservicestatus2 : personservicestatus) {// 循环找出使用和为使用两种服务状态的ID
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_UNUSE)) {
//				unUse = personservicestatus2;
//			}
//
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_USE)) {
//				use = personservicestatus2;
//			}
//		}
//
//		if (personservices.get(0).getPersonservicestatusid().equals(unUse.getPersonservicestatusid())) {// 如果服务未使用，则改为使用
//			personservices.get(0).setPersonservicestatusid(use.getPersonservicestatusid());
//			personservicesMapper.updateByPrimaryKeySelective(personservices.get(0));
//		}

		// 获取待处理状态的ID
		Integer statusID = null;
		List<Applicationstatus> applicationstatus = applicationstatusMapper.selectByExample(null);
		for (Applicationstatus applicationstatus2 : applicationstatus) {
			if (applicationstatus2.getCode().equals(Constant.APPLICATION_STATUS_WAIT)) {
				statusID = applicationstatus2.getApplicationstatusid();
			}
		}

		// 查询是否有待处理的该服务申请，有则暂时不能申请该服务
		PersonserviceapplicationExample example3 = new PersonserviceapplicationExample();
		Criteria criteria3 = example3.createCriteria();
		criteria3.andPersonserviceidEqualTo(personservices.get(0).getPersonserviceid());
		criteria3.andApplicationstatusidEqualTo(statusID);
		criteria3.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Personserviceapplication> list = personserviceapplicationMapper.selectByExample(example3);

		if (list.size() > 0) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 添加服务申请信息
		Personserviceapplication personserviceapplication = new Personserviceapplication();
		personserviceapplication.setAccountid(accountInfo.getAccount().getAccountid());
		personserviceapplication.setPersonserviceid(personservices.get(0).getPersonserviceid());
		personserviceapplication.setApplicationstatusid(statusID);
		personserviceapplication.setServiceapplicationname("线下课程");
		personserviceapplication.setApplicationtime(new Date());
		personserviceapplication.setServiceno(LiuUtils.getServeIdByUUId());

		int i = personserviceapplicationMapper.insertSelective(personserviceapplication);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户申请了线下课程服务，服务申请ID为["
				+ personserviceapplication.getServiceapplicationid() + "],操作表为[PersonServiceApplication]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();

	}

	@Override
	public Result icdlTEST(AccountInfo accountInfo, Long AppointServiceID) {
		// 查询可预约名额数
		Appointserviceconfig appointserviceconfig = appointserviceconfigMapper.selectByPrimaryKey(AppointServiceID);
		if (appointserviceconfig.getAppointleftnum() < 1) {
			return Result.build(ResultEnum.NOT_ENOUGH_PLACES);
		}

		// 查询ICDL报考服务ID
		PersonservicetypeExample example = new PersonservicetypeExample();
		PersonservicetypeExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(Constant.ICDL);
		List<Personservicetype> personservicetype = personservicetypeMapper.selectByExample(example);
		if (personservicetype.size() != 1) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 查询是否拥有ICDL报考服务
		PersonservicesExample example2 = new PersonservicesExample();
		com.jy.entiy.function.person.PersonservicesExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria2.andServicetypeidEqualTo(6);
		List<Personservices> personservices = personservicesMapper.selectByExample(example2);

		if (personservices.size() < 1) {
			return Result.build(ResultEnum.IS_NOT_REMEMBER);
		}

		// 查询所有服务状态,并取出使用和未使用状态
//		List<Personservicestatus> personservicestatus = personservicestatusMapper.selectByExample(null);
//		Personservicestatus unUse = new Personservicestatus();
//		Personservicestatus use = new Personservicestatus();
//		for (Personservicestatus personservicestatus2 : personservicestatus) {// 循环找出使用和为使用两种服务状态的ID
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_UNUSE)) {
//				unUse = personservicestatus2;
//			}
//
//			if (personservicestatus2.getCode().equals(Constant.SERVICE_STATUS_USE)) {
//				use = personservicestatus2;
//			}
//		}
//
//		if (personservices.get(0).getPersonservicestatusid().equals(unUse.getPersonservicestatusid())) {// 如果服务未使用，则改为使用
//			personservices.get(0).setPersonservicestatusid(use.getPersonservicestatusid());
//			personservicesMapper.updateByPrimaryKeySelective(personservices.get(0));
//		}

		// 获取待处理状态的ID,确定是否有未处理ICDL报考申请
		Integer statusID = null;
		List<Applicationstatus> applicationstatus = applicationstatusMapper.selectByExample(null);
		for (Applicationstatus applicationstatus2 : applicationstatus) {
			if (applicationstatus2.getCode().equals(Constant.APPLICATION_STATUS_WAIT)) {
				statusID = applicationstatus2.getApplicationstatusid();
			}
		}

		// 查询是否有待处理的简历修改服务申请，有则暂时不能申请简历修改服务
		PersonserviceapplicationExample example3 = new PersonserviceapplicationExample();
		Criteria criteria3 = example3.createCriteria();
		criteria3.andPersonserviceidEqualTo(personservices.get(0).getPersonserviceid());
		criteria3.andApplicationstatusidEqualTo(statusID);
		criteria3.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Personserviceapplication> list = personserviceapplicationMapper.selectByExample(example3);

		if (list.size() > 0) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 添加服务申请信息
		Personserviceapplication personserviceapplication = new Personserviceapplication();
		personserviceapplication.setAccountid(accountInfo.getAccount().getAccountid());
		personserviceapplication.setPersonserviceid(personservices.get(0).getPersonserviceid());
		personserviceapplication.setApplicationstatusid(statusID);
		personserviceapplication.setServiceapplicationname("ICDL报考");
		personserviceapplication.setApplicationtime(new Date());
		personserviceapplication.setServiceno(LiuUtils.getServeIdByUUId());
		personserviceapplication.setAppointserviceid(AppointServiceID);

		// 修改预约服务，将可预约人数减一
		appointserviceconfig.setAppointleftnum(appointserviceconfig.getAppointleftnum() - 1);
		appointserviceconfigMapper.updateByPrimaryKeySelective(appointserviceconfig);

		int i = personserviceapplicationMapper.insertSelective(personserviceapplication);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户申请了ICDL报考服务，服务申请ID为["
				+ personserviceapplication.getServiceapplicationid() + "],操作表为[PersonServiceApplication]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	@Override
	public Result activateCourst(AccountInfo accountInfo, Long CourseID) {
		// 判断权限
		PersoncourseExample example = new PersoncourseExample();
		com.jy.entiy.content.product.course.PersoncourseExample.Criteria criteria = example.createCriteria();
		criteria.andCourseidEqualTo(CourseID);
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Personcourse> personcourses = personcourseMapper.selectByExample(example);
		if (personcourses.size() < 1) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		}

		// 获取待处理状态的ID,确定是否有未处理ICDL报考申请
		Integer statusID = null;
		List<Applicationstatus> applicationstatus = applicationstatusMapper.selectByExample(null);
		for (Applicationstatus applicationstatus2 : applicationstatus) {
			if (applicationstatus2.getCode().equals(Constant.APPLICATION_STATUS_WAIT)) {
				statusID = applicationstatus2.getApplicationstatusid();
			}
		}

		Personserviceapplication personserviceapplication = new Personserviceapplication();
		personserviceapplication.setAccountid(accountInfo.getAccount().getAccountid());
		personserviceapplication.setCourseid(CourseID);
		personserviceapplication.setApplicationstatusid(statusID);
		personserviceapplication.setServiceapplicationname("申请激活课程");
		personserviceapplication.setApplicationtime(new Date());
		personserviceapplication.setServiceno(LiuUtils.getServeIdByUUId());

		int i = personserviceapplicationMapper.insertSelective(personserviceapplication);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}

		// 修改个人课程表激活状态
		personcourses.get(0).setIsactive(4);
		personcourseMapper.updateByExample(personcourses.get(0), example);

		// 插入数据库操作日志
		String log1 = "ID为[" + accountInfo.getAccount().getAccountid() + "]的用户申请激活课程，课程ID为[" + CourseID
				+ "],操作表为[PersonServiceApplication和PersonCourse]";
		try {
			this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log1, DB_LOG_TYPE);
		} catch (MyException e) {
			e.printStackTrace();
		}

		return Result.succee();
	}

	private boolean insertExpectJobLocation(Map<String, String> param, Long resumeid) {
		// 插入期望工作地点信息
		List<String> provinces = LiuUtils.getIDS(param.get("Province"));
		List<String> citys = LiuUtils.getIDS(param.get("City"));
		List<String> countys = LiuUtils.getIDS(param.get("County"));
		if (!(provinces.size() == citys.size() && citys.size() == countys.size())) {
			return false;
		}
		for (int i = 0; i < provinces.size(); i++) {
			Expectjoblocation expectjoblocation = new Expectjoblocation();
			String province = provinces.get(i);
			String city = citys.get(i);
			String county = countys.get(i);
			if (!province.equals("-1")) {
				expectjoblocation.setProvince(province);
			}
			if (!city.equals("-1")) {
				expectjoblocation.setCity(city);
			}
			if (!county.equals("-1")) {
				expectjoblocation.setCounty(county);
			}

			expectjoblocation.setResumeid(resumeid);
			expectjoblocationMapper.insertSelective(expectjoblocation);
		}
		return true;
	}

	private boolean insertLiveLocation(Map<String, String> param, Long resumeid) {
		// 插入居住地信息
		Livelocation livelocation = new Livelocation();
		if (param.get("liveProvince") != null) {
			livelocation.setProvince(param.get("liveProvince"));
		}
		if (param.get("liveCity") != null) {
			livelocation.setCity(param.get("liveCity"));
		}
		if (param.get("liveCounty") != null) {
			livelocation.setCounty(param.get("liveCounty"));
		}

		livelocation.setResumeid(resumeid);
		livelocationMapper.insertSelective(livelocation);
		return true;
	}

	@Override
	public Result customOther(AccountInfo accountInfo, Long FileID) throws MyException {
		CustomresumeExample example = new CustomresumeExample();
		com.jy.entiy.function.person.CustomresumeExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Customresume> customresumes = customresumeMapper.selectByExample(example);
		if (customresumes.size() < 1) {
			Customresume customresume = new Customresume();
			customresume.setAccountid(accountInfo.getAccount().getAccountid());
			customresumeMapper.insertSelective(customresume);
			customresumes.add(customresume);
		}
		Customresumeother customresumeother = new Customresumeother();
		customresumeother.setCustomresumeid(customresumes.get(0).getCustomresumeid());
		customresumeother.setFileid(FileID);
		int i = customresumeotherMapper.insertSelective(customresumeother);
		if (i < 1) {
			return Result.build(ResultEnum.INSERT_SQL_ERROR);
		}
		log(DB_LOG_TYPE, customresumeother, accountInfo, 1, "CustomResumeOther", null);
		super.addUseFile(FileID, "CustomResumeOther", customresumeother.getCustomresumeotherid());

		return Result.succee();
	}

	@Override
	public Result customOther(Long FileID, AccountInfo accountInfo) throws MyException {
		CustomresumeExample example = new CustomresumeExample();
		com.jy.entiy.function.person.CustomresumeExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		List<Customresume> customresumes = customresumeMapper.selectByExample(example);
		if (customresumes.size() < 1) {
			return Result.build(ResultEnum.NOT_DELETE_RIGHTS);
		}
		CustomresumeotherExample example2 = new CustomresumeotherExample();
		com.jy.entiy.function.person.CustomresumeotherExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andCustomresumeidEqualTo(customresumes.get(0).getCustomresumeid());
		criteria2.andFileidEqualTo(FileID);
		List<Customresumeother> customresumeothers = customresumeotherMapper.selectByExample(example2);
		int i = customresumeotherMapper.deleteByExample(example2);
		if (i < 1) {
			return Result.build(ResultEnum.DELETE_SQL_ERROR);
		}

		log(DB_LOG_TYPE, customresumeothers.get(0), accountInfo, 2, "CustomResumeOther", null);

		super.deleteFile(accountInfo, DB_LOG_TYPE, FileID, "CustomResumeOther",
				customresumeothers.get(0).getCustomresumeotherid());

		return Result.succee();
	}

	@Override
	public Result isPersonServices(AccountInfo accountInfo, Integer type) {
		PersonservicesExample example = new PersonservicesExample();
		com.jy.entiy.function.person.PersonservicesExample.Criteria criteria = example.createCriteria();
		criteria.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria.andServicetypeidEqualTo(type);
		List<Personservices> personservices = personservicesMapper.selectByExample(example);
		if (personservices.size() < 1) {
			return Result.build(ResultEnum.NOT_SELECT_RIGHTS);
		}
		PersonserviceapplicationExample example2 = new PersonserviceapplicationExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andAccountidEqualTo(accountInfo.getAccount().getAccountid());
		criteria2.andPersonserviceidEqualTo(personservices.get(0).getPersonserviceid());
		criteria2.andApplicationstatusidEqualTo(1);
		List<Personserviceapplication> personserviceapplications = personserviceapplicationMapper
				.selectByExample(example2);
		if (personserviceapplications.size() > 0) {
			return Result.build(ResultEnum.NOT_INSERT_RIGHTS);
		} else {
			return Result.succee();
		}
	}

	@Override
	public Result appointServiceConfig(String type) {
		AppointserviceconfigExample example = new AppointserviceconfigExample();
		com.jy.entiy.function.person.AppointserviceconfigExample.Criteria criteria = example.createCriteria();
		criteria.andAppointservicenameEqualTo(type);
		example.setOrderByClause("AppointDate ");
		List<Appointserviceconfig> appointserviceconfigs = appointserviceconfigMapper.selectByExample(example);
		if (appointserviceconfigs.size() < 1) {
			return Result.succee();
		}

		List<Appointserviceconfig> lists = new ArrayList<>();

		for (Appointserviceconfig appointserviceconfig : appointserviceconfigs) {
			// 超过预约时间，去掉数据
			if (appointserviceconfig.getAppointservicetimeid() == 1) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 10:00:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 2) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 10:30:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 3) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 11:00:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 4) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 11:30:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 5) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 12:00:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 6) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 12:30:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 7) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 13:00:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 8) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 13:30:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 9) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 14:00:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 10) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 14:30:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 11) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 15:00:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 12) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 15:30:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 13) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 16:00:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 14) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 16:30:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			} else if (appointserviceconfig.getAppointservicetimeid() == 15) {
				String time = appointserviceconfig.getAppointdate().substring(0, 10) + " 17:00:00";
				if (LiuUtils.timeFormatChange(time).before(new Date())) {
					continue;
				}
			}
			lists.add(appointserviceconfig);
		}

		List<Map<String, Object>> list1 = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		List<Appointserviceconfig> list2 = new ArrayList<>();
		List<Map<String, Object>> list3 = new ArrayList<>();
		Map<String, Object> map2 = new HashMap<>();
		String temp = "";
		int temp2 = -1;
		for (int i = 0; i < lists.size(); i++) {
			Appointserviceconfig appointserviceconfig = lists.get(i);

			if (temp.equals("")) {
				temp = appointserviceconfig.getAppointdate();
			}
			if (temp.equals(appointserviceconfig.getAppointdate())) {
				if (temp2 == -1) {
					temp2 = appointserviceconfig.getAppointservicetimeid();
				}
				if (temp2 == appointserviceconfig.getAppointservicetimeid()) {
					list2.add(appointserviceconfig);
				} else {
					Appointservicetime appointservicetime = appointservicetimeMapper.selectByPrimaryKey(temp2);
					map2.put("time", appointservicetime.getTimephase());
					map2.put("teacher", list2);
					list3.add(map2);
					map2 = new HashMap<>();
					list2 = new ArrayList<>();
					temp2 = appointserviceconfig.getAppointservicetimeid();
					i--;
				}
			} else {

				Appointservicetime appointservicetime = appointservicetimeMapper.selectByPrimaryKey(temp2);
				map2.put("time", appointservicetime.getTimephase());
				map2.put("teacher", list2);
				list3.add(map2);
				map2 = new HashMap<>();
				list2 = new ArrayList<>();
				temp2 = appointserviceconfig.getAppointservicetimeid();

				map1.put("day", temp.substring(5, 10));
				map1.put("week", LiuUtils.dateToWeek(temp.substring(0, 10)));
				map1.put("data", list3);
				list1.add(map1);
				list3 = new ArrayList<>();
				map1 = new HashMap<>();
				temp2 = appointserviceconfig.getAppointservicetimeid();
				temp = appointserviceconfig.getAppointdate();
				i--;// 循环回退，重新处理此条数据
			}

		}

		// 最后数据处理
		if (temp2 > 0) {
			Appointservicetime appointservicetime = appointservicetimeMapper.selectByPrimaryKey(temp2);
			map2.put("time", appointservicetime.getTimephase());
			map2.put("teacher", list2);
			list3.add(map2);
			map1.put("day", temp.substring(5, 10));
			map1.put("week", LiuUtils.dateToWeek(temp.substring(0, 10)));
			map1.put("data", list3);
			list1.add(map1);
		}

		return Result.succee(list1);
	}

	/**
	 * 作者: cheng fei 创建日期: 2018/11/13 15:54 描述 : 检测企业账号是否拥有查询个人简历权限
	 *
	 * @param enterpriseAccountID
	 *            企业账号ID
	 * @param personAccountID
	 *            个人账号ID
	 * @return
	 * @throws MyException
	 */
	private Map<String, Boolean> checkEnterpriseSelectAuthority(Long enterpriseAccountID, Long personAccountID, boolean isTalentPool)
			throws MyException {

		Map<String, Boolean> map = new HashMap<>(2);
		map.put(DELIVER, false);
		map.put(TALENT_POOL, false);

		// 查询企业ID
		Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(enterpriseAccountID);


		if (isTalentPool){
			// 查询企业是否有人才库查询权限

			Talentpoolapplication lastDownLoadApplication = talentpoolapplicationMapper.getLastDownLoadApplication(enterpriseAccountID);
			if (lastDownLoadApplication == null) {
				map.put(TALENT_POOL, false);
			} else {
				if (lastDownLoadApplication.getApplicationservicetype() == 1 && !TALENT_POOL_OPEN.equals(lastDownLoadApplication.getIsbrowseagreement())) {
					// 人才库未开启
					map.put(TALENT_POOL, false);
				} else {
					map.put(TALENT_POOL, true);
				}
			}
		}else {
			// 查询简历投递表是存在要查询账号
			EnterpriserecruitingprocessExample example1 = new EnterpriserecruitingprocessExample();
			EnterpriserecruitingprocessExample.Criteria criteria1 = example1.createCriteria();
			criteria1.andEnterpriseidEqualTo(enterpriseID);
			criteria1.andAccountidEqualTo(personAccountID);
			int i = enterpriserecruitingprocessMapper.countByExample(example1);

			map.put(DELIVER, i >= 1);
			// 已投递的直接返回,不需要再判断人才库
			if (i >= 1) {
				return map;
			}
		}
		return map;
	}

}
