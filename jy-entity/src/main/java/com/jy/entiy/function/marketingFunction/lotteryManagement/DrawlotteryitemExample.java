package com.jy.entiy.function.marketingFunction.lotteryManagement;

import java.util.ArrayList;
import java.util.List;

public class DrawlotteryitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrawlotteryitemExample() {
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

        public Criteria andDrawlotteryitemidIsNull() {
            addCriterion("DrawLotteryItemID is null");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidIsNotNull() {
            addCriterion("DrawLotteryItemID is not null");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidEqualTo(Integer value) {
            addCriterion("DrawLotteryItemID =", value, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidNotEqualTo(Integer value) {
            addCriterion("DrawLotteryItemID <>", value, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidGreaterThan(Integer value) {
            addCriterion("DrawLotteryItemID >", value, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DrawLotteryItemID >=", value, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidLessThan(Integer value) {
            addCriterion("DrawLotteryItemID <", value, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidLessThanOrEqualTo(Integer value) {
            addCriterion("DrawLotteryItemID <=", value, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidIn(List<Integer> values) {
            addCriterion("DrawLotteryItemID in", values, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidNotIn(List<Integer> values) {
            addCriterion("DrawLotteryItemID not in", values, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidBetween(Integer value1, Integer value2) {
            addCriterion("DrawLotteryItemID between", value1, value2, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryitemidNotBetween(Integer value1, Integer value2) {
            addCriterion("DrawLotteryItemID not between", value1, value2, "drawlotteryitemid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidIsNull() {
            addCriterion("DrawLotteryConfigID is null");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidIsNotNull() {
            addCriterion("DrawLotteryConfigID is not null");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidEqualTo(Integer value) {
            addCriterion("DrawLotteryConfigID =", value, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidNotEqualTo(Integer value) {
            addCriterion("DrawLotteryConfigID <>", value, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidGreaterThan(Integer value) {
            addCriterion("DrawLotteryConfigID >", value, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DrawLotteryConfigID >=", value, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidLessThan(Integer value) {
            addCriterion("DrawLotteryConfigID <", value, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidLessThanOrEqualTo(Integer value) {
            addCriterion("DrawLotteryConfigID <=", value, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidIn(List<Integer> values) {
            addCriterion("DrawLotteryConfigID in", values, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidNotIn(List<Integer> values) {
            addCriterion("DrawLotteryConfigID not in", values, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidBetween(Integer value1, Integer value2) {
            addCriterion("DrawLotteryConfigID between", value1, value2, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andDrawlotteryconfigidNotBetween(Integer value1, Integer value2) {
            addCriterion("DrawLotteryConfigID not between", value1, value2, "drawlotteryconfigid");
            return (Criteria) this;
        }

        public Criteria andLotterysetIsNull() {
            addCriterion("LotterySet is null");
            return (Criteria) this;
        }

        public Criteria andLotterysetIsNotNull() {
            addCriterion("LotterySet is not null");
            return (Criteria) this;
        }

        public Criteria andLotterysetEqualTo(String value) {
            addCriterion("LotterySet =", value, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetNotEqualTo(String value) {
            addCriterion("LotterySet <>", value, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetGreaterThan(String value) {
            addCriterion("LotterySet >", value, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetGreaterThanOrEqualTo(String value) {
            addCriterion("LotterySet >=", value, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetLessThan(String value) {
            addCriterion("LotterySet <", value, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetLessThanOrEqualTo(String value) {
            addCriterion("LotterySet <=", value, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetLike(String value) {
            addCriterion("LotterySet like", value, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetNotLike(String value) {
            addCriterion("LotterySet not like", value, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetIn(List<String> values) {
            addCriterion("LotterySet in", values, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetNotIn(List<String> values) {
            addCriterion("LotterySet not in", values, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetBetween(String value1, String value2) {
            addCriterion("LotterySet between", value1, value2, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterysetNotBetween(String value1, String value2) {
            addCriterion("LotterySet not between", value1, value2, "lotteryset");
            return (Criteria) this;
        }

        public Criteria andLotterynoIsNull() {
            addCriterion("LotteryNo is null");
            return (Criteria) this;
        }

        public Criteria andLotterynoIsNotNull() {
            addCriterion("LotteryNo is not null");
            return (Criteria) this;
        }

        public Criteria andLotterynoEqualTo(Integer value) {
            addCriterion("LotteryNo =", value, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andLotterynoNotEqualTo(Integer value) {
            addCriterion("LotteryNo <>", value, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andLotterynoGreaterThan(Integer value) {
            addCriterion("LotteryNo >", value, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andLotterynoGreaterThanOrEqualTo(Integer value) {
            addCriterion("LotteryNo >=", value, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andLotterynoLessThan(Integer value) {
            addCriterion("LotteryNo <", value, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andLotterynoLessThanOrEqualTo(Integer value) {
            addCriterion("LotteryNo <=", value, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andLotterynoIn(List<Integer> values) {
            addCriterion("LotteryNo in", values, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andLotterynoNotIn(List<Integer> values) {
            addCriterion("LotteryNo not in", values, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andLotterynoBetween(Integer value1, Integer value2) {
            addCriterion("LotteryNo between", value1, value2, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andLotterynoNotBetween(Integer value1, Integer value2) {
            addCriterion("LotteryNo not between", value1, value2, "lotteryno");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityIsNull() {
            addCriterion("GetLotteryProbalility is null");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityIsNotNull() {
            addCriterion("GetLotteryProbalility is not null");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityEqualTo(Float value) {
            addCriterion("GetLotteryProbalility =", value, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityNotEqualTo(Float value) {
            addCriterion("GetLotteryProbalility <>", value, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityGreaterThan(Float value) {
            addCriterion("GetLotteryProbalility >", value, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityGreaterThanOrEqualTo(Float value) {
            addCriterion("GetLotteryProbalility >=", value, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityLessThan(Float value) {
            addCriterion("GetLotteryProbalility <", value, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityLessThanOrEqualTo(Float value) {
            addCriterion("GetLotteryProbalility <=", value, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityIn(List<Float> values) {
            addCriterion("GetLotteryProbalility in", values, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityNotIn(List<Float> values) {
            addCriterion("GetLotteryProbalility not in", values, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityBetween(Float value1, Float value2) {
            addCriterion("GetLotteryProbalility between", value1, value2, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andGetlotteryprobalilityNotBetween(Float value1, Float value2) {
            addCriterion("GetLotteryProbalility not between", value1, value2, "getlotteryprobalility");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidIsNull() {
            addCriterion("DrawLotteryLevelID is null");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidIsNotNull() {
            addCriterion("DrawLotteryLevelID is not null");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidEqualTo(Integer value) {
            addCriterion("DrawLotteryLevelID =", value, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidNotEqualTo(Integer value) {
            addCriterion("DrawLotteryLevelID <>", value, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidGreaterThan(Integer value) {
            addCriterion("DrawLotteryLevelID >", value, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DrawLotteryLevelID >=", value, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidLessThan(Integer value) {
            addCriterion("DrawLotteryLevelID <", value, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidLessThanOrEqualTo(Integer value) {
            addCriterion("DrawLotteryLevelID <=", value, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidIn(List<Integer> values) {
            addCriterion("DrawLotteryLevelID in", values, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidNotIn(List<Integer> values) {
            addCriterion("DrawLotteryLevelID not in", values, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidBetween(Integer value1, Integer value2) {
            addCriterion("DrawLotteryLevelID between", value1, value2, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andDrawlotterylevelidNotBetween(Integer value1, Integer value2) {
            addCriterion("DrawLotteryLevelID not between", value1, value2, "drawlotterylevelid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidIsNull() {
            addCriterion("picturePathId is null");
            return (Criteria) this;
        }

        public Criteria andPicturepathidIsNotNull() {
            addCriterion("picturePathId is not null");
            return (Criteria) this;
        }

        public Criteria andPicturepathidEqualTo(Long value) {
            addCriterion("picturePathId =", value, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidNotEqualTo(Long value) {
            addCriterion("picturePathId <>", value, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidGreaterThan(Long value) {
            addCriterion("picturePathId >", value, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidGreaterThanOrEqualTo(Long value) {
            addCriterion("picturePathId >=", value, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidLessThan(Long value) {
            addCriterion("picturePathId <", value, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidLessThanOrEqualTo(Long value) {
            addCriterion("picturePathId <=", value, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidIn(List<Long> values) {
            addCriterion("picturePathId in", values, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidNotIn(List<Long> values) {
            addCriterion("picturePathId not in", values, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidBetween(Long value1, Long value2) {
            addCriterion("picturePathId between", value1, value2, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathidNotBetween(Long value1, Long value2) {
            addCriterion("picturePathId not between", value1, value2, "picturepathid");
            return (Criteria) this;
        }

        public Criteria andPicturepathIsNull() {
            addCriterion("picturePath is null");
            return (Criteria) this;
        }

        public Criteria andPicturepathIsNotNull() {
            addCriterion("picturePath is not null");
            return (Criteria) this;
        }

        public Criteria andPicturepathEqualTo(String value) {
            addCriterion("picturePath =", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathNotEqualTo(String value) {
            addCriterion("picturePath <>", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathGreaterThan(String value) {
            addCriterion("picturePath >", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathGreaterThanOrEqualTo(String value) {
            addCriterion("picturePath >=", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathLessThan(String value) {
            addCriterion("picturePath <", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathLessThanOrEqualTo(String value) {
            addCriterion("picturePath <=", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathLike(String value) {
            addCriterion("picturePath like", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathNotLike(String value) {
            addCriterion("picturePath not like", value, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathIn(List<String> values) {
            addCriterion("picturePath in", values, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathNotIn(List<String> values) {
            addCriterion("picturePath not in", values, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathBetween(String value1, String value2) {
            addCriterion("picturePath between", value1, value2, "picturepath");
            return (Criteria) this;
        }

        public Criteria andPicturepathNotBetween(String value1, String value2) {
            addCriterion("picturePath not between", value1, value2, "picturepath");
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