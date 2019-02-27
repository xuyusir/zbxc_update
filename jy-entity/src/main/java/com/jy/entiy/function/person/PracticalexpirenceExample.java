package com.jy.entiy.function.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PracticalexpirenceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PracticalexpirenceExample() {
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

        public Criteria andPracticeidIsNull() {
            addCriterion("PracticeID is null");
            return (Criteria) this;
        }

        public Criteria andPracticeidIsNotNull() {
            addCriterion("PracticeID is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeidEqualTo(Long value) {
            addCriterion("PracticeID =", value, "practiceid");
            return (Criteria) this;
        }

        public Criteria andPracticeidNotEqualTo(Long value) {
            addCriterion("PracticeID <>", value, "practiceid");
            return (Criteria) this;
        }

        public Criteria andPracticeidGreaterThan(Long value) {
            addCriterion("PracticeID >", value, "practiceid");
            return (Criteria) this;
        }

        public Criteria andPracticeidGreaterThanOrEqualTo(Long value) {
            addCriterion("PracticeID >=", value, "practiceid");
            return (Criteria) this;
        }

        public Criteria andPracticeidLessThan(Long value) {
            addCriterion("PracticeID <", value, "practiceid");
            return (Criteria) this;
        }

        public Criteria andPracticeidLessThanOrEqualTo(Long value) {
            addCriterion("PracticeID <=", value, "practiceid");
            return (Criteria) this;
        }

        public Criteria andPracticeidIn(List<Long> values) {
            addCriterion("PracticeID in", values, "practiceid");
            return (Criteria) this;
        }

        public Criteria andPracticeidNotIn(List<Long> values) {
            addCriterion("PracticeID not in", values, "practiceid");
            return (Criteria) this;
        }

        public Criteria andPracticeidBetween(Long value1, Long value2) {
            addCriterion("PracticeID between", value1, value2, "practiceid");
            return (Criteria) this;
        }

        public Criteria andPracticeidNotBetween(Long value1, Long value2) {
            addCriterion("PracticeID not between", value1, value2, "practiceid");
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

        public Criteria andPracticetitleIsNull() {
            addCriterion("PracticeTitle is null");
            return (Criteria) this;
        }

        public Criteria andPracticetitleIsNotNull() {
            addCriterion("PracticeTitle is not null");
            return (Criteria) this;
        }

        public Criteria andPracticetitleEqualTo(String value) {
            addCriterion("PracticeTitle =", value, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleNotEqualTo(String value) {
            addCriterion("PracticeTitle <>", value, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleGreaterThan(String value) {
            addCriterion("PracticeTitle >", value, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleGreaterThanOrEqualTo(String value) {
            addCriterion("PracticeTitle >=", value, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleLessThan(String value) {
            addCriterion("PracticeTitle <", value, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleLessThanOrEqualTo(String value) {
            addCriterion("PracticeTitle <=", value, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleLike(String value) {
            addCriterion("PracticeTitle like", value, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleNotLike(String value) {
            addCriterion("PracticeTitle not like", value, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleIn(List<String> values) {
            addCriterion("PracticeTitle in", values, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleNotIn(List<String> values) {
            addCriterion("PracticeTitle not in", values, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleBetween(String value1, String value2) {
            addCriterion("PracticeTitle between", value1, value2, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticetitleNotBetween(String value1, String value2) {
            addCriterion("PracticeTitle not between", value1, value2, "practicetitle");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateIsNull() {
            addCriterion("PracticeStartDate is null");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateIsNotNull() {
            addCriterion("PracticeStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateEqualTo(Date value) {
            addCriterion("PracticeStartDate =", value, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateNotEqualTo(Date value) {
            addCriterion("PracticeStartDate <>", value, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateGreaterThan(Date value) {
            addCriterion("PracticeStartDate >", value, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("PracticeStartDate >=", value, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateLessThan(Date value) {
            addCriterion("PracticeStartDate <", value, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateLessThanOrEqualTo(Date value) {
            addCriterion("PracticeStartDate <=", value, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateIn(List<Date> values) {
            addCriterion("PracticeStartDate in", values, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateNotIn(List<Date> values) {
            addCriterion("PracticeStartDate not in", values, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateBetween(Date value1, Date value2) {
            addCriterion("PracticeStartDate between", value1, value2, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticestartdateNotBetween(Date value1, Date value2) {
            addCriterion("PracticeStartDate not between", value1, value2, "practicestartdate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateIsNull() {
            addCriterion("PracticeEndDate is null");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateIsNotNull() {
            addCriterion("PracticeEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateEqualTo(Date value) {
            addCriterion("PracticeEndDate =", value, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateNotEqualTo(Date value) {
            addCriterion("PracticeEndDate <>", value, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateGreaterThan(Date value) {
            addCriterion("PracticeEndDate >", value, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("PracticeEndDate >=", value, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateLessThan(Date value) {
            addCriterion("PracticeEndDate <", value, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateLessThanOrEqualTo(Date value) {
            addCriterion("PracticeEndDate <=", value, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateIn(List<Date> values) {
            addCriterion("PracticeEndDate in", values, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateNotIn(List<Date> values) {
            addCriterion("PracticeEndDate not in", values, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateBetween(Date value1, Date value2) {
            addCriterion("PracticeEndDate between", value1, value2, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeenddateNotBetween(Date value1, Date value2) {
            addCriterion("PracticeEndDate not between", value1, value2, "practiceenddate");
            return (Criteria) this;
        }

        public Criteria andPracticeroleIsNull() {
            addCriterion("PracticeRole is null");
            return (Criteria) this;
        }

        public Criteria andPracticeroleIsNotNull() {
            addCriterion("PracticeRole is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeroleEqualTo(String value) {
            addCriterion("PracticeRole =", value, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleNotEqualTo(String value) {
            addCriterion("PracticeRole <>", value, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleGreaterThan(String value) {
            addCriterion("PracticeRole >", value, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleGreaterThanOrEqualTo(String value) {
            addCriterion("PracticeRole >=", value, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleLessThan(String value) {
            addCriterion("PracticeRole <", value, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleLessThanOrEqualTo(String value) {
            addCriterion("PracticeRole <=", value, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleLike(String value) {
            addCriterion("PracticeRole like", value, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleNotLike(String value) {
            addCriterion("PracticeRole not like", value, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleIn(List<String> values) {
            addCriterion("PracticeRole in", values, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleNotIn(List<String> values) {
            addCriterion("PracticeRole not in", values, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleBetween(String value1, String value2) {
            addCriterion("PracticeRole between", value1, value2, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticeroleNotBetween(String value1, String value2) {
            addCriterion("PracticeRole not between", value1, value2, "practicerole");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionIsNull() {
            addCriterion("PracticeDescription is null");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionIsNotNull() {
            addCriterion("PracticeDescription is not null");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionEqualTo(String value) {
            addCriterion("PracticeDescription =", value, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionNotEqualTo(String value) {
            addCriterion("PracticeDescription <>", value, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionGreaterThan(String value) {
            addCriterion("PracticeDescription >", value, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("PracticeDescription >=", value, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionLessThan(String value) {
            addCriterion("PracticeDescription <", value, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionLessThanOrEqualTo(String value) {
            addCriterion("PracticeDescription <=", value, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionLike(String value) {
            addCriterion("PracticeDescription like", value, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionNotLike(String value) {
            addCriterion("PracticeDescription not like", value, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionIn(List<String> values) {
            addCriterion("PracticeDescription in", values, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionNotIn(List<String> values) {
            addCriterion("PracticeDescription not in", values, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionBetween(String value1, String value2) {
            addCriterion("PracticeDescription between", value1, value2, "practicedescription");
            return (Criteria) this;
        }

        public Criteria andPracticedescriptionNotBetween(String value1, String value2) {
            addCriterion("PracticeDescription not between", value1, value2, "practicedescription");
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