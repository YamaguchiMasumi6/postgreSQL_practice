<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ListView,java.util.List" %>

<%  
List<ListView> listView = (List<ListView>) request.getAttribute("listView");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧画面</title>
</head>
<body>
	
	<table>
		<tr>
			<th>userId</th>
			<th>氏名</th>
			<th>年齢</th>
		</tr>
		<% for(ListView list: listView){ %>
			<tr>
				<td><%= list.getUserId() %></td>
				<td><%= list.getName() %></td>
				<td><%= list.getAge() %></td>
			</tr>
		<% } %>
	</table>
	
</body>
</html>