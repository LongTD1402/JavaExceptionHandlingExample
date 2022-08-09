package exceptions;

public class PhoneNumberException extends Exception{
	private String message;

	public PhoneNumberException(String message) {
		this.message = "[!!!]PhoneNumberException: " + message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
