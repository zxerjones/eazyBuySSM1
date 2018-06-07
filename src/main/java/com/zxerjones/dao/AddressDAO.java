package com.zxerjones.dao;

import java.util.List;

import com.zxerjones.entity.Address;

public interface AddressDAO {
	public List<Address> getAddress( int userId ) ;
}
