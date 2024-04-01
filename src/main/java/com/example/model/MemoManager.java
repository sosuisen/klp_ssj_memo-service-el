package com.example.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MemoManager {
	// JSONファイルの書き込み、読み込みを実行するモデルです。
	
	Gson gson = new Gson();
	
	private String filePath = "c:\\pleiades\\2024-03\\memo.json";
	
	public ArrayList<Memo> getMemoList() {
		try {
			return gson.fromJson(Files.readString(Path.of(filePath)), new TypeToken<ArrayList<Memo>>() {}.getType());
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
			var memo = new Memo(text);
			var memoList = getMemoList();
			memoList.add(memo);
			
            Files.writeString(Path.of(filePath), gson.toJson(memoList));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
