package com.airchina.xn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airchina.xn.dao.UserMapper;
import com.airchina.xn.entities.User;
import com.airchina.xn.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper usermapper;
	
	
	@Override
	public User getUserbyuserName(String username) {
		return usermapper.selectByUserName(username);
	}

	@Override
	public User getUserbyId(Integer id) {
		return usermapper.selectByPrimaryKey(id);
	}

}
