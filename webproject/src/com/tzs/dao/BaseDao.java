package com.tzs.dao;

import java.util.List;

import com.tzs.entity.Student;

/**
 * 这是一个接口，为对象提供增删改查的功能
 * @author Administrator
 * @date 2018-11-14
 * @location
 */
public interface BaseDao<T> {
	/**
	 * 用户添加
	 * @param t 添加对象
	 * @return 成功返回true，失败返回false
	 */
	public boolean add(T t);
	/**
	 * 根据用户id来删除对象
	 * @param id 删除对象的id
	 * @return
	 */
	public boolean deleteById(Integer id);
	/**
	 * 修改用户信息
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	/**
	 * 通过id来查询单一用户
	 * @param id
	 * @return
	 */
	public T queryById(Integer id);
	
	//查询多个对象
	public List<T> list(T t);
	/**
	 * 带分页的查询
	 * @param t
	 * @param pageNo 页数
	 * @param pageSize 每页条数
	 * @return
	 */
	public List<T> page(T t, int pageNo, int pageSize);
	
	//记录总数
	public int count(T t);
	
	
	
	
}
