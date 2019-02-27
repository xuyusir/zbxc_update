package com.jy.entiy.content.file.directory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentdirectoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumentdirectoryExample() {
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

        public Criteria andDocumentdirectoryidIsNull() {
            addCriterion("DocumentDirectoryID is null");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidIsNotNull() {
            addCriterion("DocumentDirectoryID is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidEqualTo(Long value) {
            addCriterion("DocumentDirectoryID =", value, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidNotEqualTo(Long value) {
            addCriterion("DocumentDirectoryID <>", value, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidGreaterThan(Long value) {
            addCriterion("DocumentDirectoryID >", value, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidGreaterThanOrEqualTo(Long value) {
            addCriterion("DocumentDirectoryID >=", value, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidLessThan(Long value) {
            addCriterion("DocumentDirectoryID <", value, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidLessThanOrEqualTo(Long value) {
            addCriterion("DocumentDirectoryID <=", value, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidIn(List<Long> values) {
            addCriterion("DocumentDirectoryID in", values, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidNotIn(List<Long> values) {
            addCriterion("DocumentDirectoryID not in", values, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidBetween(Long value1, Long value2) {
            addCriterion("DocumentDirectoryID between", value1, value2, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDocumentdirectoryidNotBetween(Long value1, Long value2) {
            addCriterion("DocumentDirectoryID not between", value1, value2, "documentdirectoryid");
            return (Criteria) this;
        }

        public Criteria andDirectorynameIsNull() {
            addCriterion("DirectoryName is null");
            return (Criteria) this;
        }

        public Criteria andDirectorynameIsNotNull() {
            addCriterion("DirectoryName is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorynameEqualTo(String value) {
            addCriterion("DirectoryName =", value, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameNotEqualTo(String value) {
            addCriterion("DirectoryName <>", value, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameGreaterThan(String value) {
            addCriterion("DirectoryName >", value, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameGreaterThanOrEqualTo(String value) {
            addCriterion("DirectoryName >=", value, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameLessThan(String value) {
            addCriterion("DirectoryName <", value, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameLessThanOrEqualTo(String value) {
            addCriterion("DirectoryName <=", value, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameLike(String value) {
            addCriterion("DirectoryName like", value, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameNotLike(String value) {
            addCriterion("DirectoryName not like", value, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameIn(List<String> values) {
            addCriterion("DirectoryName in", values, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameNotIn(List<String> values) {
            addCriterion("DirectoryName not in", values, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameBetween(String value1, String value2) {
            addCriterion("DirectoryName between", value1, value2, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorynameNotBetween(String value1, String value2) {
            addCriterion("DirectoryName not between", value1, value2, "directoryname");
            return (Criteria) this;
        }

        public Criteria andDirectorypathIsNull() {
            addCriterion("DirectoryPath is null");
            return (Criteria) this;
        }

        public Criteria andDirectorypathIsNotNull() {
            addCriterion("DirectoryPath is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorypathEqualTo(String value) {
            addCriterion("DirectoryPath =", value, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathNotEqualTo(String value) {
            addCriterion("DirectoryPath <>", value, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathGreaterThan(String value) {
            addCriterion("DirectoryPath >", value, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathGreaterThanOrEqualTo(String value) {
            addCriterion("DirectoryPath >=", value, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathLessThan(String value) {
            addCriterion("DirectoryPath <", value, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathLessThanOrEqualTo(String value) {
            addCriterion("DirectoryPath <=", value, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathLike(String value) {
            addCriterion("DirectoryPath like", value, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathNotLike(String value) {
            addCriterion("DirectoryPath not like", value, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathIn(List<String> values) {
            addCriterion("DirectoryPath in", values, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathNotIn(List<String> values) {
            addCriterion("DirectoryPath not in", values, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathBetween(String value1, String value2) {
            addCriterion("DirectoryPath between", value1, value2, "directorypath");
            return (Criteria) this;
        }

        public Criteria andDirectorypathNotBetween(String value1, String value2) {
            addCriterion("DirectoryPath not between", value1, value2, "directorypath");
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

        public Criteria andParentidEqualTo(Long value) {
            addCriterion("ParentID =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Long value) {
            addCriterion("ParentID <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Long value) {
            addCriterion("ParentID >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Long value) {
            addCriterion("ParentID >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Long value) {
            addCriterion("ParentID <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Long value) {
            addCriterion("ParentID <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Long> values) {
            addCriterion("ParentID in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Long> values) {
            addCriterion("ParentID not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Long value1, Long value2) {
            addCriterion("ParentID between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Long value1, Long value2) {
            addCriterion("ParentID not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNull() {
            addCriterion("IsParent is null");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNotNull() {
            addCriterion("IsParent is not null");
            return (Criteria) this;
        }

        public Criteria andIsparentEqualTo(Integer value) {
            addCriterion("IsParent =", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotEqualTo(Integer value) {
            addCriterion("IsParent <>", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThan(Integer value) {
            addCriterion("IsParent >", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsParent >=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThan(Integer value) {
            addCriterion("IsParent <", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThanOrEqualTo(Integer value) {
            addCriterion("IsParent <=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentIn(List<Integer> values) {
            addCriterion("IsParent in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotIn(List<Integer> values) {
            addCriterion("IsParent not in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentBetween(Integer value1, Integer value2) {
            addCriterion("IsParent between", value1, value2, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotBetween(Integer value1, Integer value2) {
            addCriterion("IsParent not between", value1, value2, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskIsNull() {
            addCriterion("IsNetworkDisk is null");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskIsNotNull() {
            addCriterion("IsNetworkDisk is not null");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskEqualTo(Integer value) {
            addCriterion("IsNetworkDisk =", value, "isnetworkdisk");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskNotEqualTo(Integer value) {
            addCriterion("IsNetworkDisk <>", value, "isnetworkdisk");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskGreaterThan(Integer value) {
            addCriterion("IsNetworkDisk >", value, "isnetworkdisk");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsNetworkDisk >=", value, "isnetworkdisk");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskLessThan(Integer value) {
            addCriterion("IsNetworkDisk <", value, "isnetworkdisk");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskLessThanOrEqualTo(Integer value) {
            addCriterion("IsNetworkDisk <=", value, "isnetworkdisk");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskIn(List<Integer> values) {
            addCriterion("IsNetworkDisk in", values, "isnetworkdisk");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskNotIn(List<Integer> values) {
            addCriterion("IsNetworkDisk not in", values, "isnetworkdisk");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskBetween(Integer value1, Integer value2) {
            addCriterion("IsNetworkDisk between", value1, value2, "isnetworkdisk");
            return (Criteria) this;
        }

        public Criteria andIsnetworkdiskNotBetween(Integer value1, Integer value2) {
            addCriterion("IsNetworkDisk not between", value1, value2, "isnetworkdisk");
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