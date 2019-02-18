package dao.impl;

import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import entity.User;
import entity.UserMapper;
import util.JDBCUtil;

public class UserDaoImpl implements UserDao {

	public User findUserByUserName(String userName) throws SQLException {
		String sql = "select * from user where userName=?";
		List<Object> list = JDBCUtil.executeQuery(sql, new UserMapper(), userName);
		return list.size() > 0 ? (User) list.get(0) : null;
	}

	public void addUser(User user) throws SQLException {
		String sql = "insert into user(id,name,userName,password,sex,phoneNumber) values(?,?,?,?,?,?)";
		JDBCUtil.executeUpdate(sql, user.getId(), user.getName(), user.getUserName(), user.getPassword(), user.getSex(), user.getPhoneNum());
	}

	public List<Object> findAllUsers() throws SQLException {
		String sql = "select * from user";
		List<Object> list = JDBCUtil.executeQuery(sql, new UserMapper());
		return list;
	}

	public boolean updateUser(User user) throws SQLException {
		String sql = "update user set password=?,name=?,sex=?,phoneNumber=?,email=?,address=? where userName=?";
		int result = JDBCUtil.executeUpdate(sql, user.getPassword(), user.getName(), user.getSex(), user.getPhoneNum(), user.getEmail(), user.getAddress(), user.getUserName());
		return result > 0;
	}

}
