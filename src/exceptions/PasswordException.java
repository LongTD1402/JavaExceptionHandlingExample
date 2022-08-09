package exceptions;

public class PasswordException extends Exception {
	private String message;

	
	public PasswordException(String message) {
		this.message ="[!!!]PasswordException: " + message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
