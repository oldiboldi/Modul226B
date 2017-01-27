package model;

import java.util.Date;

public abstract class User {
	String firstname;
	String lastname;
	Date birthday;
	String username = (firstname + lastname).toLowerCase();
	String password;
}
