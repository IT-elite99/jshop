package com.lixiang;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lixiang.dao.UserDao;
import com.lixiang.po.User;

public class TestUserMapper {
	@Test
	public void queryById() {

		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSF = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSF.openSession();
			UserDao mapper = session.getMapper(UserDao.class);
			User user = mapper.getById(1);
			//User user = (User) session.selectOne("com.lixiang.userMapper.selectUser", 1);
			System.out.println(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}