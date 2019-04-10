package com.accp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.users;
import com.accp.domain.usersExample;

public interface usersMapper {
	
	public int updateTypeIdById(@Param("id") Integer id, @Param("typeId") Integer typeId);
	
	public users queryByIdCard(String idCardNo);
	
	public List<users> selectAllUsers(@Param("uname") String uname, @Param("typeId") Integer typeId);
	
    int countByExample(usersExample example);

    int deleteByExample(usersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(users record);

    int insertSelective(users record);

    List<users> selectByExample(usersExample example);

    users selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") users record, @Param("example") usersExample example);

    int updateByExample(@Param("record") users record, @Param("example") usersExample example);

    int updateByPrimaryKeySelective(users record);

    int updateByPrimaryKey(users record);
    
    users query(@Param("id")Integer id);
    
    users queryByName(@Param("uname")String uname,@Param("upassword")String upassword);
    
}