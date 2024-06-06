package com.jsp.whs.responsedto;

import java.util.*;

import com.jsp.whs.enums.AdminType;
public class AdminResponse {
	private int adminId;
	private String name ;
	private String email ;
	private AdminType adminType;
	
	
	public int getAdminId() {
		return adminId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public AdminType getAdminType() {
		return adminType;
	}
	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAdminType(AdminType adminType) {
		this.adminType = adminType;
	}

	

}
