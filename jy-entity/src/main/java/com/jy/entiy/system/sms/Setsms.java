package com.jy.entiy.system.sms;

import java.util.Date;

public class Setsms {
    private Integer setinfoid;

    private Date createtime;

    private Long createpersonid;

    private String createby;

    private Date updatetime;

    private Long updatepersonid;

    private String updateby;

    private String state;

    private String username;

    private String password;

    private String registedsend;

    private String loginsend;

    public Integer getSetinfoid() {
        return setinfoid;
    }

    public void setSetinfoid(Integer setinfoid) {
        this.setinfoid = setinfoid;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRegistedsend() {
        return registedsend;
    }

    public void setRegistedsend(String registedsend) {
        this.registedsend = registedsend == null ? null : registedsend.trim();
    }

    public String getLoginsend() {
        return loginsend;
    }

    public void setLoginsend(String loginsend) {
        this.loginsend = loginsend == null ? null : loginsend.trim();
    }
}