
//设置cookie,使用方法：setCookie('user', 'simon', 11);
function setCookie(name,value,day){
	
	var date = new Date();
	date.setDate(date.getDate()+day);
	document.cookie=name+'='+value+';expires='+date;
}

//获取cookie




