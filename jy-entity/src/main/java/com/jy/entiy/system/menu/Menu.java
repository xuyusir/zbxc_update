package com.jy.entiy.system.menu;

import java.util.Date;
import java.util.List;

import com.jy.entiy.account.authority.Authority;

public class Menu {
    private Integer menuid;

    private String name;

    private String url;

    private Integer parentid;

    private Integer displayorder;

    private String icon;

    private Date createtime;

    private Long createpersonid;

    private String createby;

    private Date updatetime;

    private Long updatepersonid;

    private String updateby;

    private Integer dictionariesid;
    
    private List<Menu> childMenus;

    private List<Authority> authoritys;
    
    public List<Authority> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(List<Authority> authoritys) {
		this.authoritys = authoritys;
	}

	public List<Menu> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<Menu> childMenus) {
		this.childMenus = childMenus;
	}

	public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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

    public Integer getDictionariesid() {
        return dictionariesid;
    }

    public void setDictionariesid(Integer dictionariesid) {
        this.dictionariesid = dictionariesid;
    }

	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", name=" + name + ", url=" + url + ", parentid=" + parentid
				+ ", displayorder=" + displayorder + ", icon=" + icon + ", createtime=" + createtime
				+ ", createpersonid=" + createpersonid + ", createby=" + createby + ", updatetime=" + updatetime
				+ ", updatepersonid=" + updatepersonid + ", updateby=" + updateby + ", dictionariesid=" + dictionariesid
				+ ", childMenus=" + childMenus + "]";
	}
    
    
}