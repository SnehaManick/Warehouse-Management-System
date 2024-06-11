package com.jsp.whs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.requestdto.WarehouseRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.service.AdminService;
import com.jsp.whs.utility.ErrorStructure;
import com.jsp.whs.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
	
	 @Autowired
	 private AdminService adminService;
	 
	  @Operation( description = " the endpont is used to add the superadmin in the data base" , responses= {
			 @ApiResponse ( responseCode = "201",description = "Admin created") ,
			 @ApiResponse( responseCode =  "400" , description =  "Invalid input ", content = {
					 @Content ( schema = @Schema( oneOf = ErrorStructure.class))
			 })
	  })
	 @PostMapping("/register")
	public ResponseEntity<ResponseStructure<AdminResponse>> addSuperAdmin( @RequestBody  @Valid AdminRequest adminRequest){
		return adminService.addSuperAdmin(adminRequest);
	}
	  @PreAuthorize("hasAuthority('CREATE_ADMIN')")
	  @PostMapping("warehouses/{warehouseId}/admins")
	  public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@RequestBody @Valid  AdminRequest adminRequest, @PathVariable int warehouseId){
		return adminService.createAdmin(adminRequest, warehouseId);  
	  }
	  
	 
	  @PutMapping("/admins")
	  public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody @Valid  AdminRequest adminRequest){
			return adminService.updateAdmin(adminRequest);  
		  }
	  
	  

}
