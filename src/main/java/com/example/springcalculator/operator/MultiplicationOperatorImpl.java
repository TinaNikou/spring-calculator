package com.example.springcalculator.operator;

import org.springframework.stereotype.Component;

/**
 * Multiplication Implementation of Multiply
 */
@Component
public class MultiplicationOperatorImpl implements Operator {

	@Override
	public float performOperation(float a, float b) {
		return a * b;
	}

	/**
	 * Returns unicode multiplication symbol
	 */
	@Override
	public String getSymbol() {
		return "\u00D7";
	}

}