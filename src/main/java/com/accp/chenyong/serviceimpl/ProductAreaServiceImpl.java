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
import com.accp.domain.areas;
import com.accp.domain.orderproductwork;
import com.accp.domain.orderson;
import com.accp.domain.productarea;
import com.accp.domain.project;
import com.accp.domain.worduser;
import com.accp.domain.workTime;
import com.accp.mapper.areasMapper;
import com.accp.mapper.orderproductworkMapper;
import com.accp.mapper.productareaMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.staffMapper;
import com.accp.mapper.worduserMapper;
@Service
@Transactional
public class ProductAreaServiceImpl implements ProductAreaService{
	@Autowired
	productareaMapper mapper;
	@Autowired
	projectMapper mapper1;
	@Autowired
	orderproductworkMapper mapper2;
	@Autowired
	worduserMapper mapper3;
	@Autowired
	staffMapper mapper4;
	@Autowired
	areasMapper mapper5;
	@Override
	public project queryByArearId(project p,Date startTime,Date endTime) {
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
		 List<areas> list2=new ArrayList<areas>();
		 List<productarea> list1=mapper.queryByPid(p.getId());
		 for (productarea productarea : list1) {
			 areas area=mapper5.selectByPrimaryKey(productarea.getAreaid());
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
				 for(int i=1;i<=(600/Long.parseLong(p.getNeedtime()));i++) { 
					 workTime worktime=new workTime();
					 worktime.setStartTime(cal.getTime());
					 cal.add(Calendar.MINUTE,Integer.parseInt(p.getNeedtime()));
					 worktime.setEndTime(cal.getTime());
					 orderproductwork work=new orderproductwork();
					 work.setStarttime(worktime.getStartTime());
					 work.setEndtime(worktime.getEndTime());
					 work.setList(mapper3.queryByTime(worktime.getStartTime(), worktime.getEndTime(),p.getId()));
					 for (worduser worduser : work.getList()) {
						 worduser.setStaff(mapper4.queryById(worduser.getProductstaffid()));
					}
					 worktime.setUlist(work.getList());
					 worktime.setCount(p.getGalleryful()-mapper2.queryByTime(work));
					 long time1=cal2.getTimeInMillis()-cal.getTimeInMillis();
					 long minu=time1/(3600*1000);
					 if(minu>0||minu<-2) {
						 list.add(worktime);
					 }
				 }
				 if(area.getWorktimes()==null) {
					 area.setWorktimes(new HashMap<String,List<workTime>>());
				 }
			     d1 = cal.getTime();
				 area.getWorktimes().put(d1.toString()+d2.toString(),list);	
				 list2.add(area);
			 }
		 }
		 p.setAreas(list2);
		 return p;
	}
}
