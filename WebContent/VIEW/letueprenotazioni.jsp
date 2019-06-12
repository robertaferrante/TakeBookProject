<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% if(session.getAttribute("nome") == null )
	{
	
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
	}
	%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Le tue prenotazioni</title>
		<style>
			body {
				background-image: url('http://localhost:8080/TakeBook/images/libroimmagine.jpg') ;
				margin: 0;
				background-position: center;
		  		background-repeat: no-repeat;
		  		background-size: cover;
		  		height: 40%;
			}
			
			input[type=text] {
			  width: 100%;
			  padding: 12px 20px;
			  margin: 8px 0;
			  display: inline-block;
			  border: 1px solid #ccc;
			  box-sizing: border-box;
			}
			
			button {
			  background-color: #4CAF50;
			  color: white;
			  padding: 14px 20px;
			  margin: 8px 0;
			  border: none;
			  cursor: pointer;
			  width: 100%;
			  margin-left:-10%
			  
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
				  width: 150%;
				  border-radius: 20px 20px 20px 20px ;
				  border: 4px solid #4CAF50;
				  margin-top:15%; 
				  margin-left:-35%
				}
				
				th {
				  text-align: left;
				  padding: 8px;
				  font-family: bold;
				  width: 25%;
				}
				
				tr:nth-child(even) {
				  background-color: #dddddd;
				 
				  
				}
				td{
				width: 25%;
				
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
			<li><a  href="http://localhost:8080/TakeBook/VIEW/Menu.jsp">Home</a></li>
			<li><a class="active" href="http://localhost:8080/TakeBook/ServletLetueprenotazioni">Le tue prenotazioni</a></li>
			<li><a href="http://localhost:8080/TakeBook/ServletAutori">Autori</a></li>
			<li><a href="http://localhost:8080/TakeBook/ServletLibri">Libri</a></li>
			<li><a href="http://localhost:8080/TakeBook/ServletLogout">Logout</a></li>
		</ul>
			
			<div style="margin-left:35%;margin-right:10%;padding:1px 16px;height:1000px;"  >
				<div> <% if(request.getAttribute("restituito") != null && (boolean)request.getAttribute("restituito")==true){
							%>
							<div><h3 style="color:#FF0000;margin-top:15%;"> *La restituzione e avvenuta con successo</h3> </div>
						<%}  %>
				</div>	
				<% if(request.getAttribute("restituito") == null) { %>		
				<form action="./ServletRestituisci">
	         	<table>   
		         	<tr>
		            		<th> Restituisci </th>
		            		<th > Titolo </th>
		            		<th> Anno </th>
		            		<th> ISBN </th>
		            		<th> Categoria </th>
		            		<th> Prenotazione </th>
		            		<th> Riconsegna </th>
		            		<th> Email </th>
		            </tr>
	            
		            <c:forEach var="libro" items="${prenotazioni}">
		            	<tr>
		       			 	<td><input type="radio" name="libro" value="${libro.id_libro}" required></td>
		          			<td>${libro.titolo}</td>
		          			<td>${libro.anno_pubblicazione}</td>
		          			<td>${libro.isbn}</td>
		          			<td>${libro.categoria}</td>
		          			<td>${libro.data_prenotazione}</td>
		          			<td>${libro.data_riconsegna}</td>
		          			<td>${libro.email_utente}</td>
		      			 </tr>
		   			</c:forEach>
		        </table>
		        <button type="submit">Restituisci</button>
	        </form>
        	<%}  %>
        </div> 
	</body>
</html>