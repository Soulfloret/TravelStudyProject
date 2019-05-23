package com.accp.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.accp.domain.discussiongroup;
import com.accp.mapper.discussiongroupMapper;
import com.accp.yipeng.config.WebSocketHandleryp;

@Component
public class InitGroup implements ApplicationRunner {

	// 依赖查询所有组
	@Autowired
	discussiongroupMapper disService;
	@Autowired
	WebSocketHandleryp webso;

	public InitGroup() {

		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		List<discussiongroup> list = disService.selectByExample(null);
		if(list.size()>0) {
			webso.initGroup(list);
		}
	}
}
