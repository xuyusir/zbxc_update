package com.jy.entiy.content.product.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SectionExample() {
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

        public Criteria andSectionidIsNull() {
            addCriterion("SectionID is null");
            return (Criteria) this;
        }

        public Criteria andSectionidIsNotNull() {
            addCriterion("SectionID is not null");
            return (Criteria) this;
        }

        public Criteria andSectionidEqualTo(Long value) {
            addCriterion("SectionID =", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotEqualTo(Long value) {
            addCriterion("SectionID <>", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThan(Long value) {
            addCriterion("SectionID >", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThanOrEqualTo(Long value) {
            addCriterion("SectionID >=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThan(Long value) {
            addCriterion("SectionID <", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThanOrEqualTo(Long value) {
            addCriterion("SectionID <=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidIn(List<Long> values) {
            addCriterion("SectionID in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotIn(List<Long> values) {
            addCriterion("SectionID not in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidBetween(Long value1, Long value2) {
            addCriterion("SectionID between", value1, value2, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotBetween(Long value1, Long value2) {
            addCriterion("SectionID not between", value1, value2, "sectionid");
            return (Criteria) this;
        }

        public Criteria andCharpteridIsNull() {
            addCriterion("CharpterID is null");
            return (Criteria) this;
        }

        public Criteria andCharpteridIsNotNull() {
            addCriterion("CharpterID is not null");
            return (Criteria) this;
        }

        public Criteria andCharpteridEqualTo(Long value) {
            addCriterion("CharpterID =", value, "charpterid");
            return (Criteria) this;
        }

        public Criteria andCharpteridNotEqualTo(Long value) {
            addCriterion("CharpterID <>", value, "charpterid");
            return (Criteria) this;
        }

        public Criteria andCharpteridGreaterThan(Long value) {
            addCriterion("CharpterID >", value, "charpterid");
            return (Criteria) this;
        }

        public Criteria andCharpteridGreaterThanOrEqualTo(Long value) {
            addCriterion("CharpterID >=", value, "charpterid");
            return (Criteria) this;
        }

        public Criteria andCharpteridLessThan(Long value) {
            addCriterion("CharpterID <", value, "charpterid");
            return (Criteria) this;
        }

        public Criteria andCharpteridLessThanOrEqualTo(Long value) {
            addCriterion("CharpterID <=", value, "charpterid");
            return (Criteria) this;
        }

        public Criteria andCharpteridIn(List<Long> values) {
            addCriterion("CharpterID in", values, "charpterid");
            return (Criteria) this;
        }

        public Criteria andCharpteridNotIn(List<Long> values) {
            addCriterion("CharpterID not in", values, "charpterid");
            return (Criteria) this;
        }

        public Criteria andCharpteridBetween(Long value1, Long value2) {
            addCriterion("CharpterID between", value1, value2, "charpterid");
            return (Criteria) this;
        }

        public Criteria andCharpteridNotBetween(Long value1, Long value2) {
            addCriterion("CharpterID not between", value1, value2, "charpterid");
            return (Criteria) this;
        }

        public Criteria andSectiontitleIsNull() {
            addCriterion("SectionTitle is null");
            return (Criteria) this;
        }

        public Criteria andSectiontitleIsNotNull() {
            addCriterion("SectionTitle is not null");
            return (Criteria) this;
        }

        public Criteria andSectiontitleEqualTo(String value) {
            addCriterion("SectionTitle =", value, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleNotEqualTo(String value) {
            addCriterion("SectionTitle <>", value, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleGreaterThan(String value) {
            addCriterion("SectionTitle >", value, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleGreaterThanOrEqualTo(String value) {
            addCriterion("SectionTitle >=", value, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleLessThan(String value) {
            addCriterion("SectionTitle <", value, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleLessThanOrEqualTo(String value) {
            addCriterion("SectionTitle <=", value, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleLike(String value) {
            addCriterion("SectionTitle like", value, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleNotLike(String value) {
            addCriterion("SectionTitle not like", value, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleIn(List<String> values) {
            addCriterion("SectionTitle in", values, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleNotIn(List<String> values) {
            addCriterion("SectionTitle not in", values, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleBetween(String value1, String value2) {
            addCriterion("SectionTitle between", value1, value2, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectiontitleNotBetween(String value1, String value2) {
            addCriterion("SectionTitle not between", value1, value2, "sectiontitle");
            return (Criteria) this;
        }

        public Criteria andSectionabstractIsNull() {
            addCriterion("SectionAbstract is null");
            return (Criteria) this;
        }

        public Criteria andSectionabstractIsNotNull() {
            addCriterion("SectionAbstract is not null");
            return (Criteria) this;
        }

        public Criteria andSectionabstractEqualTo(String value) {
            addCriterion("SectionAbstract =", value, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractNotEqualTo(String value) {
            addCriterion("SectionAbstract <>", value, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractGreaterThan(String value) {
            addCriterion("SectionAbstract >", value, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractGreaterThanOrEqualTo(String value) {
            addCriterion("SectionAbstract >=", value, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractLessThan(String value) {
            addCriterion("SectionAbstract <", value, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractLessThanOrEqualTo(String value) {
            addCriterion("SectionAbstract <=", value, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractLike(String value) {
            addCriterion("SectionAbstract like", value, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractNotLike(String value) {
            addCriterion("SectionAbstract not like", value, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractIn(List<String> values) {
            addCriterion("SectionAbstract in", values, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractNotIn(List<String> values) {
            addCriterion("SectionAbstract not in", values, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractBetween(String value1, String value2) {
            addCriterion("SectionAbstract between", value1, value2, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectionabstractNotBetween(String value1, String value2) {
            addCriterion("SectionAbstract not between", value1, value2, "sectionabstract");
            return (Criteria) this;
        }

        public Criteria andSectioncodeIsNull() {
            addCriterion("SectionCode is null");
            return (Criteria) this;
        }

        public Criteria andSectioncodeIsNotNull() {
            addCriterion("SectionCode is not null");
            return (Criteria) this;
        }

        public Criteria andSectioncodeEqualTo(String value) {
            addCriterion("SectionCode =", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeNotEqualTo(String value) {
            addCriterion("SectionCode <>", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeGreaterThan(String value) {
            addCriterion("SectionCode >", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeGreaterThanOrEqualTo(String value) {
            addCriterion("SectionCode >=", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeLessThan(String value) {
            addCriterion("SectionCode <", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeLessThanOrEqualTo(String value) {
            addCriterion("SectionCode <=", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeLike(String value) {
            addCriterion("SectionCode like", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeNotLike(String value) {
            addCriterion("SectionCode not like", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeIn(List<String> values) {
            addCriterion("SectionCode in", values, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeNotIn(List<String> values) {
            addCriterion("SectionCode not in", values, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeBetween(String value1, String value2) {
            addCriterion("SectionCode between", value1, value2, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeNotBetween(String value1, String value2) {
            addCriterion("SectionCode not between", value1, value2, "sectioncode");
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

        public Criteria andIsfreeIsNull() {
            addCriterion("IsFree is null");
            return (Criteria) this;
        }

        public Criteria andIsfreeIsNotNull() {
            addCriterion("IsFree is not null");
            return (Criteria) this;
        }

        public Criteria andIsfreeEqualTo(String value) {
            addCriterion("IsFree =", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotEqualTo(String value) {
            addCriterion("IsFree <>", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeGreaterThan(String value) {
            addCriterion("IsFree >", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeGreaterThanOrEqualTo(String value) {
            addCriterion("IsFree >=", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLessThan(String value) {
            addCriterion("IsFree <", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLessThanOrEqualTo(String value) {
            addCriterion("IsFree <=", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLike(String value) {
            addCriterion("IsFree like", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotLike(String value) {
            addCriterion("IsFree not like", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeIn(List<String> values) {
            addCriterion("IsFree in", values, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotIn(List<String> values) {
            addCriterion("IsFree not in", values, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeBetween(String value1, String value2) {
            addCriterion("IsFree between", value1, value2, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotBetween(String value1, String value2) {
            addCriterion("IsFree not between", value1, value2, "isfree");
            return (Criteria) this;
        }

        public Criteria andFileidIsNull() {
            addCriterion("FileID is null");
            return (Criteria) this;
        }

        public Criteria andFileidIsNotNull() {
            addCriterion("FileID is not null");
            return (Criteria) this;
        }

        public Criteria andFileidEqualTo(Long value) {
            addCriterion("FileID =", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotEqualTo(Long value) {
            addCriterion("FileID <>", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThan(Long value) {
            addCriterion("FileID >", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThanOrEqualTo(Long value) {
            addCriterion("FileID >=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThan(Long value) {
            addCriterion("FileID <", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThanOrEqualTo(Long value) {
            addCriterion("FileID <=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidIn(List<Long> values) {
            addCriterion("FileID in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotIn(List<Long> values) {
            addCriterion("FileID not in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidBetween(Long value1, Long value2) {
            addCriterion("FileID between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotBetween(Long value1, Long value2) {
            addCriterion("FileID not between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andDisplayorderIsNull() {
            addCriterion("DisplayOrder is null");
            return (Criteria) this;
        }

        public Criteria andDisplayorderIsNotNull() {
            addCriterion("DisplayOrder is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayorderEqualTo(Integer value) {
            addCriterion("DisplayOrder =", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotEqualTo(Integer value) {
            addCriterion("DisplayOrder <>", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderGreaterThan(Integer value) {
            addCriterion("DisplayOrder >", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("DisplayOrder >=", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderLessThan(Integer value) {
            addCriterion("DisplayOrder <", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderLessThanOrEqualTo(Integer value) {
            addCriterion("DisplayOrder <=", value, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderIn(List<Integer> values) {
            addCriterion("DisplayOrder in", values, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotIn(List<Integer> values) {
            addCriterion("DisplayOrder not in", values, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderBetween(Integer value1, Integer value2) {
            addCriterion("DisplayOrder between", value1, value2, "displayorder");
            return (Criteria) this;
        }

        public Criteria andDisplayorderNotBetween(Integer value1, Integer value2) {
            addCriterion("DisplayOrder not between", value1, value2, "displayorder");
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