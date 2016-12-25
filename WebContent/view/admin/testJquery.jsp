<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆</title>
<script src="../../js/jquery-3.1.1.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet" />
<script type="text/javascript">
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

function checkCookie() {
	var user = getCookie("username");
	
	if (user != "") {
		alert("Welcome again " + user);
	} else {
		user = prompt("Please enter your name:", "");
		if (user != "" && user != null) {
			alert("usr:"+user);
			setCookie("username", user, 365);
			
		}
	}
}

</script>
<script type="text/javascript">
function log(){
	checkCookie()
	 /* $.ajax({  
         type : "POST",  //提交方式  
         url : "loginAdmin",//路径  
         data : $('#form').serialize(),
        	 
       		//数据，这里使用的是Json格式进行传输  
         success : function(result) {//返回数据根据结果进行相应的处理  
        	 alert("msg:"+result);
             if ( result.success ) {  
                 alert("成功");
                
             } else {  
                 alert("失败");  
             }  
         }  
     });   */
	
}

</script>
</head>
<body>




<form class="form-horizontal" role="form" id="form" action="testAdmin">
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">名字</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="account" name="account"
				   placeholder="请输入名字">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">姓</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="password" name="password"
				   placeholder="请输入姓fdsf">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default" >登录</button>
		</div>
	</div>
</form>








<form class="form-horizontal" role="form" id="form">
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">名字</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="account" name="account"
				   placeholder="请输入名字">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">姓</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="password" name="password"
				   placeholder="请输入姓">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-default" onclick='log()'>登录</button>
		</div>
	</div>
</form>

</body>
</html>