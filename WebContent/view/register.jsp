<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/default.css">
<link rel="stylesheet" type="text/css" href="../css/styles.css">

<!-- Buttons 库的核心文件 -->
<link rel="stylesheet" href="../css/buttons.css">
<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
<title>注册</title>
</head>
<body>
	<article class="htmleaf-content"> <!-- multistep form -->
	<form id="msform">
		<!-- progressbar -->
		<ul id="progressbar">
			<li class="active">手机验证</li>
			<li>个人信息</li>
			<li>完成注册</li>
		</ul>
		<!-- fieldsets -->
		<fieldset>
			<h2 class="fs-title">创建你的账号</h2>
			<h3 class="fs-subtitle">这是第一步</h3>
			<input type="text" name="手机号码" placeholder="手机号码" />
			<input
				class="button-large"
				name="bt_getcode" id="code" onclick='sendCode(this)'  value="点击获取验证码"/>

			<input type="password" name="pass" placeholder="密码" />
			<div>
				<input type="text" name="code" width="60%" placeholder="验证码"
					maxlength="6" />
			</div>

			<input type="button" name="next" class="next action-button"
				value="Next" />
		</fieldset>
		<fieldset>
			<h2 class="fs-title">填写社交账号</h2>
			<h3 class="fs-subtitle">填写你的常用社交网络账号</h3>
			<input type="text" name="x-weibo" placeholder="新浪微博" /> <input
				type="text" name="t-weibo" placeholder="腾讯微博" /> <input type="text"
				name="qq" placeholder="腾讯QQ" /> <input type="button"
				name="previous" class="previous action-button" value="Previous" />
			<input type="button" name="next" class="next action-button"
				value="Next" />
		</fieldset>
		<fieldset>
			<h2 class="fs-title">个人详细信息</h2>
			<h3 class="fs-subtitle">个人详细信息是保密的，不会被泄露</h3>
			<input type="text" name="fname" placeholder="昵称" /> <input
				type="text" name="lname" placeholder="姓名" /> <input type="text"
				name="phone" placeholder="电话号码" />
			<textarea name="address" placeholder="家庭住址"></textarea>
			<input type="button" name="previous" class="previous action-button"
				value="Previous" /> <input type="submit" name="submit"
				class="submit action-button" value="Submit" />
		</fieldset>
	</form>
	</article>



	<script type="text/javascript">
		    //获取验证码倒计时
		var nums=30;
		var time;
		var btn;
		var btstyles;
		function sendCode(thisBtn){
			btn = thisBtn;
			btn.setAttribute("disabled",true);
			btn.value = '还剩'+nums+'秒';
			time = setInterval(doLoop, 1000);
		}
		function doLoop(){
			nums --;
			if(nums > 0){
				btn.value = '还剩'+nums+'秒';
			}else{
				clearInterval(time);
				/*  btn.setAttribute("class",btstyles); */
				/*  btn.setAttribute("disabled",false);  */
				
				btn.removeAttribute('disbaled'); 
				btn.value = '获取验证码';
				/* btn.setAttribute("class","button button-block button-rounded button-primary button-large"); */
				nums = 30;
			}
		}
	
	

	
	
	/* function showtime(t){ 
	    document.myform.phone.disabled=true; 
	    for(i=1;i<=t;i++) { 
	        window.setTimeout("update_p(" + i + ","+t+")", i * 1000); 
	    } 
	 
	} 
	 
	function update_p(num,t) { 
	    if(num == t) { 
	        document.myform.phone.value =" 重新发送 "; 
	        document.myform.phone.disabled=false; 
	    } 
	    else { 
	        printnr = t-num; 
	        document.myform.phone.value = " (" + printnr +")秒后重新发送"; 
	    } 
	} 
	 */
	</script>



	<script src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"
		type="text/javascript"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../js/jquery-2.1.1.min.js"><\/script>')
	</script>
	<script src="../js/jquery.easing.min.js" type="text/javascript"></script>
	<script>
		var current_fs, next_fs, previous_fs;
		var left, opacity, scale;
		var animating;
		$('.next').click(
				function() {
					if (animating)
						return false;
					animating = true;
					current_fs = $(this).parent();
					next_fs = $(this).parent().next();
					$('#progressbar li').eq($('fieldset').index(next_fs))
							.addClass('active');
					next_fs.show();
					current_fs.animate({
						opacity : 0
					}, {
						step : function(now, mx) {
							scale = 1 - (1 - now) * 0.2;
							left = now * 50 + '%';
							opacity = 1 - now;
							current_fs.css({
								'transform' : 'scale(' + scale + ')'
							});
							next_fs.css({
								'left' : left,
								'opacity' : opacity
							});
						},
						duration : 800,
						complete : function() {
							current_fs.hide();
							animating = false;
						},
						easing : 'easeInOutBack'
					});
				});
		$('.previous').click(
				function() {
					if (animating)
						return false;
					animating = true;
					current_fs = $(this).parent();
					previous_fs = $(this).parent().prev();
					$('#progressbar li').eq($('fieldset').index(current_fs))
							.removeClass('active');
					previous_fs.show();
					current_fs.animate({
						opacity : 0
					}, {
						step : function(now, mx) {
							scale = 0.8 + (1 - now) * 0.2;
							left = (1 - now) * 50 + '%';
							opacity = 1 - now;
							current_fs.css({
								'left' : left
							});
							previous_fs.css({
								'transform' : 'scale(' + scale + ')',
								'opacity' : opacity
							});
						},
						duration : 800,
						complete : function() {
							current_fs.hide();
							animating = false;
						},
						easing : 'easeInOutBack'
					});
				});
		$('.submit').click(function() {
			return false;
		});
	</script>
</body>
</html>
