package com.jy.service.function.enterprise.recruitment.rz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.common.result.ResultEnum;
import com.jy.dao.account.account.AccountMapper;
import com.jy.dao.function.enterprise.info.EnterpriseinfoMapper;
import com.jy.dao.function.enterprise.recruitment.EnterprisejobvacancyMapper;
import com.jy.dao.function.enterprise.recruitment.InterviewremarkMapper;
import com.jy.entiy.account.account.Account;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.function.enterprise.recruitment.Enterprisejobvacancy;
import com.jy.entiy.function.enterprise.recruitment.Interviewremark;
import com.jy.entiy.function.enterprise.recruitment.InterviewremarkExample;
import com.jy.service.function.enterprise.base.BaseEnterpriseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description :
 * @Author : cheng fei
 * @Date : 2018/11/10 17:16
 */

@Service
public class InterviewRemarkServiceImpl extends BaseEnterpriseService implements InterviewRemarkService {

    /**
     * 数据库日志操作类型
     */
    private static final String DB_LOG_TYPE = "DB_LOG_INTERVIEW_REMARK";

    /**
     * 备注类型
     */
    private static final Integer [] TYPES = {1, 2};

    @Resource
    private InterviewremarkMapper interviewremarkMapper;

    @Resource
    private EnterpriseinfoMapper enterpriseinfoMapper;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private EnterprisejobvacancyMapper enterprisejobvacancyMapper;

    @Override
    public Result insertInterviewRemark(AccountInfo accountInfo, long accountID, Integer jobID, String content, Integer type) throws MyException {

        //检测是否是企业账号
        if (!this.checkIsEnterpriseAccount(accountInfo.getAccount())){
            return  Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        //检测参数
        if (!Arrays.asList(TYPES).contains(type)){
            return  Result.build(ResultEnum.PARAMETER_ERROR);
        }

        //插入数据库
        Interviewremark interviewremark = new Interviewremark();
        interviewremark.setAccountid(accountID);
        interviewremark.setJobid(jobID);
        interviewremark.setRemark(content);
        interviewremark.setType(type);

        interviewremark.setCreateby(accountInfo.getAccount().getName());
        interviewremark.setCreatepersonid(accountInfo.getAccount().getAccountid());
        interviewremark.setCreatetime(new Date());

        int i = interviewremarkMapper.insertSelective(interviewremark);
        if (i < 1) {
            throw new MyException(ResultEnum.INSERT_SQL_ERROR);
        }

        //添加数据库操作日志
        String enterpriseName = enterpriseinfoMapper.getEnterpriseNameByAccountID(accountInfo.getAccount().getAccountid());
        Account personAccount = accountMapper.selectByPrimaryKey(accountID);
        Enterprisejobvacancy job = enterprisejobvacancyMapper.selectByPrimaryKey(jobID);
        String log = "[ " + enterpriseName + " ]企业的[ " + accountInfo.getAccount().getName() + " ]对[ " + personAccount.getName() + " ]应聘的[ " + job.getJobtitle() + " ]职位添加了备注:[ " + content + " ]";
        this.dbLog(accountInfo.getAccount().getAccountid(), accountInfo.getAccount().getName(), log, DB_LOG_TYPE);

        return Result.succee();
    }

    @Override
    public Result getInterviewRemarkList(AccountInfo accountInfo, long accountID, Integer jobID, Integer type, Integer page, Integer pageSize) {

        //判断是否是企业账号
        if (!this.checkIsEnterpriseAccount(accountInfo.getAccount())){
            return  Result.build(ResultEnum.ACCOUNT_ERROR);
        }

        //检测参数
        if (!Arrays.asList(TYPES).contains(type)){
            return  Result.build(ResultEnum.PARAMETER_ERROR);
        }

        //开始分页
        PageHelper.startPage(page, pageSize);
        InterviewremarkExample example = new InterviewremarkExample();
        example.setOrderByClause("CreateTime desc");
        InterviewremarkExample.Criteria criteria = example.createCriteria();
        criteria.andAccountidEqualTo(accountID);
        criteria.andJobidEqualTo(jobID);
        criteria.andTypeEqualTo(type);
        List<Interviewremark> list = interviewremarkMapper.selectByExample(example);

        PageInfo<Interviewremark> info = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>(2);
        map.put("rows", info.getList());
        map.put("count", info.getTotal());

        return Result.succee(map);
    }
}
