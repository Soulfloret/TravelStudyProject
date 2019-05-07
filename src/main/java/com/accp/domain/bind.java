package com.accp.domain;

import java.util.Date;
import java.util.List;

public class bind {
    private Integer id;

    private String mname;

    private Double price;

    private Integer stock;

    private String state;

    private Date createtime;

    private Integer likecount;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private images image;
    
    private List<menu> list;
    
    private List<menubind> blist;
    
    private List<images> mlist;
    
    private Double zdprice;
    
    private Double zgprice;

    private  recommend recommend;
    
    private List<images> img;
    
    
    public List<images> getImg() {
		return img;
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

	public List<images> getMlist() {
		return mlist;
	}
	
	public void setMlist(List<images> mlist) {
		this.mlist = mlist;
	}

	public void setImg(List<images> img) {
		this.img = img;
	}

	public recommend getRecommend() {
		return recommend;
	}

	public void setRecommend(recommend recommend) {
		this.recommend = recommend;
	}

	public List<menubind> getBlist() {
		return blist;
	}

	public void setBlist(List<menubind> blist) {
		this.blist = blist;
	}

	public List<menu> getList() {
		return list;
	}

	public void setList(List<menu> list) {
		this.list = list;
	}

	public images getImage() {
		return image;
	}

	public void setImage(images image) {
		this.image = image;
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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