package com.example.profile.model;

import java.util.Date;

public class User {
	
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private String password;
	private String confirmPassword;
	private Date createdDate;
	private Date lastModifoedDate;
	
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifoedDate() {
		return lastModifoedDate;
	}
	public void setLastModifoedDate(Date lastModifoedDate) {
		this.lastModifoedDate = lastModifoedDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", createdDate=" + createdDate + ", lastModifoedDate=" + lastModifoedDate + "]";
	}
}
