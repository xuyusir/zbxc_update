package com.jy.entiy.function.enterprise.recruitment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EnterpriserecruitingprocessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriserecruitingprocessExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andApplicationstatusidIsNull() {
            addCriterion("ApplicationStatusID is null");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidIsNotNull() {
            addCriterion("ApplicationStatusID is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidEqualTo(Integer value) {
            addCriterion("ApplicationStatusID =", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidNotEqualTo(Integer value) {
            addCriterion("ApplicationStatusID <>", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidGreaterThan(Integer value) {
            addCriterion("ApplicationStatusID >", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ApplicationStatusID >=", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidLessThan(Integer value) {
            addCriterion("ApplicationStatusID <", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidLessThanOrEqualTo(Integer value) {
            addCriterion("ApplicationStatusID <=", value, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidIn(List<Integer> values) {
            addCriterion("ApplicationStatusID in", values, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidNotIn(List<Integer> values) {
            addCriterion("ApplicationStatusID not in", values, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidBetween(Integer value1, Integer value2) {
            addCriterion("ApplicationStatusID between", value1, value2, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andApplicationstatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("ApplicationStatusID not between", value1, value2, "applicationstatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidIsNull() {
            addCriterion("PDeliveryStatusID is null");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidIsNotNull() {
            addCriterion("PDeliveryStatusID is not null");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidEqualTo(Integer value) {
            addCriterion("PDeliveryStatusID =", value, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidNotEqualTo(Integer value) {
            addCriterion("PDeliveryStatusID <>", value, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidGreaterThan(Integer value) {
            addCriterion("PDeliveryStatusID >", value, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PDeliveryStatusID >=", value, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidLessThan(Integer value) {
            addCriterion("PDeliveryStatusID <", value, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidLessThanOrEqualTo(Integer value) {
            addCriterion("PDeliveryStatusID <=", value, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidIn(List<Integer> values) {
            addCriterion("PDeliveryStatusID in", values, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidNotIn(List<Integer> values) {
            addCriterion("PDeliveryStatusID not in", values, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidBetween(Integer value1, Integer value2) {
            addCriterion("PDeliveryStatusID between", value1, value2, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andPdeliverystatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("PDeliveryStatusID not between", value1, value2, "pdeliverystatusid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidIsNull() {
            addCriterion("EnterpriseID is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidIsNotNull() {
            addCriterion("EnterpriseID is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidEqualTo(Integer value) {
            addCriterion("EnterpriseID =", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidNotEqualTo(Integer value) {
            addCriterion("EnterpriseID <>", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidGreaterThan(Integer value) {
            addCriterion("EnterpriseID >", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EnterpriseID >=", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidLessThan(Integer value) {
            addCriterion("EnterpriseID <", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidLessThanOrEqualTo(Integer value) {
            addCriterion("EnterpriseID <=", value, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidIn(List<Integer> values) {
            addCriterion("EnterpriseID in", values, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidNotIn(List<Integer> values) {
            addCriterion("EnterpriseID not in", values, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidBetween(Integer value1, Integer value2) {
            addCriterion("EnterpriseID between", value1, value2, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseidNotBetween(Integer value1, Integer value2) {
            addCriterion("EnterpriseID not between", value1, value2, "enterpriseid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidIsNull() {
            addCriterion("EJobVacancyID is null");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidIsNotNull() {
            addCriterion("EJobVacancyID is not null");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidEqualTo(Integer value) {
            addCriterion("EJobVacancyID =", value, "ejobvacancyid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidNotEqualTo(Integer value) {
            addCriterion("EJobVacancyID <>", value, "ejobvacancyid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidGreaterThan(Integer value) {
            addCriterion("EJobVacancyID >", value, "ejobvacancyid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EJobVacancyID >=", value, "ejobvacancyid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidLessThan(Integer value) {
            addCriterion("EJobVacancyID <", value, "ejobvacancyid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidLessThanOrEqualTo(Integer value) {
            addCriterion("EJobVacancyID <=", value, "ejobvacancyid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidIn(List<Integer> values) {
            addCriterion("EJobVacancyID in", values, "ejobvacancyid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidNotIn(List<Integer> values) {
            addCriterion("EJobVacancyID not in", values, "ejobvacancyid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidBetween(Integer value1, Integer value2) {
            addCriterion("EJobVacancyID between", value1, value2, "ejobvacancyid");
            return (Criteria) this;
        }

        public Criteria andEjobvacancyidNotBetween(Integer value1, Integer value2) {
            addCriterion("EJobVacancyID not between", value1, value2, "ejobvacancyid");
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

        public Criteria andHandletimeIsNull() {
            addCriterion("HandleTime is null");
            return (Criteria) this;
        }

        public Criteria andHandletimeIsNotNull() {
            addCriterion("HandleTime is not null");
            return (Criteria) this;
        }

        public Criteria andHandletimeEqualTo(Date value) {
            addCriterion("HandleTime =", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeNotEqualTo(Date value) {
            addCriterion("HandleTime <>", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeGreaterThan(Date value) {
            addCriterion("HandleTime >", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeGreaterThanOrEqualTo(Date value) {
            addCriterion("HandleTime >=", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeLessThan(Date value) {
            addCriterion("HandleTime <", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeLessThanOrEqualTo(Date value) {
            addCriterion("HandleTime <=", value, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeIn(List<Date> values) {
            addCriterion("HandleTime in", values, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeNotIn(List<Date> values) {
            addCriterion("HandleTime not in", values, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeBetween(Date value1, Date value2) {
            addCriterion("HandleTime between", value1, value2, "handletime");
            return (Criteria) this;
        }

        public Criteria andHandletimeNotBetween(Date value1, Date value2) {
            addCriterion("HandleTime not between", value1, value2, "handletime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIsNull() {
            addCriterion("ApplicationTime is null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIsNotNull() {
            addCriterion("ApplicationTime is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeEqualTo(Date value) {
            addCriterion("ApplicationTime =", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotEqualTo(Date value) {
            addCriterion("ApplicationTime <>", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThan(Date value) {
            addCriterion("ApplicationTime >", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ApplicationTime >=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThan(Date value) {
            addCriterion("ApplicationTime <", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeLessThanOrEqualTo(Date value) {
            addCriterion("ApplicationTime <=", value, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeIn(List<Date> values) {
            addCriterion("ApplicationTime in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotIn(List<Date> values) {
            addCriterion("ApplicationTime not in", values, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeBetween(Date value1, Date value2) {
            addCriterion("ApplicationTime between", value1, value2, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andApplicationtimeNotBetween(Date value1, Date value2) {
            addCriterion("ApplicationTime not between", value1, value2, "applicationtime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeIsNull() {
            addCriterion("ConfirmEntryTime is null");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeIsNotNull() {
            addCriterion("ConfirmEntryTime is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeEqualTo(Date value) {
            addCriterionForJDBCDate("ConfirmEntryTime =", value, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ConfirmEntryTime <>", value, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ConfirmEntryTime >", value, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ConfirmEntryTime >=", value, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeLessThan(Date value) {
            addCriterionForJDBCDate("ConfirmEntryTime <", value, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ConfirmEntryTime <=", value, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeIn(List<Date> values) {
            addCriterionForJDBCDate("ConfirmEntryTime in", values, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ConfirmEntryTime not in", values, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ConfirmEntryTime between", value1, value2, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andConfirmentrytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ConfirmEntryTime not between", value1, value2, "confirmentrytime");
            return (Criteria) this;
        }

        public Criteria andInterviewdateIsNull() {
            addCriterion("InterviewDate is null");
            return (Criteria) this;
        }

        public Criteria andInterviewdateIsNotNull() {
            addCriterion("InterviewDate is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewdateEqualTo(Date value) {
            addCriterion("InterviewDate =", value, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andInterviewdateNotEqualTo(Date value) {
            addCriterion("InterviewDate <>", value, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andInterviewdateGreaterThan(Date value) {
            addCriterion("InterviewDate >", value, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andInterviewdateGreaterThanOrEqualTo(Date value) {
            addCriterion("InterviewDate >=", value, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andInterviewdateLessThan(Date value) {
            addCriterion("InterviewDate <", value, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andInterviewdateLessThanOrEqualTo(Date value) {
            addCriterion("InterviewDate <=", value, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andInterviewdateIn(List<Date> values) {
            addCriterion("InterviewDate in", values, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andInterviewdateNotIn(List<Date> values) {
            addCriterion("InterviewDate not in", values, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andInterviewdateBetween(Date value1, Date value2) {
            addCriterion("InterviewDate between", value1, value2, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andInterviewdateNotBetween(Date value1, Date value2) {
            addCriterion("InterviewDate not between", value1, value2, "interviewdate");
            return (Criteria) this;
        }

        public Criteria andServicenoIsNull() {
            addCriterion("ServiceNo is null");
            return (Criteria) this;
        }

        public Criteria andServicenoIsNotNull() {
            addCriterion("ServiceNo is not null");
            return (Criteria) this;
        }

        public Criteria andServicenoEqualTo(String value) {
            addCriterion("ServiceNo =", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotEqualTo(String value) {
            addCriterion("ServiceNo <>", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoGreaterThan(String value) {
            addCriterion("ServiceNo >", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoGreaterThanOrEqualTo(String value) {
            addCriterion("ServiceNo >=", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoLessThan(String value) {
            addCriterion("ServiceNo <", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoLessThanOrEqualTo(String value) {
            addCriterion("ServiceNo <=", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoLike(String value) {
            addCriterion("ServiceNo like", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotLike(String value) {
            addCriterion("ServiceNo not like", value, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoIn(List<String> values) {
            addCriterion("ServiceNo in", values, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotIn(List<String> values) {
            addCriterion("ServiceNo not in", values, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoBetween(String value1, String value2) {
            addCriterion("ServiceNo between", value1, value2, "serviceno");
            return (Criteria) this;
        }

        public Criteria andServicenoNotBetween(String value1, String value2) {
            addCriterion("ServiceNo not between", value1, value2, "serviceno");
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
