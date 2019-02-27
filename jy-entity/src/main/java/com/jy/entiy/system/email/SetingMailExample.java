package com.jy.entiy.system.email;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SetingMailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SetingMailExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMailServerIsNull() {
            addCriterion("mail_server is null");
            return (Criteria) this;
        }

        public Criteria andMailServerIsNotNull() {
            addCriterion("mail_server is not null");
            return (Criteria) this;
        }

        public Criteria andMailServerEqualTo(String value) {
            addCriterion("mail_server =", value, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerNotEqualTo(String value) {
            addCriterion("mail_server <>", value, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerGreaterThan(String value) {
            addCriterion("mail_server >", value, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerGreaterThanOrEqualTo(String value) {
            addCriterion("mail_server >=", value, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerLessThan(String value) {
            addCriterion("mail_server <", value, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerLessThanOrEqualTo(String value) {
            addCriterion("mail_server <=", value, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerLike(String value) {
            addCriterion("mail_server like", value, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerNotLike(String value) {
            addCriterion("mail_server not like", value, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerIn(List<String> values) {
            addCriterion("mail_server in", values, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerNotIn(List<String> values) {
            addCriterion("mail_server not in", values, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerBetween(String value1, String value2) {
            addCriterion("mail_server between", value1, value2, "mailServer");
            return (Criteria) this;
        }

        public Criteria andMailServerNotBetween(String value1, String value2) {
            addCriterion("mail_server not between", value1, value2, "mailServer");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andSenderipIsNull() {
            addCriterion("senderIP is null");
            return (Criteria) this;
        }

        public Criteria andSenderipIsNotNull() {
            addCriterion("senderIP is not null");
            return (Criteria) this;
        }

        public Criteria andSenderipEqualTo(String value) {
            addCriterion("senderIP =", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipNotEqualTo(String value) {
            addCriterion("senderIP <>", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipGreaterThan(String value) {
            addCriterion("senderIP >", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipGreaterThanOrEqualTo(String value) {
            addCriterion("senderIP >=", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipLessThan(String value) {
            addCriterion("senderIP <", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipLessThanOrEqualTo(String value) {
            addCriterion("senderIP <=", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipLike(String value) {
            addCriterion("senderIP like", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipNotLike(String value) {
            addCriterion("senderIP not like", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipIn(List<String> values) {
            addCriterion("senderIP in", values, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipNotIn(List<String> values) {
            addCriterion("senderIP not in", values, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipBetween(String value1, String value2) {
            addCriterion("senderIP between", value1, value2, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipNotBetween(String value1, String value2) {
            addCriterion("senderIP not between", value1, value2, "senderip");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNull() {
            addCriterion("pass_word is null");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNotNull() {
            addCriterion("pass_word is not null");
            return (Criteria) this;
        }

        public Criteria andPassWordEqualTo(String value) {
            addCriterion("pass_word =", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotEqualTo(String value) {
            addCriterion("pass_word <>", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThan(String value) {
            addCriterion("pass_word >", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThanOrEqualTo(String value) {
            addCriterion("pass_word >=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThan(String value) {
            addCriterion("pass_word <", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThanOrEqualTo(String value) {
            addCriterion("pass_word <=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLike(String value) {
            addCriterion("pass_word like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotLike(String value) {
            addCriterion("pass_word not like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordIn(List<String> values) {
            addCriterion("pass_word in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotIn(List<String> values) {
            addCriterion("pass_word not in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordBetween(String value1, String value2) {
            addCriterion("pass_word between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotBetween(String value1, String value2) {
            addCriterion("pass_word not between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andReceptionipIsNull() {
            addCriterion("receptionIP is null");
            return (Criteria) this;
        }

        public Criteria andReceptionipIsNotNull() {
            addCriterion("receptionIP is not null");
            return (Criteria) this;
        }

        public Criteria andReceptionipEqualTo(String value) {
            addCriterion("receptionIP =", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipNotEqualTo(String value) {
            addCriterion("receptionIP <>", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipGreaterThan(String value) {
            addCriterion("receptionIP >", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipGreaterThanOrEqualTo(String value) {
            addCriterion("receptionIP >=", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipLessThan(String value) {
            addCriterion("receptionIP <", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipLessThanOrEqualTo(String value) {
            addCriterion("receptionIP <=", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipLike(String value) {
            addCriterion("receptionIP like", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipNotLike(String value) {
            addCriterion("receptionIP not like", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipIn(List<String> values) {
            addCriterion("receptionIP in", values, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipNotIn(List<String> values) {
            addCriterion("receptionIP not in", values, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipBetween(String value1, String value2) {
            addCriterion("receptionIP between", value1, value2, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipNotBetween(String value1, String value2) {
            addCriterion("receptionIP not between", value1, value2, "receptionip");
            return (Criteria) this;
        }

        public Criteria andSendTestIsNull() {
            addCriterion("send_test is null");
            return (Criteria) this;
        }

        public Criteria andSendTestIsNotNull() {
            addCriterion("send_test is not null");
            return (Criteria) this;
        }

        public Criteria andSendTestEqualTo(String value) {
            addCriterion("send_test =", value, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestNotEqualTo(String value) {
            addCriterion("send_test <>", value, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestGreaterThan(String value) {
            addCriterion("send_test >", value, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestGreaterThanOrEqualTo(String value) {
            addCriterion("send_test >=", value, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestLessThan(String value) {
            addCriterion("send_test <", value, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestLessThanOrEqualTo(String value) {
            addCriterion("send_test <=", value, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestLike(String value) {
            addCriterion("send_test like", value, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestNotLike(String value) {
            addCriterion("send_test not like", value, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestIn(List<String> values) {
            addCriterion("send_test in", values, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestNotIn(List<String> values) {
            addCriterion("send_test not in", values, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestBetween(String value1, String value2) {
            addCriterion("send_test between", value1, value2, "sendTest");
            return (Criteria) this;
        }

        public Criteria andSendTestNotBetween(String value1, String value2) {
            addCriterion("send_test not between", value1, value2, "sendTest");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Integer value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Integer value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Integer value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Integer value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Integer> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Integer> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Integer value1, Integer value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Integer value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Integer value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Integer value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Integer value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Integer> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Integer> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Integer value1, Integer value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_id not between", value1, value2, "updateId");
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