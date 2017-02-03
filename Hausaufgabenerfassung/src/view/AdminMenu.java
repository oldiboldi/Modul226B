package view;

public class AdminMenu extends Menu implements MenuInterface{

	public int showOptionsStart() {
		System.out.println(	"1 --> teacher administration\n" +
				"2 --> schoolclass administration\n" +
				"3 --> student administration\n" +
				"0 --> Logout\n");
		return askWhatToDo();
	}

	public int showOptionsTeacher() {
		System.out.println(	"1 --> create teacher\n" +
				"2 --> edit teacher\n" +
				"3 --> delete teacher\n" +
				"0 --> go back\n");
		return askWhatToDo();
	}
	
	public int showOptionsSchoolClass() {
		System.out.println(	"1 --> create class\n" +
				"2 --> delete class\n" +
				"3 --> add student to class\n" +
				"4 --> remove student from class\n" +
				"0 --> go back\n");
		return askWhatToDo();
	}
	
	public int showOptionsStudent() {
		System.out.println(	"1 --> create student\n" +
				"2 --> edit student\n" +
				"3 --> delete student\n" +
				"0 --> go back\n");
		return askWhatToDo();
	}
}
