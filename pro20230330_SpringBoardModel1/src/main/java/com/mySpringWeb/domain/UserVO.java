package com.mySpringWeb.domain;

public class UserVO {
	private String uid;
	private String passwd;
	private String name;
	private String role;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String toString()
	{
		return "uid:"+uid+"passwd:"+passwd+"name:"+name+"role:"+role;
	}
	
}
