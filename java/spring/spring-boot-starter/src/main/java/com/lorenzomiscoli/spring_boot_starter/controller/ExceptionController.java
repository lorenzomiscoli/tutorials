package com.lorenzomiscoli.spring_boot_starter.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lorenzomiscoli.spring_boot_starter.exception.UserMismatchException;
import com.lorenzomiscoli.spring_boot_starter.exception.UserNotFoundException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ UserNotFoundException.class })
	protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex, "User not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ UserMismatchException.class })
	public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex, "Wrong user Id", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
