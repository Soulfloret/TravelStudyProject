package com.accp.mapper;

import com.accp.domain.bind;
import com.accp.domain.dynamics;
import com.accp.domain.images;
import com.accp.domain.imagesExample;
import com.accp.domain.menu;
import com.accp.domain.project;
import com.accp.domain.room;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface imagesMapper {
	
	int deleteByiid(Integer id);
	
	int insertmenuimglist(menu m);
	
	int insertroomimglist(room r);
	
	int insertbingimglist(bind b);
	
    int countByExample(imagesExample example);

    int deleteByExample(imagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(images record);

    int insertSelective(images record);

    List<images> selectByExample(imagesExample example);

    images selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") images record, @Param("example") imagesExample example);

    int updateByExample(@Param("record") images record, @Param("example") imagesExample example);

    int updateByPrimaryKeySelective(images record);

    int updateByPrimaryKey(images record);
    
    int insert_project(project pro);

	List<images> queryimg(@Param("iid")Integer iid,@Param("typeid")Integer typeid);
	
	int insertimglist(dynamics dinameics);

}