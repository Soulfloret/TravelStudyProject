package com.accp.yipeng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.discussiongroupson;

public interface DiscussiongroupSonService {
    int insert(discussiongroupson record);
    public int selectCountBydid(Integer did);
	public List<discussiongroupson> selectAllusersBydid(Integer did);
	public int delByarray(Integer did,Integer[] ids);
	public int insertByarray(Integer did,Integer[] ids);
	public int delByuidAndDid(@Param("did")Integer did,@Param("uid")Integer uid);

}
