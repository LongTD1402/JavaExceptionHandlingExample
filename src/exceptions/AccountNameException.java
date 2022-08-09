package exceptions;

public class AccountNameException extends Exception{
	private String message;

	public AccountNameException(String message) {
		this.message = "[!!!]AccountNameException: "+message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
