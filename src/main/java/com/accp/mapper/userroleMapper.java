package com.accp.mapper;

import com.accp.domain.userrole;
import com.accp.domain.userroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userroleMapper {
    int countByExample(userroleExample example);

    int deleteByExample(userroleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(userrole record);

    int insertSelective(userrole record);

    List<userrole> selectByExample(userroleExample example);

    userrole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") userrole record, @Param("example") userroleExample example);

    int updateByExample(@Param("record") userrole record, @Param("example") userroleExample example);

    int updateByPrimaryKeySelective(userrole record);

    int updateByPrimaryKey(userrole record);
}