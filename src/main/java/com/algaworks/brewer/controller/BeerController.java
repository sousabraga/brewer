package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/beer")
public class BeerController {

	@GetMapping("/register")
	public ModelAndView beerRegister() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("beer/beer-register");
		
		return modelAndView;
	}
	
}
