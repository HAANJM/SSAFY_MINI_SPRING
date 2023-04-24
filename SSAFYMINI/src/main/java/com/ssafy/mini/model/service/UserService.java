package com.ssafy.mini.model.service;

import java.util.List;

import com.ssafy.mini.model.dto.User;

public interface UserService {
	
	List<User> selectAll();
	
	int insertUser(User user);

}
