package com.accp.domain;

import java.util.List;

public class room {
    private Integer id;

    private String rname;

    private String location;

    private String introduce;

    private Integer typeid;

    private Double price;

    private String state;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private List<images> imgs;
    
    private recommend recommend;
    
    private images img;
    
    

    public images getImg() {
		return img;
	}

	public void setImg(images img) {
		this.img = img;
	}
    
    
    
    public recommend getRecommend() {
		return recommend;
	}

	public void setRecommend(recommend recommend) {
		this.recommend = recommend;
	}


    public List<images> getImgs() {
		return imgs;
	}

	public void setImgs(List<images> imgs) {
		this.imgs = imgs;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
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