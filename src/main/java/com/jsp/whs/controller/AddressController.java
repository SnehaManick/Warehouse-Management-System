package com.jsp.whs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.whs.requestdto.AddressRequest;
import com.jsp.whs.responsedto.AddressResponse;
import com.jsp.whs.service.AddressService;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PreAuthorize("hasAuthority('CREATE_ADDRESS')")
	@PostMapping("/warehouses/{warehouseId}/address")
    public ResponseEntity<ResponseStructure<AddressResponse>>addAddress( @RequestBody  @Valid AddressRequest addressRequest, @PathVariable int warehouseId){
		return addressService.addAddress(addressRequest, warehouseId);
    }
	
	@PreAuthorize("hasAuthority('CREATE_ADDRESS')")
	@PutMapping("/address/{addressId}")
	public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@RequestBody @Valid AddressRequest addressRequest,
		@PathVariable	int addressId) {
		return addressService.updateAddress(addressRequest, addressId);
	}
	
	@PreAuthorize("hasAuthority('CREATE_ADDRESS')")
	@GetMapping("/address/{addressId}")
	public ResponseEntity<ResponseStructure<AddressResponse>> findAddressById(@PathVariable  int addressId) {
		return addressService.findAddressById(addressId);
		
	}
}
