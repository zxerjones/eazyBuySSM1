package com.zxerjones.dao;

import java.util.List;

import com.zxerjones.entity.Address;
import com.zxerjones.entity.bo.AddressBO;

public interface AddressDAO {
	public List<Address> getAddress( int userId ) ;
	public void addAddress(AddressBO addressBO);
	public Address getAddressById(int addressId);
}
