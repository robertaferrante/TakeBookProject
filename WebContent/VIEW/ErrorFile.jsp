<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title></title>
	</head>
	<body>
		<% if(request.getAttribute("err").equals(1)){
			%> Username e password errati <%
			}
			if(request.getAttribute("err").equals(2)){
			%> Utente gi&agrave  presente <%
			}
		%>
		
	</body>
</html>