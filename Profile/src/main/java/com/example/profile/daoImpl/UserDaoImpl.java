package com.example.profile.daoImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.example.profile.dao.UserDao;
import com.example.profile.model.User;
import com.example.profile.rowmapper.GetUserByIdRowMapper;

@Repository
public class UserDaoImpl implements UserDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
    	this.dataSource = dataSource;
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
    	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int addUser(User user) {		
		SimpleJdbcInsert addUser = new SimpleJdbcInsert(dataSource).withTableName("user").usingGeneratedKeyColumns("USER_ID");
        Map<String, Object> map = new HashMap<String, Object>();
        int userId = 0;
        map.put("FIRST_NAME", user.getFirstName());
        map.put("LAST_NAME", user.getLastName());
        map.put("EMAIL", user.getEmail());
        map.put("PASSWORD", user.getPassword());
        map.put("PHONE_NO", user.getPhoneNo());
        map.put("CREATED_DATE", new Date());
        map.put("LAST_MODIFIED_DATE", new Date());
        try {
            userId = addUser.executeAndReturnKey(map).intValue();
            return userId;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
	}

	@Override
	public User getUserByUserId(int userId) {
		String sql = "SELECT u.* FROM user u WHERE u.USER_ID=?";
		User  u = null;
		
		try {
			u = this.jdbcTemplate.queryForObject(sql, new GetUserByIdRowMapper(), userId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return u;
	}

	@Override
	public int updateUser(User user) {
		int i = 0;
		 Map<String, Object> params = new HashMap<>();
		 params.put("FIRST_NAME", user.getFirstName());
		 params.put("LAST_NAME", user.getLastName());
		 params.put("EMAIL", user.getEmail());
		 params.put("PHONE_NO", user.getPhoneNo());
		 params.put("PASSWORD", user.getPassword());
		 params.put("LAST_MODIFIED_DATE", new Date());
		 params.put("USER_ID", user.getUserId());
		 
		 String sql = "UPDATE user SET user.FIRST_NAME=:FIRST_NAME, user.LAST_NAME=:LAST_NAME, user.EMAIL=:EMAIL, user.PHONE_NO=:PHONE_NO, user.PASSWORD=:PASSWORD, user.LAST_MODIFIED_DATE=:LAST_MODIFIED_DATE WHERE user.USER_ID=:USER_ID";
		 
		 try {
			 i = this.namedParameterJdbcTemplate.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
}
