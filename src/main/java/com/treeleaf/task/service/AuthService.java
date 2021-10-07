package com.treeleaf.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.treeleaf.task.dto.LoginRequest;
import com.treeleaf.task.dto.RegisterRequest;
import com.treeleaf.task.entity.User;
import com.treeleaf.task.repo.UserRepo;
import com.treeleaf.task.security.JwtProvider;


@Service
public class AuthService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;

	public void signup(RegisterRequest registerRequest) {
		User user = new User();
		user.setUserName(registerRequest.getUsername());
		user.setPassword(encodepassword(registerRequest.getPassword()));
		user.setEmail(registerRequest.getEmail());
		
		userRepo.save(user);
	}
    
	private String encodepassword(String password) {
		
		return passwordEncoder.encode(password);
	}
	
	public String login(LoginRequest loginRequest) {
	Authentication authenticate =	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		return jwtProvider.generateToken(authenticate);
	}

	public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return Optional.of(principal);
	}

}
