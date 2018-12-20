package com.tzs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tzs.util.C3P0Utils;



/**
 * 访问用户信息的DAO
 */
public class DictDAO {

	private QueryRunner queryRunner = new QueryRunner();

	/**
	 * 很多业务场景： 1.根据名称来查 2.根据出生年月来查 3.根据用户和密码
	 * 
	 */

	@SuppressWarnings("deprecation")
	public Map<String,String> list(String type) {
		StringBuffer sql = new StringBuffer("select * from dict where dict_type=? ");
		// 封装了参数
		List<Object> params = new ArrayList<>();
		params.add(type);
		Connection conn = C3P0Utils.getConnection();
		try {
			System.out.println("SQL语句:" + sql.toString());
			System.out.println("参数：" + Arrays.toString(params.toArray()));
			Map<String,String> results = queryRunner.query(conn,sql.toString(), params.toArray(), new ResultSetHandler<Map<String,String>>() {

				@Override
				public Map<String, String> handle(ResultSet arg0) throws SQLException {
					Map<String,String> result = new HashMap<>();
					while(arg0.next()){
						
						String key = arg0.getString("key");
						String value = arg0.getString("text");
						result.put(key, value);
					}
					return result;
				}
				
				
			} );
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0Utils.close(conn);
		}

		return null;
	}


}
