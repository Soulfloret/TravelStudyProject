package com.accp.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.orderproductwork;
import com.accp.domain.orderproductworkExample;
import com.accp.domain.orderwork;

public interface orderproductworkMapper {
    int countByExample(orderproductworkExample example);

    int deleteByExample(orderproductworkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(orderproductwork record);

    int insertSelective(orderproductwork record);

    List<orderproductwork> selectByExample(orderproductworkExample example);

    orderproductwork selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") orderproductwork record, @Param("example") orderproductworkExample example);

    int updateByExample(@Param("record") orderproductwork record, @Param("example") orderproductworkExample example);

    int updateByPrimaryKeySelective(orderproductwork record);

    int updateByPrimaryKey(orderproductwork record);
    
    int project_Order_Insert(orderwork ok);
    
    int queryByTime(orderproductwork work);
    
    List<orderproductwork> queryByTimeiid();
    
    orderproductwork queryByTimeEWM(orderproductwork work);
}