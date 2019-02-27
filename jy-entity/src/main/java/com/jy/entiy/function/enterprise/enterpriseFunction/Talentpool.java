package com.jy.entiy.function.enterprise.enterpriseFunction;

public class Talentpool {
    private Long id;

    private Integer enterpriseid;

    private Long accountid;

    private String remark;

    private Long resumeid;

    private Long customresumeid;

    private Integer talentpoolapplicationid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
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

    public Long getResumeid() {
        return resumeid;
    }

    public void setResumeid(Long resumeid) {
        this.resumeid = resumeid;
    }

    public Long getCustomresumeid() {
        return customresumeid;
    }

    public void setCustomresumeid(Long customresumeid) {
        this.customresumeid = customresumeid;
    }

    public Integer getTalentpoolapplicationid() {
        return talentpoolapplicationid;
    }

    public void setTalentpoolapplicationid(Integer talentpoolapplicationid) {
        this.talentpoolapplicationid = talentpoolapplicationid;
    }
}