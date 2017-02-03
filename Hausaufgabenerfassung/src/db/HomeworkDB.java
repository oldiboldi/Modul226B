package db;

import java.io.File;
import java.io.IOException;

public class HomeworkDB {

	private File homeworkClassFile;

	public HomeworkDB(String hwClass) {
		this.homeworkClassFile = new File("D:/Hausaufgabenerfassung/" + hwClass);
	}

	private void initializeDirectories() {
		homeworkClassFile = new File("D:/Hausaufgabenerfassung/stu-logins.csv");
		if (!homeworkClassFile.exists()) {
			try {
				homeworkClassFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
