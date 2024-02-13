package com.example.springcalculator.security;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.springcalculator.model.Permission;
import com.example.springcalculator.model.User;
import com.example.springcalculator.repo.PermissionRepository;
import com.example.springcalculator.repo.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class FirstUserConfigurer {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PermissionRepository permRepo;
	@Autowired
	private UserRepository userRepo;

	@PostConstruct
	public void setup() {

		if (permRepo.countByRoleName("ADMIN") < 1) {
			permRepo.save(new Permission("ADMIN"));
		}

		if (permRepo.countByRoleName("USER") < 1) {
			permRepo.save(new Permission("USER"));
		}

		if (userRepo.countByUsername("admin") < 1) {
			User u = new User();
			u.setUsername("admin");
			u.setPassword(passwordEncoder.encode("password"));
			List<Permission> p = new LinkedList<Permission>();
			p.add(permRepo.findByRoleName("ADMIN"));
			u.setPermissions(p);
			
			userRepo.save(u);
		}
	}
}
