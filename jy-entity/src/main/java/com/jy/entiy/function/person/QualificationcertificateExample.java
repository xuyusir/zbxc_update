package com.jy.entiy.function.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QualificationcertificateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QualificationcertificateExample() {
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

        public Criteria andQcidIsNull() {
            addCriterion("QCID is null");
            return (Criteria) this;
        }

        public Criteria andQcidIsNotNull() {
            addCriterion("QCID is not null");
            return (Criteria) this;
        }

        public Criteria andQcidEqualTo(Integer value) {
            addCriterion("QCID =", value, "qcid");
            return (Criteria) this;
        }

        public Criteria andQcidNotEqualTo(Integer value) {
            addCriterion("QCID <>", value, "qcid");
            return (Criteria) this;
        }

        public Criteria andQcidGreaterThan(Integer value) {
            addCriterion("QCID >", value, "qcid");
            return (Criteria) this;
        }

        public Criteria andQcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("QCID >=", value, "qcid");
            return (Criteria) this;
        }

        public Criteria andQcidLessThan(Integer value) {
            addCriterion("QCID <", value, "qcid");
            return (Criteria) this;
        }

        public Criteria andQcidLessThanOrEqualTo(Integer value) {
            addCriterion("QCID <=", value, "qcid");
            return (Criteria) this;
        }

        public Criteria andQcidIn(List<Integer> values) {
            addCriterion("QCID in", values, "qcid");
            return (Criteria) this;
        }

        public Criteria andQcidNotIn(List<Integer> values) {
            addCriterion("QCID not in", values, "qcid");
            return (Criteria) this;
        }

        public Criteria andQcidBetween(Integer value1, Integer value2) {
            addCriterion("QCID between", value1, value2, "qcid");
            return (Criteria) this;
        }

        public Criteria andQcidNotBetween(Integer value1, Integer value2) {
            addCriterion("QCID not between", value1, value2, "qcid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidIsNull() {
            addCriterion("CertificateTypeID is null");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidIsNotNull() {
            addCriterion("CertificateTypeID is not null");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidEqualTo(Integer value) {
            addCriterion("CertificateTypeID =", value, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidNotEqualTo(Integer value) {
            addCriterion("CertificateTypeID <>", value, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidGreaterThan(Integer value) {
            addCriterion("CertificateTypeID >", value, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CertificateTypeID >=", value, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidLessThan(Integer value) {
            addCriterion("CertificateTypeID <", value, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidLessThanOrEqualTo(Integer value) {
            addCriterion("CertificateTypeID <=", value, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidIn(List<Integer> values) {
            addCriterion("CertificateTypeID in", values, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidNotIn(List<Integer> values) {
            addCriterion("CertificateTypeID not in", values, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidBetween(Integer value1, Integer value2) {
            addCriterion("CertificateTypeID between", value1, value2, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andCertificatetypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("CertificateTypeID not between", value1, value2, "certificatetypeid");
            return (Criteria) this;
        }

        public Criteria andResumeidIsNull() {
            addCriterion("ResumeID is null");
            return (Criteria) this;
        }

        public Criteria andResumeidIsNotNull() {
            addCriterion("ResumeID is not null");
            return (Criteria) this;
        }

        public Criteria andResumeidEqualTo(Long value) {
            addCriterion("ResumeID =", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidNotEqualTo(Long value) {
            addCriterion("ResumeID <>", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidGreaterThan(Long value) {
            addCriterion("ResumeID >", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidGreaterThanOrEqualTo(Long value) {
            addCriterion("ResumeID >=", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidLessThan(Long value) {
            addCriterion("ResumeID <", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidLessThanOrEqualTo(Long value) {
            addCriterion("ResumeID <=", value, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidIn(List<Long> values) {
            addCriterion("ResumeID in", values, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidNotIn(List<Long> values) {
            addCriterion("ResumeID not in", values, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidBetween(Long value1, Long value2) {
            addCriterion("ResumeID between", value1, value2, "resumeid");
            return (Criteria) this;
        }

        public Criteria andResumeidNotBetween(Long value1, Long value2) {
            addCriterion("ResumeID not between", value1, value2, "resumeid");
            return (Criteria) this;
        }

        public Criteria andQctitleIsNull() {
            addCriterion("QCTitle is null");
            return (Criteria) this;
        }

        public Criteria andQctitleIsNotNull() {
            addCriterion("QCTitle is not null");
            return (Criteria) this;
        }

        public Criteria andQctitleEqualTo(String value) {
            addCriterion("QCTitle =", value, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleNotEqualTo(String value) {
            addCriterion("QCTitle <>", value, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleGreaterThan(String value) {
            addCriterion("QCTitle >", value, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleGreaterThanOrEqualTo(String value) {
            addCriterion("QCTitle >=", value, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleLessThan(String value) {
            addCriterion("QCTitle <", value, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleLessThanOrEqualTo(String value) {
            addCriterion("QCTitle <=", value, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleLike(String value) {
            addCriterion("QCTitle like", value, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleNotLike(String value) {
            addCriterion("QCTitle not like", value, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleIn(List<String> values) {
            addCriterion("QCTitle in", values, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleNotIn(List<String> values) {
            addCriterion("QCTitle not in", values, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleBetween(String value1, String value2) {
            addCriterion("QCTitle between", value1, value2, "qctitle");
            return (Criteria) this;
        }

        public Criteria andQctitleNotBetween(String value1, String value2) {
            addCriterion("QCTitle not between", value1, value2, "qctitle");
            return (Criteria) this;
        }

        public Criteria andIstotalpassIsNull() {
            addCriterion("IsTotalPass is null");
            return (Criteria) this;
        }

        public Criteria andIstotalpassIsNotNull() {
            addCriterion("IsTotalPass is not null");
            return (Criteria) this;
        }

        public Criteria andIstotalpassEqualTo(String value) {
            addCriterion("IsTotalPass =", value, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassNotEqualTo(String value) {
            addCriterion("IsTotalPass <>", value, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassGreaterThan(String value) {
            addCriterion("IsTotalPass >", value, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassGreaterThanOrEqualTo(String value) {
            addCriterion("IsTotalPass >=", value, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassLessThan(String value) {
            addCriterion("IsTotalPass <", value, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassLessThanOrEqualTo(String value) {
            addCriterion("IsTotalPass <=", value, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassLike(String value) {
            addCriterion("IsTotalPass like", value, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassNotLike(String value) {
            addCriterion("IsTotalPass not like", value, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassIn(List<String> values) {
            addCriterion("IsTotalPass in", values, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassNotIn(List<String> values) {
            addCriterion("IsTotalPass not in", values, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassBetween(String value1, String value2) {
            addCriterion("IsTotalPass between", value1, value2, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andIstotalpassNotBetween(String value1, String value2) {
            addCriterion("IsTotalPass not between", value1, value2, "istotalpass");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectIsNull() {
            addCriterion("PassedSubject is null");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectIsNotNull() {
            addCriterion("PassedSubject is not null");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectEqualTo(String value) {
            addCriterion("PassedSubject =", value, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectNotEqualTo(String value) {
            addCriterion("PassedSubject <>", value, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectGreaterThan(String value) {
            addCriterion("PassedSubject >", value, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectGreaterThanOrEqualTo(String value) {
            addCriterion("PassedSubject >=", value, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectLessThan(String value) {
            addCriterion("PassedSubject <", value, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectLessThanOrEqualTo(String value) {
            addCriterion("PassedSubject <=", value, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectLike(String value) {
            addCriterion("PassedSubject like", value, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectNotLike(String value) {
            addCriterion("PassedSubject not like", value, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectIn(List<String> values) {
            addCriterion("PassedSubject in", values, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectNotIn(List<String> values) {
            addCriterion("PassedSubject not in", values, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectBetween(String value1, String value2) {
            addCriterion("PassedSubject between", value1, value2, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andPassedsubjectNotBetween(String value1, String value2) {
            addCriterion("PassedSubject not between", value1, value2, "passedsubject");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("Score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("Score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Float value) {
            addCriterion("Score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Float value) {
            addCriterion("Score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Float value) {
            addCriterion("Score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("Score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Float value) {
            addCriterion("Score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Float value) {
            addCriterion("Score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Float> values) {
            addCriterion("Score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Float> values) {
            addCriterion("Score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Float value1, Float value2) {
            addCriterion("Score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Float value1, Float value2) {
            addCriterion("Score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andQcdateIsNull() {
            addCriterion("QCDate is null");
            return (Criteria) this;
        }

        public Criteria andQcdateIsNotNull() {
            addCriterion("QCDate is not null");
            return (Criteria) this;
        }

        public Criteria andQcdateEqualTo(Date value) {
            addCriterion("QCDate =", value, "qcdate");
            return (Criteria) this;
        }

        public Criteria andQcdateNotEqualTo(Date value) {
            addCriterion("QCDate <>", value, "qcdate");
            return (Criteria) this;
        }

        public Criteria andQcdateGreaterThan(Date value) {
            addCriterion("QCDate >", value, "qcdate");
            return (Criteria) this;
        }

        public Criteria andQcdateGreaterThanOrEqualTo(Date value) {
            addCriterion("QCDate >=", value, "qcdate");
            return (Criteria) this;
        }

        public Criteria andQcdateLessThan(Date value) {
            addCriterion("QCDate <", value, "qcdate");
            return (Criteria) this;
        }

        public Criteria andQcdateLessThanOrEqualTo(Date value) {
            addCriterion("QCDate <=", value, "qcdate");
            return (Criteria) this;
        }

        public Criteria andQcdateIn(List<Date> values) {
            addCriterion("QCDate in", values, "qcdate");
            return (Criteria) this;
        }

        public Criteria andQcdateNotIn(List<Date> values) {
            addCriterion("QCDate not in", values, "qcdate");
            return (Criteria) this;
        }

        public Criteria andQcdateBetween(Date value1, Date value2) {
            addCriterion("QCDate between", value1, value2, "qcdate");
            return (Criteria) this;
        }

        public Criteria andQcdateNotBetween(Date value1, Date value2) {
            addCriterion("QCDate not between", value1, value2, "qcdate");
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