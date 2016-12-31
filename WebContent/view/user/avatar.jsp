<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>更改头像</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script src="../../js/jquery-3.1.1.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet">
<script src="../../js/bootstrap.js"></script>


<script src="../../js/bootstrap.min.js"></script>
<link href="../../css/bootstrap.css" rel="stylesheet" />
<link href="../../css/admincss.css" rel="stylesheet">
<script src="../../js/common/getLoginUser.js"></script>
<!-- include -->
<script>
	function PreviewImage(imgFile) {
		var pattern = /(\.*.jpg$)|(\.*.png$)|(\.*.jpeg$)|(\.*.gif$)|(\.*.bmp$)/;
		if (!pattern.test(imgFile.value)) {
			alert("系统仅支持jpg/jpeg/png/gif/bmp格式的照片！");
			imgFile.focus();
		} else {
			var path;
			if (document.all)//IE 
			{
				imgFile.select();
				path = document.selection.createRange().text;

			} else//FF 
			{
				path = URL.createObjectURL(imgFile.files[0]);
				$("#avatar-img").attr('src', path);
			}
		}
	}

	function checkFile() {
		var file = $('#file').val();
		if (file == "") {
			alert("头像没有改变");
		} else {
			submit();
			
			

		}
	}
	
	function getuser(){
		var  phoneNum=  getCookie("currLoginUser");
		if(phoneNum==""){
			window.parent.location.href='login.jsp';
		}else{
			$('#phoneNum').val(phoneNum);
			
		}
	}
	
	function submit(){
		 var formData = new FormData();
         formData.append("file", document.getElementById("file").files[0]); 
         formData.append("phoneNum",$('#phoneNum').val());
         $.ajax({
             url: "uploaduser",
             type: "POST",
             data: formData,
             /**
             *必须false才会自动加上正确的Content-Type
             */
             contentType: false,
             /**
             * 必须false才会避开jQuery对 formdata 的默认处理
             * XMLHttpRequest会对 formdata 进行正确的处理
             */
             processData: false,
             success: function (data) {
                 if (data == "true") {
                     alert("上传成功！");
                     history.go(0);//刷新当前页面
                 }
                 if (data == "error") {
                     alert("上传失败");
                 }
                 
             },
             error: function () {
                 alert("上传失败！");
                 
             }
         });
    
	}
</script>
<style type="text/css">
.addAvatar {
	width: 50%;
	height: 50%;
	margin-left: 25%;
	margin-top: 5%;
	background-color: #fff;
}

.avatar-img {
	width: 120px;
	height: 120px;
	margin-top: 2%;
	margin-left: 38%;
	background-color: #c0c0c0;
}
</style>
</head>
<body onload="getuser()">

	<div class="addAvatar">
		<form action="uploaduser" method="post" 
			enctype="multipart/form-data" id="avatar">
			<!-- <div>
				<img class="avatar-img" id="avatar-img" src="" />
			</div> -->
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><h3 align="center">更换头像</h3></td>
						<td style="display: none"><input type="text" id="phoneNum" name="phoneNum"></td>
					</tr>
					

					<tr>
						<td><img class="avatar-img" id="avatar-img"
							src="" /></td>
					</tr>

					<tr>

						<td>添加头像<input type="file" id="file" name="file"
							onchange="PreviewImage(this)"></input></td>
					</tr>

					<tr>
						<td><button type="button" class="btn btn-success btn-block"
								onclick="checkFile()">提交</button></td>
						<!-- <td style="display: none"><button type="submit" id="submit" ></button></td> -->
					</tr>
				</tbody>

			</table>


		</form>
	</div>


</body>
</html>