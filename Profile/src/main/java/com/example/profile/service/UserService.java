package com.example.profile.service;

import com.example.profile.model.User;

public interface UserService {
	
	public String addUser(User user);
	
	public User getUserByUserId(int userId);
	
	public String updateUser(User user);

}
