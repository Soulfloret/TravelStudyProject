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

	/**
	 * 存储所有握手成功的讨论组
	 */
	static Map<String,List<WebSocketSession>> MAP1=new HashMap<String,List<WebSocketSession>>();
	//建立连接后
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users use=(users)session.getAttributes().get("use");
		List<discussiongroup> list =use.getDlist();
		for (discussiongroup discussiongroup : list) {
			for (discussiongroupson discussiongroupson : discussiongroup.getDlist()) {
				if(discussiongroupson.getUserid()==use.getId()) {
					if(MAP1.get(discussiongroup.getId().toString())!=null) {
						List<WebSocketSession> list1=MAP1.get(discussiongroup.getId()+"");
						list1.add(session);
					}else {
						List<WebSocketSession> list1=new ArrayList<WebSocketSession>();
						list1.add(session);
						MAP1.put(discussiongroup.getId()+"",list1);
					}
					
				}
			}
		}
		session.sendMessage(new TextMessage("建立连接成功，可以进行通信"));
	}
	public void sendMsg(String message,String  did) {
			List<WebSocketSession> ws=MAP1.get(did);
			try {
				for (WebSocketSession wss : ws) {
					wss.sendMessage(new TextMessage(message));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
