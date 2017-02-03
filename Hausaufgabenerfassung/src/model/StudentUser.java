package model;

public class StudentUser extends User {

	public StudentUser(String id, String firstname, String lastname, String birthday, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.username = "stu-" + (firstname + lastname).toLowerCase();
		this.password = password;
	}
}
