package com.jiaxin.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;

import com.jiaxin.entity.User;
import com.jiaxin.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserManagerAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String myMethod;
	private User user;
	private UserService userService;
	
	

	public String getMyMethod() {
		return myMethod;
	}

	public void setMyMethod(String myMethod) {
		this.myMethod = myMethod;
	}
	
	public String addUser(){
		System.out.println("comming in ");
		User u = new User();
		u.setPhoneNum(user.getPhoneNum());
		u.setPassword(user.getPassword());
		userService.save(u);
		System.out.println("用户信息"+u.getPhoneNum());
		System.out.println("用户信息"+u.getPassword());
		return "success";
		
	}
	
	
	public String checkUserByPhone(){
		System.out.println("用户检测开始");
		String msg="null";
		
	
		if (userService.isExist(user.getPhoneNum())) {
			System.out.println("该号码"+user.getPhoneNum()+"用户可以注册");
			msg="该号码"+user.getPhoneNum()+"用户可以注册";
		}else {
			System.out.println("该号码"+user.getPhoneNum()+"被注册注册啦，直接登陆啦");
			msg="该号码"+user.getPhoneNum()+"被注册注册啦，直接登陆啦";
		}
			
	/*	ServletActionContext.getRequest().setAttribute("message", msg);*/
		
		ActionContext.getContext().put("message", msg);
		System.out.println("返回消息："+msg);
		return "check";
		
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	

}
