package com.jy.entiy.function.marketingFunction.registrationManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignincheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SignincheckExample() {
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

        public Criteria andSignincheckidIsNull() {
            addCriterion("SigninCheckID is null");
            return (Criteria) this;
        }

        public Criteria andSignincheckidIsNotNull() {
            addCriterion("SigninCheckID is not null");
            return (Criteria) this;
        }

        public Criteria andSignincheckidEqualTo(Integer value) {
            addCriterion("SigninCheckID =", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidNotEqualTo(Integer value) {
            addCriterion("SigninCheckID <>", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidGreaterThan(Integer value) {
            addCriterion("SigninCheckID >", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SigninCheckID >=", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidLessThan(Integer value) {
            addCriterion("SigninCheckID <", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidLessThanOrEqualTo(Integer value) {
            addCriterion("SigninCheckID <=", value, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidIn(List<Integer> values) {
            addCriterion("SigninCheckID in", values, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidNotIn(List<Integer> values) {
            addCriterion("SigninCheckID not in", values, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidBetween(Integer value1, Integer value2) {
            addCriterion("SigninCheckID between", value1, value2, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andSignincheckidNotBetween(Integer value1, Integer value2) {
            addCriterion("SigninCheckID not between", value1, value2, "signincheckid");
            return (Criteria) this;
        }

        public Criteria andActivitylocationIsNull() {
            addCriterion("ActivityLocation is null");
            return (Criteria) this;
        }

        public Criteria andActivitylocationIsNotNull() {
            addCriterion("ActivityLocation is not null");
            return (Criteria) this;
        }

        public Criteria andActivitylocationEqualTo(String value) {
            addCriterion("ActivityLocation =", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationNotEqualTo(String value) {
            addCriterion("ActivityLocation <>", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationGreaterThan(String value) {
            addCriterion("ActivityLocation >", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityLocation >=", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationLessThan(String value) {
            addCriterion("ActivityLocation <", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationLessThanOrEqualTo(String value) {
            addCriterion("ActivityLocation <=", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationLike(String value) {
            addCriterion("ActivityLocation like", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationNotLike(String value) {
            addCriterion("ActivityLocation not like", value, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationIn(List<String> values) {
            addCriterion("ActivityLocation in", values, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationNotIn(List<String> values) {
            addCriterion("ActivityLocation not in", values, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationBetween(String value1, String value2) {
            addCriterion("ActivityLocation between", value1, value2, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivitylocationNotBetween(String value1, String value2) {
            addCriterion("ActivityLocation not between", value1, value2, "activitylocation");
            return (Criteria) this;
        }

        public Criteria andActivenameIsNull() {
            addCriterion("ActiveName is null");
            return (Criteria) this;
        }

        public Criteria andActivenameIsNotNull() {
            addCriterion("ActiveName is not null");
            return (Criteria) this;
        }

        public Criteria andActivenameEqualTo(String value) {
            addCriterion("ActiveName =", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameNotEqualTo(String value) {
            addCriterion("ActiveName <>", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameGreaterThan(String value) {
            addCriterion("ActiveName >", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameGreaterThanOrEqualTo(String value) {
            addCriterion("ActiveName >=", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameLessThan(String value) {
            addCriterion("ActiveName <", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameLessThanOrEqualTo(String value) {
            addCriterion("ActiveName <=", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameLike(String value) {
            addCriterion("ActiveName like", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameNotLike(String value) {
            addCriterion("ActiveName not like", value, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameIn(List<String> values) {
            addCriterion("ActiveName in", values, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameNotIn(List<String> values) {
            addCriterion("ActiveName not in", values, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameBetween(String value1, String value2) {
            addCriterion("ActiveName between", value1, value2, "activename");
            return (Criteria) this;
        }

        public Criteria andActivenameNotBetween(String value1, String value2) {
            addCriterion("ActiveName not between", value1, value2, "activename");
            return (Criteria) this;
        }

        public Criteria andActivetimeIsNull() {
            addCriterion("ActiveTime is null");
            return (Criteria) this;
        }

        public Criteria andActivetimeIsNotNull() {
            addCriterion("ActiveTime is not null");
            return (Criteria) this;
        }

        public Criteria andActivetimeEqualTo(Date value) {
            addCriterion("ActiveTime =", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotEqualTo(Date value) {
            addCriterion("ActiveTime <>", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeGreaterThan(Date value) {
            addCriterion("ActiveTime >", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ActiveTime >=", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeLessThan(Date value) {
            addCriterion("ActiveTime <", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeLessThanOrEqualTo(Date value) {
            addCriterion("ActiveTime <=", value, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeIn(List<Date> values) {
            addCriterion("ActiveTime in", values, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotIn(List<Date> values) {
            addCriterion("ActiveTime not in", values, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeBetween(Date value1, Date value2) {
            addCriterion("ActiveTime between", value1, value2, "activetime");
            return (Criteria) this;
        }

        public Criteria andActivetimeNotBetween(Date value1, Date value2) {
            addCriterion("ActiveTime not between", value1, value2, "activetime");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathIsNull() {
            addCriterion("TwoDimensionPath is null");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathIsNotNull() {
            addCriterion("TwoDimensionPath is not null");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathEqualTo(String value) {
            addCriterion("TwoDimensionPath =", value, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathNotEqualTo(String value) {
            addCriterion("TwoDimensionPath <>", value, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathGreaterThan(String value) {
            addCriterion("TwoDimensionPath >", value, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathGreaterThanOrEqualTo(String value) {
            addCriterion("TwoDimensionPath >=", value, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathLessThan(String value) {
            addCriterion("TwoDimensionPath <", value, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathLessThanOrEqualTo(String value) {
            addCriterion("TwoDimensionPath <=", value, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathLike(String value) {
            addCriterion("TwoDimensionPath like", value, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathNotLike(String value) {
            addCriterion("TwoDimensionPath not like", value, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathIn(List<String> values) {
            addCriterion("TwoDimensionPath in", values, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathNotIn(List<String> values) {
            addCriterion("TwoDimensionPath not in", values, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathBetween(String value1, String value2) {
            addCriterion("TwoDimensionPath between", value1, value2, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andTwodimensionpathNotBetween(String value1, String value2) {
            addCriterion("TwoDimensionPath not between", value1, value2, "twodimensionpath");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlIsNull() {
            addCriterion("SigninCheckPageUrl is null");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlIsNotNull() {
            addCriterion("SigninCheckPageUrl is not null");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlEqualTo(String value) {
            addCriterion("SigninCheckPageUrl =", value, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlNotEqualTo(String value) {
            addCriterion("SigninCheckPageUrl <>", value, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlGreaterThan(String value) {
            addCriterion("SigninCheckPageUrl >", value, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlGreaterThanOrEqualTo(String value) {
            addCriterion("SigninCheckPageUrl >=", value, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlLessThan(String value) {
            addCriterion("SigninCheckPageUrl <", value, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlLessThanOrEqualTo(String value) {
            addCriterion("SigninCheckPageUrl <=", value, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlLike(String value) {
            addCriterion("SigninCheckPageUrl like", value, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlNotLike(String value) {
            addCriterion("SigninCheckPageUrl not like", value, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlIn(List<String> values) {
            addCriterion("SigninCheckPageUrl in", values, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlNotIn(List<String> values) {
            addCriterion("SigninCheckPageUrl not in", values, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlBetween(String value1, String value2) {
            addCriterion("SigninCheckPageUrl between", value1, value2, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andSignincheckpageurlNotBetween(String value1, String value2) {
            addCriterion("SigninCheckPageUrl not between", value1, value2, "signincheckpageurl");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameIsNull() {
            addCriterion("TwoDimensionName is null");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameIsNotNull() {
            addCriterion("TwoDimensionName is not null");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameEqualTo(String value) {
            addCriterion("TwoDimensionName =", value, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameNotEqualTo(String value) {
            addCriterion("TwoDimensionName <>", value, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameGreaterThan(String value) {
            addCriterion("TwoDimensionName >", value, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameGreaterThanOrEqualTo(String value) {
            addCriterion("TwoDimensionName >=", value, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameLessThan(String value) {
            addCriterion("TwoDimensionName <", value, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameLessThanOrEqualTo(String value) {
            addCriterion("TwoDimensionName <=", value, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameLike(String value) {
            addCriterion("TwoDimensionName like", value, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameNotLike(String value) {
            addCriterion("TwoDimensionName not like", value, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameIn(List<String> values) {
            addCriterion("TwoDimensionName in", values, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameNotIn(List<String> values) {
            addCriterion("TwoDimensionName not in", values, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameBetween(String value1, String value2) {
            addCriterion("TwoDimensionName between", value1, value2, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andTwodimensionnameNotBetween(String value1, String value2) {
            addCriterion("TwoDimensionName not between", value1, value2, "twodimensionname");
            return (Criteria) this;
        }

        public Criteria andVotestatusidIsNull() {
            addCriterion("VoteStatusID is null");
            return (Criteria) this;
        }

        public Criteria andVotestatusidIsNotNull() {
            addCriterion("VoteStatusID is not null");
            return (Criteria) this;
        }

        public Criteria andVotestatusidEqualTo(Integer value) {
            addCriterion("VoteStatusID =", value, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVotestatusidNotEqualTo(Integer value) {
            addCriterion("VoteStatusID <>", value, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVotestatusidGreaterThan(Integer value) {
            addCriterion("VoteStatusID >", value, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVotestatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("VoteStatusID >=", value, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVotestatusidLessThan(Integer value) {
            addCriterion("VoteStatusID <", value, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVotestatusidLessThanOrEqualTo(Integer value) {
            addCriterion("VoteStatusID <=", value, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVotestatusidIn(List<Integer> values) {
            addCriterion("VoteStatusID in", values, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVotestatusidNotIn(List<Integer> values) {
            addCriterion("VoteStatusID not in", values, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVotestatusidBetween(Integer value1, Integer value2) {
            addCriterion("VoteStatusID between", value1, value2, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVotestatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("VoteStatusID not between", value1, value2, "votestatusid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidIsNull() {
            addCriterion("VoteParticipantTypeID is null");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidIsNotNull() {
            addCriterion("VoteParticipantTypeID is not null");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidEqualTo(Integer value) {
            addCriterion("VoteParticipantTypeID =", value, "voteparticipanttypeid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidNotEqualTo(Integer value) {
            addCriterion("VoteParticipantTypeID <>", value, "voteparticipanttypeid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidGreaterThan(Integer value) {
            addCriterion("VoteParticipantTypeID >", value, "voteparticipanttypeid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("VoteParticipantTypeID >=", value, "voteparticipanttypeid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidLessThan(Integer value) {
            addCriterion("VoteParticipantTypeID <", value, "voteparticipanttypeid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidLessThanOrEqualTo(Integer value) {
            addCriterion("VoteParticipantTypeID <=", value, "voteparticipanttypeid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidIn(List<Integer> values) {
            addCriterion("VoteParticipantTypeID in", values, "voteparticipanttypeid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidNotIn(List<Integer> values) {
            addCriterion("VoteParticipantTypeID not in", values, "voteparticipanttypeid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidBetween(Integer value1, Integer value2) {
            addCriterion("VoteParticipantTypeID between", value1, value2, "voteparticipanttypeid");
            return (Criteria) this;
        }

        public Criteria andVoteparticipanttypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("VoteParticipantTypeID not between", value1, value2, "voteparticipanttypeid");
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