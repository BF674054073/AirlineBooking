package service;

import entity.User;

public interface UserService {
	boolean register(User user);
	boolean login();
	
	
}
