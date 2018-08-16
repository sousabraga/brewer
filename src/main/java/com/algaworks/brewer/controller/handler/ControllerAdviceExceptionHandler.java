package com.algaworks.brewer.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.brewer.service.exception.StyleAlreadyRegisteredException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(StyleAlreadyRegisteredException.class)
	public ResponseEntity<?> handleStyleAlreadyRegisteredException(StyleAlreadyRegisteredException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
}
