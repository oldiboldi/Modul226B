package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.User;

public abstract class Database {

	File loginFile;
	ArrayList<User> userList = new ArrayList<User>();

	public Database() {
		initializeDirectories();
		initializeDB();
	}

	abstract void initializeDirectories();

	abstract void initializeDB();

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

	abstract User getUser(String username);

	abstract User getUserByID(String id);

	public String getNewID() {
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

	abstract void refreshUserFile();
//		loginFile.delete();
//		try {
//			loginFile.createNewFile();
//			for (User user : userList) {
//				FileWriter fw = new FileWriter(loginFile, true);
//				fw.append("" + (userList.indexOf(user) + 1));
//				fw.append(";");
//				fw.append(user.getFirstname());
//				fw.append(";");
//				fw.append("" + user.getLastname());
//				fw.append(";");
//				fw.append(user.getUsername());
//				fw.append(";");
//				fw.append(user.getPassword());
//				fw.append("\n");
//				fw.flush();
//				fw.close();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void deleteUser(int id) {
		userList.remove(id - 1);
		refreshUserFile();
	}

}