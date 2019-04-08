package com.accp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class menuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public menuExample() {
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

        public Criteria andMnameIsNull() {
            addCriterion("mname is null");
            return (Criteria) this;
        }

        public Criteria andMnameIsNotNull() {
            addCriterion("mname is not null");
            return (Criteria) this;
        }

        public Criteria andMnameEqualTo(String value) {
            addCriterion("mname =", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotEqualTo(String value) {
            addCriterion("mname <>", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThan(String value) {
            addCriterion("mname >", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThanOrEqualTo(String value) {
            addCriterion("mname >=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThan(String value) {
            addCriterion("mname <", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThanOrEqualTo(String value) {
            addCriterion("mname <=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLike(String value) {
            addCriterion("mname like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotLike(String value) {
            addCriterion("mname not like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameIn(List<String> values) {
            addCriterion("mname in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotIn(List<String> values) {
            addCriterion("mname not in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameBetween(String value1, String value2) {
            addCriterion("mname between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotBetween(String value1, String value2) {
            addCriterion("mname not between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andIntorduceIsNull() {
            addCriterion("intorduce is null");
            return (Criteria) this;
        }

        public Criteria andIntorduceIsNotNull() {
            addCriterion("intorduce is not null");
            return (Criteria) this;
        }

        public Criteria andIntorduceEqualTo(String value) {
            addCriterion("intorduce =", value, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceNotEqualTo(String value) {
            addCriterion("intorduce <>", value, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceGreaterThan(String value) {
            addCriterion("intorduce >", value, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceGreaterThanOrEqualTo(String value) {
            addCriterion("intorduce >=", value, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceLessThan(String value) {
            addCriterion("intorduce <", value, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceLessThanOrEqualTo(String value) {
            addCriterion("intorduce <=", value, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceLike(String value) {
            addCriterion("intorduce like", value, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceNotLike(String value) {
            addCriterion("intorduce not like", value, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceIn(List<String> values) {
            addCriterion("intorduce in", values, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceNotIn(List<String> values) {
            addCriterion("intorduce not in", values, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceBetween(String value1, String value2) {
            addCriterion("intorduce between", value1, value2, "intorduce");
            return (Criteria) this;
        }

        public Criteria andIntorduceNotBetween(String value1, String value2) {
            addCriterion("intorduce not between", value1, value2, "intorduce");
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

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andMenutypeidIsNull() {
            addCriterion("menutypeId is null");
            return (Criteria) this;
        }

        public Criteria andMenutypeidIsNotNull() {
            addCriterion("menutypeId is not null");
            return (Criteria) this;
        }

        public Criteria andMenutypeidEqualTo(Integer value) {
            addCriterion("menutypeId =", value, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andMenutypeidNotEqualTo(Integer value) {
            addCriterion("menutypeId <>", value, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andMenutypeidGreaterThan(Integer value) {
            addCriterion("menutypeId >", value, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andMenutypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("menutypeId >=", value, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andMenutypeidLessThan(Integer value) {
            addCriterion("menutypeId <", value, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andMenutypeidLessThanOrEqualTo(Integer value) {
            addCriterion("menutypeId <=", value, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andMenutypeidIn(List<Integer> values) {
            addCriterion("menutypeId in", values, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andMenutypeidNotIn(List<Integer> values) {
            addCriterion("menutypeId not in", values, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andMenutypeidBetween(Integer value1, Integer value2) {
            addCriterion("menutypeId between", value1, value2, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andMenutypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("menutypeId not between", value1, value2, "menutypeid");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeIsNull() {
            addCriterion("putawayTime is null");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeIsNotNull() {
            addCriterion("putawayTime is not null");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeEqualTo(Date value) {
            addCriterion("putawayTime =", value, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeNotEqualTo(Date value) {
            addCriterion("putawayTime <>", value, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeGreaterThan(Date value) {
            addCriterion("putawayTime >", value, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("putawayTime >=", value, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeLessThan(Date value) {
            addCriterion("putawayTime <", value, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeLessThanOrEqualTo(Date value) {
            addCriterion("putawayTime <=", value, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeIn(List<Date> values) {
            addCriterion("putawayTime in", values, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeNotIn(List<Date> values) {
            addCriterion("putawayTime not in", values, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeBetween(Date value1, Date value2) {
            addCriterion("putawayTime between", value1, value2, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andPutawaytimeNotBetween(Date value1, Date value2) {
            addCriterion("putawayTime not between", value1, value2, "putawaytime");
            return (Criteria) this;
        }

        public Criteria andLikecountIsNull() {
            addCriterion("likecount is null");
            return (Criteria) this;
        }

        public Criteria andLikecountIsNotNull() {
            addCriterion("likecount is not null");
            return (Criteria) this;
        }

        public Criteria andLikecountEqualTo(Integer value) {
            addCriterion("likecount =", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountNotEqualTo(Integer value) {
            addCriterion("likecount <>", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountGreaterThan(Integer value) {
            addCriterion("likecount >", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("likecount >=", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountLessThan(Integer value) {
            addCriterion("likecount <", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountLessThanOrEqualTo(Integer value) {
            addCriterion("likecount <=", value, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountIn(List<Integer> values) {
            addCriterion("likecount in", values, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountNotIn(List<Integer> values) {
            addCriterion("likecount not in", values, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountBetween(Integer value1, Integer value2) {
            addCriterion("likecount between", value1, value2, "likecount");
            return (Criteria) this;
        }

        public Criteria andLikecountNotBetween(Integer value1, Integer value2) {
            addCriterion("likecount not between", value1, value2, "likecount");
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