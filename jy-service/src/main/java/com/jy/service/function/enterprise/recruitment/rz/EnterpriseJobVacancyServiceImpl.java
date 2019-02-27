package com.jy.service.function.enterprise.recruitment.rz;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.LiuUtils;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.content.file.file.FileinfoMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.AccountenterpriseMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.EnterprisejobdeployapplicationMapper;
import com.jy.dao.function.enterprise.info.EnterpriseinfoMapper;
import com.jy.dao.function.enterprise.recruitment.EnterprisejobvacancyMapper;
import com.jy.dao.function.enterprise.recruitment.EnterpriserecruitingprocessMapper;
import com.jy.dao.system.dictionaries.DictionariesMapper;
import com.jy.dao.system.select.*;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.content.file.file.Fileinfo;
import com.jy.entiy.function.enterprise.enterpriseFunction.Accountenterprise;
import com.jy.entiy.function.enterprise.enterpriseFunction.Enterprisejobdeployapplication;
import com.jy.entiy.function.enterprise.info.Enterpriseinfo;
import com.jy.entiy.function.enterprise.recruitment.Enterprisejobvacancy;
import com.jy.entiy.function.enterprise.recruitment.EnterprisejobvacancyExample;
import com.jy.entiy.function.enterprise.recruitment.EnterprisejobvacancyExample.Criteria;
import com.jy.entiy.system.select.*;
import com.jy.service.function.enterprise.base.BaseEnterpriseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: EnterpriseJobVacancyServiceImpl
 * @Description:企业职位招聘服务实现类
 * @author: cheng fei
 * @date: 2018-09-05 10:55
 */

@Service
public class EnterpriseJobVacancyServiceImpl extends BaseEnterpriseService implements EnterpriseJobVacancyService {

    /**
     * 数据操作类型
     */
    private static final String DB_LOG_TYPE = "DB_LOG_ENTERPRISE_JOB_VACANCY";

    /**
     * 是否判断常量
     */
    private static final String[] FLAGS = {"N", "Y"};

    /**
     * 简历流程状态
     * 0.主动投递-待处理
     * 1.主动投递-不合适
     * 2.面试-进行中
     * 3.面试-不合适
     * 4.录用-待入职
     * 5.录用-已入职
     * 6.录用-未入职
     */
    private static final Integer[] PERSON_DELIVERY_STATUS = {1, 2, 3, 4, 5, 6, 7};

    /**
     * 审核状态
     * 0.待处理
     * 1.已处理
     * 2.已拒绝
     */
    private static final Integer[] APPLICATION_STATUS = {1, 2, 3};

    @Resource
    private AccountenterpriseMapper accountenterpriseMapper;

    @Resource
    private EnterpriseinfoMapper enterpriseinfoMapper;

    @Resource
    private EnterprisejobvacancyMapper enterprisejobvacancyMapper;

    @Resource
    private EnterprisejobdeployapplicationMapper enterprisejobdeployapplicationMapper;

    @Resource
    private EnterpriserecruitingprocessMapper enterpriserecruitingprocessMapper;

    @Resource
    private SalarytypeMapper salarytypeMapper;

    @Resource
    private AreaMapper areaMapper;

    @Resource
    private EducationbackgroundMapper educationbackgroundMapper;

    @Resource
    private JobpropertyMapper jobpropertyMapper;

    @Resource
    private JobtypeMapper jobtypeMapper;

    @Resource
    private ApplicationstatusMapper applicationstatusMapper;

    @Resource
    private FileinfoMapper fileinfoMapper;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private DictionariesMapper dictionariesMapper;


