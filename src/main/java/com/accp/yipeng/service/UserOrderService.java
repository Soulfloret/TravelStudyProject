package com.accp.yipeng.service;

import java.util.List;

import com.accp.domain.Usermainorder;
import com.accp.domain.userorder;

public interface UserOrderService {
	public List<userorder> selectAllUserOrderById(Integer uid);
	public Usermainorder queryByUserOrderId(Integer id);
}
