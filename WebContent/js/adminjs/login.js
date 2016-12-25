document.write("<script src='../js/jquery-3.1.1.js'><" + '/' + "script>");
document.write("<script src='../js/ajax.js'><" + '/' + "script>");
document.write("<script src='../js/adminjs/admin.js'><" + '/' + "script>");

$(document).ready(function() {
	formValidator();//加载页面先初始化
});



function formValidator() {
	/**
	 * 下面是进行插件初始化 你只需传入相应的键值对
	 */
	$('#loginForm').bootstrapValidator({
		message : 'This value is not valid',
		disableSubmitButtons : true,
		feedbackIcons : {/* 输入框不同状态，显示图片的样式 */
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {/* 验证 */
			account : {/* 键名username和input name值对应 */
				message : 'The username is not valid',
				validators : {
					notEmpty : {/* 非空提示 */
						message : '账号不能为空'
					},
					stringLength : {/* 长度提示 */
						min : 5,
						max : 30,
						message : '账号长度必须在5到30之间'
					}
				/* 最后一个没有逗号 */
				}
			},
			password : {
				message : '密码无效',
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					stringLength : {
						min : 5,
						max : 16,
						message : '用户名长度必须在5到16之间'
					}
				}
			},
		}
	}).on('success.form.bv', function(e) {// 点击提交之后
		// 防止多次提交表单
		e.preventDefault();

		// 获取表单实例
		var $form = $(e.target);

		// 获得 BootstrapValidator 实例
		var bv = $form.data('bootstrapValidator');
		// Use Ajax 提交至form标签中的action，result自定义ajax回调方法
		$.post($form.attr('action'), $form.serialize(), function(result) {
			
			if(result=="1"){
				/*采用encodeURIComponent的编码方式隐藏重要信息*/
			/*	var returnUrl = encodeURIComponent("http://localhost:8080/RentalHourse/view/admin/amlogin.jsp?"+$form.serialize());
				window.location.href = "http://localhost:8080/RentalHourse/view/admin/adminIndex.jsp?" + returnUrl ;*/
				/*将信息保存到cookie中*/
				var currentuser = getCookie("currentuser");
				if(currentuser!="" && currentuser!=null && typeof(currentuser)!="undefined"){
					delCookie("currentuser");
				}
					setCookie("currentuser",$('#account').val(),1);
				
				log();
			}else{
				alert("用户名或者密码错误");
			}
			
		});
	});

}
/* 该方法用于跳转到登陆界面*/
function log(){
	$('#acc').val($('#account').val());
	$('#pas').val($('#password').val());
	$('#form').submit();
}
