<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE >
<html>
<head>
<title>闲租后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="../../css/bootstrap.css">
<!-- 使用FontAwesome 框架的字体图标，详情浏览： http://www.bootcss.com/p/font-awesome/#whats-new-->
<link href="../../fonts/fontAwesome/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="../../css/admincss/sidebar-menu.css">
<link href="../../css/admincss.css" rel="stylesheet">
<style type="text/css">
.main-sidebar {
	position: absolute;
	top: 0;
	left: 0;
	height: 100%;
	min-height: 100%;
	width: 230px;
	z-index: 810;
	background-color: #222d32;
}
</style>
<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body>


		<aside class="main-sidebar">

			<section class="sidebar">

				<ul class="sidebar-menu">
					<li class="header"><img class="admin-logo-img" alt=""
						src="http://img1.gtimg.com/comic/pics/hv1/62/234/2157/140318657.jpg"></li>
					<li class="header">闲租后台管理系统</li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>主页</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> Dashboard
									v1</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> Dashboard
									v2</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-files-o"></i>
							<span>数据分析</span> <span class="label label-primary pull-right">4</span>
					</a>
						<ul class="treeview-menu" style="display: none;">
							<li><a href="#"><i class="fa fa-circle-o"></i> Top
									Navigation</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> Boxed</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> Fixed</a></li>
							<li class=""><a href="#"><i class="fa fa-circle-o"></i>
									Collapsed Sidebar</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i class="fa fa-th"></i>
							<span>用户管理</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> 用户列表</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 用户修改</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 用户删除</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> Inline
									charts</a></li>
						</ul></li>


					<li class="treeview"><a href="#"> <i
							class="fa fa-pie-chart"></i> <span>信息审核</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> 房源审核</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 实名审核</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 公司审核</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 审核记录</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-envelope"></i> <span>消息列表</span><small
							class="label pull-right label-warning">32</small>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> 消息列表</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 活动通知</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 消息推送</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 用户反馈</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 消息管理</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> Modals</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-edit"></i>
							<span>房源管理</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> 房源信息</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 信息更改</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 房源下架</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 房源配置</a></li>
						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-edit"></i>
							<span>房源合作</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> 房源信息</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 信息更改</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 房源发布</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 房源下架</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 房源配置</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i class="fa fa-table"></i>
							<span>房源推荐</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> 推荐列表</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 推荐更新</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 推荐发布</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 推荐下架</a></li>
						</ul></li>
				
					
					<li class="treeview"><a href="#"> <i class="fa fa-th"></i>
							<span>后台管理</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="adminList.jsp" target="body"><i class="fa fa-circle-o"></i> 管理员列表</a></li>
							<li><a href="addAdmin.jsp" target="body"><i class="fa fa-circle-o"></i> 管理员添加</a></li>
							<li><a href="updateAdmin.jsp" target="body"><i class="fa fa-circle-o"></i> 管理员修改</a></li>
							<li><a href="deleteAdmin.jsp" target="body"><i class="fa fa-circle-o"></i> 管理员删除</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
							<span>系统管理</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> 系统版本</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 系统日志</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 推荐房源图片</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> Register</a></li>

						</ul></li>
					<li class="treeview"><a href="#"> <i class="fa fa-share"></i>
							<span>文件管理</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> 房源图片</a></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 用户头像 <i
									class="fa fa-angle-left pull-right"></i></a>
								<ul class="treeview-menu">
									<li><a href="#"><i class="fa fa-circle-o"></i> Level
											Two</a></li>
									<li><a href="#"><i class="fa fa-circle-o"></i> Level
											Two <i class="fa fa-angle-left pull-right"></i></a>
										<ul class="treeview-menu">
											<li><a href="#"><i class="fa fa-circle-o"></i> Level
													Three</a></li>
											<li><a href="#"><i class="fa fa-circle-o"></i> Level
													Three</a></li>
										</ul></li>
								</ul></li>
							<li><a href="#"><i class="fa fa-circle-o"></i> 垃圾回收</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-book"></i> <span>Documentation</span></a></li>
					<li class="header">LABELS</li>
					<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
					<li><a href="#"><i class="fa fa-circle-o text-yellow"></i>
							<span>Warning</span></a></li>
					<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
				</ul>
			</section>
		</aside>







	<script>
		window.jQuery
				|| document
						.write('<script src="../../js/jquery-3.1.1.js"><\/script>')
	</script>
	<script src="../../js/adminjs/sidebar-menu.js"></script>

	<script>
		$.sidebarMenu($('.sidebar-menu'))
	</script>
</body>
</html>