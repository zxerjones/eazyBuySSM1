package com.zxerjones.service;


import com.zxerjones.entity.User;


public interface UserService {
	public int register( User user ) ;
	public User login( User user ) ;
}
