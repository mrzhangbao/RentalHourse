document.write("<script src='../js/jquery-3.1.1.js'><" + '/' + "script>");
function getLoginCur() {
	var currUserPhone = getCookie("currLoginUser");
	alert("cookieuserifno="+getCookie("currLoginUser"));
	
	$.ajax({
		url : "getUserInformationLogin",
		type : 'POST',
		async : true,
		data : {
			"phoneNum" : currUserPhone
		},
		success : function(data) {
			/* 成功后将用户名设置上去,如果该用户没有登陆，则跳转到登陆界面 */
			if(data=="false"){
				alert("请重新登陆系统");
				window.parent.location.href='login.jsp';
				
			}else{
				var user=JSON.parse(data);
				$('#id').val(user.id);
				$('#phoneNum').val(user.phoneNum);
				$('#email').val(user.email);
				$('#nickName').val(user.nickName);
				$('#realName').val(user.realName);
				$('#creditNum').val(user.creditNum);
				$('#company').val(user.company);
				$('#role').val(user.role);
				$('#collection').val(user.collection);
				$('#creditScore').val(user.creditScore);
			}
		},
		error : function() {
			alert("系统维护中....");
			window.parent.location.href='login.jsp';
		}
	});
}




function setCookie(cname, cvalue, exdays) {
	var d = new Date();
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
	alert("name="+cname);
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i].trim();
		if (c.indexOf(name) == 0)
			return c.substring(name.length, c.length);
	}
	return "";
}

function delCookie(cname) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(cname);
	if (cval != null)
		document.cookie = cname + "=" + cval + ";expires=" + exp.toGMTString();
}