package it.univaq.disim.oop.cerqolavoro.domain;

public class Message {

	private String title;
	private String text;
	private Employer employer;
	private Worker worker;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}

