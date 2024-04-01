<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dto.Product"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
	<%
		@SuppressWarnings("unchecked")
	    List<Product> productList = (List<Product>) request.getAttribute("list");
		if(productList != null) {
    %>
			<h2>検索結果</h2>
			<table class="prod-list">
			<tr>
				<th></th>
				<th></th>
				<th>商品ID</th>
				<th>商品名</th>
				<th>単価</th>
			</tr>
			<%
				for (Product product : productList) {
			%>
					<tr>
					<td>
						<form action="delete-servlet" method="POST">
    	            		<input type="hidden" name= "id" value="<%=product.getProductId()%>">
            	    		<input type="submit" value="削除">
						</form>
					</td>
					<td>
						<form action="edit.jsp" method="POST">
    	            		<input type="hidden" name= "id" value="<%=product.getProductId()%>">
        	        		<input type="hidden" name= "name" value="<%=product.getProductName()%>">
            	    		<input type="hidden" name= "price" value="<%=product.getPrice()%>">
            	    		<input type="submit" value="編集">
						</form>
					</td>
					<td><%=product.getProductId()%></td>
					<td><%=product.getProductName()%></td>
					<td><%=product.getPrice()%></td>
					</tr>
			<%
				}
			%>
			</table>
    <%
	    } 
    %>

</body>
</html>