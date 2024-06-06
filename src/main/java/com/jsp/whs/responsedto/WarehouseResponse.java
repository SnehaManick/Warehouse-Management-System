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
	private String name ;
	
//	public int warehouseId() {
//		return warehouseId;
//	}
//	public String getName() {
//		return name;
//	}
//
//	public void setwarehouseId(int warehouseId) {
//		this.warehouseId = warehouseId;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
}
