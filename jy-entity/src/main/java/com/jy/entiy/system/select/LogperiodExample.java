package com.jy.entiy.system.select;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogperiodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogperiodExample() {
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

        public Criteria andLogperiodidIsNull() {
            addCriterion("LogPeriodID is null");
            return (Criteria) this;
        }

        public Criteria andLogperiodidIsNotNull() {
            addCriterion("LogPeriodID is not null");
            return (Criteria) this;
        }

        public Criteria andLogperiodidEqualTo(Integer value) {
            addCriterion("LogPeriodID =", value, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodidNotEqualTo(Integer value) {
            addCriterion("LogPeriodID <>", value, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodidGreaterThan(Integer value) {
            addCriterion("LogPeriodID >", value, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LogPeriodID >=", value, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodidLessThan(Integer value) {
            addCriterion("LogPeriodID <", value, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodidLessThanOrEqualTo(Integer value) {
            addCriterion("LogPeriodID <=", value, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodidIn(List<Integer> values) {
            addCriterion("LogPeriodID in", values, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodidNotIn(List<Integer> values) {
            addCriterion("LogPeriodID not in", values, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodidBetween(Integer value1, Integer value2) {
            addCriterion("LogPeriodID between", value1, value2, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodidNotBetween(Integer value1, Integer value2) {
            addCriterion("LogPeriodID not between", value1, value2, "logperiodid");
            return (Criteria) this;
        }

        public Criteria andLogperiodIsNull() {
            addCriterion("LogPeriod is null");
            return (Criteria) this;
        }

        public Criteria andLogperiodIsNotNull() {
            addCriterion("LogPeriod is not null");
            return (Criteria) this;
        }

        public Criteria andLogperiodEqualTo(String value) {
            addCriterion("LogPeriod =", value, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodNotEqualTo(String value) {
            addCriterion("LogPeriod <>", value, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodGreaterThan(String value) {
            addCriterion("LogPeriod >", value, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodGreaterThanOrEqualTo(String value) {
            addCriterion("LogPeriod >=", value, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodLessThan(String value) {
            addCriterion("LogPeriod <", value, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodLessThanOrEqualTo(String value) {
            addCriterion("LogPeriod <=", value, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodLike(String value) {
            addCriterion("LogPeriod like", value, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodNotLike(String value) {
            addCriterion("LogPeriod not like", value, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodIn(List<String> values) {
            addCriterion("LogPeriod in", values, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodNotIn(List<String> values) {
            addCriterion("LogPeriod not in", values, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodBetween(String value1, String value2) {
            addCriterion("LogPeriod between", value1, value2, "logperiod");
            return (Criteria) this;
        }

        public Criteria andLogperiodNotBetween(String value1, String value2) {
            addCriterion("LogPeriod not between", value1, value2, "logperiod");
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

        public Criteria andUdpatebyIsNull() {
            addCriterion("UdpateBy is null");
            return (Criteria) this;
        }

        public Criteria andUdpatebyIsNotNull() {
            addCriterion("UdpateBy is not null");
            return (Criteria) this;
        }

        public Criteria andUdpatebyEqualTo(String value) {
            addCriterion("UdpateBy =", value, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyNotEqualTo(String value) {
            addCriterion("UdpateBy <>", value, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyGreaterThan(String value) {
            addCriterion("UdpateBy >", value, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyGreaterThanOrEqualTo(String value) {
            addCriterion("UdpateBy >=", value, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyLessThan(String value) {
            addCriterion("UdpateBy <", value, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyLessThanOrEqualTo(String value) {
            addCriterion("UdpateBy <=", value, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyLike(String value) {
            addCriterion("UdpateBy like", value, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyNotLike(String value) {
            addCriterion("UdpateBy not like", value, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyIn(List<String> values) {
            addCriterion("UdpateBy in", values, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyNotIn(List<String> values) {
            addCriterion("UdpateBy not in", values, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyBetween(String value1, String value2) {
            addCriterion("UdpateBy between", value1, value2, "udpateby");
            return (Criteria) this;
        }

        public Criteria andUdpatebyNotBetween(String value1, String value2) {
            addCriterion("UdpateBy not between", value1, value2, "udpateby");
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

        public Criteria andUdpatepersonidIsNull() {
            addCriterion("UdpatePersonID is null");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidIsNotNull() {
            addCriterion("UdpatePersonID is not null");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidEqualTo(Long value) {
            addCriterion("UdpatePersonID =", value, "udpatepersonid");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidNotEqualTo(Long value) {
            addCriterion("UdpatePersonID <>", value, "udpatepersonid");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidGreaterThan(Long value) {
            addCriterion("UdpatePersonID >", value, "udpatepersonid");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidGreaterThanOrEqualTo(Long value) {
            addCriterion("UdpatePersonID >=", value, "udpatepersonid");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidLessThan(Long value) {
            addCriterion("UdpatePersonID <", value, "udpatepersonid");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidLessThanOrEqualTo(Long value) {
            addCriterion("UdpatePersonID <=", value, "udpatepersonid");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidIn(List<Long> values) {
            addCriterion("UdpatePersonID in", values, "udpatepersonid");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidNotIn(List<Long> values) {
            addCriterion("UdpatePersonID not in", values, "udpatepersonid");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidBetween(Long value1, Long value2) {
            addCriterion("UdpatePersonID between", value1, value2, "udpatepersonid");
            return (Criteria) this;
        }

        public Criteria andUdpatepersonidNotBetween(Long value1, Long value2) {
            addCriterion("UdpatePersonID not between", value1, value2, "udpatepersonid");
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

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("Code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("Code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("Code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("Code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("Code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("Code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("Code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("Code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("Code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("Code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("Code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("Code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("Code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andDispalyorderIsNull() {
            addCriterion("DispalyOrder is null");
            return (Criteria) this;
        }

        public Criteria andDispalyorderIsNotNull() {
            addCriterion("DispalyOrder is not null");
            return (Criteria) this;
        }

        public Criteria andDispalyorderEqualTo(Integer value) {
            addCriterion("DispalyOrder =", value, "dispalyorder");
            return (Criteria) this;
        }

        public Criteria andDispalyorderNotEqualTo(Integer value) {
            addCriterion("DispalyOrder <>", value, "dispalyorder");
            return (Criteria) this;
        }

        public Criteria andDispalyorderGreaterThan(Integer value) {
            addCriterion("DispalyOrder >", value, "dispalyorder");
            return (Criteria) this;
        }

        public Criteria andDispalyorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("DispalyOrder >=", value, "dispalyorder");
            return (Criteria) this;
        }

        public Criteria andDispalyorderLessThan(Integer value) {
            addCriterion("DispalyOrder <", value, "dispalyorder");
            return (Criteria) this;
        }

        public Criteria andDispalyorderLessThanOrEqualTo(Integer value) {
            addCriterion("DispalyOrder <=", value, "dispalyorder");
            return (Criteria) this;
        }

        public Criteria andDispalyorderIn(List<Integer> values) {
            addCriterion("DispalyOrder in", values, "dispalyorder");
            return (Criteria) this;
        }

        public Criteria andDispalyorderNotIn(List<Integer> values) {
            addCriterion("DispalyOrder not in", values, "dispalyorder");
            return (Criteria) this;
        }

        public Criteria andDispalyorderBetween(Integer value1, Integer value2) {
            addCriterion("DispalyOrder between", value1, value2, "dispalyorder");
            return (Criteria) this;
        }

        public Criteria andDispalyorderNotBetween(Integer value1, Integer value2) {
            addCriterion("DispalyOrder not between", value1, value2, "dispalyorder");
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