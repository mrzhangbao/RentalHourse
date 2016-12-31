package com.jiaxin.service;

import java.util.List;

import com.jiaxin.entity.User;

public interface UserService {
	//ÃÌº””√ªß
	void save(User user);

	boolean isExist(String phoneNum);

	String getPasswordByPhoneNum(String phoneNum);

	String deleUser(String phoneNum);

	User getUserByPhoneNum(String phoneNum);

	List<User> findAllUser();
	
	boolean updateUser(User user);
	
	boolean updateUserAvatar(User user);

}
