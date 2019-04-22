package com.accp.mapper;

import com.accp.domain.menucomment;
import com.accp.domain.menucommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface menucommentMapper {
    int countByExample(menucommentExample example);

    int deleteByExample(menucommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(menucomment record);

    int insertSelective(menucomment record);

    List<menucomment> selectByExample(menucommentExample example);

    menucomment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") menucomment record, @Param("example") menucommentExample example);

    int updateByExample(@Param("record") menucomment record, @Param("example") menucommentExample example);

    int updateByPrimaryKeySelective(menucomment record);

    int updateByPrimaryKey(menucomment record);
    
    List<menucomment> AppMenuCommend(@Param("menuid")Integer menuid);
}