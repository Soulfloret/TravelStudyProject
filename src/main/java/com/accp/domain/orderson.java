package com.accp.domain;

import java.util.List;

public class orderson {
    private Integer id;

    private Integer iid;

    private Integer typeid;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private Object ix;
    
    private Integer tjcount;
    
    private recommend recommend;
    
    

    public recommend getRecommend() {
		return recommend;
	}

	public void setRecommend(recommend recommend) {
		this.recommend = recommend;
	}

	public Integer getTjcount() {
		return tjcount;
	}

	public void setTjcount(Integer tjcount) {
		this.tjcount = tjcount;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
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
}