package com.jiaxin.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jiaxin.dao.UserDao;
import com.jiaxin.entity.AdminEntity;
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

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		User u =  (User) this.getHibernateTemplate().get(User.class,user.getId());
		u.setEmail(user.getEmail());
		u.setNickName(user.getNickName());
		u.setRealName(user.getRealName());
		u.setCreditNum(user.getCreditNum());
		u.setCompany(user.getCompany());
		u.setRole(user.getRole());
		u.setAvatar(user.getAvatar());
		u.setCreditScore(user.getCreditScore());
		this.getHibernateTemplate().update(u);
		
		return false;
	}

	@Override
	public boolean updateUserAvatar(User user) {
		// TODO Auto-generated method stub
		User u =  (User) this.getHibernateTemplate().get(User.class,user.getId());
		u.setAvatar(user.getAvatar());
		this.getHibernateTemplate().update(u);
		return false;
	}

}
