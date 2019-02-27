package com.jy.entiy.content.file.file;

import java.util.Date;

public class Fileinfo {
    private Long fileid;

    private String filename;

    private String filetype;

    private String filefullpath;

    private String filepath;

    private String filesize;

    private Long videotime;

    private Integer type;

    private Long documentdirectoryid;

    private Date createtime;

    private String createby;

    private Long createpersonid;

    private Date updatetime;

    private String updateby;

    private Long updatepersonid;
    
    private boolean use;

    public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

	public Long getFileid() {
        return fileid;
    }

    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getFilefullpath() {
        return filefullpath;
    }

    public void setFilefullpath(String filefullpath) {
        this.filefullpath = filefullpath == null ? null : filefullpath.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize == null ? null : filesize.trim();
    }

    public Long getVideotime() {
        return videotime;
    }

    public void setVideotime(Long videotime) {
        this.videotime = videotime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getDocumentdirectoryid() {
        return documentdirectoryid;
    }

    public void setDocumentdirectoryid(Long documentdirectoryid) {
        this.documentdirectoryid = documentdirectoryid;
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
		return "Fileinfo [fileid=" + fileid + ", filename=" + filename + ", filetype=" + filetype + ", filefullpath="
				+ filefullpath + ", filepath=" + filepath + ", filesize=" + filesize + ", videotime=" + videotime
				+ ", type=" + type + ", documentdirectoryid=" + documentdirectoryid + ", createtime=" + createtime
				+ ", createby=" + createby + ", createpersonid=" + createpersonid + ", updatetime=" + updatetime
				+ ", updateby=" + updateby + ", updatepersonid=" + updatepersonid + ", use=" + use + "]";
	}
    
    
}