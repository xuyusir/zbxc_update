package com.jy.entiy.system.select;

import java.util.Date;

public class Marketingtracktype {
    private Integer marketingtracktypeid;

    private String marketingtracktypename;

    private Integer displayorder;

    private String code;

    private Integer status;

    private String createby;

    private Date createtime;

    private Long createpersonid;

    private String updateby;

    private Date updatetime;

    private Long updatepersonid;

    private String remark;

    public Integer getMarketingtracktypeid() {
        return marketingtracktypeid;
    }

    public void setMarketingtracktypeid(Integer marketingtracktypeid) {
        this.marketingtracktypeid = marketingtracktypeid;
    }

    public String getMarketingtracktypename() {
        return marketingtracktypename;
    }

    public void setMarketingtracktypename(String marketingtracktypename) {
        this.marketingtracktypename = marketingtracktypename == null ? null : marketingtracktypename.trim();
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
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

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getUpdatepersonid() {
        return updatepersonid;
    }

    public void setUpdatepersonid(Long updatepersonid) {
        this.updatepersonid = updatepersonid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}