package com.example.springcalculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Calculation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int calculationId;
	
	@NotNull
	private Float a;
	@NotNull
	private Float b;
	private Float answer;
	@NotNull
	private String operator;
	
	public Float getA() {
		return a;
	}
	public void setA(Float a) {
		this.a = a;
	}
	public Float getB() {
		return b;
	}
	public void setB(Float b) {
		this.b = b;
	}
	public Float getAnswer() {
		return answer;
	}
	public void setAnswer(Float answer) {
		this.answer = answer;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
}
