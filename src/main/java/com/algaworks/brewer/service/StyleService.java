package com.algaworks.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Style;
import com.algaworks.brewer.repository.StyleRepository;
import com.algaworks.brewer.service.exception.StyleAlreadyRegisteredException;

@Service
public class StyleService {

	@Autowired
	private StyleRepository styleRepository;
	
	@Transactional
	public void save(Style style) {
		Optional<Style> styleOptional = styleRepository.findByNameIgnoreCase(style.getName());
		
		if (styleOptional.isPresent()) 
			throw new StyleAlreadyRegisteredException("Style already registered");
		
		styleRepository.save(style);
	}
	
}
