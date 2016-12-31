<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE >
<html>
<head>

<title>用户信息上传</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="../../js/jquery-3.1.1.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet">
<script src="../../js/bootstrap.js"></script>


<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet" />
<link href="../../css/admincss.css" rel="stylesheet">
<script src="../../js/common/getLoginUser.js"></script>

<!-- 表格相关 -->



<style type="text/css">
.userinfo {
	width: 60%;
	height: 80%;
	margin-top: 5%;
	margin-left: 15%;
}

.user_title {
	width: 20%;
}

.addAvatar {
	height: 30%;
	width: 30%;
	margin-top: 5%;
	margin-left: 40%;
}

.avatar-img {
	height: 50%;
	width: 45%;
}

.content {
	width: 60%;
	margin-left: 20%;
}
</style>
<script >
function sub(){
	alert("jajaj");
	alert("data:"+ $('#phoneNum').val());
	$.ajax({
		url : "updateUserAction",
		type : 'POST',
		async : true,
		data : {
			"user.id":$('#id').val(),
			"user.phoneNum":$('#phoneNum').val(),
			"email":$('#email').val(),
			"user.nickName":$('#nickName').val(),
			"user.realName":$('#realName').val(),
			"user.creditNum":$('#creditNum').val(),
			"user.company":$('#company').val(),
			"user.role":$('#role').val()
			
		},
		
		success : function(data) {
			/* 成功后将用户名设置上去,如果该用户没有登陆，则跳转到登陆界面 */
			if(data=="false"){
				alert("请重新登陆系统");
				window.parent.location.href='login.jsp';
				
			}else{
				alert("保存成功");
			}
		},
		error : function() {
			alert("系统维护中....");
			window.parent.location.href='login.jsp';
		}
	});
}

	
</script>
</head>
<body onload="getLoginCur()">

	<div class="content">
		<form action="updateUserAction" id="userForm" >

			<div class="form-group">
				<label for="id">用户ID</label> <input type="text" class="form-control"
					id="id" name="user.id"  disabled="true">
			</div>
			<div class="form-group">
				<label for="phoneNum">注册手机</label> <input type="text"
					class="form-control" name="user.phoneNum" id="phoneNum" disabled="true">
			</div>

			<div class="form-group">
				<label for="email">邮箱（信用分+5）</label> <input type="text"
					class="form-control" name="user.email" id="email">
			</div>

			<div class="form-group">
				<label for="nickName">昵称</label> <input type="text"
					class="form-control" name="user.nickName" id="nickName">
			</div>
			<div class="form-group">
				<label for="nickName">真实姓名(正确+10)</label> <input type="text"
					class="form-control" name="user.realName" id="realName">
			</div>
			<div class="form-group">
				<label for="creditNum">身份证号码(正确+10)</label> <input type="text"
					class="form-control" name="user.creditNum" id="creditNum">
			</div>
			<div class="form-group">
				<label for="company">公司名称</label> <input type="text"
					class="form-control" name="user.company" id="company">
			</div>
			<div class="form-group">
				<label for="role">当前角色</label> <input type="text"
					class="form-control" name="user.role" id="role" disabled="true">
			</div>

			<div class="form-group">
				<label for="collection">收藏数目</label> <input type="text"
					class="form-control" name="user.collection" id="collection"
					disabled="true">
			</div>

			<div class="form-group">
				<label for="creditScore">信用分数</label> <input type="text"
					class="form-control" name="user.creditScore" id="creditScore"
					disabled="true">
			</div>

				<button  class="btn btn-success" onclick='sub()' > 保存数据</button>
			
		</form>
		
	</div>
</body>
</html>