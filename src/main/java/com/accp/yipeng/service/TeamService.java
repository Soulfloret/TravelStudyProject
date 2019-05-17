package com.accp.yipeng.service;

import java.util.List;

import com.accp.domain.staff;
import com.accp.domain.team;
import com.accp.domain.teamExample;
import com.accp.domain.users;

public interface TeamService {
	List<team> selectBymainiUserId(Integer id);

	
	public int insertTeamUsers(Integer cid,Integer Mid,users user,String team,staff staf);
	
    int deleteByPrimaryKey(Integer id);

    int insert(team record);
    
	public  List<team> selectAllTeam(String uname, String tname);

    List<team> selectByExample(teamExample example);

    team selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(team record);

}
