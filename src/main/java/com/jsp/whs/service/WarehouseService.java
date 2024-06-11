package com.jsp.whs.service;

import org.springframework.http.ResponseEntity;

import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.requestdto.WarehouseRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.responsedto.WarehouseResponse;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface WarehouseService {

	ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(@Valid  WarehouseRequest warehouseRequest);

//	String warehouse(@Valid AdminRequest adminRequest);

}
