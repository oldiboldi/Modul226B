package view;

import java.util.Scanner;

import model.MenuHub;
import model.StudentUser;
import model.TeacherUser;
import db.StudentDB;
import db.TeacherDB;

/**
 * Author: Antonio Mazzone Version: 1.0
 * 
 * Dies ist die Anmeldemaske. Es unterscheidet ein Student(stu-) von einem
 * Lehrer(tut-)
 **/
public class Login {

	private StudentDB studentDB = new StudentDB();
	private TeacherDB teacherDB = new TeacherDB();
	private MenuHub hub = new MenuHub();
	private Scanner sc = new Scanner(System.in);

	public Login() {
		logIn();
	}

	private void logIn() {
		System.out.print("Username: ");
		String inputUsername = sc.nextLine();

		if (inputUsername.startsWith("stu-")) {
			if (studentDB.containsUser(inputUsername)) {
				System.out.println("Password: ");
				String inputPassword = sc.nextLine();
				StudentUser loginUser = (StudentUser) studentDB.getUser(inputUsername);

				if (inputPassword.equals(loginUser.getPassword())) {
					hub.studentHub(inputUsername);
				}

				else {
					System.out.println("Wrong username or password");
					logIn();
				}
			}

			else {
				System.out.println("User don't exists");
				logIn();
			}
		}

		else if (inputUsername.startsWith("tut-")) {
			if (teacherDB.containsUser(inputUsername)) {
				System.out.println("Password: ");
				String inputPassword = sc.nextLine();
				TeacherUser loginUser = (TeacherUser) teacherDB.getUser(inputUsername);

				if (inputPassword.equals(loginUser.getPassword())) {
					hub.teacherHub(inputUsername);
				}

				else {
					System.out.println("Wrong username or password");
					logIn();
				}
			}

			else {
				System.out.println("User don't exists");
				logIn();
			}
		}

		else if (inputUsername.equals("ADMIN")) {
			System.out.println("Password: ");
			String inputPassword = sc.nextLine();
			if (inputPassword.equals("123456789")) {
				hub.adminHub();
			}

			else {
				System.out.println("User don't exists");
				logIn();

			}
		}

		else {
			System.out.println("User don't exists");
			logIn();
		}

		sc.close();

	}

}
