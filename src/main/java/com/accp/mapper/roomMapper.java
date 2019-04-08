package com.accp.mapper;

import com.accp.domain.room;
import com.accp.domain.roomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface roomMapper {
    int countByExample(roomExample example);

    int deleteByExample(roomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(room record);

    int insertSelective(room record);

    List<room> selectByExample(roomExample example);

    room selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") room record, @Param("example") roomExample example);

    int updateByExample(@Param("record") room record, @Param("example") roomExample example);

    int updateByPrimaryKeySelective(room record);

    int updateByPrimaryKey(room record);
}