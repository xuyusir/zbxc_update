package com.jy.entiy.function.person.memberFunction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberServiceManageViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberServiceManageViewExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andServiceapplicationidIsNull() {
            addCriterion("ServiceApplicationID is null");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidIsNotNull() {
            addCriterion("ServiceApplicationID is not null");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidEqualTo(Long value) {
            addCriterion("ServiceApplicationID =", value, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidNotEqualTo(Long value) {
            addCriterion("ServiceApplicationID <>", value, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidGreaterThan(Long value) {
            addCriterion("ServiceApplicationID >", value, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidGreaterThanOrEqualTo(Long value) {
            addCriterion("ServiceApplicationID >=", value, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidLessThan(Long value) {
            addCriterion("ServiceApplicationID <", value, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidLessThanOrEqualTo(Long value) {
            addCriterion("ServiceApplicationID <=", value, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidIn(List<Long> values) {
            addCriterion("ServiceApplicationID in", values, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidNotIn(List<Long> values) {
            addCriterion("ServiceApplicationID not in", values, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidBetween(Long value1, Long value2) {
            addCriterion("ServiceApplicationID between", value1, value2, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andServiceapplicationidNotBetween(Long value1, Long value2) {
            addCriterion("ServiceApplicationID not between", value1, value2, "serviceapplicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIsNull() {
            addCriterion("ApplicationTime is null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIsNotNull() {
            addCriterion("ApplicationTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeEqualTo(Date value) {
            addCriterion("ApplicationTime =", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotEqualTo(Date value) {
            addCriterion("ApplicationTime <>", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThan(Date value) {
            addCriterion("ApplicationTime >", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ApplicationTime >=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThan(Date value) {
            addCriterion("ApplicationTime <", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThanOrEqualTo(Date value) {
            addCriterion("ApplicationTime <=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIn(List<Date> values) {
            addCriterion("ApplicationTime in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotIn(List<Date> values) {
            addCriterion("ApplicationTime not in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeBetween(Date value1, Date value2) {
            addCriterion("ApplicationTime between", value1, value2, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotBetween(Date value1, Date value2) {
            addCriterion("ApplicationTime not between", value1, value2, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andServicenoIsNull() {
            addCriterion("ServiceNo is null");
            return (Criteria) this;
        }

        public Criteria andServicenoIsNotNull() {
            addCriterion("ServiceNo is not null");
            return (Criteria) this;
        }

        public Criteria andServicenoEqualTo(String value) {
            addCriterion("ServiceNo =", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotEqualTo(String value) {
            addCriterion("ServiceNo <>", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoGreaterThan(String value) {
            addCriterion("ServiceNo >", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoGreaterThanOrEqualTo(String value) {
            addCriterion("ServiceNo >=", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoLessThan(String value) {
            addCriterion("ServiceNo <", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoLessThanOrEqualTo(String value) {
            addCriterion("ServiceNo <=", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoLike(String value) {
            addCriterion("ServiceNo like", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotLike(String value) {
            addCriterion("ServiceNo not like", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoIn(List<String> values) {
            addCriterion("ServiceNo in", values, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotIn(List<String> values) {
            addCriterion("ServiceNo not in", values, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoBetween(String value1, String value2) {
            addCriterion("ServiceNo between", value1, value2, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotBetween(String value1, String value2) {
            addCriterion("ServiceNo not between", value1, value2, "serviceno");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNull() {
            addCriterion("AccountID is null");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNotNull() {
            addCriterion("AccountID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountidEqualTo(Long value) {
            addCriterion("AccountID =", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotEqualTo(Long value) {
            addCriterion("AccountID <>", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThan(Long value) {
            addCriterion("AccountID >", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThanOrEqualTo(Long value) {
            addCriterion("AccountID >=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThan(Long value) {
            addCriterion("AccountID <", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThanOrEqualTo(Long value) {
            addCriterion("AccountID <=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidIn(List<Long> values) {
            addCriterion("AccountID in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotIn(List<Long> values) {
            addCriterion("AccountID not in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidBetween(Long value1, Long value2) {
            addCriterion("AccountID between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotBetween(Long value1, Long value2) {
            addCriterion("AccountID not between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andServicetypenameIsNull() {
            addCriterion("ServiceTypeName is null");
            return (Criteria) this;
        }

        public Criteria andServicetypenameIsNotNull() {
            addCriterion("ServiceTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypenameEqualTo(String value) {
            addCriterion("ServiceTypeName =", value, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameNotEqualTo(String value) {
            addCriterion("ServiceTypeName <>", value, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameGreaterThan(String value) {
            addCriterion("ServiceTypeName >", value, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameGreaterThanOrEqualTo(String value) {
            addCriterion("ServiceTypeName >=", value, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameLessThan(String value) {
            addCriterion("ServiceTypeName <", value, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameLessThanOrEqualTo(String value) {
            addCriterion("ServiceTypeName <=", value, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameLike(String value) {
            addCriterion("ServiceTypeName like", value, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameNotLike(String value) {
            addCriterion("ServiceTypeName not like", value, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameIn(List<String> values) {
            addCriterion("ServiceTypeName in", values, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameNotIn(List<String> values) {
            addCriterion("ServiceTypeName not in", values, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameBetween(String value1, String value2) {
            addCriterion("ServiceTypeName between", value1, value2, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andServicetypenameNotBetween(String value1, String value2) {
            addCriterion("ServiceTypeName not between", value1, value2, "servicetypename");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameIsNull() {
            addCriterion("ApplicationStatusName is null");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameIsNotNull() {
            addCriterion("ApplicationStatusName is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameEqualTo(String value) {
            addCriterion("ApplicationStatusName =", value, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameNotEqualTo(String value) {
            addCriterion("ApplicationStatusName <>", value, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameGreaterThan(String value) {
            addCriterion("ApplicationStatusName >", value, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameGreaterThanOrEqualTo(String value) {
            addCriterion("ApplicationStatusName >=", value, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameLessThan(String value) {
            addCriterion("ApplicationStatusName <", value, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameLessThanOrEqualTo(String value) {
            addCriterion("ApplicationStatusName <=", value, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameLike(String value) {
            addCriterion("ApplicationStatusName like", value, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameNotLike(String value) {
            addCriterion("ApplicationStatusName not like", value, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameIn(List<String> values) {
            addCriterion("ApplicationStatusName in", values, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameNotIn(List<String> values) {
            addCriterion("ApplicationStatusName not in", values, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameBetween(String value1, String value2) {
            addCriterion("ApplicationStatusName between", value1, value2, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusnameNotBetween(String value1, String value2) {
            addCriterion("ApplicationStatusName not between", value1, value2, "applicationstatusname");
            return (Criteria) this;
        }

        public Criteria andHandletimeIsNull() {
            addCriterion("HandleTime is null");
            return (Criteria) this;
        }

        public Criteria andHandletimeIsNotNull() {
            addCriterion("HandleTime is not null");
            return (Criteria) this;
        }

        public Criteria andHandletimeEqualTo(Date value) {
            addCriterion("HandleTime =", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeNotEqualTo(Date value) {
            addCriterion("HandleTime <>", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeGreaterThan(Date value) {
            addCriterion("HandleTime >", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeGreaterThanOrEqualTo(Date value) {
            addCriterion("HandleTime >=", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeLessThan(Date value) {
            addCriterion("HandleTime <", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeLessThanOrEqualTo(Date value) {
            addCriterion("HandleTime <=", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeIn(List<Date> values) {
            addCriterion("HandleTime in", values, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeNotIn(List<Date> values) {
            addCriterion("HandleTime not in", values, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeBetween(Date value1, Date value2) {
            addCriterion("HandleTime between", value1, value2, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeNotBetween(Date value1, Date value2) {
            addCriterion("HandleTime not between", value1, value2, "handletime");
            return (Criteria) this;
        }

        public Criteria andAppointteacherIsNull() {
            addCriterion("AppointTeacher is null");
            return (Criteria) this;
        }

        public Criteria andAppointteacherIsNotNull() {
            addCriterion("AppointTeacher is not null");
            return (Criteria) this;
        }

        public Criteria andAppointteacherEqualTo(String value) {
            addCriterion("AppointTeacher =", value, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherNotEqualTo(String value) {
            addCriterion("AppointTeacher <>", value, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherGreaterThan(String value) {
            addCriterion("AppointTeacher >", value, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherGreaterThanOrEqualTo(String value) {
            addCriterion("AppointTeacher >=", value, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherLessThan(String value) {
            addCriterion("AppointTeacher <", value, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherLessThanOrEqualTo(String value) {
            addCriterion("AppointTeacher <=", value, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherLike(String value) {
            addCriterion("AppointTeacher like", value, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherNotLike(String value) {
            addCriterion("AppointTeacher not like", value, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherIn(List<String> values) {
            addCriterion("AppointTeacher in", values, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherNotIn(List<String> values) {
            addCriterion("AppointTeacher not in", values, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherBetween(String value1, String value2) {
            addCriterion("AppointTeacher between", value1, value2, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointteacherNotBetween(String value1, String value2) {
            addCriterion("AppointTeacher not between", value1, value2, "appointteacher");
            return (Criteria) this;
        }

        public Criteria andAppointdateIsNull() {
            addCriterion("AppointDate is null");
            return (Criteria) this;
        }

        public Criteria andAppointdateIsNotNull() {
            addCriterion("AppointDate is not null");
            return (Criteria) this;
        }

        public Criteria andAppointdateEqualTo(Date value) {
            addCriterion("AppointDate =", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateNotEqualTo(Date value) {
            addCriterion("AppointDate <>", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateGreaterThan(Date value) {
            addCriterion("AppointDate >", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateGreaterThanOrEqualTo(Date value) {
            addCriterion("AppointDate >=", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateLessThan(Date value) {
            addCriterion("AppointDate <", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateLessThanOrEqualTo(Date value) {
            addCriterion("AppointDate <=", value, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateIn(List<Date> values) {
            addCriterion("AppointDate in", values, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateNotIn(List<Date> values) {
            addCriterion("AppointDate not in", values, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateBetween(Date value1, Date value2) {
            addCriterion("AppointDate between", value1, value2, "appointdate");
            return (Criteria) this;
        }

        public Criteria andAppointdateNotBetween(Date value1, Date value2) {
            addCriterion("AppointDate not between", value1, value2, "appointdate");
            return (Criteria) this;
        }

        public Criteria andTimephaseIsNull() {
            addCriterion("TimePhase is null");
            return (Criteria) this;
        }

        public Criteria andTimephaseIsNotNull() {
            addCriterion("TimePhase is not null");
            return (Criteria) this;
        }

        public Criteria andTimephaseEqualTo(String value) {
            addCriterion("TimePhase =", value, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseNotEqualTo(String value) {
            addCriterion("TimePhase <>", value, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseGreaterThan(String value) {
            addCriterion("TimePhase >", value, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseGreaterThanOrEqualTo(String value) {
            addCriterion("TimePhase >=", value, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseLessThan(String value) {
            addCriterion("TimePhase <", value, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseLessThanOrEqualTo(String value) {
            addCriterion("TimePhase <=", value, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseLike(String value) {
            addCriterion("TimePhase like", value, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseNotLike(String value) {
            addCriterion("TimePhase not like", value, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseIn(List<String> values) {
            addCriterion("TimePhase in", values, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseNotIn(List<String> values) {
            addCriterion("TimePhase not in", values, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseBetween(String value1, String value2) {
            addCriterion("TimePhase between", value1, value2, "timephase");
            return (Criteria) this;
        }

        public Criteria andTimephaseNotBetween(String value1, String value2) {
            addCriterion("TimePhase not between", value1, value2, "timephase");
            return (Criteria) this;
        }

        public Criteria andCoursetitleIsNull() {
            addCriterion("CourseTitle is null");
            return (Criteria) this;
        }

        public Criteria andCoursetitleIsNotNull() {
            addCriterion("CourseTitle is not null");
            return (Criteria) this;
        }

        public Criteria andCoursetitleEqualTo(String value) {
            addCriterion("CourseTitle =", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleNotEqualTo(String value) {
            addCriterion("CourseTitle <>", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleGreaterThan(String value) {
            addCriterion("CourseTitle >", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleGreaterThanOrEqualTo(String value) {
            addCriterion("CourseTitle >=", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleLessThan(String value) {
            addCriterion("CourseTitle <", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleLessThanOrEqualTo(String value) {
            addCriterion("CourseTitle <=", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleLike(String value) {
            addCriterion("CourseTitle like", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleNotLike(String value) {
            addCriterion("CourseTitle not like", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleIn(List<String> values) {
            addCriterion("CourseTitle in", values, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleNotIn(List<String> values) {
            addCriterion("CourseTitle not in", values, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleBetween(String value1, String value2) {
            addCriterion("CourseTitle between", value1, value2, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleNotBetween(String value1, String value2) {
            addCriterion("CourseTitle not between", value1, value2, "coursetitle");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}