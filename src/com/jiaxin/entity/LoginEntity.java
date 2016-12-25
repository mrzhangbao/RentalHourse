package com.jiaxin.entity;

public class LoginEntity {

	private String phoneNum;
	private String password;

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginEntity(String phoneNum, String password) {
		super();
		this.phoneNum = phoneNum;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginEntity [phoneNum=" + phoneNum + ", password=" + password + "]";
	}
	
	
	

}
