package com.jy.entiy.function.enterprise.enterpriseFunction;

public class Accountenterprise {
    private Long accountenterpriseid;

    private Long accountid;

    private Integer enterpriseid;

    private String remake;

    public Long getAccountenterpriseid() {
        return accountenterpriseid;
    }

    public void setAccountenterpriseid(Long accountenterpriseid) {
        this.accountenterpriseid = accountenterpriseid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake == null ? null : remake.trim();
    }
}