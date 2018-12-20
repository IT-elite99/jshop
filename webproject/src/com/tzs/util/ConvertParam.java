package com.tzs.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class ConvertParam {
	/**
	 * 把reques里面的参数转成一个对应类型<T>对象
	 */
	public static <T> T convert(Class<T> classz, HttpServletRequest request) {

		T t = null;
		try {
			t = classz.newInstance();
			//Map<String, String[]> map = request.getParameterMap();

			// 处理时间格式
			DateConverter dateConverter = new DateConverter();
			// 设置日期格式
			dateConverter.setPatterns(new String[] { "yyyy-MM-dd", "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss" });
			// 注册格式
			ConvertUtils.register(dateConverter, Date.class);
			HashMap<String, String[]> map = new HashMap<>();
			Enumeration<String> names = request.getParameterNames();
			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				String[] values = request.getParameterValues(name);
				if(values!=null && values.length>0 &&  !"".equals(values[0])){
					map.put(name, values);
				}
			}

			BeanUtils.populate(t, map);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("转换发生了问题");
		}

		return t;
	}
}
