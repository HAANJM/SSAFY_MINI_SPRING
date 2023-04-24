package com.ssafy.mini.model.dao;

import java.util.List;

import com.ssafy.mini.model.dto.User;

public interface UserDao {
	
	List<User> selectAll();
	
	int insertUser(User user);

}
