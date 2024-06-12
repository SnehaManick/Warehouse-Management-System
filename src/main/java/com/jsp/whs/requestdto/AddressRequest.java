package com.jsp.whs.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
	
	@NotNull( message = "AddressLine should not be null")
	@NotBlank( message =  "AddressLine should not be blank")
	 private String addressLine;
	
	@NotNull( message = "City name should not be null")
	@NotBlank( message =  "City name should not be blank")
    private String city;
	
	@NotNull( message = "State name should not be null")
	@NotBlank( message =  "State name should not be blank")
	private String state;
	
	@NotNull( message = "Pincode name should not be null")
	@NotBlank( message =  "Pincode name should not be blank")
	private String pincode;
	
	@NotNull( message = "Country name should not be null")
	@NotBlank( message =  "Country name should not be blank")
	   private String country;
	
	   private String longitude;
	   private String latitude;
}
