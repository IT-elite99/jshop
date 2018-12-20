package com.tzs.util;

import java.util.Map;

import com.tzs.dao.DictDAO;



public class InstUtils {

	public static final Map<String, String> map = new DictDAO().list("INST");


	public static String mapToString(String types) {// 1,2

		if (types == null || "".equals(types.trim())) {
			return "";
		}

		String[] typeArr = types.split(",");
		StringBuffer sb = new StringBuffer();
		for (String type : typeArr) {
			sb.append(map.get(type)).append(" ");
			
		}
		
		return sb.toString();
	}

}
