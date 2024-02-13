package com.example.springcalculator.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springcalculator.model.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Integer> {
	int countByRoleName(String string);
	
	Permission findByRoleName(String string);
}
