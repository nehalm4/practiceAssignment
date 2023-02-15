package com.example.profile.dao;

import com.example.profile.model.User;

public interface UserDao {
	
	public int addUser(User user);
	
	public User getUserByUserId(int userId);
	
	public int updateUser(User user);

}
