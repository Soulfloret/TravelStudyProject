package com.accp.mapper;

import com.accp.domain.usertype;
import com.accp.domain.usertypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface usertypeMapper {
    int countByExample(usertypeExample example);

    int deleteByExample(usertypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(usertype record);

    int insertSelective(usertype record);

    List<usertype> selectByExample(usertypeExample example);

    usertype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") usertype record, @Param("example") usertypeExample example);

    int updateByExample(@Param("record") usertype record, @Param("example") usertypeExample example);

    int updateByPrimaryKeySelective(usertype record);

    int updateByPrimaryKey(usertype record);
}