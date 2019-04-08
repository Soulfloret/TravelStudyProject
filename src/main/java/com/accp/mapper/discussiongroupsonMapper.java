package com.accp.mapper;

import com.accp.domain.discussiongroupson;
import com.accp.domain.discussiongroupsonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface discussiongroupsonMapper {
    int countByExample(discussiongroupsonExample example);

    int deleteByExample(discussiongroupsonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(discussiongroupson record);

    int insertSelective(discussiongroupson record);

    List<discussiongroupson> selectByExample(discussiongroupsonExample example);

    discussiongroupson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") discussiongroupson record, @Param("example") discussiongroupsonExample example);

    int updateByExample(@Param("record") discussiongroupson record, @Param("example") discussiongroupsonExample example);

    int updateByPrimaryKeySelective(discussiongroupson record);

    int updateByPrimaryKey(discussiongroupson record);
}