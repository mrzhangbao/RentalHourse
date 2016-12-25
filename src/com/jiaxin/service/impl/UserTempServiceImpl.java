package com.jiaxin.service.impl;

import com.jiaxin.dao.UserTempDao;
import com.jiaxin.entity.UserTemp;
import com.jiaxin.service.UserTempService;

public class UserTempServiceImpl implements UserTempService {
	
	private UserTempDao userTempDao;
	
	

	public UserTempDao getUserTempDao() {
		return userTempDao;
	}

	public void setUserTempDao(UserTempDao userTempDao) {
		this.userTempDao = userTempDao;
	}

	@Override
	public String saveTempUser(UserTemp u) {
		// TODO Auto-generated method stub
		return this.userTempDao.saveTempUser(u);
	}

	@Override
	public String getCodeByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return this.userTempDao.getCodeByPhoneNum(phoneNum);
	}

	@Override
	public String deleTempUser(String phoneNum) {
		// TODO Auto-generated method stub
		return this.userTempDao.deleTempUser(phoneNum);
	}

	@Override
	public boolean isExist(String phoneNum) {
		// TODO Auto-generated method stub
		return this.userTempDao.isExist(phoneNum);
	}
	
	

}
