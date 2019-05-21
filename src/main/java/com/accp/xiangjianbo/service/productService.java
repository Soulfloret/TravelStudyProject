package com.accp.xiangjianbo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.product;
import com.accp.mapper.productMapper;
import com.accp.mapper.productprojectMapper;

@Service
@Transactional
public class productService {

	@Autowired
	productMapper prod;
	
	@Autowired
	productprojectMapper prop;
	
	//新增活动
	public int insert(product product) {
		int i=prod.insert(product);
		prop.insert_product(product);
		return 0;
	}
	
	//查询所有
	public List<product> queryAll(){
		return prod.queryAll();
	}
	
	/*后台查询活动详情*/
	public product queryByXqById(Integer id) {
		return prod.queryByXqById(id);
	}
	
	/*前台查询活动推荐*/
	public List<product> QueryQtproductByXq(){
		List<product> list  = prod.QueryQtproductByXq();
    	return list;
    }
	
}
