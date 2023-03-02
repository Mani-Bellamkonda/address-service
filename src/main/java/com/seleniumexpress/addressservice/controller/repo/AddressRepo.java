package com.seleniumexpress.addressservice.controller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seleniumexpress.addressservice.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{
	
	@Query(nativeQuery = true, value="SELECT ea.id,ea.line1,ea.line2,ea.state,ea.zip FROM seleniumexpress.address AS ea JOIN seleniumexpress.employee AS e ON e.id = ea.employee_id WHERE ea.employee_id =:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId")int employeeId);
	

}
