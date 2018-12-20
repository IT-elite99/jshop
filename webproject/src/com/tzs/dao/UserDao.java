package com.tzs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.tzs.entity.User;
import com.tzs.util.C3P0Utils;

public class UserDao implements BaseDao<User> {

	private QueryRunner queryrunner = new QueryRunner();

	@Override
	public boolean add(User t) {
		// 判断user对象是否为空
		if (t == null) {
			return false;
		}
		// 声明sql语句用于添加用户
		String sql = "insert into user(account,real_name,password,sex,birthday,address,balance,role,email,register_time,login_time,update_time,error_count)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = C3P0Utils.getConnection();
		int result = 0;
		try {

			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + t);

			result = queryrunner.update(conn, sql, t.getAccount(), t.getReal_name(),t.getPassword(), t.getSex(), t.getBirthday(),
					t.getAddress(), t.getBalance(), t.getRole(), t.getEmail(), t.getRegister_time(), t.getLogin_time(),
					t.getUpdate_time(), t.getError_count());
			return result > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return false;

	}

	@Override
	public boolean deleteById(Integer id) {
		// 判断对象是否为空
		if (id == null) {
			return false;
		}
		String sql = "delete from user where id=?";
		Connection conn = C3P0Utils.getConnection();

		try {

			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + id);

			int result = queryrunner.update(conn, sql, id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User t) {
		// 检查对象或id是否为空
		if (t == null || t.getId() == null) {
			return false;
		}
		// 拼接sql语句
		StringBuffer sql = new StringBuffer("update user set");
		// 封装参数
		List<Object> params = new ArrayList<>();
		// 定义修改的字段数量
		int index = 0;

		// 判断账号
		if (t.getAccount() != null) {

			sql.append(" account=?");
			params.add(t.getAccount());
			index++;
		}
		// 判断姓名
		if (t.getReal_name() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" real_name=?");
			params.add(t.getReal_name());
			index++;
		}
		// 判断密码
		if (t.getPassword() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" password=?");
			params.add(t.getPassword());
			index++;
		}
		// 判断性别
		if (t.getSex() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" sex=?");
			params.add(t.getSex());
			index++;
		}
		// 判断出生日期
		if (t.getBirthday() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" birthday=?");
			params.add(t.getBirthday());
			index++;
		}
		// 判断地址
		if (t.getAddress() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" address=?");
			params.add(t.getAddress());
			index++;
		}
		// 判断余额
		if (t.getBalance() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" balance=?");
			params.add(t.getBalance());
			index++;
		}
		// 判断角色
		if (t.getRole() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" real_name=?");
			params.add(t.getReal_name());
			index++;
		}
		// 判断邮箱
		if (t.getEmail() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" email=?");
			params.add(t.getEmail());
			index++;
		}
		// 判断注册时间
		if (t.getRegister_time() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" register_time=?");
			params.add(t.getRegister_time());
			index++;
		}
		// 判断登录时间
		if (t.getLogin_time() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" login_time=?");
			params.add(t.getLogin_time());
			index++;
		}
		// 判断修改时间
		if (t.getUpdate_time() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" update_time=?");
			params.add(t.getUpdate_time());
			index++;
		}
		// 判断错误次数
		if (t.getError_count() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append(" error_count=?");
			params.add(t.getError_count());
			index++;
		}

		// 如果index=0 ，说明不需要修改任何字段
		if (index == 0) {
			return false;
		}

		sql.append(" where id=?");
		params.add(t.getId());

		// 执行修改动作
		Connection conn = C3P0Utils.getConnection();
		// 防止sql语句注入
		PreparedStatement stat = null;
		try {

			stat = conn.prepareStatement(sql.toString());

			for (int i = 1; i <= params.size(); i++) {
				stat.setObject(i, params.get(i - 1));
			}
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + Arrays.toString(params.toArray()));

			int result = stat.executeUpdate();

			return result > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn, stat);
		}

		return false;
	}

	@Override
	public User queryById(Integer id) {
		// 判断id是否为空
		if (id == null) {
			return null;
		}
		String sql = "select * from user where id=?";
		Connection conn = C3P0Utils.getConnection();

		try {
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + id);
			// conn：数据库连接 sql：发送sql语句 BeanHandler：结果集处理类
			User user = queryrunner.query(conn, sql, new BeanHandler<>(User.class), id);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return null;
	}

	@Override
	public List<User> list(User t) {
		StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
		// 封装了参数
		List<Object> params = new ArrayList<>();

		if (t != null) {
			// 判断id
			if (t.getId() != null) {
				sql.append(" and id=?");
				params.add(t.getId());
			}
			// 账号支持模糊查询
			if (t.getAccount() != null && !"".equals(t.getAccount().trim())) {
				sql.append(" and real_name like ?");
				params.add("%" + t.getAccount().trim() + "%");
			}

			//
			if (t.getPassword() != null && !"".equals(t.getPassword().trim())) {
				sql.append(" and password=?");
				params.add(t.getPassword());
			}
			/**
			 * // 根据注册时间查询
			 * 
			 * if (t.getRegister_time() != null) { sql.append(" and
			 * register_time>=?"); params.add(t.getRegister_time()); }
			 * 
			 */

		}
		Connection conn = C3P0Utils.getConnection();
		try {
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + Arrays.toString(params.toArray()));
			List<User> list = queryrunner.query(conn, sql.toString(), params.toArray(),
					new BeanListHandler<>(User.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return null;
	}

	@Override
	public List<User> page(User t, int pageNo, int pageSize) {
		StringBuffer sql = new StringBuffer("select * from user where 1=1 ");
		// 封装了参数
		List<Object> params = new ArrayList<>();

		if (t != null) {
			// 判断id
			if (t.getId() != null) {
				sql.append(" and id=?");
				params.add(t.getId());
			}
			// 账号支持模糊查询
			if (t.getAccount() != null && "".equals(t.getAccount().trim())) {
				sql.append(" and account like ?");
				params.add("%" + t.getAccount().trim() + "%");
			}
			// 真实姓名支持模糊查询
			if (t.getReal_name() != null && "".equals(t.getReal_name().trim())) {
				sql.append(" and real_name like ?");
				params.add("%" + t.getReal_name().trim() + "%");
			}

			// 密码
			if (t.getPassword() != null && !"".equals(t.getPassword().trim())) {
				sql.append(" and password=?");
				params.add(t.getPassword());
			}

		}
		sql.append(" limit ?,?");
		params.add((t.getPageNo() - 1) * t.getPageSize());
		params.add(t.getPageSize());

		Connection conn = C3P0Utils.getConnection();
		try {
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + Arrays.toString(params.toArray()));
			@SuppressWarnings("deprecation")
			List<User> list = queryrunner.query(conn, sql.toString(), params.toArray(),
					new BeanListHandler<>(User.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}
		return null;
	}

	@Override
	public int count(User t) {
		StringBuffer sql = new StringBuffer("select count(1) from user where 1=1 ");
		// 封装了参数
		List<Object> params = new ArrayList<>();

		if (t != null) {
			// 判断id
			if (t.getId() != null) {
				sql.append(" and id=?");
				params.add(t.getId());
			}
			// 名称支持模糊查询
			if (t.getReal_name() != null && !"".equals(t.getReal_name().trim())) {
				sql.append(" and name like ?");
				params.add("%" + t.getReal_name().trim() + "%");
			}

			// 密码
			if (t.getPassword() != null && !"".equals(t.getPassword().trim())) {
				sql.append(" and password=?");
				params.add(t.getPassword());
			}

		}
		Connection conn = C3P0Utils.getConnection();
		try {
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + Arrays.toString(params.toArray()));
			Long count = queryrunner.query(conn, sql.toString(), params.toArray(), new ScalarHandler<Long>());
			return count.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return 0;
	}

	public User getByName(String real_name) {
		// 判断Name是否为空
		if (real_name == null && "".equals(real_name.trim())) {
			return null;
		}

		String sql = "select * from user where real_name=?";
		Connection conn = C3P0Utils.getConnection();

		try {
			/**
			 * conn:数据库连接 sql：发送sql语句 BeanHandler：结果集的处理类
			 */
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + real_name);
			User user = queryrunner.query(conn, sql, new BeanHandler<>(User.class), real_name);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return null;
	}

}
