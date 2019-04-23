package com.accp.yipeng.service;

import java.util.List;


import com.accp.domain.team;
import com.accp.domain.teamExample;

public interface TeamService {

    int deleteByPrimaryKey(Integer id);

    int insert(team record);
    
	public  List<team> selectAllTeam(String uname, String tname);

    List<team> selectByExample(teamExample example);

    team selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(team record);

}
