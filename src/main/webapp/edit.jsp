<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品情報編集</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
<h2>商品情報編集</h2>
	<% request.setCharacterEncoding("UTF-8"); %>
    <form action="update-servlet" method="POST">
    	【商品ID】<br>
    	<input class="disabled-input" type="text" size="8" 
    			pattern="[a-zA-Z0-9]{1,8}" name="id" 
    			required value="<%=request.getParameter("id") %>" 
    			readonly><br><br>
    	【商品名】<br>
    	<input type="text" size="32" pattern=".{1,32}" 
    			name="name" required 
    			value="<%=request.getParameter("name") %>"><br><br>
    	【単価】<br>
    			<input type="text" size="8" pattern="\d{1,8}" 
    			name="price" required 
    			value="<%=request.getParameter("price") %>"><br><br>
    	<input type="submit" value="登録">
    </form>
    <br><br>
    <a href="search.jsp">検索画面に戻る</a>

</body>
</html>