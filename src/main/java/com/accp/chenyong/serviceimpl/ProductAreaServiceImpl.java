package com.accp.chenyong.serviceimpl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.chenyong.service.ProductAreaService;
import com.accp.domain.orderproductwork;
import com.accp.domain.orderson;
import com.accp.domain.productarea;
import com.accp.domain.project;
import com.accp.domain.workTime;
import com.accp.mapper.orderproductworkMapper;
import com.accp.mapper.productareaMapper;
import com.accp.mapper.projectMapper;
@Service
@Transactional
public class ProductAreaServiceImpl implements ProductAreaService{
	@Autowired
	productareaMapper mapper;
	@Autowired
	projectMapper mapper1;
	@Autowired
	orderproductworkMapper mapper2;
	@Override
	public project queryByArearId(productarea p,Date startTime,Date endTime) {
		 productarea p1=mapper.queryByArearId(p);
		 p1.setP(mapper1.selectByPrimaryKey(p1.getProductid()));
		 Instant fromDate=Instant.now();
		 Instant toDate=Instant.now();
		 if(startTime!=null) {
			 fromDate=startTime.toInstant();
		 }
		 if(endTime!=null) {
			 toDate=endTime.toInstant();
		 }
		 Date d1=new Date(fromDate.toEpochMilli());
		 Date d2=new Date(toDate.toEpochMilli());
		 long daysBetween=(d1.getTime()-d2.getTime()+1000000)/(60*60*24*1000);
		 for(int j=0;j<=daysBetween;j++) {
			 Calendar cal = Calendar.getInstance();   
		     cal.setTime(d1);  
		     cal.add(Calendar.DAY_OF_MONTH, j);
		     cal.set(Calendar.HOUR, 7);
		     cal.set(Calendar.MINUTE, 30);
			 Calendar cal2 = Calendar.getInstance();   
			 cal2.setTime(d1);  
			 cal2.add(Calendar.DAY_OF_MONTH, j);
			 cal2.set(Calendar.HOUR, 11);
			 cal2.set(Calendar.MINUTE, 30);
		     List<workTime> list=new ArrayList<workTime>();
			 for(int i=1;i<=(600/Long.parseLong(p1.getP().getNeedtime()));i++) { 
				 workTime worktime=new workTime();
				 worktime.setStartTime(cal.getTime());
				 cal.add(Calendar.MINUTE,Integer.parseInt(p1.getP().getNeedtime()));
				 worktime.setEndTime(cal.getTime());
				 orderproductwork work=new orderproductwork();
				 work.setStarttime(worktime.getStartTime());
				 work.setEndtime(worktime.getEndTime());
				 worktime.setCount(p1.getP().getGalleryful()-mapper2.queryByTime(work));
				 long time1=cal2.getTimeInMillis()-cal.getTimeInMillis();
				 long minu=time1/(3600*1000);
				 if(minu>0||minu<-2) {
					 list.add(worktime);
				 }
			 }
			 if(p1.getP().getWorktimes()==null) {
				 p1.getP().setWorktimes(new HashMap<String,List<workTime>>());
			 }
		     d1 = cal.getTime();
			 p1.getP().getWorktimes().put(d1.toString()+d2.toString(),list);			
		 }
		 return p1.getP();
	}

}
