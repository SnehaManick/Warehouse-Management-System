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
<<<<<<< HEAD
  private int warehouseId;
  private String zname;
=======
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int warehouseId;
	private String warehousename;
	
	@OneToOne
	private Admin admin;

>>>>>>> 0166a88fce1c730a27a61dd3ff027df77e57b1c7
}
