package com.jiaxin.dao;

import java.util.List;

import com.jiaxin.entity.AdminEntity;


/**
 * ϵͳ����Ա��Dao�ӿ�
 * 
 * @author Benson_Tom
 *
 */
public interface AdminDao {
	// ��ӹ���Ա
	void save(AdminEntity admin);

	boolean isExist(String account);//�ж��û��Ƿ����

	String getPasswordByAccount(String account);//�����˻�������

	AdminEntity getAdminByAccount(String account);

	List<AdminEntity> findAllAdmin();
	
	int findTotalCount();//���ܵ�����
	
	List<AdminEntity> findByPageId(int begin,int limit);//��ҳ��ѯ
	
	String updateAdmin(int id,String username,String rank);//���¹���Ա
	
	boolean deleteAdmin(int id);//����idɾ������Ա

}
