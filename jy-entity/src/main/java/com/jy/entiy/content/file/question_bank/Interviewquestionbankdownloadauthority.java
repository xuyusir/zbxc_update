package com.jy.entiy.content.file.question_bank;

import java.util.Date;

public class Interviewquestionbankdownloadauthority {
    private Integer id;

    private Integer downloadauthority;

    private Date createtime;

    private Long createpersonid;

    private String createby;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDownloadauthority() {
        return downloadauthority;
    }

    public void setDownloadauthority(Integer downloadauthority) {
        this.downloadauthority = downloadauthority;
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

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
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
        this.updateby = updateby;
    }

    public Long getUpdatepersonid() {
        return updatepersonid;
    }

    public void setUpdatepersonid(Long updatepersonid) {
        this.updatepersonid = updatepersonid;
    }
}