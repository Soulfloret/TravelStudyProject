package com.accp.yipeng.service;

import java.util.List;

import com.accp.domain.Usermainorder;
import com.accp.domain.orderson;

public interface UserMainOrderService1 {
	
	public Usermainorder addUserMainOrder(Usermainorder o) ;
	
	public Usermainorder QueryCunzai(Usermainorder o);
	
	public List<orderson> queryDetails(List<orderson> list);
}
