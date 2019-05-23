package com.accp.chenyong.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.domain.menu;
import com.accp.domain.project;
import com.accp.domain.room;

public interface CountService {
    List<project> querycountproject(@Param("starttime") Date starttime,@Param("endtime") Date endtime);
    
    List<menu> querycountmenu(@Param("starttime") Date starttime,@Param("endtime") Date endtime);
    
    List<room> querycountroom(@Param("starttime")Date starttime,@Param("endtime")Date endtime);

}
