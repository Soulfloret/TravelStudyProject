
package com.accp.config;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class WebMvcConfigruation extends WebMvcConfigurationSupport {

	@Autowired
	MyInterceptor my;

	/**
	 * 闈欐�佽祫婧愯矾寰勯厤缃紝娉ㄦ剰锛氬鏋滀笉閰嶇疆锛屽垯浼�404
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/").addResourceLocations("file:F:\\").addResourceLocations("file:D:\\");

	}

	/**
	 * 瑙ｅ喅鏅�氬瓧绗︿覆閫氳繃ajax瀛楃涓叉秷鎭浆鎹㈠櫒涓枃涔辩爜
	 * 
	 * @return
	 */
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		return new StringHttpMessageConverter(StandardCharsets.UTF_8);
	}
	@Bean
    public TaskScheduler scheduledExecutorService() {
	     ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler(); 
	     scheduler.setPoolSize(8); 
	     scheduler.setThreadNamePrefix("scheduled-thread-"); 
	     return scheduler; 
     }
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}
	/**
	 * 榛樿鐨刯ackson锛屾敼鍙樻垚fastjson
	 * 
	 * @return
	 */
		/*  @Bean public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
		  //鍒涘缓FastJson淇℃伅杞崲瀵硅薄 
			  FastJsonHttpMessageConverter fastJsonHttpMessageConverter= new FastJsonHttpMessageConverter();
		  
		  //鍒涘缓Fastjosn瀵硅薄骞惰瀹氬簭鍒楀寲瑙勫垯
			  FastJsonConfig fastJsonConfig = new FastJsonConfig();
		  fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat); 
		 //涓枃涔辩爜瑙ｅ喅鏂规 
		  List<MediaType> mediaTypes = new ArrayList<>();
		  mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);//璁惧畾json鏍煎紡涓旂紪鐮佷负UTF-8
		  fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
		  //瑙勫垯璧嬩簣杞崲瀵硅薄
		  fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		  return fastJsonHttpMessageConverter;
		  }*/
		 

	/**
	 * 拦截器
	 */
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(my).addPathPatterns("/**")
		.excludePathPatterns("/login/mode")
		.excludePathPatterns("/js/**")
		.excludePathPatterns("/css/**")
		.excludePathPatterns("/assets/**")
		.excludePathPatterns("/css1/**")
		.excludePathPatterns("/font/**")
		.excludePathPatterns("/fonts/**")
		.excludePathPatterns("/images/**")
		.excludePathPatterns("/img/**")
		.excludePathPatterns("/img1/**")
		.excludePathPatterns("/jquery-ui-datepicker/**")
		.excludePathPatterns("/js1/**")
		.excludePathPatterns("/rev-slider/**")
		.excludePathPatterns("/webfonts/**")
		.excludePathPatterns("/fileupload/**")
		.excludePathPatterns("/login/login")
		.excludePathPatterns("/login/loginQuery")
		.excludePathPatterns("/module/queryByUid")
		.excludePathPatterns("/module/hide")
		.excludePathPatterns("/dynamic/**")
		.excludePathPatterns("/orderson/**")
		.excludePathPatterns("/projectshh/**")
		.excludePathPatterns("/shopcartshh/**")
		.excludePathPatterns("/user/**")
		.excludePathPatterns("/usermainordershh/**")
		.excludePathPatterns("/xjb_productController/Queryshouye")
		.excludePathPatterns("/xjb_productController/QueryQtproductByXq")
		.excludePathPatterns("/xjb_projectController/file")
		.excludePathPatterns("/xjb_projectController/query_Qt")
		.excludePathPatterns("/xjb_projectController/queryBy_Qt_Xq")
		.excludePathPatterns("/xjb_projectController/insert_shop")
		.excludePathPatterns("/menu/toquerymenu1")
		.excludePathPatterns("/menu/toquerymenu1Byid")
		.excludePathPatterns("/menu/shopcartadd")
		.excludePathPatterns("/menu/fileadd")
		.excludePathPatterns("/room/toqueryqtroom")
		.excludePathPatterns("/room/toqueryqtroomByid")
		.excludePathPatterns("/room/AjaxQuerydid")
		.excludePathPatterns("/room/queryByroomdestineid")
		.excludePathPatterns("/room/querydingdan")
		.excludePathPatterns("/room/deletedingdan")
		.excludePathPatterns("/room/roomaddorder")
		.excludePathPatterns("/customer/downloadTemple")
		.excludePathPatterns("/customer/toPerson")
		.excludePathPatterns("/customer/topagehome")
		.excludePathPatterns("/customer/toOrders")
		.excludePathPatterns("/customer/toPersonDetails")
		.excludePathPatterns("/customer/updateinfo")
		.excludePathPatterns("/customer/updateUsers")
		.excludePathPatterns("/customer/look")
		.excludePathPatterns("/customer/delshopCart")
		.excludePathPatterns("/customer/addUserMainOrder")
		.excludePathPatterns("/customer/buy")
		.excludePathPatterns("/customer/insertOrder")
		.excludePathPatterns("/fri/**")
		.excludePathPatterns("/Login/**")
		.excludePathPatterns("/team/queryAllteamByuid");
		super.addInterceptors(registry);
	}

	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(stringHttpMessageConverter());
		//converters.add(fastJsonHttpMessageConverter());
		converters.add(mappingJackson2HttpMessageConverter());
		converters.add(new ByteArrayHttpMessageConverter());
		super.configureMessageConverters(converters);
	}

	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
		// TODO Auto-generated method stub
		super.addCorsMappings(registry);
	}

}
