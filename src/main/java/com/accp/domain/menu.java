package com.accp.domain;

import java.util.Date;
import java.util.List;

public class menu {
    private Integer id;

    private String mname;

    private String intorduce;

    private Double price;

    private Integer stock;

    private String state;

    private Integer menutypeid;

    private Date putawaytime;

    private Integer likecount;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private List<images> imgs;
    
    private images image;
    
    private String mename;
    
    private menutype mtype;
    
    private List<menucomment> menucommend;
    
    private List<images> mlist;
    
    private List<Object> list;
    
    private recommend recommend;
    
    private Double zdprice;
       
    private Double zgprice;
    
    private int countnum;
    
    
    
    
    public int getCountnum() {
		return countnum;
	}

	public void setCountnum(int countnum) {
		this.countnum = countnum;
	}

	public Double getZdprice() {
		return zdprice;
	}

	public void setZdprice(Double zdprice) {
		this.zdprice = zdprice;
	}

	public Double getZgprice() {
		return zgprice;
	}

	public void setZgprice(Double zgprice) {
		this.zgprice = zgprice;
	}

	public List<menucomment> getMenucommend() {
		return menucommend;
	}

	public void setMenucommend(List<menucomment> menucommend) {
		this.menucommend = menucommend;
	}


	public void setImgs(List<images> imgs) {
		this.imgs=imgs;
	}
	public List<images> getImgs() {
		return imgs;
	}
    
    private String url ;
    
    
    
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public images getImage() {
		return image;
	}

	public void setImage(images image) {
		this.image = image;
	}

	public recommend getRecommend() {
		return recommend;
	}

	public void setRecommend(recommend recommend) {
		this.recommend = recommend;
	}

    

    public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	public List<images> getMlist() {
		return mlist;
	}

	public void setMlist(List<images> mlist) {
		this.mlist = mlist;
	}

	public menutype getMtype() {
		return mtype;
	}

	public void setMtype(menutype mtype) {
		this.mtype = mtype;
	}

	public String getMename() {
		return mename;
	}

	public void setMename(String mename) {
		this.mename = mename;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getIntorduce() {
        return intorduce;
    }

    public void setIntorduce(String intorduce) {
        this.intorduce = intorduce;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getMenutypeid() {
        return menutypeid;
    }

    public void setMenutypeid(Integer menutypeid) {
        this.menutypeid = menutypeid;
    }

    public Date getPutawaytime() {
        return putawaytime;
    }

    public void setPutawaytime(Date putawaytime) {
        this.putawaytime = putawaytime;
    }

    public Integer getLikecount() {
        return likecount;
    }

    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
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