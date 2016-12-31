package com.jiaxin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpServletRequest getRequest(){
		String user = ServletActionContext.getRequest().getParameter("user");
		System.out.println("user===="+user);
		return ServletActionContext.getRequest();
		
	};
	
	public HttpServletResponse getResponse(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		return response;
		
	};
	/**
	 * 封装了写回数据到客户端所需要的流
	 * @param response
	 * @param location //传入获取流的位置，方便检查异常错误
	 * @return
	 */
	public PrintWriter getPrintWriter(HttpServletResponse response,String location){
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(location+"------->getPrintWriter----->");
			e.printStackTrace();
		}
		return out;
	}
	
	public void close(PrintWriter out){
		out.flush();
		out.close();
	};

}
