package carss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBCʵ��MYSQL���ݿ�����,��ֹ��SQLע��
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

	private static final String CLASS = "com.mysql.jdbc.Driver"; // ������
	private static final String DRIVER = "jdbc:mysql://localhost:3306/creditcardm"; // ����
	private static final String USERNAME = "root"; // ���ݿ��û���
	private static final String PWD = "840803xxxx"; // ���ݿ�����

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * ��ȡ���Ӷ���
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
	 * ��ѯ����(һ����Ŀ���Ƿ���ResultSet��һ�㷵�ؼ��ϻ����)
	 * 
	 * @param sql
	 * @param pare
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(String sql, Object[] pare) throws Exception {

		ps = conn.prepareStatement(sql);
		// ���ò���
		for (int i = 0; i < pare.length; i++) {
			ps.setObject(i + 1, pare[i]);
		}
		rs = ps.executeQuery();

		return rs;
	}

	/**
	 * ��ɾ�Ĳ���
	 * 
	 * @param sql
	 * @param pare
	 * @return
	 * @throws Exception
	 */
	public int edit(String sql, Object[] pare) throws Exception {

		int hasEffect = 0; // Ӱ������
		ps = conn.prepareStatement(sql);
		// ���ò���
		for (int i = 0; i < pare.length; i++) {
			ps.setObject(i + 1, pare[i]);
		}
		hasEffect = ps.executeUpdate();
		return hasEffect;
	}

	/**
	 * �ر����ж���
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
	 * ����
	 * 
	 * @param args
	 */

}