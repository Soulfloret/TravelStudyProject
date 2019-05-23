package com.accp.mapper;

import com.accp.domain.discussiongroup;
import com.accp.domain.discussiongroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface discussiongroupMapper {
	public List<discussiongroup> selectByuidAndGroupName(@Param("name") String name,@Param("uid") int uid);
	
	public discussiongroup selectDisBysonUidAndDid(@Param("uid")Integer uid,@Param("did") Integer did);
	
	public int updateDisName(discussiongroup dis);
	
	public List<discussiongroup> selectAllDiscussionGroup(Integer uid);
	
	public List<discussiongroup> selectByname(String name);
	
    int countByExample(discussiongroupExample example);

    int deleteByExample(discussiongroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(discussiongroup record);

    int insertSelective(discussiongroup record);

    List<discussiongroup> selectByExample(discussiongroupExample example);

    discussiongroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") discussiongroup record, @Param("example") discussiongroupExample example);

    int updateByExample(@Param("record") discussiongroup record, @Param("example") discussiongroupExample example);

    int updateByPrimaryKeySelective(discussiongroup record);

    int updateByPrimaryKey(discussiongroup record);
}