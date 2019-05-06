package com.accp.mapper;

import com.accp.domain.rolemodule;
import com.accp.domain.rolemoduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface rolemoduleMapper {
    int countByExample(rolemoduleExample example);

    int deleteByExample(rolemoduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(rolemodule record);

    int insertSelective(rolemodule record);

    List<rolemodule> selectByExample(rolemoduleExample example);

    rolemodule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") rolemodule record, @Param("example") rolemoduleExample example);

    int updateByExample(@Param("record") rolemodule record, @Param("example") rolemoduleExample example);

    int updateByPrimaryKeySelective(rolemodule record);

    int updateByPrimaryKey(rolemodule record);
    
    int delByRoleId(int id);
}