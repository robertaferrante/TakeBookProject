<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
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
		<title>Menu</title>
		<style>
			body {
			  margin: 0;
			  background-image: url('http://localhost:8080/TakeBook/images/libroimmagine.jpg') ;
			  background-position: center;
  			  background-repeat: no-repeat;
  			  background-size: cover;
  			  height: 40%;
			}
			
			input[type="password"] {
			  width: 70%;
			  padding: 12px 20px;
			  margin: 8px 0;
			  display: inline-block;
			  border: 1px solid #ccc;
			  box-sizing: border-box;
			  text-transform:capitalize; 
			  
			}
			
			button {
			  background-color: #4CAF50;
			  color: white;
			  padding: 14px 20px;
			  margin: 8px 0;
			  border: none;
			  cursor: pointer;
			  width: 30%;
			  align:right;
			  
			}
				
			ul {
			  list-style-type: none;
			  margin-top: -2%;
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
			.avatar {
 				width: 70px;
  				height: 70px;
  				border-radius: 50%;
  				margin-right: 2%;
  				align:center;
			}
			
			table {
			  font-family: arial, sans-serif;
			  width: 60%;
			  height:25%;
			  border-radius: 20px 20px 20px 20px ;
			  border: 4px solid #4CAF50;
			  
			}
			
			.eliminazione {
		 	 background-color: #f44336;
			}
			
		</style>
	</head>
	<body>
		
		<ul>
		  <li><img align="middle" style="margin-left:33%; margin-top:10%" src="http://localhost:8080/TakeBook/images/img_avatar.png" alt="Avatar" class="avatar"></li>
		<br><br>
		  <li><a href="http://localhost:8080/TakeBook/VIEW/areapersonale.jsp"class="active">My Area</a></li>
		  <li><a href="http://localhost:8080/TakeBook/VIEW/Menu.jsp">Home</a></li>
		  <li><a href="http://localhost:8080/TakeBook/ServletLetueprenotazioni">Le tue prenotazioni</a></li>
		  <li><a href="http://localhost:8080/TakeBook/ServletAutori">Autori</a></li>
		  <li><a href="http://localhost:8080/TakeBook/ServletLibri">Libri</a></li>
		  <li><a href="http://localhost:8080/TakeBook/ServletLogout">Logout</a></li>
		</ul>
	  				
	  				
  		<h1 style="margin-left:40%">Ciao <%= request.getSession().getAttribute("nome") %></h1>	
		<div style="margin-left:30%;margin-right:15%;padding:1px 16px;height:1000px;margin-top:4%">
		
		<table >
		  <tr>
		    <th>Nome:</th>
		    <td><%= request.getSession().getAttribute("nome") %></td>
		  </tr>
		  <tr>
		    <th>Cognome:</th>
		    <td><%= request.getSession().getAttribute("cognome") %></td>
		  </tr>
		  <tr>
		    <th>Email:</th>
		    <td><%= request.getSession().getAttribute("email") %></td>
		  </tr>
		  <tr>
		    <th>Indrizzo:</th>
		    <td><%= request.getSession().getAttribute("indirizzo") %></td>
		  </tr>
		   <tr>
		    <th>Citta:</th>
		    <td><%= request.getSession().getAttribute("citta") %></td>
		  </tr>
		</table>
	
				<form action="http://localhost:8080/TakeBook/ServletCambiaPassword" method="post">
					<br>
					<br>
					<br>
					<br>
			    	<b>Nuova password</b><br>
			    	<input type="password" placeholder="Inserisci la tua nuova Password" name="pswnew" required><br>
			    	
					<button  type="submit" >Cambia password</button>
				</form>
				<div> 	
					<% if(request.getAttribute("cambiato") != null && (boolean)request.getAttribute("cambiato")==true){
					%> 
						<div><h3 style="color:#FF0000;">  *La modifica &egrave avvenuta con successo</h3> </div>
					<%} %>
				</div>
				
				
				<form action="http://localhost:8080/TakeBook/ServletEliminaAccount" method="post">
				<button  type="submit" class="eliminazione" name="elimina"style="margin-left:95%; margin-top:-4%" >Elimina Account</button>
				</form>	
		</div>
	</body>
</html>