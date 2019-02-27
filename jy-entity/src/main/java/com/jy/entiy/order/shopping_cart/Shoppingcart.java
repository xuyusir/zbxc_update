package com.jy.entiy.order.shopping_cart;

import java.util.Date;

public class Shoppingcart {
    private Long cartid;

    private Long accountid;

    private String cartstatus;

    private Date createtime;

    private String createby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;

    public Long getCartid() {
        return cartid;
    }

    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getCartstatus() {
        return cartstatus;
    }

    public void setCartstatus(String cartstatus) {
        this.cartstatus = cartstatus == null ? null : cartstatus.trim();
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
}