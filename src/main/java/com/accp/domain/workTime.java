package com.accp.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class workTime {
	@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	
	private Integer  count;

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
