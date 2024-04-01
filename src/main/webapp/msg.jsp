<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>メッセージ</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>

	<h2>メッセージ</h2>

	<br>
	<% 
		String msg = (String)request.getAttribute("msg");
		if (msg != null) {
	%>
			<p class="msg"><%= msg %></p>
	<%
		} 
	%>
	<% 
		String errorMsg = (String)request.getAttribute("errorMsg");
		if (errorMsg != null) {
	%>
			<p class="error-msg"><%= errorMsg %></p>
	<%
		} 
	%>

	<br><br>

    <a href="search.jsp">検索画面に戻る</a>

</body>
</html>