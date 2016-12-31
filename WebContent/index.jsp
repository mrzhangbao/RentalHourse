<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>爱租主页</title>


<!-- 使用FontAwesome 框架的字体图标，详情浏览： http://www.bootcss.com/p/font-awesome/#whats-new-->
<link href="fonts/fontAwesome/font-awesome.css" rel="stylesheet">
<!-- Font Style -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700'
	rel='stylesheet' type='text/css'>
<!-- Animate -->
<link href="css/animate.css" rel="stylesheet">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Bootsnav -->
<link href="css/bootsnav.css" rel="stylesheet">
<link href="css/overwrite.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="skins/color.css" rel="stylesheet">

<!-- Tab 相关 -->
<link rel="stylesheet" type="text/css" href="css/tabnormalize.css" />
<link href="css/tabstyle.css" rel="stylesheet">
<script src="js/prefixfree.min.js"></script>


<!-- 城市相关 -->

<link href="css/bootstrap.css" rel="stylesheet">


<link href="css/selectcity.css" rel="stylesheet">

<script>
	var mypcas = new PCAS("org_province,请选择省份", "org_city,请选择城市",
			"org_area,请选择县区");
	layui.use([ 'form' ], function() {
		var form = layui.form();
		var province;
		form.on('select(org_province)', function(data) {
			console.log(data.elem); //得到select原始DOM对象
			console.log(data.value); //得到被选中的值
			province = data.value;
			mypcas.SetValue(data.value, "", "");
			form.render('select');
		});
		form.on('select(org_city)', function(data) {
			console.log(data.elem); //得到select原始DOM对象
			console.log(data.value); //得到被选中的值
			mypcas.SetValue(province, data.value, "");
			form.render('select');
		});
	});
</script>



<script src="js/index.js"></script>
<link href="css/showdata.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	  <script src="js/html5shiv.min.js"></script>
	  <script src="js/respond.min.js"></script>
	<![endif]-->
<title>Insert title here</title>
</head>


