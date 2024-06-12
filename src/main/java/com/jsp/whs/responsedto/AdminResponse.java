package com.jsp.whs.responsedto;

import com.jsp.whs.enums.AdminType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class AdminResponse {

	private int adminId;
	private String name ;
	private String email ;
	private AdminType adminType;
	


	

}
