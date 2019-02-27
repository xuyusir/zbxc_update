package com.jy.entiy.system.dictionaries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DictionariesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionariesExample() {
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

        public Criteria andDictionariesidIsNull() {
            addCriterion("DictionariesID is null");
            return (Criteria) this;
        }

        public Criteria andDictionariesidIsNotNull() {
            addCriterion("DictionariesID is not null");
            return (Criteria) this;
        }

        public Criteria andDictionariesidEqualTo(Integer value) {
            addCriterion("DictionariesID =", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidNotEqualTo(Integer value) {
            addCriterion("DictionariesID <>", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidGreaterThan(Integer value) {
            addCriterion("DictionariesID >", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DictionariesID >=", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidLessThan(Integer value) {
            addCriterion("DictionariesID <", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidLessThanOrEqualTo(Integer value) {
            addCriterion("DictionariesID <=", value, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidIn(List<Integer> values) {
            addCriterion("DictionariesID in", values, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidNotIn(List<Integer> values) {
            addCriterion("DictionariesID not in", values, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidBetween(Integer value1, Integer value2) {
            addCriterion("DictionariesID between", value1, value2, "dictionariesid");
            return (Criteria) this;
        }

        public Criteria andDictionariesidNotBetween(Integer value1, Integer value2) {
            addCriterion("DictionariesID not between", value1, value2, "dictionariesid");
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

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("Name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("Name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
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

        public Criteria andParentidIsNull() {
            addCriterion("ParentID is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("ParentID is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("ParentID =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("ParentID <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("ParentID >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ParentID >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("ParentID <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("ParentID <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("ParentID in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("ParentID not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("ParentID between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("ParentID not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("Level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("Level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("Level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("Level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("Level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("Level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("Level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("Level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("Level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("Level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("Level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("Level not between", value1, value2, "level");
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

        public Criteria andCreatepersonidEqualTo(Integer value) {
            addCriterion("CreatePersonID =", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidNotEqualTo(Integer value) {
            addCriterion("CreatePersonID <>", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidGreaterThan(Integer value) {
            addCriterion("CreatePersonID >", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreatePersonID >=", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidLessThan(Integer value) {
            addCriterion("CreatePersonID <", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidLessThanOrEqualTo(Integer value) {
            addCriterion("CreatePersonID <=", value, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidIn(List<Integer> values) {
            addCriterion("CreatePersonID in", values, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidNotIn(List<Integer> values) {
            addCriterion("CreatePersonID not in", values, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidBetween(Integer value1, Integer value2) {
            addCriterion("CreatePersonID between", value1, value2, "createpersonid");
            return (Criteria) this;
        }

        public Criteria andCreatepersonidNotBetween(Integer value1, Integer value2) {
            addCriterion("CreatePersonID not between", value1, value2, "createpersonid");
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

        public Criteria andUpdatepersonidEqualTo(Integer value) {
            addCriterion("UpdatePersonID =", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidNotEqualTo(Integer value) {
            addCriterion("UpdatePersonID <>", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidGreaterThan(Integer value) {
            addCriterion("UpdatePersonID >", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdatePersonID >=", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidLessThan(Integer value) {
            addCriterion("UpdatePersonID <", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidLessThanOrEqualTo(Integer value) {
            addCriterion("UpdatePersonID <=", value, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidIn(List<Integer> values) {
            addCriterion("UpdatePersonID in", values, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidNotIn(List<Integer> values) {
            addCriterion("UpdatePersonID not in", values, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidBetween(Integer value1, Integer value2) {
            addCriterion("UpdatePersonID between", value1, value2, "updatepersonid");
            return (Criteria) this;
        }

        public Criteria andUpdatepersonidNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdatePersonID not between", value1, value2, "updatepersonid");
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