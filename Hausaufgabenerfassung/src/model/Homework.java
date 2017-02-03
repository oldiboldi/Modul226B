package model;

public class Homework {
	private String id;
	private String subject;
	private String description;
	private String doUntil;
	
	public Homework(String id, String subject, String description, String doUntil) {
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.doUntil = doUntil;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDoUntil() {
		return doUntil;
	}

	public void setDoUntil(String doUntil) {
		this.doUntil = doUntil;
	}

}