    @Override
    public Result getEnterpriseJobVacancyList(Long account_id, Integer enterprise_id, String is_open, String isAuditPassed, String search, Integer page, Integer page_size) {

        //检测参数
        if (StringUtils.isNotBlank(is_open) && !Arrays.asList(FLAGS).contains(is_open)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        if (StringUtils.isNotBlank(isAuditPassed) && !Arrays.asList(FLAGS).contains(isAuditPassed)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        //判断是通过企业ID查询还是通过当前账号查询
        if (enterprise_id == null && account_id == null) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        } else if (enterprise_id == null && account_id != null) {
            Account account = accountMapper.selectByPrimaryKey(account_id);
            Integer accountTypeEnterprise = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE);
            if (account.getDictionariesid().intValue() != accountTypeEnterprise) {
                return Result.build(ResultEnum.PARAMETER_ERROR);
            }
            Accountenterprise accountenterprise = this.getAccountenterpriseByAccountID(account_id);
            enterprise_id = accountenterprise.getEnterpriseid();
        }

        search = this.checkSearch(search);
        isAuditPassed = StringUtils.isBlank(isAuditPassed) ? null : isAuditPassed;

        // 分页开始
        PageHelper.startPage(page, page_size);
        EnterprisejobvacancyExample enterprisejobvacancyExample = new EnterprisejobvacancyExample();
        enterprisejobvacancyExample.setOrderByClause("UpdateTmie DESC");
        Criteria criteria = enterprisejobvacancyExample.createCriteria();
        criteria.andIsdeleteEqualTo("N");
        criteria.andIszhongboxingchenEqualTo("N");
        criteria.andEnterpriseidEqualTo(enterprise_id);
        if (StringUtils.isNotBlank(is_open)) {
            criteria.andIsopenEqualTo(is_open);
        }
        if (StringUtils.isNotBlank(isAuditPassed)) {
            criteria.andIsauditpassedEqualTo(isAuditPassed);
        }
        if (StringUtils.isNotBlank(search)) {
            criteria.andJobtitleLike(search);
        }

        List<Enterprisejobvacancy> list = enterprisejobvacancyMapper.selectByExample(enterprisejobvacancyExample);
        PageInfo<Enterprisejobvacancy> info = new PageInfo<>(list);
        List<Enterprisejobvacancy> data = info.getList();

        List<Integer> status = new ArrayList<>();
        for (Enterprisejobvacancy job : data) {
            //查询工作地址
            if (job.getCitycode() == null) {
                job.setCityName("");
            } else {
                String cityName = areaMapper.getNameByCode(job.getCitycode());
                job.setCityName(cityName);
            }

            //查询职位审核状态
           /* Integer applicationStatus = enterprisejobdeployapplicationMapper.getApplicationStatus(job.getEjobvacancyid());
			job.setApplicationStatus(applicationStatus);*/

            //查询薪资类型
            Salarytype salaryType = salarytypeMapper.selectByPrimaryKey(job.getSalarytypeid());
            job.setSalaryTypeName(salaryType.getSalaryname());

            //查询投递总数
            status.add(PERSON_DELIVERY_STATUS[0]);
            status.add(PERSON_DELIVERY_STATUS[1]);
            int deliverCount = enterpriserecruitingprocessMapper.getPersonDeliveryApplicationCountByPersonDeliveryStatusIDList(job.getEjobvacancyid(), status);
            job.setDeliverCount(deliverCount);

            //查询面试总数
            status.clear();
            status.add(PERSON_DELIVERY_STATUS[2]);
            status.add(PERSON_DELIVERY_STATUS[3]);
            int interviewCount = enterpriserecruitingprocessMapper.getPersonDeliveryApplicationCountByPersonDeliveryStatusIDList(job.getEjobvacancyid(), status);
            job.setInterviewCount(interviewCount);

            //查询录用总数
            status.clear();
            status.add(PERSON_DELIVERY_STATUS[4]);
            status.add(PERSON_DELIVERY_STATUS[5]);
            status.add(PERSON_DELIVERY_STATUS[6]);
            int employCount = enterpriserecruitingprocessMapper.getPersonDeliveryApplicationCountByPersonDeliveryStatusIDList(job.getEjobvacancyid(), status);
            job.setEmployCount(employCount);

            //查询入职总数
            status.clear();
            status.add(PERSON_DELIVERY_STATUS[5]);
            int entryCount = enterpriserecruitingprocessMapper.getPersonDeliveryApplicationCountByPersonDeliveryStatusIDList(job.getEjobvacancyid(), status);
            job.setEntryCount(entryCount);
        }

        long total = info.getTotal();
        Map<String, Object> map = new HashMap<>(2);
        map.put("rows", data);
        map.put("count", total);
        return Result.succee(map);
    }

    @Override
    public Result insertEnterpriseJobVacancy(AccountInfo accountInfo, Enterprisejobvacancy enterprisejobvacancy) throws MyException {

        // 检测参数格式
        if (!Arrays.asList(FLAGS).contains(enterprisejobvacancy.getIsfinalhire())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        //检测时间是否符合逻辑
        Result result = checkJObDate(enterprisejobvacancy);
        if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
            return result;
        }

        Accountenterprise accountenterprise = this.getAccountenterpriseByAccountID(accountInfo.getAccount().getAccountid());
        Enterpriseinfo enterpriseinfo = enterpriseinfoMapper.selectByPrimaryKey(accountenterprise.getEnterpriseid());

        // 补全参数
        enterprisejobvacancy.setEnterpriseid(enterpriseinfo.getEnterpriseid());
        enterprisejobvacancy.setEnterpriseName(enterpriseinfo.getEnterprisename());
        enterprisejobvacancy.setIsopen(FLAGS[1]);
        enterprisejobvacancy.setLeftpeopleno(enterprisejobvacancy.getHirepeopleno());
        enterprisejobvacancy.setIsauditpassed(FLAGS[0]);
        enterprisejobvacancy.setIsdelete(FLAGS[0]);
        enterprisejobvacancy.setIszhongboxingchen("N");
        SalarytypeExample example = new SalarytypeExample();
        com.jy.entiy.system.select.SalarytypeExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(Constant.SALARY_ON_FACE);
        List<Salarytype> list = salarytypeMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return Result.build(ResultEnum.SALARY_ON_FACE_NOT_EXIST);
        }
        Integer salary_type_id = list.get(0).getSalarytypeid();
        enterprisejobvacancy.setIssalaryonface((salary_type_id == enterprisejobvacancy.getSalarytypeid().intValue()) ? FLAGS[0] : FLAGS[1]);
        enterprisejobvacancy.setCreatepersonid(accountInfo.getAccount().getAccountid());
        enterprisejobvacancy.setCreateby(accountInfo.getAccount().getName());
        Date date = new Date();
        enterprisejobvacancy.setCreatetime(date);
        enterprisejobvacancy.setUpdatetmie(date);

