document.write("<script src='../js/ajax.js'><" + '/' + "script>");
// 页面刷新的时候自动调用这个方法，判断是不是存在cookie
window.onload = function() {

	var v = getCookieValue("secondsremained");
	if (v > 0) {
		var obj = document.getElementById("code");
		settime(obj);
	}

}

function addCookie(name, value, expiresHours) {

	var cookieString = name + "=" + escape(value);
	// 判断是否设置过期时间，0代表关闭浏览器时失效
	if (expiresHours > 0) {

		var date = new Date();
		date.setTime(date.getTime() + expiresHours * 1000);
		cookieString = cookieString + ";expires=" + date.toUTCString();

	}
	document.cookie = cookieString;
}
// 修改cookie的值
function editCookie(name, value, expiresHours) {
	var cookieString = name + "=" + escape(value);
	if (expiresHours > 0) {
		var date = new Date();
		date.setTime(date.getTime() + expiresHours * 1000);
		cookieString = cookieString + ";expires=" + date.toGMTString();
	}
	document.cookie = cookieString;
}
// 根据名字获取cookie的值
function getCookieValue(name) {
	var strCookie = document.cookie;
	var arrCookie = strCookie.split(";");
	for (var i = 0; i < arrCookie.length; i++) {
		var arr = arrCookie[i].split("=");
		if (arr[0] == name) {
			return unescape(arr[1]);
			break;
		} else {
			return "";
			break;
		}
	}
}

function sendCode(obj) {
	formcheck();
	var v = getCookieValue("secondsremained");
	if (v > 0) {
		settime(obj);
	} else {
		addCookie("secondsremained", 10, 10);// 添加cookie记录,有效时间60s
		settime(obj);
	}

}
var countdown;
function settime(obj) {
	countdown = getCookieValue("secondsremained");
	if (countdown == 0) {
		obj.removeAttribute("disabled");
		obj.value = '重新获取验证码';
		return;
	} else {
		obj.setAttribute("disabled", true);
		obj.value = '重新发送(' + countdown + ')';
		countdown--;
		editCookie("secondsremained", countdown, countdown + 1);
	}
	setTimeout(function() {
		settime(obj)
	}, 1000) // 每1000毫秒执行一次
}

function formcheck() {
	// 检查该号码是否已经被注册
	var url = "checkPhoneNumReg";
	var params = "phoneNum=" + document.getElementById("phoneNum").value;
	sendRequest(url, params, 'POST', showresult);
}

function showresult() {
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {
			var info = xmlHttpRequest.responseText;
			if (info == "false") {
				alert("该号码已经注册，可以直接登陆");
				/*
				 * document.getElementById("bt").disabled=false;
				 * document.getElementById("result").innerHTML="";
				 * document.getElementById("bt").style.background="#55ACEF";
				 * document.getElementById("bt").style.color="#fff"
				 */

			} else {
				alert("验证码发送成功");
				// info="true" 该号码未注册，可以进行注册
				/*
				 * document.getElementById("result").innerHTML= info;
				 * document.getElementById("bt").disabled=true;
				 * document.getElementById("bt").style.background="#cccccc";
				 * document.getElementById("bt").style.color="#000000";
				 * document.getElementById("result").style.color="red";
				 */
			}

		}

	}
}

function send() {
	alert("检测");
	// 检查该号码是否已经被注册
	var url = "sendCodeReg";
	var params = "phoneNum=" + document.getElementById("phoneNum").value;
	alert("检测" + "params");
	sendRequest(url, params, 'POST', sendresult);

}

function sendresult() {
	if (xmlHttpRequest.readyState == 4) {
		if (xmlHttpRequest.status == 200) {
			var info = xmlHttpRequest.responseText;
			if (info == "success") {
				alert("发送验证码成功");
				/*
				 * document.getElementById("bt").disabled=false;
				 * document.getElementById("result").innerHTML="";
				 * document.getElementById("bt").style.background="#55ACEF";
				 * document.getElementById("bt").style.color="#fff"
				 */

			} else {
				alert("发送验证码失败");
				// info="true" 该号码未注册，可以进行注册
				/*
				 * document.getElementById("result").innerHTML= info;
				 * document.getElementById("bt").disabled=true;
				 * document.getElementById("bt").style.background="#cccccc";
				 * document.getElementById("bt").style.color="#000000";
				 * document.getElementById("result").style.color="red";
				 */
			}

		}

	}
}
