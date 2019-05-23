package com.accp.domain;

import java.util.List;
import java.util.Map;

public class areas {
    private Integer id;

    private String aname;

    private String pistion;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;
    
    private Map<String,List<workTime>>worktimes;
    
    

    public Map<String, List<workTime>> getWorktimes() {
		return worktimes;
	}

	public void setWorktimes(Map<String, List<workTime>> worktimes) {
		this.worktimes = worktimes;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPistion() {
        return pistion;
    }

    public void setPistion(String pistion) {
        this.pistion = pistion;
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