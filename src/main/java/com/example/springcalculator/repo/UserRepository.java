package com.example.springcalculator.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springcalculator.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	int countByUsername(String string);

}
