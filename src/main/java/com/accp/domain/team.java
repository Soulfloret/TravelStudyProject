package com.accp.domain;

public class team {
    private Integer id;

    private Integer mainiuserid;

    public team( Integer mainiuserid,String name1) {
    	this.name1=name1;
		this.mainiuserid = mainiuserid;
	}
    private users use;
    
    
    public users getUse() {
		return use;
	}

	public void setUse(users use) {
		this.use = use;
	}
	//团队名称
	private String name1;

    public team() {
		
	}

	private String name2;

    private String name3;

    private String name4;

    private String name5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainiuserid() {
        return mainiuserid;
    }

    public void setMainiuserid(Integer mainiuserid) {
        this.mainiuserid = mainiuserid;
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