package com.jiaxin.utils;

/**
 * 用于Json格式转换的工具类
 * @author Benson_Tom
 *
 */
public class JsonUtils {
	
	public static String toJson(Object o){
		return GetGson.getGson().toJson(o);
	}

}
