package com.jy.entiy.content.product.product;

import java.util.Date;

public class Productrecommendpostionbind {
    private Integer productrpid;

    private Long productid;

    private Integer postionnumber;

    private String remark;

    private Integer columnpostionid;

    private Date createtime;

    private String createby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;

    public Integer getProductrpid() {
        return productrpid;
    }

    public void setProductrpid(Integer productrpid) {
        this.productrpid = productrpid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Integer getPostionnumber() {
        return postionnumber;
    }

    public void setPostionnumber(Integer postionnumber) {
        this.postionnumber = postionnumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getColumnpostionid() {
        return columnpostionid;
    }

    public void setColumnpostionid(Integer columnpostionid) {
        this.columnpostionid = columnpostionid;
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