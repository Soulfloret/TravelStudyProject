package com.accp.yipeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.friend;
import com.accp.yipeng.service.FriendService;
import com.accp.yipeng.service.SendReqService;

@RestController
@RequestMapping("/fri")
public class FriendCotrller {
	@Autowired
	FriendService fservice;
	@Autowired
	SendReqService sendService;
	@RequestMapping("queryAllFriend")
	public List<friend> queryAllFriend(Integer id) {
		return fservice.queryAllFriend(id);
	}
	
	@RequestMapping("queryAllreq")
	public List<Object> queryAllreq(Integer id) {
		return sendService.query(id);
	}
}
