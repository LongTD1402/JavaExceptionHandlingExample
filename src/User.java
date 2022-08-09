
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import exceptions.AccountNameException;
import exceptions.CheckDateException;
import exceptions.FullnameException;
import exceptions.PasswordException;
import exceptions.PhoneNumberException;

public class User {
	private static int curCode = 0;
	private int code;
	private String account;
	private String pass;
	private String fullName;
	private String date;
	private String phone;

	public User() {
		curCode++;
		this.code = curCode;
	}

	public User(String account, String pass, String fullName, String date, String phone) {
		super();
		curCode++;
		this.code = curCode;
		this.account = account;
		this.pass = pass;
		this.fullName = fullName;
		this.date = date;
		this.phone = phone;
	}

	public static int getCurCode() {
		return curCode;
	}

	public static void setCurCode(int curCode) {
		User.curCode = curCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) throws AccountNameException {
		if (Pattern.matches("[a-zA-Z0-9]*", account) == false) {
			throw new AccountNameException("Accepts alphanumeric characters only!");
		}
		if (account.length() < 8) {
			throw new AccountNameException("Account name must be at least 8 characters!!");
		}
		this.account = account;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) throws PasswordException {
		if (Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+", pass) == false) {
			throw new PasswordException(
					"Password must contain uppercase letters, lowercase letters, numbers, and special characters!");
		}
		if (pass.length() < 6) {
			throw new PasswordException("Passwords must be at least 6 characters!");
		}
		this.pass = pass;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) throws FullnameException {
		if (fullName.replaceAll(" ", "").isEmpty()) {
			throw new FullnameException("Name cannot be left empty!");
		}
		if (Pattern.matches("[a-zA-Z]+", fullName.replaceAll(" ", "")) == false) {
			throw new FullnameException("Names consist of letters only!");
		}
		this.fullName = fullName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) throws CheckDateException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(date);
		} catch (ParseException e) {
			throw new CheckDateException("Invalid date!");
		}
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) throws PhoneNumberException{
	
		if(Pattern.matches("[0-9]{10,12}", phone)==false) {
			throw new PhoneNumberException("Invalid phone number!");
		}
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", pass=" + pass + ", fullName=" + fullName + ", date="
				+ date + ", phone=" + phone + "]";
	}
	
}
