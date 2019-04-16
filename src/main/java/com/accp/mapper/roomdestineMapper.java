package com.accp.mapper;

import com.accp.domain.roomdestine;
import com.accp.domain.roomdestineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface roomdestineMapper {
	
	
    int countByExample(roomdestineExample example);

    int deleteByExample(roomdestineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(roomdestine record);

    int insertSelective(roomdestine record);

    List<roomdestine> selectByExample(roomdestineExample example);

    roomdestine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") roomdestine record, @Param("example") roomdestineExample example);

    int updateByExample(@Param("record") roomdestine record, @Param("example") roomdestineExample example);

    int updateByPrimaryKeySelective(roomdestine record);

    int updateByPrimaryKey(roomdestine record);
}