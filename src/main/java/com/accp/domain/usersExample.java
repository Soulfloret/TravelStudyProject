package com.accp.domain;

import java.util.ArrayList;
import java.util.List;

public class usersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public usersExample() {
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

        public Criteria andUnameIsNull() {
            addCriterion("uName is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uName is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uName =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uName <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uName >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uName >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uName <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uName <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uName like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uName not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uName in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uName not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uName between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uName not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUpasswordIsNull() {
            addCriterion("uPassword is null");
            return (Criteria) this;
        }

        public Criteria andUpasswordIsNotNull() {
            addCriterion("uPassword is not null");
            return (Criteria) this;
        }

        public Criteria andUpasswordEqualTo(String value) {
            addCriterion("uPassword =", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotEqualTo(String value) {
            addCriterion("uPassword <>", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordGreaterThan(String value) {
            addCriterion("uPassword >", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("uPassword >=", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLessThan(String value) {
            addCriterion("uPassword <", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLessThanOrEqualTo(String value) {
            addCriterion("uPassword <=", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLike(String value) {
            addCriterion("uPassword like", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotLike(String value) {
            addCriterion("uPassword not like", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordIn(List<String> values) {
            addCriterion("uPassword in", values, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotIn(List<String> values) {
            addCriterion("uPassword not in", values, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordBetween(String value1, String value2) {
            addCriterion("uPassword between", value1, value2, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotBetween(String value1, String value2) {
            addCriterion("uPassword not between", value1, value2, "upassword");
            return (Criteria) this;
        }

        public Criteria andIdcardnoIsNull() {
            addCriterion("idCardNo is null");
            return (Criteria) this;
        }

        public Criteria andIdcardnoIsNotNull() {
            addCriterion("idCardNo is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardnoEqualTo(String value) {
            addCriterion("idCardNo =", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoNotEqualTo(String value) {
            addCriterion("idCardNo <>", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoGreaterThan(String value) {
            addCriterion("idCardNo >", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoGreaterThanOrEqualTo(String value) {
            addCriterion("idCardNo >=", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoLessThan(String value) {
            addCriterion("idCardNo <", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoLessThanOrEqualTo(String value) {
            addCriterion("idCardNo <=", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoLike(String value) {
            addCriterion("idCardNo like", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoNotLike(String value) {
            addCriterion("idCardNo not like", value, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoIn(List<String> values) {
            addCriterion("idCardNo in", values, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoNotIn(List<String> values) {
            addCriterion("idCardNo not in", values, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoBetween(String value1, String value2) {
            addCriterion("idCardNo between", value1, value2, "idcardno");
            return (Criteria) this;
        }

        public Criteria andIdcardnoNotBetween(String value1, String value2) {
            addCriterion("idCardNo not between", value1, value2, "idcardno");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Double value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Double value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Double value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Double value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Double value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Double value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Double> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Double> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Double value1, Double value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Double value1, Double value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Double value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Double value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Double value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Double value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Double value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Double value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Double> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Double> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Double value1, Double value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Double value1, Double value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("TypeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("TypeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Integer value) {
            addCriterion("TypeId =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Integer value) {
            addCriterion("TypeId <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Integer value) {
            addCriterion("TypeId >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TypeId >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Integer value) {
            addCriterion("TypeId <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("TypeId <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Integer> values) {
            addCriterion("TypeId in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Integer> values) {
            addCriterion("TypeId not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Integer value1, Integer value2) {
            addCriterion("TypeId between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("TypeId not between", value1, value2, "typeid");
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