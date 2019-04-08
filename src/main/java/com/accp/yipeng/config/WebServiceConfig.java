package com.accp.yipeng.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*import com.accp.webservice.MyWebService;*/

@Configuration
public class WebServiceConfig {
	
	@Autowired
	Bus bus;
	
	/*@Autowired*/
	/*MyWebService webservice;*/
	
	/**
	 * 注册webservice (cxf)，注册地址为：mywebservice
	 * @return
	 */
/*	@Bean
	public ServletRegistrationBean registrationBean() {
		return new ServletRegistrationBean(new CXFServlet(), "/mywebservice/*");
	}*/
	
	
	/*@Bean
	public Endpoint endpoint() {
		EndpointImpl endpointImpl = new EndpointImpl(bus);
		endpointImpl.publish("/test", webservice);
		return endpointImpl;
	}*/
	
	
	

}
