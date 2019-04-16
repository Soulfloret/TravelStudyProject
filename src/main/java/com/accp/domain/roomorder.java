package com.accp.domain;

import java.util.List;

public class roomorder {
    private Integer id;

    private String ordernumber;

    private Integer userid;

    private Double price;

    private String state;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private users user;
        
    private List<roomorderson> ros;
    
    

	public users getUser() {
		return user;
	}

	public void setUser(users user) {
		this.user = user;
	}

	public List<roomorderson> getRos() {
		return ros;
	}

	public void setRos(List<roomorderson> ros) {
		this.ros = ros;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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