package com.accp.domain;

import java.util.List;

public class roomorderson {
    private Integer id;

    private Integer roomorderid;

    private Integer destineid;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private List<roomdestine> list;
    

    public roomorderson(Integer roomorderid, Integer destineid) {
		super();
		this.roomorderid = roomorderid;
		this.destineid = destineid;
	}

	public roomorderson() {
		super();
	}
	public List<roomdestine> getList() {
		return list;
	}

	public void setList(List<roomdestine> list) {
		this.list = list;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomorderid() {
        return roomorderid;
    }

    public void setRoomorderid(Integer roomorderid) {
        this.roomorderid = roomorderid;
    }

    public Integer getDestineid() {
        return destineid;
    }

    public void setDestineid(Integer destineid) {
        this.destineid = destineid;
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