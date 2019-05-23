package com.accp.mapper;

import com.accp.domain.Notice;
import com.accp.domain.NoticeExample;
import com.accp.domain.images;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
	
	int noticeImages(Notice noti);
	
	int noticeInsert(Notice record);
	
	List<Notice> noticeQuery(Integer id);
	
    int countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}