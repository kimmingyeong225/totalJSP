package com.tenco.repository.interfaces;

import java.util.List;

import com.tenco.model.User;

public interface UserRepository {
	
	int addUser(User user);
	void deleteUser(int id);
	User getUserByusername(String username);
	User getUserByusernameAndPassword(String username, String password);
	List<User> getAllUsers();

}
