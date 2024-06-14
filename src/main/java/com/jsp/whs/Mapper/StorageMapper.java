package com.jsp.whs.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jsp.whs.entity.Storage;
import com.jsp.whs.requestdto.StorageRequest;
import com.jsp.whs.responsedto.StorageResponse;

@Component
public class StorageMapper {
	@Autowired
	  private PasswordEncoder passwordEncoder;
	  
	public Storage mapToStorage(StorageRequest storageRequest, Storage storage) {

		storage.setBlockName(storageRequest.getBlockName());
		storage.setSection(storageRequest.getSection());
		storage.setLengthInMeters(storageRequest.getLengthInMeters());
		storage.setBreadthInMeters(storageRequest.getBreadthInMeters());
		storage.setHeightInMeters(storageRequest.getHeightInMeters());
		storage.setCapacityInWeight(storageRequest.getCapacityInWeight());
		storage.setMaterialTypes(storageRequest.getMaterialTypes());

		return storage;

	}

	public StorageResponse mapToStorageResponse(Storage storage) {
		return StorageResponse.builder()
				.storageId(storage.getStorageId())
				.blockName(storage.getBlockName())
				.section(storage.getSection())
				.capacityInKg(storage.getCapacityInWeight())
				.materialTypes(storage.getMaterialTypes())
				.availableArea(storage.getAvailableArea())
				.maxAdditionalWeight(storage.getMaxAdditionalWeight())
				.materialTypes(storage.getMaterialTypes())
				.build();



	}


}
