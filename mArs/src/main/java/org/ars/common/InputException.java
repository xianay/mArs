package org.ars.common;

@SuppressWarnings("serial")
public class InputException extends Exception{

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}


