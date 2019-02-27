package com.jy.entiy.function.person;

import java.util.Date;

public class Personexaminereport {
    private Long pexaminereportid;

    private Integer personreporttypeid;

    private Long accountid;

    private String createby;

    private Date createtime;

    private Long createpersonid;

    private String updateby;

    private Date updatetime;

    private Long fileid;
    
    private String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPexaminereportid() {
        return pexaminereportid;
    }

    public void setPexaminereportid(Long pexaminereportid) {
        this.pexaminereportid = pexaminereportid;
    }

    public Integer getPersonreporttypeid() {
        return personreporttypeid;
    }

    public void setPersonreporttypeid(Integer personreporttypeid) {
        this.personreporttypeid = personreporttypeid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
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

    public Long getFileid() {
        return fileid;
    }

    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }
}