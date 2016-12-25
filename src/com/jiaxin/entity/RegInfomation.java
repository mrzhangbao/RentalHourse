package com.jiaxin.entity;

public class RegInfomation {
	
	private String phoneNum;
	private String password;
	private String code;
	
	
	
	public RegInfomation() {
		super();
	}

	public RegInfomation(String phoneNum, String password, String code) {
		super();
		this.phoneNum = phoneNum;
		this.password = password;
		this.code = code;
	}
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "RegInfomation [phoneNum=" + phoneNum + ", password=" + password + ", code=" + code + "]";
	}
	
	

}
