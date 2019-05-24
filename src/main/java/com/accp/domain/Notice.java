package com.accp.domain;

import java.util.Date;
import java.util.List;

public class Notice {
    private Integer id;

    private Integer fid;

    private Date time;

    private String content;

    private Integer sid;

    private Integer nwid;

    private Integer pid;

    private Integer gid;

    private String file1;

    private String file2;

    private String file3;

    private String file4;

    private String name1;

    private String name2;

    private String name3;

    private String name4;

    private String name5;

    private String reason;
    
    private users user;

    private staff sta;
    
    private positions pos;
    
    private images images;
    
    private List<images> ilist;
    
    
    
    public List<images> getIlist() {
		return ilist;
	}

	public void setIlist(List<images> ilist) {
		this.ilist = ilist;
	}

	public images getImages() {
		return images;
	}

	public void setImages(images images) {
		this.images = images;
	}

	public positions getPos() {
		return pos;
	}

	public void setPos(positions pos) {
		this.pos = pos;
	}

	public users getUser() {
		return user;
	}

	public void setUser(users user) {
		this.user = user;
	}

	public staff getSta() {
		return sta;
	}

	public void setSta(staff sta) {
		this.sta = sta;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getNwid() {
        return nwid;
    }

    public void setNwid(Integer nwid) {
        this.nwid = nwid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getFile1() {
        return file1;
    }

    public void setFile1(String file1) {
        this.file1 = file1;
    }

    public String getFile2() {
        return file2;
    }

    public void setFile2(String file2) {
        this.file2 = file2;
    }

    public String getFile3() {
        return file3;
    }

    public void setFile3(String file3) {
        this.file3 = file3;
    }

    public String getFile4() {
        return file4;
    }

    public void setFile4(String file4) {
        this.file4 = file4;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}