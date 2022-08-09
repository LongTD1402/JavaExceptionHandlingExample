import java.util.Scanner;

import exceptions.AccountNameException;
import exceptions.CheckDateException;
import exceptions.FullnameException;
import exceptions.PasswordException;
import exceptions.PhoneNumberException;

public class Main {
	public static User listUser[];

	public static void devide(int a, int b) throws DevideByZeroExc {
		if (b == 0) {
			throw new DevideByZeroExc("[!!!]Devide by zero.");
		}
		System.out.println(a + "/" + b + "=" + (double) a / b);
	}

	public static int logIn() {
		Scanner sc = new Scanner(System.in);
		int userCode = 0;
		System.out.print("Enter Account:");
		String acc = sc.nextLine();
		System.out.print("Enter Password:");
		String pass = sc.nextLine();
		for (int i = 0; i < listUser.length; i++) {
			if (acc.equals(listUser[i].getAccount()) == true && pass.equals(listUser[i].getPass()) == true) {
				userCode = listUser[i].getCode();
				break;
			}
		}
		return userCode;
	}

	public static void register() {
		Scanner sc = new Scanner(System.in);
		User newUser = null;
		String acc = null;
		String pass = null;
		String fullName = null;
		String date = null;
		String phone = null;
		do {

			try {
				newUser = new User("", "", "", "", "");
				if (acc == null) {
					System.out.print("---Account:");
					acc = sc.nextLine();
					newUser.setAccount(acc);
				} else {
					newUser.setAccount(acc);
				}
				if (pass == null) {
					System.out.print("---Password:");
					pass = sc.nextLine();
					newUser.setPass(pass);
				} else {
					newUser.setPass(pass);
				}
				if (fullName == null) {
					System.out.print("---Full name:");
					fullName = sc.nextLine();
					newUser.setFullName(fullName);
				} else {
					newUser.setFullName(fullName);
				}
				if (date == null) {
					System.out.print("---Date of birth:");
					date = sc.nextLine();
					newUser.setDate(date);
				} else {
					newUser.setDate(date);
				}
				if (phone == null) {
					System.out.println("---Phone number:");
					phone = sc.nextLine();
					newUser.setPhone(phone);
				} else {
					newUser.setPhone(phone);
				}
				listUser = add(listUser, newUser);
				System.out.println("==>Register success!");
				System.out.println(newUser.toString());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("==Re-enter information:");
				newUser = null;
				if (e instanceof AccountNameException) {
					acc = null;
				}
				if (e instanceof PasswordException) {
					pass = null;
				}
				if (e instanceof FullnameException) {
					fullName = null;
				}
				if (e instanceof CheckDateException) {
					date = null;
				}
				if (e instanceof PhoneNumberException) {
					phone = null;
				}
			}
		} while (newUser == null);
	}

	public static User[] add(User[] arr, User user) {
		User newList[] = new User[arr.length + 1];
		System.arraycopy(arr, 0, newList, 0, arr.length);
		newList[newList.length - 1] = user;
		return newList;
	}

	public static void changeInfo(User user) {
		Scanner sc = new Scanner(System.in);
		String newPass=" ";
		String newFullname=" ";
		String newDate=" ";
		String newPhone=" ";
		do {
			System.out.print("---New Password:");
			 newPass = sc.nextLine();
			System.out.print("---New Full name:");
			 newFullname = sc.nextLine();
			System.out.print("---New Date of birth:");
			 newDate = sc.nextLine();
			System.out.print("---New Phone number:");
			 newPhone = sc.nextLine();
			try {
				user.setPass(newPass);
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			}
			try {
				user.setFullName(newFullname);
			} catch (FullnameException e) {
				System.out.println(e.getMessage());
			}
			try {
				user.setDate(newDate);
			} catch (CheckDateException e) {
				System.out.println(e.getMessage());
			}
			try {
				user.setPhone(newPhone);
			} catch (PhoneNumberException e) {
				System.out.println(e.getMessage());
			}
		} while (false);

		System.out.println("==>>Updated!");
		System.out.println(user.toString());
	}

	public static void main(String[] args) throws Exception {
		listUser = new User[2];
		try {
			User user1 = new User("LongTD", "Long1402!", "Doan Tien Long", "14/02/2000", "0123456789");
			listUser[0] = user1;
			System.out.println("Add user" + user1.getCode() + " [" + user1.getAccount() + "]" + " success!");

			User user2 = new User("NhungTT", "Nhung2704!", "To Thi Nhung", "27/04/2000", "0987654321");
			listUser[1] = user2;
			System.out.println("Add user" + user2.getCode() + " [" + user2.getAccount() + "]" + " success!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		int choose;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.Log in");
			System.out.println("2.Register");
			System.out.print("-->Choose:");
			choose = sc.nextInt();
			switch (choose) {
			case 1: {
				int code = logIn();
				if (code == 0) {
					System.out.println("[!!!]Login information is incorrect!");
				} else {
					System.out.println("===Log in success===");
					System.out.println("Account:" + listUser[code - 1].getAccount());
					System.out.println("Full name:" + listUser[code - 1].getFullName());
					int choose2;
					do {
						System.out.println("	1.1 Show information.");
						System.out.println("	1.2 Change information.");
						System.out.println("	1.3 Log out");
						System.out.print("		-->Choose:");
						choose2 = sc.nextInt();
						switch (choose2) {
						case 1: {
							System.out.println(listUser[code - 1].toString());
							break;
						}
						case 2: {
							
							changeInfo(listUser[code-1]);
							break;
						}
						case 3:
							code = 0;
							break;
						default:
							System.out.println("[!!!]Invalid choose");
							break;
						}
					} while (choose2 != 0);
				}
				break;
			}
			case 2: {
				register();
				break;
			}
			default:
				System.out.println("[!!!]Invalid choose");
				break;
			}
		} while (choose != 0);
	}
}
