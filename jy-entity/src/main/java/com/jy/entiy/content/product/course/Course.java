package com.jy.entiy.content.product.course;

import java.util.Date;
import java.util.List;

import com.jy.entiy.content.file.file.Fileinfo;

public class Course {
    private Long courseid;

    private String coursetitle;

    private String courseabstract;

    private Date createtime;

    private Long createpersonid;

    private Date updatetime;

    private Long updatepersonid;

    private Long fileid;

    private Integer validdays;

    private Long image;

    private String teacher;
    //对应产品id
    private Long productID;
    //章列表
    private List<Coursechapter> coursechapters;
    
    //讲义
    private Fileinfo fileinfo;

    /**
	 * @return the fileinfo
	 */
	public Fileinfo getFileinfo() {
		return fileinfo;
	}

	/**
	 * @param fileinfo the fileinfo to set
	 */
	public void setFileinfo(Fileinfo fileinfo) {
		this.fileinfo = fileinfo;
	}

	/**
	 * @return the coursechapters
	 */
	public List<Coursechapter> getCoursechapters() {
		return coursechapters;
	}

	/**
	 * @param coursechapters the coursechapters to set
	 */
	public void setCoursechapters(List<Coursechapter> coursechapters) {
		this.coursechapters = coursechapters;
	}

	/**
	 * @return the productID
	 */
	public Long getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle == null ? null : coursetitle.trim();
    }

    public String getCourseabstract() {
        return courseabstract;
    }

    public void setCourseabstract(String courseabstract) {
        this.courseabstract = courseabstract == null ? null : courseabstract.trim();
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

    public Long getFileid() {
        return fileid;
    }

    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }

    public Integer getValiddays() {
        return validdays;
    }

    public void setValiddays(Integer validdays) {
        this.validdays = validdays;
    }

    public Long getImage() {
        return image;
    }

    public void setImage(Long image) {
        this.image = image;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }
}