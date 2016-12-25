<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登陆</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link href="../../fonts/navfonts/FontAwesome/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" href="../../css/form-elements.css">
<link rel="stylesheet" href="../../css/style.css">

<script type="text/javascript" src="../../js/login.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- Favicon and touch icons -->




<title>登陆界面</title>
</head>
<body  onload="setData()">
	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">

				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">

						<div class="form-bottom">
							<div class="form-top">
								<a href="#"><img alt="" src="../../images/test.jpg" class="form-img-circle" ></a>
								
							</div>
							<h3  class="form-sign-text">Sign in to Rental</h3>
							<form role="form" action="" method="post" class="login-form" id="form">
								<div class="form-group">
									<label class="sr-only" for="phoneNum">phoneNum</label> 
									 <input
										type="text" name="phoneNum" placeholder="手机号码"
										class="form-username form-control" id="phoneNum"  onblur="isLoginPhoneNum()" maxlength="11">
								</div>
								
								<div class="form-group">
									<label class="sr-only" for="form-password">Password</label> <input type="password" name="user.password" placeholder="密码"
										class="form-password form-control" id="password" onkeyUp="checkLoginPassword()">
								</div>
								<button type="button" class="btn btn-primary btn-lg btn-block "  id="sub" onclick='login()'>Sign in!</button>
								
								<h4 class="login-error" id="login-error"></h4>
							</form>
						</div>
					</div>
				</div>
				<div class="form-sign-up" >
					<strong>New to GitHub? </strong><a href="../user_register.jsp">Create an account.</a>
					
				</div>
				
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 social-login">
						<h3 align="center">...or login with:</h3>
						<div class="social-login-buttons" align="center">
							<a class="btn btn-primary-qq btn-lg " href="#"> <i
								class="fa fa-qq"></i>QQ
							</a> <a class="btn btn-primary-wechat btn-lg " href="#"> <i
								class="fa fa-wechat"></i> 微信
							</a> <a class="btn btn-primary-weibo btn-lg " href="#"> <i
								class="fa fa-weibo"></i> 微博
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="../../js/jquery-1.11.0.min.js"></script>
	<script src="../../js/bootstrap.min.js"></script>
	<script src="../../js/jquery.backstretch.min.js"></script>
	<script src="../../js/scripts.js"></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>
</html>