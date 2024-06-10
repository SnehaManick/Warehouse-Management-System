  package com.jsp.whs.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.whs.AdminMapper.AdminMapper;
import com.jsp.whs.entity.Admin;
import com.jsp.whs.enums.AdminType;
import com.jsp.whs.exception.SuperAdminAlreadyExistException;
import com.jsp.whs.exception.WarehouseNotFoundByIdException;
import com.jsp.whs.repository.AdminRepository;
import com.jsp.whs.repository.WarehouseRepository;
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

		      return ResponseEntity.status(HttpStatus.CREATED)
		          .body( new ResponseStructure<AdminResponse>()
		              .setStatuscode(HttpStatus.CREATED.value())
		              .setMessage("Admin added")
		              .setData(adminMapper.mapToAdminResponse(admin)));

		      
		    }).orElseThrow( ()-> new WarehouseNotFoundByIdException("Warehouse not found "));
	}
}
	
	









