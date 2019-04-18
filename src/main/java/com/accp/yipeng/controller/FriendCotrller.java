package com.accp.yipeng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.discussiongroupson;
import com.accp.domain.friend;
import com.accp.yipeng.service.DiscussiongroupService;
import com.accp.yipeng.service.DiscussiongroupSonService;
import com.accp.yipeng.service.FriendService;
import com.accp.yipeng.service.SendReqService;

@RestController
@RequestMapping("/fri")
public class FriendCotrller {
	@Autowired
	FriendService fservice;
	@Autowired
	SendReqService sendService;
	@Autowired
	DiscussiongroupSonService DisSonService;
	@Autowired
	DiscussiongroupService DisService;
	
	@RequestMapping("queryAllFriend")
	public List<friend> queryAllFriend(Integer id) {
		return fservice.queryAllFriend(id);
	}
	
	@RequestMapping("queryAllreq")
	public List<Object> queryAllreq(Integer id) {
		return sendService.query(id);
	}
	@RequestMapping("addFriend")
	public int addFriend(String status,String id,String did,String uid) {
		int ids=Integer.parseInt(id);
		int num=0;
		if(Integer.parseInt(status)==0) {
			num=sendService.updateStatusById("已拒绝", ids);
		}else {
			sendService.updateStatusById("已同意", ids);
			friend f=new friend();
			f.setUid(Integer.parseInt(uid));
			f.setFid(Integer.parseInt(did));
			num=fservice.insert(f);
		}
		return num;
	}
	@RequestMapping("addGurop")
	public int addGurop(String status,String id,String did,String uid) {
		int ids=Integer.parseInt(id);
		int num=0;
		if(Integer.parseInt(status)==0) {
			num=sendService.updateStatusById("已拒绝", ids);
		}else {
			sendService.updateStatusById("已同意", ids);
			discussiongroupson d=new discussiongroupson();
			d.setDid(Integer.parseInt(did));
			d.setUserid(Integer.parseInt(uid));
			num=DisSonService.insert(d);
		}
		return num;
	}
	
	@RequestMapping("serach")
	public List<Object> Serach(String name) {
		return DisService.query(name);
	}
	
}
