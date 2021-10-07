package com.treeleaf.task.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.treeleaf.task.entity.User;
import com.treeleaf.task.repo.UserRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =userRepo.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("couldnt find user" + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),true,true,true,true, getAuthorities("ROLE-USER")) ;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
		
		return Collections.singletonList(new SimpleGrantedAuthority(role_user));
	}

}
