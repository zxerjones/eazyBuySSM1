package com.zxerjones.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxerjones.dao.AddressDAO;
import com.zxerjones.entity.Address;
import com.zxerjones.entity.bo.AddressBO;
import com.zxerjones.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressDAO addressDAO ;
	@Override
	public List<Address> getAddress(int userId) {
		// TODO Auto-generated method stub
		return addressDAO.getAddress(userId);
	}
	@Override
	public void addAddress(int userId, String address, String createName, String remark) {
		// TODO Auto-generated method stub
		AddressBO addressBO = new AddressBO(userId, address, createName, remark);
		addressDAO.addAddress(addressBO);
	}
	@Override
	public Address getAddressById(int addressId) {
		// TODO Auto-generated method stub
		return addressDAO.getAddressById(addressId);
	}

}
