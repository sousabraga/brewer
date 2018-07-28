package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Style;

@Controller
@RequestMapping("/style")
public class StyleController {
	
	@GetMapping("/new")
	public ModelAndView newStyle(Style style, ModelAndView modelAndView) {
		modelAndView.setViewName("style/style-register");
		
		return modelAndView;
	}
	
	@PostMapping("/new")
	public ModelAndView saveStyle(@Valid Style style, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {		
		if (bindingResult.hasErrors()) {
			return newStyle(style, modelAndView);
		}
		
		// TODO save the style
		System.out.println(style);

		redirectAttributes.addFlashAttribute("message", "Style successfully saved!");
		modelAndView.setViewName("redirect:new");

		return modelAndView;
	}

}
