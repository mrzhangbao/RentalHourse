package com.jiaxin.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.google.gson.Gson;
import com.jiaxin.dao.UserTempDao;
import com.jiaxin.entity.User;
import com.jiaxin.entity.UserTemp;
import com.jiaxin.utils.GsonUtils;

public class UserTempDaoImpl implements UserTempDao {

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

	/**
	 * 保存临时用户数据
	 */
	@Override
	public String saveTempUser(UserTemp u) {
		// TODO Auto-generated method stub
		System.out.println("位置：" + "saveTempUser" + "   ====   操作:" + "保存临时用户" + u.toString());
		this.getHibernateTemplate().save(u);

		return "yes";
	}

	/**
	 * 根据手机号码获取验证码
	 */
	@Override
	public String getCodeByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
	    List<UserTemp> user = queryByPhoneNum(phoneNum);
		if (!user.isEmpty()) {
			String code = null;
			
			for (UserTemp u : user) {
				code = u.getCode();
			}
			return code;
		}
		return null;

	}

	/**
	 * 根据手机号码删除临时数据
	 */
	@Override
	public String deleTempUser(String phoneNum) {
		// TODO Auto-generated method stub
		List<UserTemp> user = queryByPhoneNum(phoneNum);
		if (!user.isEmpty()) {	
			for (UserTemp u : user) {
				getHibernateTemplate().delete(u);
			}
			return "成功";
		}
		return null;
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
	 * @param phoneNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<UserTemp> queryByPhoneNum(String phoneNum){
		String shql = "from UserTemp u where u.phoneNum like ?";

		return (List<UserTemp>) this.getHibernateTemplate().find(shql, phoneNum);
	}

}
