package com.jiaxin.entity;

import java.util.Date;

/**
 * ����Ա��ʵ���࣬��Ӧ��tb_admin
 * 
 * @author Benson_Tom
 *
 */
public class AdminEntity {
	private Integer id;//����ԱID
	private String account;//����Ա�˺ţ�һ��Ϊ�ֻ�����
	private String password;//����Ա����
	private String username;//�û�����
	private String rank;//����Ա�ȼ�
	private Date addtime;//����ʱ��

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
