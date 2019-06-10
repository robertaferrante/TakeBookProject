<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Ricerca</title>
		</head>
		<body>
				
		<form action="./ServletPrenota">
         <table border="3">   
         	<tr>
            		<td> Prenota </td>
            		<td> Titolo </td>
            		<td> Anno </td>
            		<td> ISBN </td>
            		<td> Categoria </td>
            </tr>
            
	            <c:forEach var="libro" items="${listaLibri}">
	            	<tr>
	       			 	<td><input type="radio" name="libro" value="${libro.id_libro}"></td>
	          			<td>${libro.titolo}</td>
	          			<td>${libro.anno_pubblicazione}</td>
	          			<td>${libro.isbn}</td>
	          			<td>${libro.categoria}</td>
	      			 </tr>
	   			</c:forEach>
	
        </table>
        <button type="submit">Prenota</button>
        </form>
        <div> <% if(request.getAttribute("prenotato") != null && (boolean)request.getAttribute("prenotato")==true){
					%>
					<div> <p  style="color:#FF0000" > *La prenotazione e avvenuta con successo</p> </div>
				<%} else if(request.getAttribute("prenotato") != null && (boolean)request.getAttribute("prenotato")==false) {%> 
					<div><p  style="color:#FF0000" > *Questo libro non e al momento disponibile</p></div>
					<%} %>
				
		</body>
	</html>