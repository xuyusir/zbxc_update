package com.jy.entiy.system.inMail;

import java.util.Date;

public class Message {
    private Integer id;

    private Long sendid;

    private Long recid;

    private Integer messageid;

    private Integer readingstatus;

    private Integer deletestatus;

    private Long createpersonid;

    private String createby;

    private Date createtime;

    private Long updatepersonid;

    private String updateby;

    private Date updatetime;

    private Messagetext messagetext;
    
    /**
	 * @return the messagetext
	 */
	public Messagetext getMessagetext() {
		return messagetext;
	}

	/**
	 * @param messagetext the messagetext to set
	 */
	public void setMessagetext(Messagetext messagetext) {
		this.messagetext = messagetext;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSendid() {
        return sendid;
    }

    public void setSendid(Long sendid) {
        this.sendid = sendid;
    }

    public Long getRecid() {
        return recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public Integer getReadingstatus() {
        return readingstatus;
    }

    public void setReadingstatus(Integer readingstatus) {
        this.readingstatus = readingstatus;
    }

    public Integer getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Integer deletestatus) {
        this.deletestatus = deletestatus;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}