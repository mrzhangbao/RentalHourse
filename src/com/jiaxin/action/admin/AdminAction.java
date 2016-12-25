package com.jiaxin.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.struts2.ServletActionContext;

import com.jiaxin.entity.AdminEntity;
import com.jiaxin.service.AdminService;
import com.jiaxin.utils.AdminPageData;
import com.jiaxin.utils.EncryptionUtils;
import com.jiaxin.utils.JsonUtils;
import com.jiaxin.utils.PageBean;
import com.jiaxin.utils.Rows;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private AdminService adminService;

	private AdminEntity adminEntity;

	private static final int INACTIVEINTERVAL = 3600;// ����session����Чʱ��Ϊ3600s

	public AdminEntity getAdminEntity() {
		return adminEntity;
	}

	public void setAdminEntity(AdminEntity adminEntity) {
		this.adminEntity = adminEntity;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/* �û��ĳ��ε�½��У���û���������Session */
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		PrintWriter out = null;
		System.out.println("�û���¼��⿪ʼ");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		AdminEntity ad = adminService.getAdminByAccount(account);

		try {
			out = response.getWriter();
			if (ad == null) {
				System.out.println("����Ա������");
				out.write("2");
			} else {

				// ���������󣬷���2
				if (!EncryptionUtils.md5Hex(password).equals(ad.getPassword())) {
					System.out.println("�������");
					out.write("2");

				} else {
					// �û���֤��ȷ������1
					// �����û���Session��
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(INACTIVEINTERVAL);// ������Чʱ��Ϊ1Сʱ
					// concatƴ���ַ����ȡ�+��Ч�ʸ�
					String key = session.getId().concat(account);

					session.setAttribute(key, ad);
					out.write("1");
					System.out.println("������ȷ");
				}
			}
			close(out);// �ر����������ڴ����

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("��֤����Ա");
		return "success";
	}

	public String getname() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		System.out.println("��ȡ����Ա");
		String account = request.getParameter("account");
		AdminEntity a = getSessionData(request, account);
		// �����ȡ�Ľ��Ϊ�գ�˵��SessionʧЧ����ת����½����
		try {
			out = response.getWriter();
			// �����ڸö�����ʾ�û����е�½
			if (a == null) {
				out.write("false");
			} else {
				System.out.println("�����û���");
				out.print(a.getUsername());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		close(out);
		return null;

	}

	public String check() {
		System.out.println("�û�Session��鿪ʼ");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		AdminEntity a = getSessionData(request, adminEntity.getAccount());
		// ���Ϊ�գ���˵��ʧЧ�����û���Ϣ������ת����½����
		if (a == null) {
			try {
				System.out.println("��ת������Ա��½������");
				request.getRequestDispatcher("amlogin.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("account" + a.toString());
			System.out.println("account" + adminEntity.toString());
			// ����˺Ż�������Բ��ϣ�����֤ʧ��
			try {
				if (!adminEntity.getAccount().equals(a.getAccount())) {
					System.out.println("��ת������Ա��½������");
					request.getRequestDispatcher("amlogin.jsp").forward(request, response);
				} else {
					// ���ص�������,����������
					ActionContext.getContext().put("account", a.getAccount());
					ActionContext.getContext().put("username", a.getUsername());
					System.out.println("��ת������ϵͳ������");
					request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
				}
			} catch (ServletException | IOException e) {
				// TODO: handle exception
			}

		}

		System.out.println("��ת������ϵͳ������");
		return "success";

	}

	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String rank = request.getParameter("rank");

		PrintWriter out = null;

		try {
			out = response.getWriter();
			if (adminService.isExist(account)) {
				// �����û�����ʾ�˺��Ѿ�����
				out.print("�˺��Ѵ���");
				System.out.println("��ӹ���Աʧ��");
			} else {
				// ����û������ݿ���
				AdminEntity a = new AdminEntity();
				a.setAccount(account);
				a.setPassword(EncryptionUtils.md5Hex(password));
				a.setUsername(username);
				a.setRank(rank);
				a.setAddtime(new Date());
				adminService.save(a);
				out.print("��ӳɹ�");
				System.out.println("��ӹ���Ա�ɹ�");
			}
			close(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
	public String getAll(){
		HttpServletRequest request = getRequest();
		System.out.println("limit:"+request.getParameter("pageSize"));
		System.out.println("pageNumber:"+request.getParameter("pageNumber"));
		int limit = Integer.parseInt(request.getParameter("pageSize"));
		int pageNum= Integer.parseInt(request.getParameter("pageNumber"));
		
		System.out.println("="+limit+"="+pageNum);
		System.out.println("��ȡ����Ϣ��"+adminService.findByPageId(pageNum, limit).getList().toString());
		AdminPageData jsonData = new AdminPageData();
		PageBean<AdminEntity> pageBean = adminService.findByPageId(pageNum, limit);
		List<Rows> rows = new ArrayList<>();
		for(AdminEntity ad : pageBean.getList()){
			Rows r = new Rows();
			ad.setPassword("");
			r.setAdmin(ad);
			rows.add(r);
			
		}
		jsonData.setTotal(String.valueOf(pageBean.getTotalCount()));
		jsonData.setRows(rows);
		HttpServletResponse response = getResponse();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(JsonUtils.toJson(jsonData));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(out);
		System.out.println("���ع���Ա��Ϣ");
		return null;
		
	}
	
	
	
	public String update(){
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		System.out.println("id:"+request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String rank = request.getParameter("rank");
		System.out.println("username:"+username);
		if ( !username.equals("") && !rank.equals("")) {
			adminService.updateAdmin(id, username, rank);
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("���³ɹ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(out);
		System.out.println("���³ɹ�");
		return "error";
	}
	
	@SuppressWarnings({ })
	public String delete(){
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		PrintWriter out = null;
		System.out.println("ɾ������Ա������ʼ");
		//�ж�id�Ƿ�Ϊ����0�������������ǵû�����ʾɾ��ʧ��
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		try {
			out = response.getWriter();
			if (isInteger(idString)) {
				if (id>0) {
					adminService.deleteAdmin(id);
					out.write("ɾ���ɹ�");
				}else {
					out.write("ɾ��ʧ��");
				}
			}else {
				out.write("ɾ��ʧ��");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ɾ��ʧ��");
		}
		close(out);
		System.out.println("ɾ������Ա�������");
		return null;
		
	}
	
	/**
	 * �ж��ַ����Ƿ�Ϊ����
	 * @param input
	 * @return
	 */
	public static boolean isInteger(String input){  
        Matcher mer = Pattern.compile("^[+-]?[0-9]+$").matcher(input); 
        return mer.find();  
    }  
	
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	private PrintWriter getPrintWriter(HttpServletResponse response){
		return null;
		
	}
	
	public HttpServletResponse getResponse(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		return response;
	}
	
	

	/**
	 * ��ȡ�����Ĺ���������������ȡSession�еĹ���Ա��Ϣ
	 * 
	 * @param request
	 * @param account
	 * @return
	 */
	public AdminEntity getSessionData(HttpServletRequest request, String account) {
		HttpSession session = request.getSession();
		String key = session.getId().concat(account);
		return (AdminEntity) session.getAttribute(key);

	}

	public void close(PrintWriter out) {
		out.flush();
		out.close();// һ��Ҫ�رգ���Ȼajax �����struts.xml�����÷���һ��jsp
	}
	
	

}
