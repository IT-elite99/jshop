package cn.tzs.util;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * dao:database access object 数据访问对象
 * 
 * C3P0的辅助类
 * 
 * @author: yixuefei
 * @date: 2018年10月23日 下午2:18:39
 * @version V1.0
 * @Copyright: 2018 www.lixiang.com Inc. All rights reserved.
 */
public class C3P0Utils {

	private C3P0Utils() {
	}

	// 创建一个数据库连接池
	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	static {
		Properties pro = new Properties();
		try {
			pro.load(C3P0Utils.class.getClassLoader().getResourceAsStream("db.properties"));

			// 从属性文件中把配置项拿出来
			String url = pro.getProperty("url");// 把URL地址拿出来
			String driverClass = pro.getProperty("driverClass");
			String user = pro.getProperty("user");
			String password = pro.getProperty("password");
			String maxPoolSize = pro.getProperty("maxPoolSize");
			String minPoolSize = pro.getProperty("minPoolSize");
			String initPoolSize = pro.getProperty("initPoolSize");
			String timeout = pro.getProperty("timeout");
			String maxIdleTime = pro.getProperty("maxIdleTime");
			// 把这些配置项设置到数据库连接池中
			ds.setJdbcUrl(url);
			ds.setDriverClass(driverClass);
			ds.setUser(user);
			ds.setPassword(password);
			// 设置初始化连接数
			ds.setInitialPoolSize(Integer.parseInt(initPoolSize));
			// 设置最大的连接数
			ds.setMaxPoolSize(Integer.parseInt(maxPoolSize));
			// 设置最小的连接数
			ds.setMinPoolSize(Integer.parseInt(minPoolSize));
			// 设置超时时间
			ds.setCheckoutTimeout(Integer.parseInt(timeout));
			// 设置最大的等待时间
			ds.setMaxIdleTime(Integer.parseInt(maxIdleTime));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 从数据库里面获取连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void close(Connection conn, Statement stat) {

		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void close(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	/**
	 * 获取连接池
	 * @return
	 */
	public static DataSource getDataSource() {
		return ds;
	}

}
