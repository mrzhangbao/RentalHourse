<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>显示数据</title>

<link href="../css/showdata.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link rel="stylesheet" href="../css/bootstrap.min.css">


<script src="../js/index.js"></script>
<script src="../js/layer.js"></script>

<script src="../js/jquery-3.1.1.js"></script>
<script src="../js/bootstrap.min.js"></script>

<link rel="stylesheet" href="../css/bootstraptable/bootstrap-table.css">
<script src="../js/bootstraptable/bootstrap-table.js"></script>
 <script src="../js/bootstraptable/bootstrap-table-zh-CN.js"></script> 

<link href="../css/selectcity.css" rel="stylesheet">



</head>
<body>

	<button class="button" id="test" onclick="test()">点击</button>


	<div class="data">

		<div class="data-left">
			<div class="data-left-img"></div>
		</div>
		<div class="data-center">
			<div class="data-tables">
				<table class="data-table">
					<tr>
						<td colspan="6">100</td>
					</tr>
					<tr>
						<td class="data-table-td-border">整租</td>
						<td class="data-table-td-border">1室1厅1卫</td>
						<td class="data-table-td-border">40m</td>
						<td class="data-table-td-border">东南</td>
						<td class="data-table-td-border">3/8层</td>
						<td>精装修</td>

					</tr>
					<tr>
						<td class="data-table-td">位置</td>
						<td colspan="5" class="data-table-td">惠城区-惠州学院-35栋</td>
					</tr>
					<tr>
						<td class="data-table-td">经济人：</td>
						<td>张先生</td>
						<td class="data-table-td">独立经济人</td>
					</tr>

				</table>
			</div>

		</div>
		<div class="data-right">
			<button>560元/月</button>
			<s:property value=" 560元/月"></s:property>
		</div>



	</div>

	<div class="models">
		<!-- 按钮触发模态框 -->
		<button class="btn btn-primary btn-lg" data-toggle="modal"
			data-target="#myModal" id="click">开始演示模态框</button>
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
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							onclick='test()'>提交更改</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>

		</div>
	</div>



	<button type="button" class="btn btn-success" title="Popover title"
		data-container="body" data-toggle="popover" data-placement="bottom"
		data-content=""></button>

	<button type="button" class="btn btn-success" onclick='show()'></button>



	<button type="submit" onclick="callBackPagination();"
		class="btn btn-default">提交</button>
	<div id="mainContent"></div>

	<div id="callBackPager"></div>
	
	
	
	<table data-toggle="table" data-url="data1.json" data-height="246"  data-sort-name="name" data-sort-order="desc">
    <thead>
        <tr>
            <th data-field="id" data-align="right" data-sortable="true">Item ID</th>
            <th data-field="name" data-align="center" data-sortable="true">Item Name</th>
            <th data-field="price" data-sortable="true">Item Price</th>
        </tr>
    </thead>
</table>


<table data-toggle="table" data-url="getInfoByServlet.action" data-pagination="true">
    <thead>
        <tr>
            <th data-field="id">中文</th>
            <th data-field="floor">Item Name</th>
            <th data-field="price">Item Price</th>
        </tr>
    </thead>
</table>





<table id="tablesss"></table>  
	<button class="btn btn-primary" id="button">getjjjj</button>
<script>  
    var $table = $('#tablesss');  
   
       
        $('#button').click(function () {  
           
        });  
   
</script>

	<table data-toggle="table" data-pagination="true">
		<thead>
			<tr>
				<th>Item ID</th>
				<th>Item Name</th>
				<th>Item Price</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>Item 1</td>
				<td>$1</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Item 2</td>
				<td>$2</td>
			</tr>
		</tbody>
	</table>


	<script type="text/javascript">
		
	</script>



	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/selectcity/distpicker.data.js"></script>
	<script src="../js/selectcity/distpicker.js"></script>
	<script src="../js/selectcity/main.js"></script>
	<script src="../js/extendPagination.js"></script>



	<%-- 	<div class="showData">
	
		<s:iterator value="#list">
			<div id="showproduct" class="">
				<s:a>
					<img id="img" alt="显示图片"
						src="<s:url action='showImages'><s:param name='name' value='uploadfile'></s:param></s:url>">
					<div id="market">
						价格:<s><s:property value="%{marketprice}"></s:property></s>
					</div>
					<div id="sell">
						促销价：
						<s:property value="%{sellprice}"></s:property>
					</div>

					<div id="productname">
						<s:property value="%{productname}"></s:property>
					</div>
					<div id="name">
						<s:a>
							<u>Kevin旗舰店</u>
						</s:a>
					</div>
				</s:a>
			</div>
		</s:iterator>

	</div> --%>


</body>
</html>