package com.jiaxin.service;

import java.util.List;

import com.jiaxin.dao.UserDao;
import com.jiaxin.dao.impl.UserDaoImpl;
import com.jiaxin.entity.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean isExist(String phoneNum) {
		// TODO Auto-generated method stub
		return this.userDao.isExist(phoneNum);
	}

	@Override
	public String getPasswordByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return this.userDao.getPasswordByPhoneNum(phoneNum);
	}

	@Override
	public String deleUser(String phoneNum) {
		// TODO Auto-generated method stub
		return this.userDao.deleUser(phoneNum);
	}

	@Override
	public User getUserByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return this.userDao.getUserByPhoneNum(phoneNum);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.findAllUser();
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateUser(user);
	}

	@Override
	public boolean updateUserAvatar(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateUserAvatar(user);
	}

}
