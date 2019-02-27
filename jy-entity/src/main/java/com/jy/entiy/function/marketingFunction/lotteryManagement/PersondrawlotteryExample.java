package com.jy.entiy.function.marketingFunction.lotteryManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersondrawlotteryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersondrawlotteryExample() {
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

        public Criteria andWinningtimeIsNull() {
            addCriterion("WinningTime is null");
            return (Criteria) this;
        }

        public Criteria andWinningtimeIsNotNull() {
            addCriterion("WinningTime is not null");
            return (Criteria) this;
        }

        public Criteria andWinningtimeEqualTo(Date value) {
            addCriterion("WinningTime =", value, "winningtime");
            return (Criteria) this;
        }

        public Criteria andWinningtimeNotEqualTo(Date value) {
            addCriterion("WinningTime <>", value, "winningtime");
            return (Criteria) this;
        }

        public Criteria andWinningtimeGreaterThan(Date value) {
            addCriterion("WinningTime >", value, "winningtime");
            return (Criteria) this;
        }

        public Criteria andWinningtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WinningTime >=", value, "winningtime");
            return (Criteria) this;
        }

        public Criteria andWinningtimeLessThan(Date value) {
            addCriterion("WinningTime <", value, "winningtime");
            return (Criteria) this;
        }

        public Criteria andWinningtimeLessThanOrEqualTo(Date value) {
            addCriterion("WinningTime <=", value, "winningtime");
            return (Criteria) this;
        }

        public Criteria andWinningtimeIn(List<Date> values) {
            addCriterion("WinningTime in", values, "winningtime");
            return (Criteria) this;
        }

        public Criteria andWinningtimeNotIn(List<Date> values) {
            addCriterion("WinningTime not in", values, "winningtime");
            return (Criteria) this;
        }

        public Criteria andWinningtimeBetween(Date value1, Date value2) {
            addCriterion("WinningTime between", value1, value2, "winningtime");
            return (Criteria) this;
        }

        public Criteria andWinningtimeNotBetween(Date value1, Date value2) {
            addCriterion("WinningTime not between", value1, value2, "winningtime");
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