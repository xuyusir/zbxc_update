package com.jy.entiy.system.db_log;

import java.util.Date;

public class Dblog {
    private Long dblogid;

    private Long createpersonid;

    private String createby;

    private Date createtime;

    private String dblog;

    private Integer dictionariesid;
    
    private String typeName;
    
    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getDblogid() {
        return dblogid;
    }

    public void setDblogid(Long dblogid) {
        this.dblogid = dblogid;
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

    public String getDblog() {
        return dblog;
    }

    public void setDblog(String dblog) {
        this.dblog = dblog == null ? null : dblog.trim();
    }

    public Integer getDictionariesid() {
        return dictionariesid;
    }

    public void setDictionariesid(Integer dictionariesid) {
        this.dictionariesid = dictionariesid;
    }
}