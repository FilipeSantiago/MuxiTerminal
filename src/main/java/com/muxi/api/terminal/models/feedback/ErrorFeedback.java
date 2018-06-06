package com.muxi.api.terminal.models.feedback;

public class ErrorFeedback {
	
	public String requestedUri;
	public String errorMessage;
	
	public ErrorFeedback(String requestedUri, String errorMessage) {
		this.requestedUri = requestedUri;
		this.errorMessage = errorMessage;
	}
}
