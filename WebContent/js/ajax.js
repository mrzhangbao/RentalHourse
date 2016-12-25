
var xmlHttpRequest = null;

function createXHR(){
	
	try{
		xmlHttpRequest = new XMLHttpRequest();
	}catch (e1) {
		var Msxmlhttp = new Array("Msxml2.XMLHTTP.6.0","Msxml2.XMLHTTP.5.0","Msxml2.XMLHTTP.4.0",
								   "Msxml2.XMLHTTP.3.0","Msxml2.XMLHTTP.2.0","Msxml2.XMLHTTP.1.0");
		for(var i=0;i<Msxmlhttp.length;i++){
			try{
				xmlHttpRequest = new ActiveXObject(Msxmlhttp[i]);
				if(xmlHttpRequest!=null){break;}
			}catch(e2){}
		}
	}
	if(xmlHttpRequest==null){
		alert("Create Object defeat");
	}
}

function sendRequest(url,params,method,handler){
	
	createXHR();
	
	if(!xmlHttpRequest)return false;
	xmlHttpRequest.onreadystatechange = handler;	
	if(method == "GET"){
		xmlHttpRequest.open(method,url,+"?"+params,true);
		xmlHttpRequest.send(null);
	}
	if(method == "POST"){
		xmlHttpRequest.open(method,url,true);
		xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlHttpRequest.send(params);
	}
}