package com.jsp.whs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.whs.requestdto.AddressRequest;
import com.jsp.whs.requestdto.StorageRequest;
import com.jsp.whs.responsedto.AddressResponse;
import com.jsp.whs.responsedto.StorageResponse;
import com.jsp.whs.service.StorageService;
import com.jsp.whs.utility.ResponseStructure;
import com.jsp.whs.utility.SimpleStructure;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/v1")
public class StorageController {
	
	@Autowired
	  private StorageService storageService;
	  

	@PreAuthorize("hasAuthority('CREATE_STORAGE')")
	@PostMapping("warehouses/{wareHouseId}/storages")
	public ResponseEntity<SimpleStructure<String>> createStorage(@RequestBody  StorageRequest storageRequest ,
			@PathVariable int wareHouseId, @RequestParam("no_of_storage_units") int noOfStorageUnits ){
		return storageService.createStorage(storageRequest , wareHouseId , noOfStorageUnits);
	}
	
	
	@PreAuthorize("hasAuthority('UPDATE_STORAGE')")
	@PutMapping("/storages/{storageId}")
	public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(@PathVariable int storageId, @RequestBody StorageRequest storageRequest) {
	
		return storageService.updateStorage(storageId, storageRequest);
	}
}
