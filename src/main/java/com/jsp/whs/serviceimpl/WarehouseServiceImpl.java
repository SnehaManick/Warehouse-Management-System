package com.jsp.whs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.whs.AdminMapper.WarehouseMapper;
import com.jsp.whs.entity.Warehouse;
import com.jsp.whs.repository.WarehouseRepository;
import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.requestdto.WarehouseRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.responsedto.WarehouseResponse;
import com.jsp.whs.service.WarehouseService;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;
 
@Service
public class WarehouseServiceImpl implements WarehouseService{
	@Autowired
	private WarehouseRepository wr;
	@Autowired
	private WarehouseMapper warehouseMapper;

	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(@RequestBody WarehouseRequest warehouseRequest) {
	  
		Warehouse warehouse= warehouseMapper.mapToWarehouse(warehouseRequest,  new Warehouse());
        wr.save(warehouse);
        
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ResponseStructure<WarehouseResponse>()
                .setStatuscode(HttpStatus.CREATED.value())
                .setMessage("Warehouse created")
                .setData(warehouseMapper.mapToWarehouseResponse(warehouse)));
		
		
	
	}

 
	
}
