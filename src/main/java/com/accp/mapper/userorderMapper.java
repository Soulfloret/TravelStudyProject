package com.accp.mapper;

import com.accp.domain.userorder;
import com.accp.domain.userorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface userorderMapper {
	public List<userorder> selectAllUserOrderById(Integer uid);
	
	userorder selectByuid(Integer id);
	
	List<userorder> selectByuidinlist(Integer id);
	
    int countByExample(userorderExample example);

    int deleteByExample(userorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(userorder record);

    int insertSelective(userorder record);

    List<userorder> selectByExample(userorderExample example);

    userorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") userorder record, @Param("example") userorderExample example);

    int updateByExample(@Param("record") userorder record, @Param("example") userorderExample example);

    int updateByPrimaryKeySelective(userorder record);

    int updateByPrimaryKey(userorder record);
}