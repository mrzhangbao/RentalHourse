package com.jiaxin.utils;

/**
 * ����Json��ʽת���Ĺ�����
 * @author Benson_Tom
 *
 */
public class JsonUtils {
	
	public static String toJson(Object o){
		return GetGson.getGson().toJson(o);
	}

}
