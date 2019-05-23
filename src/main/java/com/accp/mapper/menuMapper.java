package com.accp.mapper;

import com.accp.domain.menu;
import com.accp.domain.menuExample;
import com.accp.domain.project;
import com.accp.domain.recommend;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface menuMapper {
	menu queryByiidAndMenuid(@Param("iid") Integer iid,@Param("iid") Integer typeid);
	
	List<menu> selectmenuByid(Integer id);
	
	List<menu> QueryMenu(menu me);
	
    int countByExample(menuExample example);

    int deleteByExample(menuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(menu record);

    int insertSelective(menu record);

    List<menu> selectByExample(menuExample example);

    menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") menu record, @Param("example") menuExample example);

    int updateByExample(@Param("record") menu record, @Param("example") menuExample example);

    int updateByPrimaryKeySelective(menu record);

    int updateByPrimaryKey(menu record);
    
    recommend recommendByidmenu(@Param("id")Integer id);
    
    List<menu> queryMenuAll(menu menu);
    
    menu querycountmenu(@Param("starttime") Date starttime,@Param("endtime") Date endtime,@Param("id") Integer id);
    
    
}