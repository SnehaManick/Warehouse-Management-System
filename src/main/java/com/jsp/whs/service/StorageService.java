package com.jsp.whs.service;

import org.springframework.http.ResponseEntity;

import com.jsp.whs.requestdto.StorageRequest;
import com.jsp.whs.responsedto.StorageResponse;
import com.jsp.whs.utility.ResponseStructure;
import com.jsp.whs.utility.SimpleStructure;

import jakarta.validation.Valid;

public interface StorageService {


	public ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest, int wareHouseId, int noOfStorageUnits);

	public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(int storageId,
			StorageRequest storageRequest);

}
