package com.jy.entiy.function.person.resume;

import java.util.Date;

public class Resumeinfo {
    private Long resumeid;

    private Long accountid;

    private String resumecode;

    private String resumetitle;

    private String resumename;

    private String sex;

    private Date expectjobstartdate;

    private Date expectjobenddate;

    private Integer age;

    private Integer educationid;

    private String phone;

    private String email;

    private String university;

    private String specialty;

    private String grade;

    private Double score;

    private String createby;

    private Date createtime;

    private Long createpersonid;

    private String updateby;

    private Date updatetime;

    private Long updatepersonid;

    private Long photo;

    private Integer year;

    private Integer month;

    public Long getResumeid() {
        return resumeid;
    }

    public void setResumeid(Long resumeid) {
        this.resumeid = resumeid;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getResumecode() {
        return resumecode;
    }

    public void setResumecode(String resumecode) {
        this.resumecode = resumecode == null ? null : resumecode.trim();
    }

    public String getResumetitle() {
        return resumetitle;
    }

    public void setResumetitle(String resumetitle) {
        this.resumetitle = resumetitle == null ? null : resumetitle.trim();
    }

    public String getResumename() {
        return resumename;
    }

    public void setResumename(String resumename) {
        this.resumename = resumename == null ? null : resumename.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getExpectjobstartdate() {
        return expectjobstartdate;
    }

    public void setExpectjobstartdate(Date expectjobstartdate) {
        this.expectjobstartdate = expectjobstartdate;
    }

    public Date getExpectjobenddate() {
        return expectjobenddate;
    }

    public void setExpectjobenddate(Date expectjobenddate) {
        this.expectjobenddate = expectjobenddate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEducationid() {
        return educationid;
    }

    public void setEducationid(Integer educationid) {
        this.educationid = educationid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
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

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
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

    public Long getPhoto() {
        return photo;
    }

    public void setPhoto(Long photo) {
        this.photo = photo;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}