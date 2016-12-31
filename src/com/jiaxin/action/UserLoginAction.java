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
	private static final int INACTIVEINTERVAL = 3600;// ����session����Чʱ��Ϊ3600s

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
						if (msg=="true") {
							HttpSession session = request.getSession();
							session.setMaxInactiveInterval(INACTIVEINTERVAL);
							String key = session.getId().concat(phoneNum);
							session.setAttribute(key, phoneNum);
						}
					}else {
						msg="�ú�����δע��";
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

	// ����У�鷽��
	public String checkPsw(String psw, String dbPwd) {
		if (!EncryptionUtils.md5Hex(psw).equals(dbPwd)) {
			System.out.println("������ע�����벻һ��");
			return "������ע�����벻һ��";
		} else {
			System.out.println("��½�ɹ�");
			return "true";
		}

	}
	
	public String getUserInformation() {
		System.out.println("�û�Session��鿪ʼ");
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
					
					String sessionPhone  =getSessionData(request, phoneNum);
					
					if (!sessionPhone.equals("")) {
						
						User users = userService.getUserByPhoneNum(phoneNum);
						users.setPassword("");
						out.write(JsonUtils.toJson(users));
						
						System.out.println("�����û���Ϣ"+users.toString());
					
					}else {
						out.write("false");
						System.out.println("�����µ�½");
						
					}
					close(out);

				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		

		System.out.println("��ת��������");
		return "error";

	}
	
	/**
	 * ��ȡ�����Ĺ���������������ȡSession�е��û���Ϣ
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
	
	//���HttpServletRequest
	private HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	private  HttpServletResponse getResponse(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		return response;
	}

}
