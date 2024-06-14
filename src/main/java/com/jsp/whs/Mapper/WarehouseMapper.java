package com.jsp.whs.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jsp.whs.entity.Warehouse;
import com.jsp.whs.requestdto.WarehouseRequest;
import com.jsp.whs.responsedto.WarehouseResponse;
@Component
public class WarehouseMapper {
	@Autowired
	  private PasswordEncoder passwordEncoder;

	  public Warehouse mapToWarehouse(WarehouseRequest warehouseRequest, Warehouse warehouse) {
	    warehouse.setWarehousename(warehouseRequest.getWarehousename());
	    return warehouse;
	  }

	  public WarehouseResponse mapToWarehouseResponse(Warehouse warehouse) {
	    return WarehouseResponse.builder()
	        .warehouseId(warehouse.getWarehouseId())
	        .warehousename(warehouse.getWarehousename())
	        .totalCapacity(warehouse.getTotalCapacity())
	        .build();
	  }
}
