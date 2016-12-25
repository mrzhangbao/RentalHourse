package com.jiaxin.service;

import java.util.List;

import com.jiaxin.entity.AdminEntity;
import com.jiaxin.utils.PageBean;

/**
 * ����Ա�����Service�ӿ�
 * @author Benson_Tom
 *
 */
public interface AdminService {
	// ��ӹ���Ա
		void save(AdminEntity admin);

		boolean isExist(String account);

		String getPasswordByAccount(String account);

		AdminEntity getAdminByAccount(String account);

		List<AdminEntity> findAllAdmin();
		
		int findTotalCount();//���ܵ�����
		
		PageBean<AdminEntity> findByPageId(int page,int limit);//��ҳ��ѯ

		String updateAdmin(int id,String username,String rank);//���¹���Ա
		
		boolean deleteAdmin(int id);//����idɾ������Ա
}
