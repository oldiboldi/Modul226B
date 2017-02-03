package view;

import java.util.Scanner;

public class Menu {

	public static int askWhatToDo() {
		int userinput = 0;
		boolean end = false;
		do {
			try{
				Scanner f = new Scanner(System.in);
				System.out.println("What do you wanna do?");
				String userinputString = f.nextLine();
				System.out.println();
				userinput = Integer.parseInt(userinputString);
				end = true;
			} 
			catch(NumberFormatException e){
				ErrorMessages.inputMismatchException();
			}
		} while(end == false);
		return userinput;
	}
	
	public void welcomeMessageStart() {
//		System.out.println(
//				"Its " + 
//				LocalDate.now().getDayOfWeek().name().toLowerCase() +
//				" the " +
//				LocalDate.now().getDayOfMonth() +
//				". of " +
//				LocalDate.now().getMonth() +
//				"\n"
//				);
		
		System.out.println("Welcome");
	}
}
