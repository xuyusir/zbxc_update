package com.jy.entiy.function.enterprise.enterpriseFunction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterpriseappraiseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseappraiseExample() {
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

        public Criteria andEnterpriseappraiseidIsNull() {
            addCriterion("EnterpriseAppraiseID is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidIsNotNull() {
            addCriterion("EnterpriseAppraiseID is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidEqualTo(Long value) {
            addCriterion("EnterpriseAppraiseID =", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidNotEqualTo(Long value) {
            addCriterion("EnterpriseAppraiseID <>", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidGreaterThan(Long value) {
            addCriterion("EnterpriseAppraiseID >", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidGreaterThanOrEqualTo(Long value) {
            addCriterion("EnterpriseAppraiseID >=", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidLessThan(Long value) {
            addCriterion("EnterpriseAppraiseID <", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidLessThanOrEqualTo(Long value) {
            addCriterion("EnterpriseAppraiseID <=", value, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidIn(List<Long> values) {
            addCriterion("EnterpriseAppraiseID in", values, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidNotIn(List<Long> values) {
            addCriterion("EnterpriseAppraiseID not in", values, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidBetween(Long value1, Long value2) {
            addCriterion("EnterpriseAppraiseID between", value1, value2, "enterpriseappraiseid");
            return (Criteria) this;
        }

        public Criteria andEnterpriseappraiseidNotBetween(Long value1, Long value2) {
            addCriterion("EnterpriseAppraiseID not between", value1, value2, "enterpriseappraiseid");
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

        public Criteria andAppraisedetailIsNull() {
            addCriterion("AppraiseDetail is null");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailIsNotNull() {
            addCriterion("AppraiseDetail is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailEqualTo(String value) {
            addCriterion("AppraiseDetail =", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailNotEqualTo(String value) {
            addCriterion("AppraiseDetail <>", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailGreaterThan(String value) {
            addCriterion("AppraiseDetail >", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailGreaterThanOrEqualTo(String value) {
            addCriterion("AppraiseDetail >=", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailLessThan(String value) {
            addCriterion("AppraiseDetail <", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailLessThanOrEqualTo(String value) {
            addCriterion("AppraiseDetail <=", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailLike(String value) {
            addCriterion("AppraiseDetail like", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailNotLike(String value) {
            addCriterion("AppraiseDetail not like", value, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailIn(List<String> values) {
            addCriterion("AppraiseDetail in", values, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailNotIn(List<String> values) {
            addCriterion("AppraiseDetail not in", values, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailBetween(String value1, String value2) {
            addCriterion("AppraiseDetail between", value1, value2, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisedetailNotBetween(String value1, String value2) {
            addCriterion("AppraiseDetail not between", value1, value2, "appraisedetail");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeIsNull() {
            addCriterion("AppraiseTime is null");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeIsNotNull() {
            addCriterion("AppraiseTime is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeEqualTo(Date value) {
            addCriterion("AppraiseTime =", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeNotEqualTo(Date value) {
            addCriterion("AppraiseTime <>", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeGreaterThan(Date value) {
            addCriterion("AppraiseTime >", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AppraiseTime >=", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeLessThan(Date value) {
            addCriterion("AppraiseTime <", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeLessThanOrEqualTo(Date value) {
            addCriterion("AppraiseTime <=", value, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeIn(List<Date> values) {
            addCriterion("AppraiseTime in", values, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeNotIn(List<Date> values) {
            addCriterion("AppraiseTime not in", values, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeBetween(Date value1, Date value2) {
            addCriterion("AppraiseTime between", value1, value2, "appraisetime");
            return (Criteria) this;
        }

        public Criteria andAppraisetimeNotBetween(Date value1, Date value2) {
            addCriterion("AppraiseTime not between", value1, value2, "appraisetime");
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