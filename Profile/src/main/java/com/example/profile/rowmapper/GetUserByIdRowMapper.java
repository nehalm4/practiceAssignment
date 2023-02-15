package com.example.profile.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.profile.model.User;

public class GetUserByIdRowMapper implements org.springframework.jdbc.core.RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User();
		
		u.setUserId(rs.getInt("USER_ID"));
		u.setFirstName(rs.getString("FIRST_NAME"));
		u.setLastName(rs.getString("LAST_NAME"));
		u.setPhoneNo(rs.getString("PHONE_NO"));
		u.setEmail(rs.getString("EMAIL"));
		u.setCreatedDate(rs.getTimestamp("CREATED_DATE"));
		u.setLastModifoedDate(rs.getTimestamp("LAST_MODIFIED_DATE"));
		u.setPassword(rs.getString("PASSWORD"));
		u.setConfirmPassword("..");
		return u;
	}

}
