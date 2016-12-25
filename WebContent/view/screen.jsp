<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="../css/screenstyle.css">
<script type="text/javascript" src="../js/jquery-1.4.3.min.js"></script>
<title>筛选</title>
</head>
<body>

<div class="selectNumberScreen">

	<div id="selectList" class="screenBox screenBackground">
	
		<dl class="listIndex" attr="terminal_brand_s">
			<dt>品　　牌：</dt>
			<dd>
				<a href="javascript:void(0)" values2="" values1="" attrval="apple">苹果</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="小米">小米</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="华为">华为</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="lenovo">联想</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="zte中兴">中兴</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="amoi">夏新</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="海信">海信</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="酷派">酷派</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="dell">dell</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="htc">htc</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="sony ericsson">索尼爱立信</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="三星">三星</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="诺基亚">诺基亚</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="海尔">海尔</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="tcl">tcl</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="飞利浦">飞利浦</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="摩托罗拉">摩托罗拉</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="黑莓">黑莓</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="lg">lg</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="爱国者">爱国者</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="天语">天语</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="英华达">英华达</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="长虹">长虹</a>
			</dd>
		</dl>
		
		<dl class="listIndex" attr="价格范围">
			<dt>价格范围：</dt>
			<dd>
				<a href="javascript:void(0)" values2="499" values1="1" attrval="1-499">1-499</a> 
				<a href="javascript:void(0)" values2="999" values1="500" attrval="500-999">500-999</a>
				<a href="javascript:void(0)" values2="1999" values1="1000" attrval="1000-1999">1000-1999</a>
				<a href="javascript:void(0)" values2="2999" values1="2000" attrval="2000-2999">2000-2999</a>
				<a href="javascript:void(0)" values2="4999" values1="3000" attrval="3000-4999">3000-4999</a>
				<a href="javascript:void(0)" values2="0" values1="5000" attrval="5000以上">5000以上</a>
			</dd>
		</dl>
		
		<dl class=" listIndex" attr="terminal_os_s">
			<dt>操作系统：</dt>
			<dd>
				<a href="javascript:void(0)" values2="" values1="" attrval="ios">ios</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="android">安卓</a> 
				<a href="javascript:void(0)" values2="" values1="" attrval="symbian">塞班</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="百度易平台">百度易平台</a>
			</dd>
		</dl>
		
		<dl class=" listIndex" attr="terminal_activity_s">
			<dt>优惠活动：</dt>
			<dd>
				<a href="javascript:void(0)" values2="" values1="" attrval="预存话费送手机">存话费送手机</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="购手机入网送话费">买手机送话费</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="只买手机">只买手机</a>
			</dd>
		</dl>
		
		<dl class="noBorder listIndex" attr="terminal_sellFeature_s">
			<dt>特　　点：</dt>
			<dd>
				<a href="javascript:void(0)" values2="" values1="" attrval="double_card_y">双卡双待</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="sell_point_01">千元智能机</a>
				<a href="javascript:void(0)" values2="" values1="" attrval="is_large_scn_y">大屏（4.0寸以上）</a>
			</dd>
		</dl>
		
	</div>
	
	<div class="hasBeenSelected">
		<dl>
			<dt>您已选择：</dt>
			<dd style="display:none" class="clearDd">
				<div class="clearList"></div>
				<div style="display:none;" class="eliminateCriteria">清除筛选条件</div>
			</dd>
		</dl>
		<button>确定</button>
	</div>
	
</div>

<script type="text/javascript">
var dlNum  =$("#selectList").find("dl");
for (i = 0; i < dlNum.length; i++) {
	$(".hasBeenSelected .clearList").append("<div class=\"selectedInfor selectedShow\" style=\"display:none\"><span></span><label></label><em></em></div>");
}

var refresh = "true";

$(".listIndex a ").live("click",function(){
	var text =$(this).text();
	var selectedShow = $(".selectedShow");
	var textTypeIndex =$(this).parents("dl").index();
	var textType =$(this).parent("dd").siblings("dt").text();
/* 	alert("haha"+text); */
	index = textTypeIndex -(2);
	$(".clearDd").show();
	$(".selectedShow").eq(index).show();
	$(this).addClass("selected").siblings().removeClass("selected");
	selectedShow.eq(index).find("span").text(textType);
	selectedShow.eq(index).find("label").text(text);
	var show = $(".selectedShow").length - $(".selectedShow:hidden").length;
	if (show > 1) {
		$(".eliminateCriteria").show();
	}
   
});
$(".selectedShow em").live("click",function(){
	$(this).parents(".selectedShow").hide();
	var textTypeIndex =$(this).parents(".selectedShow").index();
	index = textTypeIndex;
	
	$(".listIndex").eq(index).find("a").removeClass("selected");
	
	if($(".listIndex .selected").length < 2){
		$(".eliminateCriteria").hide();
	}
});

$(".eliminateCriteria").live("click",function(){
	$(".selectedShow").hide();
	$(this).hide();
	$(".listIndex a ").removeClass("selected");
}); 
</script>

</body>
</html>