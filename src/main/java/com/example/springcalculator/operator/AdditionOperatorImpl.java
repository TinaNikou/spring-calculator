package com.example.springcalculator.operator;

import org.springframework.stereotype.Component;

/**
 * Addition Implementation of Add using left to right ordering.
 */
@Component
public class AdditionOperatorImpl implements Operator {
	@Override
	public float performOperation(float a, float b) {
		return a + b;
	}

	@Override
	public String getSymbol() {
		return "+";
	}

}