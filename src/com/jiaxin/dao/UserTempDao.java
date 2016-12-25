package com.jiaxin.dao;

import com.jiaxin.entity.UserTemp;

public interface UserTempDao {
	
	String saveTempUser(UserTemp u);
	String getCodeByPhoneNum(String phoneNum);
	String deleTempUser(String phoneNum);
	boolean isExist(String phoneNum);

}
