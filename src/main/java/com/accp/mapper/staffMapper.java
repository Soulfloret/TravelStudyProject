package com.accp.mapper;

import com.accp.domain.staff;
import com.accp.domain.staffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface staffMapper {
	
	staff queryById(Integer id);
	
	List<staff> query(staff sta);
	
    int countByExample(staffExample example);

    int deleteByExample(staffExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(staff record);

    int insertSelective(staff record);

    List<staff> selectByExample(staffExample example);

    staff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") staff record, @Param("example") staffExample example);

    int updateByExample(@Param("record") staff record, @Param("example") staffExample example);

    int updateByPrimaryKeySelective(staff record);

    int updateByPrimaryKey(staff record);
}