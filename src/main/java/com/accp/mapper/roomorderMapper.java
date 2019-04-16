package com.accp.mapper;

import com.accp.domain.roomorder;
import com.accp.domain.roomorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface roomorderMapper {
    int countByExample(roomorderExample example);

    int deleteByExample(roomorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(roomorder record);

    int insertSelective(roomorder record);

    List<roomorder> selectByExample(roomorderExample example);

    roomorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") roomorder record, @Param("example") roomorderExample example);

    int updateByExample(@Param("record") roomorder record, @Param("example") roomorderExample example);

    int updateByPrimaryKeySelective(roomorder record);

    int updateByPrimaryKey(roomorder record);
    
    List<roomorder> query(Integer id);
}