package com.accp.yipeng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.sendrequest;


public interface SendReqService {
	public List<Object> query(Integer uid) ;
	public int updateStatusById(@Param("status")String status,@Param("id") Integer id);
    int insert(sendrequest record);

}
