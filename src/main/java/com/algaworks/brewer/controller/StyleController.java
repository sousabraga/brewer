package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Style;
import com.algaworks.brewer.service.StyleService;
import com.algaworks.brewer.service.exception.StyleAlreadyRegisteredException;

@Controller
@RequestMapping("/styles")
public class StyleController {
	
	@Autowired
	private StyleService styleService;
	
	@GetMapping
	public ModelAndView newStyle(Style style, ModelAndView modelAndView) {
		modelAndView.setViewName("style/style-register");
		
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView saveStyle(@Valid Style style, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {		
		if (bindingResult.hasErrors()) 
			return newStyle(style, modelAndView);
		
		try {
			styleService.save(style);
		} catch (StyleAlreadyRegisteredException e) {
			bindingResult.rejectValue("name", e.getMessage(), e.getMessage());
			
			return newStyle(style, modelAndView);
		}
		
		redirectAttributes.addFlashAttribute("successMessage", "Style successfully saved!");
		modelAndView.setViewName("redirect:styles");

		return modelAndView;
	}
	
	@PostMapping(value = "/fast-registration", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveStyleThroughFastRegistration(@RequestBody @Valid Style style, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return ResponseEntity.badRequest().body(bindingResult.getFieldError("name").getDefaultMessage());

		style = styleService.save(style);

		return ResponseEntity.ok(style);
	}

}
