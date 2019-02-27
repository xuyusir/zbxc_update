package com.jy.entiy.function.enterprise.enterpriseFunction;

import java.util.ArrayList;
import java.util.List;

public class TalentpoolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TalentpoolExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidIsNull() {
            addCriterion("EnterpriseID is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidIsNotNull() {
            addCriterion("EnterpriseID is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidEqualTo(Integer value) {
            addCriterion("EnterpriseID =", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidNotEqualTo(Integer value) {
            addCriterion("EnterpriseID <>", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidGreaterThan(Integer value) {
            addCriterion("EnterpriseID >", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EnterpriseID >=", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidLessThan(Integer value) {
            addCriterion("EnterpriseID <", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidLessThanOrEqualTo(Integer value) {
            addCriterion("EnterpriseID <=", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidIn(List<Integer> values) {
            addCriterion("EnterpriseID in", values, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidNotIn(List<Integer> values) {
            addCriterion("EnterpriseID not in", values, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidBetween(Integer value1, Integer value2) {
            addCriterion("EnterpriseID between", value1, value2, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidNotBetween(Integer value1, Integer value2) {
            addCriterion("EnterpriseID not between", value1, value2, "enterpriseid");
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

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
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

        public Criteria andCustomresumeidIsNull() {
            addCriterion("CustomResumeID is null");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidIsNotNull() {
            addCriterion("CustomResumeID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidEqualTo(Long value) {
            addCriterion("CustomResumeID =", value, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidNotEqualTo(Long value) {
            addCriterion("CustomResumeID <>", value, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidGreaterThan(Long value) {
            addCriterion("CustomResumeID >", value, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidGreaterThanOrEqualTo(Long value) {
            addCriterion("CustomResumeID >=", value, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidLessThan(Long value) {
            addCriterion("CustomResumeID <", value, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidLessThanOrEqualTo(Long value) {
            addCriterion("CustomResumeID <=", value, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidIn(List<Long> values) {
            addCriterion("CustomResumeID in", values, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidNotIn(List<Long> values) {
            addCriterion("CustomResumeID not in", values, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidBetween(Long value1, Long value2) {
            addCriterion("CustomResumeID between", value1, value2, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andCustomresumeidNotBetween(Long value1, Long value2) {
            addCriterion("CustomResumeID not between", value1, value2, "customresumeid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidIsNull() {
            addCriterion("TalentPoolApplicationID is null");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidIsNotNull() {
            addCriterion("TalentPoolApplicationID is not null");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidEqualTo(Integer value) {
            addCriterion("TalentPoolApplicationID =", value, "talentpoolapplicationid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidNotEqualTo(Integer value) {
            addCriterion("TalentPoolApplicationID <>", value, "talentpoolapplicationid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidGreaterThan(Integer value) {
            addCriterion("TalentPoolApplicationID >", value, "talentpoolapplicationid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TalentPoolApplicationID >=", value, "talentpoolapplicationid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidLessThan(Integer value) {
            addCriterion("TalentPoolApplicationID <", value, "talentpoolapplicationid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidLessThanOrEqualTo(Integer value) {
            addCriterion("TalentPoolApplicationID <=", value, "talentpoolapplicationid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidIn(List<Integer> values) {
            addCriterion("TalentPoolApplicationID in", values, "talentpoolapplicationid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidNotIn(List<Integer> values) {
            addCriterion("TalentPoolApplicationID not in", values, "talentpoolapplicationid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidBetween(Integer value1, Integer value2) {
            addCriterion("TalentPoolApplicationID between", value1, value2, "talentpoolapplicationid");
            return (Criteria) this;
        }

        public Criteria andTalentpoolapplicationidNotBetween(Integer value1, Integer value2) {
            addCriterion("TalentPoolApplicationID not between", value1, value2, "talentpoolapplicationid");
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