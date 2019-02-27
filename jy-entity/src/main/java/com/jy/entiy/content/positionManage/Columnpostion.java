package com.jy.entiy.content.positionManage;

import java.util.Date;

public class Columnpostion {

    
  //推荐位自增主键id
    private Integer columnpostionid;
    //栏目id
    private Integer pagecolumnid;
    //栏目名字
    private String pagecolumnname;
    //推荐位名字
    private String postionname;

    private String remark;

    private Date createtime;

    private String createby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;
    //栏目排序
    private Integer displayorder;
    //描述
    private String description;
    //图片文件id
    private Long fileid;
    //图片文件地址
    private String picturePath;
    //关联类型
    private Integer relationtype;
    //关联id
    private Integer relationid;
    //关联内容
    private Object relationContent;




	/**
	 * @return the pagecolumnname
	 */
	public String getPagecolumnname() {
		return pagecolumnname;
	}

	/**
	 * @param pagecolumnname the pagecolumnname to set
	 */
	public void setPagecolumnname(String pagecolumnname) {
		this.pagecolumnname = pagecolumnname;
	}

	/**
	 * @return the relationContent
	 */
	public Object getRelationContent() {
		return relationContent;
	}

	/**
	 * @param relationContent the relationContent to set
	 */
	public void setRelationContent(Object relationContent) {
		this.relationContent = relationContent;
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

	public Integer getColumnpostionid() {
        return columnpostionid;
    }

    public void setColumnpostionid(Integer columnpostionid) {
        this.columnpostionid = columnpostionid;
    }

    public Integer getPagecolumnid() {
        return pagecolumnid;
    }

    public void setPagecolumnid(Integer pagecolumnid) {
        this.pagecolumnid = pagecolumnid;
    }

    public String getPostionname() {
        return postionname;
    }

    public void setPostionname(String postionname) {
        this.postionname = postionname == null ? null : postionname.trim();
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

    public Integer getRelationtype() {
        return relationtype;
    }

    public void setRelationtype(Integer relationtype) {
        this.relationtype = relationtype;
    }

    public Integer getRelationid() {
        return relationid;
    }

    public void setRelationid(Integer relationid) {
        this.relationid = relationid;
    }
}