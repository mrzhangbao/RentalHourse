package com.jiaxin.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jiaxin.dao.AdminDao;
import com.jiaxin.entity.AdminEntity;
import com.jiaxin.utils.PageHibernateCallback;

public class AdminDaoImpl implements AdminDao {

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
	public void save(AdminEntity admin) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(admin);

	}

	@Override
	public List<AdminEntity> findAllAdmin() {
		// TODO Auto-generated method stub
		String queryString = "from AdminEntity";
		@SuppressWarnings("unchecked")
		List<AdminEntity> list = this.getHibernateTemplate().find(queryString);
		return list;
	}

	@Override
	public boolean isExist(String account) {
		// TODO Auto-generated method stub
		if (!queryAdminByAccount(account).isEmpty()) {
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
	private List<AdminEntity> queryAdminByAccount(String account) {
		String shql = "from AdminEntity a where a.account like ?";

		return (List<AdminEntity>) this.getHibernateTemplate().find(shql, account);
	}

	@Override
	public String getPasswordByAccount(String account) {
		// TODO Auto-generated method stub
		List<AdminEntity> a = queryAdminByAccount(account);
		if (!a.isEmpty()) {
			String password = null;
			for (AdminEntity admin : a) {
				password = admin.getPassword();
			}
			
			return password;
		}
		return null;
	}

	@Override
	public AdminEntity getAdminByAccount(String phoneNum) {
		// TODO Auto-generated method stub
		List<AdminEntity> a = queryAdminByAccount(phoneNum);
		if (!a.isEmpty()) {
			for (AdminEntity admin : a) {
				return admin;
			}
		}
		return null;
	}
	/**
	 * 获取数据库中总的条数
	 */
	@Override
	public int findTotalCount() {
		String hql="select count(*) from AdminEntity";
        @SuppressWarnings("unchecked")
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
        if(list!=null&&list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
	}

	@Override
	public List<AdminEntity> findByPageId(int begin,int limit) {
		// TODO Auto-generated method stub
		
		String hql = "from AdminEntity";
		@SuppressWarnings("unchecked")
		List<AdminEntity> list = (List<AdminEntity>) this.getHibernateTemplate().execute((PageHibernateCallback<AdminEntity>) new PageHibernateCallback<AdminEntity>(hql,  new Object[]{}, begin, limit));
		if (list!=null && list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public String updateAdmin(int id,String username, String rank) {
		// TODO Auto-generated method stub
	
		AdminEntity adminEntity = (AdminEntity) this.getHibernateTemplate().get(AdminEntity.class,id);
		adminEntity.setUsername(username);
		adminEntity.setRank(rank);
		this.getHibernateTemplate().update(adminEntity);
		
//		Object[] value = {username,rank,id};
//		String hql = "update AdminEntity a set a.username=?,a.rank=? where a.id=?";
//		this.getHibernateTemplate().update(hql,value);
		
		return null;
	}

	/**
	 * 根据管理员ID删除管理员账号
	 */
	@Override
	public boolean deleteAdmin(int id) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity = (AdminEntity) this.getHibernateTemplate().get(AdminEntity.class, id);
		try {
			this.getHibernateTemplate().delete(adminEntity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	

}
