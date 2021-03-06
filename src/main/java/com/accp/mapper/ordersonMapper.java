package com.accp.mapper;

import com.accp.domain.orderson;
import com.accp.domain.ordersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ordersonMapper {
    int countByExample(ordersonExample example);

    int deleteByExample(ordersonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(orderson record);

    int insertSelective(orderson record);

    List<orderson> selectByExample(ordersonExample example);

    orderson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") orderson record, @Param("example") ordersonExample example);

    int updateByExample(@Param("record") orderson record, @Param("example") ordersonExample example);

    int updateByPrimaryKeySelective(orderson record);

    int updateByPrimaryKey(orderson record);
}