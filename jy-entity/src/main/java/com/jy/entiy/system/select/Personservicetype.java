package com.jy.entiy.system.select;

import java.util.Date;

public class Personservicetype {
    private Integer servicetypeid;

    private String servicetypename;

    private String remark;

    private String createby;

    private Date createtime;

    private Long createpersonid;

    private String updateby;

    private Date updatetime;

    private Long updatepersonid;

    private Integer displayorder;

    private String code;

    private Integer status;

    private Date suggestiontime;

    private String suggestionreason;

    public Integer getServicetypeid() {
        return servicetypeid;
    }

    public void setServicetypeid(Integer servicetypeid) {
        this.servicetypeid = servicetypeid;
    }

    public String getServicetypename() {
        return servicetypename;
    }

    public void setServicetypename(String servicetypename) {
        this.servicetypename = servicetypename == null ? null : servicetypename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Date getSuggestiontime() {
        return suggestiontime;
    }

    public void setSuggestiontime(Date suggestiontime) {
        this.suggestiontime = suggestiontime;
    }

    public String getSuggestionreason() {
        return suggestionreason;
    }

    public void setSuggestionreason(String suggestionreason) {
        this.suggestionreason = suggestionreason == null ? null : suggestionreason.trim();
    }
}