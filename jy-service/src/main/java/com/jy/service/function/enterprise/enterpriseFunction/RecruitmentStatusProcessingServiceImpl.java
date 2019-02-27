package com.jy.service.function.enterprise.enterpriseFunction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.common.utils.DateUtils;
import com.jy.dao.function.enterprise.enterpriseFunction.PersonrecruitingprocessMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.RecommendsuccessnoMapper;
import com.jy.dao.function.enterprise.recruitment.EnterpriserecruitingprocessMapper;
import com.jy.dao.function.person.PersondeliveryapplicationMapper;
import com.jy.dao.function.person.RecruitmentprocesslogMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.enterpriseFunction.Personrecruitingprocess;
import com.jy.entiy.function.enterprise.enterpriseFunction.Recommendsuccessno;
import com.jy.entiy.function.enterprise.enterpriseFunction.RecommendsuccessnoExample;
import com.jy.entiy.function.enterprise.recruitment.Enterpriserecruitingprocess;
import com.jy.entiy.function.enterprise.recruitment.EnterpriserecruitingprocessExample;
import com.jy.entiy.function.person.Persondeliveryapplication;
import com.jy.entiy.function.person.PersondeliveryapplicationExample;
import com.jy.entiy.function.person.Recruitmentprocesslog;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName: RecruitmentStatusProcessingServiceImpl
 * @Description:招聘状态处理实现类
 * @author: chenye
 * @date: 2018-09-06 20:20
 */
@Service
public class RecruitmentStatusProcessingServiceImpl extends BaseService implements RecruitmentStatusProcessingService {

    /**
     * 审核处理状态
     * 0.待处理
     * 1.已同意
     * 2.已拒绝
     */
    private static final Integer[] APPLICATION_STATUS = {1, 2, 3};

    /**
     * 简历投递成功状态
     */
    private static final Integer DELIVERY_SUCCESS = 1;

    /**
     * 邀请面试
     */
    private static final Integer INTERVIEW_SUCCESS = 3;

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

    @Resource
    private PersonrecruitingprocessMapper personrecruitingprocessMapper;

    @Resource
    private EnterpriserecruitingprocessMapper enterpriserecruitingprocessMapper;

    @Resource
    private PersondeliveryapplicationMapper persondeliveryapplicationMapper;

    @Resource
    private RecruitmentprocesslogMapper recruitmentprocesslogMapper;

    @Resource
    private RecommendsuccessnoMapper recommendsuccessnoMapper;

    @Override
    public Result updateProcessingRecruitmentStatus(AccountInfo accountInfo, String AUTHORITY_CODE, String ids, Integer applicationStatus, String interviewDate) throws MyException {
        // 检测权限
        Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
        if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
            return checkAuthority;
        }

