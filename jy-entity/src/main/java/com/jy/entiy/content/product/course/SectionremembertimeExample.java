package com.jy.entiy.content.product.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SectionremembertimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SectionremembertimeExample() {
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

        public Criteria andSectionremembertimeidIsNull() {
            addCriterion("SectionRememberTimeID is null");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidIsNotNull() {
            addCriterion("SectionRememberTimeID is not null");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidEqualTo(Long value) {
            addCriterion("SectionRememberTimeID =", value, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidNotEqualTo(Long value) {
            addCriterion("SectionRememberTimeID <>", value, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidGreaterThan(Long value) {
            addCriterion("SectionRememberTimeID >", value, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidGreaterThanOrEqualTo(Long value) {
            addCriterion("SectionRememberTimeID >=", value, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidLessThan(Long value) {
            addCriterion("SectionRememberTimeID <", value, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidLessThanOrEqualTo(Long value) {
            addCriterion("SectionRememberTimeID <=", value, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidIn(List<Long> values) {
            addCriterion("SectionRememberTimeID in", values, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidNotIn(List<Long> values) {
            addCriterion("SectionRememberTimeID not in", values, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidBetween(Long value1, Long value2) {
            addCriterion("SectionRememberTimeID between", value1, value2, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andSectionremembertimeidNotBetween(Long value1, Long value2) {
            addCriterion("SectionRememberTimeID not between", value1, value2, "sectionremembertimeid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidIsNull() {
            addCriterion("PersonCourseID is null");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidIsNotNull() {
            addCriterion("PersonCourseID is not null");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidEqualTo(Long value) {
            addCriterion("PersonCourseID =", value, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidNotEqualTo(Long value) {
            addCriterion("PersonCourseID <>", value, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidGreaterThan(Long value) {
            addCriterion("PersonCourseID >", value, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidGreaterThanOrEqualTo(Long value) {
            addCriterion("PersonCourseID >=", value, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidLessThan(Long value) {
            addCriterion("PersonCourseID <", value, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidLessThanOrEqualTo(Long value) {
            addCriterion("PersonCourseID <=", value, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidIn(List<Long> values) {
            addCriterion("PersonCourseID in", values, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidNotIn(List<Long> values) {
            addCriterion("PersonCourseID not in", values, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidBetween(Long value1, Long value2) {
            addCriterion("PersonCourseID between", value1, value2, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andPersoncourseidNotBetween(Long value1, Long value2) {
            addCriterion("PersonCourseID not between", value1, value2, "personcourseid");
            return (Criteria) this;
        }

        public Criteria andSectionidIsNull() {
            addCriterion("SectionID is null");
            return (Criteria) this;
        }

        public Criteria andSectionidIsNotNull() {
            addCriterion("SectionID is not null");
            return (Criteria) this;
        }

        public Criteria andSectionidEqualTo(Long value) {
            addCriterion("SectionID =", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotEqualTo(Long value) {
            addCriterion("SectionID <>", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThan(Long value) {
            addCriterion("SectionID >", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThanOrEqualTo(Long value) {
            addCriterion("SectionID >=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThan(Long value) {
            addCriterion("SectionID <", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThanOrEqualTo(Long value) {
            addCriterion("SectionID <=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidIn(List<Long> values) {
            addCriterion("SectionID in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotIn(List<Long> values) {
            addCriterion("SectionID not in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidBetween(Long value1, Long value2) {
            addCriterion("SectionID between", value1, value2, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotBetween(Long value1, Long value2) {
            addCriterion("SectionID not between", value1, value2, "sectionid");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("Time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("Time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Integer value) {
            addCriterion("Time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Integer value) {
            addCriterion("Time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Integer value) {
            addCriterion("Time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Integer value) {
            addCriterion("Time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Integer value) {
            addCriterion("Time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Integer> values) {
            addCriterion("Time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Integer> values) {
            addCriterion("Time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Integer value1, Integer value2) {
            addCriterion("Time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("Time not between", value1, value2, "time");
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