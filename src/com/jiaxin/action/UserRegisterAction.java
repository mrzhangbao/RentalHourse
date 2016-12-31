package com.jiaxin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jiaxin.entity.RegInfomation;
import com.jiaxin.entity.User;
import com.jiaxin.entity.UserTemp;
import com.jiaxin.service.UserService;
import com.jiaxin.service.UserTempService;
import com.jiaxin.utils.EncryptionUtils;
import com.jiaxin.utils.GetServletHttpUtil;
import com.jiaxin.utils.GsonUtils;
import com.jiaxin.utils.TestInfo;
import com.jiaxin.utils.smsutil.Config;
import com.jiaxin.utils.smsutil.RandomCode;
import com.opensymphony.xwork2.ActionSupport;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class UserRegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String myMethod;
	private User mUser;
	private UserService userService;
	private UserTempService userTempService;

	public String getMyMethod() {
		return myMethod;
	}

	public void setMyMethod(String myMethod) {
		this.myMethod = myMethod;
	}

	public User getmUser() {
		return mUser;
	}

	public void setmUser(User mUser) {
		this.mUser = mUser;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserTempService getUserTempService() {
		return userTempService;
	}

	public void setUserTempService(UserTempService userTempService) {
		this.userTempService = userTempService;
	}

	/**
	 * 手机号码是否已经注册验证
	 */
	@SuppressWarnings("null")
	public void checkPhoneNum() {
		System.out.println("用户手机号码检测开始");
		String msg = "true";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
			String phoneNum = request.getParameter("phoneNum");
			System.out.println("这里这里"+phoneNum);

			// 获取前端返回的json数据，并通过Gson转换成对应的实体
//			RegInfomation reg = GsonUtils.fromJson(request.getParameter("info"), RegInfomation.class);

			if (phoneNum == null) {
				out.print("请重新输入手机号码");
			}

	
			if (!userService.isExist(phoneNum)) {
				System.out.println("该号码" + phoneNum + "用户可以注册");
				
				if (userTempService.isExist(phoneNum)) {
					System.out.println("该号码在临时表中存在，删除数据中。。。");
					userTempService.deleTempUser(phoneNum);
				}
				if (sendCode(phoneNum)) {
					msg = "true";
				}else {
					msg = "false";
					System.out.println("发送验证码失败");
				}

			} else {
				System.out.println("该号码" + phoneNum + "被注册注册啦，直接登陆啦");
				msg = "false";
				
			}
			out.print(msg);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			out.flush();
			out.close();
		}
	}

	public boolean sendCode(String phoneNum) {
		System.out.println("发送验证码模块开启");

		System.out.println("Send code to:" + phoneNum);

		int number = RandomCode.getRandomCode();// 产生一个6位数的随机验证码
		UserTemp uTemp = new UserTemp();
		uTemp.setPhoneNum(phoneNum);
		uTemp.setCode("" + number);
		uTemp.setTime(String.valueOf(new Date().getTime()));

		// 阿里大于发送短信验证码模块

		// TaobaoClient client = new DefaultTaobaoClient(Config.URL,
		// Config.APP_KEY, Config.APP_SECRET);
		// AlibabaAliqinFcSmsNumSendRequest req = new
		// AlibabaAliqinFcSmsNumSendRequest();
		// req.setExtend("123456");
		// req.setSmsType("normal");
		// req.setSmsFreeSignName("闲租");
		// req.setSmsParamString("{\"code\":\"1234\",\"product\":\"alidayu\"}");
		// req.setSmsParamString("{\"number\":\"" + number + "\"}");
		// req.setRecNum(phoneNum);
		// req.setSmsTemplateCode("SMS_34390202");
		// AlibabaAliqinFcSmsNumSendResponse rsp = null;
		// try {
		// rsp = client.execute(req);
		// } catch (ApiException e) {
		// // TODOAuto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(rsp.getBody());
		if(phoneNum!=null){
			userTempService.saveTempUser(uTemp);
			System.out.println("发送验证码至" + phoneNum + "成功！");
			return true;
		}else{
			System.out.println("发送验证码至" + phoneNum + "失败！");
			
			return false;
		}
		
	}

	@SuppressWarnings("null")
	public String addUser() {
		
		System.out.println("保存用户到用户表模板开始工作");
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		
		PrintWriter out = null;
		RegInfomation reg = new RegInfomation();
		

		try {
			out = response.getWriter();
			// 获取前端返回的json数据，并通过Gson转换成对应的实体
			reg.setPhoneNum(request.getParameter("phoneNum"));
			reg.setPassword(EncryptionUtils.md5Hex(request.getParameter("password")));
			reg.setCode(request.getParameter("code"));
			String code = userTempService.getCodeByPhoneNum(reg.getPhoneNum());
			System.out.println("前端提供数据："+reg.toString());
			System.out.println("临时数据库验证码："+code);
			if (code.equals(reg.getCode())) {
				// 将用户数据添加到用户表中，完成注册
				System.out.println("保存用户数据工作开启......");
				String phoneNum = reg.getPhoneNum();
				User u = new User();
				u.setPhoneNum(phoneNum);
				u.setPassword(reg.getPassword());
				u.setCreditScore("40");
				u.setRole("未认证");
				u.setCreateTime(new Timestamp(System.currentTimeMillis()));
				userService.save(u);

				// 删除临时表中的信息
				userTempService.deleTempUser(phoneNum);
				System.out.println("保存用户数据工作完成.....");
				out.print("注册成功");
				out.flush();
				out.close();
			} else {
				// 验证码错误，返回错误信息

				out.print("验证码错误");
				out.flush();
				out.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
			out.flush();
			out.close();
		} 
		return "error";

	}
	
	private HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	private HttpServletResponse getResponse(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		return response;
	}

}
