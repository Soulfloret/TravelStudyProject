package com.accp.mapper;

import com.accp.domain.roomorderson;
import com.accp.domain.roomordersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface roomordersonMapper {
    int countByExample(roomordersonExample example);

    int deleteByExample(roomordersonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(roomorderson record);

    int insertSelective(roomorderson record);

    List<roomorderson> selectByExample(roomordersonExample example);

    roomorderson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") roomorderson record, @Param("example") roomordersonExample example);

    int updateByExample(@Param("record") roomorderson record, @Param("example") roomordersonExample example);

    int updateByPrimaryKeySelective(roomorderson record);

    int updateByPrimaryKey(roomorderson record);
}