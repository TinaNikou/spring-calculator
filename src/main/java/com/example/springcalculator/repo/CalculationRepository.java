package com.example.springcalculator.repo;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springcalculator.model.Calculation;

@Repository
public interface CalculationRepository extends CrudRepository<Calculation, Integer> {
	Collection<Calculation> findTop10ByOrderByCalculationIdDesc();

	Collection<Calculation> findTop10ByAnswerGreaterThanOrderByCalculationIdDesc(float answer);
}
