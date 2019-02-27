package com.jy.service.function.person.memberFunction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.function.enterprise.enterpriseFunction.PersonrecruitingprocessMapper;
import com.jy.dao.function.enterprise.enterpriseFunction.RecommendsuccessnoMapper;
import com.jy.dao.function.enterprise.recruitment.EnterpriserecruitingprocessMapper;
import com.jy.dao.function.person.PersondeliveryapplicationMapper;
import com.jy.dao.function.person.RecruitmentprocesslogMapper;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.enterpriseFunction.Personrecruitingprocess;
import com.jy.entiy.function.enterprise.recruitment.Enterpriserecruitingprocess;
import com.jy.entiy.function.person.Persondeliveryapplication;
import com.jy.entiy.function.person.PersondeliveryapplicationExample;
import com.jy.entiy.function.person.Recruitmentprocesslog;
import com.jy.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @ClassName: DeliverMannageServiceImpl
 * @Description:投递审核处理ServiceImpl
 * @author: chenye
 * @date: 2018-09-03 10:45
 */
@Service
public class DeliverMannageServiceImpl extends BaseService implements DeliverMannageService {

	/**
	 * 审核处理状态
	 * 0.待处理
	 * 1.已同意
	 * 2.已拒绝
	 */
	private static final Integer [] APPLICATION_STATUS = {1, 2, 3};

	/**
	 * 是否是会员
	 * 0.全部
	 * 1. 是
	 * 2.不是
	 */
	private static final Integer [] IS_MEMBERS = {0, 1, 2};

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
	public Result processingDelivery(AccountInfo accountInfo, String AUTHORITY_CODE, String ids, Integer applicationStatusID) throws MyException {
		// 检测权限
		Result checkAuthority = this.checkAuthority(accountInfo, AUTHORITY_CODE);
		if (checkAuthority.getStatus() != ResultEnum.SUCCESS.getStatus().intValue()) {
			return checkAuthority;
		}

		// 参数检查
		if (applicationStatusID != 1 && !Arrays.asList(APPLICATION_STATUS).contains(applicationStatusID)) {
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

        String[] split = ids.split(",");

        for (String idStr : split) {

            if (!StringUtils.isNumeric(idStr)){
                return Result.build(ResultEnum.PARAMETER_ERROR);
            }

            Personrecruitingprocess personrecruitingprocess = personrecruitingprocessMapper.selectByPrimaryKey(Long.parseLong(idStr));

            //审核状态不是待处理,跳过
            if (personrecruitingprocess.getApplicationstatusid() != APPLICATION_STATUS[0].intValue()){
                continue;
            }else {
                updateApplicationStatus(personrecruitingprocess, accountInfo, Long.parseLong(idStr), applicationStatusID);
            }

        }


		return Result.succee();
	}

	@Override
	public Result  getDeliveryApplicationList(Integer applicationStatus, Integer isMember,String applicationTime,String search, Integer page, Integer pageSize) throws MyException {

		//检测参数
		if (applicationStatus != 0  && !Arrays.asList(APPLICATION_STATUS).contains(applicationStatus.intValue())){
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		if (!Arrays.asList(IS_MEMBERS).contains(isMember.intValue())){
			return Result.build(ResultEnum.PARAMETER_ERROR);
		}

		applicationTime = this.checkSearchTime(applicationTime);
		applicationTime = this.checkSearch(applicationTime);
		search = this.checkSearch(search);

		//分页
		PageHelper.startPage(page, pageSize);
        List<Map<String, Object>> list = personrecruitingprocessMapper.getDeliveryApplicationList(applicationStatus, isMember, applicationTime, search);
        PageInfo<Map<String, Object>> info = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>(2);
		map.put("rows", info.getList());
		map.put("count", info.getTotal());
		return Result.succee(map);

	}

    private void updateApplicationStatus(Personrecruitingprocess personrecruitingprocess, AccountInfo accountInfo, Long id, int applicationStatus) throws MyException {
        Date date = new Date();

        //修改审核申请表
        personrecruitingprocess.setApplicationstatusid(applicationStatus);
        personrecruitingprocess.setHandletime(date);
        int i = personrecruitingprocessMapper.updateByPrimaryKeySelective(personrecruitingprocess);
        if (i < 1) {
            throw new MyException(ResultEnum.UPDATE_SQL_ERROR);
        }
        //审核通过
        if (APPLICATION_STATUS[1] == applicationStatus) {
            //添加到企业招聘表
            insertEnterpriseRecruitingProcess(personrecruitingprocess);
            //同步到个人简历投递申请表
            updatePersonDeliveryApplication(personrecruitingprocess);

            //插入招聘流程日志表
            insertRecruitmentProcessLog(personrecruitingprocess, accountInfo);
        }else if (APPLICATION_STATUS[2] == applicationStatus) {
            //修改个人简历投递表状态不主动投递不合适
            personrecruitingprocess.setPdeliverystatusid(PERSON_DELIVERY_STATUS[1]);
            updatePersonDeliveryApplication(personrecruitingprocess);
            insertRecruitmentProcessLog(personrecruitingprocess, accountInfo);
        }
    }

    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/9 0:19
     * 描述 : 添加数据到企业招聘流程表
     *
     * @param personrecruitingprocess
     */
    private void insertEnterpriseRecruitingProcess(Personrecruitingprocess personrecruitingprocess) throws MyException {
        Enterpriserecruitingprocess enterpriserecruitingprocess = new Enterpriserecruitingprocess();
        enterpriserecruitingprocess.setAccountid(personrecruitingprocess.getAccountid());
        enterpriserecruitingprocess.setEjobvacancyid(personrecruitingprocess.getEjobvacancyid());
        enterpriserecruitingprocess.setApplicationstatusid(personrecruitingprocess.getApplicationstatusid());
        enterpriserecruitingprocess.setPdeliverystatusid(personrecruitingprocess.getPdeliverystatusid());
        enterpriserecruitingprocess.setApplicationtime(personrecruitingprocess.getApplicationtime());
        enterpriserecruitingprocess.setHandletime(personrecruitingprocess.getHandletime());
        enterpriserecruitingprocess.setEnterpriseid(personrecruitingprocess.getEnterpriseid());

        int i = enterpriserecruitingprocessMapper.insertSelective(enterpriserecruitingprocess);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
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
        persondeliveryapplication.setHandletime(personrecruitingprocess.getHandletime());

        int i = persondeliveryapplicationMapper.updateByPrimaryKeySelective(persondeliveryapplication);
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
        recruitmentprocesslog.setCreatetime(new Date());
        recruitmentprocesslog.setCreatepersonid(accountInfo.getAccount().getAccountid());

        int i = recruitmentprocesslogMapper.insertSelective(recruitmentprocesslog);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }
    }
}
