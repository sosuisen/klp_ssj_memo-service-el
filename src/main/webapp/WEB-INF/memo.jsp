<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモアプリ</title>
</head>
<body>
	<h1>メモを入力してください</h1>
	
	<form action="./" method="post">
		<input type="text" name="memo">
		<button>追加</button>
	</form>
	<h2>メモ一覧</h2>
	<ul>
	<c:forEach var="memo" items="${memoRecordList}">
		<c:choose>
			<c:when test="${ memo.text.length() > 7 }">
				<li style="color: red">${ memo.text }(${ memo.date })</li>
			</c:when>
			<c:otherwise>
		        <li>${ memo.text }(${ memo.date })</li>
		    </c:otherwise>
		</c:choose>
	</c:forEach>
	</ul>
</body>
</html>
