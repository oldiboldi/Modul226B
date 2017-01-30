package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.User;

/**
 * Author: Antonio Mazzone 
 * Version: 1.0
 * 
 * Die Datenbank, welche die Logindaten von .csv Files ausliest.
 **/
public class UserDB {

	private ArrayList<User> userList = new ArrayList<User>();
	private File tmp = new File("D:/Spesenerfassung/tmp");
	private File loginFile = new File("D:/Spesenerfassung/logins.csv");

	public UserDB() {
		initializeDirectories();
		initializeDB();
	}

	private void initializeDirectories() {
		// initialize tmp for printing files
		if (!tmp.exists()) {
			tmp.mkdirs();
		}

		// initialize logins.csv for the login data
		if (!loginFile.exists()) {
			createLoginFile();
		}

	}

	private void initializeDB() {
		BufferedReader br = null;
		String line = "";

		try {

			br = new BufferedReader(new FileReader("D:/Spesenerfassung/logins.csv"));
			while ((line = br.readLine()) != null) {

				String[] userData = line.split(";");
				User user = new User(userData[0], userData[1], userData[2], userData[3], userData[4]);
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

	private void createLoginFile() {
		try {
			loginFile.createNewFile();
			FileWriter fw = new FileWriter(loginFile, true);
			fw.append("1");
			fw.append(";");
			fw.append("admin");
			fw.append(";");
			fw.append("admin");
			fw.append(";");
			fw.append("admin");
			fw.append(";");
			fw.append("490207449"); // PW = [Enter]
			fw.append("\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createUser(String firstname, String lastname, String username, String password) {
		String id = getNewID();
		User user = new User(id, firstname, lastname, username, password);
		userList.add(user);

		try {
			FileWriter fw = new FileWriter(loginFile, true);
			fw.append(id);
			fw.append(";");
			fw.append(firstname);
			fw.append(";");
			fw.append(lastname);
			fw.append(";");
			fw.append(username);
			fw.append(";");
			fw.append(password);
			fw.append("\n");
			fw.flush();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean containsUser(String username) {

		boolean containsUser = false;
		for (User user : userList) {
			if (username.equals(user.getUsername())) {
				containsUser = true;
				break;
			}

			else {
				containsUser = false;
			}
		}
		return containsUser;
	}

	public String getPassword(String username) {
		String password = "";

		for (User user : userList) {
			if (username.equals(user.getUsername())) {
				password = user.getPassword();
				break;
			}
		}

		return password;
	}

	public boolean isProofPassword(String password) {
		boolean proofPassword = false;

		if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-10000000000].*")) {
			if (password.length() > 6) {
				proofPassword = true;
			}
		}

		else {
			proofPassword = false;
		}

		return proofPassword;
	}

	public boolean isProofName(String name) {
		boolean proofName = false;

		if (!name.matches(".*[0-10000000000].*") && name.matches(".*[a-z].*")) {
			proofName = true;
		}

		else {
			if (name.matches(".*[0-10000000000].*")) {
				System.err.println("This field can't contain a number.");
				proofName = false;
			}

			else if (name.isEmpty()) {
				System.err.println("This field can't be empty.");
				proofName = false;
			}
		}

		return proofName;
	}

	public boolean checkPassword(String username, String password) {
		boolean equalPassword = false;
		if (password.equals(getPassword(username))) {
			equalPassword = true;
		}

		else {
			equalPassword = false;
		}

		return equalPassword;
	}

	public User getUser(String username) {
		User returnUser = new User("", "", "", "", "");

		for (User user : userList) {
			if (username.equals(user.getUsername())) {
				returnUser.setId(user.getId());
				returnUser.setFirstname(user.getFirstname());
				returnUser.setLastname(user.getLastname());
				returnUser.setUsername(user.getUsername());
				returnUser.setPassword(user.getPassword());
				break;
			}
		}

		return returnUser;
	}

	public User getUserByID(String id) {
		User returnUser = new User("", "", "", "", "");

		for (User user : userList) {
			if (id.equals(user.getId())) {
				returnUser.setId(user.getId());
				returnUser.setFirstname(user.getFirstname());
				returnUser.setLastname(user.getLastname());
				returnUser.setUsername(user.getUsername());
				returnUser.setPassword(user.getPassword());
				break;
			}
		}

		return returnUser;
	}

	private String getNewID() {
		BufferedReader br = null;
		String line = "";
		String id = "1";

		try {

			br = new BufferedReader(new FileReader(loginFile));
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] userData = line.split(";");
				id = userData[0];

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

		int newIDInt = Integer.parseInt(id) + 1;
		id = "" + newIDInt;
		return id;
	}

	public void refreshUserFile() {
		loginFile.delete();
		try {
			loginFile.createNewFile();
			for (User user : userList) {
				FileWriter fw = new FileWriter(loginFile, true);
				fw.append("" + (userList.indexOf(user) + 1));
				fw.append(";");
				fw.append(user.getFirstname());
				fw.append(";");
				fw.append("" + user.getLastname());
				fw.append(";");
				fw.append(user.getUsername());
				fw.append(";");
				fw.append(user.getPassword());
				fw.append("\n");
				fw.flush();
				fw.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int id) {
		userList.remove(id - 1);
		refreshUserFile();
	}

	public ArrayList<User> getExpenseList() {
		return this.userList;
	}

}
