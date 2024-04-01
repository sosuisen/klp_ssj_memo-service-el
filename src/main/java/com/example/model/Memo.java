package com.example.model;

import java.time.LocalDateTime;

public class Memo {
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
	
	public Memo(String text, LocalDateTime createdAt) {
		this.text = text;
		this.createdAt = createdAt;
	}
	
	// JSONのデシリアライズのためにデフォルトコンストラクタが必要
	public Memo() {
	}
	
	private String text;
	private LocalDateTime createdAt;

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
	
	public Memo(String text, LocalDateTime createdAt) {
		super();
		this.text = text;
		this.createdAt = createdAt;
	}
	
	// JSONファイルの読み込み時に必要な引数なしのコンストラクタ
	public Memo() {
	}
}
