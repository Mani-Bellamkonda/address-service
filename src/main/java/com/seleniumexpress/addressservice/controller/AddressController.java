package com.seleniumexpress.addressservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.seleniumexpress.addressservice.controller.repo.EmployeeRepo;
import com.seleniumexpress.addressservice.response.AddressResponse;
import com.seleniumexpress.addressservice.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	EmployeeRepo empRepo;

	@Autowired
	AddressService addressService;

	@GetMapping("/address")
	String getAddress() {
		// return the address data along with employee data
		// get the data from address service from hitting this
		// http://localhost:8080/address
		// String address = restTemplate.getForObject("http://localhost:8080/address",
		// String.class);
		return "Mani , TCS ";
	}

	@GetMapping("/address/{employeeId}")
	ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId")int employeeId) {
		
		AddressResponse addressResponse =  addressService.findAddressByEmployeeId(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
		 
	}
}
