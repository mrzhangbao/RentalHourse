document.write("<script src='../../js/ajax.js'><"+'/'+"script>");
document.write("<script src='../js/jquery-3.1.1.js'><" + '/' + "script>");

/****
 * 这个js主要处理登陆过程的手机号码密码长度等检测
 */

	
	/**
	 * 加载页面的时候调用
	 */
function setData(){
	/**
	 * 将提交按钮设置为不可用
	 */
	var sign=document.getElementById("sub");
	sign.setAttribute("disabled", true);
}

/**
 * 登陆接口调用
 */
function login(){
	
	var url="loginLogin";//验证用户是否存在的Action 
	var phoneNum=document.getElementById("phoneNum").value;
	var password=document.getElementById("password").value;
	var data={"phoneNum":phoneNum,"password":password};
	var params = "info="+JSON.stringify(data);
	alert("info:"+params);
	sendRequest(url,params,'POST',loginResult);
}

function loginResult(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var info = xmlHttpRequest.responseText;
			if(info=="true"){
				//将用户信息存入cookie中
				var currentuser = getCookie("currLoginUser");
				if(currentuser!="" && currentuser!=null && typeof(currentuser)!="undefined"){
					delCookie("currLoginUser");
				}
					setCookie("currLoginUser",$('#phoneNum').val(),1);
				
				//登陆成功，跳转到用户界面
				window.location.href="userLoginIndex.jsp";
			}else{
				//info="true" 该号码未注册，可以进行注册
				alert("登陆失败，"+info);

			}

			}
	
	}
}

function getCur() {
	var currUserPhone = getCookie("currLoginUser");
	alert("cookie="+getCookie("currLoginUser"));
	if(currUserPhone==null){
		currUserPhone = "15711111111";
	}
	
	$.ajax({
		url : "getUserInformationLogin",
		type : 'POST',
		async : true,
		data : {
			"phoneNum" : currUserPhone
		},
		success : function(data) {
			/* 成功后将用户名设置上去,如果该用户没有登陆，则跳转到登陆界面 */
			if(data=="false"){
				alert("请重新登陆系统");
				window.parent.location.href='amlogin.jsp';
				
			}else{
				
			}
		},
		error : function() {
			alert("系统维护中....");
			window.parent.location.href='amlogin.jsp';
		}
	});
}




function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
	
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i].trim();
		if (c.indexOf(name) == 0)
			return c.substring(name.length, c.length);
	}
	return "";
}

function delCookie(cname) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(cname);
	if (cval != null)
		document.cookie = cname + "=" + cval + ";expires=" + exp.toGMTString();
}





//验证手机号码格式是否正确
function isLoginPhoneNum(){

	var phoneNum=document.getElementById("phoneNum").value;
	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	var error = document.getElementById("login-error");
	var sign=document.getElementById("sub");
	if(!myreg.test(phoneNum)){
		sign.setAttribute("disabled", true);
		error.innerHTML="手机号码格式错误";
		return false;
	}else{
		error.innerHTML="";
		return true;
	}
}


function checkLoginPassword(){
	
	if(isLoginPhoneNum()){
		var password=document.getElementById("password").value;
		var error = document.getElementById("login-error");
		var sign=document.getElementById("sub");
		if(password==null || password.length<6){
			
			error.innerHTML="密码不能少于6位";
			sign.setAttribute("disabled", true);
			return false;
		}else{
			error.innerHTML=" ";
			sign.removeAttribute("disabled");
			return true;
		}
	}
	
}