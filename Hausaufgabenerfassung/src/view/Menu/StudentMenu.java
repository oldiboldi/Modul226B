package view.Menu;

public class StudentMenu extends Menu implements MenuInterface{

	@Override
	public int showOptionsStart() {
		System.out.println(	
				"1 --> See homework\n" +
				"0 --> Logout\n");
		return askWhatToDo();
	}

}
