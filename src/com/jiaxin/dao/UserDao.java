package com.jiaxin.dao;

import java.util.List;

import com.jiaxin.entity.User;

/**
 * �û������Dao�ӿ�
 * 
 * @author Benson_Tom
 *
 */
public interface UserDao {
	// ����û�
	void save(User user);

	boolean isExist(String phoneNum);

	String getPasswordByPhoneNum(String phoneNum);

	String deleUser(String phoneNum);

	User getUserByPhoneNum(String phoneNum);

	List<User> findAllUser();

}
