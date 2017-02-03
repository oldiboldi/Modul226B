package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Homework;

public class Menu {

	public static int askWhatToDo() {
		int userinput = 0;
		boolean end = false;
		do {
			try {
				Scanner f = new Scanner(System.in);
				System.out.println("Choose: ");
				String userinputString = f.nextLine();
				System.out.println();
				userinput = Integer.parseInt(userinputString);
				end = true;
			} catch (NumberFormatException e) {
				ErrorMessages.inputMismatchException();
			}
		} while (end == false);
		return userinput;
	}
	
	public static void showAllHomework(ArrayList<Homework> homeworkList) {
		String leftAlignFormat = "| %-8s | %-17s | %-97s | %-25s |%n";

		System.out.format(
				"+--------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"| ID       | Subject           | Description                                                                                       | To do till                |%n");
		System.out.format(
				"+--------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		for (Homework hw : homeworkList) {
			System.out.format(leftAlignFormat, hw.getId(), hw.getSubject(), 
					hw.getDescription(), hw.getDoUntil());
		}
		System.out.format(
				"+--------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"+--------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.format(
				"|  Quit to menu: 0                                                                                                                                             |%n");
		System.out.format(
				"+--------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.println("");
	}

	public void welcomeMessageStart() {
		// System.out.println(
		// "Its " +
		// LocalDate.now().getDayOfWeek().name().toLowerCase() +
		// " the " +
		// LocalDate.now().getDayOfMonth() +
		// ". of " +
		// LocalDate.now().getMonth() +
		// "\n"
		// );

		System.out.println("Welcome");
	}
}
