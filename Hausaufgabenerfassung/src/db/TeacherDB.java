package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.StudentUser;
import model.TeacherUser;
import model.User;

public class TeacherDB extends Database {
	
	public TeacherDB() {
	}

	@Override
	void initializeDirectories() {
		loginFile = new File("./db/tut-logins.csv");
		if (!loginFile.exists()) {
			try {
				loginFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	void initializeDB() {
		BufferedReader br = null;
		String line = "";

		try {

			br = new BufferedReader(new FileReader(loginFile));
			while ((line = br.readLine()) != null) {

				String[] userData = line.split(";");
				// ID , Firstname, Lastname, Birthday, Classes, Password
				TeacherUser user = new TeacherUser(userData[0], userData[1], userData[2], userData[3], userData[4],
						userData[6]);
				userList.add(user);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public User getUser(String username) {
		TeacherUser returnUser = new TeacherUser("", "", "", "", "", "");
		for (User user : userList) {
			if (username.equals(user.getUsername())) {
				returnUser.setId(user.getId());
				returnUser.setFirstname(user.getFirstname());
				returnUser.setLastname(user.getLastname());
				returnUser.setBirthday(user.getBirthday());
				for(String c: ((TeacherUser) user).getClasses()) {
					returnUser.setClasses(c);
				}
				returnUser.setUsername(user.getUsername());
				returnUser.setPassword(user.getPassword());
				break;
			}
		}

		return returnUser;
	}

	@Override
	public User getUserByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void refreshUserFile() {
		// TODO Auto-generated method stub

	}

}
