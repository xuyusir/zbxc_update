package com.jy.entiy.function.marketingFunction.votingManagement;

import java.util.ArrayList;
import java.util.List;

public class VotedetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VotedetailsExample() {
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

        public Criteria andVoteoptionidIsNull() {
            addCriterion("VoteOptionID is null");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidIsNotNull() {
            addCriterion("VoteOptionID is not null");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidEqualTo(Integer value) {
            addCriterion("VoteOptionID =", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidNotEqualTo(Integer value) {
            addCriterion("VoteOptionID <>", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidGreaterThan(Integer value) {
            addCriterion("VoteOptionID >", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("VoteOptionID >=", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidLessThan(Integer value) {
            addCriterion("VoteOptionID <", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidLessThanOrEqualTo(Integer value) {
            addCriterion("VoteOptionID <=", value, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidIn(List<Integer> values) {
            addCriterion("VoteOptionID in", values, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidNotIn(List<Integer> values) {
            addCriterion("VoteOptionID not in", values, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidBetween(Integer value1, Integer value2) {
            addCriterion("VoteOptionID between", value1, value2, "voteoptionid");
            return (Criteria) this;
        }

        public Criteria andVoteoptionidNotBetween(Integer value1, Integer value2) {
            addCriterion("VoteOptionID not between", value1, value2, "voteoptionid");
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

        public Criteria andVoteidIsNull() {
            addCriterion("VoteID is null");
            return (Criteria) this;
        }

        public Criteria andVoteidIsNotNull() {
            addCriterion("VoteID is not null");
            return (Criteria) this;
        }

        public Criteria andVoteidEqualTo(Integer value) {
            addCriterion("VoteID =", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidNotEqualTo(Integer value) {
            addCriterion("VoteID <>", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidGreaterThan(Integer value) {
            addCriterion("VoteID >", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidGreaterThanOrEqualTo(Integer value) {
            addCriterion("VoteID >=", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidLessThan(Integer value) {
            addCriterion("VoteID <", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidLessThanOrEqualTo(Integer value) {
            addCriterion("VoteID <=", value, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidIn(List<Integer> values) {
            addCriterion("VoteID in", values, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidNotIn(List<Integer> values) {
            addCriterion("VoteID not in", values, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidBetween(Integer value1, Integer value2) {
            addCriterion("VoteID between", value1, value2, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteidNotBetween(Integer value1, Integer value2) {
            addCriterion("VoteID not between", value1, value2, "voteid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidIsNull() {
            addCriterion("VoteItemID is null");
            return (Criteria) this;
        }

        public Criteria andVoteitemidIsNotNull() {
            addCriterion("VoteItemID is not null");
            return (Criteria) this;
        }

        public Criteria andVoteitemidEqualTo(Integer value) {
            addCriterion("VoteItemID =", value, "voteitemid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidNotEqualTo(Integer value) {
            addCriterion("VoteItemID <>", value, "voteitemid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidGreaterThan(Integer value) {
            addCriterion("VoteItemID >", value, "voteitemid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("VoteItemID >=", value, "voteitemid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidLessThan(Integer value) {
            addCriterion("VoteItemID <", value, "voteitemid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidLessThanOrEqualTo(Integer value) {
            addCriterion("VoteItemID <=", value, "voteitemid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidIn(List<Integer> values) {
            addCriterion("VoteItemID in", values, "voteitemid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidNotIn(List<Integer> values) {
            addCriterion("VoteItemID not in", values, "voteitemid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidBetween(Integer value1, Integer value2) {
            addCriterion("VoteItemID between", value1, value2, "voteitemid");
            return (Criteria) this;
        }

        public Criteria andVoteitemidNotBetween(Integer value1, Integer value2) {
            addCriterion("VoteItemID not between", value1, value2, "voteitemid");
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