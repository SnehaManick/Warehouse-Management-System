  package com.jsp.whs.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jsp.whs.AdminMapper.AdminMapper;
import com.jsp.whs.entity.Admin;
import com.jsp.whs.enums.AdminType;
import com.jsp.whs.exception.AdminNotFoundByEmailException;
import com.jsp.whs.exception.SuperAdminAlreadyExistException;
import com.jsp.whs.exception.WarehouseNotFoundByIdException;
import com.jsp.whs.repository.AdminRepository;
import com.jsp.whs.repository.WarehouseRepository;
import com.jsp.whs.requestdto.AdminRequest; 
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.responsedto.WarehouseResponse;
import com.jsp.whs.service.AdminService;
import com.jsp.whs.utility.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class AdminServiceImpl  implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private WarehouseRepository warehouseRepo;

	
	
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

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(AdminRequest adminRequest, int warehouseId) {
	   
//		 Optional<Warehouse> byId = warehouseRepository.findById(warehouseId);
//		
//		    if (Optional.isEmpty())
//		      throw  new WarehouseNotFoundByIdException( " Warehouse not  exist");
//
//		    Admin   admin = adminMapper.mapToAdmin(adminRequest, new Admin());
//		    admin.setAdminType(AdminType.ADMIN);
//		    admin=adminRepository.save(admin);
//		    Warehouse warehouse = optional.get();
//		    warehouse.setAdmin(admin);
//		    
//		    return ResponseEntity.status(HttpStatus.CREATED)
//		        .body( new ResponseStructure<AdminResponse>()
//		            .setStatuscode(HttpStatus.CREATED.value())
//		            .setMessage("Admin added")
//		            .setData(adminMapper.mapToAdminResponse(admin))
//
//		        )  ;
		
		
		return warehouseRepo.findById(warehouseId).map(warehouse->{
		      Admin   admin = adminMapper.mapToAdmin(adminRequest, new Admin());
		      admin.setAdminType(AdminType.ADMIN);
		      admin=adminRepository.save(admin);
		      warehouse.setAdmin(admin);
		      warehouseRepo.save(warehouse);

		      return ResponseEntity.status(HttpStatus.CREATED)
		          .body( new ResponseStructure<AdminResponse>()
		              .setStatuscode(HttpStatus.CREATED.value())
		              .setMessage("Admin added")
		              .setData(adminMapper.mapToAdminResponse(admin)));
		      
		    }).orElseThrow( ()-> new WarehouseNotFoundByIdException("Warehouse not found "));
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@Valid AdminRequest adminRequest) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String email = auth.getName();
		 
		return adminRepository.findByEmail(email).map(exAdmin ->
		 {
//			 exAdmin.setName(adminRequest.getName());
//			 exAdmin.setEmail(adminRequest.getEmail());
//			 exAdmin.setPassword(adminRequest.getPassword());
			 
			 Admin admin = adminMapper.mapToAdmin(adminRequest, exAdmin);
			 
			  adminRepository.save(admin);
			 
			return ResponseEntity.status(HttpStatus.OK)
					 .body(new ResponseStructure<AdminResponse>()
						.setStatuscode(HttpStatus.OK.value())
						.setMessage("Admin Updated")
						.setData(adminMapper.mapToAdminResponse(admin)));
		 }).orElseThrow(()-> new AdminNotFoundByEmailException("Admin not found"));
		
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdminBySuperAdmin(
			@Valid AdminRequest adminRequest, int adminId) {
		return adminRepository.findById(adminId).map(exAdmin ->
		 {
			 Admin admin = adminMapper.mapToAdmin(adminRequest, exAdmin);
			 
			  adminRepository.save(admin);
			 
			return ResponseEntity.status(HttpStatus.OK)
					 .body(new ResponseStructure<AdminResponse>()
						.setStatuscode(HttpStatus.OK.value())
						.setMessage("Admin Updated")
						.setData(adminMapper.mapToAdminResponse(admin)));
		 }).orElseThrow(()-> new AdminNotFoundByEmailException("Admin Not Found"));
		
	}

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdmin(int adminId) {
		return adminRepository.findById(adminId).map(admin -> ResponseEntity
				.status(HttpStatus.FOUND)
				.body(new ResponseStructure<AdminResponse>()
						.setStatuscode(HttpStatus.FOUND.value())
						.setMessage("Admin found")
						.setData(adminMapper.mapToAdminResponse(admin)))
				).orElseThrow(() ->new AdminNotFoundByEmailException("Admin not found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins() {
		List<AdminResponse> adminsList = adminRepository.findAll().stream().map(admin -> 
		adminMapper.mapToAdminResponse(admin)).toList();
	
	return ResponseEntity.status(HttpStatus.FOUND)
			.body(new ResponseStructure<List<AdminResponse>>()
					.setStatuscode(HttpStatus.FOUND.value())
					.setMessage("Admins Found")
					.setData(adminsList));
	}
	
}









