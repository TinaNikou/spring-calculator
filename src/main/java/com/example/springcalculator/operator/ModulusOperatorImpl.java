package com.example.springcalculator.operator;

import org.springframework.stereotype.Component;

/**
 * Implements the modulo operator, otherwise known as 'remainder' Uses integer
 * mathematics dividing a by b and returning the remainder. Therefore answers
 * will be between 0 and b-1.
 */
@Component
public class ModulusOperatorImpl implements Operator {

	@Override
	public float performOperation(float a, float b) {
		return a % b;
	}

	@Override
	public String getSymbol() {
		return "mod";
	}

}
