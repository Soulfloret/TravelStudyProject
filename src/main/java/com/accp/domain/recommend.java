package com.accp.domain;

import java.util.List;

public class recommend
 {

	private Integer id;
	
	private Integer tid;
	
	private String name;
	
	private Double price;
	
	private String pname;
	
	private List<images> img;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public recommend() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<images> getImg() {
		return img;
	}

	public void setImg(List<images> img) {
		this.img = img;
	}
	
	
	
	
}
