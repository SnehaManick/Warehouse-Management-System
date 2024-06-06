package com.jsp.whs.requestdto;

import com.jsp.whs.enums.Privilege;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequest {
	@NotNull( message = "Admin name should not be null")
	@NotBlank( message =  "Admin name should not be blank")
	private String name ;
	
	@NotNull( message = " Email name should not be null")
	@NotBlank( message =  "Email name should not be blank")
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", message = "invalid email ")
	private String email ;
	
	@NotNull( message = "password name cannot be null")
	@NotBlank( message =  " password name cannot be Blank")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must"
			+ " contain at least one letter, one number, one special character")
	private String password ;
	
	
	 
	

}
