package com.cognizant.service;
 import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
 
 @Service
 public class UserService implements UserDetailsService{
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	 @Override
	 public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException{
		 return new User("admin",passwordEncoder.encode("admin"),new ArrayList<>());
	 }
 }