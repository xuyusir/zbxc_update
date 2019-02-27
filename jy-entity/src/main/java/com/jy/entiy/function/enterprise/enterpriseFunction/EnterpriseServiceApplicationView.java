package com.jy.entiy.function.enterprise.enterpriseFunction;

import java.util.Date;

public class EnterpriseServiceApplicationView {
	
	//人才库申请表自增长主键
    private Integer talentpoolapplicationid;
	//服务单号
    private String serviceno;
    //申请时间
    private Date applcationdate;
    //企业名称
    private String enterprisename;
    //联系人
    private String name;
    //联系方式
    private String phone;
    //申请服务
    private Integer applicationservicetype;
    //申请服务名称
    private String applicationservicename;
    //申请状态id
    private Integer applicationstatusid;
    //申请状态
    private String applicationstatusname;
    //处理时间
    private Date handletime;
    //状态码
    private String code;

    /**
	 * @return the applicationservicename
	 */
	public String getApplicationservicename() {
		return applicationservicename;
	}

	/**
	 * @param applicationservicename the applicationservicename to set
	 */
	public void setApplicationservicename(String applicationservicename) {
		this.applicationservicename = applicationservicename;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the talentpoolapplicationid
	 */
	public Integer getTalentpoolapplicationid() {
		return talentpoolapplicationid;
	}

	/**
	 * @param talentpoolapplicationid the talentpoolapplicationid to set
	 */
	public void setTalentpoolapplicationid(Integer talentpoolapplicationid) {
		this.talentpoolapplicationid = talentpoolapplicationid;
	}

	public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno == null ? null : serviceno.trim();
    }

    public Date getApplcationdate() {
        return applcationdate;
    }

    public void setApplcationdate(Date applcationdate) {
        this.applcationdate = applcationdate;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename == null ? null : enterprisename.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getApplicationservicetype() {
        return applicationservicetype;
    }

    public void setApplicationservicetype(Integer applicationservicetype) {
        this.applicationservicetype = applicationservicetype;
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
}