package com.accp.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accp.chenyong.service.ModuleService;



@Configuration
public class WebServiceConfig {
	@Autowired
	Bus bus;
	@Autowired
	ModuleService service;
	@Bean
	public ServletRegistrationBean registrationBean() {
		return new ServletRegistrationBean(new CXFServlet(),"/mywebservice/*");
	}
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpointimpl=new EndpointImpl(bus);
	//	endpointimpl.publish("/test",service);
		return endpointimpl;
	}
}
