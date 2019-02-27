package com.jy.entiy.function.enterprise.enterpriseFunction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppraisaManageViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppraisaManageViewExample() {
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

        public Criteria andEnterpriseappraiseidIsNull() {
            addCriterion("EnterpriseAppraiseID is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidIsNotNull() {
            addCriterion("EnterpriseAppraiseID is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidEqualTo(Long value) {
            addCriterion("EnterpriseAppraiseID =", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidNotEqualTo(Long value) {
            addCriterion("EnterpriseAppraiseID <>", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidGreaterThan(Long value) {
            addCriterion("EnterpriseAppraiseID >", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidGreaterThanOrEqualTo(Long value) {
            addCriterion("EnterpriseAppraiseID >=", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidLessThan(Long value) {
            addCriterion("EnterpriseAppraiseID <", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidLessThanOrEqualTo(Long value) {
            addCriterion("EnterpriseAppraiseID <=", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidIn(List<Long> values) {
            addCriterion("EnterpriseAppraiseID in", values, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidNotIn(List<Long> values) {
            addCriterion("EnterpriseAppraiseID not in", values, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidBetween(Long value1, Long value2) {
            addCriterion("EnterpriseAppraiseID between", value1, value2, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidNotBetween(Long value1, Long value2) {
            addCriterion("EnterpriseAppraiseID not between", value1, value2, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailIsNull() {
            addCriterion("AppraiseDetail is null");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailIsNotNull() {
            addCriterion("AppraiseDetail is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailEqualTo(String value) {
            addCriterion("AppraiseDetail =", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailNotEqualTo(String value) {
            addCriterion("AppraiseDetail <>", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailGreaterThan(String value) {
            addCriterion("AppraiseDetail >", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailGreaterThanOrEqualTo(String value) {
            addCriterion("AppraiseDetail >=", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailLessThan(String value) {
            addCriterion("AppraiseDetail <", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailLessThanOrEqualTo(String value) {
            addCriterion("AppraiseDetail <=", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailLike(String value) {
            addCriterion("AppraiseDetail like", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailNotLike(String value) {
            addCriterion("AppraiseDetail not like", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailIn(List<String> values) {
            addCriterion("AppraiseDetail in", values, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailNotIn(List<String> values) {
            addCriterion("AppraiseDetail not in", values, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailBetween(String value1, String value2) {
            addCriterion("AppraiseDetail between", value1, value2, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailNotBetween(String value1, String value2) {
            addCriterion("AppraiseDetail not between", value1, value2, "appraisedetail");
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

        public Criteria andJobtitleIsNull() {
            addCriterion("JobTitle is null");
            return (Criteria) this;
        }

        public Criteria andJobtitleIsNotNull() {
            addCriterion("JobTitle is not null");
            return (Criteria) this;
        }

        public Criteria andJobtitleEqualTo(String value) {
            addCriterion("JobTitle =", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotEqualTo(String value) {
            addCriterion("JobTitle <>", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleGreaterThan(String value) {
            addCriterion("JobTitle >", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleGreaterThanOrEqualTo(String value) {
            addCriterion("JobTitle >=", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleLessThan(String value) {
            addCriterion("JobTitle <", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleLessThanOrEqualTo(String value) {
            addCriterion("JobTitle <=", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleLike(String value) {
            addCriterion("JobTitle like", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotLike(String value) {
            addCriterion("JobTitle not like", value, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleIn(List<String> values) {
            addCriterion("JobTitle in", values, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotIn(List<String> values) {
            addCriterion("JobTitle not in", values, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleBetween(String value1, String value2) {
            addCriterion("JobTitle between", value1, value2, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andJobtitleNotBetween(String value1, String value2) {
            addCriterion("JobTitle not between", value1, value2, "jobtitle");
            return (Criteria) this;
        }

        public Criteria andInductiondateIsNull() {
            addCriterion("InductionDate is null");
            return (Criteria) this;
        }

        public Criteria andInductiondateIsNotNull() {
            addCriterion("InductionDate is not null");
            return (Criteria) this;
        }

        public Criteria andInductiondateEqualTo(Date value) {
            addCriterion("InductionDate =", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateNotEqualTo(Date value) {
            addCriterion("InductionDate <>", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateGreaterThan(Date value) {
            addCriterion("InductionDate >", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateGreaterThanOrEqualTo(Date value) {
            addCriterion("InductionDate >=", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateLessThan(Date value) {
            addCriterion("InductionDate <", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateLessThanOrEqualTo(Date value) {
            addCriterion("InductionDate <=", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateIn(List<Date> values) {
            addCriterion("InductionDate in", values, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateNotIn(List<Date> values) {
            addCriterion("InductionDate not in", values, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateBetween(Date value1, Date value2) {
            addCriterion("InductionDate between", value1, value2, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateNotBetween(Date value1, Date value2) {
            addCriterion("InductionDate not between", value1, value2, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIsNull() {
            addCriterion("EnterpriseName is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIsNotNull() {
            addCriterion("EnterpriseName is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameEqualTo(String value) {
            addCriterion("EnterpriseName =", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotEqualTo(String value) {
            addCriterion("EnterpriseName <>", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameGreaterThan(String value) {
            addCriterion("EnterpriseName >", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameGreaterThanOrEqualTo(String value) {
            addCriterion("EnterpriseName >=", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLessThan(String value) {
            addCriterion("EnterpriseName <", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLessThanOrEqualTo(String value) {
            addCriterion("EnterpriseName <=", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLike(String value) {
            addCriterion("EnterpriseName like", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotLike(String value) {
            addCriterion("EnterpriseName not like", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIn(List<String> values) {
            addCriterion("EnterpriseName in", values, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotIn(List<String> values) {
            addCriterion("EnterpriseName not in", values, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameBetween(String value1, String value2) {
            addCriterion("EnterpriseName between", value1, value2, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotBetween(String value1, String value2) {
            addCriterion("EnterpriseName not between", value1, value2, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeIsNull() {
            addCriterion("AppraiseTime is null");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeIsNotNull() {
            addCriterion("AppraiseTime is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeEqualTo(Date value) {
            addCriterion("AppraiseTime =", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeNotEqualTo(Date value) {
            addCriterion("AppraiseTime <>", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeGreaterThan(Date value) {
            addCriterion("AppraiseTime >", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AppraiseTime >=", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeLessThan(Date value) {
            addCriterion("AppraiseTime <", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeLessThanOrEqualTo(Date value) {
            addCriterion("AppraiseTime <=", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeIn(List<Date> values) {
            addCriterion("AppraiseTime in", values, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeNotIn(List<Date> values) {
            addCriterion("AppraiseTime not in", values, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeBetween(Date value1, Date value2) {
            addCriterion("AppraiseTime between", value1, value2, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeNotBetween(Date value1, Date value2) {
            addCriterion("AppraiseTime not between", value1, value2, "appraisetime");
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