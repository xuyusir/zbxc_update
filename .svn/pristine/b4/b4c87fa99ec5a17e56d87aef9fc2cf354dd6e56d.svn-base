package com.jy.quartz;


import com.jy.common.utils.DateUtils;
import com.jy.dao.function.enterprise.recruitment.EnterprisejobvacancyMapper;
import com.jy.entiy.function.enterprise.recruitment.Enterprisejobvacancy;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Description : 企业发布职位,超过截止日期后,自动关闭该职位
 * @Author : cheng fei
 * @Date : 2018/11/28 09:34
 */
public class JobQuartz {

    private Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private EnterprisejobvacancyMapper enterprisejobvacancyMapper;

    public void execute() throws ParseException {
        logger.info("自动关闭超过有效期招聘职位开始执行....");
        List<Enterprisejobvacancy> overdueJob = getOverdueJob();
        for (Enterprisejobvacancy job : overdueJob) {
            Enterprisejobvacancy newJob = new Enterprisejobvacancy();
            newJob.setEjobvacancyid(job.getEjobvacancyid());
            newJob.setIsopen("N");
            int i = enterprisejobvacancyMapper.updateByPrimaryKeySelective(newJob);
            if (i < 1){
                logger.error("关闭[ "+ job.getJobtitle() +" ]职位失败!");
            }else {
                logger.info("系统自动关闭了[  " + job.getJobtitle() + "  ]职位");
            }
        }
        logger.info("自动关闭超过有效期招聘职位结束!");

    }


    /**
     * 作者: cheng fei
     * 创建日期: 2018/11/28 12:43
     * 描述 : 获取已超过有效期职位列表,不包含中博星辰自己发布的职位
     * @return
     * @throws ParseException
     */
    private List<Enterprisejobvacancy> getOverdueJob() throws ParseException {
        String nowDate = DateUtils.dateFormat(new Date(), DateUtils.DATE_PATTERN);
        return enterprisejobvacancyMapper.getOverdueJobList(nowDate);

    }
}
