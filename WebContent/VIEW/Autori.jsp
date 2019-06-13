<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% if(session.getAttribute("nome") == null )
	{
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Autori</title>
		<style>
			body {
			  margin: 0;
			  background-image: url('http://localhost:8080/TakeBook/images/libroimmagine.jpg') ;
			  background-position: center;
  			  background-repeat: no-repeat;
  			  background-size: cover;
  			  height: 40%;
			}
			
			button {
			  background-color: #4CAF50;
			  color: white;
			  padding: 14px 20px;
			  margin: 8px 0;
			  border: none;
			  cursor: pointer;
			  width: 100%;
			  margin-left:-10%;
			}
				
			ul {
			  list-style-type: none;
			  margin: 0;
			  padding: 0;
			  width: 15%;
			  background-color: #f1f1f1;
			  position: fixed;
			  height: 60%;
			  overflow: auto;
			}
			
			li a {
			  display: block;
			  color: #000;
			  padding: 8px 16px;
			  text-decoration: none;
			}
			
			li a.active {
			  background-color: #4CAF50;
			  color: white;
			}
			
			li a:hover:not(.active) {
			  background-color: #555;
			  color: white;
			}
			table {
			  font-family: arial, sans-serif;
			  width: 100%;
			  border-radius: 20px 20px 20px 20px ;
			  border: 4px solid #4CAF50;
			  margin-top:15%; 
			  margin-left:-10%;
			}
			
			th {
			  text-align: left;
			  padding: 8px;
			  font-family: bold;
			}
			
			tr:nth-child(even) {
			  background-color: #dddddd;
			}
			.avatar {
				width: 70px;
 				height: 70px;
 				border-radius: 50%;
 				margin-right: 2%;
 				align:center;	
			}
		</style>
	</head>
	<body>
		<ul>
			<li><img align="middle" style="margin-left:33%; margin-top:10%" src="http://localhost:8080/TakeBook/images/img_avatar.png" alt="Avatar" class="avatar"></li>
			<br><br>
			<li><a href="http://localhost:8080/TakeBook/VIEW/areapersonale.jsp">My Area</a></li>
			<li><a href="http://localhost:8080/TakeBook/VIEW/Menu.jsp">Home</a></li>
		    <li><a href="http://localhost:8080/TakeBook/ServletLetueprenotazioni">Le tue prenotazioni</a></li>
		    <li><a class="active" href="http://localhost:8080/TakeBook/ServletAutori">Autori</a></li>
	  		<li><a href="http://localhost:8080/TakeBook/ServletLibri">Libri</a></li>
		    <li><a href="http://localhost:8080/TakeBook/ServletLogout">Logout</a></li>
		</ul>
		<div style="margin-left:35%;margin-right:10%;padding:1px 16px;height:1000px;">		
			<form action="./ServletLibriByAutore">
	         	<table>   
		         	<tr>
		            		<th> Selezione </th>
		            		<th> Nome </th>
		            		<th> Cognome </th>
		            		<th> Nazione </th>
		            </tr>
	            
		            <c:forEach var="autori" items="${listaAutori}">
	            	<tr>
	       			 	<td  style="border-radius: 0px 0px 0px 10px"><input type="radio" name="autore" value="${autori.id_autore}"></td>
	          			<td>${autori.nome}</td>
	          			<td>${autori.cognome}</td>
	          			<td  style="border-radius: 0px 0px 10px 0px">${autori.nazione}</td>
	      			 </tr>
		   			</c:forEach>
		        </table>
		        <button type="submit">Vai alla lista dei libri</button>
	        </form>
        </div>
	</body>
</html>