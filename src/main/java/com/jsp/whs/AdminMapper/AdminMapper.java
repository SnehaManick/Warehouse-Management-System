 package com.jsp.whs.AdminMapper;

import org.springframework.stereotype.Component;

import com.jsp.whs.entity.Admin;
import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.responsedto.AdminResponse;
@Component
public class AdminMapper {

	public  Admin mapToAdmin(AdminRequest adminRequest, Admin admin) {
		 admin.setName(adminRequest.getName());
		 admin.setEmail(adminRequest.getEmail());
		 admin.setPassword(adminRequest.getPassword());
		return  admin;
	}

	 
	public  AdminResponse mapToAdminResponse(Admin admin) {
		 
		 AdminResponse adminResponse = new AdminResponse() ;
		 adminResponse.setAdminId(admin.getAdminId());
		 adminResponse.setName(admin.getName());
		 adminResponse.setEmail(admin.getEmail());
		 adminResponse.setAdminType(admin.getAdminType());
		
		 return adminResponse;
	}

}
