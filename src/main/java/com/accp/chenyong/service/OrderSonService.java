package com.accp.chenyong.service;

import java.util.Date;
import java.util.List;

import com.accp.domain.orderson;

public interface OrderSonService {
	public List<orderson> query(List<orderson> o,Date startTime,Date endTime);
}
