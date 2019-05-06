package com.accp.domain;



import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class staff {
	private Integer id;

	private Integer userid;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date entrytime;

	private Date departuretime;

	private Integer departmentid;

	private Integer postionid;

	private Integer state;

	private String name1;

	private String name2;

	private String name3;

	private String name4;

    private String name5;

    private users user;
    
    private userrole ur;
    
    private List<users> ulists;
    
    public List<users> getUlists() {
		return ulists;
	}

	public void setUlists(List<users> ulists) {
		this.ulists = ulists;
	}

    public userrole getUr() {
		return ur;
	}

	public void setUr(userrole ur) {
		this.ur = ur;
	}

	public users getUser() {
		return user;
	}

	public void setUser(users user) {
		this.user = user;
	}

	private users ulist;

	private positions plist;

	private signin slist;

	private salary salist;

	public signin getSlist() {
		return slist;
	}

	public salary getSalist() {
		return salist;
	}

	public void setSalist(salary salist) {
		this.salist = salist;
	}

	public void setSlist(signin slist) {
		this.slist = slist;
	}

	public positions getPlist() {
		return plist;
	}

	public void setPlist(positions plist) {
		this.plist = plist;
	}

	public users getUlist() {
		return ulist;
	}

	public void setUlist(users ulist) {
		this.ulist = ulist;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Date getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}

	public Date getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(Date departuretime) {
		this.departuretime = departuretime;
	}

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getPostionid() {
		return postionid;
	}

	public void setPostionid(Integer postionid) {
		this.postionid = postionid;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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