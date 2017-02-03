package view.Menu;

public class TeacherMenu extends Menu implements MenuInterface{

	public int showOptionsStart() {
		System.out.println(	
				"1 --> Choose class\n" +
				"0 --> Logout\n");
		return askWhatToDo();
	}

	public int showOptionsHomeWork() {
		System.out.println(	
				"1 --> See homework\n" +
				"2 --> Give homework\n" +
				"3 --> Remove homework\n" +
				"0 --> Go back\n");
		return askWhatToDo();
	}
}
