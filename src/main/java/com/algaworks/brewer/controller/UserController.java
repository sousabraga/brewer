package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/new")
	public ModelAndView newUser(User user, ModelAndView modelAndView) {
		modelAndView.setViewName("user/user-register");
		
		return modelAndView;
	}
	
	@PostMapping("/new")
	public ModelAndView saveUser(@Valid User user, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {		
		if (bindingResult.hasErrors()) {
			return newUser(user, modelAndView);
		}
		
		// TODO save the user
		System.out.println(user);

		redirectAttributes.addFlashAttribute("successMessage", "User successfully saved!");
		modelAndView.setViewName("redirect:new");

		return modelAndView;
	}

}
