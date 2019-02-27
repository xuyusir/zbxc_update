package com.jy.entiy.staff;

import java.util.Date;

public class Stafftrackpath {
    private Long stafftrackpathid;

    private Integer trainingtypeid;

    private Integer trackpathtypeid;

    private Long accountid;

    private Date trainingstartdate;

    private Date trainingenddate;

    private Integer trainingstarthour;

    private Integer trainingstartminute;

    private Integer trainingendhour;

    private Integer trainingendminute;

    private String traininglocation;

    private String trainingproject;

    private String trainingteacher;

    private String trainingcontent;

    private Date createtime;

    private String createby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;

    private Date date;

    private String remark;

    private String adjustmenttype;

    public Long getStafftrackpathid() {
        return stafftrackpathid;
    }

    public void setStafftrackpathid(Long stafftrackpathid) {
        this.stafftrackpathid = stafftrackpathid;
    }

    public Integer getTrainingtypeid() {
        return trainingtypeid;
    }

    public void setTrainingtypeid(Integer trainingtypeid) {
        this.trainingtypeid = trainingtypeid;
    }

    public Integer getTrackpathtypeid() {
        return trackpathtypeid;
    }

    public void setTrackpathtypeid(Integer trackpathtypeid) {
        this.trackpathtypeid = trackpathtypeid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Date getTrainingstartdate() {
        return trainingstartdate;
    }

    public void setTrainingstartdate(Date trainingstartdate) {
        this.trainingstartdate = trainingstartdate;
    }

    public Date getTrainingenddate() {
        return trainingenddate;
    }

    public void setTrainingenddate(Date trainingenddate) {
        this.trainingenddate = trainingenddate;
    }

    public Integer getTrainingstarthour() {
        return trainingstarthour;
    }

    public void setTrainingstarthour(Integer trainingstarthour) {
        this.trainingstarthour = trainingstarthour;
    }

    public Integer getTrainingstartminute() {
        return trainingstartminute;
    }

    public void setTrainingstartminute(Integer trainingstartminute) {
        this.trainingstartminute = trainingstartminute;
    }

    public Integer getTrainingendhour() {
        return trainingendhour;
    }

    public void setTrainingendhour(Integer trainingendhour) {
        this.trainingendhour = trainingendhour;
    }

    public Integer getTrainingendminute() {
        return trainingendminute;
    }

    public void setTrainingendminute(Integer trainingendminute) {
        this.trainingendminute = trainingendminute;
    }

    public String getTraininglocation() {
        return traininglocation;
    }

    public void setTraininglocation(String traininglocation) {
        this.traininglocation = traininglocation == null ? null : traininglocation.trim();
    }

    public String getTrainingproject() {
        return trainingproject;
    }

    public void setTrainingproject(String trainingproject) {
        this.trainingproject = trainingproject == null ? null : trainingproject.trim();
    }

    public String getTrainingteacher() {
        return trainingteacher;
    }

    public void setTrainingteacher(String trainingteacher) {
        this.trainingteacher = trainingteacher == null ? null : trainingteacher.trim();
    }

    public String getTrainingcontent() {
        return trainingcontent;
    }

    public void setTrainingcontent(String trainingcontent) {
        this.trainingcontent = trainingcontent == null ? null : trainingcontent.trim();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAdjustmenttype() {
        return adjustmenttype;
    }

    public void setAdjustmenttype(String adjustmenttype) {
        this.adjustmenttype = adjustmenttype == null ? null : adjustmenttype.trim();
    }
}