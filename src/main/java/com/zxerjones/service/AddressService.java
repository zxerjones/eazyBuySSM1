package com.zxerjones.service;

import java.util.List;

import com.zxerjones.entity.Address;

public interface AddressService {
	public List<Address> getAddress( int userId ) ;
	
	public void addAddress(int userId, String address, String createName, String remark);
	
	public Address getAddressById(int addressId);
}
