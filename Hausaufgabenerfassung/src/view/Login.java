package Main;

import java.util.Scanner;

/**
 * Author: Antonio Mazzone
 * Version: 1.0
 * 
 * Dies ist die Anmeldemaske.
 * **/
public class Login {

	private UserDB db = new UserDB();
	private Scanner sc = new Scanner(System.in);

	public Login(boolean isAdmin) {
		logIn(isAdmin);
	}

	private void logIn(boolean isAdmin) {
		System.out.print("Username: ");
		String inputUsername = sc.nextLine();

		if (db.containsUser(inputUsername)) {

			if (isAdmin) {
				new UserMenu(inputUsername, isAdmin);
			}

			else {

				String inputPassword = k.readPassword("Password: ");
				String hashedPassword = "" + k.hashString(inputPassword);
				if (db.checkPassword(inputUsername, hashedPassword)) {
					k.clearConsole();
					if (inputUsername.equals("admin")) {
						new AdminMenu();
					} else {
						new UserMenu(inputUsername, isAdmin);
					}
				}

				else {
					k.clearConsole();
					System.err.println("Wrong password or username");
					logIn(isAdmin);
				}

			}
		}

		else {
			k.clearConsole();
			System.err.println("This user doesn't exist.");
			logIn(isAdmin);
		}
		sc.close();

	}

}
