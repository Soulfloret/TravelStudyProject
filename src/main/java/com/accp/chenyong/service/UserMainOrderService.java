package com.accp.chenyong.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.Usermainorder;
import com.accp.domain.UsermainorderExample;
import com.accp.domain.orderwork;

public interface UserMainOrderService {
	int countByExample(UsermainorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usermainorder record);

    int insertSelective(Usermainorder record);

    List<Usermainorder> selectByExample(UsermainorderExample example);

    Usermainorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Usermainorder record);
    
    List<Usermainorder> query(Usermainorder record);
    
    Usermainorder QueryCunzai(Usermainorder o);
    
	public Usermainorder QueryCunzaiInsert(Usermainorder o);

}
