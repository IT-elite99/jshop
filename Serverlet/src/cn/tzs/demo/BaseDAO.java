package cn.tzs.demo;

import java.util.List;

/**
 * 类 User--》table User
 * 提供增删改查的功能
 */
public interface BaseDAO<T> {
	
	/**
	 * 添加 
	 * @param t 要添加的对象
	 * @return 成功返回TRUE，失败返回false
	 */
	public boolean add(T t);
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	
	public boolean udpate(T t);
	
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
	public T getById(Integer id);
	
	/**
	 * 查询多个
	 * @param t
	 * @return
	 */
	public List<T> list(T t);
	
	/**
	 * 带分页功能的查询
	 * @param t 查询条件
	 * @param pageNo查询的页数
	 * @param pageSize 每页显示多少条
	 * @return
	 */
	public List<T> page(T t,int pageNo,int pageSize);

}
