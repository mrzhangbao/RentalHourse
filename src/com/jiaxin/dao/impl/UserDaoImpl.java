package com.jiaxin.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jiaxin.dao.UserDao;
import com.jiaxin.entity.User;
import com.jiaxin.entity.UserTemp;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		if (hibernateTemplate == null) {
			hibernateTemplate = new HibernateTemplate(sessionFactory);
		}
		return hibernateTemplate;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);

	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		String queryString = "from User";
		@SuppressWarnings("unchecked")
		List<User> list = this.getHibernateTemplate().find(queryString);
		return list;
	}

	@Override
	public boolean isExist(String phoneNum) {
		// TODO Auto-generated method stub
		if (!queryByPhoneNum(phoneNum).isEmpty()) {
			return true;
		}
		return false;

	}

	/**
	 * 抽取出来的方法，用来根据手机号码去查询用户
	 * 
	 * @param phoneNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<User> queryByPhoneNum(String phoneNum) {
		String shql = "from User u where u.phoneNum like ?";

		return (List<User>) this.getHibernateTemplate().find(shql, phoneNum);
	}

	@Override
	public String getPasswordByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		List<User> u = queryByPhoneNum(phoneNum);
		if (!u.isEmpty()) {
			String password = null;
			for (User user : u) {
				password = user.getPassword();
			}
			
			return password;
			
		}
		return null;
	}

	@Override
	public String deleUser(String phoneNum) {
		// TODO Auto-generated method stub
		List<User> u = queryByPhoneNum(phoneNum);
		if (!u.isEmpty()) {
			for (User user : u) {
				getHibernateTemplate().delete(user);
			}
			return "成功";
		}
		return null;
	}

	@Override
	public User getUserByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		List<User> u = queryByPhoneNum(phoneNum);
		if (!u.isEmpty()) {
			for (User user : u) {
				return user;
			}
		}
		return null;
	}

}
