package com.jsp.whs.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class WarehouseRequest {
	@NotNull( message = "Admin name should not be null")
	@NotBlank( message =  "Admin name should not be blank")
	private String warehousename ;
	
	//private String City;
}
