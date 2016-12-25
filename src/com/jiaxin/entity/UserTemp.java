package com.jiaxin.entity;


/**
 * 用户的临时表，存储验证码等临时信息
 * @author Benson_Tom
 *
 */
public class UserTemp {
	private Integer id;
	private String phoneNum;
	private String code;
	private String time;
	
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "UserTemp [id=" + id + ", phoneNum=" + phoneNum + ", code=" + code + ", time=" + time + "]";
	}
	
	
	


}
