package com.jy.entiy.function.enterprise.enterpriseFunction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonrecruitingprocessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonrecruitingprocessExample() {
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

        public Criteria andPersonrecruitingprocessidIsNull() {
            addCriterion("PersonRecruitingProcessID is null");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidIsNotNull() {
            addCriterion("PersonRecruitingProcessID is not null");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidEqualTo(Long value) {
            addCriterion("PersonRecruitingProcessID =", value, "personrecruitingprocessid");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidNotEqualTo(Long value) {
            addCriterion("PersonRecruitingProcessID <>", value, "personrecruitingprocessid");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidGreaterThan(Long value) {
            addCriterion("PersonRecruitingProcessID >", value, "personrecruitingprocessid");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidGreaterThanOrEqualTo(Long value) {
            addCriterion("PersonRecruitingProcessID >=", value, "personrecruitingprocessid");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidLessThan(Long value) {
            addCriterion("PersonRecruitingProcessID <", value, "personrecruitingprocessid");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidLessThanOrEqualTo(Long value) {
            addCriterion("PersonRecruitingProcessID <=", value, "personrecruitingprocessid");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidIn(List<Long> values) {
            addCriterion("PersonRecruitingProcessID in", values, "personrecruitingprocessid");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidNotIn(List<Long> values) {
            addCriterion("PersonRecruitingProcessID not in", values, "personrecruitingprocessid");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidBetween(Long value1, Long value2) {
            addCriterion("PersonRecruitingProcessID between", value1, value2, "personrecruitingprocessid");
            return (Criteria) this;
        }

        public Criteria andPersonrecruitingprocessidNotBetween(Long value1, Long value2) {
            addCriterion("PersonRecruitingProcessID not between", value1, value2, "personrecruitingprocessid");
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

        public Criteria andRecommendsuccessnoIsNull() {
            addCriterion("RecommendSuccessNo is null");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoIsNotNull() {
            addCriterion("RecommendSuccessNo is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoEqualTo(Integer value) {
            addCriterion("RecommendSuccessNo =", value, "recommendsuccessno");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoNotEqualTo(Integer value) {
            addCriterion("RecommendSuccessNo <>", value, "recommendsuccessno");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoGreaterThan(Integer value) {
            addCriterion("RecommendSuccessNo >", value, "recommendsuccessno");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("RecommendSuccessNo >=", value, "recommendsuccessno");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoLessThan(Integer value) {
            addCriterion("RecommendSuccessNo <", value, "recommendsuccessno");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoLessThanOrEqualTo(Integer value) {
            addCriterion("RecommendSuccessNo <=", value, "recommendsuccessno");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoIn(List<Integer> values) {
            addCriterion("RecommendSuccessNo in", values, "recommendsuccessno");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoNotIn(List<Integer> values) {
            addCriterion("RecommendSuccessNo not in", values, "recommendsuccessno");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoBetween(Integer value1, Integer value2) {
            addCriterion("RecommendSuccessNo between", value1, value2, "recommendsuccessno");
            return (Criteria) this;
        }

        public Criteria andRecommendsuccessnoNotBetween(Integer value1, Integer value2) {
            addCriterion("RecommendSuccessNo not between", value1, value2, "recommendsuccessno");
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
