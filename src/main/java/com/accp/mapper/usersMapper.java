package com.accp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.userorder;
import com.accp.domain.users;
import com.accp.domain.usersExample;

public interface usersMapper {
	public List<users> selectByUname(@Param("name") String uname,@Param("id")Integer id);
	
	int updateById(@Param("id") Integer id, @Param("uname") String uname,@Param("phone") String phone,@Param("upassword") String upassword);
	
	int accountsUpdate(@Param("id") Integer id, @Param("name2") String name2);
	
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
    
    List<users> queryByMainOrderId(@Param("id")Integer id,@Param("uid")Integer uid);

    users queryByName(@Param("uname")String uname,@Param("upassword")String upassword);
    
    users project_queryByName(String name);
    
    users queryProjectOrderByUserId(Integer id);
    
    List<users> queryIcarno(@Param("idCardNo") String idCardNo);
    
    List<users> selectByteamsUser(Integer id);
}