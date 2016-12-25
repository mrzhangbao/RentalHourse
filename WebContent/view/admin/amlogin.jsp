<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String msg = (String) ActionContext.getContext().get("msg");
%>

<!DOCTYPE >
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>闲租管理系统</title>

<script src="../../js/jquery-3.1.1.js"></script>

<script src="../../js/adminjs/login.js"></script>
<script src="../../js/adminjs/admin.js"></script>

<script src="../../js/ajax.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet" />

<script src="../../js/adminjs/bootstrapValidator.js"></script>
<link href="../../css/adminjs/bootstrapValidator.css" rel="stylesheet" />



</head>
<body>

	<div class="container" id="loginmodel">
		<!-- class都是bootstrap定义好的样式，验证是根据input中的name值 -->
		<form id="loginForm" method="post" class="form-horizontal"
			action="loginAdmin">
			<!-- 下面这个div必须要有，插件根据这个进行添加提示 -->
			<div class="form-group">
				<label class="col-lg-3 control-label">Username</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" name="account" id="account" value="admin" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-lg-3 control-label">Password</label>
				<div class="col-lg-5">
					<input type="password" class="form-control" name="password" value="123456" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3">
					<button type="submit" id="log" class="btn btn-primary">Sign
						up</button>
				</div>
			</div>
		</form>
	</div>
	 <!-- 临时表单  -->
	<div style="display: none">
		<form method="post" action="checkAdmin" id="form">
			<input type="text" name="adminEntity.account" id="acc" /> 
			<input type="password" name="adminEntity.password" id="pas" />
		</form>
	</div>





</body>
</html>