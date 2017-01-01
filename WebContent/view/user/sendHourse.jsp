<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<title>房源发布</title>


<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../css/bootstrap.css" rel="stylesheet">

<link rel="stylesheet"
	href="../../css/common/jquery-labelauty-checkbox.css">
<link href="../../css/selectcity.css" rel="stylesheet">
<script src="../../js/jquery-3.1.1.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/bootstrap.min.js"></script>

<script src="../../js/adminjs/bootstrapValidator.js"></script>
<link href="../../css/adminjs/bootstrapValidator.css" rel="stylesheet" />

<!--  封装了form to json 的方法 -->
<script src="../../js/common/common.js"></script>
<script src="../../js/common/getLoginUser.js"></script>
<script type="text/javascript">
function getname() {
	var currUserPhone = getCookie("currLoginUser");
	alert("cookie="+getCookie("currLoginUser"));
}
</script>
<style type="text/css">
.body {
	background-color: #ffffff;
}

.radiocheck {
	width: 80%;
	height: 20%;
}

.radiocheck li {
	width: 10%;
	height: 2%;
}

ul {
	list-style-type: none;
}

li {
	display: inline-block;
}

li {
	margin: 10px 0;
}

input.labelauty+label {
	font: 16px "Microsoft Yahei";
	padding-right: 10px;
	color: #000000;
	margin-bottom: 5%;
}

.data {
	background-color: #ffffff;
	margin-left: 25%;
	margin-right: 25%;
	margin-top: 2%;
	margin-bottom: 2%;
	border-radius: 3%;
}
</style>



<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->



</head>
<body onload="getname()" style="background-color: #c0c0c0">



	<div class="data">

		<div class="row">
			<div class="col-md-10" style="margin-left: 8%">

				<h2 align="center">免费发布房源</h2>
				<div class="form-group">
					<label for="hourse_type">房源类型：</label>
					<ul class="dowebok" id="hourse_type">

						<li><input type="radio" checked="true" value="1"
							name="hourse_type" data-labelauty="租房"></li>
						<li><input type="radio" name="hourse_type" value="2"
							data-labelauty="商品房"></li>
						<li><input type="radio" name="hourse_type" value="3"
							data-labelauty="二手房"></li>
						<li><input type="radio" name="hourse_type" value="4"
							data-labelauty="写字楼"></li>
					</ul>
				</div>

				<form class="form-inline" id="cityForm">
					<div id="distpicker">
						<label for="select">所在城市：</label>
						<div class="form-group" id="select">
							<label class="sr-only" for="province">Province</label> <select
								class="form-control" name="province" id="province"></select>
						</div>
						<div class="form-group">
							<label class="sr-only" for="city">City</label> <select
								class="form-control" name="city" id="city"></select>
						</div>
						<div class="form-group">
							<label class="sr-only" for="district">District</label> <select
								class="form-control" name="district" id="district"></select>
						</div>
					</div>
				</form>

				<form id="sendHourse" role="form" class="form-signin"
					action="saveRentalHourse" method="post" style="margin-top: 3%">

					<div class="form-group">
						<label for="hourse_title">房源标题：</label><input class="form-control"
							type="text" name="hourse_title" id="hourse_title" />
					</div>
					<div class="form-group ">
						<label for="hourse_price">房源价格：</label><input class="form-control"
							type="text" name="hourse_price" id="hourse_price" />
					</div>
					<div class="form-group">
						<label for="hourse_floor">房源楼层：</label><input class="form-control"
							type="text" name="hourse_floor" id="hourse_floor" />
					</div>

					<div class="form-group">
						<label for="hourse_size">楼房大小：</label><input class="form-control"
							type="text" name="hourse_size" id="hourse_size" />
					</div>
					<div class="form-group">
						<label for="description">描述信息：</label>
						<s:textarea name="description" cols="85" rows="2">
						</s:textarea>
					</div>
					<div class="form-group">
						<button class="btn btn-lg btn-primary btn-block" type="submit">提交</button>

					</div>

				</form>



			</div>
		</div>


	</div>

	<script>
		window.jQuery
				|| document
						.write('<script src="../../js/jquery-3.1.1.js"><\/script>')
	</script>



	<script src="../../js/common/jquery-labelauty-checkbox.js"></script>
	<!--  城市数据js-->
	<script src="../../js/selectcity/distpicker.data.js"></script>
	<script src="../../js/selectcity/distpicker.js"></script>
	<script src="../../js/selectcity/main.js"></script>


	<script type="text/javascript">
		$(function() {
			/* 文档加载，执行一个函数*/
			$('#sendHourse').bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {/*input状态样式图片*/
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {/*验证：规则*/
					hourse_title : {//验证input项：验证规则
						message : '标题不是有效值',

						validators : {
							notEmpty : {//非空验证：提示消息
								message : '标题不能为空'
							},
							stringLength : {
								min : 1,
								max : 24,
								message : '标题必须在1到24之间'
							}
						}

					},
					hourse_price : {
						message : '价格无效',
						validators : {
							notEmpty : {
								message : '价格不能为空'
							},
							stringLength : {
								min : 1,
								max : 8,
								message : '不能超过50000000'
							},
							regexp : {
								regexp : /^[0-9]+$/,
								message : '只能输入数字'
							}
						}
					},
					hourse_floor : {
						message : '楼层无效',
						validators : {
							notEmpty : {
								message : '请输入所在楼层'
							},
							stringLength : {
								min : 1,
								max : 8,
								message : '楼层格式错误'
							}
						}
					},
					hourse_size : {
						message : '大小无效',
						validators : {
							notEmpty : {
								message : '请输入大小'
							},
						}
					},
					description : {//验证input项：验证规则
						message : 'The username is not valid',

						validators : {
							notEmpty : {//非空验证：提示消息
								message : '小技巧：对房子描述多一点，浏览的人会更多哟！'
							},
						}
					},

				}
			}).on('success.form.bv', function(e) {//点击提交之后

				var hourse_type = $('input[name="hourse_type"]:checked').val();

				var cityParams = {};
				cityParams = formToJsonstr('cityForm');

				var hourse_detail = {}

				hourse_detail = formToJsonstr('sendHourse');


				//构造上传json格式
				var data = {
						"user" : getCookie("currLoginUser"),
						"hourse_type" : JSON.stringify(hourse_type),
						"cityParams" : JSON.stringify(cityParams),
						"hourse_detail" : JSON.stringify(hourse_detail)
				};
			

				// Prevent form submission
				e.preventDefault();

				// Get the form instance
				var $form = $(e.target);

				// Get the BootstrapValidator instance
				var bv = $form.data('bootstrapValidator');
				$.ajax({
					url : $form.attr('action'),
					type : 'POST',
					async : true,
					data : data,
					success : function(data) {
						/* 成功后将用户名设置上去,如果该用户没有登陆，则跳转到登陆界面 */
						if (data == "false") {
							alert("请重新登陆系统");
							window.parent.location.href = 'login.jsp';

						} else {
							alert("保存成功");
						}
					},
					error : function() {
						alert("系统维护中....");
						window.parent.location.href = 'login.jsp';
					}
				});

			});
		});
	</script>



	<script>
		/* 初始化单选框和复选框 */
		$(function() {
			$(':input').labelauty();
		});
	</script>



</body>
</html>