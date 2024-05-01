<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモアプリ</title>
</head>
<body>
	<h1>メモを入力してください</h1>
	<form action="./" method="post">
	    名前：<input type="text" name="author">
		メモ：	<input type="text" name="memo">
		<button name="action" value="add">追加</button><br>
		<button name="action" value="clear">クリア</button>
	</form>
	<h2>メモ一覧</h2>
	<ul>
	<c:forEach var="memo" items="${memoDTOList}">
		<li>${ memo.author }: ${ memo.text } (${ memo.date })</li>
	</c:forEach>
	</ul>
</body>
</html>
