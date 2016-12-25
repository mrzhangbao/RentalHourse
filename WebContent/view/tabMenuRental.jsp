<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>tabRental</title>
<!-- Tab 相关 -->
<link rel="stylesheet" type="text/css" href="../css/tabnormalize.css" />
<link href="../css/tabstyle.css" rel="stylesheet">
<script src="../js/prefixfree.min.js"></script>
<script src="../js/index.js"></script>
</head>
<body>

	<div class="tabcontainer">
		<div class="tab-group">
			<section id="tab1" title="全部房源" > </section>
			<section id="tab2" title="个人"> </section>
			<section id="tab3" title="经济人"> </section>
			<section id="tab4" title="品牌公寓"> </section>

		</div>
	</div>
	
	
	<script src="http://libs.useso.com/js/jquery/1.11.0/jquery.min.js"
		type="text/javascript"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../js/jquery-1.11.0.min.js"><\/script>')
	</script>



	<script type="text/javascript" src="../js/jquery-tab.js"></script>
	<script type="text/javascript">
		$(function() {
			// Calling the plugin
			$('.tab-group').tabify();
		})
	</script>
</body>
</html>