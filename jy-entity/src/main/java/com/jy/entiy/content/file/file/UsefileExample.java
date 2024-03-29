package com.jy.entiy.content.file.file;

import java.util.ArrayList;
import java.util.List;

public class UsefileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsefileExample() {
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

        public Criteria andFileidIsNull() {
            addCriterion("FileID is null");
            return (Criteria) this;
        }

        public Criteria andFileidIsNotNull() {
            addCriterion("FileID is not null");
            return (Criteria) this;
        }

        public Criteria andFileidEqualTo(Long value) {
            addCriterion("FileID =", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotEqualTo(Long value) {
            addCriterion("FileID <>", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThan(Long value) {
            addCriterion("FileID >", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThanOrEqualTo(Long value) {
            addCriterion("FileID >=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThan(Long value) {
            addCriterion("FileID <", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThanOrEqualTo(Long value) {
            addCriterion("FileID <=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidIn(List<Long> values) {
            addCriterion("FileID in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotIn(List<Long> values) {
            addCriterion("FileID not in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidBetween(Long value1, Long value2) {
            addCriterion("FileID between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotBetween(Long value1, Long value2) {
            addCriterion("FileID not between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNull() {
            addCriterion("TableName is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("TableName is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("TableName =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("TableName <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("TableName >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("TableName >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("TableName <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("TableName <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("TableName like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("TableName not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("TableName in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("TableName not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("TableName between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("TableName not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andUseidIsNull() {
            addCriterion("UseID is null");
            return (Criteria) this;
        }

        public Criteria andUseidIsNotNull() {
            addCriterion("UseID is not null");
            return (Criteria) this;
        }

        public Criteria andUseidEqualTo(Long value) {
            addCriterion("UseID =", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotEqualTo(Long value) {
            addCriterion("UseID <>", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidGreaterThan(Long value) {
            addCriterion("UseID >", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidGreaterThanOrEqualTo(Long value) {
            addCriterion("UseID >=", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidLessThan(Long value) {
            addCriterion("UseID <", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidLessThanOrEqualTo(Long value) {
            addCriterion("UseID <=", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidIn(List<Long> values) {
            addCriterion("UseID in", values, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotIn(List<Long> values) {
            addCriterion("UseID not in", values, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidBetween(Long value1, Long value2) {
            addCriterion("UseID between", value1, value2, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotBetween(Long value1, Long value2) {
            addCriterion("UseID not between", value1, value2, "useid");
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