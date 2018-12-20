package cn.work.dao;

import java.util.List;

public interface BaseDao<T> {
	//添加 
	public boolean add(T t);
	//修改
	public boolean update(T t);
	//删除：通过ID来删除
	public boolean deleteById(Integer id);
	//单个查询
	public T getById(Integer id);
	//多个查询
	public List<T> list(T t);
	/**
	 * 带分页的查询
	 * @param t 对象
	 * @param pageNo页数
	 * @param pageSize条数
	 * @return
	 */
	public List<T> page(T t,int pageNo,int pageSize);
}
