package com.accp.sunhuihui.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.chenyong.service.UserMainOrderService;
import com.accp.domain.comments;
import com.accp.domain.dynamics;
import com.accp.domain.dynamicstopf;
import com.accp.domain.images;
import com.accp.domain.reply;
import com.accp.domain.stopfcomment;
import com.accp.sunhuihui.service.DynamicService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@Controller
@RestController
@RequestMapping("/dynamic")
public class DynamicController {
		
		@Autowired
		DynamicService service;
		
		@RequestMapping("query")
		public PageInfo<dynamics> query(Integer uid){
			PageInfo<dynamics> page=service.query(1, 3,6,uid);
			String json=JSON.toJSONString(page);
			
			return page;
		}
		
		@RequestMapping("queryByid")
		public dynamics queryByid(Integer id,Integer uidd) {
			dynamics d=service.queryByid(id,uidd);
			return d;
		}
		
		@RequestMapping("commentadd")
		public int commentadd(comments comm) {
			comm.setSharetime(new Date());
			int i=service.commentadd(comm);
			return i;
		}
		
		@RequestMapping("replyadd")
		public int replyadd(reply reply) {
			reply.setSharetime(new Date());
			int i=service.replyadd(reply);
			return i;
		}
		
		@RequestMapping("stopfcommentadd")
		public int stopfcommentadd(stopfcomment stop) {
			int i=service.stopfcommentadd(stop);
			return i;
		}
		
		@RequestMapping("dynamicstopfadd")
		public int dynamicstopfadd(dynamicstopf dy) {
			int i=service.dynamicstopfadd(dy);
			return i;
		}
		
		@RequestMapping("upload")
		public void goupload(MultipartFile file0,MultipartFile file1,MultipartFile file2,MultipartFile file3,String content,String uid) {
				String url = "f:/fileupload/";
				List<images> list1=new ArrayList<images>();
				MultipartFile []file= {file0,file1,file2,file3};
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
				dynamics is=new dynamics();
				is.setUid(Integer.parseInt(uid));
				is.setContent(content);
				is.setSharetime(new Date());
				if(list1.size()==0) {
					int i=service.insertimglist1(is);
				}else {
				is.setImg(list1);
				int i=service.insertimglist(is);
				//System.out.println(i);
				}
		}
		
		
		@RequestMapping("insertimglist")
		public int insertimglist(@RequestBody dynamics dinameics) {
			int i=service.insertimglist(dinameics);
			return 0;
		}
}
