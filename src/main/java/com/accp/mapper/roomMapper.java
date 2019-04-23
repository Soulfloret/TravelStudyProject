package com.accp.mapper;

import com.accp.domain.recommend;
import com.accp.domain.room;
import com.accp.domain.roomExample;
import com.accp.domain.roomdestine;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface roomMapper {
	
	List<room> queryByroomData(@Param("begintime")Date begintime ,@Param("endtime")Date endtime);
	
	List<room> queryByroom(room r);
	
	List<room> queryByroomtypeid();
	
    int countByExample(roomExample example);

    int deleteByExample(roomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(room record);

    int insertSelective(room record);

    List<room> selectByExample(roomExample example);

    room selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") room record, @Param("example") roomExample example);

    int updateByExample(@Param("record") room record, @Param("example") roomExample example);

    int updateByPrimaryKeySelective(room record);

    int updateByPrimaryKey(room record);
    
    recommend recommendByidroom(@Param("id")Integer id);
    
    List<room> queryRoomAll(room room);
}