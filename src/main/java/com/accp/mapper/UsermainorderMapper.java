package com.accp.mapper;

import com.accp.domain.Usermainorder;
import com.accp.domain.UsermainorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsermainorderMapper {
	//yipeng 根据用户id 查询用户所有订单
	List<Usermainorder> queryByorderCustomerId(Integer id);
	
	Usermainorder queryorderCustomer(@Param("id")Integer id,@Param("lb")String lb);
	
    int countByExample(UsermainorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usermainorder record);

    int insertSelective(Usermainorder record);

    List<Usermainorder> selectByExample(UsermainorderExample example);

    Usermainorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Usermainorder record);
    
    List<Usermainorder> query(@Param("id") Integer id);
    
    Usermainorder QueryCunzai(Usermainorder o);
}
