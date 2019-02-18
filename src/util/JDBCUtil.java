package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

import org.apache.commons.dbcp.BasicDataSourceFactory;

//import java0114.dao.RowMapperObject;//复制粘贴代码时，使用的包也会被复制过来，需要注意是否真的需要该包

/**
 * jdbc的工具类 定义静态方法 获得数据库连接、执行sql、释放资源
 */
public class JDBCUtil {
	// 只需要加载一次文件，只需要注册一次
	static Properties prop = new Properties();
	static DataSource ds = null;
	static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	static {
		try {
			prop.load(new FileInputStream("src/conn.properties"));
			// Class.forName(prop.getProperty("driver"));
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "暂时无法提供服务，请耐心等待", "错误提示", JOptionPane.ERROR_MESSAGE);
			// 写日志，“服务器错误，连接数据库的配置文件参数错误”
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "暂时无法提供服务，请耐心等待", "错误提示", JOptionPane.ERROR_MESSAGE);
			// 写日志，“服务器错误，连接数据库的配置文件参数错误”
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "暂时无法提供服务，请耐心等待", "错误提示", JOptionPane.ERROR_MESSAGE);
			// 写日志，“服务器错误，连接数据库的配置文件参数错误”
		}
	}

	/**
	 * 获得连接对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	static public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// conn = DriverManager.getConnection(prop.getProperty("url"),prop);
			conn = threadLocal.get();
			if (conn == null) {
				conn = ds.getConnection();
				threadLocal.set(conn);
			}
		} catch (SQLException e) {
			// e.printStackTrace(); //开发过程中使用的错误提示
			// JOptionPane.showMessageDialog(null,
			// "服务器错误","错误提示",JOptionPane.ERROR_MESSAGE);
			throw e;
		}
		return conn;
	}

	/**
	 * 执行增删改
	 * 
	 * @param sql
	 *            参数化的sql，也可以没有参数
	 * @param objects
	 *            要设置的参数的值
	 * @return 执行结果，若操作修改了原有数据则返回大于0的数，否则返回0
	 * @throws SQLException 
	 */
	static public int executeUpdate(String sql, Object... objects) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			// 获得连接
			conn = getConnection();
			// 执行sql
			pstmt = conn.prepareStatement(sql);// 将sql预编译到prepaedStatement中
			setParm(pstmt, objects);// 设置占位符
			result = pstmt.executeUpdate();// 执行
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(null, pstmt, null);// 释放资源
		}
		return result;
	}

	static void setParm(PreparedStatement pstmt, Object... objects) throws SQLException {
		for (int i = 0; i < objects.length; i++) {
			pstmt.setObject(i + 1, objects[i]);
		}
	}

	/**
	 * 查询，循环中转为对象的过程使用接口RowMappingObject实现， 由接口的实现类完成对象的转换工作。
	 * 该查询方法可以脱离具体的查询表也及时回收了系统资源。
	 * 
	 * @param sql
	 * @param rmo
	 *            行映射接口
	 * @param objects
	 * @return
	 * @throws SQLException 
	 */
	public static List<Object> executeQuery(String sql, RowMapperObject rmo, Object... objects) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Object> list = new ArrayList<Object>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			setParm(pstmt, objects);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 将结果集转为对象,回调，用接口实现回调
				Object o = rmo.rowMapperObject(rs);
				// 将对象添加到集合中
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			close(rs, pstmt, null);
		}
		return list;
	}

	static void close(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
				threadLocal.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
