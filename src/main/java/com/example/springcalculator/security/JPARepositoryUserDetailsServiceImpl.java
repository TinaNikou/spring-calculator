package com.example.springcalculator.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.springcalculator.model.User;
import com.example.springcalculator.repo.UserRepository;

@Component
public class JPARepositoryUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optUser = userRepo.findById(username);
		
		if (optUser.isEmpty()) {
			throw new UsernameNotFoundException(username + " was not found.");
		}
		
		return optUser.get();
	}

}
