package com.jsp.whs.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.whs.entity.Admin;

public interface WarehouseRepository extends  JpaRepository<Admin, Integer> {

}
