package com.jiaxin.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jiaxin.entity.User;
import com.jiaxin.service.UserService;
import com.jiaxin.utils.JsonUtils;
import com.jiaxin.utils.smsutil.Config;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserManagerAction extends ActionSupport {

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

	public String addUser() {
		System.out.println("comming in ");
		User u = new User();
		u.setPhoneNum(user.getPhoneNum());
		u.setPassword(user.getPassword());
		userService.save(u);
		System.out.println("用户信息" + u.getPhoneNum());
		System.out.println("用户信息" + u.getPassword());
		return "success";

	}

	public String checkUserByPhone() {
		System.out.println("用户检测开始");
		String msg = "null";

		if (userService.isExist(user.getPhoneNum())) {
			System.out.println("该号码" + user.getPhoneNum() + "用户可以注册");
			msg = "该号码" + user.getPhoneNum() + "用户可以注册";
		} else {
			System.out.println("该号码" + user.getPhoneNum() + "被注册注册啦，直接登陆啦");
			msg = "该号码" + user.getPhoneNum() + "被注册注册啦，直接登陆啦";
		}
		/* ServletActionContext.getRequest().setAttribute("message", msg); */
		ActionContext.getContext().put("message", msg);
		System.out.println("返回消息：" + msg);
		return "check";

	}

	public String updateUser() {
		HttpServletRequest request = this.getRequest();
		HttpServletResponse response = this.getResponse();
		System.out.println("更新用户信息开始");
		System.out.println("userData:"+user.toString());
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (user==null) {
				out.write("提交失败");
			}else{
				User dbUser = userService.getUserByPhoneNum(user.getPhoneNum());
				int score = Integer.parseInt(dbUser.getCreditScore());
				
				if (!user.getEmail().equals("") && dbUser.getEmail().equals("") && score < 50) {
					score = score+5;
				}
				if (!user.getRealName().equals("") && dbUser.getRealName().equals("") && score < 60) {
					score = score+10;
				}
				if (score<70 && !user.getCreditNum().equals("")&& !user.getRealName().equals("") && dbUser.getCreditNum().equals("")) {
					score = score+10;
					if (dbUser.getRole().equals("独立经济人")) {
						
					}else{
						user.setRole("实名认证");
					}
				}
				user.setCreditScore(""+score);
				userService.updateUser(user);
				out.write("保存成功");
			}
			close(out);
			System.out.println("更新用户数据完成");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error";

	}

	public String getUserData() {
		System.out.println("获取用户信息");
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

				User users = userService.getUserByPhoneNum(phoneNum);
				users.setPassword("");// 设置密码为空，保护用户信息安全
				out.write(JsonUtils.toJson(users));
				System.out.println("返回用户信息" + users.toString());
				
				ActionContext.getContext().put("path", "haha");
				close(out);
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (out != null) {
				close(out);
			}
		}
		System.out.println("返回用户信息成功");
		return "error";

	}

	public String showAvatar(){
		
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		System.out.println("获取用户的头像");
		try {
			
			request = this.getRequest();
			response = this.getResponse();
			String filename=request.getParameter("filename");
			String savePath = Config.SAVE_USER_AVATAR_PATH+"/"+filename;
			FileInputStream in = new FileInputStream(savePath);
			int i = in.available();
			byte  data[]= new byte[i];
			in.read(data);
			in.close();
			response.setContentType("multipart/form-data");
			ServletOutputStream out = response.getOutputStream();
			out.write(data);
			System.out.println("返回图片到客户端成功");
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return myMethod;
		
	}
	

	// 获得HttpServletRequest
	private HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	private HttpServletResponse getResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		return response;
	}

	private void close(PrintWriter out) {
		out.flush();
		out.close();
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
