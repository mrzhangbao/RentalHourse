<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<% String path=request.getParameter("path"); %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<title>个人信息菜单</title>

<script src="../../js/jquery-3.1.1.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet">
<script src="../../js/bootstrap.js"></script>


<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet" />
<link href="../../css/common/userpersonal.css" rel="stylesheet" />
<script src="../../js/common/getLoginUser.js"></script>

<script type="text/javascript">
function getUserData() {
	var currUserPhone = getCookie("currLoginUser");
	alert("cookieuserifno="+getCookie("currLoginUser"));
	if(currUserPhone==null){
		alert("请重新登陆系统");
		window.parent.location.href='login.jsp';
	}
	
	$.ajax({
		url : "getUserDataAction",
		type : 'POST',
		async : true,
		data : {
			"phoneNum" : currUserPhone
		},
		success : function(data) {
			/* 成功后将用户名设置上去,如果该用户没有登陆，则跳转到登陆界面 */
			if(data=="false"){
				alert("请重新登陆系统");
				window.parent.location.href='login.jsp';
				
				
			}else{
				var user=JSON.parse(data);
				$('#nickName').val(user.nickName);
				var path = "http://localhost:8080/RentalHourse/"+"showAvatarAction?filename="+user.avatar;
				$("#avatar").attr('src', path);
				
				
			}
		},
		error : function() {
			alert("系统维护中....");
			window.parent.location.href='login.jsp';
		}
	});
}

function backToIndex(){
	window.parent.location.href='userLoginIndex.jsp';
}
</script>
 

</head>
<body onload="getUserData()">
	<div class="content">
		<div class="avatar">
			<div class="avatar-img">
			
				<!-- <img alt="" src="../../images/test.jpg"> -->
			<img id = "avatar" alt="" src="">
			
			</div>
			<a   id="nickName" href=""></a> 
			<h3 align="center">个人中心</h3>
		</div>
		<div class="menu">

			<ul class="list-group">
				<li class="list-group-item"><a href="javascript:backToIndex();"> 主页</a></li>
				<li class="list-group-item"><a href="">我的发布</a></li>
				<li class="list-group-item"><a href=""> 我的消息</a></li>
				<li class="list-group-item"><a href="">我的收藏</a></li>
				<li class="list-group-item"><a href="userinfo.jsp" target="body"> 个人资料</a></li>
				<li class="list-group-item"><a href="avatar.jsp" target="body">更改头像</a></li>
			</ul>
		</div>
	</div>
	
</body>
</html>