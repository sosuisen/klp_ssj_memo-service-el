package com.example;

import java.io.IOException;
import java.util.ArrayList;

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
		var allMemo = model.getMemo();

		// Modelから受け取ったデータをViewで表示しやすいよう加工するのは、Controllerの役割です。
		// ここでは改行コードごとに分割してListに格納します。
		var memoDTOList = new ArrayList<MemoDTO>();
		if (!allMemo.isEmpty()) {
			for (var memo: allMemo.split("\n")) {
				// date,textの順
				var array = memo.split(",");
				if(array.length == 2) {
					// コンストラクタ引数はtext,dateの順
                    memoDTOList.add(new MemoDTO(array[1], array[0]));
                }
			}
		}
		// データをViewに渡すため、リクエストスコープへセットします。
		request.setAttribute("memoDTOList", memoDTOList);
		request.getRequestDispatcher("/WEB-INF/memo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// Webブラウザから送られてきたデータを取得します。
		var memo = request.getParameter("memo");

		var action = request.getParameter("action");
		switch(action) {
			case "add" -> model.addMemo(memo);
			case "clear" -> model.clearMemo();
        }
		
		// この後の処理はdoGetメソッドと同じなので、doGetに任せます。
		doGet(request, response);
	}
}

