package com.jsp.whs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.whs.repository.AdminRepository;
import com.jsp.whs.repository.WarehouseRepository;
import com.jsp.whs.requestdto.AdminRequest;
import com.jsp.whs.responsedto.AdminResponse;
import com.jsp.whs.service.WarehouseService;
import com.jsp.whs.utility.ResponseStructure;
 
@Service
public class WarehouseServiceImpl implements WarehouseService{
	@Autowired
	private WarehouseRepository wr;

	
}
