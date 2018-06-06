package com.muxi.api.terminal.exceptions;

public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = 2025359314623245729L;

	public InvalidRequestException() {
        super();
    }
	
	public InvalidRequestException(String message) {
        super(message);
    }
	
	public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public InvalidRequestException(Throwable cause) {
        super(cause);
    }
	
}
