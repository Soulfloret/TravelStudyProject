package com.accp.mapper;

import com.accp.domain.Usermainorder;
import com.accp.domain.UsermainorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsermainorderMapper {
	
	Usermainorder queryorderCustomer(@Param("id")Integer id,@Param("lb")String lb,@Param("name1")String name1);
	
    int countByExample(UsermainorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usermainorder record);

    int insertSelective(Usermainorder record);

    List<Usermainorder> selectByExample(UsermainorderExample example);

    Usermainorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Usermainorder record);
    
    List<Usermainorder> query(Usermainorder record);
    
    Usermainorder QueryCunzai(Usermainorder o);
}
