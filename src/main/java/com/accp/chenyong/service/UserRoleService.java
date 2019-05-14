package com.accp.chenyong.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.userorder;
import com.accp.domain.userorderExample;
import com.accp.domain.userrole;
import com.accp.domain.userroleExample;

public interface UserRoleService {

	    int deleteByPrimaryKey(Integer id);

	    int insert(userrole record);

	    int insertSelective(userrole record);

	    List<userrole> selectByExample(userroleExample example);

	    userrole selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(userrole record);

	    int updateByPrimaryKey(userrole record);
	    
	    userrole queryByUserId(Integer userid);
	    

}
