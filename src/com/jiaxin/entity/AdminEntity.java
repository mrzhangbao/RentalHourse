package com.jiaxin.entity;

import java.util.Date;

/**
 * 管理员的实体类，对应表tb_admin
 * 
 * @author Benson_Tom
 *
 */
public class AdminEntity {
	private Integer id;//管理员ID
	private String account;//管理员账号，一般为手机号码
	private String password;//管理员密码
	private String username;//用户名称
	private String rank;//管理员等级
	private Date addtime;//加入时间

	public AdminEntity() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	@Override
	public String toString() {
		return "AdminEntity [id=" + id + ", account=" + account + ", password=" + password + ", username=" + username
				+ ", rank=" + rank + ", addtime=" + addtime + "]";
	}


}
