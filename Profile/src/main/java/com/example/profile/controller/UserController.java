package com.example.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.profile.model.User;
import com.example.profile.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody User user){
		return ResponseEntity.ok(this.userService.addUser(user));
	}
	
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId){
		return ResponseEntity.ok(this.userService.getUserByUserId(userId));
	}
	
	@GetMapping("/getUserById")
	public ResponseEntity<User> getUserById1(@RequestParam int userId){
		return ResponseEntity.ok(this.userService.getUserByUserId(userId));
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		return ResponseEntity.ok(this.userService.updateUser(user));
	}

}
