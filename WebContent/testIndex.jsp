<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type">
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- 引入bootstrap样式 -->
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>

<style type="text/css">
.logos{
width:20px;
height:20px;
	folat:left;
	clear:right;
	margin:0 0 0 3%;
	padding-top:2%
}
.menu{
float:left;

}
.clear{
clear:left;
}
</style>
<title>BootStrap Two</title>
</head>
<body>


	 <div >
		<div class="logos">
		<a href="#"  class="logo"><img src="images/logo4.png"  /></a>
		</div>
		
		<ul class="navTop nav-pills ">
			<li><a href="#" class="atop">首页</a></li>
			<li><a href="#" class="atop">租房</a></li>
			<li><a href="#" class="atop">新房</a></li>
			<li><a href="#" class="atop">二手房</a></li>
			<li><a href="#" class="atop">写字楼</a></li>
			<li><a href="#" class="atop">头条</a></li>
		</ul>

		<ul class="navTop nav-pills navbar-right">
			<li><a href="#"> 注册</a></li>
			<li><a href="#"> 登录</a></li>
		</ul>
		
	</div>




	<%-- <nav class="navbar navbar-default " role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> <img src="images/logo_1.png"
				class="img-rounded"></a>
		</div>

		<span class="link-copy"></span>
		<div class="navbar-header">
			<ul class="nav nav-pills">
				<li class="active"><a href="#" class="menu__link">Home</a></li>
				<li class="menu_item"><a href="#" class="menu__link">SVN</a></li>
				<li class="menu_item"><a href="#" class="menu__link">iOS</a></li>
				<li class="menu_item"><a href="#" class="menu__link">VB.Net</a></li>
				<li class="menu_item"><a href="#" class="menu__link">Java</a></li>
				<li class="menu_item"><a href="#" class="menu__link">PHP</a></li>
			</ul>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>
					注册</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
					登录</a></li>
		</ul>
	</div>
	</nav>
 --%>


</body>
</html>