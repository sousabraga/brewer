package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("/new")
	public ModelAndView newCustomer(Customer customer, ModelAndView modelAndView) {
		modelAndView.setViewName("customer/customer-register");
		
		return modelAndView;
	}
	
	@PostMapping("/new")
	public ModelAndView saveBeer(@Valid Customer customer, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {		
		if (bindingResult.hasErrors()) {
			return newCustomer(customer, modelAndView);
		}
		
		// TODO save the customer
		System.out.println(customer);

		redirectAttributes.addFlashAttribute("message", "Customer successfully saved!");
		modelAndView.setViewName("redirect:new");

		return modelAndView;
	}
	
}