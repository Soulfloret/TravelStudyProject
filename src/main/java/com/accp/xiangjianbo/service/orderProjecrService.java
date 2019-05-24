package com.accp.xiangjianbo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Order_workAndOrderSon;
import com.accp.domain.orderproductwork;
import com.accp.domain.orderson;
import com.accp.domain.orderwork;
import com.accp.domain.worduser;
import com.accp.mapper.orderproductworkMapper;
import com.accp.mapper.ordersonMapper;
import com.accp.mapper.orderworkMapper;
import com.accp.mapper.worduserMapper;
import com.alibaba.fastjson.JSON;

@Service
@Transactional
public class orderProjecrService {

	@Autowired
	ordersonMapper osmapper;
	
	@Autowired
	orderproductworkMapper opkmapper;
	
	@Autowired
	worduserMapper wumapper;
	
	@Autowired
	orderworkMapper okmapper;
	
	/*新增订单*/
	public int insert_Order(Order_workAndOrderSon order_work) {
		for(int k=0;k<order_work.getOrder_son().size();k++) {
			order_work.getOrder_son().get(k).setName1(18+"");
			order_work.getOrder_son().get(k).setName2(1+"");
			osmapper.insert_project(order_work.getOrder_son().get(k));
		}
		int i=0;
		for (orderwork ow : order_work.getOrder_work()) {
			ow.setOrderid(order_work.getOrder_son().get(i++).getId());
			okmapper.insert(ow);
			for (orderproductwork opk : ow.getList()) {
				opk.setOrderworkid(ow.getId());
				opkmapper.insert(opk);
				for (worduser wd : opk.getList()) {
					wd.setWorkid(opk.getId());
					wumapper.insert(wd);
				}
			}
		}
		return 0;
	}
	
	
	
	
}
