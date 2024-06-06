package com.jsp.whs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jsp.whs.repository.AdminRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
    @Autowired
	private AdminRepository ar;
    
	@Override
	public UserDetails loadUserByUsername(String username) {    
		    return ar.findByEmail(username)
		        .map(UserDetailImpl::new)
		        .orElseThrow( ()-> new  UsernameNotFoundException(" User not found "));  
		  }
		
		
		
		
//		return ar.findByEmail(username)
//				
//		//.map(admin ->new UserDetailImpl(admin))
//		
//		.map(UserDetailImpl :: new)
//        .orElseThrow() -> new UsernameNotFoundException("User not found exception"));
		
	

}
