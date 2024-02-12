package com.example.springcalculator.operator;

import org.springframework.stereotype.Component;

/**
 * Division Implementation of Divide using left to right ordering
 */
@Component
public class DivisionOperatorImpl implements Operator {

	@Override
	public float performOperation(float a, float b) {
		return a / b;
	}

	/**
	 * Returns a unicode divide symbol
	 */
	@Override
	public String getSymbol() {
		return "\u00F7";
	}

}