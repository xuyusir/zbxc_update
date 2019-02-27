package com.jy.entiy.content.file.directory;

import java.util.Date;

public class Documentdirectory {
    private Long documentdirectoryid;

    private String directoryname;

    private String directorypath;

    private Long parentid;

    private Integer isparent;

    private Integer isnetworkdisk;

    private Date createtime;

    private String createby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;

    public Long getDocumentdirectoryid() {
        return documentdirectoryid;
    }

    public void setDocumentdirectoryid(Long documentdirectoryid) {
        this.documentdirectoryid = documentdirectoryid;
    }

    public String getDirectoryname() {
        return directoryname;
    }

    public void setDirectoryname(String directoryname) {
        this.directoryname = directoryname == null ? null : directoryname.trim();
    }

    public String getDirectorypath() {
        return directorypath;
    }

    public void setDirectorypath(String directorypath) {
        this.directorypath = directorypath == null ? null : directorypath.trim();
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getIsparent() {
        return isparent;
    }

    public void setIsparent(Integer isparent) {
        this.isparent = isparent;
    }

    public Integer getIsnetworkdisk() {
        return isnetworkdisk;
    }

    public void setIsnetworkdisk(Integer isnetworkdisk) {
        this.isnetworkdisk = isnetworkdisk;
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

	@Override
	public String toString() {
		return "Documentdirectory [documentdirectoryid=" + documentdirectoryid + ", directoryname=" + directoryname
				+ ", directorypath=" + directorypath + ", parentid=" + parentid + ", isparent=" + isparent
				+ ", isnetworkdisk=" + isnetworkdisk + ", createtime=" + createtime + ", createby=" + createby
				+ ", createpersonid=" + createpersonid + ", updatetime=" + updatetime + ", updateby=" + updateby
				+ ", updatepersonid=" + updatepersonid + "]";
	}
    
    
}