package com.accp.mapper;

import com.accp.domain.sendrequest;
import com.accp.domain.sendrequestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface sendrequestMapper {
	public int updateStatusById(@Param("status")String status,@Param("id") Integer id);
	
	//根据发送类型为好友  并且发送人是自己的     
	public List<sendrequest> selectBydid(@Param("typeid")Integer typeid,@Param("did") Integer did);
	// 类型为好友  接受好友为自己的 
	public List<sendrequest> selectByuid(@Param("typeid")Integer typeid,@Param("uid") Integer uid);
	//  查询讨论组负责人为我的  
	public List<sendrequest> selectDisByuid(@Param("typeid")Integer typeid,@Param("uid") Integer uid);
	
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