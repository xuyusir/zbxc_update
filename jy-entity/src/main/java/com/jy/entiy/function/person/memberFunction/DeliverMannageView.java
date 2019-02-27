package com.jy.entiy.function.person.memberFunction;

import java.util.Date;

public class DeliverMannageView {
	//主键
	private Long pdapplciationid;
	//服务单号
    private String serviceno;
    //申请时间
    private Date deliverydate;
    //用户账号
    private Long accountid;
    //是否是会员
    private Integer ismember;
    //是否是会员
    private String isManage;
    //用户姓名
    private String name;
    //手机号
    private String phone;
    //岗位id
    private String ejobvacancyid;
    //投递岗位
    private String jobtitle;
    //申请状态id
    private Integer applicationstatusid;
    //申请状态
    private String applicationstatusname;
    //处理时间
    private Date handletime;
    //投递状态id
    private Integer pdeliverystatusid;
    //投递状态名称(面试,录用)
    private String deleiverystatusname;
    /** 历史推荐成功次数(这个人被录取过好多次就推荐成功过几次)*/
    private Integer recommendNo;
    
    

    /**
	 * @return the ismember
	 */
	public Integer getIsmember() {
		return ismember;
	}

	/**
	 * @param ismember the ismember to set
	 */
	public void setIsmember(Integer ismember) {
		this.ismember = ismember;
	}

	/**
	 * @return the ejobvacancyid
	 */
	public String getEjobvacancyid() {
		return ejobvacancyid;
	}

	/**
	 * @param ejobvacancyid the ejobvacancyid to set
	 */
	public void setEjobvacancyid(String ejobvacancyid) {
		this.ejobvacancyid = ejobvacancyid;
	}

	/**
	 * @return the isManage
	 */
	public String getIsManage() {
		return isManage;
	}

	/**
	 * @param isManage the isManage to set
	 */
	public void setIsManage(String isManage) {
		this.isManage = isManage;
	}



	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the pdapplciationid
	 */
	public Long getPdapplciationid() {
		return pdapplciationid;
	}

	/**
	 * @param pdapplciationid the pdapplciationid to set
	 */
	public void setPdapplciationid(Long pdapplciationid) {
		this.pdapplciationid = pdapplciationid;
	}

	/**
	 * @return the recommendNo
	 */
	public Integer getRecommendNo() {
		return recommendNo;
	}

	/**
	 * @param recommendNo the recommendNo to set
	 */
	public void setRecommendNo(Integer recommendNo) {
		this.recommendNo = recommendNo;
	}

	public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno == null ? null : serviceno.trim();
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle == null ? null : jobtitle.trim();
    }

    public Integer getApplicationstatusid() {
        return applicationstatusid;
    }

    public void setApplicationstatusid(Integer applicationstatusid) {
        this.applicationstatusid = applicationstatusid;
    }

    public String getApplicationstatusname() {
        return applicationstatusname;
    }

    public void setApplicationstatusname(String applicationstatusname) {
        this.applicationstatusname = applicationstatusname == null ? null : applicationstatusname.trim();
    }

    public Date getHandletime() {
        return handletime;
    }

    public void setHandletime(Date handletime) {
        this.handletime = handletime;
    }

    public Integer getPdeliverystatusid() {
        return pdeliverystatusid;
    }

    public void setPdeliverystatusid(Integer pdeliverystatusid) {
        this.pdeliverystatusid = pdeliverystatusid;
    }

    public String getDeleiverystatusname() {
        return deleiverystatusname;
    }

    public void setDeleiverystatusname(String deleiverystatusname) {
        this.deleiverystatusname = deleiverystatusname == null ? null : deleiverystatusname.trim();
    }
}