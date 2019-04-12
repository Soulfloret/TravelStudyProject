package com.accp.mapper;

import com.accp.domain.friend;
import com.accp.domain.friendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface friendMapper {
	public List<friend> queryAllFriend(Integer id);
	
    int countByExample(friendExample example);

    int deleteByExample(friendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(friend record);

    int insertSelective(friend record);

    List<friend> selectByExample(friendExample example);

    friend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") friend record, @Param("example") friendExample example);

    int updateByExample(@Param("record") friend record, @Param("example") friendExample example);

    int updateByPrimaryKeySelective(friend record);

    int updateByPrimaryKey(friend record);
}