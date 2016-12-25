document.write("<script src='../js/layui.js'><" + '/' + "script>");
document.write("<script src='../js/jquery-3.1.1.js'><" + '/' + "script>");

function setCity() {
	// jquery的方式获取值
	var options = $("#city option:selected");
	$("#current-city").text(options.val());
	/* alert("hahhahaha"+options.val()); */

	callBackPagination(200, 6, 10);
}

function callBackPagination(totalCount, showCount, limit) {

	// var totalCount = Number($('#totalCount1').val()) || 50, showCount =
	// $('#showCount1').val(),
	//
	// limit = Number($('#limit').val()) || 10;
	//
	// createTable(1, limit, totalCount);

	$('#callBackPager').extendPagination({

		totalCount : totalCount,

		showCount : showCount,

		limit : limit,
		

		callback : function(curr, limit, totalCount) {

			alert("curr:"+curr);

		}

	});

}



function search(){
	var search = $('#search-data').val();
	
	//关闭搜索框
	$('#search-close').click();
	
}



function show() {

	var dis = document.getElementById("div").style.display;
	alert("h:" + dis);
	if (dis == "none") {
		document.getElementById("div").style.display = "";
	} else {
		hidden();
	}

	// alert(document.getElementById("div").style.display)
}
function hidden() {
	document.getElementById("div").style.display = "none";
	// alert(document.getElementById("div").style.display)
}

function init() {
	window.location.href = "getInfo.action";
	alert("加载完数据");
}

function setTitle(obj) {
	document.getElementById(obj).value
	var title = document.getElementById(obj).getAttribute('title');
	alert("hahha:" + title);
}

function reg(){
	alert("哈哈");
	$('regModel').model('show');
}
