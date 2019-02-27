package com.jy.entiy.system.email;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SetmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SetmailExample() {
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

        public Criteria andSetmailidIsNull() {
            addCriterion("SetMailID is null");
            return (Criteria) this;
        }

        public Criteria andSetmailidIsNotNull() {
            addCriterion("SetMailID is not null");
            return (Criteria) this;
        }

        public Criteria andSetmailidEqualTo(Integer value) {
            addCriterion("SetMailID =", value, "setmailid");
            return (Criteria) this;
        }

        public Criteria andSetmailidNotEqualTo(Integer value) {
            addCriterion("SetMailID <>", value, "setmailid");
            return (Criteria) this;
        }

        public Criteria andSetmailidGreaterThan(Integer value) {
            addCriterion("SetMailID >", value, "setmailid");
            return (Criteria) this;
        }

        public Criteria andSetmailidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SetMailID >=", value, "setmailid");
            return (Criteria) this;
        }

        public Criteria andSetmailidLessThan(Integer value) {
            addCriterion("SetMailID <", value, "setmailid");
            return (Criteria) this;
        }

        public Criteria andSetmailidLessThanOrEqualTo(Integer value) {
            addCriterion("SetMailID <=", value, "setmailid");
            return (Criteria) this;
        }

        public Criteria andSetmailidIn(List<Integer> values) {
            addCriterion("SetMailID in", values, "setmailid");
            return (Criteria) this;
        }

        public Criteria andSetmailidNotIn(List<Integer> values) {
            addCriterion("SetMailID not in", values, "setmailid");
            return (Criteria) this;
        }

        public Criteria andSetmailidBetween(Integer value1, Integer value2) {
            addCriterion("SetMailID between", value1, value2, "setmailid");
            return (Criteria) this;
        }

        public Criteria andSetmailidNotBetween(Integer value1, Integer value2) {
            addCriterion("SetMailID not between", value1, value2, "setmailid");
            return (Criteria) this;
        }

        public Criteria andMailserverIsNull() {
            addCriterion("MailServer is null");
            return (Criteria) this;
        }

        public Criteria andMailserverIsNotNull() {
            addCriterion("MailServer is not null");
            return (Criteria) this;
        }

        public Criteria andMailserverEqualTo(String value) {
            addCriterion("MailServer =", value, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverNotEqualTo(String value) {
            addCriterion("MailServer <>", value, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverGreaterThan(String value) {
            addCriterion("MailServer >", value, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverGreaterThanOrEqualTo(String value) {
            addCriterion("MailServer >=", value, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverLessThan(String value) {
            addCriterion("MailServer <", value, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverLessThanOrEqualTo(String value) {
            addCriterion("MailServer <=", value, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverLike(String value) {
            addCriterion("MailServer like", value, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverNotLike(String value) {
            addCriterion("MailServer not like", value, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverIn(List<String> values) {
            addCriterion("MailServer in", values, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverNotIn(List<String> values) {
            addCriterion("MailServer not in", values, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverBetween(String value1, String value2) {
            addCriterion("MailServer between", value1, value2, "mailserver");
            return (Criteria) this;
        }

        public Criteria andMailserverNotBetween(String value1, String value2) {
            addCriterion("MailServer not between", value1, value2, "mailserver");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("Port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("Port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("Port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("Port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("Port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("Port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("Port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("Port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("Port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("Port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("Port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("Port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("Port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("Port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andSenderipIsNull() {
            addCriterion("SenderIP is null");
            return (Criteria) this;
        }

        public Criteria andSenderipIsNotNull() {
            addCriterion("SenderIP is not null");
            return (Criteria) this;
        }

        public Criteria andSenderipEqualTo(String value) {
            addCriterion("SenderIP =", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipNotEqualTo(String value) {
            addCriterion("SenderIP <>", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipGreaterThan(String value) {
            addCriterion("SenderIP >", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipGreaterThanOrEqualTo(String value) {
            addCriterion("SenderIP >=", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipLessThan(String value) {
            addCriterion("SenderIP <", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipLessThanOrEqualTo(String value) {
            addCriterion("SenderIP <=", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipLike(String value) {
            addCriterion("SenderIP like", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipNotLike(String value) {
            addCriterion("SenderIP not like", value, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipIn(List<String> values) {
            addCriterion("SenderIP in", values, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipNotIn(List<String> values) {
            addCriterion("SenderIP not in", values, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipBetween(String value1, String value2) {
            addCriterion("SenderIP between", value1, value2, "senderip");
            return (Criteria) this;
        }

        public Criteria andSenderipNotBetween(String value1, String value2) {
            addCriterion("SenderIP not between", value1, value2, "senderip");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PassWord is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PassWord is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PassWord =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PassWord <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PassWord >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PassWord >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PassWord <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PassWord <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PassWord like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PassWord not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PassWord in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PassWord not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PassWord between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PassWord not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andReceptionipIsNull() {
            addCriterion("ReceptionIP is null");
            return (Criteria) this;
        }

        public Criteria andReceptionipIsNotNull() {
            addCriterion("ReceptionIP is not null");
            return (Criteria) this;
        }

        public Criteria andReceptionipEqualTo(String value) {
            addCriterion("ReceptionIP =", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipNotEqualTo(String value) {
            addCriterion("ReceptionIP <>", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipGreaterThan(String value) {
            addCriterion("ReceptionIP >", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipGreaterThanOrEqualTo(String value) {
            addCriterion("ReceptionIP >=", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipLessThan(String value) {
            addCriterion("ReceptionIP <", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipLessThanOrEqualTo(String value) {
            addCriterion("ReceptionIP <=", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipLike(String value) {
            addCriterion("ReceptionIP like", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipNotLike(String value) {
            addCriterion("ReceptionIP not like", value, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipIn(List<String> values) {
            addCriterion("ReceptionIP in", values, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipNotIn(List<String> values) {
            addCriterion("ReceptionIP not in", values, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipBetween(String value1, String value2) {
            addCriterion("ReceptionIP between", value1, value2, "receptionip");
            return (Criteria) this;
        }

        public Criteria andReceptionipNotBetween(String value1, String value2) {
            addCriterion("ReceptionIP not between", value1, value2, "receptionip");
            return (Criteria) this;
        }

        public Criteria andSendtestIsNull() {
            addCriterion("SendTest is null");
            return (Criteria) this;
        }

        public Criteria andSendtestIsNotNull() {
            addCriterion("SendTest is not null");
            return (Criteria) this;
        }

        public Criteria andSendtestEqualTo(String value) {
            addCriterion("SendTest =", value, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestNotEqualTo(String value) {
            addCriterion("SendTest <>", value, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestGreaterThan(String value) {
            addCriterion("SendTest >", value, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestGreaterThanOrEqualTo(String value) {
            addCriterion("SendTest >=", value, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestLessThan(String value) {
            addCriterion("SendTest <", value, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestLessThanOrEqualTo(String value) {
            addCriterion("SendTest <=", value, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestLike(String value) {
            addCriterion("SendTest like", value, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestNotLike(String value) {
            addCriterion("SendTest not like", value, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestIn(List<String> values) {
            addCriterion("SendTest in", values, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestNotIn(List<String> values) {
            addCriterion("SendTest not in", values, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestBetween(String value1, String value2) {
            addCriterion("SendTest between", value1, value2, "sendtest");
            return (Criteria) this;
        }

        public Criteria andSendtestNotBetween(String value1, String value2) {
            addCriterion("SendTest not between", value1, value2, "sendtest");
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

        public Criteria andUpdatepersonidIsNull() {
            addCriterion("UpdatePersonID is null");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidIsNotNull() {
            addCriterion("UpdatePersonID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidEqualTo(Long value) {
            addCriterion("UpdatePersonID =", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidNotEqualTo(Long value) {
            addCriterion("UpdatePersonID <>", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidGreaterThan(Long value) {
            addCriterion("UpdatePersonID >", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidGreaterThanOrEqualTo(Long value) {
            addCriterion("UpdatePersonID >=", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidLessThan(Long value) {
            addCriterion("UpdatePersonID <", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidLessThanOrEqualTo(Long value) {
            addCriterion("UpdatePersonID <=", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidIn(List<Long> values) {
            addCriterion("UpdatePersonID in", values, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidNotIn(List<Long> values) {
            addCriterion("UpdatePersonID not in", values, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidBetween(Long value1, Long value2) {
            addCriterion("UpdatePersonID between", value1, value2, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidNotBetween(Long value1, Long value2) {
            addCriterion("UpdatePersonID not between", value1, value2, "updatepersonid");
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

        public Criteria andUpdatebyIsNull() {
            addCriterion("UpdateBy is null");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIsNotNull() {
            addCriterion("UpdateBy is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatebyEqualTo(String value) {
            addCriterion("UpdateBy =", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotEqualTo(String value) {
            addCriterion("UpdateBy <>", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyGreaterThan(String value) {
            addCriterion("UpdateBy >", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyGreaterThanOrEqualTo(String value) {
            addCriterion("UpdateBy >=", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLessThan(String value) {
            addCriterion("UpdateBy <", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLessThanOrEqualTo(String value) {
            addCriterion("UpdateBy <=", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyLike(String value) {
            addCriterion("UpdateBy like", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotLike(String value) {
            addCriterion("UpdateBy not like", value, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyIn(List<String> values) {
            addCriterion("UpdateBy in", values, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotIn(List<String> values) {
            addCriterion("UpdateBy not in", values, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyBetween(String value1, String value2) {
            addCriterion("UpdateBy between", value1, value2, "updateby");
            return (Criteria) this;
        }

        public Criteria andUpdatebyNotBetween(String value1, String value2) {
            addCriterion("UpdateBy not between", value1, value2, "updateby");
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