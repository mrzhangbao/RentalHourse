package com.jiaxin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jiaxin.entity.LoginEntity;
import com.jiaxin.entity.User;
import com.jiaxin.service.UserService;
import com.jiaxin.utils.GetServletHttpUtil;
import com.jiaxin.utils.GsonUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {

	private static final long serialVersionUID = 9168711182934563436L;

	private static final String TAG = "UserLoginAction";

	private UserService userService;
	private User user;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public String login() {
		System.out.println("位置" + TAG + "======" + "用户登录验证模块开启");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out = null;
		LoginEntity loginEntity = null;
		
		String phoneNum;
		String password;
		String msg = null;
		
		try {
			out = response.getWriter();
			
			loginEntity = GsonUtils.fromJson(request.getParameter("info"), LoginEntity.class);
			
			
			phoneNum = loginEntity.getPhoneNum();
			password = loginEntity.getPassword();
			System.out.println("位置" + TAG + "======" + "用户登录验证模块开启"+loginEntity.toString());
			
			// 判断是否为空，为空返回登陆界面，提示输入phoneNum和password
			if (phoneNum == null) {
				msg="手机号码错误";
				System.out.println("位置" + TAG + "======" +phoneNum+ "登陆的手机号码错误");
			} else {
				if (password == null) {
					msg ="密码错误";
					System.out.println("位置" + TAG + "======" + "登陆的用户密码错误");
				} else {
					// 先判断该号码是否已经注册，再根据手机号码获取数据库中的登陆信息
					
					if (userService.isExist(phoneNum)) {
						String dbPwd = userService.getPasswordByPhoneNum(phoneNum);
						msg=checkPsw(password, dbPwd);
					}else {
						msg="该号码尚未注册";
					}
				}
			}
			System.out.println("what:::"+msg);
			out.print(msg);
			
			out.flush();
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";	
	}

	// 密码校验方法
	public String checkPsw(String psw, String dbPwd) {
		if (!psw.equals(dbPwd)) {
			System.out.println("密码与注册密码不一致");
			return "密码与注册密码不一致";
		} else {
			System.out.println("登陆成功");
			
			return "true";
		}

	}

}
