package carss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBC实现MYSQL数据库连接,防止了SQL注入
 * 
 * @author Administrator
 * 
 */
public class JdbcConn {

	public JdbcConn() {
		try {
			this.setConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final String CLASS = "com.mysql.jdbc.Driver"; // 驱动类
	private static final String DRIVER = "jdbc:mysql://localhost:3306/creditcardm"; // 驱动
	private static final String USERNAME = "root"; // 数据库用户名
	private static final String PWD = "840803xxxx"; // 数据库密码

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * 获取连接对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection setConnection() throws Exception {

		Class.forName(CLASS);
		conn = DriverManager.getConnection(DRIVER, USERNAME, PWD);
		return conn;
	}

	/**
	 * 查询操作(一般项目不是返回ResultSet，一般返回集合或对象)
	 * 
	 * @param sql
	 * @param pare
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(String sql, Object[] pare) throws Exception {

		ps = conn.prepareStatement(sql);
		// 设置参数
		for (int i = 0; i < pare.length; i++) {
			ps.setObject(i + 1, pare[i]);
		}
		rs = ps.executeQuery();

		return rs;
	}

	/**
	 * 增删改操作
	 * 
	 * @param sql
	 * @param pare
	 * @return
	 * @throws Exception
	 */
	public int edit(String sql, Object[] pare) throws Exception {

		int hasEffect = 0; // 影响行数
		ps = conn.prepareStatement(sql);
		// 设置参数
		for (int i = 0; i < pare.length; i++) {
			ps.setObject(i + 1, pare[i]);
		}
		hasEffect = ps.executeUpdate();
		return hasEffect;
	}

	/**
	 * 关闭所有对象
	 * 
	 * @throws Exception
	 */
	public void closeAll() throws Exception {

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */

}