package com.lixiang.dao;

import java.util.List;

import com.lixiang.po.User;

public interface UserDao {
	
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	public boolean add(User user);
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	
	public boolean udpate(User user);
	
	/**
	 * 根据ld来删除
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer id);
	
	/**
	 * 根据i来查询
	 * @param id
	 * @return
	 */
	public User getById(Integer id);
	
	/**
	 * 查询多个
	 * @param t
	 * @return
	 */
	public List<User> list(User user);
	
	/**
	 * 带分页功能的查询
	 * @param t 查询条件
	 * @param pageNo查询的页数
	 * @param pageSize 每页显示多少条
	 * @return
	 */
	public List<User> page(User user);
	
	/**
	 * 计算总条目数
	 * @param t
	 * @return
	 */
	public int count(User user);


}
