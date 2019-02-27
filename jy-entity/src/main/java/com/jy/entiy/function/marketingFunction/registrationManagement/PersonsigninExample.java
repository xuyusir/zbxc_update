package com.jy.entiy.function.marketingFunction.registrationManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonsigninExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonsigninExample() {
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

        public Criteria andSignincheckidIsNull() {
            addCriterion("SigninCheckID is null");
            return (Criteria) this;
        }

        public Criteria andSignincheckidIsNotNull() {
            addCriterion("SigninCheckID is not null");
            return (Criteria) this;
        }

        public Criteria andSignincheckidEqualTo(Integer value) {
            addCriterion("SigninCheckID =", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidNotEqualTo(Integer value) {
            addCriterion("SigninCheckID <>", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidGreaterThan(Integer value) {
            addCriterion("SigninCheckID >", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SigninCheckID >=", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidLessThan(Integer value) {
            addCriterion("SigninCheckID <", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidLessThanOrEqualTo(Integer value) {
            addCriterion("SigninCheckID <=", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidIn(List<Integer> values) {
            addCriterion("SigninCheckID in", values, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidNotIn(List<Integer> values) {
            addCriterion("SigninCheckID not in", values, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidBetween(Integer value1, Integer value2) {
            addCriterion("SigninCheckID between", value1, value2, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidNotBetween(Integer value1, Integer value2) {
            addCriterion("SigninCheckID not between", value1, value2, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSigintimeIsNull() {
            addCriterion("SiginTime is null");
            return (Criteria) this;
        }

        public Criteria andSigintimeIsNotNull() {
            addCriterion("SiginTime is not null");
            return (Criteria) this;
        }

        public Criteria andSigintimeEqualTo(Date value) {
            addCriterion("SiginTime =", value, "sigintime");
            return (Criteria) this;
        }

        public Criteria andSigintimeNotEqualTo(Date value) {
            addCriterion("SiginTime <>", value, "sigintime");
            return (Criteria) this;
        }

        public Criteria andSigintimeGreaterThan(Date value) {
            addCriterion("SiginTime >", value, "sigintime");
            return (Criteria) this;
        }

        public Criteria andSigintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SiginTime >=", value, "sigintime");
            return (Criteria) this;
        }

        public Criteria andSigintimeLessThan(Date value) {
            addCriterion("SiginTime <", value, "sigintime");
            return (Criteria) this;
        }

        public Criteria andSigintimeLessThanOrEqualTo(Date value) {
            addCriterion("SiginTime <=", value, "sigintime");
            return (Criteria) this;
        }

        public Criteria andSigintimeIn(List<Date> values) {
            addCriterion("SiginTime in", values, "sigintime");
            return (Criteria) this;
        }

        public Criteria andSigintimeNotIn(List<Date> values) {
            addCriterion("SiginTime not in", values, "sigintime");
            return (Criteria) this;
        }

        public Criteria andSigintimeBetween(Date value1, Date value2) {
            addCriterion("SiginTime between", value1, value2, "sigintime");
            return (Criteria) this;
        }

        public Criteria andSigintimeNotBetween(Date value1, Date value2) {
            addCriterion("SiginTime not between", value1, value2, "sigintime");
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