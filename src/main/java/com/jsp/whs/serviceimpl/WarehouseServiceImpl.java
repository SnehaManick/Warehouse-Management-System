package com.jsp.whs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.whs.Mapper.WarehouseMapper;
import com.jsp.whs.entity.Warehouse;
import com.jsp.whs.exception.WarehouseNotFoundByIdException;
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

	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> updateWarehouse(
			@Valid WarehouseRequest warehouseRequest, int warehouseId) {

//			return wr.findById(warehouseId).map(existingWarehouse ->{
//				warehouseMapper.mapToWarehouse(warehouseRequest, existingWarehouse);
//				existingWarehouse = wr.save(existingWarehouse);
//				
//				return ResponseEntity.status(HttpStatus.OK)
//						.body(new ResponseStructure<WarehouseResponse>()
//							.setStatuscode(HttpStatus.OK.value())
//							.setMessage("WareHouse Updated")
//							.setData(warehouseMapper.mapToWarehouseResponse(existingWarehouse)));
//			}).orElseThrow(()-> new WarehouseNotFoundByIdException("wareHouse Not found"));
//			
//		}
		
		return	wr.findById(warehouseId)
				.<ResponseEntity<ResponseStructure<WarehouseResponse>>>map(exWarehouse -> {

			exWarehouse = warehouseMapper.mapToWarehouse(warehouseRequest, exWarehouse);

			Warehouse warehouse = wr.save(exWarehouse);

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<WarehouseResponse>()
							.setStatuscode(HttpStatus.OK.value())
							.setMessage("Warehouse Updated")
							.setData(warehouseMapper.mapToWarehouseResponse(warehouse)));
		}).orElseThrow(()-> new WarehouseNotFoundByIdException("Warehouse Not Found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> findWarehouse(int warehouseId) {
		return wr.findById(warehouseId).
		<ResponseEntity<ResponseStructure<WarehouseResponse>>>map(warehouse->{
	
	return ResponseEntity.status(HttpStatus.FOUND)
			.body(new ResponseStructure<WarehouseResponse>()
					.setStatuscode(HttpStatus.FOUND.value())
					.setMessage("Warehouse Found")
					.setData(warehouseMapper.mapToWarehouseResponse(warehouse)));
}).orElseThrow(()-> new WarehouseNotFoundByIdException("Warehouse not found by Id"));
}
	}
	

 
	

