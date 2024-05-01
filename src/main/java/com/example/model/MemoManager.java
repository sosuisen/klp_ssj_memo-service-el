package com.example.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemoManager {
	// テキストファイルの書き込み、読み込みを実行する単純なモデルです。
	
	private String filePath = "c:\\pleiades\\2024-03\\memo2.txt";
	
	public String getMemo() {
		try {
			return Files.readString(Path.of(filePath));
		} catch (NoSuchFileException e) {
			System.out.println("File not found: " + filePath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	synchronized public void addMemo(String author, String text) {
		try {
			var oldMemo = getMemo();

			text = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "," + author + "," + text;
			
			var newMemo = "";
			if (oldMemo.isEmpty()) {
				newMemo = text;
            }
            else {
                newMemo = oldMemo + "\n" + text;
            }
            Files.writeString(Path.of(filePath), newMemo);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	synchronized public void clearMemo() {
		try {
			Files.deleteIfExists(Path.of(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
