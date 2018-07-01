package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.brewer.model.Beer;

@Controller
@RequestMapping("/beer")
public class BeerController {

	@GetMapping("/new")
	public ModelAndView newBeer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("beer/beer-register");
		
		return modelAndView;
	}
	
	@PostMapping("/new")
	public ModelAndView saveBeer(@Valid Beer beer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.err.println("Errors detected. :(");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("beer/beer-register");
		
		System.out.println(beer);
	
		return modelAndView;
	}
	
}