<body id="home">


	<!-- Start Home -->
	<div class="pageheader">
		<div class="container">
			<h2 class="title">爱生活，爱闲租</h2>
			<p>Love Rental hourse</p>
		</div>
	</div>
	<!-- End Home -->
	<!-- Start Navigation -->
	<nav class="navbar navbar-default navbar-sticky bootsnav">
		<!-- Start Top Search -->
		<div class="top-search">
			<div class="container">

				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-search"></i></span>
					<input type="text" class="form-control" placeholder="Search"
						id="search-data"> <span
						class="input-group-addon close-search" id="search-close"><i
						class="fa fa-times"></i></span>

					<button class="btn" onclick='search()'>确定</button>
				</div>
			</div>
		</div>
		<!-- End Top Search -->

		<div class="container">
			<!-- Start Atribute Navigation -->
			<div class="attr-nav">
				<ul>

					<li class="search"><a href="#"><img alt=""
							src="images/search_26.png"></a></li>

					<li class="dropdown pull-right"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><img alt=""
							src="images/user_normal_35.png"></a>
						<ul class="dropdown-menu cart-list">
							<li><a href="#"><span class="fa fa-user"></span>
									&nbsp个人信息</a></li>

							<li><a href="#"><span class="fa fa-user-plus"></span>
									&nbsp任务安排</a></li>

							<li><a href="#"><span class="fa fa-power-off"></span>
									&nbsp退出系统</a></li>
						</ul></li>



					<%-- <!-- 仿照购物车功能 -->
					 <li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <i class="fa fa-comment"></i> <span
							class="badge">3</span>
					</a>
						<ul class="dropdown-menu cart-list">
							<li><a href="#" class="photo"><img
									src="../images/thumb/thumb01.jpg" class="cart-thumb" alt="" /></a>
								<h6>
									<a href="#">Delica omtantur </a>
								</h6>
								<p>
									2x - <span class="price">$99.99</span>
								</p></li>
							<li><a href="#" class="photo"><img
									src="../images/thumb/thumb02.jpg" class="cart-thumb" alt="" /></a>
								<h6>
									<a href="#">Omnes ocurreret</a>
								</h6>
								<p>
									1x - <span class="price">$33.33</span>
								</p></li>
							<li><a href="#" class="photo"><img
									src="../images/thumb/thumb03.jpg" class="cart-thumb" alt="" /></a>
								<h6>
									<a href="#">Agam facilisis</a>
								</h6>
								<p>
									2x - <span class="price">$99.99</span>
								</p></li>
							<li class="total"><span class="pull-right"><strong>Total</strong>:
									$0.00</span> <a href="#" class="btn btn-default btn-cart">Cart</a></li>
						</ul></li> 
 --%>

				</ul>
			</div>
			<!-- End Atribute Navigation -->

			<!-- Start Header Navigation -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-menu">
					<i class="fa fa-bars"></i>
				</button>
				<!-- 显示logo  属性可以到index.css中修改 -->
				<div class="nav-logo">
					<div class="nav-logo-img">
						<!-- <img src="images/logo_64.png" alt=""> -->
						<img alt=""
							src="http://stacdn201.ganjistatic1.com/src/app/ms_v2/housing_v2/html/images/logo.png">
					</div>
					<!-- 城市操作     开始-->
					<div class="selectcity">
						<!-- 按钮触发模态框 -->
						<div class="city-position">
							<button class="city-button" data-toggle="modal"
								data-target="#myModal" id="current-city">广州市</button>
						</div>

						<!-- 模态框（Modal） -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel" align="center">城市选择</h4>
									</div>
									<div class="modal-body">
										<div class="docs-methods" id="div">
											<form class="form-inline">
												<div id="distpicker">
													<div class="form-group">
														<label class="sr-only" for="province">Province</label> <select
															class="form-control" id="province"></select>
													</div>
													<div class="form-group">
														<label class="sr-only" for="city">City</label> <select
															class="form-control" id="city"></select>
													</div>
													<div class="form-group">
														<label class="sr-only" for="district">District</label> <select
															class="form-control" id="district"></select>
													</div>
													<div class="form-group">
														<button class="btn btn-primary" id="reset" type="button">Reset</button>

													</div>
												</div>
											</form>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button>
										<button type="button" class="btn btn-primary"
											data-dismiss="modal" onclick='setCity()'>提交更改</button>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>

						</div>
					</div>
				</div>



			</div>
			<!-- End Header Navigation -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-menu">
				<ul class="nav navbar-nav navbar-right" data-in="fadeInDown"
					data-out="fadeOutUp">
					<li><a href="#">首页</a></li>
					<li><a href="#">租房</a></li>
					<li class="dropdown megamenu-fw"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown">新房</a>
						<ul class="dropdown-menu megamenu-content" role="menu">
							<li>
								<div class="row">
									<div class="col-menu col-md-3">
										<h6 class="title">Title Menu One</h6>
										<div class="content">
											<ul class="menu-col">
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
											</ul>
										</div>
									</div>
									<!-- end col-3 -->
									<div class="col-menu col-md-3">
										<h6 class="title">Title Menu Two</h6>
										<div class="content">
											<ul class="menu-col">
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
											</ul>
										</div>
									</div>
									<!-- end col-3 -->
									<div class="col-menu col-md-3">
										<h6 class="title">Title Menu Three</h6>
										<div class="content">
											<ul class="menu-col">
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
											</ul>
										</div>
									</div>
									<div class="col-menu col-md-3">
										<h6 class="title">Title Menu Four</h6>
										<div class="content">
											<ul class="menu-col">
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
												<li><a href="#">Custom Menu</a></li>
											</ul>
										</div>
									</div>
									<!-- end col-3 -->
								</div> <!-- end row -->
							</li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">二手房</a>
						<ul class="dropdown-menu">
							<li><a href="#">Custom Menu</a></li>
							<li><a href="#">Custom Menu</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Sub Menu</a>
								<ul class="dropdown-menu">
									<li><a href="#">Custom Menu</a></li>
									<li><a href="#">Custom Menu</a></li>
									<li class="dropdown"><a href="#" class="dropdown-toggle"
										data-toggle="dropdown">Sub Menu</a>
										<ul class="dropdown-menu">
											<li><a href="#">Custom Menu</a></li>
											<li><a href="#">Custom Menu</a></li>
											<li><a href="#">Custom Menu</a></li>
											<li><a href="#">Custom Menu</a></li>
										</ul></li>
									<li><a href="#">Custom Menu</a></li>
								</ul></li>
							<li><a href="#">Custom Menu</a></li>
							<li><a href="#">Custom Menu</a></li>
							<li><a href="#">Custom Menu</a></li>
							<li><a href="#">Custom Menu</a></li>
						</ul></li>
					<li><a href="#">写字楼</a></li>
					<li><a href="#">头条</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>
	<!-- End Navigation -->

	<div class="clearfix"></div>
	<!-- Start Demo -->

	<div class="content">
		<!-- 筛选栏  -->
		<!-- <div id="iframepageScreen" class="screen">
			<iframe src="view/screen.jsp" id="iframepage" frameborder="0"
				scrolling="no" width="100%" marginheight="0" marginwidth="0"></iframe>

		</div> -->

		<div class="content-info">
			<!-- 租房信息显示，样式可以在index.css中修改-->
			<div class="information">

				<div class="information-cen">
					<div id="iframepages">
						<iframe src="view/tabMenuRental.jsp" id="iframepage"
							frameborder="0" scrolling="no" width="100%" height="80px"
							marginheight="0" marginwidth="0"></iframe>

					</div>
					<s:iterator value="#list">
						<div class="data">

							<div class="data-left">
								<div class="data-left-img">
									<img class="data-img"
										src="http://img1.gtimg.com/comic/pics/hv1/61/234/2157/140318656.jpg"></img>
								</div>
							</div>
							<div class="data-center">
								<div class="data-tables">
									<table class="data-table">
										<tr>
											<td colspan="6" class="data-table-td-title"><s:property
													value="%{title}" /></td>
										</tr>
										<tr>
											<td class="data-table-td-border"><s:property
													value="%{rentalType}" /></td>
											<td class="data-table-td-border"><s:property
													value="%{layout}" /></td>
											<td class="data-table-td-border"><s:property
													value="%{size}" /></td>
											<td class="data-table-td-border"><s:property
													value="%{direction}" /></td>
											<td class="data-table-td-border"><s:property
													value="%{floor}" /></td>
											<td><s:property value="%{decoration}" /></td>
										</tr>
										<tr>
											<td class="data-table-td">位置：</td>
											<td colspan="5" class="data-table-td"><s:property
													value="%{address}" /></td>
										</tr>
										<tr>
											<td class="data-table-td">经济人：</td>
											<td><s:property value="%{agent}" /></td>
											<td class="data-table-td"><s:property value="%{role}" /></td>
										</tr>

									</table>
								</div>
							</div>
							<!-- 价格、时间信息显示           开始-->
							<div class="data-right">
								<div class="data-price">
									<div class="data-price-num">
										<s:property value="%{price}" />
									</div>
									<div class="data-price-unit">
										<s:property value="%{unit}" />
									</div>

								</div>

								<div class="data-time">
									<s:property value="%{time}" />
								</div>

							</div>
						</div>

					</s:iterator>
					<!-- 分页 -->
					<div class="pagination">

						<div id="callBackPager"></div>
					</div>

					<!-- 价格、时间信息显示 结束  -->
				</div>
				<!--  房源推荐信息显示   开始-->
				<div class="recommend">

					<s:iterator value="#recommend">
						<s:a href="http://www.baidu.com">
							<div class="recommend-img">
								<img class="recommend-data-img"
									src="http://img2.ph.126.net/ezex84jfduVMJtBn1WlIug==/2049982255483942661.jpg"></img>
							</div>
							<div class="recommend-info">
								<table>
									<tr>
										<td><s:property value="%{price}" /></td>
										<td><s:property value="%{address}" /></td>
									</tr>
									<tr>
										<td><s:property value="%{title}" /></td>

									</tr>

								</table>

							</div>
						</s:a>
					</s:iterator>
				</div>
				<!--  房源推荐信息显示    结束-->
			</div>


		</div>

	</div>



	<!-- End Demo -->

	<%-- <script src="http://libs.useso.com/js/jquery/1.11.0/jquery.min.js"
		type="text/javascript"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
	</script> --%>

	<script src="js/jquery-3.1.1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/bootsnav.js"></script>


	<!--  城市数据js-->
	<script src="js/selectcity/distpicker.data.js"></script>
	<script src="js/selectcity/distpicker.js"></script>
	<script src="js/selectcity/main.js"></script>

	<!-- 分页 -->
	<script src="js/extendPagination.js"></script>



	<script type="text/javascript" src="js/jquery-tab.js"></script>
	<script type="text/javascript">
		$(function() {
			// Calling the plugin
			$('.tab-group').tabify();
		})
	</script>



</body>
</html>