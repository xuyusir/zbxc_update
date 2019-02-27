package com.jy.entiy.function.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkexpirenceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkexpirenceExample() {
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

        public Criteria andWorkexpirenceidIsNull() {
            addCriterion("WorkExpirenceID is null");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidIsNotNull() {
            addCriterion("WorkExpirenceID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidEqualTo(Long value) {
            addCriterion("WorkExpirenceID =", value, "workexpirenceid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidNotEqualTo(Long value) {
            addCriterion("WorkExpirenceID <>", value, "workexpirenceid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidGreaterThan(Long value) {
            addCriterion("WorkExpirenceID >", value, "workexpirenceid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidGreaterThanOrEqualTo(Long value) {
            addCriterion("WorkExpirenceID >=", value, "workexpirenceid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidLessThan(Long value) {
            addCriterion("WorkExpirenceID <", value, "workexpirenceid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidLessThanOrEqualTo(Long value) {
            addCriterion("WorkExpirenceID <=", value, "workexpirenceid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidIn(List<Long> values) {
            addCriterion("WorkExpirenceID in", values, "workexpirenceid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidNotIn(List<Long> values) {
            addCriterion("WorkExpirenceID not in", values, "workexpirenceid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidBetween(Long value1, Long value2) {
            addCriterion("WorkExpirenceID between", value1, value2, "workexpirenceid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirenceidNotBetween(Long value1, Long value2) {
            addCriterion("WorkExpirenceID not between", value1, value2, "workexpirenceid");
            return (Criteria) this;
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

        public Criteria andCompanyscaleidIsNull() {
            addCriterion("CompanyScaleID is null");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidIsNotNull() {
            addCriterion("CompanyScaleID is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidEqualTo(Integer value) {
            addCriterion("CompanyScaleID =", value, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidNotEqualTo(Integer value) {
            addCriterion("CompanyScaleID <>", value, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidGreaterThan(Integer value) {
            addCriterion("CompanyScaleID >", value, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CompanyScaleID >=", value, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidLessThan(Integer value) {
            addCriterion("CompanyScaleID <", value, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidLessThanOrEqualTo(Integer value) {
            addCriterion("CompanyScaleID <=", value, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidIn(List<Integer> values) {
            addCriterion("CompanyScaleID in", values, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidNotIn(List<Integer> values) {
            addCriterion("CompanyScaleID not in", values, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidBetween(Integer value1, Integer value2) {
            addCriterion("CompanyScaleID between", value1, value2, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andCompanyscaleidNotBetween(Integer value1, Integer value2) {
            addCriterion("CompanyScaleID not between", value1, value2, "companyscaleid");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleIsNull() {
            addCriterion("WorkExpirenceTitle is null");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleIsNotNull() {
            addCriterion("WorkExpirenceTitle is not null");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleEqualTo(String value) {
            addCriterion("WorkExpirenceTitle =", value, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleNotEqualTo(String value) {
            addCriterion("WorkExpirenceTitle <>", value, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleGreaterThan(String value) {
            addCriterion("WorkExpirenceTitle >", value, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleGreaterThanOrEqualTo(String value) {
            addCriterion("WorkExpirenceTitle >=", value, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleLessThan(String value) {
            addCriterion("WorkExpirenceTitle <", value, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleLessThanOrEqualTo(String value) {
            addCriterion("WorkExpirenceTitle <=", value, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleLike(String value) {
            addCriterion("WorkExpirenceTitle like", value, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleNotLike(String value) {
            addCriterion("WorkExpirenceTitle not like", value, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleIn(List<String> values) {
            addCriterion("WorkExpirenceTitle in", values, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleNotIn(List<String> values) {
            addCriterion("WorkExpirenceTitle not in", values, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleBetween(String value1, String value2) {
            addCriterion("WorkExpirenceTitle between", value1, value2, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andWorkexpirencetitleNotBetween(String value1, String value2) {
            addCriterion("WorkExpirenceTitle not between", value1, value2, "workexpirencetitle");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("Company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("Company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("Company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("Company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("Company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("Company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("Company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("Company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("Company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("Company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("Company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("Company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("Company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("Company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateIsNull() {
            addCriterion("WorkStartDate is null");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateIsNotNull() {
            addCriterion("WorkStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateEqualTo(Date value) {
            addCriterion("WorkStartDate =", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateNotEqualTo(Date value) {
            addCriterion("WorkStartDate <>", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateGreaterThan(Date value) {
            addCriterion("WorkStartDate >", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("WorkStartDate >=", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateLessThan(Date value) {
            addCriterion("WorkStartDate <", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateLessThanOrEqualTo(Date value) {
            addCriterion("WorkStartDate <=", value, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateIn(List<Date> values) {
            addCriterion("WorkStartDate in", values, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateNotIn(List<Date> values) {
            addCriterion("WorkStartDate not in", values, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateBetween(Date value1, Date value2) {
            addCriterion("WorkStartDate between", value1, value2, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkstartdateNotBetween(Date value1, Date value2) {
            addCriterion("WorkStartDate not between", value1, value2, "workstartdate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateIsNull() {
            addCriterion("WorkEndDate is null");
            return (Criteria) this;
        }

        public Criteria andWorkenddateIsNotNull() {
            addCriterion("WorkEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andWorkenddateEqualTo(Date value) {
            addCriterion("WorkEndDate =", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateNotEqualTo(Date value) {
            addCriterion("WorkEndDate <>", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateGreaterThan(Date value) {
            addCriterion("WorkEndDate >", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("WorkEndDate >=", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateLessThan(Date value) {
            addCriterion("WorkEndDate <", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateLessThanOrEqualTo(Date value) {
            addCriterion("WorkEndDate <=", value, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateIn(List<Date> values) {
            addCriterion("WorkEndDate in", values, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateNotIn(List<Date> values) {
            addCriterion("WorkEndDate not in", values, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateBetween(Date value1, Date value2) {
            addCriterion("WorkEndDate between", value1, value2, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkenddateNotBetween(Date value1, Date value2) {
            addCriterion("WorkEndDate not between", value1, value2, "workenddate");
            return (Criteria) this;
        }

        public Criteria andWorkroleIsNull() {
            addCriterion("WorkRole is null");
            return (Criteria) this;
        }

        public Criteria andWorkroleIsNotNull() {
            addCriterion("WorkRole is not null");
            return (Criteria) this;
        }

        public Criteria andWorkroleEqualTo(String value) {
            addCriterion("WorkRole =", value, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleNotEqualTo(String value) {
            addCriterion("WorkRole <>", value, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleGreaterThan(String value) {
            addCriterion("WorkRole >", value, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleGreaterThanOrEqualTo(String value) {
            addCriterion("WorkRole >=", value, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleLessThan(String value) {
            addCriterion("WorkRole <", value, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleLessThanOrEqualTo(String value) {
            addCriterion("WorkRole <=", value, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleLike(String value) {
            addCriterion("WorkRole like", value, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleNotLike(String value) {
            addCriterion("WorkRole not like", value, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleIn(List<String> values) {
            addCriterion("WorkRole in", values, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleNotIn(List<String> values) {
            addCriterion("WorkRole not in", values, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleBetween(String value1, String value2) {
            addCriterion("WorkRole between", value1, value2, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkroleNotBetween(String value1, String value2) {
            addCriterion("WorkRole not between", value1, value2, "workrole");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityIsNull() {
            addCriterion("WorkResponsiblility is null");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityIsNotNull() {
            addCriterion("WorkResponsiblility is not null");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityEqualTo(String value) {
            addCriterion("WorkResponsiblility =", value, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityNotEqualTo(String value) {
            addCriterion("WorkResponsiblility <>", value, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityGreaterThan(String value) {
            addCriterion("WorkResponsiblility >", value, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityGreaterThanOrEqualTo(String value) {
            addCriterion("WorkResponsiblility >=", value, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityLessThan(String value) {
            addCriterion("WorkResponsiblility <", value, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityLessThanOrEqualTo(String value) {
            addCriterion("WorkResponsiblility <=", value, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityLike(String value) {
            addCriterion("WorkResponsiblility like", value, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityNotLike(String value) {
            addCriterion("WorkResponsiblility not like", value, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityIn(List<String> values) {
            addCriterion("WorkResponsiblility in", values, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityNotIn(List<String> values) {
            addCriterion("WorkResponsiblility not in", values, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityBetween(String value1, String value2) {
            addCriterion("WorkResponsiblility between", value1, value2, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkresponsiblilityNotBetween(String value1, String value2) {
            addCriterion("WorkResponsiblility not between", value1, value2, "workresponsiblility");
            return (Criteria) this;
        }

        public Criteria andWorkachievementIsNull() {
            addCriterion("WorkAchievement is null");
            return (Criteria) this;
        }

        public Criteria andWorkachievementIsNotNull() {
            addCriterion("WorkAchievement is not null");
            return (Criteria) this;
        }

        public Criteria andWorkachievementEqualTo(String value) {
            addCriterion("WorkAchievement =", value, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementNotEqualTo(String value) {
            addCriterion("WorkAchievement <>", value, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementGreaterThan(String value) {
            addCriterion("WorkAchievement >", value, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementGreaterThanOrEqualTo(String value) {
            addCriterion("WorkAchievement >=", value, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementLessThan(String value) {
            addCriterion("WorkAchievement <", value, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementLessThanOrEqualTo(String value) {
            addCriterion("WorkAchievement <=", value, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementLike(String value) {
            addCriterion("WorkAchievement like", value, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementNotLike(String value) {
            addCriterion("WorkAchievement not like", value, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementIn(List<String> values) {
            addCriterion("WorkAchievement in", values, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementNotIn(List<String> values) {
            addCriterion("WorkAchievement not in", values, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementBetween(String value1, String value2) {
            addCriterion("WorkAchievement between", value1, value2, "workachievement");
            return (Criteria) this;
        }

        public Criteria andWorkachievementNotBetween(String value1, String value2) {
            addCriterion("WorkAchievement not between", value1, value2, "workachievement");
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