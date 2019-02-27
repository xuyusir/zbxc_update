package com.jy.entiy.function.person;

import java.util.ArrayList;
import java.util.List;

public class CustomresumeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomresumeExample() {
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

        public Criteria andDocfileidIsNull() {
            addCriterion("DocFileID is null");
            return (Criteria) this;
        }

        public Criteria andDocfileidIsNotNull() {
            addCriterion("DocFileID is not null");
            return (Criteria) this;
        }

        public Criteria andDocfileidEqualTo(Long value) {
            addCriterion("DocFileID =", value, "docfileid");
            return (Criteria) this;
        }

        public Criteria andDocfileidNotEqualTo(Long value) {
            addCriterion("DocFileID <>", value, "docfileid");
            return (Criteria) this;
        }

        public Criteria andDocfileidGreaterThan(Long value) {
            addCriterion("DocFileID >", value, "docfileid");
            return (Criteria) this;
        }

        public Criteria andDocfileidGreaterThanOrEqualTo(Long value) {
            addCriterion("DocFileID >=", value, "docfileid");
            return (Criteria) this;
        }

        public Criteria andDocfileidLessThan(Long value) {
            addCriterion("DocFileID <", value, "docfileid");
            return (Criteria) this;
        }

        public Criteria andDocfileidLessThanOrEqualTo(Long value) {
            addCriterion("DocFileID <=", value, "docfileid");
            return (Criteria) this;
        }

        public Criteria andDocfileidIn(List<Long> values) {
            addCriterion("DocFileID in", values, "docfileid");
            return (Criteria) this;
        }

        public Criteria andDocfileidNotIn(List<Long> values) {
            addCriterion("DocFileID not in", values, "docfileid");
            return (Criteria) this;
        }

        public Criteria andDocfileidBetween(Long value1, Long value2) {
            addCriterion("DocFileID between", value1, value2, "docfileid");
            return (Criteria) this;
        }

        public Criteria andDocfileidNotBetween(Long value1, Long value2) {
            addCriterion("DocFileID not between", value1, value2, "docfileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidIsNull() {
            addCriterion("VedioFileID is null");
            return (Criteria) this;
        }

        public Criteria andVediofileidIsNotNull() {
            addCriterion("VedioFileID is not null");
            return (Criteria) this;
        }

        public Criteria andVediofileidEqualTo(Long value) {
            addCriterion("VedioFileID =", value, "vediofileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidNotEqualTo(Long value) {
            addCriterion("VedioFileID <>", value, "vediofileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidGreaterThan(Long value) {
            addCriterion("VedioFileID >", value, "vediofileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidGreaterThanOrEqualTo(Long value) {
            addCriterion("VedioFileID >=", value, "vediofileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidLessThan(Long value) {
            addCriterion("VedioFileID <", value, "vediofileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidLessThanOrEqualTo(Long value) {
            addCriterion("VedioFileID <=", value, "vediofileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidIn(List<Long> values) {
            addCriterion("VedioFileID in", values, "vediofileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidNotIn(List<Long> values) {
            addCriterion("VedioFileID not in", values, "vediofileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidBetween(Long value1, Long value2) {
            addCriterion("VedioFileID between", value1, value2, "vediofileid");
            return (Criteria) this;
        }

        public Criteria andVediofileidNotBetween(Long value1, Long value2) {
            addCriterion("VedioFileID not between", value1, value2, "vediofileid");
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