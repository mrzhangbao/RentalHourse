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

<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet" />
<link href="../../css/admincss.css" rel="stylesheet">



<!-- 表格相关 -->
<link rel="stylesheet"
	href="../../css/bootstraptable/bootstrap-table.css">
<script src="../../js/bootstraptable/bootstrap-table.js"></script>
<script src="../../js/bootstraptable/bootstrap-table-zh-CN.js"></script>


<script type="text/javascript" src="../../js/adminjs/getCurrentUser.js"></script>

<style type="text/css">
.add {
	width: 100%;
	height: 100%;
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

		<h2 align="center">管理员信息列表</h2>
		<table id="tablesss"></table>


	</div>
	<script type="text/javascript">
		$('#tablesss').bootstrapTable({
			url : 'getAllAdmin.action',
			showHeader : true,
			pagination : true,
			paginationDetailHAlign : 'left',
			queryParamsType : 'limit',
			queryParams : queryParams,
			pageNumber : 1,
			pageSize : 10,
			dataType:'json',
			sidePagination : "server", 
			contentType : "application/x-www-form-urlencoded",
			method : 'post',
			 field:'rows',
			columns : [ {
				field : 'admin.id',
				title : '管理员ID'
			}, {
				field : 'admin.account',
				title : '账号'
			}, {
				field : 'admin.username',
				title : '名称'
			}, {
				field : 'admin.rank',
				title : '管理员等级'
			}, {
				field : 'admin.addtime',
				title : '创建时间'
			}, ]
		});
		


		function queryParams(params) {
			return {
				pageSize : params.limit,
				pageNumber : params.offset,

			}

		};
	</script>

</body>
</html>