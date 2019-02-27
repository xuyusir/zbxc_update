package com.jy.entiy.system.select;

import java.util.ArrayList;
import java.util.List;

public class AreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AreaExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
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

        public Criteria andParentcodeIsNull() {
            addCriterion("ParentCode is null");
            return (Criteria) this;
        }

        public Criteria andParentcodeIsNotNull() {
            addCriterion("ParentCode is not null");
            return (Criteria) this;
        }

        public Criteria andParentcodeEqualTo(String value) {
            addCriterion("ParentCode =", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotEqualTo(String value) {
            addCriterion("ParentCode <>", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThan(String value) {
            addCriterion("ParentCode >", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ParentCode >=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThan(String value) {
            addCriterion("ParentCode <", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThanOrEqualTo(String value) {
            addCriterion("ParentCode <=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLike(String value) {
            addCriterion("ParentCode like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotLike(String value) {
            addCriterion("ParentCode not like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeIn(List<String> values) {
            addCriterion("ParentCode in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotIn(List<String> values) {
            addCriterion("ParentCode not in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeBetween(String value1, String value2) {
            addCriterion("ParentCode between", value1, value2, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotBetween(String value1, String value2) {
            addCriterion("ParentCode not between", value1, value2, "parentcode");
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

        public Criteria andMergernameIsNull() {
            addCriterion("MergerName is null");
            return (Criteria) this;
        }

        public Criteria andMergernameIsNotNull() {
            addCriterion("MergerName is not null");
            return (Criteria) this;
        }

        public Criteria andMergernameEqualTo(String value) {
            addCriterion("MergerName =", value, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameNotEqualTo(String value) {
            addCriterion("MergerName <>", value, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameGreaterThan(String value) {
            addCriterion("MergerName >", value, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameGreaterThanOrEqualTo(String value) {
            addCriterion("MergerName >=", value, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameLessThan(String value) {
            addCriterion("MergerName <", value, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameLessThanOrEqualTo(String value) {
            addCriterion("MergerName <=", value, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameLike(String value) {
            addCriterion("MergerName like", value, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameNotLike(String value) {
            addCriterion("MergerName not like", value, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameIn(List<String> values) {
            addCriterion("MergerName in", values, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameNotIn(List<String> values) {
            addCriterion("MergerName not in", values, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameBetween(String value1, String value2) {
            addCriterion("MergerName between", value1, value2, "mergername");
            return (Criteria) this;
        }

        public Criteria andMergernameNotBetween(String value1, String value2) {
            addCriterion("MergerName not between", value1, value2, "mergername");
            return (Criteria) this;
        }

        public Criteria andShortnameIsNull() {
            addCriterion("ShortName is null");
            return (Criteria) this;
        }

        public Criteria andShortnameIsNotNull() {
            addCriterion("ShortName is not null");
            return (Criteria) this;
        }

        public Criteria andShortnameEqualTo(String value) {
            addCriterion("ShortName =", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotEqualTo(String value) {
            addCriterion("ShortName <>", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameGreaterThan(String value) {
            addCriterion("ShortName >", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameGreaterThanOrEqualTo(String value) {
            addCriterion("ShortName >=", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLessThan(String value) {
            addCriterion("ShortName <", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLessThanOrEqualTo(String value) {
            addCriterion("ShortName <=", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameLike(String value) {
            addCriterion("ShortName like", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotLike(String value) {
            addCriterion("ShortName not like", value, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameIn(List<String> values) {
            addCriterion("ShortName in", values, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotIn(List<String> values) {
            addCriterion("ShortName not in", values, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameBetween(String value1, String value2) {
            addCriterion("ShortName between", value1, value2, "shortname");
            return (Criteria) this;
        }

        public Criteria andShortnameNotBetween(String value1, String value2) {
            addCriterion("ShortName not between", value1, value2, "shortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameIsNull() {
            addCriterion("MergerShortName is null");
            return (Criteria) this;
        }

        public Criteria andMergershortnameIsNotNull() {
            addCriterion("MergerShortName is not null");
            return (Criteria) this;
        }

        public Criteria andMergershortnameEqualTo(String value) {
            addCriterion("MergerShortName =", value, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameNotEqualTo(String value) {
            addCriterion("MergerShortName <>", value, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameGreaterThan(String value) {
            addCriterion("MergerShortName >", value, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameGreaterThanOrEqualTo(String value) {
            addCriterion("MergerShortName >=", value, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameLessThan(String value) {
            addCriterion("MergerShortName <", value, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameLessThanOrEqualTo(String value) {
            addCriterion("MergerShortName <=", value, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameLike(String value) {
            addCriterion("MergerShortName like", value, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameNotLike(String value) {
            addCriterion("MergerShortName not like", value, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameIn(List<String> values) {
            addCriterion("MergerShortName in", values, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameNotIn(List<String> values) {
            addCriterion("MergerShortName not in", values, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameBetween(String value1, String value2) {
            addCriterion("MergerShortName between", value1, value2, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andMergershortnameNotBetween(String value1, String value2) {
            addCriterion("MergerShortName not between", value1, value2, "mergershortname");
            return (Criteria) this;
        }

        public Criteria andLeveltypeIsNull() {
            addCriterion("LevelType is null");
            return (Criteria) this;
        }

        public Criteria andLeveltypeIsNotNull() {
            addCriterion("LevelType is not null");
            return (Criteria) this;
        }

        public Criteria andLeveltypeEqualTo(String value) {
            addCriterion("LevelType =", value, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeNotEqualTo(String value) {
            addCriterion("LevelType <>", value, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeGreaterThan(String value) {
            addCriterion("LevelType >", value, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeGreaterThanOrEqualTo(String value) {
            addCriterion("LevelType >=", value, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeLessThan(String value) {
            addCriterion("LevelType <", value, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeLessThanOrEqualTo(String value) {
            addCriterion("LevelType <=", value, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeLike(String value) {
            addCriterion("LevelType like", value, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeNotLike(String value) {
            addCriterion("LevelType not like", value, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeIn(List<String> values) {
            addCriterion("LevelType in", values, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeNotIn(List<String> values) {
            addCriterion("LevelType not in", values, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeBetween(String value1, String value2) {
            addCriterion("LevelType between", value1, value2, "leveltype");
            return (Criteria) this;
        }

        public Criteria andLeveltypeNotBetween(String value1, String value2) {
            addCriterion("LevelType not between", value1, value2, "leveltype");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNull() {
            addCriterion("CityCode is null");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNotNull() {
            addCriterion("CityCode is not null");
            return (Criteria) this;
        }

        public Criteria andCitycodeEqualTo(String value) {
            addCriterion("CityCode =", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotEqualTo(String value) {
            addCriterion("CityCode <>", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThan(String value) {
            addCriterion("CityCode >", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("CityCode >=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThan(String value) {
            addCriterion("CityCode <", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThanOrEqualTo(String value) {
            addCriterion("CityCode <=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLike(String value) {
            addCriterion("CityCode like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotLike(String value) {
            addCriterion("CityCode not like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeIn(List<String> values) {
            addCriterion("CityCode in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotIn(List<String> values) {
            addCriterion("CityCode not in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeBetween(String value1, String value2) {
            addCriterion("CityCode between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotBetween(String value1, String value2) {
            addCriterion("CityCode not between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNull() {
            addCriterion("ZipCode is null");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNotNull() {
            addCriterion("ZipCode is not null");
            return (Criteria) this;
        }

        public Criteria andZipcodeEqualTo(String value) {
            addCriterion("ZipCode =", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotEqualTo(String value) {
            addCriterion("ZipCode <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThan(String value) {
            addCriterion("ZipCode >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ZipCode >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThan(String value) {
            addCriterion("ZipCode <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(String value) {
            addCriterion("ZipCode <=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLike(String value) {
            addCriterion("ZipCode like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotLike(String value) {
            addCriterion("ZipCode not like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeIn(List<String> values) {
            addCriterion("ZipCode in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotIn(List<String> values) {
            addCriterion("ZipCode not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeBetween(String value1, String value2) {
            addCriterion("ZipCode between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotBetween(String value1, String value2) {
            addCriterion("ZipCode not between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNull() {
            addCriterion("PinYin is null");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("PinYin is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("PinYin =", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("PinYin <>", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("PinYin >", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("PinYin >=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("PinYin <", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("PinYin <=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLike(String value) {
            addCriterion("PinYin like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("PinYin not like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinIn(List<String> values) {
            addCriterion("PinYin in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotIn(List<String> values) {
            addCriterion("PinYin not in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("PinYin between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("PinYin not between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andJianpinIsNull() {
            addCriterion("JianPin is null");
            return (Criteria) this;
        }

        public Criteria andJianpinIsNotNull() {
            addCriterion("JianPin is not null");
            return (Criteria) this;
        }

        public Criteria andJianpinEqualTo(String value) {
            addCriterion("JianPin =", value, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinNotEqualTo(String value) {
            addCriterion("JianPin <>", value, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinGreaterThan(String value) {
            addCriterion("JianPin >", value, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinGreaterThanOrEqualTo(String value) {
            addCriterion("JianPin >=", value, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinLessThan(String value) {
            addCriterion("JianPin <", value, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinLessThanOrEqualTo(String value) {
            addCriterion("JianPin <=", value, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinLike(String value) {
            addCriterion("JianPin like", value, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinNotLike(String value) {
            addCriterion("JianPin not like", value, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinIn(List<String> values) {
            addCriterion("JianPin in", values, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinNotIn(List<String> values) {
            addCriterion("JianPin not in", values, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinBetween(String value1, String value2) {
            addCriterion("JianPin between", value1, value2, "jianpin");
            return (Criteria) this;
        }

        public Criteria andJianpinNotBetween(String value1, String value2) {
            addCriterion("JianPin not between", value1, value2, "jianpin");
            return (Criteria) this;
        }

        public Criteria andFirstcharIsNull() {
            addCriterion("FirstChar is null");
            return (Criteria) this;
        }

        public Criteria andFirstcharIsNotNull() {
            addCriterion("FirstChar is not null");
            return (Criteria) this;
        }

        public Criteria andFirstcharEqualTo(String value) {
            addCriterion("FirstChar =", value, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharNotEqualTo(String value) {
            addCriterion("FirstChar <>", value, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharGreaterThan(String value) {
            addCriterion("FirstChar >", value, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharGreaterThanOrEqualTo(String value) {
            addCriterion("FirstChar >=", value, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharLessThan(String value) {
            addCriterion("FirstChar <", value, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharLessThanOrEqualTo(String value) {
            addCriterion("FirstChar <=", value, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharLike(String value) {
            addCriterion("FirstChar like", value, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharNotLike(String value) {
            addCriterion("FirstChar not like", value, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharIn(List<String> values) {
            addCriterion("FirstChar in", values, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharNotIn(List<String> values) {
            addCriterion("FirstChar not in", values, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharBetween(String value1, String value2) {
            addCriterion("FirstChar between", value1, value2, "firstchar");
            return (Criteria) this;
        }

        public Criteria andFirstcharNotBetween(String value1, String value2) {
            addCriterion("FirstChar not between", value1, value2, "firstchar");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("Lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("Lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Double value) {
            addCriterion("Lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Double value) {
            addCriterion("Lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Double value) {
            addCriterion("Lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Double value) {
            addCriterion("Lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Double value) {
            addCriterion("Lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Double value) {
            addCriterion("Lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Double> values) {
            addCriterion("Lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Double> values) {
            addCriterion("Lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Double value1, Double value2) {
            addCriterion("Lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Double value1, Double value2) {
            addCriterion("Lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("Lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("Lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("Lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("Lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("Lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("Lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("Lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("Lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("Lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("Lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("Lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("Lat not between", value1, value2, "lat");
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