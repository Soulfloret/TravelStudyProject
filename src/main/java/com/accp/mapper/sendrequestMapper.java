package com.accp.mapper;

import com.accp.domain.sendrequest;
import com.accp.domain.sendrequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface sendrequestMapper {
    int countByExample(sendrequestExample example);

    int deleteByExample(sendrequestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(sendrequest record);

    int insertSelective(sendrequest record);

    List<sendrequest> selectByExample(sendrequestExample example);

    sendrequest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") sendrequest record, @Param("example") sendrequestExample example);

    int updateByExample(@Param("record") sendrequest record, @Param("example") sendrequestExample example);

    int updateByPrimaryKeySelective(sendrequest record);

    int updateByPrimaryKey(sendrequest record);
}