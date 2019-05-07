package com.accp.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class workTime {
	@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	
	private Integer  count;
	
	private List<users> ulist;

	public List<users> getUlist() {
		return ulist;
	}

	public void setUlist(List<users> ulist) {
		this.ulist = ulist;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
	
}
