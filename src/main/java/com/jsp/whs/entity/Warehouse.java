package com.jsp.whs.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int warehouseId;
	private String warehousename;
	private int totalCapacity;
	
	//private String city;
	
	@OneToOne
	private Admin admin;


}
