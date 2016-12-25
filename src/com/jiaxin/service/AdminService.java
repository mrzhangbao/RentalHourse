package com.jiaxin.service;

import java.util.List;

import com.jiaxin.entity.AdminEntity;
import com.jiaxin.utils.PageBean;

/**
 * 管理员管理的Service接口
 * @author Benson_Tom
 *
 */
public interface AdminService {
	// 添加管理员
		void save(AdminEntity admin);

		boolean isExist(String account);

		String getPasswordByAccount(String account);

		AdminEntity getAdminByAccount(String account);

		List<AdminEntity> findAllAdmin();
		
		int findTotalCount();//查总的条数
		
		PageBean<AdminEntity> findByPageId(int page,int limit);//分页查询

		String updateAdmin(int id,String username,String rank);//更新管理员
		
		boolean deleteAdmin(int id);//根据id删除管理员
}
