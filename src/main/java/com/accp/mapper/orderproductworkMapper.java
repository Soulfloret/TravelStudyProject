package com.accp.mapper;

import com.accp.domain.orderproductwork;
import com.accp.domain.orderproductworkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}