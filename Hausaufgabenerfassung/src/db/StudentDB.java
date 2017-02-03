package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.StudentUser;
import model.User;

/**
 * Author: Antonio Mazzone Version: 1.0
 * 
 * Die Datenbank, welche die Logindaten von .csv Files ausliest.
 **/
public class StudentDB extends Database {
	
	public StudentDB() {
	}

	@Override
	void initializeDirectories() {
		loginFile = new File("D:/Hausaufgabenerfassung/stu-logins.csv");
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

			br = new BufferedReader(new FileReader("D:/Hausaufgabenerfassung/stu-logins.csv"));
			while ((line = br.readLine()) != null) {

				String[] userData = line.split(";");
				// ID , Firstname, Lastname, Birthday, Password
				StudentUser user = new StudentUser(userData[0], userData[1], userData[2], userData[3], userData[5]);
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

	public void createUser(String firstname, String lastname, String birthday, String password) {
		String id = getNewID();
		StudentUser user = new StudentUser(id, firstname, lastname, birthday, password);
		userList.add(user);

		try {
			FileWriter fw = new FileWriter(loginFile, true);
			fw.append(user.getId());
			fw.append(";");
			fw.append(user.getFirstname());
			fw.append(";");
			fw.append(user.getLastname());
			fw.append(";");
			fw.append(user.getBirthday());
			fw.append(";");
			fw.append(user.getUsername());
			fw.append(";");
			fw.append(user.getPassword());
			fw.append("\n");
			fw.flush();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public User getUser(String username) {
		StudentUser returnUser = new StudentUser("", "", "", "", "");
		for (User user : userList) {
			if (username.equals(user.getUsername())) {
				returnUser.setId(user.getId());
				returnUser.setFirstname(user.getFirstname());
				returnUser.setLastname(user.getLastname());
				returnUser.setBirthday(user.getBirthday());
				returnUser.setUsername(user.getUsername());
				returnUser.setPassword(user.getPassword());
				break;
			}
		}

		return returnUser;
	}

	@Override
	public User getUserByID(String id) {
		StudentUser returnUser = new StudentUser("", "", "", "", "");
		for (User user : userList) {
			if (id.equals(user.getId())) {
				returnUser.setId(user.getId());
				returnUser.setFirstname(user.getFirstname());
				returnUser.setLastname(user.getLastname());
				returnUser.setBirthday(user.getBirthday());
				returnUser.setUsername(user.getUsername());
				returnUser.setPassword(user.getPassword());
				break;
			}
		}

		return returnUser;
	}

	@Override
	void refreshUserFile() {
		// TODO Auto-generated method stub
		
	}

}
