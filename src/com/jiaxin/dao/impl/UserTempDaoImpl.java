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
	 * ������ʱ�û�����
	 */
	@Override
	public String saveTempUser(UserTemp u) {
		// TODO Auto-generated method stub
		System.out.println("λ�ã�" + "saveTempUser" + "   ====   ����:" + "������ʱ�û�" + u.toString());
		this.getHibernateTemplate().save(u);

		return "yes";
	}

	/**
	 * �����ֻ������ȡ��֤��
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
	 * �����ֻ�����ɾ����ʱ����
	 */
	@Override
	public String deleTempUser(String phoneNum) {
		// TODO Auto-generated method stub
		List<UserTemp> user = queryByPhoneNum(phoneNum);
		if (!user.isEmpty()) {	
			for (UserTemp u : user) {
				getHibernateTemplate().delete(u);
			}
			return "�ɹ�";
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
	 * ��ȡ�����ķ��������������ֻ�����ȥ��ѯ�û�
	 * @param phoneNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<UserTemp> queryByPhoneNum(String phoneNum){
		String shql = "from UserTemp u where u.phoneNum like ?";

		return (List<UserTemp>) this.getHibernateTemplate().find(shql, phoneNum);
	}

}
