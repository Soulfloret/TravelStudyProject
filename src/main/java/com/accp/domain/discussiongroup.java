package com.accp.domain;

import java.util.List;

public class discussiongroup {
    private Integer id;

    private String groupname;

    private Integer groupsize;

    private String groupdescribe;

    public discussiongroup() {
	}

    private message mess;
    
    private List<message> messList;
    
	public List<message> getMessList() {
		return messList;
	}

	public void setMessList(List<message> messList) {
		this.messList = messList;
	}

	public message getMess() {
		return mess;
	}

	public void setMess(message mess) {
		this.mess = mess;
	}

	private Integer groupmainid;

    private String name1;

    private String name2;

    public discussiongroup(String groupname, Integer groupsize, String groupdescribe, Integer groupmainid) {
		super();
		this.groupname = groupname;
		this.groupsize = groupsize;
		this.groupdescribe = groupdescribe;
		this.groupmainid = groupmainid;
	}

	private String name3;

    private String name4;

    private String name5;
    
    //保存讨论组图片
    private List<images> img;
    //讨论组现人数
    private Integer Count;
    //用来保存请求 判断是当前登录用户对讨论组是否已发送请求
    private sendrequest sendreq;
    
	public sendrequest getSendreq() {
		return sendreq;
	}

	public void setSendreq(sendrequest sendreq) {
		this.sendreq = sendreq;
	}

	public Integer getCount() {
		return Count;
	}

	public void setCount(Integer count) {
		Count = count;
	}

	public List<images> getImg() {
		return img;
	}

	public void setImg(List<images> img) {
		this.img = img;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Integer getGroupsize() {
        return groupsize;
    }

    public void setGroupsize(Integer groupsize) {
        this.groupsize = groupsize;
    }

    public String getGroupdescribe() {
        return groupdescribe;
    }

    public void setGroupdescribe(String groupdescribe) {
        this.groupdescribe = groupdescribe;
    }

    public Integer getGroupmainid() {
        return groupmainid;
    }

    public void setGroupmainid(Integer groupmainid) {
        this.groupmainid = groupmainid;
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