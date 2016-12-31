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
		System.out.println("�û���Ϣ" + u.getPhoneNum());
		System.out.println("�û���Ϣ" + u.getPassword());
		return "success";

	}

	public String checkUserByPhone() {
		System.out.println("�û���⿪ʼ");
		String msg = "null";

		if (userService.isExist(user.getPhoneNum())) {
			System.out.println("�ú���" + user.getPhoneNum() + "�û�����ע��");
			msg = "�ú���" + user.getPhoneNum() + "�û�����ע��";
		} else {
			System.out.println("�ú���" + user.getPhoneNum() + "��ע��ע������ֱ�ӵ�½��");
			msg = "�ú���" + user.getPhoneNum() + "��ע��ע������ֱ�ӵ�½��";
		}
		/* ServletActionContext.getRequest().setAttribute("message", msg); */
		ActionContext.getContext().put("message", msg);
		System.out.println("������Ϣ��" + msg);
		return "check";

	}

	public String updateUser() {
		HttpServletRequest request = this.getRequest();
		HttpServletResponse response = this.getResponse();
		System.out.println("�����û���Ϣ��ʼ");
		System.out.println("userData:"+user.toString());
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (user==null) {
				out.write("�ύʧ��");
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
					if (dbUser.getRole().equals("����������")) {
						
					}else{
						user.setRole("ʵ����֤");
					}
				}
				user.setCreditScore(""+score);
				userService.updateUser(user);
				out.write("����ɹ�");
			}
			close(out);
			System.out.println("�����û��������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error";

	}

	public String getUserData() {
		System.out.println("��ȡ�û���Ϣ");
		HttpServletRequest request = this.getRequest();
		HttpServletResponse response = this.getResponse();
		String phoneNum = request.getParameter("phoneNum");

		PrintWriter out = null;
		// ���Ϊ�գ���˵��ʧЧ�����û���Ϣ������ת����½����

		try {
			out = response.getWriter();
			if (phoneNum == "") {
				try {
					System.out.println("��ת����½������");
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
				users.setPassword("");// ��������Ϊ�գ������û���Ϣ��ȫ
				out.write(JsonUtils.toJson(users));
				System.out.println("�����û���Ϣ" + users.toString());
				
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
		System.out.println("�����û���Ϣ�ɹ�");
		return "error";

	}

	public String showAvatar(){
		
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		System.out.println("��ȡ�û���ͷ��");
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
			System.out.println("����ͼƬ���ͻ��˳ɹ�");
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return myMethod;
		
	}
	

	// ���HttpServletRequest
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
