package com.accp.domain;

import java.util.List;

public class productproject {
    private Integer id;

    private Integer productid;

    private Integer projectid;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private project pro;
    
    private List<project> projects;
    
    
    public List<project> getProjects() {
		return projects;
	}

	public void setProjects(List<project> projects) {
		this.projects = projects;
	}
    
    public project getPro() {
		return pro;
	}

	public void setPro(project pro) {
		this.pro = pro;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
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