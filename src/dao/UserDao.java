package dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import entity.Flight;
import entity.User;

public interface UserDao {
	/**
	 * 显示所有用户对象
	 * 
	 * @return
	 */
	List<Object> findAllUsers() throws SQLException;

	/**
	 * 注册用户对象
	 * 
	 * @param
	 * @return doctor
	 */
	void addUser(User User) throws SQLException;

	/**
	 * 查找用户信息
	 * 
	 * @param user
	 * @return
	 */
	User findUserByUserName(String userName) throws SQLException;

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 */
	boolean updateUser(User user) throws SQLException;
}
