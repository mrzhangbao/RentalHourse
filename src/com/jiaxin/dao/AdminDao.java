package com.jiaxin.dao;

import java.util.List;

import com.jiaxin.entity.AdminEntity;


/**
 * 系统管理员的Dao接口
 * 
 * @author Benson_Tom
 *
 */
public interface AdminDao {
	// 添加管理员
	void save(AdminEntity admin);

	boolean isExist(String account);//判断用户是否存在

	String getPasswordByAccount(String account);//根据账户查密码

	AdminEntity getAdminByAccount(String account);

	List<AdminEntity> findAllAdmin();
	
	int findTotalCount();//查总的条数
	
	List<AdminEntity> findByPageId(int begin,int limit);//分页查询
	
	String updateAdmin(int id,String username,String rank);//更新管理员
	
	boolean deleteAdmin(int id);//根据id删除管理员

}
