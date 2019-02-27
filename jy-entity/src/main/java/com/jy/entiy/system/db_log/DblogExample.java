package com.jy.entiy.system.db_log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DblogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DblogExample() {
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

        public Criteria andDblogidIsNull() {
            addCriterion("DbLogID is null");
            return (Criteria) this;
        }

        public Criteria andDblogidIsNotNull() {
            addCriterion("DbLogID is not null");
            return (Criteria) this;
        }

        public Criteria andDblogidEqualTo(Long value) {
            addCriterion("DbLogID =", value, "dblogid");
            return (Criteria) this;
        }

        public Criteria andDblogidNotEqualTo(Long value) {
            addCriterion("DbLogID <>", value, "dblogid");
            return (Criteria) this;
        }

        public Criteria andDblogidGreaterThan(Long value) {
            addCriterion("DbLogID >", value, "dblogid");
            return (Criteria) this;
        }

        public Criteria andDblogidGreaterThanOrEqualTo(Long value) {
            addCriterion("DbLogID >=", value, "dblogid");
            return (Criteria) this;
        }

        public Criteria andDblogidLessThan(Long value) {
            addCriterion("DbLogID <", value, "dblogid");
            return (Criteria) this;
        }

        public Criteria andDblogidLessThanOrEqualTo(Long value) {
            addCriterion("DbLogID <=", value, "dblogid");
            return (Criteria) this;
        }

        public Criteria andDblogidIn(List<Long> values) {
            addCriterion("DbLogID in", values, "dblogid");
            return (Criteria) this;
        }

        public Criteria andDblogidNotIn(List<Long> values) {
            addCriterion("DbLogID not in", values, "dblogid");
            return (Criteria) this;
        }

        public Criteria andDblogidBetween(Long value1, Long value2) {
            addCriterion("DbLogID between", value1, value2, "dblogid");
            return (Criteria) this;
        }

        public Criteria andDblogidNotBetween(Long value1, Long value2) {
            addCriterion("DbLogID not between", value1, value2, "dblogid");
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

        public Criteria andDblogIsNull() {
            addCriterion("DbLog is null");
            return (Criteria) this;
        }

        public Criteria andDblogIsNotNull() {
            addCriterion("DbLog is not null");
            return (Criteria) this;
        }

        public Criteria andDblogEqualTo(String value) {
            addCriterion("DbLog =", value, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogNotEqualTo(String value) {
            addCriterion("DbLog <>", value, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogGreaterThan(String value) {
            addCriterion("DbLog >", value, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogGreaterThanOrEqualTo(String value) {
            addCriterion("DbLog >=", value, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogLessThan(String value) {
            addCriterion("DbLog <", value, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogLessThanOrEqualTo(String value) {
            addCriterion("DbLog <=", value, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogLike(String value) {
            addCriterion("DbLog like", value, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogNotLike(String value) {
            addCriterion("DbLog not like", value, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogIn(List<String> values) {
            addCriterion("DbLog in", values, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogNotIn(List<String> values) {
            addCriterion("DbLog not in", values, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogBetween(String value1, String value2) {
            addCriterion("DbLog between", value1, value2, "dblog");
            return (Criteria) this;
        }

        public Criteria andDblogNotBetween(String value1, String value2) {
            addCriterion("DbLog not between", value1, value2, "dblog");
            return (Criteria) this;
        }

        public Criteria andDictionariesidIsNull() {
            addCriterion("DictionariesID is null");
            return (Criteria) this;
        }

        public Criteria andDictionariesidIsNotNull() {
            addCriterion("DictionariesID is not null");
            return (Criteria) this;
        }

        public Criteria andDictionariesidEqualTo(Integer value) {
            addCriterion("DictionariesID =", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidNotEqualTo(Integer value) {
            addCriterion("DictionariesID <>", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidGreaterThan(Integer value) {
            addCriterion("DictionariesID >", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DictionariesID >=", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidLessThan(Integer value) {
            addCriterion("DictionariesID <", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidLessThanOrEqualTo(Integer value) {
            addCriterion("DictionariesID <=", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidIn(List<Integer> values) {
            addCriterion("DictionariesID in", values, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidNotIn(List<Integer> values) {
            addCriterion("DictionariesID not in", values, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidBetween(Integer value1, Integer value2) {
            addCriterion("DictionariesID between", value1, value2, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidNotBetween(Integer value1, Integer value2) {
            addCriterion("DictionariesID not between", value1, value2, "dictionariesid");
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