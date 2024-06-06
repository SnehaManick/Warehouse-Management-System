 package com.jsp.whs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.whs.AdminMapper.AdminMapper;
import com.jsp.whs.entity.Admin;
import com.jsp.whs.enums.AdminType;
import com.jsp.whs.enums.Privilege;
import com.jsp.whs.exception.SuperAdminAlreadyExistException;
import com.jsp.whs.repository.AdminRepository;
import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.service.AdminService;
import com.jsp.whs.utility.ResponseStructure;

@Service
public class AdminServiceImpl  implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> addSuperAdmin(AdminRequest adminRequest) {
		if(adminRepository.existsByAdminType(AdminType.SUPER_ADMIN))
			throw new SuperAdminAlreadyExistException("SuperAdmin already exist");
		
		 Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
		 admin.setAdminType(AdminType.SUPER_ADMIN);
		 admin = adminRepository.save(admin);
		 
		 return ResponseEntity.status(HttpStatus.CREATED)
				 .body(new ResponseStructure<AdminResponse>()
						 .setStatuscode(HttpStatus.CREATED.value())
						 .setMessage("Admin Created")
						 .setData(adminMapper.mapToAdminResponse(admin)));
	                     //.orElseThrow(() -> new AdminNotFoundException("Illegeal")));
	}

//	@Override
//	public ResponseEntity<ResponseStructure<AdminResponse>> findByAdminType(AdminType adminType) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	}
	
	



