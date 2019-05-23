package com.accp.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.accp.domain.orderproductwork;
import com.accp.mapper.orderproductworkMapper;

@Component
public class Scheduler {
		@Autowired
		orderproductworkMapper mapper;
		private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    //每隔半个小时执行
	    @Scheduled(fixedRate = 1800000)
	    public void testTasks1() throws Exception {
	      List<orderproductwork> s=mapper.queryByTimeiid();
	      for (orderproductwork orderproductwork : s) {
		      String text ="iid:"+orderproductwork.getIid()+"starttime:"+orderproductwork.getStarttime()+"endtime:"+orderproductwork.getEndtime();	
		      QRCodeUtil.encode(text, "", "C:\\Users\\LENOVO\\Desktop\\erweima", true);
	      }
	    }
}
