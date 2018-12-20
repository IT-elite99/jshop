package com.lixiang;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lixiang.dao.UserDaoImpl;
import com.lixiang.po.User;



public class TestDAO {

	private ApplicationContext context;

	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}
	
	
	@Test
	public void add(){
		User user = new User(3, "username", "2323",null, null, null, null);
		
		UserDaoImpl dao = context.getBean(UserDaoImpl.class);
		
		boolean result = dao.add(user);
		
		System.out.println("添加的结果:"+result);
		
	}

}
