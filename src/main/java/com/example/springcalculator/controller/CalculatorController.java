package com.example.springcalculator.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springcalculator.model.Calculation;
import com.example.springcalculator.operator.Operator;
import com.example.springcalculator.repo.CalculationRepository;

import jakarta.validation.Valid;

@Controller
public class CalculatorController {

	@Autowired
	private List<Operator> ops;

	@Autowired
	private CalculationRepository repo;

	@GetMapping("/calculate")
	public String form(Model m) {

		if (!m.containsAttribute("calc")) {
			m.addAttribute("calc", new Calculation());
		}

		m.addAttribute("operators", ops);
		m.addAttribute("prev", repo.findTop10ByAnswerGreaterThanOrderByCalculationIdDesc(500f));

		return "result";
	}

	@PostMapping("/calculate")
	public String calculate(@Valid @ModelAttribute("calc") Calculation calc, BindingResult b, Model m) {

		if (!b.hasErrors()) {
			for (Operator o : ops) {
				if (o.getSymbol().equals(calc.getOperator())) {
					calc.setAnswer(o.performOperation(calc.getA(), calc.getB()));

					repo.save(calc);
					break;
				}
			}
		}

		m.addAttribute("calc", calc);

		return form(m);
	}
	
	@GetMapping("/reset")
	@Secured("ROLE_ADMIN")
	public String reset() {
		repo.deleteAll();
		return "redirect:/calculate";
		
	}
}