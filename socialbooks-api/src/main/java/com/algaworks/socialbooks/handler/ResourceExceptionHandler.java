package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.services.exceptions.NotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Void> handleNotFoundException(NotFoundException e, 
			HttpServletRequest request) {
		return ResponseEntity.notFound().build();
	}
}
