package com.accp.wujiajun.interceptor;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
@Component
public class WebSocketInterceptor implements HandshakeInterceptor{

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
		/*匹配用户(获取HTTP:session中的用户)，将用户存储在session中*/
//		ServletServerHttpRequest servletRequest=(ServletServerHttpRequest)request;
		//从http:request中获取session中的用户对象
	//	User uid=(User)servletRequest.getServletRequest().getSession().getAttribute("user");
		//if(uid!=null) {
			//attributes.put("uid", uid.getUid());
			//return true;
//		}
		return false;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub
		
		
	}

}
