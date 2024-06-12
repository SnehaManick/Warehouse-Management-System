package com.jsp.whs.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse {
	   private int addressId;
	   private String addressLine;
	   private String city;
	   private String state;
	   private String pincode;
	   private String country;
	   private String longitude;
	   private String latitude;
}
