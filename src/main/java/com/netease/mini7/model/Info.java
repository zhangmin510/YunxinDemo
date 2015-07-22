package com.netease.mini7.model;

/**
 * 
 * @ClassName: Info 
 * @Description: 云信API返回值的实体类
 * @author chenzhongzheng
 *
 */
public class Info {
	private String token;
	private String accid;
	private String name;
	
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Info(String token, String accid, String name) {
		super();
		this.token = token;
		this.accid = accid;
		this.name = name;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Info [token=" + token + ", accid=" + accid + ", name=" + name
				+ "]";
	}
	
	
}
