package com.accp.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class project {
    private Integer id;

    private String pname;

    private String description;

    private Date createtime;

    private Date safetime;

    private String pstatus;

    private Integer mincrowd;

    private Integer maxcrowd;

    private Double minheight;

    private Double maxheight;

    private String remark;

    private Double price;

    private Integer tid;

    private String needtime;

    private Integer galleryful;

    private Double cost;

    private Integer leadingoffcial;

    private Double newprice;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private List<areas> areas;
           
    private List<images> ilist;
    
    private images img;
    
    private projectpl pllist;
    
    private List<projectpl> pllistshh;

	public List<areas> getAreas() {
		return areas;
	}

	public void setAreas(List<areas> areas) {
		this.areas = areas;
	}


	public List<projectpl> getPllistshh() {
		return pllistshh;
	}

	public void setPllistshh(List<projectpl> pllistshh) {
		this.pllistshh = pllistshh;
	}

	public projectpl getPllist() {
		return pllist;
	}

	public void setPllist(projectpl pllist) {
		this.pllist = pllist;
	}

	public images getImg() {
		return img;
	}

	public void setImg(images img) {
		this.img = img;
	}

	private staff sta;
    
    private users use;
    
    private projecttype ptype;
    
    private projecttype pt;
    
    private recommend recommend;
    
    
    
    public recommend getRecommend() {
		return recommend;
	}

	public void setRecommend(recommend recommend) {
		this.recommend = recommend;
	}

	public projecttype getPt() {
		return pt;
	}

	public void setPt(projecttype pt) {
		this.pt = pt;
	}

	private List<productarea> palist;
    
	public List<productarea> getPalist() {
		return palist;
	}

	public void setPalist(List<productarea> palist) {
		this.palist = palist;
	}

	public projecttype getPtype() {
		return ptype;
	}

	public void setPtype(projecttype ptype) {
		this.ptype = ptype;
	}

	public users getUse() {
		return use;
	}

	public void setUse(users use) {
		this.use = use;
	}
    
    public staff getSta() {
		return sta;
	}

	public void setSta(staff sta) {
		this.sta = sta;
	}

	public List<images> getIlist() {
		return ilist;
	}

	public void setIlist(List<images> ilist) {
		this.ilist = ilist;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getSafetime() {
        return safetime;
    }

    public void setSafetime(Date safetime) {
        this.safetime = safetime;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public Integer getMincrowd() {
        return mincrowd;
    }

    public void setMincrowd(Integer mincrowd) {
        this.mincrowd = mincrowd;
    }

    public Integer getMaxcrowd() {
        return maxcrowd;
    }

    public void setMaxcrowd(Integer maxcrowd) {
        this.maxcrowd = maxcrowd;
    }

    public Double getMinheight() {
        return minheight;
    }

    public void setMinheight(Double minheight) {
        this.minheight = minheight;
    }

    public Double getMaxheight() {
        return maxheight;
    }

    public void setMaxheight(Double maxheight) {
        this.maxheight = maxheight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getNeedtime() {
        return needtime;
    }

    public void setNeedtime(String needtime) {
        this.needtime = needtime;
    }

    public Integer getGalleryful() {
        return galleryful;
    }

    public void setGalleryful(Integer galleryful) {
        this.galleryful = galleryful;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getLeadingoffcial() {
        return leadingoffcial;
    }

    public void setLeadingoffcial(Integer leadingoffcial) {
        this.leadingoffcial = leadingoffcial;
    }

    public Double getNewprice() {
        return newprice;
    }

    public void setNewprice(Double newprice) {
        this.newprice = newprice;
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