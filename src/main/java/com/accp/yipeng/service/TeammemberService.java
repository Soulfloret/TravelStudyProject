package com.accp.yipeng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.teammember;
import com.accp.domain.teammemberExample;

public interface TeammemberService {
	public int insertBylist( Integer teamId,List<Integer> list);
	
	int deleteByPrimaryKey(Integer id);

	int insert(teammember record);

	List<teammember> selectByExample(teammemberExample example);

	teammember selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(teammember record);

}
