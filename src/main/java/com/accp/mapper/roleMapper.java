package com.accp.mapper;

import com.accp.domain.role;
import com.accp.domain.roleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface roleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(role record);

    int insertSelective(role record);

    List<role> selectByExample(roleExample example);

    role selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(role record);
    
    int updateByPrimaryKeySelective(role record);
}