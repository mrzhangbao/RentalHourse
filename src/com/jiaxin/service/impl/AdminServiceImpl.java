package com.jiaxin.service.impl;

import java.util.List;

import com.jiaxin.dao.AdminDao;
import com.jiaxin.entity.AdminEntity;
import com.jiaxin.service.AdminService;
import com.jiaxin.utils.PageBean;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao;
	
	
	

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void save(AdminEntity admin) {
		// TODO Auto-generated method stub
		adminDao.save(admin);

	}

	@Override
	public boolean isExist(String account) {
		// TODO Auto-generated method stub
		return adminDao.isExist(account);
	}

	@Override
	public String getPasswordByAccount(String account) {
		// TODO Auto-generated method stub
		return adminDao.getPasswordByAccount(account);
	}

	
	@Override
	public AdminEntity getAdminByAccount(String account) {
		// TODO Auto-generated method stub
		return adminDao.getAdminByAccount(account);
	}

	@Override
	public List<AdminEntity> findAllAdmin() {
		// TODO Auto-generated method stub
		return adminDao.findAllAdmin();
	}

	@Override
	public int findTotalCount() {
		// TODO Auto-generated method stub
		return adminDao.findTotalCount();
	}

	/**
	 * 分页查询数据，返回一个分页实体类，传入当前页面和显示的数目
	 */
	@Override
	public PageBean<AdminEntity> findByPageId(int page, int limit) {
		PageBean<AdminEntity> bean = new PageBean<>();
		bean.setPage(page);
		bean.setLimit(limit);
		int totalCount = findTotalCount();//获取总的条数
		bean.setTotalCount(totalCount);
		int totalPage=(int) Math.ceil(totalCount/limit);
		bean.setTotalPage(totalPage);
		List<AdminEntity> list = adminDao.findByPageId(page, limit);
		bean.setList(list);
		return bean;
	}

	@Override
	public String updateAdmin(int id,String username, String rank) {
		// TODO Auto-generated method stub
		
		return adminDao.updateAdmin(id, username, rank);
	}

	@Override
	public boolean deleteAdmin(int id) {
		// TODO Auto-generated method stub
		return adminDao.deleteAdmin(id);
	}

}
