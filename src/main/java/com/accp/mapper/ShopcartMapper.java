package com.accp.mapper;

import com.accp.domain.Shopcart;
import com.accp.domain.ShopcartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopcartMapper {
    int countByExample(ShopcartExample example);

    int deleteByExample(ShopcartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shopcart record);

    int insertSelective(Shopcart record);

    List<Shopcart> selectByExample(ShopcartExample example);

    Shopcart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shopcart record, @Param("example") ShopcartExample example);

    int updateByExample(@Param("record") Shopcart record, @Param("example") ShopcartExample example);

    int updateByPrimaryKeySelective(Shopcart record);

    int updateByPrimaryKey(Shopcart record);
    
    int insertList(Shopcart shop);
    
    Shopcart QueryIidUserid(@Param("iid")Integer iid,@Param("typeid")Integer typeid,@Param("userid")Integer userid);
    
    int deleteIidUserid(@Param("iid")Integer iid,@Param("typeid")Integer typeid,@Param("userid")Integer userid);
    
    int deleteUserid(@Param("userid")Integer userid);
    
    List<Shopcart> queryAll(@Param("userid")Integer userid);
}