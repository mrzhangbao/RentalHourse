package com.jiaxin.action.hourse;


import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.jiaxin.action.BaseAction;
import com.jiaxin.entity.HourseDetail;
import com.jiaxin.entity.HourseRental;
import com.jiaxin.service.UserService;
import com.jiaxin.utils.DateUtils;



public class HourseAction extends BaseAction {
	
	private UserService userService;
	
	private HourseRental mHourseRental;
	private HourseDetail mHourseDetail;
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void saveRental(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = getResponse();
		PrintWriter out = getPrintWriter(response, "HourseAction-->saveHourseRental");
		//获取B 端数据
		String user = request.getParameter("user");
		System.out.println("user--"+user);
		System.out.println("tyoe--"+ request.getParameter("hourse_type"));
		System.out.println("detail--"+ request.getParameter("hourse_detail"));
		genHourseDetail(request.getParameter("hourse_detail"));
		genHourseRental(request.getParameter("hourse_detail"));
		 

	
	}
	
	private HourseRental genHourseRental(String json){
		HourseDetail rental = new Gson().fromJson(json, HourseDetail.class);
		String currentTime = DateUtils.getDateFormat(DateUtils.getNowDate());
		System.out.println("cur="+currentTime);
		
		return null;
	}
	private HourseDetail genHourseDetail(String json){
		mHourseDetail = new Gson().fromJson(json, HourseDetail.class);
		mHourseDetail.setSend_time( DateUtils.getDateFormat(DateUtils.getNowDate()));
		System.out.println("show="+mHourseDetail.toString());
		return mHourseDetail;
		
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public HourseRental getmHourseRental() {
		return mHourseRental;
	}

	public void setmHourseRental(HourseRental mHourseRental) {
		this.mHourseRental = mHourseRental;
	}

	public HourseDetail getmHourseDetail() {
		return mHourseDetail;
	}

	public void setmHourseDetail(HourseDetail mHourseDetail) {
		this.mHourseDetail = mHourseDetail;
	}
	
	
	
	

	
	
	
	
}
