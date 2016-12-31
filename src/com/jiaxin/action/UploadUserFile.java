package com.jiaxin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jiaxin.entity.User;
import com.jiaxin.service.UserService;
import com.jiaxin.utils.smsutil.Config;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadUserFile extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String execute() throws Exception {
		
		System.out.println("保存用户信息工作开始");

		// 判断文件夹是否存在操作
		String savepath = Config.SAVE_USER_AVATAR_PATH;
		String savefilename = "";
		HttpServletRequest request = this.getRequest();
		String phoneNum = request.getParameter("phoneNum");
		System.out.println("phoneNum"+phoneNum);
		HttpServletResponse response = this.getResponse();
		
		if (!new File(savepath).isDirectory()) {
			new File(savepath).mkdir();
		}

		System.out.println("path:" + savepath);
		
		PrintWriter out = null;
		
		out = response.getWriter();
		boolean isupload = false;

		if (file == null) {
			savefilename = "logo.png";
		} else {
			InputStream is = new FileInputStream(file);
			savefilename = phoneNum+(new Date()).getTime() + ".jpg";
			OutputStream os = new FileOutputStream(new File(savepath, savefilename));

			byte[] buffer = new byte[500];
			int length = 0;
			while (-1 != (length = is.read(buffer, 0, buffer.length))) {
				os.write(buffer);
			}
			System.out.println("保存图片成功");
			isupload=true;
			os.close();
			is.close();
		}
		
		User user = userService.getUserByPhoneNum(phoneNum);
		if (user==null) {
			return "error";
		}
		user.setAvatar(savefilename);
		this.userService.updateUser(user);
		
		if (isupload && phoneNum!=null) {
			out.write("true");
		}else {
			out.write("error");
		}
		close(out);
		System.out.println("保存路径" + savepath);

		
		System.out.println("保存用户信息结束");
		return "success";
	}

	@Override
	public HttpServletRequest getRequest() {
		// TODO Auto-generated method stub
		return super.getRequest();
	}

	@Override
	public HttpServletResponse getResponse() {
		// TODO Auto-generated method stub
		return super.getResponse();
	}

	@Override
	public void close(PrintWriter out) {
		// TODO Auto-generated method stub
		super.close(out);
	}
	
	

}
