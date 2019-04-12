package com.accp.yipeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.friend;
import com.accp.yipeng.service.FriendService;

@RestController
@RequestMapping("/fri")
public class FriendCotrller {
	@Autowired
	FriendService fservice;
	
	@RequestMapping("queryAllFriend")
	public List<friend> queryAllFriend(Integer id) {
		return fservice.queryAllFriend(id);
	}
}
