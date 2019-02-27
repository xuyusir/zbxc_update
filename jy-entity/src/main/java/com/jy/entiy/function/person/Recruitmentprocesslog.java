package com.jy.entiy.function.person;

import java.util.Date;

public class Recruitmentprocesslog {
    private Long id;

    private Integer pdeliverystatusid;

    private Integer applicationstatusid;

    private Integer ejobvacancyid;

    private Long accountid;

    private String serviceno;

    private Date createtime;

    private Long createpersonid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPdeliverystatusid() {
        return pdeliverystatusid;
    }

    public void setPdeliverystatusid(Integer pdeliverystatusid) {
        this.pdeliverystatusid = pdeliverystatusid;
    }

    public Integer getApplicationstatusid() {
        return applicationstatusid;
    }

    public void setApplicationstatusid(Integer applicationstatusid) {
        this.applicationstatusid = applicationstatusid;
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

    public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Long createpersonid) {
        this.createpersonid = createpersonid;
    }
}