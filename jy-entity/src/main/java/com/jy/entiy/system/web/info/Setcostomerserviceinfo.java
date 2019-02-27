package com.jy.entiy.system.web.info;

import java.util.Date;

public class Setcostomerserviceinfo {
    private Integer setcostomerserviceinfoid;

    private String start;

    private String site;

    private String dialog;

    private String worktime;

    private String position1;

    private String qq1;

    private String position2;

    private String qq2;

    private String position3;

    private String qq3;

    private Date createtime;

    private Date updatetime;

    private Long createpersonid;

    private Long updatepersonid;

    private String updateby;

    private String createby;

    public Integer getSetcostomerserviceinfoid() {
        return setcostomerserviceinfoid;
    }

    public void setSetcostomerserviceinfoid(Integer setcostomerserviceinfoid) {
        this.setcostomerserviceinfoid = setcostomerserviceinfoid;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start == null ? null : start.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog == null ? null : dialog.trim();
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime == null ? null : worktime.trim();
    }

    public String getPosition1() {
        return position1;
    }

    public void setPosition1(String position1) {
        this.position1 = position1 == null ? null : position1.trim();
    }

    public String getQq1() {
        return qq1;
    }

    public void setQq1(String qq1) {
        this.qq1 = qq1 == null ? null : qq1.trim();
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2 == null ? null : position2.trim();
    }

    public String getQq2() {
        return qq2;
    }

    public void setQq2(String qq2) {
        this.qq2 = qq2 == null ? null : qq2.trim();
    }

    public String getPosition3() {
        return position3;
    }

    public void setPosition3(String position3) {
        this.position3 = position3 == null ? null : position3.trim();
    }

    public String getQq3() {
        return qq3;
    }

    public void setQq3(String qq3) {
        this.qq3 = qq3 == null ? null : qq3.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Long createpersonid) {
        this.createpersonid = createpersonid;
    }

    public Long getUpdatepersonid() {
        return updatepersonid;
    }

    public void setUpdatepersonid(Long updatepersonid) {
        this.updatepersonid = updatepersonid;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }
}