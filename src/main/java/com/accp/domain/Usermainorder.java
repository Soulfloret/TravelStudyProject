package com.accp.domain;

import java.util.Date;
import java.util.List;

public class Usermainorder {
    private Integer id;

    private String orderno;

    private Date ordertime;

    private Integer orderuser;

    private Integer ordercustomer;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private users user;
    
    private staff staff;
        
    private List<users> list;
    
    private Double price;
    
    

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<users> getList() {
		return list;
	}

	public void setList(List<users> list) {
		this.list = list;
	}

	public users getUser() {
		return user;
	}

	public void setUser(users user) {
		this.user = user;
	}

	public staff getStaff() {
		return staff;
	}

	public void setStaff(staff staff) {
		this.staff = staff;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getOrderuser() {
        return orderuser;
    }

    public void setOrderuser(Integer orderuser) {
        this.orderuser = orderuser;
    }

    public Integer getOrdercustomer() {
        return ordercustomer;
    }

    public void setOrdercustomer(Integer ordercustomer) {
        this.ordercustomer = ordercustomer;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }
}