        //检测参数
        if (!Arrays.asList(APPLICATION_STATUS).contains(applicationStatus.intValue()) || applicationStatus == 1) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        String[] split = ids.split(",");
        for (String id_str : split) {
            if (!StringUtils.isNumeric(id_str)) {
                return Result.build(ResultEnum.PARAMETER_ERROR);
            }

            Personrecruitingprocess personrecruitingprocess = personrecruitingprocessMapper.selectByPrimaryKey(Long.parseLong(id_str));
            if (personrecruitingprocess.getApplicationstatusid().intValue() != APPLICATION_STATUS[0]) {
                //已处理和已拒绝的跳过
                continue;
            } else {
                Result result = updateApplicationStatus(personrecruitingprocess, accountInfo, Long.parseLong(id_str), applicationStatus, interviewDate);
                if (result.getStatus().intValue() != ResultEnum.SUCCESS.getStatus()) {
                    return result;
                }
            }
        }
        return Result.succee();
    }

    @Override
    public Result getJobApplicationList(Integer applicationStatus, Integer personDeliveryStatus, String applicationTime, String search, Integer page, Integer pageSize) throws MyException {

        //检测参数
        if (applicationStatus != 0 && !Arrays.asList(APPLICATION_STATUS).contains(applicationStatus.intValue())) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        if (personDeliveryStatus != 0 && !Arrays.asList(PERSON_DELIVERY_STATUS).contains(personDeliveryStatus.intValue()) && personDeliveryStatus <= 5) {
            return Result.build(ResultEnum.PARAMETER_ERROR);
        }

        // 处理参数
        search = this.checkSearch(search);
        applicationTime = this.checkSearchTime(applicationTime);
        if (StringUtils.isNotBlank(applicationTime)) {
            applicationTime = "%" + applicationTime + "%";
        }

        PageHelper.startPage(page, pageSize);

        List<Map<String, Object>> list = personrecruitingprocessMapper.getJobApplicationList(applicationStatus, personDeliveryStatus, applicationTime, search);

        PageInfo<Map<String, Object>> info = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();
        map.put("rows", info.getList());
        map.put("count", info.getTotal());
        return Result.succee(map);
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/8 23:10
     * 描述 : 修改招聘流程状态审核表
     *
     * @param id                招聘流程审核申请表主键
     * @param applicationStatus 审核状态
     */
    private Result updateApplicationStatus(Personrecruitingprocess personrecruitingprocess, AccountInfo accountInfo, Long id, int applicationStatus, String interviewDate) throws MyException {

        Date date = new Date();
        //修改审核表
        personrecruitingprocess.setApplicationstatusid(applicationStatus);
        personrecruitingprocess.setHandletime(date);

        //审核面试时,添加面试时间
        if (personrecruitingprocess.getPdeliverystatusid().intValue() == INTERVIEW_SUCCESS) {
            try {
                if (StringUtils.isNotBlank(interviewDate)) {
                    personrecruitingprocess.setInterviewdate(DateUtils.dateParse(interviewDate, DateUtils.MINUTE_PATTERN));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return Result.build(ResultEnum.PARAMETER_ERROR);
            }
        }

        int i = personrecruitingprocessMapper.updateByPrimaryKey(personrecruitingprocess);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }

        if (APPLICATION_STATUS[1] == applicationStatus) {
            //审核通过
            //同步至企业招聘流程表
            EnterpriserecruitingprocessExample example = new EnterpriserecruitingprocessExample();
            EnterpriserecruitingprocessExample.Criteria criteria = example.createCriteria();
            criteria.andAccountidEqualTo(personrecruitingprocess.getAccountid());
            criteria.andEjobvacancyidEqualTo(personrecruitingprocess.getEjobvacancyid());
            List<Enterpriserecruitingprocess> list = enterpriserecruitingprocessMapper.selectByExample(example);

            if (list == null || list.size() == 0) {
                throw new MyException(ResultEnum.DB_ERROR);
            }

            Enterpriserecruitingprocess enterpriserecruitingprocess = list.get(0);
            enterpriserecruitingprocess.setApplicationstatusid(personrecruitingprocess.getApplicationstatusid());
            enterpriserecruitingprocess.setHandletime(date);
            enterpriserecruitingprocess.setPdeliverystatusid(personrecruitingprocess.getPdeliverystatusid());
            enterpriserecruitingprocess.setInterviewdate(personrecruitingprocess.getInterviewdate());
            enterpriserecruitingprocess.setServiceno(personrecruitingprocess.getServiceno());

            i = enterpriserecruitingprocessMapper.updateByExample(enterpriserecruitingprocess, example);
            if (i < 1) {
                throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
            }

            //同步到个人简历投递申请表
            updatePersonDeliveryApplication(personrecruitingprocess);

            //插入招聘流程日志表
            insertRecruitmentProcessLog(personrecruitingprocess, accountInfo);

            //判断是否是录用申请,是录用申请,修改推荐成功次数
            if (personrecruitingprocess.getPdeliverystatusid().intValue() == PERSON_DELIVERY_STATUS[4]) {
                updateRecommendSuccessNo(personrecruitingprocess);
            }
        } else if (APPLICATION_STATUS[2] == applicationStatus) {
            //审核不通过
            // 查询申请审核前记录
            Recruitmentprocesslog oldRecruitmentProcessLog = recruitmentprocesslogMapper.selectLastLog(personrecruitingprocess.getAccountid(), personrecruitingprocess.getEjobvacancyid(), 2);

            //插入招聘流程日志表
            insertRecruitmentProcessLog(personrecruitingprocess, accountInfo);


            //企业招聘流程表回滚
            EnterpriserecruitingprocessExample example = new EnterpriserecruitingprocessExample();
            EnterpriserecruitingprocessExample.Criteria criteria = example.createCriteria();
            criteria.andAccountidEqualTo(personrecruitingprocess.getAccountid());
            criteria.andEjobvacancyidEqualTo(personrecruitingprocess.getEjobvacancyid());
            List<Enterpriserecruitingprocess> list = enterpriserecruitingprocessMapper.selectByExample(example);

            if (list == null || list.size() == 0) {
                throw new MyException(ResultEnum.DB_ERROR);
            }

            Enterpriserecruitingprocess enterpriserecruitingprocess = list.get(0);
            enterpriserecruitingprocess.setApplicationstatusid(oldRecruitmentProcessLog.getApplicationstatusid());
            enterpriserecruitingprocess.setHandletime(date);
            enterpriserecruitingprocess.setPdeliverystatusid(oldRecruitmentProcessLog.getPdeliverystatusid());
            enterpriserecruitingprocess.setServiceno(personrecruitingprocess.getServiceno());

            i = enterpriserecruitingprocessMapper.updateByExample(enterpriserecruitingprocess, example);
            if (i < 1) {
                throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
            }
        }

        return Result.succee();
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/10 15:46
     * 描述 : 修改当前人员的推荐成功次数
     *
     * @param personrecruitingprocess
     */
    private void updateRecommendSuccessNo(Personrecruitingprocess personrecruitingprocess) throws MyException {
        //查询推荐成功数据表是否有当前人员数据
        RecommendsuccessnoExample example = new RecommendsuccessnoExample();
        RecommendsuccessnoExample.Criteria criteria = example.createCriteria();
        criteria.andAccountidEqualTo(personrecruitingprocess.getAccountid());
        List<Recommendsuccessno> list = recommendsuccessnoMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            //无数据,添加
            Recommendsuccessno recommendsuccessno = new Recommendsuccessno();
            recommendsuccessno.setAccountid(personrecruitingprocess.getAccountid());
            //初始添加推荐成功一次
            recommendsuccessno.setRecommendsuccessno(1);
            int i = recommendsuccessnoMapper.insertSelective(recommendsuccessno);
            if (i < 1) {
                throw new MyException(ResultEnum.INSERT_SQL_ERROR);
            }
        } else {
            //有记录,修改
            Recommendsuccessno recommendsuccessno = list.get(0);
            recommendsuccessno.setRecommendsuccessno(recommendsuccessno.getRecommendsuccessno() + 1);
            int i = recommendsuccessnoMapper.updateByPrimaryKey(recommendsuccessno);
            if (i < 1) {
                throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
            }
        }
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/8 23:47
     * 描述 : 同步审核状态到个人投递申请表
     *
     * @param personrecruitingprocess
     */
    private void updatePersonDeliveryApplication(Personrecruitingprocess personrecruitingprocess) throws MyException {
        PersondeliveryapplicationExample example = new PersondeliveryapplicationExample();
        PersondeliveryapplicationExample.Criteria criteria = example.createCriteria();
        criteria.andAccountidEqualTo(personrecruitingprocess.getAccountid());
        criteria.andEjobvacancyidEqualTo(personrecruitingprocess.getEjobvacancyid());
        List<Persondeliveryapplication> list = persondeliveryapplicationMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            throw new MyException(ResultEnum.DB_ERROR);
        }

        Persondeliveryapplication persondeliveryapplication = list.get(0);
        persondeliveryapplication.setApplicationstatusid(personrecruitingprocess.getApplicationstatusid());
        persondeliveryapplication.setPdeliverystatusid(personrecruitingprocess.getPdeliverystatusid());
        persondeliveryapplication.setDeliverydate(personrecruitingprocess.getApplicationtime());
        persondeliveryapplication.setHandletime(personrecruitingprocess.getHandletime());
        persondeliveryapplication.setInterviewdate(personrecruitingprocess.getInterviewdate());

        int i = persondeliveryapplicationMapper.updateByPrimaryKey(persondeliveryapplication);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }
    }


    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/9 0:14
     * 描述 : 添加招聘流程日志
     *
     * @param personrecruitingprocess
     * @param accountInfo
     * @throws MyException
     */
    private void insertRecruitmentProcessLog(Personrecruitingprocess personrecruitingprocess, AccountInfo accountInfo) throws MyException {

        Recruitmentprocesslog recruitmentprocesslog = new Recruitmentprocesslog();
        recruitmentprocesslog.setPdeliverystatusid(personrecruitingprocess.getPdeliverystatusid());
        recruitmentprocesslog.setApplicationstatusid(personrecruitingprocess.getApplicationstatusid());
        recruitmentprocesslog.setEjobvacancyid(personrecruitingprocess.getEjobvacancyid());
        recruitmentprocesslog.setAccountid(personrecruitingprocess.getAccountid());
        recruitmentprocesslog.setServiceno(personrecruitingprocess.getServiceno());
        recruitmentprocesslog.setCreatetime(new Date());
        recruitmentprocesslog.setCreatepersonid(accountInfo.getAccount().getAccountid());

        int i = recruitmentprocesslogMapper.insertSelective(recruitmentprocesslog);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }
    }


}
