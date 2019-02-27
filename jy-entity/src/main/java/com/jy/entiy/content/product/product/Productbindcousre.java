package com.jy.entiy.content.product.product;

public class Productbindcousre {
    private Long prouctbindcourseid;

    private Long productid;

    private Long courseid;

    private Integer validdays;

    private String lectureattachmentpath;

    private String lectureattachmentname;

    private String lectureattachmenttype;

    private String isauditpassed;

    private String auditcomment;

    private String auditor;

    public Long getProuctbindcourseid() {
        return prouctbindcourseid;
    }

    public void setProuctbindcourseid(Long prouctbindcourseid) {
        this.prouctbindcourseid = prouctbindcourseid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public Integer getValiddays() {
        return validdays;
    }

    public void setValiddays(Integer validdays) {
        this.validdays = validdays;
    }

    public String getLectureattachmentpath() {
        return lectureattachmentpath;
    }

    public void setLectureattachmentpath(String lectureattachmentpath) {
        this.lectureattachmentpath = lectureattachmentpath == null ? null : lectureattachmentpath.trim();
    }

    public String getLectureattachmentname() {
        return lectureattachmentname;
    }

    public void setLectureattachmentname(String lectureattachmentname) {
        this.lectureattachmentname = lectureattachmentname == null ? null : lectureattachmentname.trim();
    }

    public String getLectureattachmenttype() {
        return lectureattachmenttype;
    }

    public void setLectureattachmenttype(String lectureattachmenttype) {
        this.lectureattachmenttype = lectureattachmenttype == null ? null : lectureattachmenttype.trim();
    }

    public String getIsauditpassed() {
        return isauditpassed;
    }

    public void setIsauditpassed(String isauditpassed) {
        this.isauditpassed = isauditpassed == null ? null : isauditpassed.trim();
    }

    public String getAuditcomment() {
        return auditcomment;
    }

    public void setAuditcomment(String auditcomment) {
        this.auditcomment = auditcomment == null ? null : auditcomment.trim();
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }
}