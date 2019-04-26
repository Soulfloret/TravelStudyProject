package com.accp.mapper;

import com.accp.domain.Order_workAndOrderSon;
import com.accp.domain.orderson;
import com.accp.domain.ordersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ordersonMapper {
	
	List<orderson> querytj(orderson o);
	
    int countByExample(ordersonExample example);

    int deleteByExample(ordersonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(orderson list);

    int insertSelective(orderson record);

    List<orderson> selectByExample(ordersonExample example);

    orderson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") orderson record, @Param("example") ordersonExample example);

    int updateByExample(@Param("record") orderson record, @Param("example") ordersonExample example);

    int updateByPrimaryKeySelective(orderson record);

    int updateByPrimaryKey(orderson record);
    
    List<orderson> recommdstatic(@Param("typeid")Integer typeid);
    
    List<orderson> recommdstaticmenu(@Param("typeid")Integer typeid);
    
    /*新增订单项目排班*/
    int insert_project(orderson record);
}