package com.jsp.whs.responsedto;

import java.util.List;

import org.springframework.security.config.http.MatcherType;

import com.jsp.whs.enums.MaterialType;


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
public class StorageResponse {

	private int storageId;
	private String blockName;
	private String section;
	private double capacityInKg;
	List<MaterialType> materialTypes;
	private double maxAdditionalWeight;
	private double availableArea;
}

