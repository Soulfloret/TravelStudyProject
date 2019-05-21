package com.accp.chenyong.serviceimpl;

import java.text.SimpleDateFormat;
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date d1=startTime;
		 Date d2=endTime;
		 d2.setHours(d1.getHours());
		 d2.setMinutes(d1.getMinutes());
		 d2.setSeconds(d1.getSeconds());
		 long daysBetween=(d2.getTime()-d1.getTime()+1000000)/(60*60*24*1000);
		 List<areas> list2=new ArrayList<areas>();
		 List<productarea> list1=mapper.queryByPid(p.getId());
		 for (productarea productarea : list1) {
			 Date d3=d1;
			 areas area=mapper5.selectByPrimaryKey(productarea.getAreaid());
			 for(int j=0;j<=daysBetween;j++) {
				 Calendar cal = Calendar.getInstance();   
			     cal.setTime(d3);  
			     cal.add(Calendar.DAY_OF_MONTH, j);
			     cal.set(Calendar.HOUR_OF_DAY, 7);
			     cal.set(Calendar.MINUTE, 30);
			     cal.set(Calendar.SECOND, 0);
				 Calendar cal2 = Calendar.getInstance();   
				 cal2.setTime(d3); 
				 cal2.add(Calendar.DAY_OF_MONTH, j);
				 cal2.set(Calendar.HOUR_OF_DAY, 11);
				 cal2.set(Calendar.MINUTE, 30);
				 cal2.set(Calendar.SECOND, 0);
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
				 area.getWorktimes().put(sdf.format(cal.getTime()).toString()+d2.toString(),list);	
			 }
			 list2.add(area);
		 }
		 p.setAreas(list2);
		 return p;
	}
}
