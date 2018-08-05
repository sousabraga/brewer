package com.algaworks.brewer.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.algaworks.brewer.model.Style;

@Component
public class StyleConverter implements Converter<String, Style> {

	@Override
	public Style convert(String id) {
		if (StringUtils.isEmpty(id)) 
			return null;
		
		Style style = new Style();
		style.setId(Long.valueOf(id));
		
		return style;
	}

}
