package com.jy.entiy.system.select;

import java.util.Date;

public class Votetype {
    private Integer votetypeid;

    private String votetypename;

    private String remark;

    private Date createtime;

    private String createby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;

    private Integer displayorder;

    private String code;

    private Integer status;

    public Integer getVotetypeid() {
        return votetypeid;
    }

    public void setVotetypeid(Integer votetypeid) {
        this.votetypeid = votetypeid;
    }

    public String getVotetypename() {
        return votetypename;
    }

    public void setVotetypename(String votetypename) {
        this.votetypename = votetypename == null ? null : votetypename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}