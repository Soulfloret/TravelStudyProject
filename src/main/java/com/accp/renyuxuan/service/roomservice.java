package com.accp.renyuxuan.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.room;
import com.accp.domain.roomdestine;

public interface roomservice {
	
	room queryByroomdestineid(roomdestine r);
	
	room queryByroomid(Integer id);

	
	List<room> queryByroomtypeid();
	
	List<room> queryByroomData(room ro);
	
	List<room> queryByroom(room r);
	
	int insertSelective(room record);
	
	int updateByPrimaryKeySelective(room record);

}
