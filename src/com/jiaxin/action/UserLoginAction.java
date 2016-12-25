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
		System.out.println("λ��" + TAG + "======" + "�û���¼��֤ģ�鿪��");
		
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
			System.out.println("λ��" + TAG + "======" + "�û���¼��֤ģ�鿪��"+loginEntity.toString());
			
			// �ж��Ƿ�Ϊ�գ�Ϊ�շ��ص�½���棬��ʾ����phoneNum��password
			if (phoneNum == null) {
				msg="�ֻ��������";
				System.out.println("λ��" + TAG + "======" +phoneNum+ "��½���ֻ��������");
			} else {
				if (password == null) {
					msg ="�������";
					System.out.println("λ��" + TAG + "======" + "��½���û��������");
				} else {
					// ���жϸú����Ƿ��Ѿ�ע�ᣬ�ٸ����ֻ������ȡ���ݿ��еĵ�½��Ϣ
					
					if (userService.isExist(phoneNum)) {
						String dbPwd = userService.getPasswordByPhoneNum(phoneNum);
						msg=checkPsw(password, dbPwd);
					}else {
						msg="�ú�����δע��";
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

	// ����У�鷽��
	public String checkPsw(String psw, String dbPwd) {
		if (!psw.equals(dbPwd)) {
			System.out.println("������ע�����벻һ��");
			return "������ע�����벻һ��";
		} else {
			System.out.println("��½�ɹ�");
			
			return "true";
		}

	}

}
