package com.jsp.whs.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.whs.Mapper.StorageMapper;
import com.jsp.whs.entity.Storage;
import com.jsp.whs.entity.Warehouse;
import com.jsp.whs.exception.StorageNotFoundByIdException;
import com.jsp.whs.exception.WarehouseNotFoundByIdException;
import com.jsp.whs.repository.StorageRepository;
import com.jsp.whs.repository.WarehouseRepository;
import com.jsp.whs.requestdto.StorageRequest;
import com.jsp.whs.responsedto.StorageResponse;
import com.jsp.whs.service.StorageService;
import com.jsp.whs.utility.ResponseStructure;
import com.jsp.whs.utility.SimpleStructure;

import jakarta.validation.Valid;

@Service
public class StorageServiceImpl  implements StorageService{

	@Autowired
	private StorageRepository storageRepo;

	@Autowired
	private StorageMapper storageMapper;

	@Autowired
	private WarehouseRepository warehouseRepo;

	@Override
	public ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest,
			int wareHouseId, int noOfStorageUnits) {

		Warehouse wareHouse =  warehouseRepo.findById(wareHouseId).orElseThrow(()-> new WarehouseNotFoundByIdException(""));

			List<Storage> storages = new ArrayList<Storage>();
			
			int count = 0;

			while(noOfStorageUnits > 0) {
			
			Storage storage  = storageMapper.mapToStorage(storageRequest, new Storage());
			
			storage.setMaxAdditionalWeight(storageRequest.getCapacityInWeight());
			storage.setAvailableArea(storageRequest.getLengthInMeters() * storageRequest.getBreadthInMeters() * storageRequest.getHeightInMeters());
			
			wareHouse.setTotalCapacity(storageRequest.getCapacityInWeight() * noOfStorageUnits + wareHouse.getTotalCapacity());
			storage.setWareHouse(wareHouse);
			
			storages.add(storage);
			count++;
			noOfStorageUnits --;
		}
		
		storageRepo.saveAll(storages);
		warehouseRepo.save(wareHouse);

		
		return ResponseEntity.status(HttpStatus.CREATED).body(new SimpleStructure<String>()
				.setStatus(HttpStatus.CREATED.value())
				.setMesssage(""+count + " Storages created"));

	}

	@Override
	public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(int storageId,
			StorageRequest storageRequest) {
		
		
		return storageRepo.findById(storageId).map(existingStorage -> {
			
			existingStorage = storageMapper.mapToStorage(storageRequest, existingStorage);
			storageRepo.save(existingStorage);
			
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseStructure<StorageResponse>()
					.setStatuscode(HttpStatus.OK.value())
					.setMessage("Storage updsates")
					.setData(storageMapper.mapToStorageResponse(existingStorage)));
					
			
		}).orElseThrow(()-> new StorageNotFoundByIdException("storage Not Found"));
	}


}




