package com.accp.domain;

import java.util.List;

public class Meal {
    private Integer id;

    private String name;

    private Double price;

    private Integer status;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private List<Mealix> list;
    
    private List<project> plist;

	private List<room> rlist;
	
	private List<bind> blist;
	
	private List<menu> mlist;

	public List<menu> getMlist() {
		return mlist;
	}

	public void setMlist(List<menu> mlist) {
		this.mlist = mlist;
	}

	public List<bind> getBlist() {
		return blist;
	}

	public void setBlist(List<bind> blist) {
		this.blist = blist;
	}

	public List<project> getPlist() {
		return plist;
	}

	public void setPlist(List<project> plist) {
		this.plist = plist;
	}

	public List<room> getRlist() {
		return rlist;
	}

	public void setRlist(List<room> rlist) {
		this.rlist = rlist;
	}

    

    public List<Mealix> getList() {
		return list;
	}

	public void setList(List<Mealix> list) {
		this.list = list;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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