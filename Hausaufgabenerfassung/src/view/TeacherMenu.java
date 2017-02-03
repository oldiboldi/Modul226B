package view;

import java.util.Scanner;

public class TeacherMenu extends Menu implements MenuInterface {

	private String username;

	public TeacherMenu(String username) {
		this.username = username;
	}

	public int showOptionsStart() {
		System.out.println("1 --> Choose class\n" + "0 --> Logout\n");
		return askWhatToDo();
	}

	public int showOptionsHomeWork() {
		System.out.println("1 --> See homework\n" + "2 --> Give homework\n"
				+ "3 --> Remove homework\n" + "0 --> Go back\n");
		return askWhatToDo();
	}

	public String[] setHomeWorkProperties() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Subject: ");
		String inputSubject = sc.nextLine();

		System.out.println("Description: ");
		String inputDescription = sc.nextLine();

		System.out.println("Date (dd.MM): ");
		String inputDate = sc.nextLine();

		String[] returnArray = new String[] { inputSubject, inputDescription,
				inputDate };
		return returnArray;

	}
	
}
