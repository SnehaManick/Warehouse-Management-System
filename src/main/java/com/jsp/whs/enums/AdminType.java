package com.jsp.whs.enums;

import java.util.List;

public enum AdminType {
	SUPER_ADMIN(List.of( 
			Privilege.CREATE_ADMIN,
			Privilege.CREATE_WAREHOUSE,
			Privilege.CREATE_ADDRESS,
			Privilege.CREATE_STORAGE,
			Privilege.UPDATE_ADMIN ,
			Privilege.UPDATE_WAREHOUSE,
			Privilege.UPDATE_ADDRESS,
			Privilege.UPDATE_STORAGE,
			Privilege.DEL_ADMIN ,
			Privilege.DEL_WAREHOUSE,
			Privilege.DEL_ADDRESS,
			Privilege.DEL_STORAGE)),
	ADMIN (List.of( Privilege.CREATE_STORAGE,Privilege.UPDATE_ADMIN ,Privilege.UPDATE_STORAGE,Privilege.DEL_STORAGE));


	private List<Privilege> privileges;

	AdminType(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}
}