package com.jy.entiy.content.articleManage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleinfoExample() {
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

        public Criteria andArticleidIsNull() {
            addCriterion("ArticleID is null");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNotNull() {
            addCriterion("ArticleID is not null");
            return (Criteria) this;
        }

        public Criteria andArticleidEqualTo(Integer value) {
            addCriterion("ArticleID =", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotEqualTo(Integer value) {
            addCriterion("ArticleID <>", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThan(Integer value) {
            addCriterion("ArticleID >", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ArticleID >=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThan(Integer value) {
            addCriterion("ArticleID <", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThanOrEqualTo(Integer value) {
            addCriterion("ArticleID <=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidIn(List<Integer> values) {
            addCriterion("ArticleID in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotIn(List<Integer> values) {
            addCriterion("ArticleID not in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidBetween(Integer value1, Integer value2) {
            addCriterion("ArticleID between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotBetween(Integer value1, Integer value2) {
            addCriterion("ArticleID not between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidIsNull() {
            addCriterion("ArticleStatusID is null");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidIsNotNull() {
            addCriterion("ArticleStatusID is not null");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidEqualTo(Integer value) {
            addCriterion("ArticleStatusID =", value, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidNotEqualTo(Integer value) {
            addCriterion("ArticleStatusID <>", value, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidGreaterThan(Integer value) {
            addCriterion("ArticleStatusID >", value, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ArticleStatusID >=", value, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidLessThan(Integer value) {
            addCriterion("ArticleStatusID <", value, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidLessThanOrEqualTo(Integer value) {
            addCriterion("ArticleStatusID <=", value, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidIn(List<Integer> values) {
            addCriterion("ArticleStatusID in", values, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidNotIn(List<Integer> values) {
            addCriterion("ArticleStatusID not in", values, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidBetween(Integer value1, Integer value2) {
            addCriterion("ArticleStatusID between", value1, value2, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlestatusidNotBetween(Integer value1, Integer value2) {
            addCriterion("ArticleStatusID not between", value1, value2, "articlestatusid");
            return (Criteria) this;
        }

        public Criteria andArticlenoIsNull() {
            addCriterion("ArticleNo is null");
            return (Criteria) this;
        }

        public Criteria andArticlenoIsNotNull() {
            addCriterion("ArticleNo is not null");
            return (Criteria) this;
        }

        public Criteria andArticlenoEqualTo(Integer value) {
            addCriterion("ArticleNo =", value, "articleno");
            return (Criteria) this;
        }

        public Criteria andArticlenoNotEqualTo(Integer value) {
            addCriterion("ArticleNo <>", value, "articleno");
            return (Criteria) this;
        }

        public Criteria andArticlenoGreaterThan(Integer value) {
            addCriterion("ArticleNo >", value, "articleno");
            return (Criteria) this;
        }

        public Criteria andArticlenoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ArticleNo >=", value, "articleno");
            return (Criteria) this;
        }

        public Criteria andArticlenoLessThan(Integer value) {
            addCriterion("ArticleNo <", value, "articleno");
            return (Criteria) this;
        }

        public Criteria andArticlenoLessThanOrEqualTo(Integer value) {
            addCriterion("ArticleNo <=", value, "articleno");
            return (Criteria) this;
        }

        public Criteria andArticlenoIn(List<Integer> values) {
            addCriterion("ArticleNo in", values, "articleno");
            return (Criteria) this;
        }

        public Criteria andArticlenoNotIn(List<Integer> values) {
            addCriterion("ArticleNo not in", values, "articleno");
            return (Criteria) this;
        }

        public Criteria andArticlenoBetween(Integer value1, Integer value2) {
            addCriterion("ArticleNo between", value1, value2, "articleno");
            return (Criteria) this;
        }

        public Criteria andArticlenoNotBetween(Integer value1, Integer value2) {
            addCriterion("ArticleNo not between", value1, value2, "articleno");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidIsNull() {
            addCriterion("PageColumnID is null");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidIsNotNull() {
            addCriterion("PageColumnID is not null");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidEqualTo(Integer value) {
            addCriterion("PageColumnID =", value, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidNotEqualTo(Integer value) {
            addCriterion("PageColumnID <>", value, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidGreaterThan(Integer value) {
            addCriterion("PageColumnID >", value, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PageColumnID >=", value, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidLessThan(Integer value) {
            addCriterion("PageColumnID <", value, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidLessThanOrEqualTo(Integer value) {
            addCriterion("PageColumnID <=", value, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidIn(List<Integer> values) {
            addCriterion("PageColumnID in", values, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidNotIn(List<Integer> values) {
            addCriterion("PageColumnID not in", values, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidBetween(Integer value1, Integer value2) {
            addCriterion("PageColumnID between", value1, value2, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andPagecolumnidNotBetween(Integer value1, Integer value2) {
            addCriterion("PageColumnID not between", value1, value2, "pagecolumnid");
            return (Criteria) this;
        }

        public Criteria andArticletitleIsNull() {
            addCriterion("ArticleTitle is null");
            return (Criteria) this;
        }

        public Criteria andArticletitleIsNotNull() {
            addCriterion("ArticleTitle is not null");
            return (Criteria) this;
        }

        public Criteria andArticletitleEqualTo(String value) {
            addCriterion("ArticleTitle =", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotEqualTo(String value) {
            addCriterion("ArticleTitle <>", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleGreaterThan(String value) {
            addCriterion("ArticleTitle >", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleGreaterThanOrEqualTo(String value) {
            addCriterion("ArticleTitle >=", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleLessThan(String value) {
            addCriterion("ArticleTitle <", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleLessThanOrEqualTo(String value) {
            addCriterion("ArticleTitle <=", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleLike(String value) {
            addCriterion("ArticleTitle like", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotLike(String value) {
            addCriterion("ArticleTitle not like", value, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleIn(List<String> values) {
            addCriterion("ArticleTitle in", values, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotIn(List<String> values) {
            addCriterion("ArticleTitle not in", values, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleBetween(String value1, String value2) {
            addCriterion("ArticleTitle between", value1, value2, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticletitleNotBetween(String value1, String value2) {
            addCriterion("ArticleTitle not between", value1, value2, "articletitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleIsNull() {
            addCriterion("ArticleSubTitle is null");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleIsNotNull() {
            addCriterion("ArticleSubTitle is not null");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleEqualTo(String value) {
            addCriterion("ArticleSubTitle =", value, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleNotEqualTo(String value) {
            addCriterion("ArticleSubTitle <>", value, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleGreaterThan(String value) {
            addCriterion("ArticleSubTitle >", value, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("ArticleSubTitle >=", value, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleLessThan(String value) {
            addCriterion("ArticleSubTitle <", value, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleLessThanOrEqualTo(String value) {
            addCriterion("ArticleSubTitle <=", value, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleLike(String value) {
            addCriterion("ArticleSubTitle like", value, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleNotLike(String value) {
            addCriterion("ArticleSubTitle not like", value, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleIn(List<String> values) {
            addCriterion("ArticleSubTitle in", values, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleNotIn(List<String> values) {
            addCriterion("ArticleSubTitle not in", values, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleBetween(String value1, String value2) {
            addCriterion("ArticleSubTitle between", value1, value2, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andArticlesubtitleNotBetween(String value1, String value2) {
            addCriterion("ArticleSubTitle not between", value1, value2, "articlesubtitle");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("Keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("Keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("Keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("Keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("Keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("Keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("Keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("Keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("Keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("Keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("Keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("Keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("Keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("Keyword not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andSeoabstractIsNull() {
            addCriterion("SEOAbstract is null");
            return (Criteria) this;
        }

        public Criteria andSeoabstractIsNotNull() {
            addCriterion("SEOAbstract is not null");
            return (Criteria) this;
        }

        public Criteria andSeoabstractEqualTo(String value) {
            addCriterion("SEOAbstract =", value, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractNotEqualTo(String value) {
            addCriterion("SEOAbstract <>", value, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractGreaterThan(String value) {
            addCriterion("SEOAbstract >", value, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractGreaterThanOrEqualTo(String value) {
            addCriterion("SEOAbstract >=", value, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractLessThan(String value) {
            addCriterion("SEOAbstract <", value, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractLessThanOrEqualTo(String value) {
            addCriterion("SEOAbstract <=", value, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractLike(String value) {
            addCriterion("SEOAbstract like", value, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractNotLike(String value) {
            addCriterion("SEOAbstract not like", value, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractIn(List<String> values) {
            addCriterion("SEOAbstract in", values, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractNotIn(List<String> values) {
            addCriterion("SEOAbstract not in", values, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractBetween(String value1, String value2) {
            addCriterion("SEOAbstract between", value1, value2, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andSeoabstractNotBetween(String value1, String value2) {
            addCriterion("SEOAbstract not between", value1, value2, "seoabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractIsNull() {
            addCriterion("ArticleAbstract is null");
            return (Criteria) this;
        }

        public Criteria andArticleabstractIsNotNull() {
            addCriterion("ArticleAbstract is not null");
            return (Criteria) this;
        }

        public Criteria andArticleabstractEqualTo(String value) {
            addCriterion("ArticleAbstract =", value, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractNotEqualTo(String value) {
            addCriterion("ArticleAbstract <>", value, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractGreaterThan(String value) {
            addCriterion("ArticleAbstract >", value, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractGreaterThanOrEqualTo(String value) {
            addCriterion("ArticleAbstract >=", value, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractLessThan(String value) {
            addCriterion("ArticleAbstract <", value, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractLessThanOrEqualTo(String value) {
            addCriterion("ArticleAbstract <=", value, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractLike(String value) {
            addCriterion("ArticleAbstract like", value, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractNotLike(String value) {
            addCriterion("ArticleAbstract not like", value, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractIn(List<String> values) {
            addCriterion("ArticleAbstract in", values, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractNotIn(List<String> values) {
            addCriterion("ArticleAbstract not in", values, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractBetween(String value1, String value2) {
            addCriterion("ArticleAbstract between", value1, value2, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andArticleabstractNotBetween(String value1, String value2) {
            addCriterion("ArticleAbstract not between", value1, value2, "articleabstract");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidIsNull() {
            addCriterion("ThumbnailFileID is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidIsNotNull() {
            addCriterion("ThumbnailFileID is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidEqualTo(String value) {
            addCriterion("ThumbnailFileID =", value, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidNotEqualTo(String value) {
            addCriterion("ThumbnailFileID <>", value, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidGreaterThan(String value) {
            addCriterion("ThumbnailFileID >", value, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidGreaterThanOrEqualTo(String value) {
            addCriterion("ThumbnailFileID >=", value, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidLessThan(String value) {
            addCriterion("ThumbnailFileID <", value, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidLessThanOrEqualTo(String value) {
            addCriterion("ThumbnailFileID <=", value, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidLike(String value) {
            addCriterion("ThumbnailFileID like", value, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidNotLike(String value) {
            addCriterion("ThumbnailFileID not like", value, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidIn(List<String> values) {
            addCriterion("ThumbnailFileID in", values, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidNotIn(List<String> values) {
            addCriterion("ThumbnailFileID not in", values, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidBetween(String value1, String value2) {
            addCriterion("ThumbnailFileID between", value1, value2, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailfileidNotBetween(String value1, String value2) {
            addCriterion("ThumbnailFileID not between", value1, value2, "thumbnailfileid");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathIsNull() {
            addCriterion("ThumbnailPath is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathIsNotNull() {
            addCriterion("ThumbnailPath is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathEqualTo(String value) {
            addCriterion("ThumbnailPath =", value, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathNotEqualTo(String value) {
            addCriterion("ThumbnailPath <>", value, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathGreaterThan(String value) {
            addCriterion("ThumbnailPath >", value, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathGreaterThanOrEqualTo(String value) {
            addCriterion("ThumbnailPath >=", value, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathLessThan(String value) {
            addCriterion("ThumbnailPath <", value, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathLessThanOrEqualTo(String value) {
            addCriterion("ThumbnailPath <=", value, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathLike(String value) {
            addCriterion("ThumbnailPath like", value, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathNotLike(String value) {
            addCriterion("ThumbnailPath not like", value, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathIn(List<String> values) {
            addCriterion("ThumbnailPath in", values, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathNotIn(List<String> values) {
            addCriterion("ThumbnailPath not in", values, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathBetween(String value1, String value2) {
            addCriterion("ThumbnailPath between", value1, value2, "thumbnailpath");
            return (Criteria) this;
        }

        public Criteria andThumbnailpathNotBetween(String value1, String value2) {
            addCriterion("ThumbnailPath not between", value1, value2, "thumbnailpath");
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

        public Criteria andAttachmentfileidIsNull() {
            addCriterion("AttachmentFileID is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidIsNotNull() {
            addCriterion("AttachmentFileID is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidEqualTo(String value) {
            addCriterion("AttachmentFileID =", value, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidNotEqualTo(String value) {
            addCriterion("AttachmentFileID <>", value, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidGreaterThan(String value) {
            addCriterion("AttachmentFileID >", value, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidGreaterThanOrEqualTo(String value) {
            addCriterion("AttachmentFileID >=", value, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidLessThan(String value) {
            addCriterion("AttachmentFileID <", value, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidLessThanOrEqualTo(String value) {
            addCriterion("AttachmentFileID <=", value, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidLike(String value) {
            addCriterion("AttachmentFileID like", value, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidNotLike(String value) {
            addCriterion("AttachmentFileID not like", value, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidIn(List<String> values) {
            addCriterion("AttachmentFileID in", values, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidNotIn(List<String> values) {
            addCriterion("AttachmentFileID not in", values, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidBetween(String value1, String value2) {
            addCriterion("AttachmentFileID between", value1, value2, "attachmentfileid");
            return (Criteria) this;
        }

        public Criteria andAttachmentfileidNotBetween(String value1, String value2) {
            addCriterion("AttachmentFileID not between", value1, value2, "attachmentfileid");
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

        public Criteria andDeadlinetimeIsNull() {
            addCriterion("DeadlineTime is null");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeIsNotNull() {
            addCriterion("DeadlineTime is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeEqualTo(Date value) {
            addCriterion("DeadlineTime =", value, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeNotEqualTo(Date value) {
            addCriterion("DeadlineTime <>", value, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeGreaterThan(Date value) {
            addCriterion("DeadlineTime >", value, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DeadlineTime >=", value, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeLessThan(Date value) {
            addCriterion("DeadlineTime <", value, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeLessThanOrEqualTo(Date value) {
            addCriterion("DeadlineTime <=", value, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeIn(List<Date> values) {
            addCriterion("DeadlineTime in", values, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeNotIn(List<Date> values) {
            addCriterion("DeadlineTime not in", values, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeBetween(Date value1, Date value2) {
            addCriterion("DeadlineTime between", value1, value2, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeadlinetimeNotBetween(Date value1, Date value2) {
            addCriterion("DeadlineTime not between", value1, value2, "deadlinetime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeIsNull() {
            addCriterion("DeploymentTime is null");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeIsNotNull() {
            addCriterion("DeploymentTime is not null");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeEqualTo(Date value) {
            addCriterion("DeploymentTime =", value, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeNotEqualTo(Date value) {
            addCriterion("DeploymentTime <>", value, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeGreaterThan(Date value) {
            addCriterion("DeploymentTime >", value, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DeploymentTime >=", value, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeLessThan(Date value) {
            addCriterion("DeploymentTime <", value, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeLessThanOrEqualTo(Date value) {
            addCriterion("DeploymentTime <=", value, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeIn(List<Date> values) {
            addCriterion("DeploymentTime in", values, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeNotIn(List<Date> values) {
            addCriterion("DeploymentTime not in", values, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeBetween(Date value1, Date value2) {
            addCriterion("DeploymentTime between", value1, value2, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploymenttimeNotBetween(Date value1, Date value2) {
            addCriterion("DeploymentTime not between", value1, value2, "deploymenttime");
            return (Criteria) this;
        }

        public Criteria andDeploypersonIsNull() {
            addCriterion("DeployPerson is null");
            return (Criteria) this;
        }

        public Criteria andDeploypersonIsNotNull() {
            addCriterion("DeployPerson is not null");
            return (Criteria) this;
        }

        public Criteria andDeploypersonEqualTo(String value) {
            addCriterion("DeployPerson =", value, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonNotEqualTo(String value) {
            addCriterion("DeployPerson <>", value, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonGreaterThan(String value) {
            addCriterion("DeployPerson >", value, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonGreaterThanOrEqualTo(String value) {
            addCriterion("DeployPerson >=", value, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonLessThan(String value) {
            addCriterion("DeployPerson <", value, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonLessThanOrEqualTo(String value) {
            addCriterion("DeployPerson <=", value, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonLike(String value) {
            addCriterion("DeployPerson like", value, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonNotLike(String value) {
            addCriterion("DeployPerson not like", value, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonIn(List<String> values) {
            addCriterion("DeployPerson in", values, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonNotIn(List<String> values) {
            addCriterion("DeployPerson not in", values, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonBetween(String value1, String value2) {
            addCriterion("DeployPerson between", value1, value2, "deployperson");
            return (Criteria) this;
        }

        public Criteria andDeploypersonNotBetween(String value1, String value2) {
            addCriterion("DeployPerson not between", value1, value2, "deployperson");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceIsNull() {
            addCriterion("OriginalSource is null");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceIsNotNull() {
            addCriterion("OriginalSource is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceEqualTo(String value) {
            addCriterion("OriginalSource =", value, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceNotEqualTo(String value) {
            addCriterion("OriginalSource <>", value, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceGreaterThan(String value) {
            addCriterion("OriginalSource >", value, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceGreaterThanOrEqualTo(String value) {
            addCriterion("OriginalSource >=", value, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceLessThan(String value) {
            addCriterion("OriginalSource <", value, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceLessThanOrEqualTo(String value) {
            addCriterion("OriginalSource <=", value, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceLike(String value) {
            addCriterion("OriginalSource like", value, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceNotLike(String value) {
            addCriterion("OriginalSource not like", value, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceIn(List<String> values) {
            addCriterion("OriginalSource in", values, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceNotIn(List<String> values) {
            addCriterion("OriginalSource not in", values, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceBetween(String value1, String value2) {
            addCriterion("OriginalSource between", value1, value2, "originalsource");
            return (Criteria) this;
        }

        public Criteria andOriginalsourceNotBetween(String value1, String value2) {
            addCriterion("OriginalSource not between", value1, value2, "originalsource");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("IsDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("IsDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(String value) {
            addCriterion("IsDelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(String value) {
            addCriterion("IsDelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(String value) {
            addCriterion("IsDelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(String value) {
            addCriterion("IsDelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(String value) {
            addCriterion("IsDelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(String value) {
            addCriterion("IsDelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLike(String value) {
            addCriterion("IsDelete like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotLike(String value) {
            addCriterion("IsDelete not like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<String> values) {
            addCriterion("IsDelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<String> values) {
            addCriterion("IsDelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(String value1, String value2) {
            addCriterion("IsDelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(String value1, String value2) {
            addCriterion("IsDelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsactiveIsNull() {
            addCriterion("IsActive is null");
            return (Criteria) this;
        }

        public Criteria andIsactiveIsNotNull() {
            addCriterion("IsActive is not null");
            return (Criteria) this;
        }

        public Criteria andIsactiveEqualTo(String value) {
            addCriterion("IsActive =", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotEqualTo(String value) {
            addCriterion("IsActive <>", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThan(String value) {
            addCriterion("IsActive >", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThanOrEqualTo(String value) {
            addCriterion("IsActive >=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThan(String value) {
            addCriterion("IsActive <", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThanOrEqualTo(String value) {
            addCriterion("IsActive <=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLike(String value) {
            addCriterion("IsActive like", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotLike(String value) {
            addCriterion("IsActive not like", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveIn(List<String> values) {
            addCriterion("IsActive in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotIn(List<String> values) {
            addCriterion("IsActive not in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveBetween(String value1, String value2) {
            addCriterion("IsActive between", value1, value2, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotBetween(String value1, String value2) {
            addCriterion("IsActive not between", value1, value2, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedIsNull() {
            addCriterion("IsAuditPassed is null");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedIsNotNull() {
            addCriterion("IsAuditPassed is not null");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedEqualTo(String value) {
            addCriterion("IsAuditPassed =", value, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedNotEqualTo(String value) {
            addCriterion("IsAuditPassed <>", value, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedGreaterThan(String value) {
            addCriterion("IsAuditPassed >", value, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedGreaterThanOrEqualTo(String value) {
            addCriterion("IsAuditPassed >=", value, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedLessThan(String value) {
            addCriterion("IsAuditPassed <", value, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedLessThanOrEqualTo(String value) {
            addCriterion("IsAuditPassed <=", value, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedLike(String value) {
            addCriterion("IsAuditPassed like", value, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedNotLike(String value) {
            addCriterion("IsAuditPassed not like", value, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedIn(List<String> values) {
            addCriterion("IsAuditPassed in", values, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedNotIn(List<String> values) {
            addCriterion("IsAuditPassed not in", values, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedBetween(String value1, String value2) {
            addCriterion("IsAuditPassed between", value1, value2, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andIsauditpassedNotBetween(String value1, String value2) {
            addCriterion("IsAuditPassed not between", value1, value2, "isauditpassed");
            return (Criteria) this;
        }

        public Criteria andAuditcommentIsNull() {
            addCriterion("AuditComment is null");
            return (Criteria) this;
        }

        public Criteria andAuditcommentIsNotNull() {
            addCriterion("AuditComment is not null");
            return (Criteria) this;
        }

        public Criteria andAuditcommentEqualTo(String value) {
            addCriterion("AuditComment =", value, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentNotEqualTo(String value) {
            addCriterion("AuditComment <>", value, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentGreaterThan(String value) {
            addCriterion("AuditComment >", value, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentGreaterThanOrEqualTo(String value) {
            addCriterion("AuditComment >=", value, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentLessThan(String value) {
            addCriterion("AuditComment <", value, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentLessThanOrEqualTo(String value) {
            addCriterion("AuditComment <=", value, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentLike(String value) {
            addCriterion("AuditComment like", value, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentNotLike(String value) {
            addCriterion("AuditComment not like", value, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentIn(List<String> values) {
            addCriterion("AuditComment in", values, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentNotIn(List<String> values) {
            addCriterion("AuditComment not in", values, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentBetween(String value1, String value2) {
            addCriterion("AuditComment between", value1, value2, "auditcomment");
            return (Criteria) this;
        }

        public Criteria andAuditcommentNotBetween(String value1, String value2) {
            addCriterion("AuditComment not between", value1, value2, "auditcomment");
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

        public Criteria andLivevediolistidIsNull() {
            addCriterion("LiveVedioListID is null");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidIsNotNull() {
            addCriterion("LiveVedioListID is not null");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidEqualTo(Long value) {
            addCriterion("LiveVedioListID =", value, "livevediolistid");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidNotEqualTo(Long value) {
            addCriterion("LiveVedioListID <>", value, "livevediolistid");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidGreaterThan(Long value) {
            addCriterion("LiveVedioListID >", value, "livevediolistid");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidGreaterThanOrEqualTo(Long value) {
            addCriterion("LiveVedioListID >=", value, "livevediolistid");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidLessThan(Long value) {
            addCriterion("LiveVedioListID <", value, "livevediolistid");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidLessThanOrEqualTo(Long value) {
            addCriterion("LiveVedioListID <=", value, "livevediolistid");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidIn(List<Long> values) {
            addCriterion("LiveVedioListID in", values, "livevediolistid");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidNotIn(List<Long> values) {
            addCriterion("LiveVedioListID not in", values, "livevediolistid");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidBetween(Long value1, Long value2) {
            addCriterion("LiveVedioListID between", value1, value2, "livevediolistid");
            return (Criteria) this;
        }

        public Criteria andLivevediolistidNotBetween(Long value1, Long value2) {
            addCriterion("LiveVedioListID not between", value1, value2, "livevediolistid");
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