package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemoDTO {
	private String author;
	private String text;
	private String date;
}