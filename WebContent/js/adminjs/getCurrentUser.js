
/*获取当前登录的管理员*/
function getCur() {
	$.ajax({
		url : "getnameAdmin",
		type : 'POST',
		async : true,
		data : {
			"account" : getCookie("currentuser")
		},
		success : function(data) {
			/* 成功后将用户名设置上去,如果该用户没有登陆，则跳转到登陆界面 */
			if(data=="false"){
				alert("请重新登陆系统");
				window.parent.location.href='amlogin.jsp';
				
			}else{
				$('#username').html(data);
			}
		},
		error : function() {
			alert("系统维护中....");
			window.parent.location.href='amlogin.jsp';
		}
	});
}

