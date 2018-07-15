package com.algaworks.brewer.model;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 6623895256130065088L;
	
	private Long id;
	
	private String name;
	
	// TODO change to Enum 
	private String type;
	
	private String documentNumber;
	
	private String phoneNumber;
	
	private String email;
	

}
