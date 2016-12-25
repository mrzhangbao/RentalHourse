<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>闲租后台管理系统</title>
<!-- 使用FontAwesome 框架的字体图标，详情浏览： http://www.bootcss.com/p/font-awesome/#whats-new-->
<link href="../../fonts/fontAwesome/font-awesome.css" rel="stylesheet">

<link href="../../css/bootstrap.css" rel="stylesheet">
<link href="../../css/admincss.css" rel="stylesheet">
<script type="text/javascript" src="../../js/adminjs/admin.js"></script>

<script src="../../js/jquery-3.1.1.js"></script>
<script src="../../js/bootstrap.js"></script>
 <script type="text/javascript" src="../../js/adminjs/getCurrentUser.js"></script> 

<style type="text/css">
.bodys{
	margin-right:12%;
}
</style>
</head>
<body onload="getCur()" >

	<div class="admin-body">
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
	</div>




</body>
</html>