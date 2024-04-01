package com.example.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // JSON変換時に必要
public class Memo {
	private String author;
	private String text;
	private LocalDateTime createdAt;
}
