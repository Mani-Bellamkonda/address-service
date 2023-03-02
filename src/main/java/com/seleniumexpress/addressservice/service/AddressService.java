package com.seleniumexpress.addressservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.addressservice.controller.repo.AddressRepo;
import com.seleniumexpress.addressservice.entity.Address;
import com.seleniumexpress.addressservice.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepo addressRepo;
	

	@Autowired
	ModelMapper modealMapper;
	
	public AddressResponse findAddressByEmployeeId(int employeeId) {
		System.out.println("employeeId "+employeeId);
		Address address = addressRepo.findAddressByEmployeeId(employeeId);
		AddressResponse addressResponse =  modealMapper.map(address, AddressResponse.class);
		return addressResponse;
		
	}
	
}
