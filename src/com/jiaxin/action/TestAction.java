package com.jiaxin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.jiaxin.entity.HourseDetail;
import com.jiaxin.entity.Recommend;
import com.jiaxin.entity.User;
import com.jiaxin.service.UserServiceImpl;
import com.jiaxin.utils.GsonUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	private User u = new User();
	/**
	 * 
	 */
	private static final long serialVersionUID = 2794127077533895034L;

	public String Login() {
		System.out.println("===========Struts Action");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl service = (UserServiceImpl) ctx.getBean("userService");
		u.setNickName("Kevin");
		u.setPassword("1234567777");
		service.save(u);
		ActionContext.getContext().put("user", u);
		return "success";

	}

	public String getInfo() {

		HourseDetail h = new HourseDetail();
		List<HourseDetail> list = new ArrayList<>();
		
		for (int i = 0; i < 15; i++) {
			list.add(h);
		}

		List<Recommend> r = new ArrayList<>();
		Recommend re = new Recommend();
		re.setPrice("5600元/月");
		re.setAddress("深圳南山");
		re.setTitle("单身公寓");

		for (int i = 0; i < 10; i++) {
			r.add(re);
		}
		ActionContext.getContext().put("list", list);
		ActionContext.getContext().put("recommend", r);
		Gson g = new Gson();
		String json = g.toJson(list);
		System.out.println("调用了主页数据");

		return "success";

	}
	
	public void getInfoByServlet() {

		HourseDetail h = new HourseDetail();
		List<HourseDetail> list = new ArrayList<>();
		
		for (int i = 0; i < 15; i++) {
			System.out.println("i="+i);
			if(i<10 ){
				h.setHourse_price("500"+i);
			}else {
				h.setHourse_price("5600");
			}
			list.add(h);
		}

		List<Recommend> r = new ArrayList<>();
		Recommend re = new Recommend();
		re.setPrice("5600元/月");
		re.setAddress("深圳南山");
		re.setTitle("单身公寓");

		for (int i = 0; i < 10; i++) {
			r.add(re);
		}
		
		Gson g = new Gson();
		String json = g.toJson(list);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out= response.getWriter();
			out.print(json);
			System.out.println("调用了主页数据"+json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		

	}

	/*
	 * @Override public String execute() throws Exception { // TODO
	 * Auto-generated method stub System.out.println("Struts Action");
	 * ApplicationContext ctx = new
	 * ClassPathXmlApplicationContext("./src/applicationContext.xml");
	 * UserServiceImpl service = (UserServiceImpl) ctx.getBean("UserSercvice");
	 * User u = new User(); u.setUsername("Kevin"); u.setPassword("123456");
	 * service.add(u); ActionContext.getContext().put("user", u);
	 * System.out.println(u.getUsername()); return "success"; }
	 */

}
