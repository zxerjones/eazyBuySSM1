package com.zxerjones.dao;

import com.zxerjones.entity.User;

public interface UserDAO {
	public int register( User user ) ;
	public User login( User user ) ;
	
	public User searchUserByLoginName(String loginName);
}
