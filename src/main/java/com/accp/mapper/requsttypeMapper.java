package com.accp.mapper;

import com.accp.domain.requsttype;
import com.accp.domain.requsttypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface requsttypeMapper {
    int countByExample(requsttypeExample example);

    int deleteByExample(requsttypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(requsttype record);

    int insertSelective(requsttype record);

    List<requsttype> selectByExample(requsttypeExample example);

    requsttype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") requsttype record, @Param("example") requsttypeExample example);

    int updateByExample(@Param("record") requsttype record, @Param("example") requsttypeExample example);

    int updateByPrimaryKeySelective(requsttype record);

    int updateByPrimaryKey(requsttype record);
}