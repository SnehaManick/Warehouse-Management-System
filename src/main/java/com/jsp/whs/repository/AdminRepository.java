package com.jsp.whs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.whs.entity.Admin;
import com.jsp.whs.enums.AdminType;

public  interface  AdminRepository extends  JpaRepository<Admin, Integer> {

	boolean existsByAdminType(AdminType superAdmin);

}
