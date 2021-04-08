package com.HCL.Capstone.onlinemusicstore.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.HCL.Capstone.onlinemusicstore.entity.User;
import com.HCL.Capstone.onlinemusicstore.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByUsername(username);
		logger.info("authenticating");
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
		
		return new MyUserDetails(user.get());
	}

}
