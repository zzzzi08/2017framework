package com.hb.day02me.support;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private static Map<String,String> map = new HashMap<String,String>();
	
	public static void setMap(String param1,String param2){
		map.put(param1, param2);
	}
	
	public static MyController mapping(String uri) {
		MyController controller=null;
		try {
			Class clazz = Class.forName(map.get(uri));
			controller=(MyController) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return controller;
	}
}