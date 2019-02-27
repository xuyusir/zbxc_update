package com.jy.entiy.staff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffarchivesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StaffarchivesExample() {
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

        public Criteria andDepartmentidIsNull() {
            addCriterion("DepartmentID is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("DepartmentID is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(Integer value) {
            addCriterion("DepartmentID =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(Integer value) {
            addCriterion("DepartmentID <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(Integer value) {
            addCriterion("DepartmentID >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DepartmentID >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(Integer value) {
            addCriterion("DepartmentID <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(Integer value) {
            addCriterion("DepartmentID <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<Integer> values) {
            addCriterion("DepartmentID in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<Integer> values) {
            addCriterion("DepartmentID not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(Integer value1, Integer value2) {
            addCriterion("DepartmentID between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("DepartmentID not between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidIsNull() {
            addCriterion("DepartmentPostID is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidIsNotNull() {
            addCriterion("DepartmentPostID is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidEqualTo(Integer value) {
            addCriterion("DepartmentPostID =", value, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidNotEqualTo(Integer value) {
            addCriterion("DepartmentPostID <>", value, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidGreaterThan(Integer value) {
            addCriterion("DepartmentPostID >", value, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DepartmentPostID >=", value, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidLessThan(Integer value) {
            addCriterion("DepartmentPostID <", value, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidLessThanOrEqualTo(Integer value) {
            addCriterion("DepartmentPostID <=", value, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidIn(List<Integer> values) {
            addCriterion("DepartmentPostID in", values, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidNotIn(List<Integer> values) {
            addCriterion("DepartmentPostID not in", values, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidBetween(Integer value1, Integer value2) {
            addCriterion("DepartmentPostID between", value1, value2, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andDepartmentpostidNotBetween(Integer value1, Integer value2) {
            addCriterion("DepartmentPostID not between", value1, value2, "departmentpostid");
            return (Criteria) this;
        }

        public Criteria andInductiondateIsNull() {
            addCriterion("InductionDate is null");
            return (Criteria) this;
        }

        public Criteria andInductiondateIsNotNull() {
            addCriterion("InductionDate is not null");
            return (Criteria) this;
        }

        public Criteria andInductiondateEqualTo(Date value) {
            addCriterion("InductionDate =", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateNotEqualTo(Date value) {
            addCriterion("InductionDate <>", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateGreaterThan(Date value) {
            addCriterion("InductionDate >", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateGreaterThanOrEqualTo(Date value) {
            addCriterion("InductionDate >=", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateLessThan(Date value) {
            addCriterion("InductionDate <", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateLessThanOrEqualTo(Date value) {
            addCriterion("InductionDate <=", value, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateIn(List<Date> values) {
            addCriterion("InductionDate in", values, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateNotIn(List<Date> values) {
            addCriterion("InductionDate not in", values, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateBetween(Date value1, Date value2) {
            addCriterion("InductionDate between", value1, value2, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andInductiondateNotBetween(Date value1, Date value2) {
            addCriterion("InductionDate not between", value1, value2, "inductiondate");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidIsNull() {
            addCriterion("PoliticsStatusID is null");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidIsNotNull() {
            addCriterion("PoliticsStatusID is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidEqualTo(Integer value) {
            addCriterion("PoliticsStatusID =", value, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidNotEqualTo(Integer value) {
            addCriterion("PoliticsStatusID <>", value, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidGreaterThan(Integer value) {
            addCriterion("PoliticsStatusID >", value, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PoliticsStatusID >=", value, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidLessThan(Integer value) {
            addCriterion("PoliticsStatusID <", value, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidLessThanOrEqualTo(Integer value) {
            addCriterion("PoliticsStatusID <=", value, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidIn(List<Integer> values) {
            addCriterion("PoliticsStatusID in", values, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidNotIn(List<Integer> values) {
            addCriterion("PoliticsStatusID not in", values, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidBetween(Integer value1, Integer value2) {
            addCriterion("PoliticsStatusID between", value1, value2, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andPoliticsstatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("PoliticsStatusID not between", value1, value2, "politicsstatusid");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactIsNull() {
            addCriterion("EmergencyContact is null");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactIsNotNull() {
            addCriterion("EmergencyContact is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactEqualTo(String value) {
            addCriterion("EmergencyContact =", value, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactNotEqualTo(String value) {
            addCriterion("EmergencyContact <>", value, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactGreaterThan(String value) {
            addCriterion("EmergencyContact >", value, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactGreaterThanOrEqualTo(String value) {
            addCriterion("EmergencyContact >=", value, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactLessThan(String value) {
            addCriterion("EmergencyContact <", value, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactLessThanOrEqualTo(String value) {
            addCriterion("EmergencyContact <=", value, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactLike(String value) {
            addCriterion("EmergencyContact like", value, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactNotLike(String value) {
            addCriterion("EmergencyContact not like", value, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactIn(List<String> values) {
            addCriterion("EmergencyContact in", values, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactNotIn(List<String> values) {
            addCriterion("EmergencyContact not in", values, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactBetween(String value1, String value2) {
            addCriterion("EmergencyContact between", value1, value2, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencycontactNotBetween(String value1, String value2) {
            addCriterion("EmergencyContact not between", value1, value2, "emergencycontact");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneIsNull() {
            addCriterion("EmergencyPhone is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneIsNotNull() {
            addCriterion("EmergencyPhone is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneEqualTo(String value) {
            addCriterion("EmergencyPhone =", value, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneNotEqualTo(String value) {
            addCriterion("EmergencyPhone <>", value, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneGreaterThan(String value) {
            addCriterion("EmergencyPhone >", value, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneGreaterThanOrEqualTo(String value) {
            addCriterion("EmergencyPhone >=", value, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneLessThan(String value) {
            addCriterion("EmergencyPhone <", value, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneLessThanOrEqualTo(String value) {
            addCriterion("EmergencyPhone <=", value, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneLike(String value) {
            addCriterion("EmergencyPhone like", value, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneNotLike(String value) {
            addCriterion("EmergencyPhone not like", value, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneIn(List<String> values) {
            addCriterion("EmergencyPhone in", values, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneNotIn(List<String> values) {
            addCriterion("EmergencyPhone not in", values, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneBetween(String value1, String value2) {
            addCriterion("EmergencyPhone between", value1, value2, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andEmergencyphoneNotBetween(String value1, String value2) {
            addCriterion("EmergencyPhone not between", value1, value2, "emergencyphone");
            return (Criteria) this;
        }

        public Criteria andUniversityIsNull() {
            addCriterion("University is null");
            return (Criteria) this;
        }

        public Criteria andUniversityIsNotNull() {
            addCriterion("University is not null");
            return (Criteria) this;
        }

        public Criteria andUniversityEqualTo(String value) {
            addCriterion("University =", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotEqualTo(String value) {
            addCriterion("University <>", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThan(String value) {
            addCriterion("University >", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityGreaterThanOrEqualTo(String value) {
            addCriterion("University >=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThan(String value) {
            addCriterion("University <", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLessThanOrEqualTo(String value) {
            addCriterion("University <=", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityLike(String value) {
            addCriterion("University like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotLike(String value) {
            addCriterion("University not like", value, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityIn(List<String> values) {
            addCriterion("University in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotIn(List<String> values) {
            addCriterion("University not in", values, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityBetween(String value1, String value2) {
            addCriterion("University between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andUniversityNotBetween(String value1, String value2) {
            addCriterion("University not between", value1, value2, "university");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNull() {
            addCriterion("College is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("College is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("College =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("College <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("College >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("College >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("College <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("College <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("College like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("College not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("College in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("College not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("College between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("College not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNull() {
            addCriterion("Specialty is null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNotNull() {
            addCriterion("Specialty is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyEqualTo(String value) {
            addCriterion("Specialty =", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotEqualTo(String value) {
            addCriterion("Specialty <>", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThan(String value) {
            addCriterion("Specialty >", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("Specialty >=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThan(String value) {
            addCriterion("Specialty <", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("Specialty <=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLike(String value) {
            addCriterion("Specialty like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotLike(String value) {
            addCriterion("Specialty not like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIn(List<String> values) {
            addCriterion("Specialty in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotIn(List<String> values) {
            addCriterion("Specialty not in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyBetween(String value1, String value2) {
            addCriterion("Specialty between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotBetween(String value1, String value2) {
            addCriterion("Specialty not between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andEducationidIsNull() {
            addCriterion("EducationID is null");
            return (Criteria) this;
        }

        public Criteria andEducationidIsNotNull() {
            addCriterion("EducationID is not null");
            return (Criteria) this;
        }

        public Criteria andEducationidEqualTo(Integer value) {
            addCriterion("EducationID =", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidNotEqualTo(Integer value) {
            addCriterion("EducationID <>", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidGreaterThan(Integer value) {
            addCriterion("EducationID >", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EducationID >=", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidLessThan(Integer value) {
            addCriterion("EducationID <", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidLessThanOrEqualTo(Integer value) {
            addCriterion("EducationID <=", value, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidIn(List<Integer> values) {
            addCriterion("EducationID in", values, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidNotIn(List<Integer> values) {
            addCriterion("EducationID not in", values, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidBetween(Integer value1, Integer value2) {
            addCriterion("EducationID between", value1, value2, "educationid");
            return (Criteria) this;
        }

        public Criteria andEducationidNotBetween(Integer value1, Integer value2) {
            addCriterion("EducationID not between", value1, value2, "educationid");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardIsNull() {
            addCriterion("SocialSecurityCard is null");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardIsNotNull() {
            addCriterion("SocialSecurityCard is not null");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardEqualTo(String value) {
            addCriterion("SocialSecurityCard =", value, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardNotEqualTo(String value) {
            addCriterion("SocialSecurityCard <>", value, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardGreaterThan(String value) {
            addCriterion("SocialSecurityCard >", value, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardGreaterThanOrEqualTo(String value) {
            addCriterion("SocialSecurityCard >=", value, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardLessThan(String value) {
            addCriterion("SocialSecurityCard <", value, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardLessThanOrEqualTo(String value) {
            addCriterion("SocialSecurityCard <=", value, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardLike(String value) {
            addCriterion("SocialSecurityCard like", value, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardNotLike(String value) {
            addCriterion("SocialSecurityCard not like", value, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardIn(List<String> values) {
            addCriterion("SocialSecurityCard in", values, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardNotIn(List<String> values) {
            addCriterion("SocialSecurityCard not in", values, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardBetween(String value1, String value2) {
            addCriterion("SocialSecurityCard between", value1, value2, "socialsecuritycard");
            return (Criteria) this;
        }

        public Criteria andSocialsecuritycardNotBetween(String value1, String value2) {
            addCriterion("SocialSecurityCard not between", value1, value2, "socialsecuritycard");
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

        public Criteria andAttachmentpathIsNull() {
            addCriterion("AttachmentPath is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathIsNotNull() {
            addCriterion("AttachmentPath is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathEqualTo(String value) {
            addCriterion("AttachmentPath =", value, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathNotEqualTo(String value) {
            addCriterion("AttachmentPath <>", value, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathGreaterThan(String value) {
            addCriterion("AttachmentPath >", value, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathGreaterThanOrEqualTo(String value) {
            addCriterion("AttachmentPath >=", value, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathLessThan(String value) {
            addCriterion("AttachmentPath <", value, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathLessThanOrEqualTo(String value) {
            addCriterion("AttachmentPath <=", value, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathLike(String value) {
            addCriterion("AttachmentPath like", value, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathNotLike(String value) {
            addCriterion("AttachmentPath not like", value, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathIn(List<String> values) {
            addCriterion("AttachmentPath in", values, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathNotIn(List<String> values) {
            addCriterion("AttachmentPath not in", values, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathBetween(String value1, String value2) {
            addCriterion("AttachmentPath between", value1, value2, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentpathNotBetween(String value1, String value2) {
            addCriterion("AttachmentPath not between", value1, value2, "attachmentpath");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameIsNull() {
            addCriterion("AttachmentName is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameIsNotNull() {
            addCriterion("AttachmentName is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameEqualTo(String value) {
            addCriterion("AttachmentName =", value, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameNotEqualTo(String value) {
            addCriterion("AttachmentName <>", value, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameGreaterThan(String value) {
            addCriterion("AttachmentName >", value, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameGreaterThanOrEqualTo(String value) {
            addCriterion("AttachmentName >=", value, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameLessThan(String value) {
            addCriterion("AttachmentName <", value, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameLessThanOrEqualTo(String value) {
            addCriterion("AttachmentName <=", value, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameLike(String value) {
            addCriterion("AttachmentName like", value, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameNotLike(String value) {
            addCriterion("AttachmentName not like", value, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameIn(List<String> values) {
            addCriterion("AttachmentName in", values, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameNotIn(List<String> values) {
            addCriterion("AttachmentName not in", values, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameBetween(String value1, String value2) {
            addCriterion("AttachmentName between", value1, value2, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmentnameNotBetween(String value1, String value2) {
            addCriterion("AttachmentName not between", value1, value2, "attachmentname");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeIsNull() {
            addCriterion("AttachmentType is null");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeIsNotNull() {
            addCriterion("AttachmentType is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeEqualTo(String value) {
            addCriterion("AttachmentType =", value, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeNotEqualTo(String value) {
            addCriterion("AttachmentType <>", value, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeGreaterThan(String value) {
            addCriterion("AttachmentType >", value, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("AttachmentType >=", value, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeLessThan(String value) {
            addCriterion("AttachmentType <", value, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeLessThanOrEqualTo(String value) {
            addCriterion("AttachmentType <=", value, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeLike(String value) {
            addCriterion("AttachmentType like", value, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeNotLike(String value) {
            addCriterion("AttachmentType not like", value, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeIn(List<String> values) {
            addCriterion("AttachmentType in", values, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeNotIn(List<String> values) {
            addCriterion("AttachmentType not in", values, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeBetween(String value1, String value2) {
            addCriterion("AttachmentType between", value1, value2, "attachmenttype");
            return (Criteria) this;
        }

        public Criteria andAttachmenttypeNotBetween(String value1, String value2) {
            addCriterion("AttachmentType not between", value1, value2, "attachmenttype");
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

        public Criteria andNativeplaceIsNull() {
            addCriterion("NativePlace is null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNotNull() {
            addCriterion("NativePlace is not null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceEqualTo(String value) {
            addCriterion("NativePlace =", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotEqualTo(String value) {
            addCriterion("NativePlace <>", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThan(String value) {
            addCriterion("NativePlace >", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThanOrEqualTo(String value) {
            addCriterion("NativePlace >=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThan(String value) {
            addCriterion("NativePlace <", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThanOrEqualTo(String value) {
            addCriterion("NativePlace <=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLike(String value) {
            addCriterion("NativePlace like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotLike(String value) {
            addCriterion("NativePlace not like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIn(List<String> values) {
            addCriterion("NativePlace in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotIn(List<String> values) {
            addCriterion("NativePlace not in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceBetween(String value1, String value2) {
            addCriterion("NativePlace between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotBetween(String value1, String value2) {
            addCriterion("NativePlace not between", value1, value2, "nativeplace");
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