package com.jsp.whs.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jsp.whs.entity.Address;
import com.jsp.whs.requestdto.AddressRequest;
import com.jsp.whs.responsedto.AddressResponse;

@Component
public class AddressMapper {
	@Autowired
	  private PasswordEncoder passwordEncoder;
	
	  public Address mapToAddress(AddressRequest addressRequest, Address address) {
		  address.setAddressLine(addressRequest.getAddressLine());
		  address.setCity(addressRequest.getCity());
		  address.setState(addressRequest.getState());
		  address.setPincode(addressRequest.getPincode());
		  address.setCountry(addressRequest.getCountry());
		  address.setLongitude(addressRequest.getLongitude());
		  address.setLatitude(addressRequest.getLatitude());
		return address;
		  
	  }
	  public AddressResponse mapToAddressResponse(Address address) {
		  return AddressResponse.builder()
				  .addressId(address.getAddressId())
				  .addressLine(address.getAddressLine())
				  .city(address.getCity())
				  .state(address.getState())
				  .pincode(address.getPincode())
				  .country(address.getCountry())
				  .longitude(address.getLongitude())
				  .latitude(address.getLatitude())
				  .build();
	  }
}
