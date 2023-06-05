package com.lorenzomiscoli.spring_boot_starter.exception;

public class UserMismatchException extends RuntimeException {

	public UserMismatchException() {
		super();
	}

	public UserMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserMismatchException(String message) {
		super(message);
	}

	public UserMismatchException(Throwable cause) {
		super(cause);
	}

}
