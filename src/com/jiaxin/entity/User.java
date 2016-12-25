package com.jiaxin.entity;

import java.sql.Timestamp;

public class User {
	private Integer id;
	private String phoneNum;
	private String email;
	private String password;
	private String nickName;
	private String realName;
	private String company;
	private String role;
	private String avatar;
	private Timestamp lastSign;
	private String creditNum;
	private String collection;
	private String creditScore;
	private Timestamp createTime;
	public User() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Timestamp getLastSign() {
		return lastSign;
	}
	public void setLastSign(Timestamp lastSign) {
		this.lastSign = lastSign;
	}
	public String getCreditNum() {
		return creditNum;
	}
	public void setCreditNum(String creditNum) {
		this.creditNum = creditNum;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public String getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", phoneNum=" + phoneNum + ", email=" + email + ", password=" + password
				+ ", nickName=" + nickName + ", realName=" + realName + ", company=" + company + ", role=" + role
				+ ", avatar=" + avatar + ", lastSign=" + lastSign + ", creditNum=" + creditNum + ", collection="
				+ collection + ", creditScore=" + creditScore + ", createTime=" + createTime + "]";
	}
	
	
	

}
