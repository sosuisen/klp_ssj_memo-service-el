package com.example.model;

// ServletからJSPへ渡すJavaBeans
public class MemoDTO {
	// JSP側では読み取りのみなのでsetterは省略できます。
	// ただ、setterがあっても大きな問題はないです。
	private String author;
	public String getAuthor() {
		return author;
	}
	
	private String text;
	public String getText() {
		return text;
	}
	
	private String date;
	public String getDate() {
		return date;
	}
	
	public MemoDTO(String author, String text, String date) {
		this.author = author;
		this.text = text;
		this.date = date;
	}
	
	// 今回、このクラスは必ず手動でインスタンス化するため、
	// 引数なしの省略できます。あっても問題はないです。
}