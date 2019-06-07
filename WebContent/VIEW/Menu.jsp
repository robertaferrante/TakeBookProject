<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Menu</title>
	</head>
	<body>
		<h1>Ciao <%= request.getSession().getAttribute("nome") %></h1><br>
		
		
		<div class="menu">
		<ul>
		<li><a href="./VIEW/Menu.jsp">Home</a></li>
		
		<li><a href="C:\Users\Protom\Desktop\Doc\Java\TakeBook\WebContent/index.html">Logout</a></li>
	</ul>
	</div>
	</body>
</html>