package com.springws.service;

import org.springframework.stereotype.Service;

import com.springws.domain.User;

@Service
public class UserServiceImpl implements UserService{

	public User getUser(String name) {
		User user = new User();
		user.setUsername(name);
		user.setEmail(name+"@emc.com");
		return user;
	}
}
