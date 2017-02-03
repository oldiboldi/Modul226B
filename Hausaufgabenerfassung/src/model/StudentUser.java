package model;

public class StudentUser extends User {

	private String classe;

	public StudentUser(String id, String firstname, String lastname,
			String birthday, String classe, String username, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.classe = classe;
		this.username = "stu-" + username;
		this.password = password;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
}
