package com.accp.yipeng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Shopcart;

public interface ShopCareServcie {
    int deleteByPrimaryKey(Integer id);

	
    int updateByPrimaryKeySelective(Shopcart record);

    int insertSelective(Shopcart record);

    int insertList(Shopcart shop);
    
    Shopcart QueryIidUserid(@Param("iid")Integer iid,@Param("typeid")Integer typeid,@Param("userid")Integer userid);
    
    int deleteIidUserid(@Param("iid")Integer iid,@Param("typeid")Integer typeid,@Param("userid")Integer userid);
    
    int deleteUserid(@Param("userid")Integer userid);
    
    List<Shopcart> queryAll(@Param("userid")Integer userid);
}
