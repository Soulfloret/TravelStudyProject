package com.accp.mapper;

import com.accp.domain.areas;
import com.accp.domain.areasExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface areasMapper {
    int countByExample(areasExample example);

    int deleteByExample(areasExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(areas record);

    int insertSelective(areas record);

    List<areas> selectByExample(areas example);

    areas selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") areas record, @Param("example") areasExample example);

    int updateByExample(@Param("record") areas record, @Param("example") areasExample example);

    int updateByPrimaryKeySelective(areas record);

    int updateByPrimaryKey(areas record);
}