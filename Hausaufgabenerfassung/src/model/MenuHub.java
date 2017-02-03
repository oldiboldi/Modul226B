package model;

import java.util.ArrayList;

import view.AdminMenu;
import view.Login;
import view.Menu;
import view.StudentMenu;
import view.TeacherMenu;
import db.HomeworkDB;
import db.StudentDB;
import db.TeacherDB;

public class MenuHub {
	public void adminHub() {
		AdminMenu adminMenu = new AdminMenu();
		boolean end = false;
		boolean iterator = false;
		adminMenu.welcomeMessageStart();
		do {
			switch (adminMenu.showOptionsStart()) {
			// Case Logout
			case 0:
				end = true;
				new Login();
				break;
			// Case teacher administration
			case 1:
				iterator = false;
				while (iterator == false) {
					switch (adminMenu.showOptionsTeacher()) {
					// Case go back
					case 0:
						iterator = true;
						break;
					// Case create Teacher
					case 1:

						break;
					// Case edit Teacher
					case 2:

						break;
					// Case delete Teacher
					case 3:

						break;
					}
				}
				break;
			// Case class administration
			case 2:
				iterator = false;
				while (iterator == false) {
					switch (adminMenu.showOptionsSchoolClass()) {
					// Case go back
					case 0:
						iterator = true;
						break;
					// Case create class
					case 1:

						break;
					// Case delete class
					case 2:

						break;
					// Case add student to class
					case 3:

						break;
					// Case remove student from class
					case 4:

						break;
					}
				}
				break;
			// Case student administration
			case 3:
				iterator = false;
				while (iterator == false) {
					switch (adminMenu.showOptionsStudent()) {
					// Case go back
					case 0:
						iterator = true;
						break;
					// Case create Student
					case 1:

						break;
					// Case edit Student
					case 2:

						break;
					// Case delete Teacher
					case 3:

						break;
					}
				}
			}
		} while (end == false);
	}

	public void teacherHub(String username) {
		TeacherDB teacherDB = new TeacherDB();
		HomeworkDB homeworkDB;
		TeacherMenu teacherMenu = new TeacherMenu(username);
		TeacherUser t = (TeacherUser) teacherDB.getUser(username);
		boolean end = false;
		boolean iterator = false;
		teacherMenu.welcomeMessageStart();
		do {
			switch (teacherMenu.showOptionsStart()) {
			// Case Logout
			case 0:
				end = true;
				new Login();
				break;
			// Case Choose class
			case 1:
				ArrayList<String> classList = t.getClasses();
				int i = 1;
				for (String c : classList) {
					System.out.println("[" + i + "] " + c);
					i++;
				}

				homeworkDB = new HomeworkDB(
						classList.get(Menu.askWhatToDo() - 1));
				iterator = false;
				while (iterator == false) {
					switch (teacherMenu.showOptionsHomeWork()) {
					// Case go back
					case 0:
						iterator = true;
						break;
					// Case see homework
					case 1:
						Menu.showAllHomework(homeworkDB.getHomeworkList());
						break;
					// Case give homework
					case 2:
	
						String[] homeworkData = teacherMenu.setHomeWorkProperties();
						homeworkDB.createHomework(homeworkData[0], homeworkData[1],
								homeworkData[2]);
						break;
					// Case remove homework
					case 3:
	
						break;
					}
				}
				while (iterator == false) {
					switch (teacherMenu.showOptionsHomeWork()) {
					// Case go back
					case 0:
						iterator = true;
						break;
					// Case see homework
					case 1:

						break;
					// Case give homework
					case 2:

						break;
					// Case remove homework
					case 3:

						break;
					}
				}
				break;
			}
		} while (end == false);
	}

	public void studentHub(String username) {
		StudentMenu studentMenu = new StudentMenu(username);
		StudentDB studentDB = new StudentDB();
		StudentUser s = (StudentUser) studentDB.getUser(username);
		HomeworkDB homeworkDB = new HomeworkDB(s.getClasse());
		boolean end = false;
		studentMenu.welcomeMessageStart();
		do {
			switch (studentMenu.showOptionsStart()) {
			// Case Logout
			case 0:
				end = true;
				new Login();
				break;
			// Case see homework
			case 1:
				break;
			}
		} while (end == false);
	}
}
