package com.accp.mapper;

import com.accp.domain.teammember;
import com.accp.domain.teammemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface teammemberMapper {
	Integer queryByteamId(Integer tid);
	
	List<teammember> queryBytid(Integer tid);
	
	public int insertBylist(@Param("teamId") Integer teamId,@Param("list") List<Integer> list);
    int countByExample(teammemberExample example);

    int deleteByExample(teammemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(teammember record);

    int insertSelective(teammember record);

    List<teammember> selectByExample(teammemberExample example);

    teammember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") teammember record, @Param("example") teammemberExample example);

    int updateByExample(@Param("record") teammember record, @Param("example") teammemberExample example);

    int updateByPrimaryKeySelective(teammember record);

    int updateByPrimaryKey(teammember record);
}