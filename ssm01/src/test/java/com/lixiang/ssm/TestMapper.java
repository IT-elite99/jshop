package com.lixiang.ssm;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lixiang.ssm.dao.UserMapper;
import com.lixiang.ssm.entity.User;

public class TestMapper {
	
	@Test
	public void test(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
		
		UserMapper mapper = ctx.getBean("userMapper", UserMapper.class);
		
		User user = mapper.selectByPrimaryKey(16);
		
		System.out.println(user);
		
	}

}
