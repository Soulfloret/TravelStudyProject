package com.accp.mapper;

import com.accp.domain.signin;
import com.accp.domain.signinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface signinMapper {
    int countByExample(signinExample example);

    int deleteByExample(signinExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(signin record);

    int insertSelective(signin record);

    List<signin> selectByExample(signinExample example);

    signin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") signin record, @Param("example") signinExample example);

    int updateByExample(@Param("record") signin record, @Param("example") signinExample example);

    int updateByPrimaryKeySelective(signin record);

    int updateByPrimaryKey(signin record);
}