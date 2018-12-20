package com.lixiang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lixiang.dao.UserDaoImpl;
import com.lixiang.po.User;

@Service
public class UserService {
	@Autowired
	private UserDaoImpl userDaoImpl;

	@Transactional
	public boolean add(User user){
		boolean result = false;
		result = userDaoImpl.add(user);
		return result;
	}

	public boolean udpate(User user){
		return false;
		
	}

	public boolean deleteById(Integer id){
		return false;
		
	}

	public User getById(Integer id){
		return null;
		
	}
	@Transactional
	public List<User> list(User user){
		return userDaoImpl.page(user);
		
	}

	public List<User> page(User user){
		return null;
		
	}

	public int count(User user){
		return 0;
		
	}

}
