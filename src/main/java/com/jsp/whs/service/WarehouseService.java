package com.jsp.whs.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.requestdto.WarehouseRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.responsedto.WarehouseResponse;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface WarehouseService {

	ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(@Valid  WarehouseRequest warehouseRequest);

	ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(@Valid WarehouseRequest warehouseRequest,
			int warehouseId);

	ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId);

	ResponseEntity<ResponseStructure<List<WarehouseResponse>>> findWarehouses();

//	String warehouse(@Valid AdminRequest adminRequest);

}
