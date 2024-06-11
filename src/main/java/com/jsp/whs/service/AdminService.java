package com.jsp.whs.service;

import org.springframework.http.ResponseEntity;

import com.jsp.whs.enums.AdminType;
import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.requestdto.WarehouseRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;

public  interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> addSuperAdmin(AdminRequest adminRequest);

	
	ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@Valid AdminRequest adminRequest, int warehouseId);

	ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@Valid AdminRequest adminRequest);

}
