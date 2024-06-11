package com.jsp.whs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.requestdto.WarehouseRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.responsedto.WarehouseResponse;
import com.jsp.whs.service.WarehouseService;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class WarehouseController {

	@Autowired
	 private WarehouseService ws;
	
	    @PreAuthorize("hasAuthority('CREATE_WAREHOUSE')")
	     @PostMapping("/warehouses")
		public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse( @RequestBody  @Valid WarehouseRequest warehouseRequest){
			return ws.createWarehouse(warehouseRequest);
		}
}
