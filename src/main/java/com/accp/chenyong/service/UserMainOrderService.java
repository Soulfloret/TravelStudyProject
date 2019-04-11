package com.accp.chenyong.service;

import java.util.List;

import com.accp.domain.Usermainorder;
import com.accp.domain.UsermainorderExample;

public interface UserMainOrderService {
	int countByExample(UsermainorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usermainorder record);

    int insertSelective(Usermainorder record);

    List<Usermainorder> selectByExample(UsermainorderExample example);

    Usermainorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Usermainorder record);
	
}
