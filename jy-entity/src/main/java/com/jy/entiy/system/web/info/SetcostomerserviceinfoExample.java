package com.jy.entiy.system.web.info;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SetcostomerserviceinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SetcostomerserviceinfoExample() {
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

        public Criteria andSetcostomerserviceinfoidIsNull() {
            addCriterion("SetCostomerServiceInfoID is null");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidIsNotNull() {
            addCriterion("SetCostomerServiceInfoID is not null");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidEqualTo(Integer value) {
            addCriterion("SetCostomerServiceInfoID =", value, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidNotEqualTo(Integer value) {
            addCriterion("SetCostomerServiceInfoID <>", value, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidGreaterThan(Integer value) {
            addCriterion("SetCostomerServiceInfoID >", value, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SetCostomerServiceInfoID >=", value, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidLessThan(Integer value) {
            addCriterion("SetCostomerServiceInfoID <", value, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidLessThanOrEqualTo(Integer value) {
            addCriterion("SetCostomerServiceInfoID <=", value, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidIn(List<Integer> values) {
            addCriterion("SetCostomerServiceInfoID in", values, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidNotIn(List<Integer> values) {
            addCriterion("SetCostomerServiceInfoID not in", values, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidBetween(Integer value1, Integer value2) {
            addCriterion("SetCostomerServiceInfoID between", value1, value2, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andSetcostomerserviceinfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("SetCostomerServiceInfoID not between", value1, value2, "setcostomerserviceinfoid");
            return (Criteria) this;
        }

        public Criteria andStartIsNull() {
            addCriterion("Start is null");
            return (Criteria) this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("Start is not null");
            return (Criteria) this;
        }

        public Criteria andStartEqualTo(String value) {
            addCriterion("Start =", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotEqualTo(String value) {
            addCriterion("Start <>", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThan(String value) {
            addCriterion("Start >", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThanOrEqualTo(String value) {
            addCriterion("Start >=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThan(String value) {
            addCriterion("Start <", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThanOrEqualTo(String value) {
            addCriterion("Start <=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLike(String value) {
            addCriterion("Start like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotLike(String value) {
            addCriterion("Start not like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartIn(List<String> values) {
            addCriterion("Start in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotIn(List<String> values) {
            addCriterion("Start not in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartBetween(String value1, String value2) {
            addCriterion("Start between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotBetween(String value1, String value2) {
            addCriterion("Start not between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andSiteIsNull() {
            addCriterion("Site is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("Site is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(String value) {
            addCriterion("Site =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("Site <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("Site >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("Site >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("Site <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("Site <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLike(String value) {
            addCriterion("Site like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("Site not like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<String> values) {
            addCriterion("Site in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("Site not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("Site between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("Site not between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andDialogIsNull() {
            addCriterion("Dialog is null");
            return (Criteria) this;
        }

        public Criteria andDialogIsNotNull() {
            addCriterion("Dialog is not null");
            return (Criteria) this;
        }

        public Criteria andDialogEqualTo(String value) {
            addCriterion("Dialog =", value, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogNotEqualTo(String value) {
            addCriterion("Dialog <>", value, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogGreaterThan(String value) {
            addCriterion("Dialog >", value, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogGreaterThanOrEqualTo(String value) {
            addCriterion("Dialog >=", value, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogLessThan(String value) {
            addCriterion("Dialog <", value, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogLessThanOrEqualTo(String value) {
            addCriterion("Dialog <=", value, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogLike(String value) {
            addCriterion("Dialog like", value, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogNotLike(String value) {
            addCriterion("Dialog not like", value, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogIn(List<String> values) {
            addCriterion("Dialog in", values, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogNotIn(List<String> values) {
            addCriterion("Dialog not in", values, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogBetween(String value1, String value2) {
            addCriterion("Dialog between", value1, value2, "dialog");
            return (Criteria) this;
        }

        public Criteria andDialogNotBetween(String value1, String value2) {
            addCriterion("Dialog not between", value1, value2, "dialog");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNull() {
            addCriterion("WorkTime is null");
            return (Criteria) this;
        }

        public Criteria andWorktimeIsNotNull() {
            addCriterion("WorkTime is not null");
            return (Criteria) this;
        }

        public Criteria andWorktimeEqualTo(String value) {
            addCriterion("WorkTime =", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotEqualTo(String value) {
            addCriterion("WorkTime <>", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThan(String value) {
            addCriterion("WorkTime >", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeGreaterThanOrEqualTo(String value) {
            addCriterion("WorkTime >=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThan(String value) {
            addCriterion("WorkTime <", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLessThanOrEqualTo(String value) {
            addCriterion("WorkTime <=", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeLike(String value) {
            addCriterion("WorkTime like", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotLike(String value) {
            addCriterion("WorkTime not like", value, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeIn(List<String> values) {
            addCriterion("WorkTime in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotIn(List<String> values) {
            addCriterion("WorkTime not in", values, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeBetween(String value1, String value2) {
            addCriterion("WorkTime between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andWorktimeNotBetween(String value1, String value2) {
            addCriterion("WorkTime not between", value1, value2, "worktime");
            return (Criteria) this;
        }

        public Criteria andPosition1IsNull() {
            addCriterion("Position1 is null");
            return (Criteria) this;
        }

        public Criteria andPosition1IsNotNull() {
            addCriterion("Position1 is not null");
            return (Criteria) this;
        }

        public Criteria andPosition1EqualTo(String value) {
            addCriterion("Position1 =", value, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1NotEqualTo(String value) {
            addCriterion("Position1 <>", value, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1GreaterThan(String value) {
            addCriterion("Position1 >", value, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1GreaterThanOrEqualTo(String value) {
            addCriterion("Position1 >=", value, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1LessThan(String value) {
            addCriterion("Position1 <", value, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1LessThanOrEqualTo(String value) {
            addCriterion("Position1 <=", value, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1Like(String value) {
            addCriterion("Position1 like", value, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1NotLike(String value) {
            addCriterion("Position1 not like", value, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1In(List<String> values) {
            addCriterion("Position1 in", values, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1NotIn(List<String> values) {
            addCriterion("Position1 not in", values, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1Between(String value1, String value2) {
            addCriterion("Position1 between", value1, value2, "position1");
            return (Criteria) this;
        }

        public Criteria andPosition1NotBetween(String value1, String value2) {
            addCriterion("Position1 not between", value1, value2, "position1");
            return (Criteria) this;
        }

        public Criteria andQq1IsNull() {
            addCriterion("QQ1 is null");
            return (Criteria) this;
        }

        public Criteria andQq1IsNotNull() {
            addCriterion("QQ1 is not null");
            return (Criteria) this;
        }

        public Criteria andQq1EqualTo(String value) {
            addCriterion("QQ1 =", value, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1NotEqualTo(String value) {
            addCriterion("QQ1 <>", value, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1GreaterThan(String value) {
            addCriterion("QQ1 >", value, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1GreaterThanOrEqualTo(String value) {
            addCriterion("QQ1 >=", value, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1LessThan(String value) {
            addCriterion("QQ1 <", value, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1LessThanOrEqualTo(String value) {
            addCriterion("QQ1 <=", value, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1Like(String value) {
            addCriterion("QQ1 like", value, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1NotLike(String value) {
            addCriterion("QQ1 not like", value, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1In(List<String> values) {
            addCriterion("QQ1 in", values, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1NotIn(List<String> values) {
            addCriterion("QQ1 not in", values, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1Between(String value1, String value2) {
            addCriterion("QQ1 between", value1, value2, "qq1");
            return (Criteria) this;
        }

        public Criteria andQq1NotBetween(String value1, String value2) {
            addCriterion("QQ1 not between", value1, value2, "qq1");
            return (Criteria) this;
        }

        public Criteria andPosition2IsNull() {
            addCriterion("Position2 is null");
            return (Criteria) this;
        }

        public Criteria andPosition2IsNotNull() {
            addCriterion("Position2 is not null");
            return (Criteria) this;
        }

        public Criteria andPosition2EqualTo(String value) {
            addCriterion("Position2 =", value, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2NotEqualTo(String value) {
            addCriterion("Position2 <>", value, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2GreaterThan(String value) {
            addCriterion("Position2 >", value, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2GreaterThanOrEqualTo(String value) {
            addCriterion("Position2 >=", value, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2LessThan(String value) {
            addCriterion("Position2 <", value, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2LessThanOrEqualTo(String value) {
            addCriterion("Position2 <=", value, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2Like(String value) {
            addCriterion("Position2 like", value, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2NotLike(String value) {
            addCriterion("Position2 not like", value, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2In(List<String> values) {
            addCriterion("Position2 in", values, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2NotIn(List<String> values) {
            addCriterion("Position2 not in", values, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2Between(String value1, String value2) {
            addCriterion("Position2 between", value1, value2, "position2");
            return (Criteria) this;
        }

        public Criteria andPosition2NotBetween(String value1, String value2) {
            addCriterion("Position2 not between", value1, value2, "position2");
            return (Criteria) this;
        }

        public Criteria andQq2IsNull() {
            addCriterion("QQ2 is null");
            return (Criteria) this;
        }

        public Criteria andQq2IsNotNull() {
            addCriterion("QQ2 is not null");
            return (Criteria) this;
        }

        public Criteria andQq2EqualTo(String value) {
            addCriterion("QQ2 =", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2NotEqualTo(String value) {
            addCriterion("QQ2 <>", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2GreaterThan(String value) {
            addCriterion("QQ2 >", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2GreaterThanOrEqualTo(String value) {
            addCriterion("QQ2 >=", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2LessThan(String value) {
            addCriterion("QQ2 <", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2LessThanOrEqualTo(String value) {
            addCriterion("QQ2 <=", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2Like(String value) {
            addCriterion("QQ2 like", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2NotLike(String value) {
            addCriterion("QQ2 not like", value, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2In(List<String> values) {
            addCriterion("QQ2 in", values, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2NotIn(List<String> values) {
            addCriterion("QQ2 not in", values, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2Between(String value1, String value2) {
            addCriterion("QQ2 between", value1, value2, "qq2");
            return (Criteria) this;
        }

        public Criteria andQq2NotBetween(String value1, String value2) {
            addCriterion("QQ2 not between", value1, value2, "qq2");
            return (Criteria) this;
        }

        public Criteria andPosition3IsNull() {
            addCriterion("Position3 is null");
            return (Criteria) this;
        }

        public Criteria andPosition3IsNotNull() {
            addCriterion("Position3 is not null");
            return (Criteria) this;
        }

        public Criteria andPosition3EqualTo(String value) {
            addCriterion("Position3 =", value, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3NotEqualTo(String value) {
            addCriterion("Position3 <>", value, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3GreaterThan(String value) {
            addCriterion("Position3 >", value, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3GreaterThanOrEqualTo(String value) {
            addCriterion("Position3 >=", value, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3LessThan(String value) {
            addCriterion("Position3 <", value, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3LessThanOrEqualTo(String value) {
            addCriterion("Position3 <=", value, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3Like(String value) {
            addCriterion("Position3 like", value, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3NotLike(String value) {
            addCriterion("Position3 not like", value, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3In(List<String> values) {
            addCriterion("Position3 in", values, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3NotIn(List<String> values) {
            addCriterion("Position3 not in", values, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3Between(String value1, String value2) {
            addCriterion("Position3 between", value1, value2, "position3");
            return (Criteria) this;
        }

        public Criteria andPosition3NotBetween(String value1, String value2) {
            addCriterion("Position3 not between", value1, value2, "position3");
            return (Criteria) this;
        }

        public Criteria andQq3IsNull() {
            addCriterion("QQ3 is null");
            return (Criteria) this;
        }

        public Criteria andQq3IsNotNull() {
            addCriterion("QQ3 is not null");
            return (Criteria) this;
        }

        public Criteria andQq3EqualTo(String value) {
            addCriterion("QQ3 =", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3NotEqualTo(String value) {
            addCriterion("QQ3 <>", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3GreaterThan(String value) {
            addCriterion("QQ3 >", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3GreaterThanOrEqualTo(String value) {
            addCriterion("QQ3 >=", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3LessThan(String value) {
            addCriterion("QQ3 <", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3LessThanOrEqualTo(String value) {
            addCriterion("QQ3 <=", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3Like(String value) {
            addCriterion("QQ3 like", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3NotLike(String value) {
            addCriterion("QQ3 not like", value, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3In(List<String> values) {
            addCriterion("QQ3 in", values, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3NotIn(List<String> values) {
            addCriterion("QQ3 not in", values, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3Between(String value1, String value2) {
            addCriterion("QQ3 between", value1, value2, "qq3");
            return (Criteria) this;
        }

        public Criteria andQq3NotBetween(String value1, String value2) {
            addCriterion("QQ3 not between", value1, value2, "qq3");
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