package com.jy.entiy.function.enterprise.enterpriseFunction;

import java.util.Date;

public class AppraisaManageView {
    private Long enterpriseappraiseid;

    private String appraisedetail;

    private String name;

    private String jobtitle;

    private Date inductiondate;

    private String enterprisename;

    private Date appraisetime;

    public Long getEnterpriseappraiseid() {
        return enterpriseappraiseid;
    }

    public void setEnterpriseappraiseid(Long enterpriseappraiseid) {
        this.enterpriseappraiseid = enterpriseappraiseid;
    }

    public String getAppraisedetail() {
        return appraisedetail;
    }

    public void setAppraisedetail(String appraisedetail) {
        this.appraisedetail = appraisedetail == null ? null : appraisedetail.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle == null ? null : jobtitle.trim();
    }

    public Date getInductiondate() {
        return inductiondate;
    }

    public void setInductiondate(Date inductiondate) {
        this.inductiondate = inductiondate;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename == null ? null : enterprisename.trim();
    }

    public Date getAppraisetime() {
        return appraisetime;
    }

    public void setAppraisetime(Date appraisetime) {
        this.appraisetime = appraisetime;
    }
}