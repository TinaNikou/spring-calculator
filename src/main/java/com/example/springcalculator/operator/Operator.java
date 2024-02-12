package com.example.springcalculator.operator;

import org.springframework.stereotype.Component;

/**
 * Interface for mathematical operators to perform operations and get its respective symbol
 */
@Component
public interface Operator {
	/**
	 * Perform the mathematical operation
	 * 
	 * @param a the first operand, usually to the left of the symbol
	 * @param b the second operand, usually to the right of the symbol
	 * @return the result of the operation
	 */
	float performOperation(float a, float b);
	
	/**
	 * Get the symbol for this operation
	 * 
	 * @return the symbol, which can be more than one character and will not be null
	 */
	String getSymbol();
}
