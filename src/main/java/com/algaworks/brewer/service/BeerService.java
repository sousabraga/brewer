package com.algaworks.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.brewer.model.Beer;
import com.algaworks.brewer.model.Flavor;
import com.algaworks.brewer.model.Origin;
import com.algaworks.brewer.repository.BeerRepository;
import com.algaworks.brewer.repository.StyleRepository;

@Service
public class BeerService {

	@Autowired
	private BeerRepository beerRepository;
	
	@Autowired
	private StyleRepository styleRepository;
	
	@Transactional
	public void save(Beer beer) {
		// TODO implement validations
		
		beerRepository.save(beer);
	}
	
	public void loadObjects(ModelAndView modelAndView) {
		modelAndView.addObject("flavorList", Flavor.values());
		modelAndView.addObject("styleList", styleRepository.findAll());
		modelAndView.addObject("originList", Origin.values());
	}
	
}
