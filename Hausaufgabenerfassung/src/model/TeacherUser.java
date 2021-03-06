package model;

import java.util.ArrayList;

public class TeacherUser extends User {

	private ArrayList<String> classesList = new ArrayList<String>();

	public TeacherUser(String id, String firstname, String lastname,
			String birthday, String classes, String username,String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.username = "tut-" + username;
		this.password = password;
		initClasses(classes);

	}

	private void initClasses(String classes) {
		String[] classArray = classes.split(",");
		for (String c : classArray) {
			if (c != "") {
				classesList.add(c);
			}
		}
	}

	public ArrayList<String> getClasses() {
		return this.classesList;
	}

	public void setClasses(String c) {
		this.classesList.add(c);
	}
}
