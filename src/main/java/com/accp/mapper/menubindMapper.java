package com.accp.mapper;

import com.accp.domain.menubind;
import com.accp.domain.menubindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface menubindMapper {
	
	int deleteBybindid(Integer id);
	
    int countByExample(menubindExample example);

    int deleteByExample(menubindExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(menubind record);

    int insertSelective(menubind record);

    List<menubind> selectByExample(menubindExample example);

    menubind selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") menubind record, @Param("example") menubindExample example);

    int updateByExample(@Param("record") menubind record, @Param("example") menubindExample example);

    int updateByPrimaryKeySelective(menubind record);

    int updateByPrimaryKey(menubind record);
}