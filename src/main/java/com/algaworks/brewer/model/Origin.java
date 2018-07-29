package com.algaworks.brewer.model;

public enum Origin {

	NATIONAL("National"), 
	INTERNATIONAL("International");
	
	private String description;
	
	Origin(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
