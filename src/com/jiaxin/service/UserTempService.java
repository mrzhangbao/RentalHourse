package com.jiaxin.service;

import com.jiaxin.entity.UserTemp;

public interface UserTempService {
	
	String saveTempUser(UserTemp u);
	String getCodeByPhoneNum(String phoneNum);
	String deleTempUser(String phoneNum);
	boolean isExist(String phoneNum);

}
