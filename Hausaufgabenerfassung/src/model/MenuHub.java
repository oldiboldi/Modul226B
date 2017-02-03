package viewmodel;

import view.Menu.AdminMenu;
import view.Menu.TeacherMenu;
import view.Menu.StudentMenu;

public class MenuHub {
	public static void adminHub() {
		AdminMenu adminMenu = new AdminMenu();
		adminMenu.welcomeMessageStart();
		switch(adminMenu.showOptionsStart()) {
			// Case Logout
			case 0:
				
			break;
			//Case teacher administration
			case 1:
				switch(adminMenu.showOptionsTeacher()) {
					//Case go back
					case 0:
					
					break;
					//Case create Teacher
					case 1:
						
					break;
					//Case edit Teacher
					case 2:
					
					break;
					//Case delete Teacher
					case 3:
						
					break;
				}
			break;
			//Case class administration
			case 2:
				switch(adminMenu.showOptionsSchoolClass()) {
					//Case go back
					case 0:
					
					break;
					//Case create class
					case 1:
						
					break;
					//Case delete class
					case 2:
					
					break;
					//Case add student to class
					case 3:
						
					break;
					//Case remove student from class
					case 4:
						
					break;
			}
			break;
			//Case student administration
			case 3:
				switch(adminMenu.showOptionsStudent()) {
					//Case go back
					case 0:
					
					break;
					//Case create Student
					case 1:
						
					break;
					//Case edit Student
					case 2:
					
					break;
					//Case delete Teacher
					case 3:
						
					break;
			}
			break;
		}
		
	}
	
	public static void teacherHub() {
		TeacherMenu teacherMenu = new TeacherMenu();
		teacherMenu.welcomeMessageStart();
		switch(teacherMenu.showOptionsStart()) {
			//Case Logout
			case 0:
			
			break;
			//Case Choose class
			case 1:
				
				switch(teacherMenu.showOptionsHomeWork()) {
					//Case go back
					case 0:
						
					break;
					//Case see homework
					case 1:
						
					break;
					//Case give homework
					case 2:
						
					break;
					//Case remove homework
					case 3:
						
					break;
				}
	}
}
	public static void studentHub() {
		StudentMenu studentMenu = new StudentMenu();
		studentMenu.welcomeMessageStart();
		switch(studentMenu.showOptionsStart()) {
			//Case Logout
			case 0:
				
			break;
			//Case see homework
			case 1:
				
			break;
		}
}
}
