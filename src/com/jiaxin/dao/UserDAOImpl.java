package com.jiaxin.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jiaxin.entity.User;



public class UserDAOImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
		
		System.out.println("Username::" + user.getNickName());
		System.out.println("Password::" + user.getPassword());
	}



	



	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	


	@Override
	public boolean isExist(String phoneNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPasswordByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleUser(String phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}







	@Override
	public boolean updateUserAvatar(User user) {
		// TODO Auto-generated method stub
		return false;
	}



}
