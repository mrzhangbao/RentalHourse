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
		System.out.println("�û���Ϣ"+u.getPhoneNum());
		System.out.println("�û���Ϣ"+u.getPassword());
		return "success";
		
	}
	
	
	public String checkUserByPhone(){
		System.out.println("�û���⿪ʼ");
		String msg="null";
		
	
		if (userService.isExist(user.getPhoneNum())) {
			System.out.println("�ú���"+user.getPhoneNum()+"�û�����ע��");
			msg="�ú���"+user.getPhoneNum()+"�û�����ע��";
		}else {
			System.out.println("�ú���"+user.getPhoneNum()+"��ע��ע������ֱ�ӵ�½��");
			msg="�ú���"+user.getPhoneNum()+"��ע��ע������ֱ�ӵ�½��";
		}
			
	/*	ServletActionContext.getRequest().setAttribute("message", msg);*/
		
		ActionContext.getContext().put("message", msg);
		System.out.println("������Ϣ��"+msg);
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
