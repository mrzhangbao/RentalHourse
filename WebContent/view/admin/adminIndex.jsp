<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>闲租后台管理系统</title>
<!-- Bootstrap Core CSS -->
<link href="../../css/bootstrap.css" rel="stylesheet">
<script type="text/javascript">
	
</script>
</head>
 <!-- <frameset rows="14%,*"   >
	<frame src="view/admin/top.jsp" name="top" scrolling="no">
		
</frameset>  -->

<frameset cols="18.2%,*" frameborder="no" border="0" framespacing="0">
	<frame src="view/admin/sidemenu.jsp" name="left">
	<frame src="view/admin/body.jsp" name="body" noresize="noresize">
</frameset>

</html>