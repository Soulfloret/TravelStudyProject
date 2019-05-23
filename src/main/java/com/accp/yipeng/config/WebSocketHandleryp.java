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
		if(map.get( use.getId()+"")==null) {
			map.put(use.getId()+"", session);
		}
	}
	public void sendMsg(String message,String  did,String uid) {
			List<WebSocketSession> ws=MAP1.get(did);
			try {
				WebSocketSession webSession= map.get(uid+"");
				for (WebSocketSession wss : ws) {
						if(wss!=webSession) {
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
		 List<WebSocketSession> webList= MAP1.get(groupId);
		 WebSocketSession webSession = map.get(userid);
		 int index=0;
		 for (WebSocketSession webSocketSession : webList) {
			 if(webSocketSession==webSession) {
				index++;
			 }
		}
		
		if(index==0) {
			 MAP1.get(groupId).add(webSession);
		}
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
