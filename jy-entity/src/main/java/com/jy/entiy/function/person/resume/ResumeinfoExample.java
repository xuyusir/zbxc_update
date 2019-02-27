package com.jy.entiy.function.person.resume;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResumeinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResumeinfoExample() {
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

        public Criteria andResumeidIsNull() {
            addCriterion("ResumeID is null");
            return (Criteria) this;
        }

        public Criteria andResumeidIsNotNull() {
            addCriterion("ResumeID is not null");
            return (Criteria) this;
        }

        public Criteria andResumeidEqualTo(Long value) {
            addCriterion("ResumeID =", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidNotEqualTo(Long value) {
            addCriterion("ResumeID <>", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidGreaterThan(Long value) {
            addCriterion("ResumeID >", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidGreaterThanOrEqualTo(Long value) {
            addCriterion("ResumeID >=", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidLessThan(Long value) {
            addCriterion("ResumeID <", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidLessThanOrEqualTo(Long value) {
            addCriterion("ResumeID <=", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidIn(List<Long> values) {
            addCriterion("ResumeID in", values, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidNotIn(List<Long> values) {
            addCriterion("ResumeID not in", values, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidBetween(Long value1, Long value2) {
            addCriterion("ResumeID between", value1, value2, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidNotBetween(Long value1, Long value2) {
            addCriterion("ResumeID not between", value1, value2, "resumeid");
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

        public Criteria andResumecodeIsNull() {
            addCriterion("ResumeCode is null");
            return (Criteria) this;
        }

        public Criteria andResumecodeIsNotNull() {
            addCriterion("ResumeCode is not null");
            return (Criteria) this;
        }

        public Criteria andResumecodeEqualTo(String value) {
            addCriterion("ResumeCode =", value, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeNotEqualTo(String value) {
            addCriterion("ResumeCode <>", value, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeGreaterThan(String value) {
            addCriterion("ResumeCode >", value, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeGreaterThanOrEqualTo(String value) {
            addCriterion("ResumeCode >=", value, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeLessThan(String value) {
            addCriterion("ResumeCode <", value, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeLessThanOrEqualTo(String value) {
            addCriterion("ResumeCode <=", value, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeLike(String value) {
            addCriterion("ResumeCode like", value, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeNotLike(String value) {
            addCriterion("ResumeCode not like", value, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeIn(List<String> values) {
            addCriterion("ResumeCode in", values, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeNotIn(List<String> values) {
            addCriterion("ResumeCode not in", values, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeBetween(String value1, String value2) {
            addCriterion("ResumeCode between", value1, value2, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumecodeNotBetween(String value1, String value2) {
            addCriterion("ResumeCode not between", value1, value2, "resumecode");
            return (Criteria) this;
        }

        public Criteria andResumetitleIsNull() {
            addCriterion("ResumeTitle is null");
            return (Criteria) this;
        }

        public Criteria andResumetitleIsNotNull() {
            addCriterion("ResumeTitle is not null");
            return (Criteria) this;
        }

        public Criteria andResumetitleEqualTo(String value) {
            addCriterion("ResumeTitle =", value, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleNotEqualTo(String value) {
            addCriterion("ResumeTitle <>", value, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleGreaterThan(String value) {
            addCriterion("ResumeTitle >", value, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleGreaterThanOrEqualTo(String value) {
            addCriterion("ResumeTitle >=", value, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleLessThan(String value) {
            addCriterion("ResumeTitle <", value, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleLessThanOrEqualTo(String value) {
            addCriterion("ResumeTitle <=", value, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleLike(String value) {
            addCriterion("ResumeTitle like", value, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleNotLike(String value) {
            addCriterion("ResumeTitle not like", value, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleIn(List<String> values) {
            addCriterion("ResumeTitle in", values, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleNotIn(List<String> values) {
            addCriterion("ResumeTitle not in", values, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleBetween(String value1, String value2) {
            addCriterion("ResumeTitle between", value1, value2, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumetitleNotBetween(String value1, String value2) {
            addCriterion("ResumeTitle not between", value1, value2, "resumetitle");
            return (Criteria) this;
        }

        public Criteria andResumenameIsNull() {
            addCriterion("ResumeName is null");
            return (Criteria) this;
        }

        public Criteria andResumenameIsNotNull() {
            addCriterion("ResumeName is not null");
            return (Criteria) this;
        }

        public Criteria andResumenameEqualTo(String value) {
            addCriterion("ResumeName =", value, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameNotEqualTo(String value) {
            addCriterion("ResumeName <>", value, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameGreaterThan(String value) {
            addCriterion("ResumeName >", value, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameGreaterThanOrEqualTo(String value) {
            addCriterion("ResumeName >=", value, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameLessThan(String value) {
            addCriterion("ResumeName <", value, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameLessThanOrEqualTo(String value) {
            addCriterion("ResumeName <=", value, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameLike(String value) {
            addCriterion("ResumeName like", value, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameNotLike(String value) {
            addCriterion("ResumeName not like", value, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameIn(List<String> values) {
            addCriterion("ResumeName in", values, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameNotIn(List<String> values) {
            addCriterion("ResumeName not in", values, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameBetween(String value1, String value2) {
            addCriterion("ResumeName between", value1, value2, "resumename");
            return (Criteria) this;
        }

        public Criteria andResumenameNotBetween(String value1, String value2) {
            addCriterion("ResumeName not between", value1, value2, "resumename");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("Sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("Sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("Sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("Sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("Sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("Sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("Sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("Sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("Sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("Sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("Sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("Sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("Sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("Sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateIsNull() {
            addCriterion("ExpectJobStartDate is null");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateIsNotNull() {
            addCriterion("ExpectJobStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateEqualTo(Date value) {
            addCriterion("ExpectJobStartDate =", value, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateNotEqualTo(Date value) {
            addCriterion("ExpectJobStartDate <>", value, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateGreaterThan(Date value) {
            addCriterion("ExpectJobStartDate >", value, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("ExpectJobStartDate >=", value, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateLessThan(Date value) {
            addCriterion("ExpectJobStartDate <", value, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateLessThanOrEqualTo(Date value) {
            addCriterion("ExpectJobStartDate <=", value, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateIn(List<Date> values) {
            addCriterion("ExpectJobStartDate in", values, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateNotIn(List<Date> values) {
            addCriterion("ExpectJobStartDate not in", values, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateBetween(Date value1, Date value2) {
            addCriterion("ExpectJobStartDate between", value1, value2, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobstartdateNotBetween(Date value1, Date value2) {
            addCriterion("ExpectJobStartDate not between", value1, value2, "expectjobstartdate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateIsNull() {
            addCriterion("ExpectJobEndDate is null");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateIsNotNull() {
            addCriterion("ExpectJobEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateEqualTo(Date value) {
            addCriterion("ExpectJobEndDate =", value, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateNotEqualTo(Date value) {
            addCriterion("ExpectJobEndDate <>", value, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateGreaterThan(Date value) {
            addCriterion("ExpectJobEndDate >", value, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("ExpectJobEndDate >=", value, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateLessThan(Date value) {
            addCriterion("ExpectJobEndDate <", value, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateLessThanOrEqualTo(Date value) {
            addCriterion("ExpectJobEndDate <=", value, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateIn(List<Date> values) {
            addCriterion("ExpectJobEndDate in", values, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateNotIn(List<Date> values) {
            addCriterion("ExpectJobEndDate not in", values, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateBetween(Date value1, Date value2) {
            addCriterion("ExpectJobEndDate between", value1, value2, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andExpectjobenddateNotBetween(Date value1, Date value2) {
            addCriterion("ExpectJobEndDate not between", value1, value2, "expectjobenddate");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("Age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("Age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("Age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("Age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("Age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("Age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("Age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("Age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("Age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("Age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("Age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andEducationidIsNull() {
            addCriterion("EducationID is null");
            return (Criteria) this;
        }

        public Criteria andEducationidIsNotNull() {
            addCriterion("EducationID is not null");
            return (Criteria) this;
        }

        public Criteria andEducationidEqualTo(Integer value) {
            addCriterion("EducationID =", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidNotEqualTo(Integer value) {
            addCriterion("EducationID <>", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidGreaterThan(Integer value) {
            addCriterion("EducationID >", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EducationID >=", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidLessThan(Integer value) {
            addCriterion("EducationID <", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidLessThanOrEqualTo(Integer value) {
            addCriterion("EducationID <=", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidIn(List<Integer> values) {
            addCriterion("EducationID in", values, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidNotIn(List<Integer> values) {
            addCriterion("EducationID not in", values, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidBetween(Integer value1, Integer value2) {
            addCriterion("EducationID between", value1, value2, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidNotBetween(Integer value1, Integer value2) {
            addCriterion("EducationID not between", value1, value2, "educationid");
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

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andUniversityIsNull() {
            addCriterion("University is null");
            return (Criteria) this;
        }

        public Criteria andUniversityIsNotNull() {
            addCriterion("University is not null");
            return (Criteria) this;
        }

        public Criteria andUniversityEqualTo(String value) {
            addCriterion("University =", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotEqualTo(String value) {
            addCriterion("University <>", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThan(String value) {
            addCriterion("University >", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThanOrEqualTo(String value) {
            addCriterion("University >=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThan(String value) {
            addCriterion("University <", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThanOrEqualTo(String value) {
            addCriterion("University <=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLike(String value) {
            addCriterion("University like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotLike(String value) {
            addCriterion("University not like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityIn(List<String> values) {
            addCriterion("University in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotIn(List<String> values) {
            addCriterion("University not in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityBetween(String value1, String value2) {
            addCriterion("University between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotBetween(String value1, String value2) {
            addCriterion("University not between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNull() {
            addCriterion("Specialty is null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNotNull() {
            addCriterion("Specialty is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyEqualTo(String value) {
            addCriterion("Specialty =", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotEqualTo(String value) {
            addCriterion("Specialty <>", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThan(String value) {
            addCriterion("Specialty >", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("Specialty >=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThan(String value) {
            addCriterion("Specialty <", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("Specialty <=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLike(String value) {
            addCriterion("Specialty like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotLike(String value) {
            addCriterion("Specialty not like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIn(List<String> values) {
            addCriterion("Specialty in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotIn(List<String> values) {
            addCriterion("Specialty not in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyBetween(String value1, String value2) {
            addCriterion("Specialty between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotBetween(String value1, String value2) {
            addCriterion("Specialty not between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("Grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("Grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("Grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("Grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("Grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("Grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("Grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("Grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("Grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("Grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("Grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("Grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("Grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("Grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("Score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("Score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Double value) {
            addCriterion("Score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("Score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("Score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("Score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Double value) {
            addCriterion("Score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("Score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Double> values) {
            addCriterion("Score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("Score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("Score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("Score not between", value1, value2, "score");
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

        public Criteria andPhotoIsNull() {
            addCriterion("Photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("Photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(Long value) {
            addCriterion("Photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(Long value) {
            addCriterion("Photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(Long value) {
            addCriterion("Photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(Long value) {
            addCriterion("Photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(Long value) {
            addCriterion("Photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(Long value) {
            addCriterion("Photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<Long> values) {
            addCriterion("Photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<Long> values) {
            addCriterion("Photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(Long value1, Long value2) {
            addCriterion("Photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(Long value1, Long value2) {
            addCriterion("Photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("Year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("Year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("Year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("Year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("Year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("Year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("Year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("Year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("Year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("Year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("Year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("Year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("Month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("Month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("Month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("Month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("Month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("Month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("Month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("Month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("Month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("Month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("Month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("Month not between", value1, value2, "month");
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