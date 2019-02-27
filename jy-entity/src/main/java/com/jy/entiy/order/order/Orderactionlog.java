package com.jy.entiy.order.order;

import java.util.Date;

public class Orderactionlog {
    private Long orderactionlogid;

    private Long orderid;

    private Long orderdetailsid;

    private String actionuser;

    private Integer orderstatus;

    private Integer paystatus;

    private String remark;

    private Date actionlogtime;

    private Long accountid;

    public Long getOrderactionlogid() {
        return orderactionlogid;
    }

    public void setOrderactionlogid(Long orderactionlogid) {
        this.orderactionlogid = orderactionlogid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getOrderdetailsid() {
        return orderdetailsid;
    }

    public void setOrderdetailsid(Long orderdetailsid) {
        this.orderdetailsid = orderdetailsid;
    }

    public String getActionuser() {
        return actionuser;
    }

    public void setActionuser(String actionuser) {
        this.actionuser = actionuser == null ? null : actionuser.trim();
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Integer paystatus) {
        this.paystatus = paystatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getActionlogtime() {
        return actionlogtime;
    }

    public void setActionlogtime(Date actionlogtime) {
        this.actionlogtime = actionlogtime;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }
}