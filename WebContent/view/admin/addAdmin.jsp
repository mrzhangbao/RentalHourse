<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理员添加</title>
<script src="../../js/jquery-3.1.1.js"></script>

<script src="../../js/adminjs/login.js"></script>
<script src="../../js/adminjs/admin.js"></script>

<script src="../../js/ajax.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet" />
<link href="../../css/admincss.css" rel="stylesheet">

<script src="../../js/adminjs/bootstrapValidator.js"></script>
<link href="../../css/adminjs/bootstrapValidator.css" rel="stylesheet" />
 <script type="text/javascript" src="../../js/adminjs/getCurrentUser.js"></script> 

<script type="text/javascript">
	$(function() {
		
		/* 文档加载，执行一个函数*/
		$('#addForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/*input状态样式图片*/
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {/*验证：规则*/
				account : {//验证input项：验证规则
					message : 'The username is not valid',

					validators : {
						notEmpty : {//非空验证：提示消息
							message : '账号不能为空'
						},
						stringLength : {
							min : 5,
							max : 12,
							message : '用户名长度必须在5到12之间'
						},regexp: {
	                         regexp:  /^[A-Za-z0-9]+$/,
	                         message: '只能输入字母或数字的组合'
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
							field : 'account',//需要进行比较的input name值
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
							field : 'account',
							message : '不能和用户名相同'
						},
					}
				},
				username : {//验证input项：验证规则
					message : 'The username is not valid',

					validators : {
						notEmpty : {//非空验证：提示消息
							message : '昵称不能为空'
						},
						stringLength : {
							min : 2,
							max : 12,
							message : '昵称长度必须在2到12之间'
						},

					}
				},

			}
		}).on('success.form.bv', function(e) {//点击提交之后
			// Prevent form submission
			e.preventDefault();

			// Get the form instance
			var $form = $(e.target);

			// Get the BootstrapValidator instance
			var bv = $form.data('bootstrapValidator');

			// Use Ajax to submit form data 提交至form标签中的action，result自定义
			$.post($form.attr('action'), $form.serialize(), function(result) {
				if(result=="账号已存在"){
					
				}else{
					history.go(0);//刷新当前页面
				}
				alert("" + result);
				
				
			});
		});
	});
</script>
<style type="text/css">
.add {
	width: 50%;
	height: 30%;
	margin-left: 25%;
}
</style>
</head>
<body onload="getCur()">
<div class="admin-top">
			<div class="admin-top-user">
				<ul class="admin-nav nav-tabs">


					<li class="dropdown  pull-left"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><img class="admin-avatar"
							alt=""
							src="http://img1.gtimg.com/comic/pics/hv1/62/234/2157/140318657.jpg"><span
							id="username"></span> <span class="caret"></span> </a>
						<ul class="dropdown-menu">
							<li><a href="#"><span class="fa fa-user"></span>
									&nbsp个人信息</a></li>
							<li class="divider"></li>
							<li><a href="#"><span class="fa fa-tasks"></span>
									&nbsp任务安排</a></li>
							<li class="divider"></li>
							<li><a href="#"><span class="fa fa-power-off"></span>
									&nbsp退出系统</a></li>
						</ul></li>
				</ul>
			</div>

			<div class="admin-msg">
				<h3 align="center">闲租后台管理系统</h3>
			</div>


		</div>


	<div class="add">


		<form id="addForm" role="form" class="form-signin" action="addAdmin"
			method="post">
			<h3 class="form-signin-heading" align="center">管理员信息：</h3>

			<div class="form-group">
				<label for="username">账号：</label><input class="form-control"
					type="text" name="account" id="account" />
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
				<label for="username">名字：</label><input class="form-control"
					type="text" name="username" id="username" />
			</div>
			<div class="form-group">
				<select name="rank" id="rank" class="form-control">
					<option value="2">普通管理员</option>
					<option value="1">超级管理员</option>

				</select>
			</div>

			<div class="form-group">
				<button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>
				
			</div>
		</form>

	</div>
	<script type="text/javascript"></script>

</body>
</html>