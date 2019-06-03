package com.zxerjones.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxerjones.dao.UserDAO;
import com.zxerjones.entity.User;
import com.zxerjones.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO ;
	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		return userDAO.register(user);
	}
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDAO.login( user );
	}
	@Override
	public User searchUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userDAO.searchUserByLoginName(loginName);
	}

}
