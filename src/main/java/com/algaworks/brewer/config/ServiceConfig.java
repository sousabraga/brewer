package com.algaworks.brewer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.algaworks.brewer.service.BeerService;
import com.algaworks.brewer.storage.PhotoStorage;
import com.algaworks.brewer.storage.local.PhotoStorageLocal;

@Configuration
@ComponentScan(basePackageClasses = { BeerService.class })
public class ServiceConfig {

	@Bean
	public PhotoStorage photoStorage() {
		return new PhotoStorageLocal();
	}
	
}
	