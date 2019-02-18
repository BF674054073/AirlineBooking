package manager.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import exception.UserException;
import manager.UserManager;
import objectfactory.ObjectFactory;
import util.Transaction;

public class UserManagerImpl implements UserManager {
	Transaction transaction = (Transaction) ObjectFactory.getObject("transaction");
	UserDao userDao = (UserDao) ObjectFactory.getObject("userdao");

	// UserDao userDao = new UserDaoImpl();

	public User findUserByUserName(String userName) throws UserException {
		User user = null;
		try {
			transaction.start();
			user = userDao.findUserByUserName(userName);
			transaction.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public boolean addUser(User user) throws UserException {
		try {
			// 启动事务
			transaction.start();
			userDao.addUser(user);
			transaction.commit();
		} catch (SQLException e) {
			throw new UserException(e.getMessage());
		}
		return true;
	}

	public List<User> findAllUsers() throws UserException {
		List<User> users = new ArrayList<User>();
		try {
			List<Object> list = userDao.findAllUsers();
			for (Object object : list) {
				users.add((User) object);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException(e.getMessage());
		}
	}

	public boolean updateUser(User user) throws UserException {
		try {
			transaction.start();
			userDao.updateUser(user);
			transaction.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public static void main(String[] args) throws UserException {
		UserManagerImpl userManagerImpl = new UserManagerImpl();
		User user = new User("123456", "zhangsan", "zhangsan", "123456", "男", "123456", null, null);
		boolean b = userManagerImpl.addUser(user);
		System.out.println(b ? "成功" : "失败");

	}

}
