package com.accp.yipeng.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.discussiongroup;
import com.accp.domain.discussiongroupson;
import com.accp.domain.friend;
import com.accp.domain.images;
import com.accp.domain.sendrequest;
import com.accp.domain.users;
import com.accp.yipeng.config.WebSocketHandleryp;
import com.accp.yipeng.service.DiscussiongroupService;
import com.accp.yipeng.service.DiscussiongroupSonService;
import com.accp.yipeng.service.FriendService;
import com.accp.yipeng.service.SendReqService;
import com.accp.yipeng.service.UsersService;

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
	@Autowired
	WebSocketHandleryp webso;
	@Autowired
	UsersService uservice;
	
	@RequestMapping("queryAllFriend")
	public List<friend> queryAllFriend(Integer id,Integer did) {
		return fservice.queryAllFriend(id,did);
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
	public int addGurop(String status,String id,String did,String uid ,HttpSession session) {
		int ids=Integer.parseInt(id);
		int num=0;
		if(Integer.parseInt(status)==0) {
			num=sendService.updateStatusById("已拒绝", ids);
		}else {
			int dids=Integer.parseInt(did);
			discussiongroup dis=DisService.selectByPrimaryKey(dids);
			if(dis.getGroupsize()==DisSonService.selectCountBydid(dids)) {
				num=sendService.updateStatusById("人数已满", ids);
			}else {
				sendService.updateStatusById("已同意", ids);
				discussiongroupson d=new discussiongroupson();
				d.setDid(Integer.parseInt(did));
				d.setUserid(Integer.parseInt(uid));
				num=DisSonService.insert(d);
				webso.addGroupItem(did, uid);
			}
		}
		return num;
	}
	
	@RequestMapping("serach")
	public List<Object> Serach(String name,Integer Id) {
		return DisService.query(name,Id);
	}
	
	@RequestMapping("sendReq")
	public int sendReq(String uid,String did,String TypeId,String content){
		int uids=Integer.parseInt(uid);
		int typeId=Integer.parseInt(TypeId);
		int dids=Integer.parseInt(did);
		int num=0;
		sendrequest s=new sendrequest(uids, dids, typeId, "等待同意", content);
		num=sendService.insert(s);
		return num;
	} 
	

	@RequestMapping("upload")
	public void goupload(MultipartFile file0,MultipartFile file1,MultipartFile file2,String groupname,String uid,String groupdescribe, String   ids,HttpSession session) {
			String url = "d:/fileupload/";
			List<images> list1=new ArrayList<images>();
			MultipartFile []file= {file0,file1,file2};
			File filePath = new File(url);
			if(!filePath.exists()) {
				filePath.mkdirs();
			}
			try {
				for(MultipartFile f : file) {
					if(f!=null) {
					String uuid = UUID.randomUUID().toString();
					String name = f.getOriginalFilename();
					String suffix = name.substring(name.lastIndexOf("."), name.length());
					File fileImg = new File(url+uuid+suffix);
					f.transferTo(fileImg);
					images im=new images();
					im.setUrl("fileupload/"+fileImg.getName());
					list1.add(im);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			discussiongroup dis=new discussiongroup(groupname, 30, groupdescribe, Integer.parseInt(uid));
			DisService.insertSelective(dis);
			DisService.add(dis,ids,list1);
			webso.addGroup(dis.getId()+"");
	}
	
	@RequestMapping("selectAllDiscussionGroup")
	public List<discussiongroup> selectAllDiscussionGroup(Integer uid) {
		return DisService.selectAllDiscussionGroup(uid);
	}
	@RequestMapping("queryById")
	public discussiongroup queryById(Integer did,Integer uid) {
		discussiongroup dis= DisService.queryById(did);
		webso.addGroupItem(did+"", uid+"");
		return dis;
	}
	
	@RequestMapping("query")
	public discussiongroup query(Integer did) {
		return DisService.query(did);
	}
	 	
	@RequestMapping("updateDisName")
	public int updateDisName(Integer did,String  groupName) {
		discussiongroup d=new discussiongroup();
		d.setId(did);
		d.setGroupname(groupName);
		return DisService.updateDisName(d);
	}
	
	@RequestMapping("queryAllusersBydid")
	public discussiongroup queryAllusersBydid(Integer did) {
		discussiongroup d=DisService.selectByPrimaryKey(did);
		d.setDlist(DisSonService.selectAllusersBydid(did));
		return d;
	}
	
	@RequestMapping("removeUsersBydid")
	public int removeUsersBydid(String did,String  ids) {
		String []idss=ids.split(",");
		Integer [] args=new Integer[idss.length];
		for (int i = 0; i < idss.length; i++) {
			args[i]=Integer.parseInt(idss[i]);
		}
		return DisSonService.delByarray(Integer.parseInt(did), args);
	}
	@RequestMapping("insertDisSonByarray")
	public int insertDisSonByarray(String did,String  ids) {
		String []idss=ids.split(",");
		Integer [] args=new Integer[idss.length];
		for (int i = 0; i < idss.length; i++) {
			args[i]=Integer.parseInt(idss[i]);
		}
		return DisSonService.insertByarray(Integer.parseInt(did), args);
	}

	@RequestMapping("delDis")
	public int delDis(String did,String uid,String typeId ) {
		int typeid=Integer.parseInt(typeId);
		int num=DisService.delDis(Integer.parseInt(did),Integer.parseInt(uid),typeid);
		users use=sessionUser(uid);
		if(typeid==1) {
			use.setType(typeid);
			use.setDid(Integer.parseInt(did));
			webso.removeGroup(did);
		}else {
			use.setType(typeid);
			use.setDid(Integer.parseInt(did));
			webso.removeGroupItem(did, uid);
		}
		 return num;
	}
	 	
	@RequestMapping("sendMsg")
	public int sendMsg(String sendmsg,String  did,String uid){
		webso.sendMsg(sendmsg, did,uid);
		return DisService.SendMessage(Integer.parseInt(uid),Integer.parseInt( did), sendmsg);
	}
	
	public users sessionUser(String uid) {
		users use=uservice.query(Integer.parseInt(uid));
		List<discussiongroup> list= DisService.selectAllDiscussionGroup(use.getId());
		for (discussiongroup discussiongroup : list) {
			discussiongroup.setDlist(DisSonService.selectAllusersBydid(discussiongroup.getId()));
		}
		use.setDlist(list);
		return use;
	}
	@ResponseBody
	@RequestMapping("queryByUid")
	public users queryByUid(Integer uid) {
		return uservice.query(uid);
	}
	
}
