package com.jy.entiy.content.product.course;

import java.util.Date;

public class Personcoursenote {
    private Long coursenoteid;

    private Long accountid;

    private String notetitle;

    private String noterecord;

    private String createby;

    private Date createtime;

    private Long createpersonid;

    private String updateby;

    private Date updatetime;

    private Long updatepersonid;

    private Long courseid;

    private Long charpterid;

    private Long sectionid;

    private Integer time;

    public Long getCoursenoteid() {
        return coursenoteid;
    }

    public void setCoursenoteid(Long coursenoteid) {
        this.coursenoteid = coursenoteid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle == null ? null : notetitle.trim();
    }

    public String getNoterecord() {
        return noterecord;
    }

    public void setNoterecord(String noterecord) {
        this.noterecord = noterecord == null ? null : noterecord.trim();
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

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public Long getCharpterid() {
        return charpterid;
    }

    public void setCharpterid(Long charpterid) {
        this.charpterid = charpterid;
    }

    public Long getSectionid() {
        return sectionid;
    }

    public void setSectionid(Long sectionid) {
        this.sectionid = sectionid;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}