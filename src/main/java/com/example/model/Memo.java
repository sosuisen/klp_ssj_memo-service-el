package com.example.model;

import java.time.LocalDateTime;

public class Memo {
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public Memo(String author, String text, LocalDateTime createdAt) {
		this.author = author;
		this.text = text;
		this.createdAt = createdAt;
	}
	
	// JSONのデシリアライズのためにデフォルトコンストラクタが必要
	public Memo() {
	}
	
	private String author;
	private String text;
	private LocalDateTime createdAt;
}
