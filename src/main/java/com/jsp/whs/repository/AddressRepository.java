package com.jsp.whs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.whs.entity.Address;
import com.jsp.whs.entity.Warehouse;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findWarehousesByCity(String city);


 

}
