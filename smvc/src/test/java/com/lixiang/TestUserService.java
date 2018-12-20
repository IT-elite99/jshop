package com.lixiang;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lixiang.po.User;
import com.lixiang.service.UserService;



public class TestUserService {

	private ApplicationContext context;

	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}
	
	
	@Test
	public void add(){
	/*	User user = new User(null, "fanbingbing3", "8888888", new Date());
		
		UserService dao = context.getBean(UserService.class);
		
		boolean result = dao.add(user);
		
		System.out.println("添加的结果:"+result);*/
		
		User user = new User(2,"tan234","123123", null, null, null, null);
		UserService service = context.getBean(UserService.class);
		boolean result = service.add(user);
		System.out.println("添加的结果:"+result);
	}

}
