package com.example.entity;

public class User {
	private String name;
	private String num;
	private String pwd;
	
	
	public User() {
		super();
	}
	public User(String name, String num, String pwd) {
		super();
		this.name = name;
		this.num = num;
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", num=" + num + ", pwd=" + pwd + "]";
	}

}
