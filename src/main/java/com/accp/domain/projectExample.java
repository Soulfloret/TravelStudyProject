package com.accp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class projectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public projectExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pName is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pName is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pName =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pName <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pName >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pName >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pName <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pName <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pName like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pName not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pName in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pName not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pName between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pName not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andSafetimeIsNull() {
            addCriterion("safeTime is null");
            return (Criteria) this;
        }

        public Criteria andSafetimeIsNotNull() {
            addCriterion("safeTime is not null");
            return (Criteria) this;
        }

        public Criteria andSafetimeEqualTo(Date value) {
            addCriterion("safeTime =", value, "safetime");
            return (Criteria) this;
        }

        public Criteria andSafetimeNotEqualTo(Date value) {
            addCriterion("safeTime <>", value, "safetime");
            return (Criteria) this;
        }

        public Criteria andSafetimeGreaterThan(Date value) {
            addCriterion("safeTime >", value, "safetime");
            return (Criteria) this;
        }

        public Criteria andSafetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("safeTime >=", value, "safetime");
            return (Criteria) this;
        }

        public Criteria andSafetimeLessThan(Date value) {
            addCriterion("safeTime <", value, "safetime");
            return (Criteria) this;
        }

        public Criteria andSafetimeLessThanOrEqualTo(Date value) {
            addCriterion("safeTime <=", value, "safetime");
            return (Criteria) this;
        }

        public Criteria andSafetimeIn(List<Date> values) {
            addCriterion("safeTime in", values, "safetime");
            return (Criteria) this;
        }

        public Criteria andSafetimeNotIn(List<Date> values) {
            addCriterion("safeTime not in", values, "safetime");
            return (Criteria) this;
        }

        public Criteria andSafetimeBetween(Date value1, Date value2) {
            addCriterion("safeTime between", value1, value2, "safetime");
            return (Criteria) this;
        }

        public Criteria andSafetimeNotBetween(Date value1, Date value2) {
            addCriterion("safeTime not between", value1, value2, "safetime");
            return (Criteria) this;
        }

        public Criteria andPstatusIsNull() {
            addCriterion("pstatus is null");
            return (Criteria) this;
        }

        public Criteria andPstatusIsNotNull() {
            addCriterion("pstatus is not null");
            return (Criteria) this;
        }

        public Criteria andPstatusEqualTo(String value) {
            addCriterion("pstatus =", value, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusNotEqualTo(String value) {
            addCriterion("pstatus <>", value, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusGreaterThan(String value) {
            addCriterion("pstatus >", value, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusGreaterThanOrEqualTo(String value) {
            addCriterion("pstatus >=", value, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusLessThan(String value) {
            addCriterion("pstatus <", value, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusLessThanOrEqualTo(String value) {
            addCriterion("pstatus <=", value, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusLike(String value) {
            addCriterion("pstatus like", value, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusNotLike(String value) {
            addCriterion("pstatus not like", value, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusIn(List<String> values) {
            addCriterion("pstatus in", values, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusNotIn(List<String> values) {
            addCriterion("pstatus not in", values, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusBetween(String value1, String value2) {
            addCriterion("pstatus between", value1, value2, "pstatus");
            return (Criteria) this;
        }

        public Criteria andPstatusNotBetween(String value1, String value2) {
            addCriterion("pstatus not between", value1, value2, "pstatus");
            return (Criteria) this;
        }

        public Criteria andMincrowdIsNull() {
            addCriterion("mincrowd is null");
            return (Criteria) this;
        }

        public Criteria andMincrowdIsNotNull() {
            addCriterion("mincrowd is not null");
            return (Criteria) this;
        }

        public Criteria andMincrowdEqualTo(Integer value) {
            addCriterion("mincrowd =", value, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMincrowdNotEqualTo(Integer value) {
            addCriterion("mincrowd <>", value, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMincrowdGreaterThan(Integer value) {
            addCriterion("mincrowd >", value, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMincrowdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mincrowd >=", value, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMincrowdLessThan(Integer value) {
            addCriterion("mincrowd <", value, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMincrowdLessThanOrEqualTo(Integer value) {
            addCriterion("mincrowd <=", value, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMincrowdIn(List<Integer> values) {
            addCriterion("mincrowd in", values, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMincrowdNotIn(List<Integer> values) {
            addCriterion("mincrowd not in", values, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMincrowdBetween(Integer value1, Integer value2) {
            addCriterion("mincrowd between", value1, value2, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMincrowdNotBetween(Integer value1, Integer value2) {
            addCriterion("mincrowd not between", value1, value2, "mincrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdIsNull() {
            addCriterion("maxcrowd is null");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdIsNotNull() {
            addCriterion("maxcrowd is not null");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdEqualTo(Integer value) {
            addCriterion("maxcrowd =", value, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdNotEqualTo(Integer value) {
            addCriterion("maxcrowd <>", value, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdGreaterThan(Integer value) {
            addCriterion("maxcrowd >", value, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxcrowd >=", value, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdLessThan(Integer value) {
            addCriterion("maxcrowd <", value, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdLessThanOrEqualTo(Integer value) {
            addCriterion("maxcrowd <=", value, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdIn(List<Integer> values) {
            addCriterion("maxcrowd in", values, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdNotIn(List<Integer> values) {
            addCriterion("maxcrowd not in", values, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdBetween(Integer value1, Integer value2) {
            addCriterion("maxcrowd between", value1, value2, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMaxcrowdNotBetween(Integer value1, Integer value2) {
            addCriterion("maxcrowd not between", value1, value2, "maxcrowd");
            return (Criteria) this;
        }

        public Criteria andMinheightIsNull() {
            addCriterion("minheight is null");
            return (Criteria) this;
        }

        public Criteria andMinheightIsNotNull() {
            addCriterion("minheight is not null");
            return (Criteria) this;
        }

        public Criteria andMinheightEqualTo(Double value) {
            addCriterion("minheight =", value, "minheight");
            return (Criteria) this;
        }

        public Criteria andMinheightNotEqualTo(Double value) {
            addCriterion("minheight <>", value, "minheight");
            return (Criteria) this;
        }

        public Criteria andMinheightGreaterThan(Double value) {
            addCriterion("minheight >", value, "minheight");
            return (Criteria) this;
        }

        public Criteria andMinheightGreaterThanOrEqualTo(Double value) {
            addCriterion("minheight >=", value, "minheight");
            return (Criteria) this;
        }

        public Criteria andMinheightLessThan(Double value) {
            addCriterion("minheight <", value, "minheight");
            return (Criteria) this;
        }

        public Criteria andMinheightLessThanOrEqualTo(Double value) {
            addCriterion("minheight <=", value, "minheight");
            return (Criteria) this;
        }

        public Criteria andMinheightIn(List<Double> values) {
            addCriterion("minheight in", values, "minheight");
            return (Criteria) this;
        }

        public Criteria andMinheightNotIn(List<Double> values) {
            addCriterion("minheight not in", values, "minheight");
            return (Criteria) this;
        }

        public Criteria andMinheightBetween(Double value1, Double value2) {
            addCriterion("minheight between", value1, value2, "minheight");
            return (Criteria) this;
        }

        public Criteria andMinheightNotBetween(Double value1, Double value2) {
            addCriterion("minheight not between", value1, value2, "minheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightIsNull() {
            addCriterion("maxheight is null");
            return (Criteria) this;
        }

        public Criteria andMaxheightIsNotNull() {
            addCriterion("maxheight is not null");
            return (Criteria) this;
        }

        public Criteria andMaxheightEqualTo(Double value) {
            addCriterion("maxheight =", value, "maxheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightNotEqualTo(Double value) {
            addCriterion("maxheight <>", value, "maxheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightGreaterThan(Double value) {
            addCriterion("maxheight >", value, "maxheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightGreaterThanOrEqualTo(Double value) {
            addCriterion("maxheight >=", value, "maxheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightLessThan(Double value) {
            addCriterion("maxheight <", value, "maxheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightLessThanOrEqualTo(Double value) {
            addCriterion("maxheight <=", value, "maxheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightIn(List<Double> values) {
            addCriterion("maxheight in", values, "maxheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightNotIn(List<Double> values) {
            addCriterion("maxheight not in", values, "maxheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightBetween(Double value1, Double value2) {
            addCriterion("maxheight between", value1, value2, "maxheight");
            return (Criteria) this;
        }

        public Criteria andMaxheightNotBetween(Double value1, Double value2) {
            addCriterion("maxheight not between", value1, value2, "maxheight");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andNeedtimeIsNull() {
            addCriterion("needTime is null");
            return (Criteria) this;
        }

        public Criteria andNeedtimeIsNotNull() {
            addCriterion("needTime is not null");
            return (Criteria) this;
        }

        public Criteria andNeedtimeEqualTo(String value) {
            addCriterion("needTime =", value, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeNotEqualTo(String value) {
            addCriterion("needTime <>", value, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeGreaterThan(String value) {
            addCriterion("needTime >", value, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeGreaterThanOrEqualTo(String value) {
            addCriterion("needTime >=", value, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeLessThan(String value) {
            addCriterion("needTime <", value, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeLessThanOrEqualTo(String value) {
            addCriterion("needTime <=", value, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeLike(String value) {
            addCriterion("needTime like", value, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeNotLike(String value) {
            addCriterion("needTime not like", value, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeIn(List<String> values) {
            addCriterion("needTime in", values, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeNotIn(List<String> values) {
            addCriterion("needTime not in", values, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeBetween(String value1, String value2) {
            addCriterion("needTime between", value1, value2, "needtime");
            return (Criteria) this;
        }

        public Criteria andNeedtimeNotBetween(String value1, String value2) {
            addCriterion("needTime not between", value1, value2, "needtime");
            return (Criteria) this;
        }

        public Criteria andGalleryfulIsNull() {
            addCriterion("galleryful is null");
            return (Criteria) this;
        }

        public Criteria andGalleryfulIsNotNull() {
            addCriterion("galleryful is not null");
            return (Criteria) this;
        }

        public Criteria andGalleryfulEqualTo(Integer value) {
            addCriterion("galleryful =", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulNotEqualTo(Integer value) {
            addCriterion("galleryful <>", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulGreaterThan(Integer value) {
            addCriterion("galleryful >", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulGreaterThanOrEqualTo(Integer value) {
            addCriterion("galleryful >=", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulLessThan(Integer value) {
            addCriterion("galleryful <", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulLessThanOrEqualTo(Integer value) {
            addCriterion("galleryful <=", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulIn(List<Integer> values) {
            addCriterion("galleryful in", values, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulNotIn(List<Integer> values) {
            addCriterion("galleryful not in", values, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulBetween(Integer value1, Integer value2) {
            addCriterion("galleryful between", value1, value2, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulNotBetween(Integer value1, Integer value2) {
            addCriterion("galleryful not between", value1, value2, "galleryful");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(Double value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(Double value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(Double value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(Double value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(Double value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(Double value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<Double> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<Double> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(Double value1, Double value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(Double value1, Double value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialIsNull() {
            addCriterion("leadingoffcial is null");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialIsNotNull() {
            addCriterion("leadingoffcial is not null");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialEqualTo(Integer value) {
            addCriterion("leadingoffcial =", value, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialNotEqualTo(Integer value) {
            addCriterion("leadingoffcial <>", value, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialGreaterThan(Integer value) {
            addCriterion("leadingoffcial >", value, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialGreaterThanOrEqualTo(Integer value) {
            addCriterion("leadingoffcial >=", value, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialLessThan(Integer value) {
            addCriterion("leadingoffcial <", value, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialLessThanOrEqualTo(Integer value) {
            addCriterion("leadingoffcial <=", value, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialIn(List<Integer> values) {
            addCriterion("leadingoffcial in", values, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialNotIn(List<Integer> values) {
            addCriterion("leadingoffcial not in", values, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialBetween(Integer value1, Integer value2) {
            addCriterion("leadingoffcial between", value1, value2, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andLeadingoffcialNotBetween(Integer value1, Integer value2) {
            addCriterion("leadingoffcial not between", value1, value2, "leadingoffcial");
            return (Criteria) this;
        }

        public Criteria andNewpriceIsNull() {
            addCriterion("newPrice is null");
            return (Criteria) this;
        }

        public Criteria andNewpriceIsNotNull() {
            addCriterion("newPrice is not null");
            return (Criteria) this;
        }

        public Criteria andNewpriceEqualTo(Double value) {
            addCriterion("newPrice =", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceNotEqualTo(Double value) {
            addCriterion("newPrice <>", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceGreaterThan(Double value) {
            addCriterion("newPrice >", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("newPrice >=", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceLessThan(Double value) {
            addCriterion("newPrice <", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceLessThanOrEqualTo(Double value) {
            addCriterion("newPrice <=", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceIn(List<Double> values) {
            addCriterion("newPrice in", values, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceNotIn(List<Double> values) {
            addCriterion("newPrice not in", values, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceBetween(Double value1, Double value2) {
            addCriterion("newPrice between", value1, value2, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceNotBetween(Double value1, Double value2) {
            addCriterion("newPrice not between", value1, value2, "newprice");
            return (Criteria) this;
        }

        public Criteria andName1IsNull() {
            addCriterion("name1 is null");
            return (Criteria) this;
        }

        public Criteria andName1IsNotNull() {
            addCriterion("name1 is not null");
            return (Criteria) this;
        }

        public Criteria andName1EqualTo(String value) {
            addCriterion("name1 =", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotEqualTo(String value) {
            addCriterion("name1 <>", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThan(String value) {
            addCriterion("name1 >", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThanOrEqualTo(String value) {
            addCriterion("name1 >=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThan(String value) {
            addCriterion("name1 <", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThanOrEqualTo(String value) {
            addCriterion("name1 <=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Like(String value) {
            addCriterion("name1 like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotLike(String value) {
            addCriterion("name1 not like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1In(List<String> values) {
            addCriterion("name1 in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotIn(List<String> values) {
            addCriterion("name1 not in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Between(String value1, String value2) {
            addCriterion("name1 between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotBetween(String value1, String value2) {
            addCriterion("name1 not between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andName2IsNull() {
            addCriterion("name2 is null");
            return (Criteria) this;
        }

        public Criteria andName2IsNotNull() {
            addCriterion("name2 is not null");
            return (Criteria) this;
        }

        public Criteria andName2EqualTo(String value) {
            addCriterion("name2 =", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotEqualTo(String value) {
            addCriterion("name2 <>", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2GreaterThan(String value) {
            addCriterion("name2 >", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2GreaterThanOrEqualTo(String value) {
            addCriterion("name2 >=", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2LessThan(String value) {
            addCriterion("name2 <", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2LessThanOrEqualTo(String value) {
            addCriterion("name2 <=", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2Like(String value) {
            addCriterion("name2 like", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotLike(String value) {
            addCriterion("name2 not like", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2In(List<String> values) {
            addCriterion("name2 in", values, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotIn(List<String> values) {
            addCriterion("name2 not in", values, "name2");
            return (Criteria) this;
        }

        public Criteria andName2Between(String value1, String value2) {
            addCriterion("name2 between", value1, value2, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotBetween(String value1, String value2) {
            addCriterion("name2 not between", value1, value2, "name2");
            return (Criteria) this;
        }

        public Criteria andName3IsNull() {
            addCriterion("name3 is null");
            return (Criteria) this;
        }

        public Criteria andName3IsNotNull() {
            addCriterion("name3 is not null");
            return (Criteria) this;
        }

        public Criteria andName3EqualTo(String value) {
            addCriterion("name3 =", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3NotEqualTo(String value) {
            addCriterion("name3 <>", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3GreaterThan(String value) {
            addCriterion("name3 >", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3GreaterThanOrEqualTo(String value) {
            addCriterion("name3 >=", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3LessThan(String value) {
            addCriterion("name3 <", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3LessThanOrEqualTo(String value) {
            addCriterion("name3 <=", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3Like(String value) {
            addCriterion("name3 like", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3NotLike(String value) {
            addCriterion("name3 not like", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3In(List<String> values) {
            addCriterion("name3 in", values, "name3");
            return (Criteria) this;
        }

        public Criteria andName3NotIn(List<String> values) {
            addCriterion("name3 not in", values, "name3");
            return (Criteria) this;
        }

        public Criteria andName3Between(String value1, String value2) {
            addCriterion("name3 between", value1, value2, "name3");
            return (Criteria) this;
        }

        public Criteria andName3NotBetween(String value1, String value2) {
            addCriterion("name3 not between", value1, value2, "name3");
            return (Criteria) this;
        }

        public Criteria andName4IsNull() {
            addCriterion("name4 is null");
            return (Criteria) this;
        }

        public Criteria andName4IsNotNull() {
            addCriterion("name4 is not null");
            return (Criteria) this;
        }

        public Criteria andName4EqualTo(String value) {
            addCriterion("name4 =", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4NotEqualTo(String value) {
            addCriterion("name4 <>", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4GreaterThan(String value) {
            addCriterion("name4 >", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4GreaterThanOrEqualTo(String value) {
            addCriterion("name4 >=", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4LessThan(String value) {
            addCriterion("name4 <", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4LessThanOrEqualTo(String value) {
            addCriterion("name4 <=", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4Like(String value) {
            addCriterion("name4 like", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4NotLike(String value) {
            addCriterion("name4 not like", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4In(List<String> values) {
            addCriterion("name4 in", values, "name4");
            return (Criteria) this;
        }

        public Criteria andName4NotIn(List<String> values) {
            addCriterion("name4 not in", values, "name4");
            return (Criteria) this;
        }

        public Criteria andName4Between(String value1, String value2) {
            addCriterion("name4 between", value1, value2, "name4");
            return (Criteria) this;
        }

        public Criteria andName4NotBetween(String value1, String value2) {
            addCriterion("name4 not between", value1, value2, "name4");
            return (Criteria) this;
        }

        public Criteria andName5IsNull() {
            addCriterion("name5 is null");
            return (Criteria) this;
        }

        public Criteria andName5IsNotNull() {
            addCriterion("name5 is not null");
            return (Criteria) this;
        }

        public Criteria andName5EqualTo(String value) {
            addCriterion("name5 =", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5NotEqualTo(String value) {
            addCriterion("name5 <>", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5GreaterThan(String value) {
            addCriterion("name5 >", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5GreaterThanOrEqualTo(String value) {
            addCriterion("name5 >=", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5LessThan(String value) {
            addCriterion("name5 <", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5LessThanOrEqualTo(String value) {
            addCriterion("name5 <=", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5Like(String value) {
            addCriterion("name5 like", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5NotLike(String value) {
            addCriterion("name5 not like", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5In(List<String> values) {
            addCriterion("name5 in", values, "name5");
            return (Criteria) this;
        }

        public Criteria andName5NotIn(List<String> values) {
            addCriterion("name5 not in", values, "name5");
            return (Criteria) this;
        }

        public Criteria andName5Between(String value1, String value2) {
            addCriterion("name5 between", value1, value2, "name5");
            return (Criteria) this;
        }

        public Criteria andName5NotBetween(String value1, String value2) {
            addCriterion("name5 not between", value1, value2, "name5");
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