package com.jiaxin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jiaxin.entity.AdminEntity;
import com.jiaxin.entity.LoginEntity;
import com.jiaxin.entity.User;
import com.jiaxin.service.UserService;
import com.jiaxin.utils.EncryptionUtils;
import com.jiaxin.utils.GetServletHttpUtil;
import com.jiaxin.utils.GsonUtils;
import com.jiaxin.utils.JsonUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {

	private static final long serialVersionUID = 9168711182934563436L;

	private static final String TAG = "UserLoginAction";
	private static final int INACTIVEINTERVAL = 3600;// 设置session的有效时间为3600s

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
		
		HttpServletRequest request = this.getRequest();
		HttpServletResponse response = this.getResponse();
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
						if (msg=="true") {
							HttpSession session = request.getSession();
							session.setMaxInactiveInterval(INACTIVEINTERVAL);
							String key = session.getId().concat(phoneNum);
							session.setAttribute(key, phoneNum);
						}
					}else {
						msg="该号码尚未注册";
					}
				}
			}
			System.out.println("what:::"+msg);
			out.print(msg);
			
			close(out);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";	
	}

	// 密码校验方法
	public String checkPsw(String psw, String dbPwd) {
		if (!EncryptionUtils.md5Hex(psw).equals(dbPwd)) {
			System.out.println("密码与注册密码不一致");
			return "密码与注册密码不一致";
		} else {
			System.out.println("登陆成功");
			return "true";
		}

	}
	
	public String getUserInformation() {
		System.out.println("用户Session检查开始");
		HttpServletRequest request = this.getRequest();
		HttpServletResponse response = this.getResponse();
		String phoneNum = request.getParameter("phoneNum");
		
		PrintWriter out = null;
		// 如果为空，则说明失效或者用户信息错误，跳转到登陆界面
		
		
			try {
				out = response.getWriter();
				if (phoneNum == "") {
					try {
						System.out.println("跳转到登陆主界面");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					
					String sessionPhone  =getSessionData(request, phoneNum);
					
					if (!sessionPhone.equals("")) {
						
						User users = userService.getUserByPhoneNum(phoneNum);
						users.setPassword("");
						out.write(JsonUtils.toJson(users));
						
						System.out.println("返回用户信息"+users.toString());
					
					}else {
						out.write("false");
						System.out.println("请重新登陆");
						
					}
					close(out);

				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		

		System.out.println("跳转到主界面");
		return "error";

	}
	
	/**
	 * 抽取出来的公共方法，用来获取Session中的用户信息
	 * 
	 * @param request
	 * @param account
	 * @return
	 */
	public String getSessionData(HttpServletRequest request, String phoneNum) {
		HttpSession session = request.getSession();
		String key = session.getId().concat(phoneNum);
		return  (String) session.getAttribute(key);

	}
	
	private void close(PrintWriter out){
		out.flush();
		out.close();
	}
	
	//获得HttpServletRequest
	private HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	private  HttpServletResponse getResponse(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		return response;
	}

}
