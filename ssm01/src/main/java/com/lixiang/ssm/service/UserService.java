package com.lixiang.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lixiang.ssm.dao.UserMapper;
import com.lixiang.ssm.entity.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public boolean addUser(User user) {
		return userMapper.insert(user) > 0;
	}

	public List<User> list(User user) {
		return userMapper.list(user);
	}
	
	/**
	 * 分页的查询
	 * @param user
	 * @return
	 */
	public PageInfo<User> pageList(User user) {
		//获取第1页，10条内容，默认查询总数count
		PageHelper.startPage(user.getPageNum(), user.getPageSize());
		//查询语句
		List<User> list = userMapper.list(user);
		//用PageInfo对结果进行包装
		PageInfo<User> page = new PageInfo<>(list);
		return page;
	}

}
