package com.accp.domain;

import java.util.Date;
import java.util.List;

public class staff {
	private Integer id;

	private Integer userid;

	private Date entrytime;

	private Date departuretime;

	private Integer departmentid;

	private Integer postionid;

	private Integer state;

	private String uname;

	private String name2;

	private String name3;

	private String name4;

	private String name5;

	private users ulist;
	
	private positions plist;
	
	private signin slist;
	
	
	public signin getSlist() {
		return slist;
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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