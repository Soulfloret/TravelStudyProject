package com.accp.mapper;

import com.accp.domain.staff;
import com.accp.domain.staffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface staffMapper {
	
	List<staff> staffquery(staff sta);
	
	staff accountsQuery(Integer id);
	
	staff loginByuserid(Integer userid);
	
	int staffupdate(staff sta);
	
	List<staff> salaryQueryIds(Integer id);
	
	List<staff> salaryQueryId(Integer id);
	
	List<staff> salaryQuery(staff sta);
	
	List<staff> queryLike(staff sta);
	
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
    
    List<staff> projectOrder_queryUser(Integer id);
    
    /*新增项目查询负责人*/
    List<staff> ByProjectName();
}