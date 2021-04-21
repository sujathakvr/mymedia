package com.ontarioinc.mediaapp.rest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ontarioinc.mediaapp.db.User;
import com.ontarioinc.mediaapp.db.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserName(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found" + username));
		
		return user.map(MyUserDetails::new).get();
	}

}
