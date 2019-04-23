package com.accp.domain;

import java.util.List;

public class users {
    private Integer id;

    private String uname;

    private String upassword;

    public users() {
		super();
	}
    private dynamics dynamic;

    
	public dynamics getDynamic() {
		return dynamic;
	}

	public void setDynamic(dynamics dynamic) {
		this.dynamic = dynamic;
	}

	public users(String uname, String idcardno, String phone, String address, Double height, Double width,
			Integer typeid, String name1,String upassword1) {
		super();
		this.uname = uname;
		this.idcardno = idcardno;
		this.phone = phone;
		this.address = address;
		this.height = height;
		this.width = width;
		this.typeid = typeid;
		this.name1 = name1;
		this.upassword=upassword1;
	}

	public sendrequest getSendreq() {
		return sendreq;
	}

	public void setSendreq(sendrequest sendreq) {
		this.sendreq = sendreq;
	}
	
	private discussiongroup dis;
	
	
	public discussiongroup getDis() {
		return dis;
	}

	public void setDis(discussiongroup dis) {
		this.dis = dis;
	}
	//用来保存请求 判断是当前登录用户对用户是否已发送请求
	private sendrequest sendreq;
	
	private String idcardno;

    private String phone;

	private String address;

    private Double height;

    private Double width;

    private Integer typeid;
    
    //閻€劍鍩涚猾璇茬�风�电钖� 
    private usertype usetype;
    
    //閹冨焼閸掞拷  
    private String name1;

    //婢舵潙鍎�
    private String name2;

    private String name3;

    private String name4;

    private String name5;

    //楠烇拷
	private Integer year;
	//閺堬拷
	private Integer month;
	//閺冿拷
	private Integer day;
	//楠炴挳绶�
	private Integer age;
    //鐠愶箑褰�
    private String name6;
    
    private List<userorder> orders;
    
    private staff sta;
    
    

	public String getName6() {
		return name6;
	}

	public void setName6(String name6) {
		this.name6 = name6;
	}

	public staff getSta() {
		return sta;
	}

	public void setSta(staff sta) {
		this.sta = sta;
	}

	public List<userorder> getOrders() {
		return orders;
	}

	public void setOrders(List<userorder> orders) {
		this.orders = orders;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
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
    public usertype getUsetype() {
		return usetype;
	}

	public void setUsetype(usertype usetype) {
		this.usetype = usetype;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}