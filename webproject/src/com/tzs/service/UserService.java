package com.tzs.service;

import java.util.List;

import com.tzs.dao.UserDao;
import com.tzs.entity.BaseEntity;
import com.tzs.entity.Student;
import com.tzs.entity.User;

public class UserService extends BaseEntity{

	private UserDao dao = new UserDao();
	
	//添加用户
		public boolean add(User user){
			return dao.add(user);
		}
		
		//根据id删除学生
		public boolean deleteById(Integer id){
			return dao.deleteById(id);
		}
		
		//修改用户信息
		public boolean update(User user){
			return dao.update(user);
		}
		
		//根据id查询单一用户
		public User queryById(Integer id){
			return dao.queryById(id);
		}
		
		//查询用户信息
		public List<User> list(User user){
			return dao.list(user);
		}
		
		//分页查询
		public List<User> page(User user){
			return dao.page(user, getPageNo(), getPageSize());
		}
		
		//总数
		public int count(User user){
			return dao.count(user);
		}
		
		//根据用户姓名查询
		public User getByName(String real_name){
			return dao.getByName(real_name);
		}

}
