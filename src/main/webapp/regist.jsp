<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品登録</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
<h2>商品登録</h2>
    <form action="regist-servlet" method="POST">
    	【商品ID】<br>
    	<input type="text" size="8" 
    			pattern="[a-zA-Z0-9]{1,8}" name="id" required><br><br>
    	【商品名】<br>
    	<input type="text" size="32" pattern=".{1,32}" 
    			name="name" required><br><br>
    	【単価】<br>
    	<input type="text" size="8" pattern="\d{1,8}" 
    			name="price" required><br><br>
    	<input type="submit" value="登録">
    </form>
    <br><br>
    <a href="search.jsp">検索画面に戻る</a>
</body>
</html>
