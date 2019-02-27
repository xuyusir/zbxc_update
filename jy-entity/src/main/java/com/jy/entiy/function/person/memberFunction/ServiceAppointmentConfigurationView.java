package com.jy.entiy.function.person.memberFunction;

import java.util.Date;

public class ServiceAppointmentConfigurationView {
	//预约编号
    private Long appointserviceid;
    //预约日期
    private Date appointdate;
    //预约日期展示
    private String appointdateView;
    //预约时间
    private String timephase;
    //预约老师
    private String appointteacher;
    //预约服务名字
    private String appointservicename;
    //预约名额
    private Integer appointtotalnum;
    //剩余名额
    private Integer appointleftnum;
    //状态(根据预约时间判断当前时间已超过预约时间为已完成否则为正在进行)
    private String status;
    

    /**
	 * @return the appointservicename
	 */
	public String getAppointservicename() {
		return appointservicename;
	}

	/**
	 * @param appointservicename the appointservicename to set
	 */
	public void setAppointservicename(String appointservicename) {
		this.appointservicename = appointservicename;
	}

	/**
	 * @return the appointdateView
	 */
	public String getAppointdateView() {
		return appointdateView;
	}

	/**
	 * @param appointdateView the appointdateView to set
	 */
	public void setAppointdateView(String appointdateView) {
		this.appointdateView = appointdateView;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAppointserviceid() {
        return appointserviceid;
    }

    public void setAppointserviceid(Long appointserviceid) {
        this.appointserviceid = appointserviceid;
    }

    public Date getAppointdate() {
        return appointdate;
    }

    public void setAppointdate(Date appointdate) {
        this.appointdate = appointdate;
    }

    public String getTimephase() {
        return timephase;
    }

    public void setTimephase(String timephase) {
        this.timephase = timephase == null ? null : timephase.trim();
    }

    public String getAppointteacher() {
        return appointteacher;
    }

    public void setAppointteacher(String appointteacher) {
        this.appointteacher = appointteacher == null ? null : appointteacher.trim();
    }

    public Integer getAppointtotalnum() {
        return appointtotalnum;
    }

    public void setAppointtotalnum(Integer appointtotalnum) {
        this.appointtotalnum = appointtotalnum;
    }

    public Integer getAppointleftnum() {
        return appointleftnum;
    }

    public void setAppointleftnum(Integer appointleftnum) {
        this.appointleftnum = appointleftnum;
    }
}