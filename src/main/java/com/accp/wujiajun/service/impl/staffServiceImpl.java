package com.accp.wujiajun.service.impl;

import java.util.List;

import com.accp.domain.signin;
import com.accp.domain.staff;
import com.accp.domain.staffExample;

public interface staffServiceImpl {
	//鏌ヨ鍛樺伐鍒楄〃
	List<staff> query(staff sta);
	//鏍规嵁鍛樺伐鏌ヨ鍛樺伐璧勬枡
	staff queryById(Integer id);
	//鎸夋潯浠舵煡璇㈠憳宸ュ垪琛�
	List<staff> queryLike(staff sta);
	//鍏堝鍔犵敤鎴� 鍦ㄥ鍔犲憳宸�
	int insert(staff sta);
	//鏌ヨ鍛樺伐钖祫鍒楄〃
	List<staff> salaryQuery(staff sta);
	//鏍规嵁鍛樺伐鏌ヨ鍛樺伐钖祫銆佹墦鍗℃鏁�
	List<staff> salaryQueryId(Integer id);
	//鏍规嵁鍛樺伐鏌ヨ姣忎釜鍛樺伐鎵撳崱鐨勬潯鏁�
	List<signin> signinQuery(Integer id);
	//淇敼鍛樺伐鍦ㄨ亴鐘舵��(0,1)
	int staffupdate(staff sta);
	//鐧诲綍鏃舵洿鐢ㄦ埛id鏌ヨ鏄惁鏄憳宸�
	staff loginByuserid(Integer userid);
	
	List<staff> staffquery(staff sta);
	
}
