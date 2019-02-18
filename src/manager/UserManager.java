package manager;

import java.util.List;

import entity.User;
import exception.UserException;

public interface UserManager {
	List<User> findAllUsers() throws UserException;
	boolean addUser(User user) throws UserException;
	User findUserByUserName(String userName) throws UserException;
	boolean updateUser(User user) throws UserException;
}
