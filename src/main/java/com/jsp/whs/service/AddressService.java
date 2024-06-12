package com.jsp.whs.service;

import org.springframework.http.ResponseEntity;

import com.jsp.whs.requestdto.AddressRequest;
import com.jsp.whs.responsedto.AddressResponse;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface AddressService {

	ResponseEntity<ResponseStructure<AddressResponse>> addAddress(@Valid AddressRequest addressRequest,
			int warehouseId);

	ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@Valid AddressRequest addressRequest,
			int addressId);

	ResponseEntity<ResponseStructure<AddressResponse>> findAddressById(int addressId);


}
