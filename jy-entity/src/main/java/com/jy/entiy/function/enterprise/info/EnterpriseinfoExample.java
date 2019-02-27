package com.jy.entiy.function.enterprise.info;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterpriseinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnterpriseinfoExample() {
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

        public Criteria andEnterprisenameIsNull() {
            addCriterion("EnterpriseName is null");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIsNotNull() {
            addCriterion("EnterpriseName is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameEqualTo(String value) {
            addCriterion("EnterpriseName =", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotEqualTo(String value) {
            addCriterion("EnterpriseName <>", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameGreaterThan(String value) {
            addCriterion("EnterpriseName >", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameGreaterThanOrEqualTo(String value) {
            addCriterion("EnterpriseName >=", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLessThan(String value) {
            addCriterion("EnterpriseName <", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLessThanOrEqualTo(String value) {
            addCriterion("EnterpriseName <=", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameLike(String value) {
            addCriterion("EnterpriseName like", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotLike(String value) {
            addCriterion("EnterpriseName not like", value, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameIn(List<String> values) {
            addCriterion("EnterpriseName in", values, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotIn(List<String> values) {
            addCriterion("EnterpriseName not in", values, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameBetween(String value1, String value2) {
            addCriterion("EnterpriseName between", value1, value2, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andEnterprisenameNotBetween(String value1, String value2) {
            addCriterion("EnterpriseName not between", value1, value2, "enterprisename");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("Introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("Introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("Introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("Introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("Introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("Introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("Introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("Introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("Introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("Introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("Introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("Introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("Introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("Introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlIsNull() {
            addCriterion("EnterpriseUrl is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlIsNotNull() {
            addCriterion("EnterpriseUrl is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlEqualTo(String value) {
            addCriterion("EnterpriseUrl =", value, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlNotEqualTo(String value) {
            addCriterion("EnterpriseUrl <>", value, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlGreaterThan(String value) {
            addCriterion("EnterpriseUrl >", value, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlGreaterThanOrEqualTo(String value) {
            addCriterion("EnterpriseUrl >=", value, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlLessThan(String value) {
            addCriterion("EnterpriseUrl <", value, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlLessThanOrEqualTo(String value) {
            addCriterion("EnterpriseUrl <=", value, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlLike(String value) {
            addCriterion("EnterpriseUrl like", value, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlNotLike(String value) {
            addCriterion("EnterpriseUrl not like", value, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlIn(List<String> values) {
            addCriterion("EnterpriseUrl in", values, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlNotIn(List<String> values) {
            addCriterion("EnterpriseUrl not in", values, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlBetween(String value1, String value2) {
            addCriterion("EnterpriseUrl between", value1, value2, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andEnterpriseurlNotBetween(String value1, String value2) {
            addCriterion("EnterpriseUrl not between", value1, value2, "enterpriseurl");
            return (Criteria) this;
        }

        public Criteria andHeadquartersIsNull() {
            addCriterion("Headquarters is null");
            return (Criteria) this;
        }

        public Criteria andHeadquartersIsNotNull() {
            addCriterion("Headquarters is not null");
            return (Criteria) this;
        }

        public Criteria andHeadquartersEqualTo(String value) {
            addCriterion("Headquarters =", value, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersNotEqualTo(String value) {
            addCriterion("Headquarters <>", value, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersGreaterThan(String value) {
            addCriterion("Headquarters >", value, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersGreaterThanOrEqualTo(String value) {
            addCriterion("Headquarters >=", value, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersLessThan(String value) {
            addCriterion("Headquarters <", value, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersLessThanOrEqualTo(String value) {
            addCriterion("Headquarters <=", value, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersLike(String value) {
            addCriterion("Headquarters like", value, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersNotLike(String value) {
            addCriterion("Headquarters not like", value, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersIn(List<String> values) {
            addCriterion("Headquarters in", values, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersNotIn(List<String> values) {
            addCriterion("Headquarters not in", values, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersBetween(String value1, String value2) {
            addCriterion("Headquarters between", value1, value2, "headquarters");
            return (Criteria) this;
        }

        public Criteria andHeadquartersNotBetween(String value1, String value2) {
            addCriterion("Headquarters not between", value1, value2, "headquarters");
            return (Criteria) this;
        }

        public Criteria andLogofileidIsNull() {
            addCriterion("LogoFileID is null");
            return (Criteria) this;
        }

        public Criteria andLogofileidIsNotNull() {
            addCriterion("LogoFileID is not null");
            return (Criteria) this;
        }

        public Criteria andLogofileidEqualTo(Long value) {
            addCriterion("LogoFileID =", value, "logofileid");
            return (Criteria) this;
        }

        public Criteria andLogofileidNotEqualTo(Long value) {
            addCriterion("LogoFileID <>", value, "logofileid");
            return (Criteria) this;
        }

        public Criteria andLogofileidGreaterThan(Long value) {
            addCriterion("LogoFileID >", value, "logofileid");
            return (Criteria) this;
        }

        public Criteria andLogofileidGreaterThanOrEqualTo(Long value) {
            addCriterion("LogoFileID >=", value, "logofileid");
            return (Criteria) this;
        }

        public Criteria andLogofileidLessThan(Long value) {
            addCriterion("LogoFileID <", value, "logofileid");
            return (Criteria) this;
        }

        public Criteria andLogofileidLessThanOrEqualTo(Long value) {
            addCriterion("LogoFileID <=", value, "logofileid");
            return (Criteria) this;
        }

        public Criteria andLogofileidIn(List<Long> values) {
            addCriterion("LogoFileID in", values, "logofileid");
            return (Criteria) this;
        }

        public Criteria andLogofileidNotIn(List<Long> values) {
            addCriterion("LogoFileID not in", values, "logofileid");
            return (Criteria) this;
        }

        public Criteria andLogofileidBetween(Long value1, Long value2) {
            addCriterion("LogoFileID between", value1, value2, "logofileid");
            return (Criteria) this;
        }

        public Criteria andLogofileidNotBetween(Long value1, Long value2) {
            addCriterion("LogoFileID not between", value1, value2, "logofileid");
            return (Criteria) this;
        }

        public Criteria andContactornameIsNull() {
            addCriterion("ContactorName is null");
            return (Criteria) this;
        }

        public Criteria andContactornameIsNotNull() {
            addCriterion("ContactorName is not null");
            return (Criteria) this;
        }

        public Criteria andContactornameEqualTo(String value) {
            addCriterion("ContactorName =", value, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameNotEqualTo(String value) {
            addCriterion("ContactorName <>", value, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameGreaterThan(String value) {
            addCriterion("ContactorName >", value, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameGreaterThanOrEqualTo(String value) {
            addCriterion("ContactorName >=", value, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameLessThan(String value) {
            addCriterion("ContactorName <", value, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameLessThanOrEqualTo(String value) {
            addCriterion("ContactorName <=", value, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameLike(String value) {
            addCriterion("ContactorName like", value, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameNotLike(String value) {
            addCriterion("ContactorName not like", value, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameIn(List<String> values) {
            addCriterion("ContactorName in", values, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameNotIn(List<String> values) {
            addCriterion("ContactorName not in", values, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameBetween(String value1, String value2) {
            addCriterion("ContactorName between", value1, value2, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactornameNotBetween(String value1, String value2) {
            addCriterion("ContactorName not between", value1, value2, "contactorname");
            return (Criteria) this;
        }

        public Criteria andContactorphoneIsNull() {
            addCriterion("ContactorPhone is null");
            return (Criteria) this;
        }

        public Criteria andContactorphoneIsNotNull() {
            addCriterion("ContactorPhone is not null");
            return (Criteria) this;
        }

        public Criteria andContactorphoneEqualTo(String value) {
            addCriterion("ContactorPhone =", value, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneNotEqualTo(String value) {
            addCriterion("ContactorPhone <>", value, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneGreaterThan(String value) {
            addCriterion("ContactorPhone >", value, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneGreaterThanOrEqualTo(String value) {
            addCriterion("ContactorPhone >=", value, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneLessThan(String value) {
            addCriterion("ContactorPhone <", value, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneLessThanOrEqualTo(String value) {
            addCriterion("ContactorPhone <=", value, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneLike(String value) {
            addCriterion("ContactorPhone like", value, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneNotLike(String value) {
            addCriterion("ContactorPhone not like", value, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneIn(List<String> values) {
            addCriterion("ContactorPhone in", values, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneNotIn(List<String> values) {
            addCriterion("ContactorPhone not in", values, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneBetween(String value1, String value2) {
            addCriterion("ContactorPhone between", value1, value2, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactorphoneNotBetween(String value1, String value2) {
            addCriterion("ContactorPhone not between", value1, value2, "contactorphone");
            return (Criteria) this;
        }

        public Criteria andContactoremailIsNull() {
            addCriterion("ContactorEmail is null");
            return (Criteria) this;
        }

        public Criteria andContactoremailIsNotNull() {
            addCriterion("ContactorEmail is not null");
            return (Criteria) this;
        }

        public Criteria andContactoremailEqualTo(String value) {
            addCriterion("ContactorEmail =", value, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailNotEqualTo(String value) {
            addCriterion("ContactorEmail <>", value, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailGreaterThan(String value) {
            addCriterion("ContactorEmail >", value, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailGreaterThanOrEqualTo(String value) {
            addCriterion("ContactorEmail >=", value, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailLessThan(String value) {
            addCriterion("ContactorEmail <", value, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailLessThanOrEqualTo(String value) {
            addCriterion("ContactorEmail <=", value, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailLike(String value) {
            addCriterion("ContactorEmail like", value, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailNotLike(String value) {
            addCriterion("ContactorEmail not like", value, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailIn(List<String> values) {
            addCriterion("ContactorEmail in", values, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailNotIn(List<String> values) {
            addCriterion("ContactorEmail not in", values, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailBetween(String value1, String value2) {
            addCriterion("ContactorEmail between", value1, value2, "contactoremail");
            return (Criteria) this;
        }

        public Criteria andContactoremailNotBetween(String value1, String value2) {
            addCriterion("ContactorEmail not between", value1, value2, "contactoremail");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("Status not between", value1, value2, "status");
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

        public Criteria andCreaepersonidIsNull() {
            addCriterion("CreaePersonID is null");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidIsNotNull() {
            addCriterion("CreaePersonID is not null");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidEqualTo(Long value) {
            addCriterion("CreaePersonID =", value, "creaepersonid");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidNotEqualTo(Long value) {
            addCriterion("CreaePersonID <>", value, "creaepersonid");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidGreaterThan(Long value) {
            addCriterion("CreaePersonID >", value, "creaepersonid");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidGreaterThanOrEqualTo(Long value) {
            addCriterion("CreaePersonID >=", value, "creaepersonid");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidLessThan(Long value) {
            addCriterion("CreaePersonID <", value, "creaepersonid");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidLessThanOrEqualTo(Long value) {
            addCriterion("CreaePersonID <=", value, "creaepersonid");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidIn(List<Long> values) {
            addCriterion("CreaePersonID in", values, "creaepersonid");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidNotIn(List<Long> values) {
            addCriterion("CreaePersonID not in", values, "creaepersonid");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidBetween(Long value1, Long value2) {
            addCriterion("CreaePersonID between", value1, value2, "creaepersonid");
            return (Criteria) this;
        }

        public Criteria andCreaepersonidNotBetween(Long value1, Long value2) {
            addCriterion("CreaePersonID not between", value1, value2, "creaepersonid");
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