package com.jy.entiy.function.enterprise.enterpriseFunction;

import java.util.Date;

public class Personrecruitingprocess {
    private Long personrecruitingprocessid;

    private Integer applicationstatusid;

    private Integer pdeliverystatusid;

    private Integer ejobvacancyid;

    private Long accountid;

    private String remark;

    private Date handletime;

    private Integer recommendsuccessno;

    private Date applicationtime;

    private Integer enterpriseid;

    private Date createtime;

    private String createby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;

    private Date interviewdate;

    private String serviceno;

    public Long getPersonrecruitingprocessid() {
        return personrecruitingprocessid;
    }

    public void setPersonrecruitingprocessid(Long personrecruitingprocessid) {
        this.personrecruitingprocessid = personrecruitingprocessid;
    }

    public Integer getApplicationstatusid() {
        return applicationstatusid;
    }

    public void setApplicationstatusid(Integer applicationstatusid) {
        this.applicationstatusid = applicationstatusid;
    }

    public Integer getPdeliverystatusid() {
        return pdeliverystatusid;
    }

    public void setPdeliverystatusid(Integer pdeliverystatusid) {
        this.pdeliverystatusid = pdeliverystatusid;
    }

    public Integer getEjobvacancyid() {
        return ejobvacancyid;
    }

    public void setEjobvacancyid(Integer ejobvacancyid) {
        this.ejobvacancyid = ejobvacancyid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getHandletime() {
        return handletime;
    }

    public void setHandletime(Date handletime) {
        this.handletime = handletime;
    }

    public Integer getRecommendsuccessno() {
        return recommendsuccessno;
    }

    public void setRecommendsuccessno(Integer recommendsuccessno) {
        this.recommendsuccessno = recommendsuccessno;
    }

    public Date getApplicationtime() {
        return applicationtime;
    }

    public void setApplicationtime(Date applicationtime) {
        this.applicationtime = applicationtime;
    }

    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Long getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Long createpersonid) {
        this.createpersonid = createpersonid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public Long getUpdatepersonid() {
        return updatepersonid;
    }

    public void setUpdatepersonid(Long updatepersonid) {
        this.updatepersonid = updatepersonid;
    }

    public Date getInterviewdate() {
        return interviewdate;
    }

    public void setInterviewdate(Date interviewdate) {
        this.interviewdate = interviewdate;
    }

    public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno == null ? null : serviceno.trim();
    }
}
