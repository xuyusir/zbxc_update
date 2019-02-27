package com.jy.entiy.content.product.course;

import java.util.Date;

public class Sectionremembertime {
    private Long sectionremembertimeid;

    private Long personcourseid;

    private Long sectionid;

    private Integer time;

    private Date updatetime;

    public Long getSectionremembertimeid() {
        return sectionremembertimeid;
    }

    public void setSectionremembertimeid(Long sectionremembertimeid) {
        this.sectionremembertimeid = sectionremembertimeid;
    }

    public Long getPersoncourseid() {
        return personcourseid;
    }

    public void setPersoncourseid(Long personcourseid) {
        this.personcourseid = personcourseid;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}