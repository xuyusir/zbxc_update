package com.jy.entiy.system.web.info;

import java.util.Date;

public class Setwebinfo {
    private Integer websetinfoid;

    private String url;

    private String name;

    private String title;

    private String icpid;

    private String provinceinitial;

    private String caseid;

    private String keyword;

    private String depict;

    private String copyright;

    private String address;

    private String phone;

    private String mobilephone;

    private String fax;

    private String mail;

    private String postalcode;

    private Long weblogo;

    private Long wechatqrcode;

    private String start;

    private Long mobilelogo;

    private Date createtime;

    private Date updatetime;

    private Long createpersonid;

    private Long updatepersonid;

    private String updateby;

    private String createby;
    
    private String webLogoPath;
    
    private String wechatQRCodePath;
    
    private String mobileLogoPath;

    public String getWebLogoPath() {
		return webLogoPath;
	}

	public void setWebLogoPath(String webLogoPath) {
		this.webLogoPath = webLogoPath;
	}

	public String getWechatQRCodePath() {
		return wechatQRCodePath;
	}

	public void setWechatQRCodePath(String wechatQRCodePath) {
		this.wechatQRCodePath = wechatQRCodePath;
	}

	public String getMobileLogoPath() {
		return mobileLogoPath;
	}

	public void setMobileLogoPath(String mobileLogoPath) {
		this.mobileLogoPath = mobileLogoPath;
	}

	public Integer getWebsetinfoid() {
        return websetinfoid;
    }

    public void setWebsetinfoid(Integer websetinfoid) {
        this.websetinfoid = websetinfoid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIcpid() {
        return icpid;
    }

    public void setIcpid(String icpid) {
        this.icpid = icpid == null ? null : icpid.trim();
    }

    public String getProvinceinitial() {
        return provinceinitial;
    }

    public void setProvinceinitial(String provinceinitial) {
        this.provinceinitial = provinceinitial == null ? null : provinceinitial.trim();
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid == null ? null : caseid.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode == null ? null : postalcode.trim();
    }

    public Long getWeblogo() {
        return weblogo;
    }

    public void setWeblogo(Long weblogo) {
        this.weblogo = weblogo;
    }

    public Long getWechatqrcode() {
        return wechatqrcode;
    }

    public void setWechatqrcode(Long wechatqrcode) {
        this.wechatqrcode = wechatqrcode;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start == null ? null : start.trim();
    }

    public Long getMobilelogo() {
        return mobilelogo;
    }

    public void setMobilelogo(Long mobilelogo) {
        this.mobilelogo = mobilelogo;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Long getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Long createpersonid) {
        this.createpersonid = createpersonid;
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

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }
}