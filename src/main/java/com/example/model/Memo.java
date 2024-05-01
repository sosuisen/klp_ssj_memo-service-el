package com.example.model;

import java.time.LocalDateTime;

// Jsonbライブラリを用いて、
// JavaのオブジェクトとJSON形式のテキストデータを
// 相互変換するためのクラス。
// JsonbはJSONデータを元に自動的にこのクラスのインスタンスを作るため、
// 引数なしのコンストラクタやsetterは省略できません。
public class Memo {	
	private String author;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	private String text;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	private LocalDateTime createdAt;
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
	
	// 引数なしのコンストラクタ。中身は空っぽでよいです。
	public Memo() {
	}
}
