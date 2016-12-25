package com.jiaxin.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class GetServletHttpUtil {
	
	private static HttpServletRequest request;
	private static HttpServletResponse response;
	
	public static HttpServletRequest getRequest(){
		if (request == null) {
			synchronized (GetServletHttpUtil.class) {
				if (request == null) {
					request = ServletActionContext.getRequest();
				}
			}
		}
		return request;
		
	}
	
	public static HttpServletResponse getResponse(){
		if (response == null) {
			synchronized (GetServletHttpUtil.class) {
				if (response == null) {
					response = ServletActionContext.getResponse();
				}
				
			}
		}
		return response;
	}

}
