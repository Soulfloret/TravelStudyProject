package com.accp.mapper;

import com.accp.domain.Usermainorder;
import com.accp.domain.UsermainorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsermainorderMapper {
    int countByExample(UsermainorderExample example);

    int deleteByExample(UsermainorderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usermainorder record);

    int insertSelective(Usermainorder record);

    List<Usermainorder> selectByExample(UsermainorderExample example);

    Usermainorder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usermainorder record, @Param("example") UsermainorderExample example);

    int updateByExample(@Param("record") Usermainorder record, @Param("example") UsermainorderExample example);

    int updateByPrimaryKeySelective(Usermainorder record);

    int updateByPrimaryKey(Usermainorder record);
}