package com.company.ssm.vo;

public class QueryVo {
	private String id;
	private String username;
	private String minSal;
	private String maxSal;
	public QueryVo() {
		// TODO Auto-generated constructor stub
	}
	public QueryVo(String id, String username, String minSal, String maxSal) {
		super();
		this.id = id;
		this.username = username;
		this.minSal = minSal;
		this.maxSal = maxSal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMinSal() {
		return minSal;
	}
	public void setMinSal(String minSal) {
		this.minSal = minSal;
	}
	public String getMaxSal() {
		return maxSal;
	}
	public void setMaxSal(String maxSal) {
		this.maxSal = maxSal;
	}
	@Override
	public String toString() {
		return "QueryVo [id=" + id + ", username=" + username + ", minSal=" + minSal + ", maxSal=" + maxSal + "]";
	}
	
}
