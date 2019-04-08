package com.accp.mapper;

import com.accp.domain.ordershop;
import com.accp.domain.ordershopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ordershopMapper {
    int countByExample(ordershopExample example);

    int deleteByExample(ordershopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ordershop record);

    int insertSelective(ordershop record);

    List<ordershop> selectByExample(ordershopExample example);

    ordershop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ordershop record, @Param("example") ordershopExample example);

    int updateByExample(@Param("record") ordershop record, @Param("example") ordershopExample example);

    int updateByPrimaryKeySelective(ordershop record);

    int updateByPrimaryKey(ordershop record);
}