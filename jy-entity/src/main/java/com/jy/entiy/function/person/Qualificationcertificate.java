package com.jy.entiy.function.person;

import java.util.Date;

public class Qualificationcertificate {
    private Integer qcid;

    private Integer certificatetypeid;

    private Long resumeid;

    private String qctitle;

    private String istotalpass;

    private String passedsubject;

    private Float score;

    private Date qcdate;

    private String createby;

    private Date createtime;

    private Long createpersonid;

    private String updateby;

    private Date updatetime;

    private Long updatepersonid;
    
    private String qcdates;
    
    

    public String getQcdates() {
		return qcdates;
	}

	public void setQcdates(String qcdates) {
		this.qcdates = qcdates;
	}

	public Integer getQcid() {
        return qcid;
    }

    public void setQcid(Integer qcid) {
        this.qcid = qcid;
    }

    public Integer getCertificatetypeid() {
        return certificatetypeid;
    }

    public void setCertificatetypeid(Integer certificatetypeid) {
        this.certificatetypeid = certificatetypeid;
    }

    public Long getResumeid() {
        return resumeid;
    }

    public void setResumeid(Long resumeid) {
        this.resumeid = resumeid;
    }

    public String getQctitle() {
        return qctitle;
    }

    public void setQctitle(String qctitle) {
        this.qctitle = qctitle == null ? null : qctitle.trim();
    }

    public String getIstotalpass() {
        return istotalpass;
    }

    public void setIstotalpass(String istotalpass) {
        this.istotalpass = istotalpass == null ? null : istotalpass.trim();
    }

    public String getPassedsubject() {
        return passedsubject;
    }

    public void setPassedsubject(String passedsubject) {
        this.passedsubject = passedsubject == null ? null : passedsubject.trim();
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Date getQcdate() {
        return qcdate;
    }

    public void setQcdate(Date qcdate) {
        this.qcdate = qcdate;
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
}