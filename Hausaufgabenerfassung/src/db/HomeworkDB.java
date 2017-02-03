package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Homework;

public class HomeworkDB {

	private File homeworkClassFile;
	private ArrayList<Homework> homeworkList = new ArrayList<Homework>();

	public HomeworkDB(String hwClass) {
		this.homeworkClassFile = new File("./db/Klassen/" + hwClass + ".csv");
		initializeDirectories();
		initializeDB();
	}

	private void initializeDirectories() {
		if (!homeworkClassFile.exists()) {
			try {
				homeworkClassFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void initializeDB() {
		BufferedReader br = null;
		String line = "";

		try {

			br = new BufferedReader(new FileReader(homeworkClassFile));
			while ((line = br.readLine()) != null) {

				String[] homeworkData = line.split(";");
				// ID , Subject, Description, Do till
				Homework hw = new Homework(homeworkData[0], homeworkData[1],
						homeworkData[2], homeworkData[3]);
				homeworkList.add(hw);
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

	public void createHomework(String subject, String description,
			String doUntil) {
		Homework hw = new Homework(getNewID(), subject, description, doUntil);
		homeworkList.add(hw);

		try {
			FileWriter fw = new FileWriter(homeworkClassFile, true);
			fw.append(getNewID());
			fw.append(";");
			fw.append(subject);
			fw.append(";");
			fw.append(description);
			fw.append(";");
			fw.append(doUntil);
			fw.append("\n");
			fw.flush();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void refreshHomeworkFile() {
		homeworkClassFile.delete();
		try {
			homeworkClassFile.createNewFile();
			for (Homework hw : homeworkList) {
				FileWriter fw = new FileWriter(homeworkClassFile, true);
				fw.append("" + (homeworkList.indexOf(hw) + 1));
				fw.append(";");
				fw.append(hw.getSubject());
				fw.append(";");
				fw.append(hw.getDescription());
				fw.append(";");
				fw.append(hw.getDoUntil());
				fw.append("\n");
				fw.flush();
				fw.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Homework> getHomeworkList() {
		return this.homeworkList;
	}

	private String getNewID() {
		BufferedReader br = null;
		String line = "";
		String id = "0";

		try {

			br = new BufferedReader(new FileReader(homeworkClassFile));
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] homeworkData = line.split(";");
				id = homeworkData[0];

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
	
	public void deleteHomework(int id) {
		homeworkList.remove(id - 1);
		refreshHomeworkFile();
	}

}
