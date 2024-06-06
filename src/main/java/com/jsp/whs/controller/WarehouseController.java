package com.jsp.whs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.whs.service.WarehouseService;

@RestController
@RequestMapping("api/v1")
public class WarehouseController {

//	@Autowired
//	 private WarehouseService ws;
	
	 @GetMapping("/warehouses")
		public String saveWarehouse (){
			return "Warehouse found";
		}
}
