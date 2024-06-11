package com.jsp.whs.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class WarehouseResponse {
    private int warehouseId;
	private String warehousename ;
	private int totalCapacity;
	

}
