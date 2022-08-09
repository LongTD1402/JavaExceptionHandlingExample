package exceptions;

public class FullnameException extends Exception {
	private String message;

	public FullnameException(String message) {
		this.message ="[!!!]FullnameException: " + message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
