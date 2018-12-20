package com.lixiang.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lixiang.dao.UserDao;
import com.lixiang.po.User;
import com.mysql.jdbc.log.Log;

import aj.org.objectweb.asm.Type;

@Repository
public class UserDaoImpl implements UserDao {

	private Logger logger = Logger.getLogger(User.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean add(User user) {
		// 先判断对象是否为空
		if (user == null)
			return false;
		String sql = "insert into user(username,password,name,sex,birthday,telephone) values(?,?,?,?,?,?)";
		logger.debug("SQL语句:" + sql.toString());
		logger.debug("参数：" + user);
		int result = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getSex(),
				user.getBirthday(), user.getTelephone());

		return result > 0;

	}

	@Override
	public boolean udpate(User user) {
		// 检查对象和id是否为空
		if (user == null || user.getId() == null) {
			return false;
		}
		// 要拼接的SQL语句
		StringBuffer sql = new StringBuffer("update user set ");
		// 封装了参数
		List<Object> params = new ArrayList<>();
		List<Integer> types = new ArrayList<>();
		// 表示修改字段数量
		int index = 0;
		// 判断用户名(账号)
		if (user.getUsername() != null) {
			sql.append(" username=?");
			params.add(user.getUsername());
			types.add(Types.VARCHAR);
			index++;
		}
		// 判断密码
		if (user.getPassword() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append("  password=? ");
			params.add(user.getPassword());
			types.add(Types.VARCHAR);
			index++;
		}
		// 判断真实姓名
		if (user.getName() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" name=?");
			params.add(user.getName());
			types.add(Types.VARCHAR);
		}
		// 判断性别
		if (user.getSex() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" sex=?");
			params.add(user.getSex());
			types.add(Types.TINYINT);

		}
		// 判断生日
		if (user.getBirthday() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" birthday=?");
			params.add(user.getBirthday());
			types.add(Types.DATE);
		}

		// 判断电话号码
		if (user.getTelephone() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" telephone=?");
			params.add(user.getTelephone());
			types.add(Types.VARCHAR);
		}
		// 如果index=0，那么说明不需要修改任何字段，之间返回false
		if (index == 0) {
			return false;
		}

		sql.append(" where id=?");
		params.add(user.getId());

		// 执行修改动作

		logger.debug("SQL语句:" + sql.toString());
		logger.debug("参数：" + Arrays.toString(params.toArray()));

		int result = jdbcTemplate.update(sql.toString(), params.toArray(), types.toArray());

		return result > 0;
	}

	@Override
	public boolean deleteById(Integer id) {
		// 判断是否为空
		if (id == null) {
			return false;
		}

		String sql = "delete from user where id=?";

		logger.debug("SQL语句:" + sql.toString());
		logger.debug("参数：" + id);
		int result = jdbcTemplate.update(sql, id);
		return result > 0;
	}

	@Override
	public User getById(Integer id) {
		// 判断Id是否为空
		if (id == null) {
			return null;
		}

		String sql = "select * from user where id=?";

		logger.debug("SQL语句:" + sql.toString());
		logger.debug("参数：" + id);
		User user = jdbcTemplate.queryForObject(sql, User.class, id);
		return user;
	}

	@Override
	public List<User> list(User user) {
		StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
		// 封装了参数
		List<Object> params = new ArrayList<>();

		if (user != null) {
			// 判断id
			if (user.getId() != null) {
				sql.append(" and id=?");
				params.add(user.getId());
			}
			// 真实姓名支持模糊查询
			if (user.getUsername() != null && !"".equals(user.getUsername().trim())) {
				sql.append(" and username like ?");
				params.add("%" + user.getUsername().trim() + "%");
			}

			// 密码
			if (user.getPassword() != null && !"".equals(user.getPassword().trim())) {
				sql.append(" and password=?");
				params.add(user.getPassword());
			}
			// 真实姓名支持模糊查询
			if (user.getName() != null && !"".equals(user.getName().trim())) {
				sql.append(" and name like ?");
				params.add("%" + user.getName().trim() + "%");
			}

			/*
			 * // 生日是一个范围查询 开始-结束 // 判断生日 // startDate:2018-01-01 //
			 * endDate:2018-10-10 if (t.getStartDate() != null) {
			 * sql.append(" and birthday>=?"); params.add(t.getStartDate()); }
			 * if (t.getEndDate() != null) { sql.append(" and birthday<=?");
			 * params.add(t.getEndDate()); }
			 */

		}

		logger.debug("SQL语句:" + sql.toString());
		logger.debug("参数：" + Arrays.toString(params.toArray()));
		List<User> list = jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<User>());
		return list;
	}

	@Override
	public List<User> page(User user) {
		StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
		// 封装了参数
		List<Object> params = new ArrayList<>();

		if (user != null) {
			// 判断id
			if (user.getId() != null) {
				sql.append(" and id=?");
				params.add(user.getId());
			}
			// 真实姓名支持模糊查询
			if (user.getUsername() != null && !"".equals(user.getUsername().trim())) {
				sql.append(" and username like ?");
				params.add("%" + user.getUsername().trim() + "%");
			}

			// 密码
			if (user.getPassword() != null && !"".equals(user.getPassword().trim())) {
				sql.append(" and password=?");
				params.add(user.getPassword());
			}
			// 真实姓名支持模糊查询
			if (user.getName() != null && !"".equals(user.getName().trim())) {
				sql.append(" and name like ?");
				params.add("%" + user.getName().trim() + "%");
			}

			/*// 生日是一个范围查询 开始-结束
			// 判断生日
			// startDate:2018-01-01
			// endDate:2018-10-10
			if (t.getStartDate() != null) {
				sql.append(" and birthday>=?");
				params.add(t.getStartDate());
			}
			if (t.getEndDate() != null) {
				sql.append(" and birthday<=?");
				params.add(t.getEndDate());
			}
*/
		}
		sql.append(" limit ?,?");
		params.add((user.getPageNo() - 1) * user.getPageSize());
		params.add(user.getPageSize());

		logger.debug("SQL语句:" + sql.toString());
		logger.debug("参数：" + Arrays.toString(params.toArray()));
		List<User> list = jdbcTemplate.query(sql.toString(), params.toArray(),
				new BeanPropertyRowMapper<User>(User.class));
		return list;

	}


	@Override
	public int count(User user) {
		StringBuffer sql = new StringBuffer("select count(1) from user where 1=1 ");
		// 封装了参数
		List<Object> params = new ArrayList<>();

		if (user != null) {
			// 判断id
			if (user.getId() != null) {
				sql.append(" and id=?");
				params.add(user.getId());
			}
			// 真实姓名支持模糊查询
			if (user.getUsername() != null && !"".equals(user.getUsername().trim())) {
				sql.append(" and username like ?");
				params.add("%" + user.getUsername().trim() + "%");
			}

			// 密码
			if (user.getPassword() != null && !"".equals(user.getPassword().trim())) {
				sql.append(" and password=?");
				params.add(user.getPassword());
			}
			// 真实姓名支持模糊查询
			if (user.getName() != null && !"".equals(user.getName().trim())) {
				sql.append(" and name like ?");
				params.add("%" + user.getName().trim() + "%");
			}


		}

		logger.debug("SQL语句:" + sql.toString());
		logger.debug("参数：" + Arrays.toString(params.toArray()));
		Long count = jdbcTemplate.queryForObject(sql.toString(), Long.class, params.toArray());
		
		return count.intValue();

	}

}
