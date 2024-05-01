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

	public MemoDTO(String text, String date) {
		super();
		this.text = text;
		this.date = date;
	}	
}
