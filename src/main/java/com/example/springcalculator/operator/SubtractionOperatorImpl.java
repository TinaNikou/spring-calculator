package com.example.springcalculator.operator;

import org.springframework.stereotype.Component;

/**
 * Division Implementation of Divide using left to right ordering
 */
@Component
public class SubtractionOperatorImpl implements Operator {

	@Override
	public float performOperation(float a, float b) {
		return a - b;
	}

	@Override
	public String getSymbol() {
		return "-";
	}

}