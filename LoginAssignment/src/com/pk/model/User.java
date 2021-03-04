package com.pk.model;

public class User {
	
	private String uid;
	private String name;
	private String password;
	private String address;
	private String h1,h2,h3;
	private String i1,i2,i3;
	
	
	public User() {
		super();
	}
	public User(String uid, String name, String password, String address, String h1, String h2, String h3, String i1,
			String i2, String i3) {
		super();
		this.uid = uid;
		this.name = name;
		this.password = password;
		this.address = address;
		this.h1 = h1;
		this.h2 = h2;
		this.h3 = h3;
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", password=" + password + ", address=" + address + ", h1=" + h1
				+ ", h2=" + h2 + ", h3=" + h3 + ", i1=" + i1 + ", i2=" + i2 + ", i3=" + i3 + "]";
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getH1() {
		return h1;
	}
	public void setH1(String h1) {
		this.h1 = h1;
	}
	public String getH2() {
		return h2;
	}
	public void setH2(String h2) {
		this.h2 = h2;
	}
	public String getH3() {
		return h3;
	}
	public void setH3(String h3) {
		this.h3 = h3;
	}
	public String getI1() {
		return i1;
	}
	public void setI1(String i1) {
		this.i1 = i1;
	}
	public String getI2() {
		return i2;
	}
	public void setI2(String i2) {
		this.i2 = i2;
	}
	public String getI3() {
		return i3;
	}
	public void setI3(String i3) {
		this.i3 = i3;
	}
	
	

}
