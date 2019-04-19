package com.accp.mapper;

import com.accp.domain.positions;
import com.accp.domain.positionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface positionsMapper {
	
	List<positions> positionsById(Integer id);
	
    int countByExample(positionsExample example);

    int deleteByExample(positionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(positions record);

    int insertSelective(positions record);

    List<positions> selectByExample(positionsExample example);

    positions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") positions record, @Param("example") positionsExample example);

    int updateByExample(@Param("record") positions record, @Param("example") positionsExample example);

    int updateByPrimaryKeySelective(positions record);

    int updateByPrimaryKey(positions record);
}