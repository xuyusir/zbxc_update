package com.jy.entiy.vedio;

import java.util.Date;

public class Vedioinfo {
    private Long vedioid;

    private Integer vediotypeid;

    private Integer vediocategoryid;

    private String vedioname;

    private String vediolocationserver;

    private String vediopath;

    private String vediolinkurl;

    private Float vediosize;

    private Date createtime;

    private Long createpersonid;

    private String createby;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;

    public Long getVedioid() {
        return vedioid;
    }

    public void setVedioid(Long vedioid) {
        this.vedioid = vedioid;
    }

    public Integer getVediotypeid() {
        return vediotypeid;
    }

    public void setVediotypeid(Integer vediotypeid) {
        this.vediotypeid = vediotypeid;
    }

    public Integer getVediocategoryid() {
        return vediocategoryid;
    }

    public void setVediocategoryid(Integer vediocategoryid) {
        this.vediocategoryid = vediocategoryid;
    }

    public String getVedioname() {
        return vedioname;
    }

    public void setVedioname(String vedioname) {
        this.vedioname = vedioname == null ? null : vedioname.trim();
    }

    public String getVediolocationserver() {
        return vediolocationserver;
    }

    public void setVediolocationserver(String vediolocationserver) {
        this.vediolocationserver = vediolocationserver == null ? null : vediolocationserver.trim();
    }

    public String getVediopath() {
        return vediopath;
    }

    public void setVediopath(String vediopath) {
        this.vediopath = vediopath == null ? null : vediopath.trim();
    }

    public String getVediolinkurl() {
        return vediolinkurl;
    }

    public void setVediolinkurl(String vediolinkurl) {
        this.vediolinkurl = vediolinkurl == null ? null : vediolinkurl.trim();
    }

    public Float getVediosize() {
        return vediosize;
    }

    public void setVediosize(Float vediosize) {
        this.vediosize = vediosize;
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
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public Long getUpdatepersonid() {
        return updatepersonid;
    }

    public void setUpdatepersonid(Long updatepersonid) {
        this.updatepersonid = updatepersonid;
    }
}