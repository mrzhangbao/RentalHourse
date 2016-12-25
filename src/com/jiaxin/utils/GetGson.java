package com.jiaxin.utils;

import com.google.gson.Gson;

public class GetGson {
	
	private GetGson(){
		
	}
	private static Gson  g;
	
	public static synchronized Gson getGson(){
		if (g==null) {
			return g = new Gson();
		}else{
			return g;
		}
	}

}
