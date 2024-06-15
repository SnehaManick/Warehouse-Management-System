package com.jsp.whs.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jsp.whs.entity.Warehouse;

public interface WarehouseRepository extends  JpaRepository<Warehouse, Integer> {

	//Optional<Warehouse> findByCity(String city);

}
