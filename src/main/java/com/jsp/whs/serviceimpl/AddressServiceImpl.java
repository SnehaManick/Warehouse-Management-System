package com.jsp.whs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.whs.Mapper.AddressMapper;
import com.jsp.whs.entity.Address;
import com.jsp.whs.exception.AddressNotFoundByIdException;
import com.jsp.whs.exception.WarehouseNotFoundByIdException;
import com.jsp.whs.repository.AddressRepository;
import com.jsp.whs.repository.WarehouseRepository;
import com.jsp.whs.requestdto.AddressRequest;
import com.jsp.whs.responsedto.AddressResponse;
import com.jsp.whs.service.AddressService;
import com.jsp.whs.utility.ResponseStructure;
import jakarta.validation.Valid;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private WarehouseRepository warehouseRepository;

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> addAddress(@Valid AddressRequest addressRequest, int warehouseId) {
		
		return warehouseRepository.findById(warehouseId).map(warehouse->{
		 Address address = addressMapper.mapToAddress(addressRequest, new Address());
		 address = addressRepository.save(address);
		 address.setWarehouse(warehouse);
		 warehouseRepository.save(warehouse);
		 
		 return ResponseEntity.status(HttpStatus.CREATED)
				 .body(new ResponseStructure<AddressResponse>()
						 .setStatuscode(HttpStatus.CREATED.value())
						 .setMessage("Address Created")
						 .setData(addressMapper.mapToAddressResponse(address)));
	}).orElseThrow(() -> new WarehouseNotFoundByIdException("Warehouse not found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@Valid AddressRequest addressRequest,
			int addressId) {
		return addressRepository.findById(addressId).map(exaddress ->{
			addressMapper.mapToAddress(addressRequest, exaddress);
			exaddress = addressRepository.save(exaddress);
			return  ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseStructure<AddressResponse>()
							.setStatuscode(HttpStatus.CREATED.value())
							.setMessage("Address Updated")
							.setData(addressMapper.mapToAddressResponse(exaddress)));
		}).orElseThrow(()-> new AddressNotFoundByIdException("Address not found by the given id"));
		
	}

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> findAddressById(int addressId) {
		return addressRepository.findById(addressId).map(address ->
		ResponseEntity.status(HttpStatus.OK)
		.body(new ResponseStructure<AddressResponse>()
				.setStatuscode(HttpStatus.OK.value())
				.setMessage("Address found")
				.setData(addressMapper.mapToAddressResponse(address)))
		).orElseThrow(()-> new AddressNotFoundByIdException("Address not found by the given id"));
	}
	
}
