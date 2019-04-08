package com.accp.mapper;

import com.accp.domain.projectdiscount;
import com.accp.domain.projectdiscountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface projectdiscountMapper {
    int countByExample(projectdiscountExample example);

    int deleteByExample(projectdiscountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(projectdiscount record);

    int insertSelective(projectdiscount record);

    List<projectdiscount> selectByExample(projectdiscountExample example);

    projectdiscount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") projectdiscount record, @Param("example") projectdiscountExample example);

    int updateByExample(@Param("record") projectdiscount record, @Param("example") projectdiscountExample example);

    int updateByPrimaryKeySelective(projectdiscount record);

    int updateByPrimaryKey(projectdiscount record);
}