package com.accp.domain;

import java.util.Date;
import java.util.List;

public class comments {
    private Integer id;

    private String content;

    private Date sharetime;

    private Integer did;

    private Integer uid;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private users user;
    
    private List<reply> reply;
    
    private Integer dzcount;
    
    
    
    
    public Integer getDzcount() {
		return dzcount;
	}

	public void setDzcount(Integer dzcount) {
		this.dzcount = dzcount;
	}

	public List<reply> getReply() {
		return reply;
	}

	public void setReply(List<reply> reply) {
		this.reply = reply;
	}

	public users getUser() {
		return user;
	}

	public void setUser(users user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSharetime() {
        return sharetime;
    }

    public void setSharetime(Date sharetime) {
        this.sharetime = sharetime;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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