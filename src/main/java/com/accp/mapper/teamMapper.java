package com.accp.mapper;

import com.accp.domain.team;
import com.accp.domain.teamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface teamMapper {
	public  List<team> selectAllTeam(@Param("uname") String uname,@Param("tname") String tname);
	
    int countByExample(teamExample example);

    int deleteByExample(teamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(team record);

    int insertSelective(team record);

    List<team> selectByExample(teamExample example);

    team selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") team record, @Param("example") teamExample example);

    int updateByExample(@Param("record") team record, @Param("example") teamExample example);

    int updateByPrimaryKeySelective(team record);

    int updateByPrimaryKey(team record);
}