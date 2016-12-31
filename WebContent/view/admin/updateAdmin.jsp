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
		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<table id="tablesss">


		</table>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel" align="center">管理员信息</h4>
					</div>
					<div class="modal-body">


						<form id="updateForm"  
							action="updateAdmin" method="post">
					

							<div class="form-group">
								<label for="id">管理员ID：</label><input class="form-control"
									type="text" name="id" id="id" disabled="true"  />
							</div>
							<div class="form-group">
								<label for="adminname">名称：</label><input class="form-control"
									type="text" name="adminname" id="adminname"  />
							</div>
							<div class="form-group">
							<label for="repassword">等级：</label>
								<select name="rank" id="rank" class="form-control">
									<option value="2">普通管理员</option>
									<option value="1">超级管理员</option>

								</select>
							</div>
						</form>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary"  onclick='commit()'>提交更改</button>
						
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>


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
			dataType : 'json',
			sidePagination : "server",
			contentType : "application/x-www-form-urlencoded",
			method : 'post',
			field : 'rows',
			toolbar : '#toolbar',
			clickToSelect : true,
			checkboxHeader : true,

			toolbarAlign : 'left',
			columns : [ {
				checkbox : true,
			}, {
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
			}, ],
			/* 监听行的点击事件，row为行数据，$element为<tr>属性 */
			onClickRow : function(row, $element) {
				/* 弹窗并传入数据，可以进行数据的更改 */
				showModel(row);
			}

		});
		/* 分页的提交*/
		function queryParams(params) {
			return {
				pageSize : params.limit,
				pageNumber : params.offset,

			}

		};

		function showModel(data) {
			$('#id').val(data.admin.id);
			 $('#adminname').val(data.admin.username); 
			 $('#rank').val(data.admin.rank);
			$('#myModal').modal('show');
			
		}
		/*提交更改后的数据*/
		function commit(){
			$('#myModal').modal('hide');
			
			$.ajax({
				url:'updateAdmin',
				type:'POST',
				async:true,
				data:{"id":$('#id').val(),"username":$('#adminname').val(),"rank":$('#rank').val()},
				success:function(data){
					alert(data);
					history.go(0);//刷新当前页面
				}
			});
				
		}
	</script>

</body>
</html>