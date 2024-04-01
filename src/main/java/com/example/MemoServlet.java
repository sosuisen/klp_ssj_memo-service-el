package com.example;

import java.io.IOException;
import java.util.List;

import com.example.model.MemoDTO;
import com.example.model.MemoManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// Controller
public class MemoServlet extends HttpServlet {
	private static final MemoManager model = new MemoManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Modelからメモを取得します。
		var memoList = model.getMemoList();

		// Modelから受け取ったデータをViewで表示しやすいよう加工するのは、Controllerの役割です。
		// 日付をLocalDateTimeオブジェクト（日時の書式は"2024-04-01T21:20:08.3262465"）から
		// 文字列"2024-04-01"に変換したリストを作成します。
		List<MemoDTO> memoRecordList = memoList.stream().map(memo -> 
			new MemoDTO(memo.getText(), memo.getCreatedAt().toString().substring(0, 10))
		).toList();
		
		// データをViewに渡すため、リクエストスコープへセットします。
		request.setAttribute("memoRecordList", memoRecordList);
		request.getRequestDispatcher("/WEB-INF/memo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// Webブラウザから送られてきたデータを取得します。
		var memo = request.getParameter("memo");

		// Modelのメモ追加機能を呼び出します。
		model.addMemo(memo);
		
		// この後の処理はdoGetメソッドと同じなので、doGetに任せます。
		doGet(request, response);
	}
}

