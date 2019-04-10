package com.accp.mapper;

import com.accp.domain.bind;
import com.accp.domain.bindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface bindMapper {
	
	int insertmenubind(bind bi);
	
	List<bind> querybind(bind bi);
	
    int countByExample(bindExample example);

    int deleteByExample(bindExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(bind record);

    int insertSelective(bind record);

    List<bind> selectByExample(bindExample example);

    bind selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") bind record, @Param("example") bindExample example);

    int updateByExample(@Param("record") bind record, @Param("example") bindExample example);

    int updateByPrimaryKeySelective(bind record);

    int updateByPrimaryKey(bind record);
}