package model;

public class StudentUser extends User {
	public StudentUser() {
		this.username = "stu-" + this.username;
	}
}
