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
	 * �ֻ������Ƿ��Ѿ�ע����֤
	 */
	@SuppressWarnings("null")
	public void checkPhoneNum() {
		System.out.println("�û��ֻ������⿪ʼ");
		String msg = "true";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			
			String phoneNum = request.getParameter("phoneNum");
			System.out.println("��������"+phoneNum);

			// ��ȡǰ�˷��ص�json���ݣ���ͨ��Gsonת���ɶ�Ӧ��ʵ��
//			RegInfomation reg = GsonUtils.fromJson(request.getParameter("info"), RegInfomation.class);

			if (phoneNum == null) {
				out.print("�����������ֻ�����");
			}

	
			if (!userService.isExist(phoneNum)) {
				System.out.println("�ú���" + phoneNum + "�û�����ע��");
				
				if (userTempService.isExist(phoneNum)) {
					System.out.println("�ú�������ʱ���д��ڣ�ɾ�������С�����");
					userTempService.deleTempUser(phoneNum);
				}
				if (sendCode(phoneNum)) {
					msg = "true";
				}else {
					msg = "false";
					System.out.println("������֤��ʧ��");
				}

			} else {
				System.out.println("�ú���" + phoneNum + "��ע��ע������ֱ�ӵ�½��");
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
		System.out.println("������֤��ģ�鿪��");

		System.out.println("Send code to:" + phoneNum);

		int number = RandomCode.getRandomCode();// ����һ��6λ���������֤��
		UserTemp uTemp = new UserTemp();
		uTemp.setPhoneNum(phoneNum);
		uTemp.setCode("" + number);
		uTemp.setTime(String.valueOf(new Date().getTime()));

		// ������ڷ��Ͷ�����֤��ģ��

		// TaobaoClient client = new DefaultTaobaoClient(Config.URL,
		// Config.APP_KEY, Config.APP_SECRET);
		// AlibabaAliqinFcSmsNumSendRequest req = new
		// AlibabaAliqinFcSmsNumSendRequest();
		// req.setExtend("123456");
		// req.setSmsType("normal");
		// req.setSmsFreeSignName("����");
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
			System.out.println("������֤����" + phoneNum + "�ɹ���");
			return true;
		}else{
			System.out.println("������֤����" + phoneNum + "ʧ�ܣ�");
			
			return false;
		}
		
	}

	@SuppressWarnings("null")
	public String addUser() {
		
		System.out.println("�����û����û���ģ�忪ʼ����");
		HttpServletRequest request = getRequest();
		HttpServletResponse response = getResponse();
		
		PrintWriter out = null;
		RegInfomation reg = new RegInfomation();
		

		try {
			out = response.getWriter();
			// ��ȡǰ�˷��ص�json���ݣ���ͨ��Gsonת���ɶ�Ӧ��ʵ��
			reg.setPhoneNum(request.getParameter("phoneNum"));
			reg.setPassword(EncryptionUtils.md5Hex(request.getParameter("password")));
			reg.setCode(request.getParameter("code"));
			String code = userTempService.getCodeByPhoneNum(reg.getPhoneNum());
			System.out.println("ǰ���ṩ���ݣ�"+reg.toString());
			System.out.println("��ʱ���ݿ���֤�룺"+code);
			if (code.equals(reg.getCode())) {
				// ���û�������ӵ��û����У����ע��
				System.out.println("�����û����ݹ�������......");
				String phoneNum = reg.getPhoneNum();
				User u = new User();
				u.setPhoneNum(phoneNum);
				u.setPassword(reg.getPassword());
				u.setCreditScore("40");
				u.setRole("δ��֤");
				u.setCreateTime(new Timestamp(System.currentTimeMillis()));
				userService.save(u);

				// ɾ����ʱ���е���Ϣ
				userTempService.deleTempUser(phoneNum);
				System.out.println("�����û����ݹ������.....");
				out.print("ע��ɹ�");
				out.flush();
				out.close();
			} else {
				// ��֤����󣬷��ش�����Ϣ

				out.print("��֤�����");
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
