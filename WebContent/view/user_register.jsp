<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE >
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>注册</title>
<script src="../js/jquery-3.1.1.js"></script>

<script src=".../js/adminjs/login.js"></script>

<script src="../js/bootstrap.min.js"></script>
<link href="../css/bootstrap.css" rel="stylesheet" />

<script src="../js/adminjs/bootstrapValidator.js"></script>
<link href="../css/adminjs/bootstrapValidator.css" rel="stylesheet" />
<script type="text/javascript" src="../js/countdown.js"></script>
<style type="text/css">
body {
	background-color: #222d32;
	outline: none;
}

.welcome {
	color: #ffffff;
	font-size: 18px;
	margin-top: 2%;
}

.add {
	width: 45%;
	height: 78%;
	margin-left: 27%;
	margin-top: 2%;
	background-color: #ffffff;
	padding-top: 1%;
	padding-left: 3%;
	padding-right: 3%;
	border-radius: 2em;
}

.sendCode {
	margin-bottom: 3%;
	heigth: 5%;
}
</style>
</head>
<body>

	<div class="welcome">
		<h3 align="center">欢迎您加入我们</h3>
	</div>


	<div class="add">
		<form id="addForm" role="form" class="form-signin" action="addUserReg"
			method="post">
			<h4 class="form-signin-heading" align="center">注册信息</h4>

			<div class="form-group">
				<label for="phoneNum">手机号码：</label><input class="form-control"
					type="text" name="phoneNum" id="phoneNum" maxlength="11"
					placeholder="手机号码" />
			</div>
			<div class="form-group">
				<label for="password">密码：</label><input class="form-control"
					type="password" name="password" id="password" />
			</div>
			<div class="form-group">
				<label for="repassword">确认密码：</label><input class="form-control"
					type="password" name="repassword" id="repassword" />
			</div>

			<div class="form-group">
				<label for="code">验证码：</label><input class="form-control"
					type="text" name="code" id="code" />
			</div>

			<div class="sendCode input-group-lg">
				<input type="button" class="btn btn-primary" name="bt_getcode"
					id="code" onclick='sendCode(this)' value="点击获取验证码" />
			</div>
			<div class="form-group">
				<button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>
			</div>
		</form>

	</div>

	<script type="text/javascript">
		$(function() {

			/* 文档加载，执行一个函数*/
			$('#addForm')
					.bootstrapValidator(
							{
								message : 'This value is not valid',
								feedbackIcons : {/*input状态样式图片*/
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {/*验证：规则*/
									phoneNum : {//验证input项：验证规则
										message : 'The username is not valid',

										validators : {
											notEmpty : {//非空验证：提示消息
												message : '手机号码不能为空'
											},
											stringLength : {
												min : 11,
												max : 11,
												message : '11位数手机号码'
											},
											regexp : {
												regexp : /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/,
												message : '请输入有效的手机号码'
											}

										}

									},
									password : {
										message : '密码无效',
										validators : {
											notEmpty : {
												message : '密码不能为空'
											},
											stringLength : {
												min : 5,
												max : 20,
												message : '密码长度必须在5到20之间'
											},
											identical : {//相同
												field : 'repassword', //需要进行比较的input name值
												message : '两次密码不一致'
											},
											different : {//不能和用户名相同
												field : 'phoneNum',//需要进行比较的input name值
												message : '不能和用户名相同'
											},
										}
									},
									repassword : {
										message : '密码无效',
										validators : {
											notEmpty : {
												message : '密码不能为空'
											},
											stringLength : {
												min : 5,
												max : 20,
												message : '密码长度必须在5到20之间'
											},
											identical : {//相同
												field : 'password',
												message : '两次密码不一致'
											},
											different : {//不能和用户名相同
												field : 'phoneNum',
												message : '不能和用户名相同'
											},
										}
									},
									code : {//验证input项：验证规则
										message : 'The username is not valid',

										validators : {
											notEmpty : {//非空验证：提示消息
												message : '验证码不能为空'
											},
											stringLength : {
												min : 6,
												max : 6,
												message : '请输入6位数的验证码'
											},

										}
									},

								}
							}).on(
							'success.form.bv',
							function(e) {//点击提交之后
								// Prevent form submission
								e.preventDefault();

								// Get the form instance
								var $form = $(e.target);

								// Get the BootstrapValidator instance
								var bv = $form.data('bootstrapValidator');

								// Use Ajax to submit form data 提交至form标签中的action，result自定义
								$.post($form.attr('action'), $form.serialize(),
										function(result) {
											history.go(0);//刷新当前页面
											alert(result);

										});
							});
		});
	</script>

</body>
</html>