package exceptions;

public class CheckDateException extends Exception {
	private String message;

	public CheckDateException(String message) {

		this.message = "[!!!]CheckDateException: " + message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
