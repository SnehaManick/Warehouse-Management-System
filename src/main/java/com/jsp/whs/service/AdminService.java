package com.jsp.whs.service;

import org.springframework.http.ResponseEntity;

import com.jsp.whs.enums.AdminType;
import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.utility.ResponseStructure;

public  interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> addSuperAdmin(AdminRequest adminRequest);

	//ResponseEntity<ResponseStructure<AdminResponse>> findByAdminType(AdminType adminType);

}
