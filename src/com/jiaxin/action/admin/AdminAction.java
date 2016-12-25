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

	private static final int INACTIVEINTERVAL = 3600;// 设置session的有效时间为3600s

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

	/* 用户的初次登陆，校验用户，并创建Session */
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		PrintWriter out = null;
		System.out.println("用户登录检测开始");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		AdminEntity ad = adminService.getAdminByAccount(account);

		try {
			out = response.getWriter();
			if (ad == null) {
				System.out.println("管理员不存在");
				out.write("2");
			} else {

				// 如果密码错误，返回2
				if (!EncryptionUtils.md5Hex(password).equals(ad.getPassword())) {
					System.out.println("密码错误");
					out.write("2");

				} else {
					// 用户验证正确，返回1
					// 保存用户到Session中
					HttpSession session = request.getSession();
					session.setMaxInactiveInterval(INACTIVEINTERVAL);// 设置有效时长为1小时
					// concat拼接字符串比“+”效率高
					String key = session.getId().concat(account);

					session.setAttribute(key, ad);
					out.write("1");
					System.out.println("密码正确");
				}
			}
			close(out);// 关闭流，避免内存溢出

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("验证管理员");
		return "success";
	}

	public String getname() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		System.out.println("获取管理员");
		String account = request.getParameter("account");
		AdminEntity a = getSessionData(request, account);
		// 如果获取的结果为空，说明Session失效，跳转到登陆界面
		try {
			out = response.getWriter();
			// 不存在该对象，提示用户进行登陆
			if (a == null) {
				out.write("false");
			} else {
				System.out.println("返回用户名");
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
		System.out.println("用户Session检查开始");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		AdminEntity a = getSessionData(request, adminEntity.getAccount());
		// 如果为空，则说明失效或者用户信息错误，跳转到登陆界面
		if (a == null) {
			try {
				System.out.println("跳转到管理员登陆主界面");
				request.getRequestDispatcher("amlogin.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("account" + a.toString());
			System.out.println("account" + adminEntity.toString());
			// 如果账号或者密码对不上，则验证失败
			try {
				if (!adminEntity.getAccount().equals(a.getAccount())) {
					System.out.println("跳转到管理员登陆主界面");
					request.getRequestDispatcher("amlogin.jsp").forward(request, response);
				} else {
					// 返回到主界面,并附带参数
					ActionContext.getContext().put("account", a.getAccount());
					ActionContext.getContext().put("username", a.getUsername());
					System.out.println("跳转到管理系统主界面");
					request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
				}
			} catch (ServletException | IOException e) {
				// TODO: handle exception
			}

		}

		System.out.println("跳转到管理系统主界面");
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
				// 存在用户，提示账号已经存在
				out.print("账号已存在");
				System.out.println("添加管理员失败");
			} else {
				// 添加用户到数据库中
				AdminEntity a = new AdminEntity();
				a.setAccount(account);
				a.setPassword(EncryptionUtils.md5Hex(password));
				a.setUsername(username);
				a.setRank(rank);
				a.setAddtime(new Date());
				adminService.save(a);
				out.print("添加成功");
				System.out.println("添加管理员成功");
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
		System.out.println("获取的信息："+adminService.findByPageId(pageNum, limit).getList().toString());
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
		System.out.println("返回管理员信息");
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
			out.print("更新成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(out);
		System.out.println("更新成功");
		return "error";
	}
	
	@SuppressWarnings({ })
	public String delete(){
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		PrintWriter out = null;
		System.out.println("删除管理员操作开始");
		//判断id是否为大于0的正整数，不是得话则提示删除失败
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		try {
			out = response.getWriter();
			if (isInteger(idString)) {
				if (id>0) {
					adminService.deleteAdmin(id);
					out.write("删除成功");
				}else {
					out.write("删除失败");
				}
			}else {
				out.write("删除失败");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除失败");
		}
		close(out);
		System.out.println("删除管理员操作完成");
		return null;
		
	}
	
	/**
	 * 判断字符串是否为整数
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
	 * 抽取出来的公共方法，用来获取Session中的管理员信息
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
		out.close();// 一定要关闭，不然ajax 会根据struts.xml的配置返回一个jsp
	}
	
	

}
