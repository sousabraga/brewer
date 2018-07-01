package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Beer;

@Controller
@RequestMapping("/beer")
public class BeerController {

	@GetMapping("/new")
	public ModelAndView newBeer(Beer beer, ModelAndView modelAndView) {
		modelAndView.setViewName("beer/beer-register");
		
		return modelAndView;
	}
	
	@PostMapping("/new")
	public ModelAndView saveBeer(@Valid Beer beer, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {		
		if (bindingResult.hasErrors()) {
			return newBeer(beer, modelAndView);
		}
		
		// TODO save the beeer
		System.out.println(beer);

		redirectAttributes.addFlashAttribute("message", "Beer successfully saved!");
		modelAndView.setViewName("redirect:new");

		return modelAndView;
	}
	
}
