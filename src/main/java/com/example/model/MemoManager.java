package com.example.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

public class MemoManager {
	// JSONファイルの書き込み、読み込みを実行するモデルです。
	
	private Jsonb jsonb = JsonbBuilder.create();
	
	private String filePath = "c:\\pleiades\\2024-03\\memo.json";
	
	public ArrayList<Memo> getMemoList() {
		try {
			return jsonb.fromJson(Files.readString(Path.of(filePath)), new ArrayList<Memo>(){}.getClass().getGenericSuperclass());
		} catch (NoSuchFileException e) {
			System.out.println("File not found: " + filePath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<Memo>();
	}
	
	synchronized public void addMemo(String text) {
		try {
			var memo = new Memo(text, LocalDateTime.now());
			var memoList = getMemoList();
			memoList.add(memo);
			
            Files.writeString(Path.of(filePath), jsonb.toJson(memoList));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
