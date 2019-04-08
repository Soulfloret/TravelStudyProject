package com.accp.mapper;

import com.accp.domain.salary;
import com.accp.domain.salaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface salaryMapper {
    int countByExample(salaryExample example);

    int deleteByExample(salaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(salary record);

    int insertSelective(salary record);

    List<salary> selectByExample(salaryExample example);

    salary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") salary record, @Param("example") salaryExample example);

    int updateByExample(@Param("record") salary record, @Param("example") salaryExample example);

    int updateByPrimaryKeySelective(salary record);

    int updateByPrimaryKey(salary record);
}