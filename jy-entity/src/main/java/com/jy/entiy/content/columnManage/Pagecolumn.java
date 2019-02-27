package com.jy.entiy.content.columnManage;

import java.util.Date;

public class Pagecolumn {

    
    private Integer pagecolumnid;
    //导航页id
    private Integer pageid;
    //导航页名称
    private String pagename;

    private String pagecolumnname;

    private String remark;

    private Date createtime;

    private String createby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;

    private Integer displayorder;

    private String title;

    private String description;

    private Long fileid;
    //图片地址
    private String picturePath;

    /**
	 * @return the pagename
	 */
	public String getPagename() {
		return pagename;
	}

	/**
	 * @param pagename the pagename to set
	 */
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}

	/**
	 * @return the picturePath
	 */
	public String getPicturePath() {
		return picturePath;
	}

	/**
	 * @param picturePath the picturePath to set
	 */
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Integer getPagecolumnid() {
        return pagecolumnid;
    }

    public void setPagecolumnid(Integer pagecolumnid) {
        this.pagecolumnid = pagecolumnid;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public String getPagecolumnname() {
        return pagecolumnname;
    }

    public void setPagecolumnname(String pagecolumnname) {
        this.pagecolumnname = pagecolumnname == null ? null : pagecolumnname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Long getCreatepersonid() {
        return createpersonid;
    }

    public void setCreatepersonid(Long createpersonid) {
        this.createpersonid = createpersonid;
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

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getFileid() {
        return fileid;
    }

    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }

	@Override
	public String toString() {
		return "Pagecolumn [pagecolumnid=" + pagecolumnid + ", pageid=" + pageid + ", pagecolumnname=" + pagecolumnname
				+ ", remark=" + remark + ", createtime=" + createtime + ", createby=" + createby + ", createpersonid="
				+ createpersonid + ", updatetime=" + updatetime + ", updateby=" + updateby + ", updatepersonid="
				+ updatepersonid + ", displayorder=" + displayorder + ", title=" + title + ", description="
				+ description + ", fileid=" + fileid + ", picturePath=" + picturePath + "]";
	}
    
}