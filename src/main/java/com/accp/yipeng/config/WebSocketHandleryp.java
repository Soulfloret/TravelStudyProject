package com.accp.yipeng.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.accp.domain.discussiongroup;
import com.accp.domain.discussiongroupson;
import com.accp.domain.users;
@Configuration
public class WebSocketHandleryp extends TextWebSocketHandler {
	static Map<String,WebSocketSession> map=new HashMap<String,WebSocketSession>();
	/**
	 * 存储所有握手成功的讨论组
	 */
	static Map<String,List<WebSocketSession>> MAP1=new HashMap<String,List<WebSocketSession>>();
	//建立连接后
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users use=(users)session.getAttributes().get("use");
		/*if(use.getType()!=null && use.getDid()!=null) {
			if(use.getType()==1) {
				MAP1.remove(use.getDid()+"");
			}else {
				int index=0;
				List<WebSocketSession> list1=MAP1.get(use.getDid()+"");
				for (WebSocketSession webSocketSession : list1) {
					Map<String, Object> ss=webSocketSession.getAttributes();
					users uses=(users)ss.get("use");
					if(uses.getId()==use.getId()) {
						index++;
					}
				}
				if(index>0) {
					list1.remove(map.get(use.getId()+""));
				}
			}
		}*/
		if(map.get( use.getId()+"")==null) {
			map.put(use.getId()+"", session);
		}
		/*List<discussiongroup> list =use.getDlist();
		for (discussiongroup discussiongroup : list) {
			for (discussiongroupson discussiongroupson : discussiongroup.getDlist()) {
				if(discussiongroupson.getUserid()==use.getId()) {
					//System.out.println(MAP1.get(discussiongroup.getId()+""));
					if(MAP1.get(discussiongroup.getId()+"")!=null) {
						int index=0;
						List<WebSocketSession> list1=MAP1.get(discussiongroup.getId()+"");
						for (WebSocketSession wss : list1) {
							Map<String, Object> ss=wss.getAttributes();
							users uses=(users)ss.get("use");
							if(uses.getId()==use.getId()) {
								index++;
							}
						}
						if(index==0) {
							list1.add(map.get(use.getId()+""));
						}
						
					}else {
						List<WebSocketSession> list1=new ArrayList<WebSocketSession>();
						list1.add(map.get(use.getId()+""));
						MAP1.put(discussiongroup.getId()+"",list1);
					}
					
				}
			}
		}*/
		session.sendMessage(new TextMessage("建立连接成功，可以进行通信"));
	}
	public void sendMsg(String message,String  did,String uid) {
			List<WebSocketSession> ws=MAP1.get(did);
			try {
				for (WebSocketSession wss : ws) {
					Map<String, Object> ss=wss.getAttributes();
					users use=(users)ss.get("use");
					if(use.getId()!=Integer.parseInt(uid)) {
						wss.sendMessage(new TextMessage(message));
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public    void addGroup(String groupId) {
		List<WebSocketSession> groupSession = new ArrayList<WebSocketSession>();
		MAP1.put(groupId, groupSession);
	}
	
	public   void addGroupItem(String groupId,String userid) {
		WebSocketSession webSession = map.get(userid);
		MAP1.get(groupId).add(webSession);
	}
	
	public   void removeGroupItem(String groupId,String userid) {
		WebSocketSession webSession = map.get(userid);
		MAP1.get(groupId).remove(webSession);
	}
	
	public   void removeGroup(String groupId) {
		MAP1.remove(groupId);
	}
	
	public void initGroup(List<discussiongroup> list) {
		
		for (discussiongroup discussiongroup : list) {
			addGroup(discussiongroup.getId()+"");
		}
	}
	
	
	

}
