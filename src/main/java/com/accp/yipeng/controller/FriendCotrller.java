package com.accp.yipeng.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.domain.discussiongroup;
import com.accp.domain.discussiongroupson;
import com.accp.domain.friend;
import com.accp.domain.images;
import com.accp.domain.sendrequest;
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
			int dids=Integer.parseInt(did);
			discussiongroup dis=DisService.selectByPrimaryKey(dids);
			if(dis.getGroupsize()==DisSonService.selectCountBydid(dids)) {
				sendService.updateStatusById("该讨论组人数已满", ids);
			}else {
				sendService.updateStatusById("已同意", ids);
				discussiongroupson d=new discussiongroupson();
				d.setDid(Integer.parseInt(did));
				d.setUserid(Integer.parseInt(uid));
				num=DisSonService.insert(d);
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
	public void goupload(MultipartFile file0,MultipartFile file1,MultipartFile file2,String groupname,String uid,String groupdescribe, String   ids) {
			String url = "f:/fileupload/";
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
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			discussiongroup dis=new discussiongroup(groupname, 30, groupdescribe, Integer.parseInt(uid));
			DisService.add(dis,ids,list1);
			
	}
	
	@RequestMapping("selectAllDiscussionGroup")
	public List<discussiongroup> selectAllDiscussionGroup(Integer uid) {
		return DisService.selectAllDiscussionGroup(uid);
	}
	@RequestMapping("queryById")
	public discussiongroup queryById(Integer did) {
		return DisService.queryById(did);
	}
	
	
}
