package com.example.model;

public class MemoDTO {
	private String text;
	public String getText() {
		return text;
	}
	
	private String date;
	public String getDate() {
		return date;
	}

	private String author;
	public String getAuthor() {
		return author;
	}

	public MemoDTO(String text, String date, String author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}	
}
