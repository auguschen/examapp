package com.airchina.xn.service;

import com.airchina.xn.entities.User;

public interface UserService {

	public User getUserbyuserName(String username);
	
	public User getUserbyId(Integer id);
}
