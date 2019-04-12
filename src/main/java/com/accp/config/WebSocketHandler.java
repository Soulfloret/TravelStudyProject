package com.accp.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@Configuration
public class WebSocketHandler extends TextWebSocketHandler {
	/**
	 * 存储所有握手成功的用户
	 */
	static Map<String,WebSocketSession> MAP=new HashMap<String,WebSocketSession>();
	//建立连接后
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String uid=session.getAttributes().get("uid")+"";
		MAP.put(uid, session);
		session.sendMessage(new TextMessage("建立连接成功，可以进行通信"));
	}
	public void sendMsg(String message,String[] ids) {
		for (String string : ids) {
			WebSocketSession ws=MAP.get(string);
			try {
				ws.sendMessage(new TextMessage(message));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
