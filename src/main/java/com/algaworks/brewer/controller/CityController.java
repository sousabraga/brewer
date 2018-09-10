package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.City;

@Controller
@RequestMapping("/cities")
public class CityController {
	
	@GetMapping
	public ModelAndView newCity(City city, ModelAndView modelAndView) {
		modelAndView.setViewName("city/city-register");
		
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView saveCity(@Valid City city, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {		
		if (bindingResult.hasErrors()) {
			return newCity(city, modelAndView);
		}
		
		// TODO save the customer
		System.out.println(city);

		redirectAttributes.addFlashAttribute("successMessage", "City successfully saved!");
		modelAndView.setViewName("redirect:cities");

		return modelAndView;
	}

}
