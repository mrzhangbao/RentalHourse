package com.jiaxin.dao;

import java.util.List;

import com.jiaxin.entity.User;

/**
 * 用户管理的Dao接口
 * 
 * @author Benson_Tom
 *
 */
public interface UserDao {
	// 添加用户
	void save(User user);

	boolean isExist(String phoneNum);

	String getPasswordByPhoneNum(String phoneNum);

	String deleUser(String phoneNum);

	User getUserByPhoneNum(String phoneNum);

	List<User> findAllUser();

}
