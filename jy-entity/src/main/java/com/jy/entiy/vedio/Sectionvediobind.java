package com.jy.entiy.vedio;

public class Sectionvediobind {
    private Long sectionvedioid;

    private Long sectionid;

    private Long vedioid;

    private String remark;

    private String isfree;

    public Long getSectionvedioid() {
        return sectionvedioid;
    }

    public void setSectionvedioid(Long sectionvedioid) {
        this.sectionvedioid = sectionvedioid;
    }

    public Long getSectionid() {
        return sectionid;
    }

    public void setSectionid(Long sectionid) {
        this.sectionid = sectionid;
    }

    public Long getVedioid() {
        return vedioid;
    }

    public void setVedioid(Long vedioid) {
        this.vedioid = vedioid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsfree() {
        return isfree;
    }

    public void setIsfree(String isfree) {
        this.isfree = isfree == null ? null : isfree.trim();
    }
}