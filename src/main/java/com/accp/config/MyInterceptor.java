package com.accp.config;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.accp.chenyong.service.ModuleService;
import com.accp.domain.module;
import com.accp.domain.staff;
import com.accp.domain.users;
@Configuration
public class MyInterceptor implements HandlerInterceptor {
	@Autowired
	ModuleService service;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		staff staff=(staff)request.getSession().getAttribute("staff");
		String uri=request.getRequestURI();
		uri=uri.replaceFirst(request.getContextPath()+"/","");
		if(staff==null) {
			response.sendRedirect("/login/login");
		}
		if(request.getSession().getAttribute("urlMap")==null)
		{
			Map<String,module> map=service.queryModuleByUidToMap(staff.getUserid());
			request.getSession().setAttribute("urlMap", map);
		}
		if(uri.indexOf("login")!=-1) {
			return true;
		}
		Object map=request.getSession().getAttribute("urlMap");
		if(map!=null) {
			Map<String,module>maps=(Map<String,module>)request.getSession().getAttribute("urlMap");
				if(maps.get(uri)!=null) {
					return true;
			}
		}
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
