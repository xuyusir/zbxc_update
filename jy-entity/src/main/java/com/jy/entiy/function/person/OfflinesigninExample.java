package com.jy.entiy.function.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfflinesigninExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfflinesigninExample() {
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

        public Criteria andOfflinesigninidIsNull() {
            addCriterion("OfflineSignInID is null");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidIsNotNull() {
            addCriterion("OfflineSignInID is not null");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidEqualTo(Long value) {
            addCriterion("OfflineSignInID =", value, "offlinesigninid");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidNotEqualTo(Long value) {
            addCriterion("OfflineSignInID <>", value, "offlinesigninid");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidGreaterThan(Long value) {
            addCriterion("OfflineSignInID >", value, "offlinesigninid");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidGreaterThanOrEqualTo(Long value) {
            addCriterion("OfflineSignInID >=", value, "offlinesigninid");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidLessThan(Long value) {
            addCriterion("OfflineSignInID <", value, "offlinesigninid");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidLessThanOrEqualTo(Long value) {
            addCriterion("OfflineSignInID <=", value, "offlinesigninid");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidIn(List<Long> values) {
            addCriterion("OfflineSignInID in", values, "offlinesigninid");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidNotIn(List<Long> values) {
            addCriterion("OfflineSignInID not in", values, "offlinesigninid");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidBetween(Long value1, Long value2) {
            addCriterion("OfflineSignInID between", value1, value2, "offlinesigninid");
            return (Criteria) this;
        }

        public Criteria andOfflinesigninidNotBetween(Long value1, Long value2) {
            addCriterion("OfflineSignInID not between", value1, value2, "offlinesigninid");
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

        public Criteria andSignincheckidIsNull() {
            addCriterion("SigninCheckID is null");
            return (Criteria) this;
        }

        public Criteria andSignincheckidIsNotNull() {
            addCriterion("SigninCheckID is not null");
            return (Criteria) this;
        }

        public Criteria andSignincheckidEqualTo(Long value) {
            addCriterion("SigninCheckID =", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidNotEqualTo(Long value) {
            addCriterion("SigninCheckID <>", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidGreaterThan(Long value) {
            addCriterion("SigninCheckID >", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidGreaterThanOrEqualTo(Long value) {
            addCriterion("SigninCheckID >=", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidLessThan(Long value) {
            addCriterion("SigninCheckID <", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidLessThanOrEqualTo(Long value) {
            addCriterion("SigninCheckID <=", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidIn(List<Long> values) {
            addCriterion("SigninCheckID in", values, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidNotIn(List<Long> values) {
            addCriterion("SigninCheckID not in", values, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidBetween(Long value1, Long value2) {
            addCriterion("SigninCheckID between", value1, value2, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidNotBetween(Long value1, Long value2) {
            addCriterion("SigninCheckID not between", value1, value2, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andActivitynameIsNull() {
            addCriterion("ActivityName is null");
            return (Criteria) this;
        }

        public Criteria andActivitynameIsNotNull() {
            addCriterion("ActivityName is not null");
            return (Criteria) this;
        }

        public Criteria andActivitynameEqualTo(String value) {
            addCriterion("ActivityName =", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotEqualTo(String value) {
            addCriterion("ActivityName <>", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameGreaterThan(String value) {
            addCriterion("ActivityName >", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityName >=", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLessThan(String value) {
            addCriterion("ActivityName <", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLessThanOrEqualTo(String value) {
            addCriterion("ActivityName <=", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLike(String value) {
            addCriterion("ActivityName like", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotLike(String value) {
            addCriterion("ActivityName not like", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameIn(List<String> values) {
            addCriterion("ActivityName in", values, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotIn(List<String> values) {
            addCriterion("ActivityName not in", values, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameBetween(String value1, String value2) {
            addCriterion("ActivityName between", value1, value2, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotBetween(String value1, String value2) {
            addCriterion("ActivityName not between", value1, value2, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitytimeIsNull() {
            addCriterion("ActivityTime is null");
            return (Criteria) this;
        }

        public Criteria andActivitytimeIsNotNull() {
            addCriterion("ActivityTime is not null");
            return (Criteria) this;
        }

        public Criteria andActivitytimeEqualTo(Date value) {
            addCriterion("ActivityTime =", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeNotEqualTo(Date value) {
            addCriterion("ActivityTime <>", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeGreaterThan(Date value) {
            addCriterion("ActivityTime >", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ActivityTime >=", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeLessThan(Date value) {
            addCriterion("ActivityTime <", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeLessThanOrEqualTo(Date value) {
            addCriterion("ActivityTime <=", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeIn(List<Date> values) {
            addCriterion("ActivityTime in", values, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeNotIn(List<Date> values) {
            addCriterion("ActivityTime not in", values, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeBetween(Date value1, Date value2) {
            addCriterion("ActivityTime between", value1, value2, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeNotBetween(Date value1, Date value2) {
            addCriterion("ActivityTime not between", value1, value2, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitylocationIsNull() {
            addCriterion("ActivityLocation is null");
            return (Criteria) this;
        }

        public Criteria andActivitylocationIsNotNull() {
            addCriterion("ActivityLocation is not null");
            return (Criteria) this;
        }

        public Criteria andActivitylocationEqualTo(String value) {
            addCriterion("ActivityLocation =", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationNotEqualTo(String value) {
            addCriterion("ActivityLocation <>", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationGreaterThan(String value) {
            addCriterion("ActivityLocation >", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityLocation >=", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationLessThan(String value) {
            addCriterion("ActivityLocation <", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationLessThanOrEqualTo(String value) {
            addCriterion("ActivityLocation <=", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationLike(String value) {
            addCriterion("ActivityLocation like", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationNotLike(String value) {
            addCriterion("ActivityLocation not like", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationIn(List<String> values) {
            addCriterion("ActivityLocation in", values, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationNotIn(List<String> values) {
            addCriterion("ActivityLocation not in", values, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationBetween(String value1, String value2) {
            addCriterion("ActivityLocation between", value1, value2, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationNotBetween(String value1, String value2) {
            addCriterion("ActivityLocation not between", value1, value2, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andSignintimeIsNull() {
            addCriterion("SignInTime is null");
            return (Criteria) this;
        }

        public Criteria andSignintimeIsNotNull() {
            addCriterion("SignInTime is not null");
            return (Criteria) this;
        }

        public Criteria andSignintimeEqualTo(Date value) {
            addCriterion("SignInTime =", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotEqualTo(Date value) {
            addCriterion("SignInTime <>", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeGreaterThan(Date value) {
            addCriterion("SignInTime >", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SignInTime >=", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeLessThan(Date value) {
            addCriterion("SignInTime <", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeLessThanOrEqualTo(Date value) {
            addCriterion("SignInTime <=", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeIn(List<Date> values) {
            addCriterion("SignInTime in", values, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotIn(List<Date> values) {
            addCriterion("SignInTime not in", values, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeBetween(Date value1, Date value2) {
            addCriterion("SignInTime between", value1, value2, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotBetween(Date value1, Date value2) {
            addCriterion("SignInTime not between", value1, value2, "signintime");
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