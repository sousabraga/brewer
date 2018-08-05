package com.algaworks.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Style;
import com.algaworks.brewer.repository.StyleRepository;

@Service
public class StyleService {

	@Autowired
	private StyleRepository styleRepository;
	
	@Transactional
	public void save(Style style) {
		styleRepository.save(style);
	}
	
}
