package cn.tzs.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.tzs.entity.User;
import cn.tzs.util.C3P0Utils;


/**
 * 访问用户信息的DAO
 */
public class UserDAO implements BaseDAO<User> {

	private QueryRunner queryRunner = new QueryRunner();

	@Override
	public boolean add(User t) {
		if (t == null)
			return false;

		String sql = "insert into user(name,password,birthday) values(?,?,?)";
		Connection conn = C3P0Utils.getConnection();
		try {
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + t);
			int result = queryRunner.update(conn, sql, t.getName(), t.getPassword(), t.getBirthday());
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return false;
	}

	/**
	 * 很多种业务场景 1.修改密码 2.修改生日 3.修改密码和生日
	 * 
	 * 动态SQL语句：根据条件来组装SQL语句
	 * 
	 * user: id: 1 name:abc password birthday
	 * 
	 * update user set name=?,password=?
	 */
	@Override
	public boolean udpate(User t) {
		// 检查对象和id是否为空
		if (t == null || t.getId() == null) {
			return false;
		}
		// 要拼接的SQL语句
		StringBuffer sql = new StringBuffer("update user set ");
		// 封装了参数
		List<Object> params = new ArrayList<>();
		// 表示修改字段数量
		int index = 0;
		// 判断用户名
		if (t.getName() != null) {
			sql.append(" name=?");
			params.add(t.getName());
			index++;
		}
		// 判断密码
		if (t.getPassword() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append("  password=? ");
			params.add(t.getPassword());
			index++;
		}
		// 判断出生年月
		if (t.getBirthday() != null) {
			if (index > 0) {
				sql.append(",");
			}
			sql.append("  password=? ");
			params.add(t.getName());
			index++;
		}
		// 如果index=0，那么说明不需要修改任何字段，之间返回false
		if (index == 0) {
			return false;
		}

		sql.append(" where id=?");
		params.add(t.getId());

		// 执行修改动作
		Connection conn = C3P0Utils.getConnection();
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
	public boolean deleteById(Integer id) {
		// 判断是否为空
		if (id == null) {
			return false;
		}

		String sql = "delete from user where id=?";

		Connection conn = C3P0Utils.getConnection();
		try {
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + id);
			int result = queryRunner.update(conn, sql, id);
			return result > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return false;

	}

	@Override
	public User getById(Integer id) {
		// 判断Id是否为空
		if (id == null) {
			return null;
		}

		String sql = "select * from user where id=?";
		Connection conn = C3P0Utils.getConnection();

		try {
			/**
			 * conn:数据库连接 sql：发送sql语句 BeanHandler：结果集的处理类
			 */
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + id);
			User user = queryRunner.query(conn, sql, new BeanHandler<>(User.class), id);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return null;
	}

	/**
	 * 很多业务场景： 1.根据名称来查 2.根据出生年月来查 3.根据用户和密码
	 * 
	 */

	@SuppressWarnings("deprecation")
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
			// 名称支持模糊查询
			if (t.getName() != null && !"".equals(t.getName().trim())) {
				sql.append(" and name like ?");
				params.add("%" + t.getName().trim() + "%");
			}

			// 密码
			if (t.getPassword() != null && !"".equals(t.getPassword().trim())) {
				sql.append(" and password=?");
				params.add(t.getPassword());
			}
			// 生日是一个范围查询 开始-结束
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

		}
		Connection conn = C3P0Utils.getConnection();
		try {
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + Arrays.toString(params.toArray()));
			List<User> list = queryRunner.query(conn,sql.toString(), params.toArray(), new BeanListHandler<>(User.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return null;
	}

	/**
	 * Limit:m(开始序号0),n（条目数） 每页：20 第一页：0,20-->0-19 第二页:20,20-->20-39
	 * 第三页:40,20-->40-59 开始序号=(pageNo-1)*pageSize
	 * 
	 * @param pageNo
	 *            查询的页数
	 * @param pageSize
	 *            每页大小
	 */
	@SuppressWarnings("deprecation")
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
			// 名称支持模糊查询
			if (t.getName() != null && "".equals(t.getName().trim())) {
				sql.append(" and name like ?");
				params.add("%" + t.getName().trim() + "%");
			}

			// 密码
			if (t.getPassword() != null && "".equals(t.getPassword().trim())) {
				sql.append(" and password=?");
				params.add(t.getPassword());
			}
			// 生日是一个范围查询 开始-结束
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

		}
		sql.append(" limit ?,?");
		params.add((pageNo - 1) * pageSize);
		params.add(pageSize);

		Connection conn = C3P0Utils.getConnection();
		try {
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + Arrays.toString(params.toArray()));
			List<User> list = queryRunner.query(conn, sql.toString(), params.toArray(), new BeanListHandler<User>(User.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return null;
	}

}
