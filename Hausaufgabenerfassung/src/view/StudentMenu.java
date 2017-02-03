package view;

public class StudentMenu extends Menu implements MenuInterface{
	
	private String username;
	
	public StudentMenu(String username) {
		this.username = username;
	}
	
	@Override
	public int showOptionsStart() {
		System.out.println(	
				"1 --> See homework\n" +
				"0 --> Logout\n");
		return askWhatToDo();
	}

}
