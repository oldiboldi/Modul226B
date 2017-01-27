package model;

public class TeacherUser extends User {
	public TeacherUser() {
		this.username = "tut-" + this.username;
	}
}
