package com.accp.yipeng.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Shopcart;
import com.accp.domain.bind;
import com.accp.domain.menu;
import com.accp.domain.product;
import com.accp.domain.productproject;
import com.accp.domain.project;
import com.accp.domain.room;
import com.accp.mapper.MealMapper;
import com.accp.mapper.ShopcartMapper;
import com.accp.mapper.bindMapper;
import com.accp.mapper.imagesMapper;
import com.accp.mapper.menuMapper;
import com.accp.mapper.productMapper;
import com.accp.mapper.productprojectMapper;
import com.accp.mapper.projectMapper;
import com.accp.mapper.roomMapper;
import com.accp.yipeng.service.ShopCareServcie;

@Transactional
@Service
public class ShopCareServcieImpl implements ShopCareServcie{
	@Autowired
	ShopcartMapper mapper;
	@Autowired
	projectMapper mapper1;
	@Autowired
	imagesMapper mapper2;
	@Autowired
	menuMapper mapper3;
	@Autowired
	roomMapper mapper4;
	@Autowired
	bindMapper mapper5;
	@Autowired
	productMapper mapper6;
	@Autowired
	MealMapper mapper7;
	@Autowired
	productprojectMapper mapper8;
	
	@Override
	public int updateByPrimaryKeySelective(Shopcart record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int insertSelective(Shopcart record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public int insertList(Shopcart shop) {
		// TODO Auto-generated method stub
		return mapper.insertList(shop);
	}

	@Override
	public Shopcart QueryIidUserid(Integer iid, Integer typeid, Integer userid) {
		// TODO Auto-generated method stub
		return mapper.QueryIidUserid(iid, typeid, userid);
	}

	@Override
	public int deleteIidUserid(Integer iid, Integer typeid, Integer userid) {
		// TODO Auto-generated method stub
		return mapper.deleteIidUserid(iid, typeid, userid);
	}

	@Override
	public int deleteUserid(Integer userid) {
		// TODO Auto-generated method stub
		return mapper.deleteUserid(userid);
	}

	@Override
	public List<Shopcart> queryAll(Integer userid) {
		List<Shopcart> list=mapper.queryAll(userid);
		for (Shopcart shopcart : list) {
			if(shopcart.getTypeid()==1) {
				project pro= mapper1.selectByPrimaryKey(shopcart.getIid());
				pro.setIlist(mapper2.queryimg(shopcart.getIid(), shopcart.getTypeid()));
				shopcart.setIx(pro);
			}else if(shopcart.getTypeid()==2) {
				menu me= mapper3.selectByPrimaryKey(shopcart.getId());
				me.setImgs(mapper2.queryimg(shopcart.getIid(), shopcart.getTypeid()));
				shopcart.setIx(me);
			}else if(shopcart.getTypeid()==3) {
				room rom=mapper4.selectByPrimaryKey(shopcart.getIid());
				rom.setImgs(mapper2.queryimg(shopcart.getIid(), shopcart.getTypeid()));
				shopcart.setIx(rom);
			}else if(shopcart.getTypeid()==4) {
				bind bid= mapper5.selectByPrimaryKey(shopcart.getIid());
				bid.setImg(mapper2.queryimg(shopcart.getIid(), shopcart.getTypeid()));
				shopcart.setIx(bid);
			}else if(shopcart.getTypeid()==5) {
				product pro=mapper6.selectByPrimaryKey(shopcart.getIid());
				List<productproject> list1= mapper8.queryByProdId(pro.getId());
				double sum=0;
				for (productproject pje : list1) {
					project p= mapper1.selectByPrimaryKey(pje.getProjectid());
					 sum+=p.getPrice();
				}
				pro.setPrice(sum);
			 	shopcart.setIx(pro);
			}else if(shopcart.getTypeid()==7) {
				shopcart.setIx(mapper7.selectByPrimaryKey(shopcart.getIid()));
			}
			
		}
		return list;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}
	
}
