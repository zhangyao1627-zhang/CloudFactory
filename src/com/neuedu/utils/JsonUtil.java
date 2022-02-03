package com.neuedu.utils;

import java.util.List;



import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	public static <T> T jsonToObject(String json,Class<T> clazz) {

		if(json == null || json.length()==0) {
			return null;
		}
		System.out.println(json);
		T t = JSONObject.parseObject(json,clazz);
		return t;
	}
	
	public static String objectToJson(Object o) {

		if(o==null) {
			return null;
		}
		return JSONObject.toJSONString(o);
	}
	
	public static <T>List<T> jsonToList(String json,Class<T> clazz) {
		if(json == null || json.length()==0) {
			return null;
		}
		List<T> list = JSONObject.parseArray(json,clazz);
		return list;
	}
	

}
