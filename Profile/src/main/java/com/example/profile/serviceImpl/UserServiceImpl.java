package com.example.profile.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profile.dao.UserDao;
import com.example.profile.model.User;
import com.example.profile.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public String addUser(User user) {
		int obj = 0;
		String finalStr = "";
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			finalStr = "Please Check Password and Confirm Password";
		} else {
			try {
				obj = this.userDao.addUser(user);
				if(obj > 0) {
					finalStr = "New User Created";
				}
			} catch (Exception e) {
				finalStr = "Something went Wrong Please Try again...";
			}
		}
		
		return finalStr;
	}


	@Override
	public User getUserByUserId(int userId) {
		User u = this.userDao.getUserByUserId(userId);
		
		if(u != null){
			return u;
		}
		
		return null;
	}


	@Override
	public String updateUser(User user) {
		int i = this.userDao.updateUser(user);;
		
		if(i > 0) {
			return "User Updated";
		} else {
			return "Something Went wrong Try again";
		}
	}
	
	
	
	

}
