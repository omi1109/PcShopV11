<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>商品検索</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h2>商品検索</h2>
    
    <form action="search-servlet" method="POST">

	    【商品名】(部分一致)<br>
	    <input type="text" maxlength="50" name="name"><br>
	    <input type="submit" value="検索">
    </form>

	<br>
	
    <form action="regist.jsp" method="POST">
    	 <input type="submit" value="新規登録" >
    </form>

	<% 
		// 検索時の条件が リクエストスコープに格納されていれば表示
		String cond = (String)request.getAttribute("cond");
		if ((cond != null) && (!cond.equals(""))) {
	%>
			<p class="msg">検索条件：「 <%= cond %> 」</p>
	<%
		} 
	%>

	<div>
	<%@ include file="search-result.jsp" %>
	</div>

</body>
</html>
