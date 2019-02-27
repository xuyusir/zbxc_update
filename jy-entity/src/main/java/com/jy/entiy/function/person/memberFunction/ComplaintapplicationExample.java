package com.jy.entiy.function.person.memberFunction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplaintapplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComplaintapplicationExample() {
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

        public Criteria andComplaintapplicationidIsNull() {
            addCriterion("ComplaintApplicationID is null");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidIsNotNull() {
            addCriterion("ComplaintApplicationID is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidEqualTo(Long value) {
            addCriterion("ComplaintApplicationID =", value, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidNotEqualTo(Long value) {
            addCriterion("ComplaintApplicationID <>", value, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidGreaterThan(Long value) {
            addCriterion("ComplaintApplicationID >", value, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidGreaterThanOrEqualTo(Long value) {
            addCriterion("ComplaintApplicationID >=", value, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidLessThan(Long value) {
            addCriterion("ComplaintApplicationID <", value, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidLessThanOrEqualTo(Long value) {
            addCriterion("ComplaintApplicationID <=", value, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidIn(List<Long> values) {
            addCriterion("ComplaintApplicationID in", values, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidNotIn(List<Long> values) {
            addCriterion("ComplaintApplicationID not in", values, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidBetween(Long value1, Long value2) {
            addCriterion("ComplaintApplicationID between", value1, value2, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andComplaintapplicationidNotBetween(Long value1, Long value2) {
            addCriterion("ComplaintApplicationID not between", value1, value2, "complaintapplicationid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidIsNull() {
            addCriterion("ApplicationStatusID is null");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidIsNotNull() {
            addCriterion("ApplicationStatusID is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidEqualTo(Integer value) {
            addCriterion("ApplicationStatusID =", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidNotEqualTo(Integer value) {
            addCriterion("ApplicationStatusID <>", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidGreaterThan(Integer value) {
            addCriterion("ApplicationStatusID >", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ApplicationStatusID >=", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidLessThan(Integer value) {
            addCriterion("ApplicationStatusID <", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidLessThanOrEqualTo(Integer value) {
            addCriterion("ApplicationStatusID <=", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidIn(List<Integer> values) {
            addCriterion("ApplicationStatusID in", values, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidNotIn(List<Integer> values) {
            addCriterion("ApplicationStatusID not in", values, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidBetween(Integer value1, Integer value2) {
            addCriterion("ApplicationStatusID between", value1, value2, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("ApplicationStatusID not between", value1, value2, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andComplaintnoIsNull() {
            addCriterion("ComplaintNo is null");
            return (Criteria) this;
        }

        public Criteria andComplaintnoIsNotNull() {
            addCriterion("ComplaintNo is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintnoEqualTo(String value) {
            addCriterion("ComplaintNo =", value, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoNotEqualTo(String value) {
            addCriterion("ComplaintNo <>", value, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoGreaterThan(String value) {
            addCriterion("ComplaintNo >", value, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoGreaterThanOrEqualTo(String value) {
            addCriterion("ComplaintNo >=", value, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoLessThan(String value) {
            addCriterion("ComplaintNo <", value, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoLessThanOrEqualTo(String value) {
            addCriterion("ComplaintNo <=", value, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoLike(String value) {
            addCriterion("ComplaintNo like", value, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoNotLike(String value) {
            addCriterion("ComplaintNo not like", value, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoIn(List<String> values) {
            addCriterion("ComplaintNo in", values, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoNotIn(List<String> values) {
            addCriterion("ComplaintNo not in", values, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoBetween(String value1, String value2) {
            addCriterion("ComplaintNo between", value1, value2, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintnoNotBetween(String value1, String value2) {
            addCriterion("ComplaintNo not between", value1, value2, "complaintno");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonIsNull() {
            addCriterion("ComplaintPerson is null");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonIsNotNull() {
            addCriterion("ComplaintPerson is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonEqualTo(String value) {
            addCriterion("ComplaintPerson =", value, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonNotEqualTo(String value) {
            addCriterion("ComplaintPerson <>", value, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonGreaterThan(String value) {
            addCriterion("ComplaintPerson >", value, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonGreaterThanOrEqualTo(String value) {
            addCriterion("ComplaintPerson >=", value, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonLessThan(String value) {
            addCriterion("ComplaintPerson <", value, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonLessThanOrEqualTo(String value) {
            addCriterion("ComplaintPerson <=", value, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonLike(String value) {
            addCriterion("ComplaintPerson like", value, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonNotLike(String value) {
            addCriterion("ComplaintPerson not like", value, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonIn(List<String> values) {
            addCriterion("ComplaintPerson in", values, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonNotIn(List<String> values) {
            addCriterion("ComplaintPerson not in", values, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonBetween(String value1, String value2) {
            addCriterion("ComplaintPerson between", value1, value2, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andComplaintpersonNotBetween(String value1, String value2) {
            addCriterion("ComplaintPerson not between", value1, value2, "complaintperson");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("Phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("Phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("Phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("Phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("Phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("Phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("Phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("Phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("Phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("Phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("Phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("Phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("Phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andComplainttimeIsNull() {
            addCriterion("ComplaintTime is null");
            return (Criteria) this;
        }

        public Criteria andComplainttimeIsNotNull() {
            addCriterion("ComplaintTime is not null");
            return (Criteria) this;
        }

        public Criteria andComplainttimeEqualTo(Date value) {
            addCriterion("ComplaintTime =", value, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttimeNotEqualTo(Date value) {
            addCriterion("ComplaintTime <>", value, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttimeGreaterThan(Date value) {
            addCriterion("ComplaintTime >", value, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ComplaintTime >=", value, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttimeLessThan(Date value) {
            addCriterion("ComplaintTime <", value, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttimeLessThanOrEqualTo(Date value) {
            addCriterion("ComplaintTime <=", value, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttimeIn(List<Date> values) {
            addCriterion("ComplaintTime in", values, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttimeNotIn(List<Date> values) {
            addCriterion("ComplaintTime not in", values, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttimeBetween(Date value1, Date value2) {
            addCriterion("ComplaintTime between", value1, value2, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttimeNotBetween(Date value1, Date value2) {
            addCriterion("ComplaintTime not between", value1, value2, "complainttime");
            return (Criteria) this;
        }

        public Criteria andComplainttargetIsNull() {
            addCriterion("ComplaintTarget is null");
            return (Criteria) this;
        }

        public Criteria andComplainttargetIsNotNull() {
            addCriterion("ComplaintTarget is not null");
            return (Criteria) this;
        }

        public Criteria andComplainttargetEqualTo(String value) {
            addCriterion("ComplaintTarget =", value, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetNotEqualTo(String value) {
            addCriterion("ComplaintTarget <>", value, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetGreaterThan(String value) {
            addCriterion("ComplaintTarget >", value, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetGreaterThanOrEqualTo(String value) {
            addCriterion("ComplaintTarget >=", value, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetLessThan(String value) {
            addCriterion("ComplaintTarget <", value, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetLessThanOrEqualTo(String value) {
            addCriterion("ComplaintTarget <=", value, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetLike(String value) {
            addCriterion("ComplaintTarget like", value, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetNotLike(String value) {
            addCriterion("ComplaintTarget not like", value, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetIn(List<String> values) {
            addCriterion("ComplaintTarget in", values, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetNotIn(List<String> values) {
            addCriterion("ComplaintTarget not in", values, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetBetween(String value1, String value2) {
            addCriterion("ComplaintTarget between", value1, value2, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplainttargetNotBetween(String value1, String value2) {
            addCriterion("ComplaintTarget not between", value1, value2, "complainttarget");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentIsNull() {
            addCriterion("ComplaintContent is null");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentIsNotNull() {
            addCriterion("ComplaintContent is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentEqualTo(String value) {
            addCriterion("ComplaintContent =", value, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentNotEqualTo(String value) {
            addCriterion("ComplaintContent <>", value, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentGreaterThan(String value) {
            addCriterion("ComplaintContent >", value, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentGreaterThanOrEqualTo(String value) {
            addCriterion("ComplaintContent >=", value, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentLessThan(String value) {
            addCriterion("ComplaintContent <", value, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentLessThanOrEqualTo(String value) {
            addCriterion("ComplaintContent <=", value, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentLike(String value) {
            addCriterion("ComplaintContent like", value, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentNotLike(String value) {
            addCriterion("ComplaintContent not like", value, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentIn(List<String> values) {
            addCriterion("ComplaintContent in", values, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentNotIn(List<String> values) {
            addCriterion("ComplaintContent not in", values, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentBetween(String value1, String value2) {
            addCriterion("ComplaintContent between", value1, value2, "complaintcontent");
            return (Criteria) this;
        }

        public Criteria andComplaintcontentNotBetween(String value1, String value2) {
            addCriterion("ComplaintContent not between", value1, value2, "complaintcontent");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNull() {
            addCriterion("CreateBy is null");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNotNull() {
            addCriterion("CreateBy is not null");
            return (Criteria) this;
        }

        public Criteria andCreatebyEqualTo(String value) {
            addCriterion("CreateBy =", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotEqualTo(String value) {
            addCriterion("CreateBy <>", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThan(String value) {
            addCriterion("CreateBy >", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThanOrEqualTo(String value) {
            addCriterion("CreateBy >=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThan(String value) {
            addCriterion("CreateBy <", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThanOrEqualTo(String value) {
            addCriterion("CreateBy <=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLike(String value) {
            addCriterion("CreateBy like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotLike(String value) {
            addCriterion("CreateBy not like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyIn(List<String> values) {
            addCriterion("CreateBy in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotIn(List<String> values) {
            addCriterion("CreateBy not in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyBetween(String value1, String value2) {
            addCriterion("CreateBy between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotBetween(String value1, String value2) {
            addCriterion("CreateBy not between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidIsNull() {
            addCriterion("CreatePersonID is null");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidIsNotNull() {
            addCriterion("CreatePersonID is not null");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidEqualTo(Long value) {
            addCriterion("CreatePersonID =", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidNotEqualTo(Long value) {
            addCriterion("CreatePersonID <>", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidGreaterThan(Long value) {
            addCriterion("CreatePersonID >", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidGreaterThanOrEqualTo(Long value) {
            addCriterion("CreatePersonID >=", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidLessThan(Long value) {
            addCriterion("CreatePersonID <", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidLessThanOrEqualTo(Long value) {
            addCriterion("CreatePersonID <=", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidIn(List<Long> values) {
            addCriterion("CreatePersonID in", values, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidNotIn(List<Long> values) {
            addCriterion("CreatePersonID not in", values, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidBetween(Long value1, Long value2) {
            addCriterion("CreatePersonID between", value1, value2, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidNotBetween(Long value1, Long value2) {
            addCriterion("CreatePersonID not between", value1, value2, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIsNull() {
            addCriterion("UpdateBy is null");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIsNotNull() {
            addCriterion("UpdateBy is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatebyEqualTo(String value) {
            addCriterion("UpdateBy =", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotEqualTo(String value) {
            addCriterion("UpdateBy <>", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyGreaterThan(String value) {
            addCriterion("UpdateBy >", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyGreaterThanOrEqualTo(String value) {
            addCriterion("UpdateBy >=", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLessThan(String value) {
            addCriterion("UpdateBy <", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLessThanOrEqualTo(String value) {
            addCriterion("UpdateBy <=", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLike(String value) {
            addCriterion("UpdateBy like", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotLike(String value) {
            addCriterion("UpdateBy not like", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIn(List<String> values) {
            addCriterion("UpdateBy in", values, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotIn(List<String> values) {
            addCriterion("UpdateBy not in", values, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyBetween(String value1, String value2) {
            addCriterion("UpdateBy between", value1, value2, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotBetween(String value1, String value2) {
            addCriterion("UpdateBy not between", value1, value2, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidIsNull() {
            addCriterion("UpdatePersonID is null");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidIsNotNull() {
            addCriterion("UpdatePersonID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidEqualTo(Long value) {
            addCriterion("UpdatePersonID =", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidNotEqualTo(Long value) {
            addCriterion("UpdatePersonID <>", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidGreaterThan(Long value) {
            addCriterion("UpdatePersonID >", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidGreaterThanOrEqualTo(Long value) {
            addCriterion("UpdatePersonID >=", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidLessThan(Long value) {
            addCriterion("UpdatePersonID <", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidLessThanOrEqualTo(Long value) {
            addCriterion("UpdatePersonID <=", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidIn(List<Long> values) {
            addCriterion("UpdatePersonID in", values, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidNotIn(List<Long> values) {
            addCriterion("UpdatePersonID not in", values, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidBetween(Long value1, Long value2) {
            addCriterion("UpdatePersonID between", value1, value2, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidNotBetween(Long value1, Long value2) {
            addCriterion("UpdatePersonID not between", value1, value2, "updatepersonid");
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