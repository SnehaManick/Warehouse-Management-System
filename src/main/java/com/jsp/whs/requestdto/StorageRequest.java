package com.jsp.whs.requestdto;

import java.util.List;

import com.jsp.whs.enums.MaterialType;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StorageRequest {
	
	private String blockName;
	private String section;
	private double capacityInWeight;
	private double lengthInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	List<MaterialType> materialTypes;
	
	
}