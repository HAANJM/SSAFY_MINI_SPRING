package com.ssafy.mini.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mini.model.dao.UserDao;
import com.ssafy.mini.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	@Transactional
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User selectOne(String id) {
		return userDao.selectOne(id);
	}

	@Override
	public int deleteUser(String id) {
		return userDao.deleteUser(id);
	}

}
