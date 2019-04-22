package com.accp.mapper;

import com.accp.domain.message;
import com.accp.domain.messageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface messageMapper {
	List<message> queryMessageBydid(Integer did);
	int selectCountBydid(Integer did);
	message queryLastMessageBydid(Integer did);
	
    int countByExample(messageExample example);

    int deleteByExample(messageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(message record);

    int insertSelective(message record);

    List<message> selectByExample(messageExample example);

    message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") message record, @Param("example") messageExample example);

    int updateByExample(@Param("record") message record, @Param("example") messageExample example);

    int updateByPrimaryKeySelective(message record);

    int updateByPrimaryKey(message record);
}