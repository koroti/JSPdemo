package com.Entity;

public class USER {
	int id;
	String name;
	int age;
	String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public USER(int id, String name, int age, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.pwd = pwd;
	}
	public USER() {}
}