        //添加到数据库
        int i = enterprisejobvacancyMapper.insertSelective(enterprisejobvacancy);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }

        //添加数据到企业职位发布申请表
        insertEnterprisejobdeployapplication(enterpriseinfo.getEnterpriseid(), enterprisejobvacancy.getEjobvacancyid(), accountInfo);

        setTypeName(enterprisejobvacancy, false);

        //添加数据库操作日志
        String log = "[ " + enterprisejobvacancy.getEnterpriseName() + " ]添加了企业职位招聘:[ ";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobtitle()) ? "" : "职位名称:" + enterprisejobvacancy.getJobtitle() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobPropertyName()) ? "" : "招聘类型:" + enterprisejobvacancy.getJobPropertyName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobTypeName()) ? "" : "工作类型:" + enterprisejobvacancy.getJobTypeName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getProvinceName()) ? "" : "省:" + enterprisejobvacancy.getProvinceName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getCityName()) ? "" : "市:" + enterprisejobvacancy.getCityName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getCountyName()) ? "" : "县:" + enterprisejobvacancy.getCountyName() + ",";
        log += enterprisejobvacancy.getHirepeopleno() == null ? "" : "招聘人数:" + enterprisejobvacancy.getHirepeopleno() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsfinalhire()) ? "" : "是否留用:" + formatFlag(enterprisejobvacancy.getIsfinalhire()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getSalaryTypeName()) ? "" : "薪资类型:" + enterprisejobvacancy.getSalaryTypeName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getSalary()) ? "" : "薪资:" + enterprisejobvacancy.getSalary() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getExpirencerequirement()) ? "" : "工作年限要求:" + enterprisejobvacancy.getExpirencerequirement() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobchineseresponsibility()) ? "" : "工作内容:" + enterprisejobvacancy.getJobchineseresponsibility() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobchineserequirement()) ? "" : "职位要求:" + enterprisejobvacancy.getJobchineserequirement() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getEducationName()) ? "" : "学历要求:" + enterprisejobvacancy.getEducationName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getWorkaddress()) ? "" : "工作地址:" + enterprisejobvacancy.getWorkaddress() + ",";
        log += enterprisejobvacancy.getRecruitexpiredate() == null ? "" : "招聘有效期:" + formatDate(enterprisejobvacancy.getRecruitexpiredate()) + ",";
        log += enterprisejobvacancy.getNextreruitdate() == null ? "" : "下期开始日期:" + formatDate(enterprisejobvacancy.getNextreruitdate()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsfinalhire()) ? "" : "是否留用:" + formatFlag(enterprisejobvacancy.getIsfinalhire()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsopen()) ? "" : "是否开启职位:" + formatFlag(enterprisejobvacancy.getIsopen()) + ",";
        log += enterprisejobvacancy.getLeftpeopleno() == null ? "" : "剩余招聘人数:" + enterprisejobvacancy.getLeftpeopleno() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsopen()) ? "" : "是否开启职位:" + formatFlag(enterprisejobvacancy.getIsopen()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsauditpassed()) ? "" : "是否通过审核:" + formatFlag(enterprisejobvacancy.getIsauditpassed()) + ",";

        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);


        return Result.succee();
    }

    @Override
    public Result updateEnterpriseJobVacancy(AccountInfo accountInfo, Enterprisejobvacancy enterprisejobvacancy) throws MyException {
        // 检测参数格式
        if (enterprisejobvacancy.getEjobvacancyid() == null) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        if (enterprisejobvacancy.getIsfinalhire() != null && !Arrays.asList(FLAGS).contains(enterprisejobvacancy.getIsfinalhire())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        if (enterprisejobvacancy.getIsopen() != null && !Arrays.asList(FLAGS).contains(enterprisejobvacancy.getIsopen())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        if (enterprisejobvacancy.getIsauditpassed() != null && !Arrays.asList(FLAGS).contains(enterprisejobvacancy.getIsauditpassed())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        if (enterprisejobvacancy.getIszhongboxingchen() != null && !Arrays.asList(FLAGS).contains(enterprisejobvacancy.getIszhongboxingchen())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        if (enterprisejobvacancy.getIsdelete() != null && !Arrays.asList(FLAGS).contains(enterprisejobvacancy.getIsdelete())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }
        if (enterprisejobvacancy.getIssalaryonface() != null && !Arrays.asList(FLAGS).contains(enterprisejobvacancy.getIssalaryonface())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        //检测时间是否符合逻辑
        Result result = checkJObDate(enterprisejobvacancy);
        if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
            return result;
        }


        Enterprisejobvacancy oldEnterpriseJobVacancy = enterprisejobvacancyMapper.selectByPrimaryKey(enterprisejobvacancy.getEjobvacancyid());

        //判断修改后和修改前是否一致
        boolean b = checkUpdateJOb(enterprisejobvacancy, oldEnterpriseJobVacancy);
        if (b) {
            return Result.succee();
        }

        String oldJObTitle = oldEnterpriseJobVacancy.getJobtitle();

        oldEnterpriseJobVacancy.setJobtitle(enterprisejobvacancy.getJobtitle());
        oldEnterpriseJobVacancy.setJobpropertyid(enterprisejobvacancy.getJobpropertyid());
        oldEnterpriseJobVacancy.setJobtypeid(enterprisejobvacancy.getJobtypeid());
        oldEnterpriseJobVacancy.setProvincecode(enterprisejobvacancy.getProvincecode());
        oldEnterpriseJobVacancy.setCitycode(enterprisejobvacancy.getCitycode());
        oldEnterpriseJobVacancy.setCountycode(enterprisejobvacancy.getCountycode());
        oldEnterpriseJobVacancy.setHirepeopleno(enterprisejobvacancy.getHirepeopleno());
        oldEnterpriseJobVacancy.setSalarytypeid(enterprisejobvacancy.getSalarytypeid());
        oldEnterpriseJobVacancy.setIsfinalhire(enterprisejobvacancy.getIsfinalhire());
        oldEnterpriseJobVacancy.setSalary(enterprisejobvacancy.getSalary());
        oldEnterpriseJobVacancy.setExpirencerequirement(enterprisejobvacancy.getExpirencerequirement());
        oldEnterpriseJobVacancy.setJobchineseresponsibility(enterprisejobvacancy.getJobchineseresponsibility());
        oldEnterpriseJobVacancy.setJobchineserequirement(enterprisejobvacancy.getJobchineserequirement());
        oldEnterpriseJobVacancy.setEducationid(enterprisejobvacancy.getEducationid());
        oldEnterpriseJobVacancy.setWorkaddress(enterprisejobvacancy.getWorkaddress());
        oldEnterpriseJobVacancy.setRecruitexpiredate(enterprisejobvacancy.getRecruitexpiredate());
        oldEnterpriseJobVacancy.setNextreruitdate(enterprisejobvacancy.getNextreruitdate());

        //补全参数
        oldEnterpriseJobVacancy.setIsauditpassed("N");
        oldEnterpriseJobVacancy.setUpdatepersonid(accountInfo.getAccount().getAccountid());
        oldEnterpriseJobVacancy.setUpdateby(accountInfo.getAccount().getName());
        oldEnterpriseJobVacancy.setUpdatetmie(new Date());

        //添加到数据库
        int i = enterprisejobvacancyMapper.updateByPrimaryKey(oldEnterpriseJobVacancy);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }

        Accountenterprise accountenterprise = this.getAccountenterpriseByAccountID(accountInfo.getAccount().getAccountid());
        Enterpriseinfo enterpriseinfo = enterpriseinfoMapper.selectByPrimaryKey(accountenterprise.getEnterpriseid());

        //添加企业岗位发布审核审核记录
        insertEnterprisejobdeployapplication(enterpriseinfo.getEnterpriseid(), oldEnterpriseJobVacancy.getEjobvacancyid(), accountInfo);

        setTypeName(enterprisejobvacancy, false);
        //添加数据库操作日志
        String log = "[ " + enterprisejobvacancy.getEnterpriseName() + " ]修改[ " + oldJObTitle + " ]职位招聘:[ ";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobtitle()) ? "" : "职位名称:" + enterprisejobvacancy.getJobtitle() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobPropertyName()) ? "" : "招聘类型:" + enterprisejobvacancy.getJobPropertyName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobTypeName()) ? "" : "工作类型:" + enterprisejobvacancy.getJobTypeName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getProvinceName()) ? "" : "省:" + enterprisejobvacancy.getProvinceName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getCityName()) ? "" : "市:" + enterprisejobvacancy.getCityName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getCountyName()) ? "" : "县:" + enterprisejobvacancy.getCountyName() + ",";
        log += enterprisejobvacancy.getHirepeopleno() == null ? "" : "招聘人数:" + enterprisejobvacancy.getHirepeopleno() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsfinalhire()) ? "" : "是否留用:" + formatFlag(enterprisejobvacancy.getIsfinalhire()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getSalaryTypeName()) ? "" : "薪资类型:" + enterprisejobvacancy.getSalaryTypeName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getSalary()) ? "" : "薪资:" + enterprisejobvacancy.getSalary() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getExpirencerequirement()) ? "" : "工作年限要求:" + enterprisejobvacancy.getExpirencerequirement() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobchineseresponsibility()) ? "" : "工作内容:" + enterprisejobvacancy.getJobchineseresponsibility() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getJobchineserequirement()) ? "" : "职位要求:" + enterprisejobvacancy.getJobchineserequirement() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getEducationName()) ? "" : "学历要求:" + enterprisejobvacancy.getEducationName() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getWorkaddress()) ? "" : "工作地址:" + enterprisejobvacancy.getWorkaddress() + ",";
        log += enterprisejobvacancy.getRecruitexpiredate() == null ? "" : "招聘有效期:" + formatDate(enterprisejobvacancy.getRecruitexpiredate()) + ",";
        log += enterprisejobvacancy.getNextreruitdate() == null ? "" : "下期开始日期:" + formatDate(enterprisejobvacancy.getNextreruitdate()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsfinalhire()) ? "" : "是否留用:" + formatFlag(enterprisejobvacancy.getIsfinalhire()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsopen()) ? "" : "是否开启职位:" + formatFlag(enterprisejobvacancy.getIsopen()) + ",";
        log += enterprisejobvacancy.getLeftpeopleno() == null ? "" : "剩余招聘人数:" + enterprisejobvacancy.getLeftpeopleno() + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsopen()) ? "" : "是否开启职位:" + formatFlag(enterprisejobvacancy.getIsopen()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsauditpassed()) ? "" : "是否通过审核:" + formatFlag(enterprisejobvacancy.getIsauditpassed()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getAuditor()) ? "" : "审核人员:" + formatFlag(enterprisejobvacancy.getIsauditpassed()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIszhongboxingchen()) ? "" : "是否是中博星辰职位:" + formatFlag(enterprisejobvacancy.getIszhongboxingchen()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIsdelete()) ? "" : "是否已删除:" + formatFlag(enterprisejobvacancy.getIsdelete()) + ",";
        log += StringUtils.isBlank(enterprisejobvacancy.getIssalaryonface()) ? "" : "薪资是否需要面谈:" + formatFlag(enterprisejobvacancy.getIssalaryonface()) + ",";

        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
        return Result.succee();
    }

    @Override
    public Result getEnterpriseJobVacancy(Integer enterprise_job_vacancy_id) {

        EnterprisejobvacancyExample example = new EnterprisejobvacancyExample();
        Criteria criteria = example.createCriteria();
        criteria.andEjobvacancyidEqualTo(enterprise_job_vacancy_id);
        List<Enterprisejobvacancy> list = enterprisejobvacancyMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            Enterprisejobvacancy ejv = list.get(0);
            setTypeName(ejv, true);
            aliyunOSSClientUtil.closeOSSClient();
            return Result.succee(ejv);
        }
        return Result.succee();
    }


    @Override
    public Result getEnterpriseJobVacancySelect(AccountInfo accountInfo, String search, String isOpen, String isAuditPassed) {

        //检测参数

        if (StringUtils.isBlank(isOpen)) {
            isOpen = null;
        } else if (!Arrays.asList(FLAGS).contains(isOpen)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        if (StringUtils.isBlank(isAuditPassed)) {
            isAuditPassed = null;
        } else if (!Arrays.asList(FLAGS).contains(isAuditPassed)) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        search = this.checkSearch(search);

        Accountenterprise accountenterprise = this.getAccountenterpriseByAccountID(accountInfo.getAccount().getAccountid());
        List<SelectResult> list = enterprisejobvacancyMapper.getEnterpriseJobVacancySelect(accountenterprise.getEnterpriseid(), search, isOpen, isAuditPassed);
        SelectResult selectResult = new SelectResult();
        selectResult.setId(0);
        selectResult.setName("全部职位");
        list.add(0, selectResult);
        return Result.succee(list);
    }

    @Override
    public Result getEnterpriseJobVacancyListAll(AccountInfo accountInfo, String search, Integer page, Integer page_size) {

        search = checkSearch(search);

        PageHelper.startPage(page, page_size);
        List<Enterprisejobvacancy> list = enterprisejobvacancyMapper.getEnterpriseJobVacancyListAll(search);
        PageInfo<Enterprisejobvacancy> info = new PageInfo<>(list);

        List<Enterprisejobvacancy> data = info.getList();
        //对查询结果进行处理
        for (Enterprisejobvacancy ejv : data) {
            setTypeName(ejv, true);
        }
        aliyunOSSClientUtil.closeOSSClient();

        Map<String, Object> map = new HashMap<>();
        map.put("rows", data);
        map.put("count", info.getTotal());

        return Result.succee(map);
    }

    @Override
    public Result getCount(AccountInfo accountInfo) {
        Integer accountTypeEnterprise = dictionariesMapper.getDictionariesIDByCode(Constant.ACCOUNT_TYPE_ENTERPRISE);

        if (accountInfo.getAccount().getDictionariesid().intValue() != accountTypeEnterprise) {
            return Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());

        //查询开启职位总数
        EnterprisejobvacancyExample example = new EnterprisejobvacancyExample();
        Criteria criteria = example.createCriteria();
        criteria.andEnterpriseidEqualTo(enterpriseID);
        criteria.andIsopenEqualTo(FLAGS[1]);
        criteria.andIsdeleteEqualTo(FLAGS[0]);
        criteria.andIszhongboxingchenEqualTo(FLAGS[0]);
        int open = enterprisejobvacancyMapper.countByExample(example);

        //查询关闭职位总数
        EnterprisejobvacancyExample example2 = new EnterprisejobvacancyExample();
        Criteria criteria2 = example2.createCriteria();
        criteria2.andEnterpriseidEqualTo(enterpriseID);
        criteria2.andIsopenEqualTo(FLAGS[0]);
        criteria2.andIsdeleteEqualTo(FLAGS[0]);
        criteria2.andIszhongboxingchenEqualTo(FLAGS[0]);
        int close = enterprisejobvacancyMapper.countByExample(example2);
        Map<String, Integer> map = new HashMap<>();
        map.put("open", open);
        map.put("close", close);
        return Result.succee(map);
    }

    @Override
    public Result updateEnterpriseJobVacancyOpenOrClose(AccountInfo accountInfo, String jobIDS, String Status) throws MyException {

        if (!checkIsEnterpriseAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.LOGIN_UNAUTHORIZED);
        }

        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());
        //是否是开启岗位
        boolean isOpen = "Y".equals(Status);
        String[] split = jobIDS.split(",");
        for (String jobIDStr : split) {

            //判断参数
            if (!StringUtils.isNumeric(jobIDStr)) {
                return Result.build(ResultEnum.PARAMETER_ERROR);
            } else {
                //修改状态
                Enterprisejobvacancy enterprisejobvacancy = new Enterprisejobvacancy();
                enterprisejobvacancy.setEnterpriseid(enterpriseID);
                enterprisejobvacancy.setEjobvacancyid(Integer.parseInt(jobIDStr));
                enterprisejobvacancy.setIsopen(Status);
                if (isOpen){
                    enterprisejobvacancy.setIsauditpassed("N");
                }
                enterprisejobvacancy.setUpdateby(accountInfo.getAccount().getName());
                enterprisejobvacancy.setUpdatepersonid(accountInfo.getAccount().getAccountid());
                enterprisejobvacancy.setUpdatetmie(new Date());
                EnterprisejobvacancyExample example = new EnterprisejobvacancyExample();
                Criteria criteria = example.createCriteria();
                criteria.andEjobvacancyidEqualTo(Integer.parseInt(jobIDStr));
                criteria.andEnterpriseidEqualTo(enterpriseID);
                int i = enterprisejobvacancyMapper.updateByExampleSelective(enterprisejobvacancy, example);
                if (i < 1) {
                    throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
                }

                //开启岗位
                if (isOpen) {
                    //添加企业岗位发布审核
                    insertEnterprisejobdeployapplication(enterpriseID, Integer.parseInt(jobIDStr), accountInfo);
                }
            }

            //数据库操作日志
            String log = "[ " + enterpriseinfoMapper.getEnterpriseNameByAccountID(accountInfo.getAccount().getAccountid()) + " ]企业关闭了职位[ " + enterprisejobvacancyMapper.getJobNameByJObID(Integer.parseInt(jobIDStr)) + " ]";
            this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        }

        return Result.succee();
    }

    @Override
    public Result updateEnterpriseJobVacancyDelete(AccountInfo
                                                           accountInfo, String jobIDS) throws MyException {

        if (!checkIsEnterpriseAccount(accountInfo.getAccount())) {
            return Result.build(ResultEnum.LOGIN_UNAUTHORIZED);
        }

        Integer enterpriseID = accountenterpriseMapper.getEnterpriseIDByAccountID(accountInfo.getAccount().getAccountid());

        String[] split = jobIDS.split(",");
        for (String jobIDStr : split) {

            //判断参数
            if (!StringUtils.isNumeric(jobIDStr)) {
                return Result.build(ResultEnum.PARAMETER_ERROR);
            } else {
                //修改状态
                Enterprisejobvacancy enterprisejobvacancy = new Enterprisejobvacancy();
                enterprisejobvacancy.setEnterpriseid(enterpriseID);
                enterprisejobvacancy.setEjobvacancyid(Integer.parseInt(jobIDStr));
                enterprisejobvacancy.setIsdelete(FLAGS[1]);

                enterprisejobvacancy.setUpdateby(accountInfo.getAccount().getName());
                enterprisejobvacancy.setUpdatepersonid(accountInfo.getAccount().getAccountid());
                enterprisejobvacancy.setUpdatetmie(new Date());

                EnterprisejobvacancyExample example = new EnterprisejobvacancyExample();
                Criteria criteria = example.createCriteria();
                criteria.andEjobvacancyidEqualTo(Integer.parseInt(jobIDStr));
                criteria.andEnterpriseidEqualTo(enterpriseID);
                int i = enterprisejobvacancyMapper.updateByExampleSelective(enterprisejobvacancy, example);
                if (i < 1) {
                    throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
                }
            }

            //数据库操作日志
            String log = "[ " + enterpriseinfoMapper.getEnterpriseNameByAccountID(accountInfo.getAccount().getAccountid()) + " ]企业删除了职位[ " + enterprisejobvacancyMapper.getJobNameByJObID(Integer.parseInt(jobIDStr)) + " ]";
            this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);
        }

        return Result.succee();
    }

    @Override
    public Result getCountByEnterpriseID(Integer enterpriseID) {

        EnterprisejobvacancyExample example = new EnterprisejobvacancyExample();
        Criteria criteria = example.createCriteria();
        criteria.andIszhongboxingchenEqualTo("N");
        criteria.andIsdeleteEqualTo("N");
        criteria.andIsopenEqualTo("Y");
        criteria.andIsauditpassedEqualTo("Y");
        criteria.andEnterpriseidEqualTo(enterpriseID);
        int count = enterprisejobvacancyMapper.countByExample(example);
        return Result.succee(count);
    }


    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/7 10:52
     * 描述 : 添加数据到企业职位发布申请表
     *
     * @param enterpriseID
     * @param jobID
     * @param accountInfo
     * @throws MyException
     */
    private void insertEnterprisejobdeployapplication(Integer enterpriseID, Integer jobID, AccountInfo accountInfo) throws
            MyException {
        //插入数据到企业职位发布申请表
        Enterprisejobdeployapplication enterprisejobdeployapplication = new Enterprisejobdeployapplication();

        enterprisejobdeployapplication.setApplicationstatusid(APPLICATION_STATUS[0]);
        enterprisejobdeployapplication.setApplicationtime(new Date());
        enterprisejobdeployapplication.setEnterpriseid(enterpriseID);
        enterprisejobdeployapplication.setEjobvacancyid(jobID);
        enterprisejobdeployapplication.setServiceno(LiuUtils.getServeIdByUUId());

        enterprisejobdeployapplication.setCreateby(accountInfo.getAccount().getName());
        enterprisejobdeployapplication.setCreatepersonid(accountInfo.getAccount().getAccountid());
        enterprisejobdeployapplication.setCreatetime(new Date());
        int i = enterprisejobdeployapplicationMapper.insertSelective(enterprisejobdeployapplication);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }
    }


    /**
     * 设置配置表信息
     *
     * @param ejv
     * @param set_enterprise 是否设置企业信息
     */
    private void setTypeName(Enterprisejobvacancy ejv, boolean set_enterprise) {
        if (set_enterprise) {
            Enterpriseinfo enterpriseinfo = enterpriseinfoMapper.selectByPrimaryKey(ejv.getEnterpriseid());
            ejv.setEnterpriseName(enterpriseinfo.getEnterprisename());
            Fileinfo fileinfo = fileinfoMapper.selectByPrimaryKey(enterpriseinfo.getLogofileid());
            if (fileinfo != null && StringUtils.isNotBlank(fileinfo.getFilefullpath())) {
                ejv.setEnterpriseLogo(aliyunOSSClientUtil.getUrl(fileinfo.getFilefullpath()));
            }
        }
        if (ejv.getSalarytypeid() != null) {
            Salarytype salarytype = salarytypeMapper.selectByPrimaryKey(ejv.getSalarytypeid());
            ejv.setSalaryTypeName(salarytype == null ? null : salarytype.getSalaryname());
        }
        if (StringUtils.isNotBlank(ejv.getProvincecode())) {
            ejv.setProvinceName(areaMapper.getNameByCode(ejv.getProvincecode()));
        }
        if (StringUtils.isNotBlank(ejv.getCitycode())) {
            ejv.setCityName(areaMapper.getNameByCode(ejv.getCitycode()));
        }
        if (StringUtils.isNotBlank(ejv.getCountycode())) {
            ejv.setCountyName(areaMapper.getNameByCode(ejv.getCountycode()));
        }
        if (ejv.getJobpropertyid() != null) {
            Jobproperty jobproperty = jobpropertyMapper.selectByPrimaryKey(ejv.getJobpropertyid());
            ejv.setJobPropertyName(jobproperty == null ? null : jobproperty.getJobpropertyname());
        }
        if (ejv.getJobtypeid() != null) {
            Jobtype jobtype = jobtypeMapper.selectByPrimaryKey(ejv.getJobtypeid());
            ejv.setJobTypeName(jobtype == null ? null : jobtype.getJobtypename());
        }
        if (ejv.getEducationid() != null) {
            Educationbackground education = educationbackgroundMapper.selectByPrimaryKey(ejv.getEducationid());
            ejv.setEducationName(education == null ? null : education.getEducationlevel());
        }
    }

    /**
     * 格式化数据
     *
     * @param data
     * @return
     */
    private String formatFlag(String data) {
        if (Arrays.asList(FLAGS).contains(data)) {
            return FLAGS[1].equals(data) ? "是" : "否";
        }
        return null;
    }


    /**
     * 格式化时间
     *
     * @return
     */
    protected String formatDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = format.parse(date);
            String time = format.format(date1.getTime());
            return time;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 格式化时间
     *
     * @return
     */
    protected String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date.getTime());
        return time;
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/12/1 15:01
     * 描述 : 检测发布工作的日期是否正常
     *
     * @param ejv
     * @return
     */
    private Result checkJObDate(Enterprisejobvacancy ejv) {
        Date now = new Date();
        if (now.getTime() > ejv.getRecruitexpiredate().getTime()) {
            return Result.build(ResultEnum.RECRUIT_EXPIRE_DATE_ERROR);
        } else if (ejv.getNextreruitdate() != null && ejv.getRecruitexpiredate().getTime() > ejv.getNextreruitdate().getTime()) {
            return Result.build(ResultEnum.NEXT_RERUIT_DATE_ERROR);
        } else {
            return Result.succee();
        }
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2019/1/7 10:14
     * 描述 : 判断修改职位前后是否一致
     *
     * @param newEnterpriseJobVacancy
     * @param oldEnterpriseJobVacancy
     * @return
     */
    private boolean checkUpdateJOb(Enterprisejobvacancy newEnterpriseJobVacancy, Enterprisejobvacancy oldEnterpriseJobVacancy) {
        if ((newEnterpriseJobVacancy.getJobtitle() != null && oldEnterpriseJobVacancy.getJobtitle() != null)
                || (newEnterpriseJobVacancy.getJobtitle() == null && oldEnterpriseJobVacancy.getJobtitle() == null)) {
            if (newEnterpriseJobVacancy.getJobtitle() != null) {
                if (!newEnterpriseJobVacancy.getJobtitle().equals(oldEnterpriseJobVacancy.getJobtitle())) {
                    return false;
                }
            }
        }
        else {
            return false;
        }

        if ((newEnterpriseJobVacancy.getJobpropertyid() != null && oldEnterpriseJobVacancy.getJobpropertyid() != null)
                || (newEnterpriseJobVacancy.getJobpropertyid() == null && oldEnterpriseJobVacancy.getJobpropertyid() == null)) {
            if (newEnterpriseJobVacancy.getJobpropertyid() != null) {
                if (newEnterpriseJobVacancy.getJobpropertyid().intValue() != oldEnterpriseJobVacancy.getJobpropertyid()) {
                    return false;
                }
            }
        }else {
            return false;
        }

        if ((newEnterpriseJobVacancy.getJobtypeid() != null && oldEnterpriseJobVacancy.getJobtypeid() != null)
                || (newEnterpriseJobVacancy.getJobtypeid() == null && oldEnterpriseJobVacancy.getJobtypeid() == null)) {
            if (newEnterpriseJobVacancy.getJobtypeid() != null) {
                if (newEnterpriseJobVacancy.getJobtypeid().intValue() != oldEnterpriseJobVacancy.getJobtypeid()) {
                    return false;
                }
            }
        }else {
            return false;
        }

        if ((newEnterpriseJobVacancy.getProvincecode() != null && oldEnterpriseJobVacancy.getProvincecode() != null)
                || (newEnterpriseJobVacancy.getProvincecode() == null && oldEnterpriseJobVacancy.getProvincecode() == null)) {
            if (newEnterpriseJobVacancy.getProvincecode() != null) {
                if (!newEnterpriseJobVacancy.getProvincecode().equals(oldEnterpriseJobVacancy.getProvincecode())) {
                    return false;
                }
            }
        }else {
            return false;
        }

        if ((newEnterpriseJobVacancy.getCitycode() != null && oldEnterpriseJobVacancy.getCitycode() != null)
                || (newEnterpriseJobVacancy.getCitycode() == null && oldEnterpriseJobVacancy.getCitycode() == null)) {
            if (newEnterpriseJobVacancy.getCitycode() != null) {
                if (!newEnterpriseJobVacancy.getCitycode().equals(oldEnterpriseJobVacancy.getCitycode())) {
                    return false;
                }
            }
        }else {
            return false;
        }

        if ((newEnterpriseJobVacancy.getCountycode() != null && oldEnterpriseJobVacancy.getCountycode() != null)
                || (newEnterpriseJobVacancy.getCountycode() == null && oldEnterpriseJobVacancy.getCountycode() == null)) {
            if (newEnterpriseJobVacancy.getCountycode() != null) {
                if (!newEnterpriseJobVacancy.getCountycode().equals(oldEnterpriseJobVacancy.getCountycode())) {
                    return false;
                }
            }
        }else {
            return false;
        }

        if ((newEnterpriseJobVacancy.getHirepeopleno() != null && oldEnterpriseJobVacancy.getHirepeopleno() != null)
                || (newEnterpriseJobVacancy.getHirepeopleno() == null && oldEnterpriseJobVacancy.getHirepeopleno() == null)) {
            if (newEnterpriseJobVacancy.getHirepeopleno() != null) {
                if (newEnterpriseJobVacancy.getHirepeopleno().intValue() != oldEnterpriseJobVacancy.getHirepeopleno()) {
                    return false;
                }
            }
        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getIsfinalhire() != null && oldEnterpriseJobVacancy.getIsfinalhire() != null)
                || (newEnterpriseJobVacancy.getIsfinalhire() == null && oldEnterpriseJobVacancy.getIsfinalhire() == null)) {
            if (newEnterpriseJobVacancy.getIsfinalhire() != null) {
                if (!newEnterpriseJobVacancy.getIsfinalhire().equals(oldEnterpriseJobVacancy.getIsfinalhire())) {
                    return false;
                }
            }
        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getSalarytypeid() != null && oldEnterpriseJobVacancy.getSalarytypeid() != null)
                || (newEnterpriseJobVacancy.getSalarytypeid() == null && oldEnterpriseJobVacancy.getSalarytypeid() == null)) {
            if (newEnterpriseJobVacancy.getSalarytypeid() != null) {
                if (newEnterpriseJobVacancy.getSalarytypeid().intValue() != oldEnterpriseJobVacancy.getSalarytypeid()) {
                    return false;
                }
            }
        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getSalary() != null && oldEnterpriseJobVacancy.getSalary() != null)
                || (newEnterpriseJobVacancy.getSalary() == null && oldEnterpriseJobVacancy.getSalary() == null)) {
            if (newEnterpriseJobVacancy.getSalary() != null) {
                if (!newEnterpriseJobVacancy.getSalary().equals(oldEnterpriseJobVacancy.getSalary())) {
                    return false;
                }
            }
        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getExpirencerequirement() != null && oldEnterpriseJobVacancy.getExpirencerequirement() != null)
                || (newEnterpriseJobVacancy.getExpirencerequirement() == null && oldEnterpriseJobVacancy.getExpirencerequirement() == null)) {
            if (newEnterpriseJobVacancy.getExpirencerequirement() != null) {
                if (!newEnterpriseJobVacancy.getExpirencerequirement().equals(oldEnterpriseJobVacancy.getExpirencerequirement())) {
                    return false;
                }
            }
        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getJobchineseresponsibility() != null && oldEnterpriseJobVacancy.getJobchineseresponsibility() != null)
                || (newEnterpriseJobVacancy.getJobchineseresponsibility() == null && oldEnterpriseJobVacancy.getJobchineseresponsibility() == null)) {
            if (newEnterpriseJobVacancy.getJobchineseresponsibility() != null) {
                if (!newEnterpriseJobVacancy.getJobchineseresponsibility().equals(oldEnterpriseJobVacancy.getJobchineseresponsibility())) {
                    return false;
                }
            }
        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getJobchineserequirement() != null && oldEnterpriseJobVacancy.getJobchineserequirement() != null)
                || (newEnterpriseJobVacancy.getJobchineserequirement() == null && oldEnterpriseJobVacancy.getJobchineserequirement() == null)) {
            if (newEnterpriseJobVacancy.getJobchineserequirement() != null) {
                if (!newEnterpriseJobVacancy.getJobchineserequirement().equals(oldEnterpriseJobVacancy.getJobchineserequirement())) {
                    return false;
                }
            }
        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getEducationid() != null && oldEnterpriseJobVacancy.getEducationid() != null)
                || (newEnterpriseJobVacancy.getEducationid() == null && oldEnterpriseJobVacancy.getEducationid() == null)) {
            if (newEnterpriseJobVacancy.getEducationid() != null) {
                if (newEnterpriseJobVacancy.getEducationid().intValue() != oldEnterpriseJobVacancy.getEducationid()) {
                    return false;
                }
            }
        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getWorkaddress() != null && oldEnterpriseJobVacancy.getWorkaddress() != null)
                || (newEnterpriseJobVacancy.getWorkaddress() == null && oldEnterpriseJobVacancy.getWorkaddress() == null)) {
            if (newEnterpriseJobVacancy.getWorkaddress() != null) {
                if (!newEnterpriseJobVacancy.getWorkaddress().equals(oldEnterpriseJobVacancy.getWorkaddress())) {
                    return false;
                }
            }
        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getRecruitexpiredate() != null && oldEnterpriseJobVacancy.getRecruitexpiredate() != null)
                || (newEnterpriseJobVacancy.getRecruitexpiredate() == null && oldEnterpriseJobVacancy.getRecruitexpiredate() == null)) {
            if (newEnterpriseJobVacancy.getRecruitexpiredate() != null) {
                if (newEnterpriseJobVacancy.getRecruitexpiredate().getTime() != oldEnterpriseJobVacancy.getRecruitexpiredate().getTime()) {
                    return false;
                }
            }

        }else {
            return false;
        }
        if ((newEnterpriseJobVacancy.getNextreruitdate() != null && oldEnterpriseJobVacancy.getNextreruitdate() != null)
                || (newEnterpriseJobVacancy.getNextreruitdate() == null && oldEnterpriseJobVacancy.getNextreruitdate() == null)) {
            if (newEnterpriseJobVacancy.getNextreruitdate() != null) {
                if (newEnterpriseJobVacancy.getNextreruitdate().getTime() != oldEnterpriseJobVacancy.getNextreruitdate().getTime()) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

}
